package org.pan.odesk.search;

import java.util.HashMap;

/**
 * oDesk provider search criteria
 * <p>
 * Criteria for searching providers on oDesk
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskProviderSearchCriteria {
	
	private String profileData;
	
	private String jobCategory;
	
	private String secondCategory;
	
	private String adjustedScore;
	
	private String isRecent;
	
	private String minHourlyRate;
	
	private String maxHourlyRate;
	
	private String countryRegion;
	
	private String providerType;
	
	private String titlesOnly;
	
	private Integer page = 0;
	
	private Integer count = 200;
	
	private String sort;

	public oDeskProviderSearchCriteria() {
		super();
	}

	public String getProfileData() {
		return profileData;
	}

	public void setProfileData(String profileData) {
		this.profileData = profileData;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}

	public String getAdjustedScore() {
		return adjustedScore;
	}

	public void setAdjustedScore(String adjustedScore) {
		this.adjustedScore = adjustedScore;
	}

	public String getIsRecent() {
		return isRecent;
	}

	public void setIsRecent(String isRecent) {
		this.isRecent = isRecent;
	}

	public String getMinHourlyRate() {
		return minHourlyRate;
	}

	public void setMinHourlyRate(String minHourlyRate) {
		this.minHourlyRate = minHourlyRate;
	}

	public String getMaxHourlyRate() {
		return maxHourlyRate;
	}

	public void setMaxHourlyRate(String maxHourlyRate) {
		this.maxHourlyRate = maxHourlyRate;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public String getTitlesOnly() {
		return titlesOnly;
	}

	public void setTitlesOnly(String titlesOnly) {
		this.titlesOnly = titlesOnly;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public HashMap<String, String> buildParameterMap() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if (getProfileData() != null) {
			map.put("q", getProfileData());
		}
		
		if (getJobCategory() != null) {
			map.put("c1", getJobCategory());
		}
		
		if (getSecondCategory() != null) {
			map.put("c2", getSecondCategory());
		}
		
		if (getAdjustedScore() != null) {
			map.put("fb", getAdjustedScore());
		}
		
		if (getIsRecent() != null) {
			map.put("ir", getIsRecent());
		}
		
		if (getMinHourlyRate() != null) {
			map.put("min", getMinHourlyRate());
		}
		
		if (getMaxHourlyRate() != null) {
			map.put("max", getMaxHourlyRate());
		}
		
		if (getCountryRegion() != null) {
			map.put("loc", getCountryRegion());
		}
		
		if (getProviderType() != null) {
			map.put("pt", getProviderType());
		}
		
		if (getTitlesOnly() != null) {
			map.put("to", getTitlesOnly());
		}
		
		Integer count = 200;
		if (getCount() != null && !getCount().equals(200)) {
			count = getCount();
		}

		Integer page = 0;
		if (getPage() != null && !getPage().equals(0)) {
			page = getPage();
		}
		
		map.put("page", page*count + ";" + count);
		
		if (getSort() != null) {
			map.put("sort", getSort());
		}
		
		return map;
	}
}
