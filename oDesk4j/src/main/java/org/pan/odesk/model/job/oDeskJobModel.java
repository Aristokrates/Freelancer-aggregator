package org.pan.odesk.model.job;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * oDesk job json to Java bean mapping model
 * <p>
 * Maps the job json representation returned from oDesk into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskJobModel {

	private String opReason;

	private String secondCategory;

	private String engagementRelated;

	private String description;

	private String totalActiveCandidates;

	private String jobExpiration;

	private String averageHourlyRate;

	private String jobCategory;

	private String timePosted;

	private String timezone;

	private String hoursPerWeek;

	private String dateCreated;
	
	private String datePosted;
	
	private oDeskJobBuyer buyer;

	private String endDate;

	private String title;

	private String jobId;
	
	private String profileKey;

	private String startDate;

	private String requiredSkills;

	private String country;

	private String jobType;

	private String estimatedDuration;

	private String active;

	public oDeskJobModel() {
		super();
	}

	public String getOpReason() {
		return opReason;
	}

	@JsonProperty("op_reason")
	public void setOpReason(String opReason) {
		this.opReason = opReason;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	@JsonProperty("job_category_level_two")
	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}

	public String getEngagementRelated() {
		return engagementRelated;
	}

	@JsonProperty("engagement_related")
	public void setEngagementRelated(String engagementRelated) {
		this.engagementRelated = engagementRelated;
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty("op_description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalActiveCandidates() {
		return totalActiveCandidates;
	}

	@JsonProperty("candidates_total_active")
	public void setTotalActiveCandidates(String totalActiveCandidates) {
		this.totalActiveCandidates = totalActiveCandidates;
	}

	public String getJobExpiration() {
		return jobExpiration;
	}

	@JsonProperty("op_job_expiration")
	public void setJobExpiration(String jobExpiration) {
		this.jobExpiration = jobExpiration;
	}
	
	public oDeskJobBuyer getBuyer() {
		return buyer;
	}

	@JsonProperty("buyer")
	public void setBuyer(oDeskJobBuyer buyer) {
		this.buyer = buyer;
	}

	public String getAverageHourlyRate() {
		return averageHourlyRate;
	}

	@JsonProperty("op_avg_hourly_rate_active")
	public void setAverageHourlyRate(String averageHourlyRate) {
		this.averageHourlyRate = averageHourlyRate;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	@JsonProperty("job_category_level_one")
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getTimePosted() {
		return timePosted;
	}

	@JsonProperty("op_time_posted")
	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}

	public String getTimezone() {
		return timezone;
	}

	@JsonProperty("timezone")
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getHoursPerWeek() {
		return hoursPerWeek;
	}

	@JsonProperty("hours_per_week")
	public void setHoursPerWeek(String hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	@JsonProperty("op_date_created")
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEndDate() {
		return endDate;
	}

	@JsonProperty("op_end_date")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	@JsonProperty("op_title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getJobId() {
		return jobId;
	}

	@JsonProperty("ciphertext")
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getProfileKey() {
		return profileKey;
	}

	@JsonProperty("profile_key")
	public void setProfileKey(String profileKey) {
		this.profileKey = profileKey;
	}

	public String getStartDate() {
		return startDate;
	}

	@JsonProperty("op_start_date")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	@JsonProperty("op_required_skills")
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public String getCountry() {
		return country;
	}

	@JsonProperty("op_country")
	public void setCountry(String country) {
		this.country = country;
	}

	public String getJobType() {
		return jobType;
	}

	@JsonProperty("job_type")
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getEstimatedDuration() {
		return estimatedDuration;
	}

	@JsonProperty("op_est_duration")
	public void setEstimatedDuration(String estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}

	public String getActive() {
		return active;
	}

	@JsonProperty("op_active")
	public void setActive(String active) {
		this.active = active;
	}
	
	public String getDatePosted() {
		return datePosted;
	}

	@JsonProperty("date_posted")
	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}
	
	public String getIdentifier() {
		return getJobId();
	}

	public oDeskCacheJob toCacheJob() {
		return new oDeskCacheJob(jobId, active, dateCreated);
	}

	@Override
	public String toString() {
		return "oDeskJobModel [active=" + active + ", datePosted=" + datePosted
				+ ", jobId=" + jobId + "]";
	}
}
