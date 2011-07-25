package org.pan.odesk.scheduler.job;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.pan.odesk.client.oDeskClientWrapper;
import org.pan.odesk.model.job.oDeskCacheJob;
import org.pan.odesk.model.job.oDeskJobModel;
import org.pan.odesk.scheduler.oDeskObserver;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * oDesk job trigger
 * <p>
 * oDesk job trigger is triggered from oDSesk scheduler. 
 * It performs pulling of jobs and check if those job exist in job cache.
 * If exist it checks for job status change and notifies observer if there is any change
 * If not it notifies the observer for new projects
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskJobTrigger implements StatefulJob {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		oDeskObserver oDeskObserver =  (oDeskObserver) dataMap.get("observer");
		oDeskClientWrapper client = (oDeskClientWrapper) dataMap.get("client");
		oDeskJobSearchCriteria searchCriteria = (oDeskJobSearchCriteria) dataMap.get("criteria");
		Map<String, oDeskCacheJob> jobCache = (Map<String, oDeskCacheJob>) dataMap.get("jobCache");
		
		DateFormat searchDateFormatter = new SimpleDateFormat("MM-dd-yyyy");
		DateFormat retrieveDateFormatter = new SimpleDateFormat("MMMM dd, yyyy");
		
		System.out.println("Start oDesk job pulling at: " + new Date());
		Date checkpointDate = null;
		Object dateObject = dataMap.get("checkpointDate");
		if (dateObject != null) {
			checkpointDate = (Date) dateObject;
			searchCriteria.setDatePosted(searchDateFormatter.format(checkpointDate));
		}
		
		List<oDeskJobModel> newJobList;
		List<oDeskCacheJob> changeStateJobList;
		oDeskJobSearchCriteria copySearchCriteria;
		
		try {
			copySearchCriteria = searchCriteria.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException();
		}
		
		while (true) {	
			
			List<oDeskJobModel> jobs = client.searchJobsByCriteria(copySearchCriteria);
					
			newJobList = new ArrayList<oDeskJobModel>();	
			changeStateJobList = new ArrayList<oDeskCacheJob>();	
			
			for (oDeskJobModel job : jobs) {
				
				//optimization 
				Date newDate;
				try {
					newDate = retrieveDateFormatter.parse(job.getDatePosted());
				} catch (ParseException e) {
					throw new RuntimeException();
				}
				
				if (checkpointDate == null) {
					checkpointDate = newDate;
				} else {
					if (newDate.after(checkpointDate)) {
						checkpointDate = newDate;
					}
				}
				
				//cache checking
				oDeskCacheJob cacheModel = job.toCacheJob();
				oDeskCacheJob cachedProject = jobCache.get(job.getIdentifier());
				if (cachedProject != null) {
					if (!cachedProject.getActive().equals(cacheModel.getActive())) {
						changeStateJobList.add(cacheModel);
						jobCache.put(job.getIdentifier(), cacheModel);
					}
				} else {
					newJobList.add(job);
					jobCache.put(job.getIdentifier(), cacheModel);
				}
			}

			if (!newJobList.isEmpty()) {
				oDeskObserver.notifyOnNewJobs(newJobList);
			}
			if (!changeStateJobList.isEmpty()) {
				oDeskObserver.notifyOnJobStatusChange(changeStateJobList);
			}

			if (jobs.size() < copySearchCriteria.getCount() && newJobList.isEmpty() && changeStateJobList.isEmpty()) {
				System.out.println("Job size pulled: " + jobs.size() + " " + "Nothing to notify. Exiting...");
				break;
			}	
			copySearchCriteria.setPage(copySearchCriteria.getPage() + 1);
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				throw new RuntimeException();
			}
		}
		
		System.out.println("Checkpoint date: " + checkpointDate);
		dataMap.put("checkpointDate", checkpointDate);
		
		newJobList = null;
		changeStateJobList = null;
		copySearchCriteria = null;
		
	}

}
