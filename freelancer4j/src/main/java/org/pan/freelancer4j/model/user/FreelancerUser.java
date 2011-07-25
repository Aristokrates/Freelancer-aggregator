package org.pan.freelancer4j.model.user;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Freelancer user to Java bean mapping model
 * <p>
 * Maps the freelancer user json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerUser {
	
	private String username;
	
	private Integer userId;
	
	private String company;
	
	private FreelancerUserAddress address;
	
	private Integer averagePricing;

	public FreelancerUser() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty(value="userid")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty(value="userid")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public FreelancerUserAddress getAddress() {
		return address;
	}

	public void setAddress(FreelancerUserAddress address) {
		this.address = address;
	}

	@JsonProperty(value="averagepricing")
	public Integer getAveragePricing() {
		return averagePricing;
	}

	@JsonProperty(value="averagepricing")
	public void setAveragePricing(Integer averagePricing) {
		this.averagePricing = averagePricing;
	}

	@Override
	public String toString() {
		return "FreelancerUser [address=" + address + ", averagePricing="
				+ averagePricing + ", company=" + company + ", userId="
				+ userId + ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((averagePricing == null) ? 0 : averagePricing.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		FreelancerUser other = (FreelancerUser) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (averagePricing == null) {
			if (other.averagePricing != null)
				return false;
		} else if (!averagePricing.equals(other.averagePricing))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
