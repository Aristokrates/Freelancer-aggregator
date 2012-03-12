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

public class LinkedInPeopleSearchCriteria {
	
	private String keywords;
	
	private String firstName;
	
	private String lastName;
	
	private String companyName;
	
	private String currentCompany;
	
	private String title;
	
	private String currentTitle;
	
	private String postalCode;
	
	private String distance;
	
	private Integer start;
	
	private Integer count;
	
	private List<String> countryCodes = new ArrayList<String>();
	
	private List<String> industries;

	public LinkedInPeopleSearchCriteria() {
		super();
		
		//default values
		this.start = 0;
		this.count = 25;
		this.industries = Arrays.asList(IndustryCodes.Computer_Software, IndustryCodes.Computer_and_Network_Security, IndustryCodes.Computer_Networking);
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
	}

	public List<String> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<String> countryCodes) {
		this.countryCodes = countryCodes;
	}
	
	public void addCountryCode(String countryCode) {
		getCountryCodes().add(countryCode);
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
		
		if (getCurrentCompany() != null) {
			map.put(SearchParameter.CURRENT_COMPANY, getCurrentCompany());
		}
		
		if (getTitle() != null) {
			map.put(SearchParameter.TITLE, getTitle());
		}
		
		if (getCurrentTitle() != null) {
			map.put(SearchParameter.CURRENT_TITLE, getCurrentTitle());
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
		 
		 for (String industryCode : getIndustries()) {
			 facets.add(new Parameter<FacetType, String>(FacetType.INDUSTRY, industryCode));
		 }
		 
		 
		 for (String contryCode : getCountryCodes()) {
			 facets.add(new Parameter<FacetType, String>(FacetType.LOCATION, contryCode));
		 }
		 
		 return facets;
	}
	
	

}
