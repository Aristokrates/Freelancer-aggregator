package org.pan.freelancer.observer;

import java.util.List;

import org.pan.odesk.model.job.oDeskCacheJob;
import org.pan.odesk.model.job.oDeskJobModel;
import org.pan.odesk.scheduler.oDeskObserver;

/**
 * oDesk observer implementation
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskSiteObserver implements oDeskObserver {

	@Override
	public void notifyOnJobStatusChange(List<oDeskCacheJob> changeStateJobList) {
		System.out.println("oDesk notification on job status change: " + changeStateJobList);
		
	}

	@Override
	public void notifyOnNewJobs(List<oDeskJobModel> jobs) {
		System.out.println("oDesk notification on new jobs: " + jobs);
		
	}

}
