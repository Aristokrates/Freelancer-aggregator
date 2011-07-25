package org.pan.freelancer.service;

import java.util.List;

import org.pan.odesk.model.job.oDeskJobModel;
import org.pan.odesk.model.provider.oDeskProviderModel;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.pan.odesk.search.oDeskProviderSearchCriteria;

public interface oDeskProjectService {
	
	public List<oDeskJobModel> getJobsByCriteria(oDeskJobSearchCriteria jobSearchCriteria);
	
	public List<oDeskProviderModel> getProvidersByCriteria(oDeskProviderSearchCriteria providerSearchCriteria);

}
