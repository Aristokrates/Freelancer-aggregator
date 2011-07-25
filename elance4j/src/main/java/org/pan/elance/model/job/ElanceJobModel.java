package org.pan.elance.model.job;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.pan.elance.json.JsonDateDeserializer;

/**
 * Elance job json model
 * <p>
 * Maps the json properties returned from elance job search into Java bean.
 * <p>
 * For more reference: <a href="http://www.elance.com/p/api/methods/search/jobs">Elance Job</a>
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceJobModel {
	
	private String jobId;
	
	private String name;
	
	private String description;
	
	private String budget;
	
	private Date startDate;
	
	private Date endDate;
	
	private String category;
	
	private String numProposals;
	
	private String jobURL;

	public ElanceJobModel() {
		super();
	}
	
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobid) {
		this.jobId = jobid;
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

	public Date getStartDate() {
		return startDate;
	}

	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNumProposals() {
		return numProposals;
	}

	public void setNumProposals(String numProposals) {
		this.numProposals = numProposals;
	}

	public String getJobURL() {
		return jobURL;
	}

	public void setJobURL(String jobURL) {
		this.jobURL = jobURL;
	}

	@Override
	public String toString() {
		return "ElanceJobModel [jobId=" + jobId + ", name=" + name
				+ ", startDate=" + startDate + "]";
	}
}
