package org.pan.freelancer4j.model.project.bids;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Freelancer project bid list
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectBidList {
	
	private Integer count;
	
	private List<FreelancerProjectBid> freelancerProjectBids = new ArrayList<FreelancerProjectBid>();
	
	public FreelancerProjectBidList() {
		super();
	}

	public FreelancerProjectBidList(Integer count,
			List<FreelancerProjectBid> freelancerProjectBids) {
		super();
		this.count = count;
		this.freelancerProjectBids = freelancerProjectBids;
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
	public List<FreelancerProjectBid> getFreelancerProjectBids() {
		return freelancerProjectBids;
	}

	@JsonProperty("items")
	public void setFreelancerProjectBids(
			List<FreelancerProjectBid> freelancerProjectBids) {
		this.freelancerProjectBids = freelancerProjectBids;
	}

	@Override
	public String toString() {
		return "FreelancerProjectBidList [count=" + count
				+ ", freelancerProjectBids=" + freelancerProjectBids + "]";
	}
}
