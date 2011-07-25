package org.pan.freelancer4j.model.user;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Freelancer user address to Java bean mapping model
 * <p>
 * Maps the freelancer user address json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerUserAddress {

	private String country;
	
	private String city;
	

	public FreelancerUserAddress() {
		super();
	}

	public FreelancerUserAddress(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}
	
	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}
	
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "FreelancerUserAddress [city=" + city + ", country=" + country
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		FreelancerUserAddress other = (FreelancerUserAddress) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		return true;
	}
}
