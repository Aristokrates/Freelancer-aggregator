package org.pan.linkedin.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.pan.linkedin.model.job.LinkedInJobModel;
import org.pan.linkedin.model.person.LinkedInPersonModel;
import org.pan.linkedin.model.person.details.LinkedInPersonDetailsModel;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.pan.linkedin.search.LinkedInPeopleSearchCriteria;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.enumeration.JobField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.Jobs;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;

/**
 * Client wrapper for LinkedIn client
 * 
 * @author Pance.Isajeski
 *
 */
public class LinkedInClientWrapper {

	private LinkedInApiClient linkedInApiClient;

	public LinkedInClientWrapper(String consumerKey, String consumerSecret, String token, String tokenSecret) {

		LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKey, consumerSecret);
		linkedInApiClient = factory.createLinkedInApiClient(token, tokenSecret);
	}

	public List<LinkedInJobModel> searchJobsByCriteria(LinkedInJobSearchCriteria searchCriteria) {

		Map<SearchParameter, String> searchParameters = searchCriteria.buildSearchParameterMap();
		List<Parameter<FacetType, String>> facets = searchCriteria.buildSearchFacets();		
		Integer start = searchCriteria.getStart();
		Integer count = searchCriteria.getCount();

		Jobs jobs = linkedInApiClient.searchJobs(searchParameters, buildJobFieldSet(false), start, count, facets);
		List<Job> jobList = jobs.getJobList();
		return buildModelFromJobList(jobList);

	}

	public List<LinkedInPersonModel> searchPeopleByCriteria(LinkedInPeopleSearchCriteria searchCriteria) {

		Map<SearchParameter, String> searchParameters = searchCriteria.buildSearchParameterMap();
		List<Parameter<FacetType, String>> facets = searchCriteria.buildSearchFacets();		
		Integer start = searchCriteria.getStart();
		Integer count = searchCriteria.getCount();

		People people = linkedInApiClient.searchPeople(searchParameters, buildProfileFieldSet(true), start, count, facets);

		return buildModelFromPersonList(people.getPersonList());
	}	
	
	public LinkedInPersonDetailsModel getPersonDetails(String personId) {
		
		Person person = linkedInApiClient.getProfileById(personId, buildProfileFieldSet(true));
		return buildModelFromPersonDetails(person);
	}

	private Set<JobField> buildJobFieldSet(boolean onlyId) {

		Set<JobField> jobFields = new HashSet<JobField>();
		jobFields.add(JobField.ID);

		if (!onlyId) {

			jobFields.add(JobField.CUSTOMER_JOB_CODE);
			jobFields.add(JobField.DESCRIPTION);

			jobFields.add(JobField.ACTIVE);
			jobFields.add(JobField.POSTING_TIMESTAMP);
			jobFields.add(JobField.EXPIRATION_TIMESTAMP);

			jobFields.add(JobField.COMPANY);

			jobFields.add(JobField.POSITION);
			jobFields.add(JobField.POSITION_EXPERIENCE_LEVEL);
			jobFields.add(JobField.POSITION_INDUSTRIES);
			jobFields.add(JobField.POSITION_JOB_FUNCTIONS);
			jobFields.add(JobField.POSITION_JOB_TYPE);
			jobFields.add(JobField.POSITION_LOCATION);
			jobFields.add(JobField.POSITION_TITLE);

			jobFields.add(JobField.SITE_JOB_URL);
			jobFields.add(JobField.LOCATION_DESCRIPTION);
			jobFields.add(JobField.SKILLS_AND_EXPERIENCE);
			jobFields.add(JobField.SALARY);
			jobFields.add(JobField.JOB_POSTER);
		}

		return jobFields;
	}

	private Set<ProfileField> buildProfileFieldSet(boolean detailView) {

		Set<ProfileField> profileFields = new HashSet<ProfileField>();
		profileFields.add(ProfileField.ID);
		profileFields.add(ProfileField.FIRST_NAME);
		profileFields.add(ProfileField.LAST_NAME);
		profileFields.add(ProfileField.SUMMARY);
		profileFields.add(ProfileField.SPECIALTIES);
		profileFields.add(ProfileField.PUBLIC_PROFILE_URL);
		
		if (detailView) {
			profileFields.add(ProfileField.SKILLS);
			profileFields.add(ProfileField.INDUSTRY);
			profileFields.add(ProfileField.POSITIONS);
			profileFields.add(ProfileField.LOCATION);
		}
		

		return profileFields;
	}

	private List<LinkedInJobModel> buildModelFromJobList(List<Job> jobList) {

		List<LinkedInJobModel> jobListModel = new ArrayList<LinkedInJobModel>();

		for (Job job : jobList) {
			LinkedInJobModel jobModel = new LinkedInJobModel(job);
			jobListModel.add(jobModel);
		}
		return jobListModel;
	}
	

	private List<LinkedInPersonModel> buildModelFromPersonList(List<Person> personList) {

		List<LinkedInPersonModel> personListModel = new ArrayList<LinkedInPersonModel>();

		for (Person person : personList) {
			LinkedInPersonModel personModel = new LinkedInPersonModel(person);
			personListModel.add(personModel);
		}
		return personListModel;
	}
	

	private LinkedInPersonDetailsModel buildModelFromPersonDetails(Person person) {

		return new LinkedInPersonDetailsModel(person);
	}
}
