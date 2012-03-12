package org.pan.freelancer4j.model.project;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Wrapper list for freelance project model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectList {
	
	private Integer count;
	
	private List<FreelancerProject> projects = new ArrayList<FreelancerProject>();

	public FreelancerProjectList() {
		super();
	}

	public FreelancerProjectList(Integer count, List<FreelancerProject> projects) {
		super();
		this.count = count;
		this.projects = projects;
	}

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("items")
	public List<FreelancerProject> getProjects() {
		return projects;
	}

	@JsonProperty("items")
	public void setProjects(List<FreelancerProject> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "FreelancerProjectList [count=" + count + ", projects="
				+ projects + "]";
	}
	
}
