package org.pan.linkedin.scheduler.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pan.linkedin.client.LinkedInClientWrapper;
import org.pan.linkedin.model.job.LinkedInJobModel;
import org.pan.linkedin.scheduler.LinkedInObserver;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

public class LinkedInJobTrigger implements StatefulJob {
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		LinkedInObserver linkedinObserver =  (LinkedInObserver) dataMap.get("observer");
		LinkedInClientWrapper client = (LinkedInClientWrapper) dataMap.get("client");
		LinkedInJobSearchCriteria searchCriteria = (LinkedInJobSearchCriteria) dataMap.get("criteria");
		List<String> jobCache = (List<String>) dataMap.get("jobCache");
		
		System.out.println("LinkedIn pulling started: " + new Date());
		List<LinkedInJobModel> newJobList;
		LinkedInJobSearchCriteria copySearchCriteria;		
		
		try {
			copySearchCriteria = searchCriteria.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
		
		while (true) {	
			
			List<LinkedInJobModel> projects = client.searchJobsByCriteria(copySearchCriteria).getLinkedinJobs();
					
			newJobList = new ArrayList<LinkedInJobModel>();	
			
			for (LinkedInJobModel project : projects) {
				if (!jobCache.contains(project.getJobId())) {
					newJobList.add(project);
					jobCache.add(project.getJobId());
				}
			}

			if (!newJobList.isEmpty()) {
				linkedinObserver.notifyOnNewJobs(newJobList);
			}

			if (projects.size() < copySearchCriteria.getCount()) {
				break;
			}	
			copySearchCriteria.setStart(copySearchCriteria.getStart() + copySearchCriteria.getCount());
			
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		newJobList = null;
		copySearchCriteria = null;		
	}


}
