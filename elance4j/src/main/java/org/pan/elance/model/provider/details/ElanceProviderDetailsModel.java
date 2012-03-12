package org.pan.elance.model.provider.details;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceProviderDetailsModel {
	
	@JsonProperty
	private Integer userId;
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private String businessName;
	
	@JsonProperty
	private String tagLine;
	
	@JsonProperty
	private Integer hourlyRate;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private String state;
	
	@JsonProperty
	private String country;
	
	@JsonProperty
	private Integer elanceLevel;
	
	@JsonProperty
	private String category;
	
	@JsonProperty
	private String providerProfileURL;
	
	@JsonProperty
	private Integer earnings;
	
	@JsonProperty
	private Integer clients;
	
	@JsonProperty
	private Integer jobs;
	
	@JsonProperty
	private Map<Integer, ElanceLatestJobDataModel> latestJobs;
	
	@JsonProperty
	private Map<Integer, ElanceSkillDataModel> skills;

	public ElanceProviderDetailsModel() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public Integer getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Integer hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getElanceLevel() {
		return elanceLevel;
	}

	public void setElanceLevel(Integer elanceLevel) {
		this.elanceLevel = elanceLevel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProviderProfileURL() {
		return providerProfileURL;
	}

	public void setProviderProfileURL(String providerProfileURL) {
		this.providerProfileURL = providerProfileURL;
	}

	public Integer getEarnings() {
		return earnings;
	}

	public void setEarnings(Integer earnings) {
		this.earnings = earnings;
	}

	public Integer getClients() {
		return clients;
	}

	public void setClients(Integer clients) {
		this.clients = clients;
	}

	public Integer getJobs() {
		return jobs;
	}

	public void setJobs(Integer jobs) {
		this.jobs = jobs;
	}

	public Map<Integer, ElanceLatestJobDataModel> getLatestJobs() {
		return latestJobs;
	}

	public void setLatestJobs(Map<Integer, ElanceLatestJobDataModel> latestJobs) {
		this.latestJobs = latestJobs;
	}

	public Map<Integer, ElanceSkillDataModel> getSkills() {
		return skills;
	}

	public void setSkills(Map<Integer, ElanceSkillDataModel> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "ElanceProviderDetailsModel [userId=" + userId + ", userName="
				+ userName + ", businessName=" + businessName + ", category="
				+ category + "]";
	}
	

}
