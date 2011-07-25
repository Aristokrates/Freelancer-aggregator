package org.pan.freelancer4j.test.client;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.pan.freelancer4j.client.FreelancerClientWrapper;
import org.pan.freelancer4j.model.project.FreelancerProjectList;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidList;
import org.pan.freelancer4j.model.project.details.FreelancerProjectDetails;
import org.pan.freelancer4j.model.user.FreelancerUserList;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetails;
import org.pan.freelancer4j.scheduler.FreelancerGenericScheduler;
import org.pan.freelancer4j.scheduler.FreelancerObserver;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.pan.freelancer4j.search.UserSearchCriteria;
import org.pan.freelancer4j.setting.FreelancerClientSettings;
import org.pan.freelancer4j.test.BaseTestCase;
import org.pan.freelancer4j.token.FreelancerAccessToken;
import org.pan.freelancer4j.token.FreelancerConsumerToken;

public class FreelanceClientWrapperTestCase extends BaseTestCase {
	
	private FreelancerClientWrapper freelancerClientWrapper;
	
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
		freelancerClientWrapper = new FreelancerClientWrapper(settings);
	}
	
	
	@Test
	public void testUserSearch() {	

		UserSearchCriteria userSearchCriteria = new UserSearchCriteria();
		userSearchCriteria.setCount(200);
		userSearchCriteria.setPage(0);
		userSearchCriteria.setExpertiseCsvs("JAVA");
		FreelancerUserList userList = freelancerClientWrapper.searchUsersByCriteria(userSearchCriteria);
		System.out.println(userList);
	}
	
	@Test
	public void testGetUserDetails() {	
		
		FreelancerUserDetails userDetails = freelancerClientWrapper.getUserDetails(1620264, null);
		System.out.println(userDetails);
	}
	
	@Test
	public void testProjectSearch() {
		
		ProjectSearchCriteria projectSearchCriteria = new ProjectSearchCriteria();
		projectSearchCriteria.setPage(0);
		projectSearchCriteria.setCount(200);
		projectSearchCriteria.setIsfulltime(Boolean.TRUE);
		
		
		FreelancerProjectList projectList = freelancerClientWrapper.searchProjectsByCriteria(projectSearchCriteria);
		FreelancerProjectList overralProjectList = new FreelancerProjectList(projectList.getCount(), projectList.getProjects());
		
		Integer size = projectList.getCount();
		
		while (size.equals(projectSearchCriteria.getCount())) {
			projectSearchCriteria.setPage(projectSearchCriteria.getPage() + 1);
			FreelancerProjectList tempProjectList = freelancerClientWrapper.searchProjectsByCriteria(projectSearchCriteria);
			overralProjectList.setCount(overralProjectList.getCount() + tempProjectList.getCount());
			overralProjectList.getProjects().addAll(tempProjectList.getProjects());
			size = tempProjectList.getCount();
		}
		
		System.out.println(overralProjectList);
	
	}
	
	@Test
	public void testProjectDetails() {
		FreelancerProjectDetails projectDetails = freelancerClientWrapper.getProjectDetailsByProjectId(150);
		System.out.println(projectDetails.getStateEnum());
		System.out.println(projectDetails.getCurrencyEnum());
	}
	
	@Test
	public void testProjectBidDetails() {
		
		FreelancerProjectBidList bidList = freelancerClientWrapper.getProjectBidDetails(150);
		System.out.println(bidList);
	}
	
	@Test
	public void testScheduler() {
		FreelancerGenericScheduler scheduler = new FreelancerGenericScheduler();
		scheduler.setFreelancerClient(freelancerClientWrapper);
		DummyFreelancerObserver observer = new DummyFreelancerObserver();
		scheduler.setFreelancerObserver(observer);
		scheduler.startProjectScheduler(new ProjectSearchCriteria(), 5L * 1000L);
		scheduler.startProjectBidScheduler(Arrays.asList(694), 12L * 1000L);
		while (true) {
			
		}
	}
}
