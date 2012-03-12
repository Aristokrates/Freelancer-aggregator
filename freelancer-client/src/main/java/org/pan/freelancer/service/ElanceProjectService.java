package org.pan.freelancer.service;

import org.pan.elance.model.job.ElanceJobModelWrapper;
import org.pan.elance.model.provider.ElanceProviderModelWrapper;
import org.pan.elance.model.provider.details.ElanceProviderDetailsModel;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.pan.elance.search.ElanceProviderSearchCriteria;

public interface ElanceProjectService {

	public ElanceJobModelWrapper getProjectsByCriteria(ElanceJobSearchCriteria jobSearchCriteria);
	
	public ElanceProviderModelWrapper getProvidersByCriteria(ElanceProviderSearchCriteria providerSearchCriteria);
	
	public ElanceProviderDetailsModel getProviderDetailsById(Integer providerId);
	
}
