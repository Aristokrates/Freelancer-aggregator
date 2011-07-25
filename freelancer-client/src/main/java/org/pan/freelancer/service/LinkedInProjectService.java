package org.pan.freelancer.service;

import java.util.List;

import org.pan.linkedin.model.job.LinkedInJobModel;
import org.pan.linkedin.model.person.LinkedInPersonModel;
import org.pan.linkedin.model.person.details.LinkedInPersonDetailsModel;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.pan.linkedin.search.LinkedInPeopleSearchCriteria;

public interface LinkedInProjectService {
	
	public List<LinkedInJobModel> getJobsByCriteria(LinkedInJobSearchCriteria searchCriteria);

	public List<LinkedInPersonModel> getProvidersByCriteria(LinkedInPeopleSearchCriteria searchCriteria);

	public LinkedInPersonDetailsModel getProviderDetailsById(String providerId);
}
