package org.pan.freelancer.service;

import java.util.List;

import org.pan.elance.model.job.ElanceJobModel;
import org.pan.elance.model.provider.ElanceProviderModel;
import org.pan.elance.model.provider.details.ElanceProviderDetailsModel;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.pan.elance.search.ElanceProviderSearchCriteria;

public interface ElanceProjectService {

	public List<ElanceJobModel> getProjectsByCriteria(ElanceJobSearchCriteria jobSearchCriteria);
	
	public List<ElanceProviderModel> getProvidersByCriteria(ElanceProviderSearchCriteria providerSearchCriteria);
	
	public ElanceProviderDetailsModel getProviderDetailsById(Integer providerId);
	
}
