package org.pan.freelancer.service.impl;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.pan.elance.client.ElanceClientWrapper;
import org.pan.elance.model.job.ElanceJobModelWrapper;
import org.pan.elance.model.provider.ElanceProviderModelWrapper;
import org.pan.elance.model.provider.details.ElanceProviderDetailsModel;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.pan.elance.search.ElanceProviderSearchCriteria;
import org.pan.freelancer.service.ElanceProjectService;
import org.springframework.stereotype.Service;

@Service("elanceService")
public class ElanceProjectServiceImpl implements ElanceProjectService {
	
	@Resource
	private ElanceClientWrapper clientWrapper;
	
	@PreDestroy
	public void destroy() {
		clientWrapper.shutdownClient();
	}

	@Override
	public ElanceJobModelWrapper getProjectsByCriteria(ElanceJobSearchCriteria jobSearchCriteria) {
		return clientWrapper.searchJobsByCriteria(jobSearchCriteria);
	}

	@Override
	public ElanceProviderModelWrapper getProvidersByCriteria(ElanceProviderSearchCriteria providerSearchCriteria) {
		return clientWrapper.searchProvidersByCriteria(providerSearchCriteria);
	}

	@Override
	public ElanceProviderDetailsModel getProviderDetailsById(Integer providerId) {
		return clientWrapper.getProviderDetailsById(providerId);
	}
}
