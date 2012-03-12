package org.pan.linkedin.model.job;

import java.util.Date;

import com.google.code.linkedinapi.schema.Job;

public class LinkedInJobModel {
	
	private String jobId;
	
	private Boolean active;
	
	private String companyName;
	
	private String description;
	
	private Date postingDate;
	
	private Date expirationDate;
	
	private String jobPosterName;
	
	private String jobPosterHeadline;
	
	private String location;
	
	private LinkedInJobPositionModel jobPosition;
	
	private String salary;
	
	private String skills;
	
	private String jobUrl;	

	public LinkedInJobModel() {
		super();
	}

	public LinkedInJobModel(Job job) {
		
		this.jobId = job.getId();
		this.active = job.isActive();
		this.companyName = job.getCompany() != null ? job.getCompany().getName() : null;
		this.description = job.getDescription();
		this.postingDate = new Date(job.getPostingTimestamp());
		this.expirationDate = new Date(job.getExpirationTimestamp());
		this.jobPosterName = job.getPoster() != null ? job.getPoster().getEmailAddress() : null;
		this.location = job.getLocationDescription();
		if (job.getPosition() != null) {
			this.jobPosition = new LinkedInJobPositionModel(job.getPosition());
		}
		this.salary = job.getSalary();
		this.skills = job.getSkillsAndExperience();
		this.jobUrl = job.getSiteJobUrl();
		
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getJobPosterName() {
		return jobPosterName;
	}

	public void setJobPosterName(String jobPosterName) {
		this.jobPosterName = jobPosterName;
	}

	public String getJobPosterHeadline() {
		return jobPosterHeadline;
	}

	public void setJobPosterHeadline(String jobPosterHeadline) {
		this.jobPosterHeadline = jobPosterHeadline;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public LinkedInJobPositionModel getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(LinkedInJobPositionModel jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	@Override
	public String toString() {
		return "LinkedInJobModel [jobId=" + jobId + ", companyName="
				+ companyName + ", jobUrl=" + jobUrl + "]";
	}

}
