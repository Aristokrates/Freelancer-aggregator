package org.pan.elance.model.provider.details;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceSkillDataModel {
	
	@JsonProperty
	private Integer skillId;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String proficiencyType;
	
	@JsonProperty
	private Integer proficiency;
	
	@JsonProperty
	private Integer testAverage;
	
	@JsonProperty
	private Integer testPercentile;

	public ElanceSkillDataModel() {
		super();
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProficiencyType() {
		return proficiencyType;
	}

	public void setProficiencyType(String proficiencyType) {
		this.proficiencyType = proficiencyType;
	}

	public Integer getProficiency() {
		return proficiency;
	}

	public void setProficiency(Integer proficiency) {
		this.proficiency = proficiency;
	}

	public Integer getTestAverage() {
		return testAverage;
	}

	public void setTestAverage(Integer testAverage) {
		this.testAverage = testAverage;
	}

	public Integer getTestPercentile() {
		return testPercentile;
	}

	public void setTestPercentile(Integer testPercentile) {
		this.testPercentile = testPercentile;
	}
}
