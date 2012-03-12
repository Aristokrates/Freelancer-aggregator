package org.pan.odesk.search;

import java.util.HashMap;

/**
 * oDesk job criteria
 * <p>
 * Criteria for searching jobs on oDesk
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskJobSearchCriteria implements Cloneable {
	
	private String openingData;
	
	private String jobCategory;
	
	private String secondCategory;
	
	private String adjustedScore;
	
	private Integer minBudget;
	
	private Integer maxBudget;
	
	private String jobType;
	
	private Integer hoursPerWeek;
	
	private String engagementDuraton;
	
	private String datePosted;
	
	private String statusForSearching;
	
	private String totalBilled;
	
	private String prefGroup;
	
	private String titlesOnly;
	
	private Integer page = 0;
	
	private Integer count = 200;
	
	private String sort;

	public oDeskJobSearchCriteria() {
		super();
	}

	public String getOpeningData() {
		return openingData;
	}

	public void setOpeningData(String openingData) {
		this.openingData = openingData;
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

	public Integer getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(Integer minBudget) {
		this.minBudget = minBudget;
	}

	public Integer getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(Integer maxBudget) {
		this.maxBudget = maxBudget;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Integer getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(Integer hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getEngagementDuraton() {
		return engagementDuraton;
	}

	public void setEngagementDuraton(String engagementDuraton) {
		this.engagementDuraton = engagementDuraton;
	}

	public String getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}

	public String getStatusForSearching() {
		return statusForSearching;
	}

	public void setStatusForSearching(String statusForSearching) {
		this.statusForSearching = statusForSearching;
	}

	public String getTotalBilled() {
		return totalBilled;
	}

	public void setTotalBilled(String totalBilled) {
		this.totalBilled = totalBilled;
	}

	public String getPrefGroup() {
		return prefGroup;
	}

	public void setPrefGroup(String prefGroup) {
		this.prefGroup = prefGroup;
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
		
		if (getOpeningData() != null) {
			map.put("q", getOpeningData());
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
		
		if (getMinBudget() != null) {
			map.put("min", getMinBudget().toString());
		}
		
		if (getMaxBudget() != null) {
			map.put("max", getMaxBudget().toString());
		}
		
		if (getJobType() != null) {
			map.put("t", getJobType());
		}
		
		if (getHoursPerWeek() != null) {
			map.put("wl", getHoursPerWeek().toString());
		}
		
		if (getEngagementDuraton() != null) {
			map.put("dur", getEngagementDuraton());
		}
		
		if (getDatePosted() != null) {
			map.put("dp", getDatePosted());
		}
		
		if (getStatusForSearching() != null) {
			map.put("st", getStatusForSearching());
		}
		
		if (getTotalBilled() != null) {
			map.put("tba", getTotalBilled());
		}
		
		if (getPrefGroup()  != null) {
			map.put("gr", getPrefGroup());
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

	@Override
	public oDeskJobSearchCriteria clone() throws CloneNotSupportedException {
		return (oDeskJobSearchCriteria) super.clone();
	}
	
	
}
