package org.pan.freelancer.service.impl;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.pan.elance.client.ElanceClientWrapper;
import org.pan.elance.model.job.ElanceJobModel;
import org.pan.elance.model.provider.ElanceProviderModel;
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
	public List<ElanceJobModel> getProjectsByCriteria(ElanceJobSearchCriteria jobSearchCriteria) {
		return clientWrapper.searchJobsByCriteria(jobSearchCriteria);
	}

	@Override
	public List<ElanceProviderModel> getProvidersByCriteria(ElanceProviderSearchCriteria providerSearchCriteria) {
		return clientWrapper.searchProvidersByCriteria(providerSearchCriteria);
	}

	@Override
	public ElanceProviderDetailsModel getProviderDetailsById(Integer providerId) {
		return clientWrapper.getProviderDetailsById(providerId);
	}
}
