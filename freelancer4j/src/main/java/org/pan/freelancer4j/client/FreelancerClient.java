package org.pan.freelancer4j.client;

import java.net.URL;
import java.util.*;
import java.util.Map.Entry;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.pan.freelancer4j.exception.FreelancerClientException;
import org.pan.freelancer4j.json.GenericSerializer;
import org.pan.freelancer4j.json.JacksonJsonSerializer;
import org.pan.freelancer4j.model.FreelancerResponseWrapper;
import org.pan.freelancer4j.model.project.FreelancerProjectWrapper;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidWrapper;
import org.pan.freelancer4j.model.project.details.FreelancerProjectDetailsWrapper;
import org.pan.freelancer4j.model.user.FreelancerUserWrapper;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetailsWrapper;
import org.pan.freelancer4j.setting.FreelancerClientSettings;
import org.pan.freelancer4j.token.FreelancerAccessToken;
import org.pan.freelancer4j.token.FreelancerConsumerToken;
import org.pan.freelancer4j.token.FreelancerRequestToken;

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthServiceProvider;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient4.HttpClient4;
import net.oauth.client.httpclient4.HttpClientPool;


/**
 * Freelancer API java client
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerClient {
	private HttpClient httpClient;
	private OAuthClient authClient;
	private OAuthServiceProvider authProvider;
	private FreelancerRequestToken requestToken = new FreelancerRequestToken();
	private FreelancerClientSettings settings;
	private HttpClientPool pool;
	
	private GenericSerializer serializer;

	public FreelancerClient(FreelancerClientSettings clientSettings) {
		this(getDefaultHttpClient(), clientSettings);
	}

	public FreelancerClient(final HttpClient hClient, FreelancerClientSettings clientSettings) {
		this.httpClient = hClient;

		this.setUserAgent("pan");

		this.setSocketTimeout( (30 * 1000) );
		this.setConnectionTimeout( (20 * 1000) );


		this.pool = new HttpClientPool()
		{

			public HttpClient getHttpClient(URL u)
			{
				return httpClient;
			}

		};
		this.settings = clientSettings;
		this.serializer = new JacksonJsonSerializer();

	}
	
	public FreelancerProjectWrapper sendSearchProjectRequest(Set<Entry<String, Object>> params, String extraPath) {
		return sendFreelancerRequest(this.getClientSettings().getProjectEndpointUrl(), params, extraPath, FreelancerProjectWrapper.class);
	}
	
	public FreelancerUserWrapper sendSearchUserRequest(Set<Entry<String, Object>> params, String extraPath) {
		return sendFreelancerRequest(this.getClientSettings().getUserEndpointUrl(), params, extraPath, FreelancerUserWrapper.class);
	}
	
	public FreelancerUserDetailsWrapper sendGetUserDetailsRequest(Set<Entry<String, Object>> params, String extraPath) {
		return sendFreelancerRequest(this.getClientSettings().getUserDetailsEndpointUrl(), params, extraPath, FreelancerUserDetailsWrapper.class);
	}
	
	public FreelancerProjectDetailsWrapper sendProjectDetailsRequest(Set<Entry<String, Object>> params, String extraPath) {
		return sendFreelancerRequest(this.getClientSettings().getProjectDetailsUrl(), params, extraPath, FreelancerProjectDetailsWrapper.class);
	}
	
	public FreelancerProjectBidWrapper sendProjectBidRequest(Set<Entry<String, Object>> params, String extraPath) {
		return sendFreelancerRequest(this.getClientSettings().getProjectBidDetailsUrl(), params, extraPath, FreelancerProjectBidWrapper.class);
	}

	protected <T extends FreelancerResponseWrapper> T sendFreelancerRequest(String endpointUrl, Set<Entry<String, Object>> params, String extraPath, Class<T> responseClass) {

		String rsp = sendHttpRequest(endpointUrl, 
				"GET", 
				extraPath,
				params, 
				this.getClientSettings().getAccessToken());

		return fromString(rsp, responseClass);

	}

	protected String sendHttpRequest(String baseUrl, String method, String extraPath, Set<Entry<String, Object>> params, FreelancerAccessToken token) {

		OAuthClient client = getOAuthClient();

		OAuthMessage responseMsg = null;

		OAuthAccessor access = this.createOAuthAccessor();

		access.accessToken = token.getToken();
		access.tokenSecret = token.getTokenSecret();

		if (params == null) {
			params = new HashSet<Map.Entry<String,Object>>();
		}

		String url = baseUrl;

		if (extraPath != null) {
			url += extraPath;
		}

		try {

			responseMsg = client.invoke(access, method, url, params);

			return responseMsg.readBodyAsString();

		} 
		catch (Exception e) {
			throw new FreelancerClientException(e);
		}

	}

	protected <T extends FreelancerResponseWrapper> T fromString(String rsp, Class<T> responseClass) {
		return serializer.fromJson(rsp, responseClass);
	}

	protected OAuthClient createOAuthClient() {

		OAuthClient authClient = new OAuthClient(new HttpClient4(this.pool));

		return authClient;
	}

	protected OAuthClient getOAuthClient() {

		if (authClient == null)
		{
			authClient = createOAuthClient();
		}

		return authClient;
	}

	protected OAuthServiceProvider createOAuthServiceProvider() {

		OAuthServiceProvider p = new OAuthServiceProvider(
				this.getClientSettings().getAuthRequestTokenUrl(),
				this.getClientSettings().getAuthAuthorizeUrl(),
				this.getClientSettings().getAuthAccessTokenUrl());

		return p;

	}

	protected FreelancerClientSettings getClientSettings() {
		return this.settings; 
	}

	protected OAuthServiceProvider getOAuthServiceProvider() {
		if (authProvider == null)
		{
			authProvider = createOAuthServiceProvider();
		}
		return authProvider;
	}

	protected OAuthAccessor createOAuthAccessor() {

		OAuthConsumer c = createOAuthConsumer();

		OAuthAccessor a = new OAuthAccessor(c);

		return a;

	}

	protected OAuthConsumer createOAuthConsumer() {

		FreelancerConsumerToken consumerToken = this.getClientSettings().getConsumerToken();

		String oauthCallBackUrl = this.getClientSettings().getAuthCallbackUrl();

		OAuthConsumer c = new OAuthConsumer(
				oauthCallBackUrl, 
				consumerToken.getToken(), 
				consumerToken.getTokenSecret(),
				getOAuthServiceProvider());

		return c;
	}

	public FreelancerAccessToken fetchAccessToken(String verifier) {

		OAuthClient client = getOAuthClient();
		
		OAuthAccessor access = this.createOAuthAccessor();

		System.out.println("Request token: " + requestToken);
		System.out.println("Consumer token: " + this.getClientSettings().getConsumerToken());

		try
		{
			access.accessToken = null;
			access.requestToken = requestToken.getToken();
			access.tokenSecret = requestToken.getTokenSecret();

			Map<String, String> parameters = new HashMap<String, String>();
			
			parameters.put("oauth_verifier", verifier);
			
			client.getAccessToken(access, "GET", parameters.entrySet());
			
			FreelancerAccessToken accessToken = new FreelancerAccessToken(access.accessToken, access.tokenSecret);

			this.getClientSettings().setAccessToken(accessToken);
			
			return accessToken;

		} 
		catch (Exception e) 
		{
			throw new FreelancerClientException(e);
		}
	}

	public String getUserAuthorizationUrl() {

		String url = null;

		OAuthClient client = getOAuthClient();

		OAuthAccessor access = this.createOAuthAccessor();
		try {

			this.requestToken = null;
			access.requestToken = null;
			access.accessToken = null;
			access.tokenSecret = null;

			Map<String, String> parameters = new HashMap<String, String>();
			
			parameters.put("oauth_callback", settings.getAuthCallbackUrl());

			client.getRequestToken(access, "GET", parameters.entrySet());

			this.requestToken = new FreelancerRequestToken(access.requestToken, access.tokenSecret.trim());
			System.out.println("Request token: " + requestToken);
			url = this.getClientSettings().getAuthAuthorizeUrl() 
			+ "?oauth_token=" + requestToken.getToken();

			return url;

		} 
		catch (Exception e) 
		{
			throw new FreelancerClientException(e);
		}
	}
	
	public void setClientSettings(FreelancerClientSettings s) {
		this.settings = s;
	}

	public void setRequestToken(FreelancerRequestToken t) {
		this.requestToken = t;
	}

	public byte[] get(String url) {
		HttpGet get = null;
		HttpResponse response = null;
		byte[] data = null;
		HttpEntity entity = null;

		try
		{
			get = new HttpGet(url);
			response = this.getHttpClient().execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				entity = response.getEntity();
				data = EntityUtils.toByteArray(entity);
				return data;
			}
			else
			{
				throw new RuntimeException("HTTP GET failed ("
						+ url
						+ "), status code = " 
						+ response.getStatusLine().getStatusCode());
			}
		}
		catch (RuntimeException ex) {
			throw ex;
		}
		catch (Exception ex) {
			throw new FreelancerClientException(ex);
		}
	}

	protected boolean hasValidUserAccessToken() {
		return this.getAccessToken().isValid();
	}

	protected FreelancerAccessToken getAccessToken() {
		return this.getClientSettings().getAccessToken(); 
	}
	
	private HttpClient getHttpClient() {
		return httpClient;
	}

	@SuppressWarnings("deprecation")
	private static HttpClient getDefaultHttpClient() {		
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, "utf-8");
        params.setBooleanParameter("http.protocol.expect-continue", false);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(params, registry);
        return new DefaultHttpClient(cm, params);
	}

	public void open() {

	}

	public void shutdown() {
		try
		{
			this.getHttpClient().getConnectionManager().shutdown();
		}
		catch (Exception ignore)
		{
			// ignored
		}
	}

	private void setUserAgent(String ua) {
		this.getHttpClient().getParams().setParameter(AllClientPNames.USER_AGENT, ua);
	}

	private void setConnectionTimeout(int milliseconds) {
		this.getHttpClient().getParams().setIntParameter(AllClientPNames.CONNECTION_TIMEOUT, milliseconds);
	}

	private void setSocketTimeout(int milliseconds) {
		this.getHttpClient().getParams().setIntParameter(AllClientPNames.SO_TIMEOUT, milliseconds);
	}


	public String toString() {
		if (this.getClientSettings() != null)
		{
			return this.getClientSettings().toString();
		}
		else
		{
			return super.toString();
		}
	}
}

