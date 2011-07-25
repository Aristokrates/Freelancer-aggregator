package org.pan.freelancer4j.search;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Freelancer users search criteria
 * <p>
 * Criteria for searching freelancers(users) on Freelancer.com
 * 
 * @author Pance.Isajeski
 *
 */
public class UserSearchCriteria {
	
	private String username;
	
	private String expertiseCsvs;
	
	private String countryCsvs;
	
	private Integer rating;
	
	private Integer count;
	
	private Integer page;
	 
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExpertiseCsvs() {
		return expertiseCsvs;
	}

	public void setExpertiseCsvs(String expertiseCsvs) {
		this.expertiseCsvs = expertiseCsvs;
	}

	public String getCountryCsvs() {
		return countryCsvs;
	}

	public void setCountryCsvs(String countryCsvs) {
		this.countryCsvs = countryCsvs;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Set<Entry<String, Object>> buildParameterSetEntry() {
		
		Set<Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		
		if (getUsername() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("username", getUsername()));
		}
		if (getExpertiseCsvs() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("expertise_csv", getExpertiseCsvs()));
		}
		if (getCountryCsvs() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("country_csv", getCountryCsvs()));
		}
		if (getRating() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("rating", getRating()));
		}
		if (getCount() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("count", getCount()));
		}
		if (getPage() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("page", getPage()));
		}
		return params;
	}

}
