package org.pan.freelancer.test.client.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.pan.freelancer.service.FreelancerProjectService;
import org.pan.freelancer.test.client.BaseTestCase;
import org.pan.freelancer4j.model.FreelancerProjectState;
import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBid;
import org.pan.freelancer4j.model.project.details.FreelancerProjectDetails;
import org.pan.freelancer4j.model.user.FreelancerUser;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetails;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.pan.freelancer4j.search.UserSearchCriteria;

public class FreelancerProjectTestCase extends BaseTestCase {	
	
	@Resource private FreelancerProjectService freelancerService;
	
	@Test
	public void testSearchProjects() {
		
		ProjectSearchCriteria searchCriteria = new ProjectSearchCriteria();
		searchCriteria.setSearchkeyword("JAVA");
		searchCriteria.setProjectState(FreelancerProjectState.ACTIVE);
		searchCriteria.setSearchjobtypecsv(Arrays.asList("Java"));
		
		List<FreelancerProject> projects = freelancerService.getProjectsByCriteria(searchCriteria);
		
		System.out.println(projects);
	}
	
	@Test
	public void testGetProjectDetails() {
		
		Integer projectId = 611;
		FreelancerProjectDetails projectDetails = freelancerService.getProjectDetailsByProjectId(projectId);
		
		System.out.println(projectDetails);
	}
	
	@Test
	public void testProjectBids() {
		
		Integer projectId = 611;
		List<FreelancerProjectBid> projectBids = freelancerService.getProjectBidDetails(projectId);
		System.out.println(projectBids);
		
	}
	
	@Test
	public void testSearchUsers() {
		
		UserSearchCriteria searchCriteria = new UserSearchCriteria();
		searchCriteria.setCountryCsvs("United States,Romania");
		searchCriteria.setExpertiseCsvs("Java");
		List<FreelancerUser> freelancerUsers = freelancerService.getUsersByCriteria(searchCriteria);
		System.out.println(freelancerUsers);
	}
	
	@Test
	public void testGetUserDetails() {
		
		Integer userId = 1619881;
		FreelancerUserDetails freelancerUser = freelancerService.getUserDetails(userId, null);
		System.out.println(freelancerUser);
	}
	
}
