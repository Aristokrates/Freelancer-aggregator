package org.pan.linkedin.scheduler;

import java.util.List;

import org.pan.linkedin.model.job.LinkedInJobModel;

public interface LinkedInObserver {
	
	void notifyOnNewJobs(List<LinkedInJobModel> jobs);


}
