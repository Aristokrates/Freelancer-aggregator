package org.pan.freelancer4j.model.user.details;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.freelancer4j.model.FreelancerCurrency;
import org.pan.freelancer4j.model.FreelancerStatistic;
import org.pan.freelancer4j.model.user.FreelancerUserAddress;

/**
 * Freelancer user details to Java bean mapping model
 * <p>
 * Maps the freelancer user details json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerUserDetails {
	
	private Integer id;
	
	private String username;
	
	private String url;
	
	private String logoUrl;
	
	private String profileLogoUrl;
	
	private String registrationUnixTime;
	
	private Date registrationDate;
	
	private String company;
	
	private Integer currency;
	
	private String timezone;
	
	private FreelancerUserAddress address;
	
	private Boolean goldMember;
	
	private String hourlyRate;
	
	private FreelancerStatistic userRating;
	
	private FreelancerStatistic buyerRating;
	
	private FreelancerStatistic providerRating;
	
	private List<String> skills;

	public FreelancerUserDetails() {
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

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("logo_url")
	public String getLogoUrl() {
		return logoUrl;
	}

	@JsonProperty("logo_url")
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
		
	@JsonProperty("profile_logo_url")
	public String getProfileLogoUrl() {
		return profileLogoUrl;
	}
	
	@JsonProperty("profile_logo_url")
	public void setProfileLogoUrl(String profileLogoUrl) {
		this.profileLogoUrl = profileLogoUrl;
	}

	@JsonProperty("reg_unixtime")
	public String getRegistrationUnixTime() {
		return registrationUnixTime;
	}

	@JsonProperty("reg_unixtime")
	public void setRegistrationUnixTime(String registrationUnixTime) {
		this.registrationUnixTime = registrationUnixTime;
	}

	@JsonProperty("reg_date")
	public Date getRegistrationDate() {
		return registrationDate;
	}

	@JsonProperty("reg_date")
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@JsonProperty("company")
	public String getCompany() {
		return company;
	}

	@JsonProperty("company")
	public void setCompany(String company) {
		this.company = company;
	}

	@JsonProperty("currency")
	public Integer getCurrency() {
		return currency;
	}
	
	public FreelancerCurrency getCurrencyEnum() {
		return FreelancerCurrency.getFreelancerCurrency(getCurrency());
	}

	@JsonProperty("currency")
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	@JsonProperty("timezone")
	public String getTimezone() {
		return timezone;
	}

	@JsonProperty("timezone")
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@JsonProperty("address")
	public FreelancerUserAddress getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(FreelancerUserAddress address) {
		this.address = address;
	}

	@JsonProperty("gold")
	public Boolean getGoldMember() {
		return goldMember;
	}

	@JsonProperty("gold")
	public void setGoldMember(Boolean goldMember) {
		this.goldMember = goldMember;
	}

	@JsonProperty("hourlyrate")
	public String getHourlyRate() {
		return hourlyRate;
	}

	@JsonProperty("hourlyrate")
	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@JsonProperty("rating")
	public FreelancerStatistic getUserRating() {
		return userRating;
	}

	@JsonProperty("rating")
	public void setUserRating(FreelancerStatistic userRating) {
		this.userRating = userRating;
	}

	@JsonProperty("buyer_rating")
	public FreelancerStatistic getBuyerRating() {
		return buyerRating;
	}

	@JsonProperty("buyer_rating")
	public void setBuyerRating(FreelancerStatistic buyerRating) {
		this.buyerRating = buyerRating;
	}

	@JsonProperty("provider_rating")
	public FreelancerStatistic getProviderRating() {
		return providerRating;
	}

	@JsonProperty("provider_rating")
	public void setProviderRating(FreelancerStatistic providerRating) {
		this.providerRating = providerRating;
	}

	@JsonProperty("jobs")
	public List<String> getSkills() {
		return skills;
	}

	@JsonProperty("jobs")
	public void setSkills(List<String> jobs) {
		this.skills = jobs;
	}

	@Override
	public String toString() {
		return "FreelanceUserDetails [id=" + id + ", url=" + url
				+ ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		FreelancerUserDetails other = (FreelancerUserDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
