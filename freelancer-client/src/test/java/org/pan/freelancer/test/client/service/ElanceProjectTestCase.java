package org.pan.freelancer.test.client.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.pan.elance.model.job.ElanceJobModelWrapper;
import org.pan.elance.model.provider.ElanceProviderModelWrapper;
import org.pan.elance.model.provider.details.ElanceProviderDetailsModel;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.pan.elance.search.ElanceProviderSearchCriteria;
import org.pan.freelancer.service.ElanceProjectService;
import org.pan.freelancer.test.client.BaseTestCase;

public class ElanceProjectTestCase extends BaseTestCase {
	
	@Resource private ElanceProjectService elanceService;
	
	@Test
	public void testSearchProjects() {
		
		ElanceJobSearchCriteria jobSearchCriteria = new ElanceJobSearchCriteria();
		jobSearchCriteria.setKeyword("Java");
		
		ElanceJobModelWrapper jobModelWrapper = elanceService.getProjectsByCriteria(jobSearchCriteria);
		
		System.out.println(jobModelWrapper);
	}
	
	@Test
	public void testSearchProviders() {
		
		ElanceProviderSearchCriteria providerSearchCriteria = new ElanceProviderSearchCriteria();
		providerSearchCriteria.setKeyword("Java");
		
		ElanceProviderModelWrapper providerModelWrapper = elanceService.getProvidersByCriteria(providerSearchCriteria);
		
		System.out.println(providerModelWrapper);
	}
	
	@Test
	public void testGetProviderDetails() {
		
		Integer providerId = 2316742;
		
		ElanceProviderDetailsModel providerDetails = elanceService.getProviderDetailsById(providerId);
		
		System.out.println(providerDetails);
	}

}
