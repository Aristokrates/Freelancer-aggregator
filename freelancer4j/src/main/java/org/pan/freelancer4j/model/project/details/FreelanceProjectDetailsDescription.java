package org.pan.freelancer4j.model.project.details;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Freelancer project details additional description model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelanceProjectDetailsDescription {
	
	private Integer descriptionId;
	
	private Integer projectId;
	
	private Date submitDate;
	
	private String descriptionHtml;

	public FreelanceProjectDetailsDescription() {
		super();
	}

	@JsonProperty("id")
	public Integer getDescriptionId() {
		return descriptionId;
	}

	@JsonProperty("id")
	public void setDescriptionId(Integer descriptionId) {
		this.descriptionId = descriptionId;
	}

	@JsonProperty("project_id")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("project_id")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonProperty("submitdate")
	public Date getSubmitDate() {
		return submitDate;
	}

	@JsonProperty("submitdate")
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	@JsonProperty("descr_html")
	public String getDescriptionHtml() {
		return descriptionHtml;
	}

	@JsonProperty("descr_html")
	public void setDescriptionHtml(String descriptionHtml) {
		this.descriptionHtml = descriptionHtml;
	}

	@Override
	public String toString() {
		return "FreelanceProjectDetailsDescription [descriptionId="
				+ descriptionId + ", projectId=" + projectId + "]";
	}
}
