package org.pan.freelancer4j.model.project.bids;

import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.freelancer4j.model.FreelancerResponseWrapper;

/**
 * Freelancer bid list wrapper
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerProjectBidWrapper extends FreelancerResponseWrapper {
	
	private FreelancerProjectBidList bidList;

	public FreelancerProjectBidWrapper() {
		super();
	}

	public FreelancerProjectBidWrapper(FreelancerProjectBidList bidList) {
		super();
		this.bidList = bidList;
	}

	@JsonProperty("json-result")
	public FreelancerProjectBidList getBidList() {
		return bidList;
	}

	@JsonProperty("json-result")
	public void setBidList(FreelancerProjectBidList bidList) {
		this.bidList = bidList;
	}

	@Override
	public String toString() {
		return "FreelancerProjectBidWrapper [bidList=" + bidList + "]";
	}	
}
