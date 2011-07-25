package org.pan.freelancer4j.test.client;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.pan.freelancer4j.client.FreelancerClient;
import org.pan.freelancer4j.model.project.FreelancerProjectWrapper;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidWrapper;
import org.pan.freelancer4j.model.project.details.FreelancerProjectDetailsWrapper;
import org.pan.freelancer4j.model.user.FreelancerUserWrapper;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetailsWrapper;
import org.pan.freelancer4j.setting.FreelancerClientSettings;
import org.pan.freelancer4j.test.BaseTestCase;
import org.pan.freelancer4j.token.FreelancerAccessToken;
import org.pan.freelancer4j.token.FreelancerConsumerToken;
import org.pan.freelancer4j.token.FreelancerRequestToken;

public class FreelancerClientTestCase extends BaseTestCase {
	
	private FreelancerClient freelancerClient;
	
	@Before
	public void initClient() {
		
		FreelancerClientSettings settings = new FreelancerClientSettings();
		
		settings.setAuthRequestTokenUrl(props.getProperty("requestTokenUrl"));
		settings.setAuthAuthorizeUrl(props.getProperty("authorizeUrl"));
		settings.setAuthAccessTokenUrl(props.getProperty("accessTokenUrl"));
		settings.setAuthCallbackUrl(props.getProperty("callbackUrl"));
		settings.setProjectEndpointUrl(props.getProperty("projectEndpointUrl"));
		settings.setUserEndpointUrl(props.getProperty("userEndpointUrl"));
		settings.setUserDetailsEndpointUrl(props.getProperty("userDetailsEndpointUrl"));
		settings.setProjectDetailsUrl(props.getProperty("projectDetails"));
		settings.setProjectBidDetailsUrl(props.getProperty("projectBidsDetails"));
		settings.setConsumerToken(new FreelancerConsumerToken(props.getProperty("consumerKey"), props.getProperty("consumerSecret")));
		settings.setAccessToken(new FreelancerAccessToken(props.getProperty("accessToken"), props.getProperty("accessTokenSecret")));
		freelancerClient = new FreelancerClient(settings);
		
	}
	
	@Test
	@Ignore
	public void testTokenRetrieval() {
		String authUrl = freelancerClient.getUserAuthorizationUrl();
		System.out.println(authUrl);
	}
	
	@Test
	@Ignore
	public void testAccesTokenTokenRetrieval() {
		freelancerClient.setRequestToken(new FreelancerRequestToken("5331609ffc079d2d25eae212b78006fd501e0cfc", 
				"c66e7a9bb49353503d42f807f8597f54c319bcad"));
		
		FreelancerAccessToken token = freelancerClient.fetchAccessToken("2bd81c619580404cebbfd24bedda9b2930d4840d");

		System.out.println("Access token: " + token);
	}
	
	@Test
	public void testUserSearch() {	
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		Map.Entry<String, Object> countEntry = new AbstractMap.SimpleEntry<String, Object>("count", 200);
		Map.Entry<String, Object> pageEntry = new AbstractMap.SimpleEntry<String, Object>("page", 1);

		params.add(countEntry);
		params.add(pageEntry);
		FreelancerUserWrapper entity = freelancerClient.sendSearchUserRequest(params, null);
		System.out.println(entity);
	}
	
	@Test
	public void testGetUserDetails() {	
		
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		Map.Entry<String, Object> userIdEntry = new AbstractMap.SimpleEntry<String, Object>("userid", 1620264);
		params.add(userIdEntry);	
		FreelancerUserDetailsWrapper entity = freelancerClient.sendGetUserDetailsRequest(params, null);
		System.out.println(entity);
	}
	
	@Test
	public void testProjectSearch() {
		
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		Map.Entry<String, Object> pageEntry = new AbstractMap.SimpleEntry<String, Object>("pg", 0);
		Map.Entry<String, Object> countEntry = new AbstractMap.SimpleEntry<String, Object>("count", 200);
		params.add(pageEntry);	
		params.add(countEntry);
		FreelancerProjectWrapper entity = freelancerClient.sendSearchProjectRequest(params, null);
		System.out.println(entity);
	}
	
	@Test
	public void testProjectDetails() {
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		Map.Entry<String, Object> projectIdEntry = new AbstractMap.SimpleEntry<String, Object>("projectid", 279);
		params.add(projectIdEntry);
		FreelancerProjectDetailsWrapper entity = freelancerClient.sendProjectDetailsRequest(params, null);
		System.out.println(entity);
	}
	
	@Test
	public void testProjectBidDetails() {
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		Map.Entry<String, Object> projectIdEntry = new AbstractMap.SimpleEntry<String, Object>("projectid", 279);
		Map.Entry<String, Object> pageEntry = new AbstractMap.SimpleEntry<String, Object>("pg", 0);
		Map.Entry<String, Object> countEntry = new AbstractMap.SimpleEntry<String, Object>("count", 200);
		params.add(projectIdEntry);		
		params.add(pageEntry);		
		params.add(countEntry);	
		FreelancerProjectBidWrapper entity = freelancerClient.sendProjectBidRequest(params, null);
		System.out.println(entity);
	}
	
	@After
	public void shutdown() {
		freelancerClient.shutdown();
	}
}
