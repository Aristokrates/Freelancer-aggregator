package org.pan.freelancer4j.model.project;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.freelancer4j.model.FreelancerResponseWrapper;

/**
 *  Wrapper model for freelancer project list
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectWrapper extends FreelancerResponseWrapper {

	private FreelancerProjectList projectList;

	public FreelancerProjectWrapper() {
		super();
	}
	
	public FreelancerProjectWrapper(FreelancerProjectList projectList) {
		super();
		this.projectList = projectList;
	}
	
	@JsonProperty("projects")
	public FreelancerProjectList getProjectList() {
		return projectList;
	}
	
	@JsonProperty("projects")
	public void setProjectList(FreelancerProjectList projectList) {
		this.projectList = projectList;
	}

	@Override
	public String toString() {
		return "FreelancerProjectWrapper [projectList=" + projectList + "]";
	}
}
