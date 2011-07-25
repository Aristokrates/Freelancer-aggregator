package org.pan.freelancer.test.client.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.pan.freelancer.service.oDeskProjectService;
import org.pan.freelancer.test.client.BaseTestCase;
import org.pan.odesk.model.job.oDeskJobModel;
import org.pan.odesk.model.provider.oDeskProviderModel;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.pan.odesk.search.oDeskProviderSearchCriteria;

public class oDeskProjectTestCase extends BaseTestCase {
	
	@Resource private oDeskProjectService oDeskService;
	
	@Test
	public void testSearchJobs() {
		
		oDeskJobSearchCriteria searchCriteria = new oDeskJobSearchCriteria();
		searchCriteria.setJobCategory("Web Development");
		searchCriteria.setJobType("Hourly");
		List<oDeskJobModel> oDeskJobs = oDeskService.getJobsByCriteria(searchCriteria);
		System.out.println(oDeskJobs);
	}
	
	@Test
	public void testSearchProviders() {
		
		oDeskProviderSearchCriteria searchCriteria = new oDeskProviderSearchCriteria();
		searchCriteria.setJobCategory("Web Development");
		
		List<oDeskProviderModel> providers = oDeskService.getProvidersByCriteria(searchCriteria);
		
		System.out.println(providers);
	}
}
