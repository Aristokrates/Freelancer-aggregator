package org.pan.linkedin.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.pan.linkedin.client.LinkedInClientWrapper;
import org.pan.linkedin.model.job.LinkedInJobModel;
import org.pan.linkedin.model.person.details.LinkedInPersonDetailsModel;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.pan.linkedin.search.LinkedInPeopleSearchCriteria;

@RunWith(BlockJUnit4ClassRunner.class)
public class LinkedInClientTest {
	
	public static final String consumerKey = "k8fwsds9ku0y";
	public static final String consumerSecret = "hrXxRsW1vxyNdvRU";
	
	public static final String token = "19c17c2d-9659-47e1-9c4c-86ef90378ea6";
	public static final String tokenSecret = "92fbc869-e54f-4ce7-8851-9e817c8e63a7";
	
	private LinkedInClientWrapper clientWrapper;
	
	@Before
	public void init() {
		clientWrapper = new LinkedInClientWrapper(consumerKey, consumerSecret, token, tokenSecret);
	}
	
	@Test
	public void testJobClient() {
		
		LinkedInJobSearchCriteria criteria = new LinkedInJobSearchCriteria();
		criteria.setCountryCode("fr");
		criteria.setCount(110);
		
		List<LinkedInJobModel> jobModelList = clientWrapper.searchJobsByCriteria(criteria).getLinkedinJobs();
		
		System.out.println(jobModelList);
		
	}
	
	@Test
	public void testPersonClient() {
		
		LinkedInPeopleSearchCriteria searchCriteria = new LinkedInPeopleSearchCriteria();
		searchCriteria.addCountryCode("en");
		
		clientWrapper.searchPeopleByCriteria(searchCriteria);
	}
	
	@Test
	public void testPersonDetails() {
		
		LinkedInPersonDetailsModel personDetails = clientWrapper.getPersonDetails("piCBUPTfjn");
		System.out.println(personDetails);
	}
	

}
