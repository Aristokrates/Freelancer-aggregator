package org.pan.freelancer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pan.freelancer.service.LinkedInProjectService;
import org.pan.linkedin.client.LinkedInClientWrapper;
import org.pan.linkedin.model.job.LinkedInJobModel;
import org.pan.linkedin.model.person.LinkedInPersonModel;
import org.pan.linkedin.model.person.details.LinkedInPersonDetailsModel;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.pan.linkedin.search.LinkedInPeopleSearchCriteria;
import org.springframework.stereotype.Service;

@Service("linkedinService")
public class LinkedInProjectServiceImpl implements LinkedInProjectService {
	
	@Resource
	private LinkedInClientWrapper clientWrapper;

	@Override
	public List<LinkedInJobModel> getJobsByCriteria(LinkedInJobSearchCriteria searchCriteria) {
		return clientWrapper.searchJobsByCriteria(searchCriteria);
	}

	@Override
	public List<LinkedInPersonModel> getProvidersByCriteria(LinkedInPeopleSearchCriteria searchCriteria) {
		return clientWrapper.searchPeopleByCriteria(searchCriteria);
	}

	@Override
	public LinkedInPersonDetailsModel getProviderDetailsById(String providerId) {
		return clientWrapper.getPersonDetails(providerId);
	}

}
