package org.pan.freelancer4j.model.project;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Project option json to Java bean mapping model
 * <p>
 * Maps the project opton json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectOption {
	
	private Boolean featured;
	
	private Boolean nonPublic;
	
	private Boolean trial;
	
	private Boolean goldMembersOnly;
	
	private Boolean fullTime;
	
	private Boolean hiddenBids;

	public FreelancerProjectOption() {
		super();
	}

	@JsonProperty("featured")
	public Boolean getFeatured() {
		return featured;
	}

	@JsonProperty("featured")
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	@JsonProperty("nonpublic")
	public Boolean getNonPublic() {
		return nonPublic;
	}

	@JsonProperty("nonpublic")
	public void setNonPublic(Boolean nonPublic) {
		this.nonPublic = nonPublic;
	}

	@JsonProperty("trial")
	public Boolean getTrial() {
		return trial;
	}

	@JsonProperty("trial")
	public void setTrial(Boolean trial) {
		this.trial = trial;
	}

	@JsonProperty("for_gold_members")
	public Boolean getGoldMembersOnly() {
		return goldMembersOnly;
	}

	@JsonProperty("for_gold_members")
	public void setGoldMembersOnly(Boolean goldMembersOnly) {
		this.goldMembersOnly = goldMembersOnly;
	}	
	
	@JsonProperty("fulltime")
	public Boolean getFullTime() {
		return fullTime;
	}
	
	@JsonProperty("fulltime")
	public void setFullTime(Boolean fullTime) {
		this.fullTime = fullTime;
	}

	@JsonProperty("hidden_bids")
	public Boolean getHiddenBids() {
		return hiddenBids;
	}

	@JsonProperty("hidden_bids")
	public void setHiddenBids(Boolean hiddenBids) {
		this.hiddenBids = hiddenBids;
	}

	@Override
	public String toString() {
		return "FreelancerProjectOption [featured=" + featured + ", fullTime="
				+ fullTime + ", goldMembersOnly=" + goldMembersOnly
				+ ", hiddenBids=" + hiddenBids + ", nonPublic=" + nonPublic
				+ ", trial=" + trial + "]";
	}
}
