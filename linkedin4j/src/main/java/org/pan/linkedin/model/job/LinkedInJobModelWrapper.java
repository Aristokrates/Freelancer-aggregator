package org.pan.linkedin.model.job;

import java.util.ArrayList;
import java.util.List;

public class LinkedInJobModelWrapper {
	
	private Integer totalResults;
	
	private List<LinkedInJobModel> linkedinJobs = new ArrayList<LinkedInJobModel>();

	public LinkedInJobModelWrapper() {
		super();
	}

	public LinkedInJobModelWrapper(Integer totalResults,
			List<LinkedInJobModel> linkedinJobs) {
		super();
		this.totalResults = totalResults;
		this.linkedinJobs = linkedinJobs;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public List<LinkedInJobModel> getLinkedinJobs() {
		return linkedinJobs;
	}

	public void setLinkedinJobs(List<LinkedInJobModel> linkedinJobs) {
		this.linkedinJobs = linkedinJobs;
	}
}
