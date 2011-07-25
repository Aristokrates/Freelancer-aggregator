package org.pan.freelancer4j.scheduler.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.pan.freelancer4j.client.FreelancerClientWrapper;
import org.pan.freelancer4j.model.project.FreelancerCacheProject;
import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.scheduler.FreelancerObserver;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * Freelance project trigger job
 * <p>
 * Freelancer project trigger is triggered from freelancer scheduler. 
 * It performs pulling of project and check if those projects exist in project cache.
 * If exist it checks for project status changes and notifies the observer if there is status change.
 * If not it notifies the observer for new projects
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerProjectJob implements StatefulJob {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		FreelancerObserver freelanceObserver =  (FreelancerObserver) dataMap.get("observer");
		FreelancerClientWrapper client = (FreelancerClientWrapper) dataMap.get("client");
		ProjectSearchCriteria searchCriteria = (ProjectSearchCriteria) dataMap.get("criteria");
		Map<Integer, FreelancerCacheProject> projectCache = (Map<Integer, FreelancerCacheProject>) dataMap.get("projectCache");
		
		System.out.println("Freelancer project pulling initiated: " + new Date());
		List<FreelancerProject> newProjectList;
		List<FreelancerCacheProject> changeStateProjectList;
		ProjectSearchCriteria copySearchCriteria;
		
		
		try {
			copySearchCriteria = searchCriteria.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
		
		while (true) {	
			
			List<FreelancerProject> projects = client.searchProjectsByCriteria(copySearchCriteria).getProjects();
					
			newProjectList = new ArrayList<FreelancerProject>();	
			changeStateProjectList = new ArrayList<FreelancerCacheProject>();	
			
			for (FreelancerProject project : projects) {
				FreelancerCacheProject projectModel = project.toFreelancerCacheProject();
				FreelancerCacheProject cachedProject = projectCache.get(project.getId());
				if (cachedProject != null) {
					if (!cachedProject.getProjectState().equals(projectModel.getProjectState())) {
						changeStateProjectList.add(projectModel);
						projectCache.put(project.getId(), projectModel);
					}
				} else {
					newProjectList.add(project);
					projectCache.put(project.getId(), projectModel);
				}
			}

			if (!newProjectList.isEmpty()) {
				freelanceObserver.notifyOnNewProject(newProjectList);
			}
			if (!changeStateProjectList.isEmpty()) {
				freelanceObserver.notifyOnProjectStatusChange(changeStateProjectList);
			}

			if (projects.size() < copySearchCriteria.getCount().intValue()) {
				break;
			}	
			copySearchCriteria.setPage(copySearchCriteria.getPage() + 1);
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		newProjectList = null;
		changeStateProjectList = null;
		copySearchCriteria = null;
	}
}
