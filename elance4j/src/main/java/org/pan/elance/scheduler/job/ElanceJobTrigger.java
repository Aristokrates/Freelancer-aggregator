package org.pan.elance.scheduler.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pan.elance.client.ElanceClientWrapper;
import org.pan.elance.model.job.ElanceJobModel;
import org.pan.elance.scheduler.ElanceObserver;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * Elance job trigger
 * <p>
 * Elance job trigger is triggered from scheduler. 
 * It performs pulling of jobs and check if those job exist in job cache.
 * If not it notifies the elance observer for new projects
 * 
 * @author Pance.Isajeski
 *
 */
public class ElanceJobTrigger implements StatefulJob {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		ElanceObserver elanceObserver =  (ElanceObserver) dataMap.get("observer");
		ElanceClientWrapper client = (ElanceClientWrapper) dataMap.get("client");
		ElanceJobSearchCriteria searchCriteria = (ElanceJobSearchCriteria) dataMap.get("criteria");
		List<String> jobCache = (List<String>) dataMap.get("jobCache");
		
		System.out.println("Initiating elance job pulling: " + new Date());
		List<ElanceJobModel> newJobList;
		ElanceJobSearchCriteria copySearchCriteria;		
		
		try {
			copySearchCriteria = searchCriteria.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
		
		while (true) {	
			
			List<ElanceJobModel> projects = new ArrayList<ElanceJobModel>(client.searchJobsByCriteria(copySearchCriteria).getJobMap().values());
					
			newJobList = new ArrayList<ElanceJobModel>();	
			
			for (ElanceJobModel project : projects) {
				if (!jobCache.contains(project.getJobId())) {
					newJobList.add(project);
					jobCache.add(project.getJobId());
				}
			}

			if (!newJobList.isEmpty()) {
				elanceObserver.notifyOnNewJobs(newJobList);
			}

			if (projects.size() < 25) {
				break;
			}	
			copySearchCriteria.setPage(copySearchCriteria.getPage() + 1);
			
			try {
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		newJobList = null;
		copySearchCriteria = null;		
	}

}
