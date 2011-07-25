package org.pan.freelancer.test.client.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.pan.elance.model.job.ElanceJobModel;
import org.pan.elance.model.provider.ElanceProviderModel;
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
		
		List<ElanceJobModel> elanceJobSearchResult = elanceService.getProjectsByCriteria(jobSearchCriteria);
		
		System.out.println(elanceJobSearchResult);
	}
	
	@Test
	public void testSearchProviders() {
		
		ElanceProviderSearchCriteria providerSearchCriteria = new ElanceProviderSearchCriteria();
		providerSearchCriteria.setKeyword("Java");
		
		List<ElanceProviderModel> providers = elanceService.getProvidersByCriteria(providerSearchCriteria);
		
		System.out.println(providers);
	}
	
	@Test
	public void testGetProviderDetails() {
		
		Integer providerId = 2316742;
		
		ElanceProviderDetailsModel providerDetails = elanceService.getProviderDetailsById(providerId);
		
		System.out.println(providerDetails);
	}

}
