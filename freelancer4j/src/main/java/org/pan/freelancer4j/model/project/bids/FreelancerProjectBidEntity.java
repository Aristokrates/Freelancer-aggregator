package org.pan.freelancer4j.model.project.bids;

/**
 * Freelancer bid entity used in notifying observer for new bid
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerProjectBidEntity {
	
	private Integer projectId;
	
	private FreelancerProjectBid projectBid;
	
	public FreelancerProjectBidEntity() {
		super();
	}

	public FreelancerProjectBidEntity(Integer projectId, FreelancerProjectBid projectBid) {
		super();
		this.projectId = projectId;
		this.projectBid = projectBid;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public FreelancerProjectBid getProjectBid() {
		return projectBid;
	}

	public void setProjectBid(FreelancerProjectBid projectBid) {
		this.projectBid = projectBid;
	}

	@Override
	public String toString() {
		return "FreelancerProjectBidEntity [projectId=" + projectId
				+ ", projectBid=" + projectBid + "]";
	}
}
