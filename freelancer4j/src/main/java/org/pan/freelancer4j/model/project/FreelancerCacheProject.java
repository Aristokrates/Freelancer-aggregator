package org.pan.freelancer4j.model.project;

import org.pan.freelancer4j.model.FreelancerProjectState;

/**
 * Project cache model stored in project cache
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerCacheProject {
	
	private Integer projectId;
	
	private FreelancerProjectState projectState;

	public FreelancerCacheProject(Integer projectId, FreelancerProjectState projectState) {
		super();
		this.projectId = projectId;
		this.projectState = projectState;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public FreelancerProjectState getProjectState() {
		return projectState;
	}

	public void setProjectState(FreelancerProjectState projectState) {
		this.projectState = projectState;
	}

	@Override
	public String toString() {
		return "FreelancerCacheProjectModel [projectId=" + projectId
				+ ", projectState=" + projectState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result
				+ ((projectState == null) ? 0 : projectState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreelancerCacheProject other = (FreelancerCacheProject) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (projectState == null) {
			if (other.projectState != null)
				return false;
		} else if (!projectState.equals(other.projectState))
			return false;
		return true;
	}
}
