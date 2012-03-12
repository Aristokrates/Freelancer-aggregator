package org.pan.freelancer.observer;

import java.util.List;

import org.pan.linkedin.model.job.LinkedInJobModel;
import org.pan.linkedin.scheduler.LinkedInObserver;

public class LinkedInSiteObserver implements LinkedInObserver {

	@Override
	public void notifyOnNewJobs(List<LinkedInJobModel> jobs) {
		System.out.println("Linkedin notifications on new jobs: " + jobs);
	}

}
