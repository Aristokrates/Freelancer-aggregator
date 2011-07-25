package org.pan.odesk.model.provider;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * oDesk provider json to Java bean mapping model
 * <p>
 * Maps the odesk provider json representation returned from oDesk into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskProviderModel {
	
	private String devUserId;
	
	private String contactName;
	
	private String rankPercentile;
	
	private String activeInterviews;
	
	private String totalDevelopmentHours;
	
	private String englishSkillLevel;
	
	private String category;
	
	private String estimatedAvailability;
	
	private String providerId;
	
	private String billRate;
	
	private String yearsOfExpirience;
	
	private String location;
	
	private String recentHours;
	
	private String lastWorked;
	
	private String lastActivity;
	
	private List<oDeskProviderSkillModel> providerSkills = new ArrayList<oDeskProviderSkillModel>();

	public oDeskProviderModel() {
		super();
	}

	@JsonProperty("dev_userid")
	public String getDevUserId() {
		return devUserId;
	}

	@JsonProperty("dev_userid")
	public void setDevUserId(String devUserId) {
		this.devUserId = devUserId;
	}

	@JsonProperty("contact_name")
	public String getContactName() {
		return contactName;
	}

	@JsonProperty("contact_name")
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@JsonProperty("dev_recent_rank_percentile")
	public String getRankPercentile() {
		return rankPercentile;
	}

	@JsonProperty("dev_recent_rank_percentile")
	public void setRankPercentile(String rankPercentile) {
		this.rankPercentile = rankPercentile;
	}

	@JsonProperty("dev_active_interviews")
	public String getActiveInterviews() {
		return activeInterviews;
	}

	@JsonProperty("dev_active_interviews")
	public void setActiveInterviews(String activeInterviews) {
		this.activeInterviews = activeInterviews;
	}

	@JsonProperty("dev_total_hours")
	public String getTotalDevelopmentHours() {
		return totalDevelopmentHours;
	}

	@JsonProperty("dev_total_hours")
	public void setTotalDevelopmentHours(String totalDevelopmentHours) {
		this.totalDevelopmentHours = totalDevelopmentHours;
	}

	@JsonProperty("dev_eng_skill")
	public String getEnglishSkillLevel() {
		return englishSkillLevel;
	}

	@JsonProperty("dev_eng_skill")
	public void setEnglishSkillLevel(String englishSkillLevel) {
		this.englishSkillLevel = englishSkillLevel;
	}

	@JsonProperty("dev_category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("dev_category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("dev_est_availability")
	public String getEstimatedAvailability() {
		return estimatedAvailability;
	}

	@JsonProperty("dev_est_availability")
	public void setEstimatedAvailability(String estimatedAvailability) {
		this.estimatedAvailability = estimatedAvailability;
	}

	@JsonProperty("ciphertext")
	public String getProviderId() {
		return providerId;
	}

	@JsonProperty("ciphertext")
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	@JsonProperty("dev_bill_rate")
	public String getBillRate() {
		return billRate;
	}

	@JsonProperty("dev_bill_rate")
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	@JsonProperty("dev_year_exp")
	public String getYearsOfExpirience() {
		return yearsOfExpirience;
	}

	@JsonProperty("dev_year_exp")
	public void setYearsOfExpirience(String yearsOfExpirience) {
		this.yearsOfExpirience = yearsOfExpirience;
	}

	@JsonProperty("dev_location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("dev_location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("dev_recent_hours")
	public String getRecentHours() {
		return recentHours;
	}

	@JsonProperty("dev_recent_hours")
	public void setRecentHours(String recentHours) {
		this.recentHours = recentHours;
	}

	@JsonProperty("dev_last_worked")
	public String getLastWorked() {
		return lastWorked;
	}

	@JsonProperty("dev_last_worked")
	public void setLastWorked(String lastWorked) {
		this.lastWorked = lastWorked;
	}

	@JsonProperty("dev_last_activity")
	public String getLastActivity() {
		return lastActivity;
	}

	@JsonProperty("dev_last_activity")
	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}

	public List<oDeskProviderSkillModel> getProviderSkills() {
		return providerSkills;
	}

	public void setProviderSkills(List<oDeskProviderSkillModel> providerSkills) {
		this.providerSkills = providerSkills;
	}
	
	public void addProviderSkill(oDeskProviderSkillModel skillModel) {
		getProviderSkills().add(skillModel);
	}

	@Override
	public String toString() {
		return "oDeskProviderModel [devUserId=" + devUserId + ", contactName="
				+ contactName + ", category=" + category + ", providerId="
				+ providerId + "]";
	}
	
}
