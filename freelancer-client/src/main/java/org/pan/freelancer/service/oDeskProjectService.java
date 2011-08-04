package org.pan.freelancer.service;

import org.pan.odesk.model.job.oDeskJobWrapper;
import org.pan.odesk.model.provider.oDeskProviderModel;
import org.pan.odesk.model.provider.oDeskProviderModelWrapper;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.pan.odesk.search.oDeskProviderSearchCriteria;

public interface oDeskProjectService {
	
	public oDeskJobWrapper getJobsByCriteria(oDeskJobSearchCriteria jobSearchCriteria);
	
	public oDeskProviderModelWrapper getProvidersByCriteria(oDeskProviderSearchCriteria providerSearchCriteria);
	
	public oDeskProviderModel getProviderById(String providerId);

}
