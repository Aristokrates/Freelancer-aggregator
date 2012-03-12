package org.pan.elance.model.provider;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Elance provider json model
 * <p>
 * Maps the json properties returned from elance provider search into Java bean.
 * <p>
 * For more reference: <a href="http://www.elance.com/p/api/methods/search/providers">Elance Providers</a>
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceProviderModel {
	
	@JsonProperty
	private String userId;
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private String businessName;
	
	@JsonProperty
	private String tagLine;
	
	@JsonProperty
	private String hourlyRate;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private String state;
	
	@JsonProperty
	private String country;
	
	@JsonProperty
	private String earnings6Months;
	
	@JsonProperty
	private String category;
	
	@JsonProperty
	private String logo;
	
	@JsonProperty
	private String providerProfileURL;

	public ElanceProviderModel() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEarnings6Months() {
		return earnings6Months;
	}

	public void setEarnings6Months(String earnings6Months) {
		this.earnings6Months = earnings6Months;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getProviderProfileURL() {
		return providerProfileURL;
	}

	public void setProviderProfileURL(String providerProfileURL) {
		this.providerProfileURL = providerProfileURL;
	}

	@Override
	public String toString() {
		return "ElanceProviderModel [userId=" + userId + ", userName="
				+ userName + ", businessName=" + businessName + "]";
	}
}
