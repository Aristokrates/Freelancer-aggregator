package org.pan.freelancer4j.model;

/**
 * Project state on freelancer.com and its String representation
 * 
 * @author Pance.Isajeski
 *
 */
public enum FreelancerProjectState {
	
	ACTIVE("A"),
	FROZEN("F"),
	CLOSED("C"),
	PENDIND("P"),
	REJECT("R"),
	DRAFT("D");
	
	private String projectStateIdentifier;
	
	private FreelancerProjectState(String projectStatus) {
		this.projectStateIdentifier = projectStatus;
	}
	
	public String getProjectStateIdentifier() {
		return projectStateIdentifier;
	}

	public static FreelancerProjectState getProjectStateByIdentifier(String projectStateIdentifier) {
		
		if (projectStateIdentifier == null) {
			return null;
		}
		
		for (FreelancerProjectState stat : FreelancerProjectState.values()) {
			if (stat.getProjectStateIdentifier().equals(projectStateIdentifier)) {
				return stat;
			}
		}
		return null;
	}

}
