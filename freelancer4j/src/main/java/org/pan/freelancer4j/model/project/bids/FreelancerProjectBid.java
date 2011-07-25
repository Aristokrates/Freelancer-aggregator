package org.pan.freelancer4j.model.project.bids;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Project bid to Java bean mapping model
 * <p>
 * Maps the project bid json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectBid {
	
	private Integer providerUserId;
	
	private String providerUsername;
	
	private Integer bidAmmount;
	
	private String milestone;
	
	private Boolean highlighted;
	
	private Integer period;
	
	private String description;
	
	private String submitDate;
	
	private Long rating;
	
	private Integer totalMessageCount;
	
	private Integer unreadMessageCount;

	public FreelancerProjectBid() {
		super();
	}

	@JsonProperty("provider_userid")
	public Integer getProviderUserId() {
		return providerUserId;
	}

	@JsonProperty("provider_userid")
	public void setProviderUserId(Integer providerUserId) {
		this.providerUserId = providerUserId;
	}

	@JsonProperty("provider")
	public String getProviderUsername() {
		return providerUsername;
	}

	@JsonProperty("provider")
	public void setProviderUsername(String providerUsername) {
		this.providerUsername = providerUsername;
	}

	@JsonProperty("bid_amount")
	public Integer getBidAmmount() {
		return bidAmmount;
	}

	@JsonProperty("bid_amount")
	public void setBidAmmount(Integer bidAmmount) {
		this.bidAmmount = bidAmmount;
	}

	@JsonProperty("milestone")
	public String getMilestone() {
		return milestone;
	}

	@JsonProperty("milestone")
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	@JsonProperty("highlighted")
	public Boolean getHighlighted() {
		return highlighted;
	}

	@JsonProperty("highlighted")
	public void setHighlighted(Boolean highlighted) {
		this.highlighted = highlighted;
	}

	@JsonProperty("period")
	public Integer getPeriod() {
		return period;
	}

	@JsonProperty("period")
	public void setPeriod(Integer period) {
		this.period = period;
	}

	@JsonProperty("descr")
	public String getDescription() {
		return description;
	}

	@JsonProperty("descr")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("submittime")
	public String getSubmitDate() {
		return submitDate;
	}

	@JsonProperty("submittime")
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	@JsonProperty("rating")
	public Long getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Long rating) {
		this.rating = rating;
	}

	@JsonProperty("total_msg_count")
	public Integer getTotalMessageCount() {
		return totalMessageCount;
	}

	@JsonProperty("total_msg_count")
	public void setTotalMessageCount(Integer totalMessageCount) {
		this.totalMessageCount = totalMessageCount;
	}

	@JsonProperty("unread_msg_count")
	public Integer getUnreadMessageCount() {
		return unreadMessageCount;
	}

	@JsonProperty("unread_msg_count")
	public void setUnreadMessageCount(Integer unreadMessageCount) {
		this.unreadMessageCount = unreadMessageCount;
	}
	
	public FreelancerCacheProjectBid toFreelancerCacheProjectBid() {
		return new FreelancerCacheProjectBid(getProviderUserId(), 
				getBidAmmount(), getPeriod());
	}

	@Override
	public String toString() {
		return "FreelancerProjectBid [description=" + description
				+ ", providerUserId=" + providerUserId + ", providerUsername="
				+ providerUsername + "]";
	}
}
