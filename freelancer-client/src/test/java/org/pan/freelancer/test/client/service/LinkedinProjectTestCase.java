package org.pan.freelancer.test.client.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.pan.freelancer.service.LinkedInProjectService;
import org.pan.freelancer.test.client.BaseTestCase;
import org.pan.linkedin.model.job.LinkedInJobModel;
import org.pan.linkedin.model.person.LinkedInPersonModel;
import org.pan.linkedin.model.person.details.LinkedInPersonDetailsModel;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.pan.linkedin.search.LinkedInPeopleSearchCriteria;

public class LinkedinProjectTestCase extends BaseTestCase {
	
	@Resource private LinkedInProjectService linkedinService;
	
	@Test
	public void testSearchJobs() {
		
		LinkedInJobSearchCriteria searchCriteria = new LinkedInJobSearchCriteria();
		searchCriteria.setCountryCode("fr");
		
		List<LinkedInJobModel> jobs = linkedinService.getJobsByCriteria(searchCriteria);
		
		System.out.println(jobs);
	}
	
	@Test
	public void testSearchProviders() {
		
		LinkedInPeopleSearchCriteria searchCriteria = new LinkedInPeopleSearchCriteria();
		searchCriteria.setKeywords("Java");
		searchCriteria.setCountryCode("fr");
		
		List<LinkedInPersonModel> people = linkedinService.getProvidersByCriteria(searchCriteria);
		
		System.out.println(people);
	}
	
	@Test
	public void testGetProviderDetails() {
		
		String providerId = "uklPy6rc4h";
		LinkedInPersonDetailsModel modelDetails = linkedinService.getProviderDetailsById(providerId);
		System.out.println(modelDetails);
	}

}
