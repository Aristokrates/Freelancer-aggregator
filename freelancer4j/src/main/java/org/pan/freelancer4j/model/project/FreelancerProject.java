package org.pan.freelancer4j.model.project;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.freelancer4j.model.FreelancerCurrency;
import org.pan.freelancer4j.model.FreelancerProjectState;
import org.pan.freelancer4j.model.FreelancerStatistic;

/**
 * Project json to Java bean mapping model
 * <p>
 * Maps the project json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProject {
	
	private Integer id;
	
	private String name;
	
	private String url;
	
	private String startUnixTime;
	
	private Date startDate;
	
	private String endUnixTime;
	
	private Date endDate;
	
	private FreelancerProjectBuyer buyer;
	
	private String state;
	
	private String shortDescription;
	
	private FreelancerProjectOption options;
	
	private FreelancerProjectBudget budget;
	
	private List<String> jobs;
	
	private Integer currency;
	
	private FreelancerStatistic bidStatistic;

	public FreelancerProject() {
		super();
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("start_unixtime")
	public String getStartUnixTime() {
		return startUnixTime;
	}

	@JsonProperty("start_unixtime")
	public void setStartUnixTime(String startUnixTime) {
		this.startUnixTime = startUnixTime;
	}

	@JsonProperty("start_date")
	public Date getStartDate() {
		return startDate;
	}

	@JsonProperty("start_date")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonProperty("end_unixtime")
	public String getEndUnixTime() {
		return endUnixTime;
	}

	@JsonProperty("end_unixtime")
	public void setEndUnixTime(String endUnixTime) {
		this.endUnixTime = endUnixTime;
	}

	@JsonProperty("end_date")
	public Date getEndDate() {
		return endDate;
	}

	@JsonProperty("end_date")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@JsonProperty("buyer")
	public FreelancerProjectBuyer getBuyer() {
		return buyer;
	}

	@JsonProperty("buyer")
	public void setBuyer(FreelancerProjectBuyer buyer) {
		this.buyer = buyer;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}
	
	public FreelancerProjectState getStateEnum() {
		return FreelancerProjectState.getProjectStateByIdentifier(getState());
	}

	@JsonProperty("short_descr")
	public String getShortDescription() {
		return shortDescription;
	}

	@JsonProperty("short_descr")
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@JsonProperty("options")
	public FreelancerProjectOption getOptions() {
		return options;
	}

	@JsonProperty("options")
	public void setOptions(FreelancerProjectOption options) {
		this.options = options;
	}

	@JsonProperty("budget")
	public FreelancerProjectBudget getBudget() {
		return budget;
	}

	@JsonProperty("budget")
	public void setBudget(FreelancerProjectBudget budget) {
		this.budget = budget;
	}

	@JsonProperty("jobs")
	public List<String> getJobs() {
		return jobs;
	}

	@JsonProperty("jobs")
	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}	
	
	@JsonProperty("currency")
	public Integer getCurrency() {
		return currency;
	}
	
	@JsonProperty("currency")
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	
	public FreelancerCurrency getCurrencyEnum() {
		return FreelancerCurrency.getFreelancerCurrency(getCurrency());
	}

	@JsonProperty("bid_stats")
	public FreelancerStatistic getBidStatistic() {
		return bidStatistic;
	}

	@JsonProperty("bid_stats")
	public void setBidStatistic(FreelancerStatistic bidStatistic) {
		this.bidStatistic = bidStatistic;
	}
	
	public FreelancerCacheProject toFreelancerCacheProject() {
		return new FreelancerCacheProject(getId(), getStateEnum());
	}

	@Override
	public String toString() {
		return "FreelancerProject [id=" + id + ", name=" + name + ", url="
				+ url + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreelancerProject other = (FreelancerProject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
}
