package org.pan.linkedin.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.constant.IndustryCodes;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.FacetType;

public class LinkedInJobSearchCriteria implements Cloneable {
	
	private String keywords;
	
	private String companyName;
	
	private String jobTitle;
	
	private String countryCode;
	
	private String postalCode;
	
	private String distance;
	
	private List<DatePosted> datePosted ;
	
	private List<String> industries;
	
	private Integer start;
	
	private Integer count;

	public LinkedInJobSearchCriteria() {
		
		super();
		
		//default values
		this.start = 0;
		this.count = 20;
		this.datePosted = Arrays.asList(DatePosted.DAY_AGO_1);		
		this.industries = Arrays.asList(IndustryCodes.Computer_Software, IndustryCodes.Computer_and_Network_Security, IndustryCodes.Computer_Networking);
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public List<DatePosted> getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(List<DatePosted> datePosted) {
		this.datePosted = datePosted;
	}
	
	public void addDatePosted(DatePosted dp) {
		getDatePosted().add(dp);
	}

	public List<String> getIndustries() {
		return industries;
	}

	public void setIndustries(List<String> industries) {
		this.industries = industries;
	}
	
	public void addIndustry(String industry) {
		getIndustries().add(industry);
	}

	public Map<SearchParameter, String> buildSearchParameterMap() {
		
		Map<SearchParameter, String> map = new HashMap<SearchParameter, String>();
		if (getKeywords() != null) {
			map.put(SearchParameter.KEYWORDS, getKeywords());
		}
		
		if (getCompanyName() != null) {
			map.put(SearchParameter.COMPANY_NAME, getCompanyName());
		}
		
		if (getJobTitle() != null) {
			map.put(SearchParameter.JOB_TITLE, getJobTitle());
		}
		
		if (getCountryCode() != null) {
			map.put(SearchParameter.COUNTRY_CODE, getCountryCode());
		}
		
		if (getPostalCode() != null) {
			map.put(SearchParameter.POSTAL_CODE, getPostalCode());
		}
		
		if (getDistance() != null) {
			map.put(SearchParameter.DISTANCE, getDistance());
		}
		
		return map;
	}
	
	public List<Parameter<FacetType, String>> buildSearchFacets() {
		
		 List<Parameter<FacetType, String>> facets = new ArrayList<Parameter<FacetType,String>>();
		 
		 for (DatePosted datePosted : getDatePosted()) {
			 facets.add(new Parameter<FacetType, String>(FacetType.DATE_POSTED, datePosted.getValue()));
		 }
		 
		 for (String industryCode : getIndustries()) {
			 facets.add(new Parameter<FacetType, String>(FacetType.INDUSTRY, industryCode));
		 }
		 
		 return facets;
	}

	@Override
	public LinkedInJobSearchCriteria clone() throws CloneNotSupportedException {
		return (LinkedInJobSearchCriteria) super.clone();
	}
	
	
	
}
