package org.pan.freelancer4j.model.project.details;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.pan.freelancer4j.json.JsonDateDeserializer;
import org.pan.freelancer4j.model.project.FreelancerProject;

/**
 * Project details to Java bean mapping model
 * <p>
 * Maps the project details json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectDetails extends FreelancerProject {
	
	private FreelanceProjectDetailsDescription additionalDescription;
	
	private FreelanceProjectDetailsFile additionalFiles;
	
	@Override
	public Date getEndDate() {
		return super.getEndDate();
	}

	@JsonDeserialize(using=JsonDateDeserializer.class)
	@Override
	public void setEndDate(Date endDate) {
		super.setEndDate(endDate);
	}
	
	@Override
	public Date getStartDate() {
		return super.getStartDate();
	}

	@JsonDeserialize(using=JsonDateDeserializer.class)
	@Override
	public void setStartDate(Date startDate) {
		super.setStartDate(startDate);
	}

	@JsonProperty("addtional_descr")
	public FreelanceProjectDetailsDescription getAdditionalDescription() {
		return additionalDescription;
	}

	@JsonProperty("addtional_descr")
	public void setAdditionalDescription(
			FreelanceProjectDetailsDescription additionalDescription) {
		this.additionalDescription = additionalDescription;
	}

	@JsonProperty("additional_files")
	public FreelanceProjectDetailsFile getAdditionalFiles() {
		return additionalFiles;
	}

	@JsonProperty("additional_files")
	public void setAdditionalFiles(FreelanceProjectDetailsFile additionalFiles) {
		this.additionalFiles = additionalFiles;
	}

	@Override
	public String toString() {
		return "FreelancerProjectDetails [toString()=" + super.toString() + "]";
	}
	
}
