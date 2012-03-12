package org.pan.odesk.model.provider;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskProviderSkillModel {
	
	@JsonProperty
	private String skl_ref;
	
	@JsonProperty
	private String skl_name;
	
	@JsonProperty
	private String skl_last_used;
	
	@JsonProperty
	private String skl_level_num;
	
	@JsonProperty
	private String skl_level;
	
	@JsonProperty
	private String skl_comment;
	
	@JsonProperty
	private String skl_year_exp;

	public oDeskProviderSkillModel() {
		super();
	}

	public String getSkl_ref() {
		return skl_ref;
	}

	public void setSkl_ref(String skl_ref) {
		this.skl_ref = skl_ref;
	}

	public String getSkl_name() {
		return skl_name;
	}

	public void setSkl_name(String skl_name) {
		this.skl_name = skl_name;
	}

	public String getSkl_last_used() {
		return skl_last_used;
	}

	public void setSkl_last_used(String skl_last_used) {
		this.skl_last_used = skl_last_used;
	}

	public String getSkl_level_num() {
		return skl_level_num;
	}

	public void setSkl_level_num(String skl_level_num) {
		this.skl_level_num = skl_level_num;
	}

	public String getSkl_level() {
		return skl_level;
	}

	public void setSkl_level(String skl_level) {
		this.skl_level = skl_level;
	}

	public String getSkl_comment() {
		return skl_comment;
	}

	public void setSkl_comment(String skl_comment) {
		this.skl_comment = skl_comment;
	}

	public String getSkl_year_exp() {
		return skl_year_exp;
	}

	public void setSkl_year_exp(String skl_year_exp) {
		this.skl_year_exp = skl_year_exp;
	}
}
