package org.pan.elance.model.provider.details;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceLatestJobDataModel {
	
	@JsonProperty
	private Integer jobId;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private String budget;
	
	@JsonProperty
	private String category;
	
	@JsonProperty
	private String jobURL;

	public ElanceLatestJobDataModel() {
		super();
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJobURL() {
		return jobURL;
	}

	public void setJobURL(String jobURL) {
		this.jobURL = jobURL;
	}
}
