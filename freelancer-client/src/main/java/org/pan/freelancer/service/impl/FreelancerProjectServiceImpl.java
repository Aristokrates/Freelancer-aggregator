package org.pan.freelancer.service.impl;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.pan.freelancer.service.FreelancerProjectService;
import org.pan.freelancer4j.client.FreelancerClientWrapper;
import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBid;
import org.pan.freelancer4j.model.project.details.FreelancerProjectDetails;
import org.pan.freelancer4j.model.user.FreelancerUser;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetails;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.pan.freelancer4j.search.UserSearchCriteria;
import org.springframework.stereotype.Service;

@Service("freelancerService")
public class FreelancerProjectServiceImpl implements FreelancerProjectService {
	
	@Resource
	private FreelancerClientWrapper freelancerClient;
	
	@PreDestroy
	public void destroy() {
		freelancerClient.shutDownClient();
	}

	@Override
	public List<FreelancerProject> getProjectsByCriteria(
			ProjectSearchCriteria projectCriteria) {
		
		return freelancerClient.searchProjectsByCriteria(projectCriteria).getProjects();
	}

	@Override
	public FreelancerProjectDetails getProjectDetailsByProjectId(Integer projectId) {
		return freelancerClient.getProjectDetailsByProjectId(projectId);
	}

	@Override
	public List<FreelancerProjectBid> getProjectBidDetails(Integer projectId) {
		return freelancerClient.getProjectBidDetails(projectId).getFreelancerProjectBids();
	}

	@Override
	public List<FreelancerUser> getUsersByCriteria(
			UserSearchCriteria userCriteria) {

		return freelancerClient.searchUsersByCriteria(userCriteria).getUsers();
	}

	@Override
	public FreelancerUserDetails getUserDetails(Integer userId, String username) {
		return freelancerClient.getUserDetails(userId, username);
	}	
}
