package org.pan.odesk.model.job;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * oDesk job buyer json to Java bean mapping model
 * <p>
 * Maps the job buyer json representation returned from oDesk into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskJobBuyer {
	
	private String assignmenets;
	
	private String hoursLast30Days;
	
	private String otherJobs;
	
	private String state;
	
	private String contractDate;
	
	private String totalCharge;
	
	private String adjustedScore;
	
	private String totalAssignments;
	
	private String timezone;
	
	private String chargeLast30Days;
	
	private String totalFeedback;
	
	private String totalJobsOpened;
	
	private String country;
	
	private String city;
	
	private String totalJobsPosted;
	
	private String totalJObsFilled;
	
	private String totalHour;

	public oDeskJobBuyer() {
		super();
	}

	public String getAssignmenets() {
		return assignmenets;
	}

	@JsonProperty("cnt_assignments")
	public void setAssignmenets(String assignmenets) {
		this.assignmenets = assignmenets;
	}

	public String getHoursLast30Days() {
		return hoursLast30Days;
	}

	@JsonProperty("op_hours_last30days")
	public void setHoursLast30Days(String hoursLast30Days) {
		this.hoursLast30Days = hoursLast30Days;
	}

	public String getOtherJobs() {
		return otherJobs;
	}

	@JsonProperty("cnt_op_other_jobs")
	public void setOtherJobs(String otherJobs) {
		this.otherJobs = otherJobs;
	}

	public String getState() {
		return state;
	}

	@JsonProperty("op_state")
	public void setState(String state) {
		this.state = state;
	}

	public String getContractDate() {
		return contractDate;
	}

	@JsonProperty("op_contract_date")
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getTotalCharge() {
		return totalCharge;
	}

	@JsonProperty("op_tot_charge")
	public void setTotalCharge(String totalCharge) {
		this.totalCharge = totalCharge;
	}

	public String getAdjustedScore() {
		return adjustedScore;
	}

	@JsonProperty("op_adjusted_score")
	public void setAdjustedScore(String adjustedScore) {
		this.adjustedScore = adjustedScore;
	}

	public String getTotalAssignments() {
		return totalAssignments;
	}

	@JsonProperty("op_tot_asgs")
	public void setTotalAssignments(String totalAssignments) {
		this.totalAssignments = totalAssignments;
	}

	public String getTimezone() {
		return timezone;
	}

	@JsonProperty("op_timezone")
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getChargeLast30Days() {
		return chargeLast30Days;
	}

	@JsonProperty("op_charge_last30days")
	public void setChargeLast30Days(String chargeLast30Days) {
		this.chargeLast30Days = chargeLast30Days;
	}

	public String getTotalFeedback() {
		return totalFeedback;
	}

	@JsonProperty("op_tot_feedback")
	public void setTotalFeedback(String totalFeedback) {
		this.totalFeedback = totalFeedback;
	}

	public String getTotalJobsOpened() {
		return totalJobsOpened;
	}

	@JsonProperty("op_tot_jobs_open")
	public void setTotalJobsOpened(String totalJobsOpened) {
		this.totalJobsOpened = totalJobsOpened;
	}

	public String getCountry() {
		return country;
	}

	@JsonProperty("op_country")
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	@JsonProperty("op_city")
	public void setCity(String city) {
		this.city = city;
	}

	public String getTotalJobsPosted() {
		return totalJobsPosted;
	}

	@JsonProperty("op_tot_jobs_posted")
	public void setTotalJobsPosted(String totalJobsPosted) {
		this.totalJobsPosted = totalJobsPosted;
	}

	public String getTotalJObsFilled() {
		return totalJObsFilled;
	}

	@JsonProperty("op_tot_jobs_filled")
	public void setTotalJObsFilled(String totalJObsFilled) {
		this.totalJObsFilled = totalJObsFilled;
	}

	public String getTotalHour() {
		return totalHour;
	}

	@JsonProperty("op_tot_hours")
	public void setTotalHour(String totalHour) {
		this.totalHour = totalHour;
	}
}
