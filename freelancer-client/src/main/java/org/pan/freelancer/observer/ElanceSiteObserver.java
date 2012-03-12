package org.pan.freelancer.observer;

import java.util.List;

import org.pan.elance.model.job.ElanceJobModel;
import org.pan.elance.scheduler.ElanceObserver;

/**
 *	Elance Observer implementation
 * 
 * @author Pance.Isajeski
 *
 */
public class ElanceSiteObserver implements ElanceObserver {

	@Override
	public void notifyOnNewJobs(List<ElanceJobModel> jobs) {
		
		System.out.println("Elance notification on new jobs: " + jobs);
		
	}

}
