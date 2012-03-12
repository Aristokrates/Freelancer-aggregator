package org.pan.freelancer4j.model.project.details;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.freelancer4j.model.FreelancerResponseWrapper;

/**
 * Wrapper for freelancer project details
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectDetailsWrapper extends FreelancerResponseWrapper {
	
	private FreelancerProjectDetails projectDetails;

	public FreelancerProjectDetailsWrapper() {
		super();
	}

	@JsonProperty("json-result")
	public FreelancerProjectDetails getProjectDetails() {
		return projectDetails;
	}

	@JsonProperty("json-result")
	public void setProjectDetails(FreelancerProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Override
	public String toString() {
		return "FreelancerProjectDetailsWrapper [projectDetails="
				+ projectDetails + "]";
	}
}
