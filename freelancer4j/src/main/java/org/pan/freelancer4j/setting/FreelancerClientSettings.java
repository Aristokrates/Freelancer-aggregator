package org.pan.freelancer4j.setting;

import org.pan.freelancer4j.token.FreelancerAccessToken;
import org.pan.freelancer4j.token.FreelancerConsumerToken;

/**
 * Freelancer initial settings
 * <p>
 * Used for initializing freelancer client
 * 
 * @author Pance.Isajeski
 *
 */
@SuppressWarnings("serial")
public class FreelancerClientSettings implements java.io.Serializable
{
	private String authCallbackUrl;
	private String authRequestTokenUrl;
	private String authAuthorizeUrl;
	private String authAccessTokenUrl;
	
	private String userEndpointUrl;
	private String userDetailsEndpointUrl;
	private String projectEndpointUrl;
	private String notificationEndpointUrl;
	private String projectDetailsUrl;
	private String projectBidDetailsUrl;
	
	private FreelancerConsumerToken consumerToken;
	private FreelancerAccessToken accessToken;
	private boolean usesOAuth = true;
	
	public FreelancerClientSettings()
	{
		super();
	}
	
	public boolean needsOAuthConfig()
	{
		return ( (authRequestTokenUrl == null)
				 || (authAuthorizeUrl == null)
				 || (authAccessTokenUrl == null));
	}

	public String getAuthCallbackUrl() {
		return authCallbackUrl;
	}

	public void setAuthCallbackUrl(String oAuthCallbackUrl) {
		this.authCallbackUrl = oAuthCallbackUrl;
	}

	public String getAuthRequestTokenUrl() {
		return authRequestTokenUrl;
	}

	public void setAuthRequestTokenUrl(String oAuthRequestTokenUrl) {
		this.authRequestTokenUrl = oAuthRequestTokenUrl;
	}

	public String getAuthAuthorizeUrl() {
		return authAuthorizeUrl;
	}

	public void setAuthAuthorizeUrl(String oAuthAuthorizeUrl) {
		this.authAuthorizeUrl = oAuthAuthorizeUrl;
	}

	public String getAuthAccessTokenUrl() {
		return authAccessTokenUrl;
	}

	public void setAuthAccessTokenUrl(String oAuthAccessTokenUrl) {
		this.authAccessTokenUrl = oAuthAccessTokenUrl;
	}

	public String getUserEndpointUrl() {
		return userEndpointUrl;
	}

	public void setUserEndpointUrl(String userEndpointUrl) {
		this.userEndpointUrl = userEndpointUrl;
	}

	public String getProjectEndpointUrl() {
		return projectEndpointUrl;
	}

	public void setProjectEndpointUrl(String projectEndpointUrl) {
		this.projectEndpointUrl = projectEndpointUrl;
	}

	public String getNotificationEndpointUrl() {
		return notificationEndpointUrl;
	}

	public void setNotificationEndpointUrl(String notificationEndpointUrl) {
		this.notificationEndpointUrl = notificationEndpointUrl;
	}

	public String getProjectDetailsUrl() {
		return projectDetailsUrl;
	}

	public void setProjectDetailsUrl(String projectDetailsUrl) {
		this.projectDetailsUrl = projectDetailsUrl;
	}

	public String getProjectBidDetailsUrl() {
		return projectBidDetailsUrl;
	}

	public void setProjectBidDetailsUrl(String projectBidDetailsUrl) {
		this.projectBidDetailsUrl = projectBidDetailsUrl;
	}

	public FreelancerAccessToken getAccessToken()
	{
		if (accessToken == null)
		{
			accessToken = new FreelancerAccessToken();
		}
		return accessToken;
	}

	public void setAccessToken(FreelancerAccessToken t)
	{
		this.accessToken = t;
	}

	public FreelancerConsumerToken getConsumerToken() {
		return consumerToken;
	}

	public void setConsumerToken(FreelancerConsumerToken apiKey) {
		this.consumerToken = apiKey;
	}

	public boolean getUsesOAuth()
	{
		return usesOAuth;
	}

	public void setUsesOAuth(boolean usesOAuth)
	{
		this.usesOAuth = usesOAuth;
	}

	public String getUserDetailsEndpointUrl() {
		return userDetailsEndpointUrl;
	}

	public void setUserDetailsEndpointUrl(String userDetailsEndpointUrl) {
		this.userDetailsEndpointUrl = userDetailsEndpointUrl;
	}
}

