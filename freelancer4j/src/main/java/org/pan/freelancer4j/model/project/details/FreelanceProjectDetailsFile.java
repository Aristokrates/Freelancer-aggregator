package org.pan.freelancer4j.model.project.details;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.pan.freelancer4j.json.JsonDateDeserializer;

/**
 * Freelancer project details additional file details
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelanceProjectDetailsFile {
	
	private Integer fileId;
	
	private Integer projectId;
	
	private String name;
	
	private Date submitDate;

	public FreelanceProjectDetailsFile() {
		super();
	}

	@JsonProperty("id")
	public Integer getFileId() {
		return fileId;
	}

	@JsonProperty("id")
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	@JsonProperty("project_id")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("project_id")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("submitdate")
	public Date getSubmitDate() {
		return submitDate;
	}

	@JsonDeserialize(using=JsonDateDeserializer.class)
	@JsonProperty("submitdate")
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	@Override
	public String toString() {
		return "FreelanceProjectDetailsFile [fileId=" + fileId + ", name="
				+ name + ", projectId=" + projectId + "]";
	}
}
