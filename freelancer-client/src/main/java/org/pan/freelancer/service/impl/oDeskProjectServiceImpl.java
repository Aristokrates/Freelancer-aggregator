package org.pan.freelancer.service.impl;

import javax.annotation.Resource;

import org.pan.freelancer.service.oDeskProjectService;
import org.pan.odesk.client.oDeskClientWrapper;
import org.pan.odesk.model.job.oDeskJobWrapper;
import org.pan.odesk.model.provider.oDeskProviderModel;
import org.pan.odesk.model.provider.oDeskProviderModelWrapper;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.pan.odesk.search.oDeskProviderSearchCriteria;
import org.springframework.stereotype.Service;

@Service("oDeskService")
public class oDeskProjectServiceImpl implements oDeskProjectService {
	
	@Resource
	private oDeskClientWrapper clientWrapper;

	@Override
	public oDeskJobWrapper getJobsByCriteria(oDeskJobSearchCriteria jobSearchCriteria) {
		return clientWrapper.searchJobsByCriteria(jobSearchCriteria);
	}

	@Override
	public oDeskProviderModelWrapper getProvidersByCriteria(oDeskProviderSearchCriteria providerSearchCriteria) {
		return clientWrapper.searchProvidersByCriteria(providerSearchCriteria);
	}

	@Override
	public oDeskProviderModel getProviderById(String providerId) {
		return clientWrapper.getProviderById(providerId);
	}
}
