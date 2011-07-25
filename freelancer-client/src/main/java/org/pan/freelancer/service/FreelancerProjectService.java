package org.pan.freelancer.service;

import java.util.List;

import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBid;
import org.pan.freelancer4j.model.project.details.FreelancerProjectDetails;
import org.pan.freelancer4j.model.user.FreelancerUser;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetails;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.pan.freelancer4j.search.UserSearchCriteria;


public interface FreelancerProjectService {
	
	List<FreelancerProject> getProjectsByCriteria(ProjectSearchCriteria projectCriteria);
	
	FreelancerProjectDetails getProjectDetailsByProjectId(Integer projectId);
	
	List<FreelancerProjectBid> getProjectBidDetails(Integer projectId);
	
	List<FreelancerUser> getUsersByCriteria(UserSearchCriteria userCriteria);
	
	FreelancerUserDetails getUserDetails(Integer userId, String username);
}
