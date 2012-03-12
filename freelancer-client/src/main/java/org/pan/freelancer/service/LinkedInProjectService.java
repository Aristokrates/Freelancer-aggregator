package org.pan.freelancer.service;

import org.pan.linkedin.model.job.LinkedInJobModelWrapper;
import org.pan.linkedin.model.person.LinkedInPersonModelWrapper;
import org.pan.linkedin.model.person.details.LinkedInPersonDetailsModel;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.pan.linkedin.search.LinkedInPeopleSearchCriteria;

public interface LinkedInProjectService {
	
	public LinkedInJobModelWrapper getJobsByCriteria(LinkedInJobSearchCriteria searchCriteria);

	public LinkedInPersonModelWrapper getProvidersByCriteria(LinkedInPeopleSearchCriteria searchCriteria);

	public LinkedInPersonDetailsModel getProviderDetailsById(String providerId);
}
