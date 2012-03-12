package org.pan.linkedin.model.job;

import java.util.ArrayList;
import java.util.List;

import com.google.code.linkedinapi.schema.Industry;
import com.google.code.linkedinapi.schema.JobFunction;
import com.google.code.linkedinapi.schema.Position;

public class LinkedInJobPositionModel {
	
	private String description;
	
	private String location;
	
	private String skills;
	
	private String title;
	
	private String jobType;
	
	private List<String> functions = new ArrayList<String>();
	
	private List<String> industries = new ArrayList<String>();

	public LinkedInJobPositionModel(Position position) {
		
		this.description = position.getDescription();
		this.location = position.getLocation() != null ? position.getLocation().getDescription() : null;
		this.skills = position.getSkillsAndExperience();
		this.title = position.getTitle();
		this.jobType = position.getJobType() != null ? position.getJobType().getName() : null;
		
		if (position.getJobFunctions() != null) {
			for (JobFunction jf : position.getJobFunctions().getJobFunctionList()) {
				this.functions.add(jf.getName());
			}
		}
		
		if (position.getIndustries() != null) {
			for (Industry ind : position.getIndustries().getIndustryList()) {
				this.industries.add(ind.getName());
			}
		}				
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public List<String> getFunctions() {
		return functions;
	}

	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}

	public List<String> getIndustries() {
		return industries;
	}

	public void setIndustries(List<String> industries) {
		this.industries = industries;
	}

	@Override
	public String toString() {
		return "LinkedInJobPositionModel [description=" + description
				+ ", title=" + title + "]";
	}	
	
	
}
