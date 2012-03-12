package org.pan.freelancer4j.model.project.bids;

/**
 * Project bid cache model used for storing bids in cache
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerCacheProjectBid {
	
	private Integer providerUserId;
	
	private Integer bidAmmount;
	
	private Integer period;

	public FreelancerCacheProjectBid(Integer providerUserId, Integer bidAmmount, Integer period) {
		
		super();
		this.providerUserId = providerUserId;
		this.bidAmmount = bidAmmount;
		this.period = period;
	}

	public Integer getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(Integer providerUserId) {
		this.providerUserId = providerUserId;
	}

	public Integer getBidAmmount() {
		return bidAmmount;
	}

	public void setBidAmmount(Integer bidAmmount) {
		this.bidAmmount = bidAmmount;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "FreelancerCacheBidModel [bidAmmount=" + bidAmmount
				+ ", period=" + period + ", providerUserId=" + providerUserId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bidAmmount == null) ? 0 : bidAmmount.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result
				+ ((providerUserId == null) ? 0 : providerUserId.hashCode());
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
		FreelancerCacheProjectBid other = (FreelancerCacheProjectBid) obj;
		if (bidAmmount == null) {
			if (other.bidAmmount != null)
				return false;
		} else if (!bidAmmount.equals(other.bidAmmount))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (providerUserId == null) {
			if (other.providerUserId != null)
				return false;
		} else if (!providerUserId.equals(other.providerUserId))
			return false;
		return true;
	}
}
