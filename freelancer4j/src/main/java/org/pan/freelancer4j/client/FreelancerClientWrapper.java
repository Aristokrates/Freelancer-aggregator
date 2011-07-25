package org.pan.freelancer4j.client;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.pan.freelancer4j.exception.FreelancerClientException;
import org.pan.freelancer4j.model.project.FreelancerProjectList;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidList;
import org.pan.freelancer4j.model.project.details.FreelancerProjectDetails;
import org.pan.freelancer4j.model.user.FreelancerUserList;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetails;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.pan.freelancer4j.search.UserSearchCriteria;
import org.pan.freelancer4j.setting.FreelancerClientSettings;

/**
 * Freelancer client wrapper
 * <p>
 * Wraps the requests as search criteria and response as freelancer model
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerClientWrapper {

	private FreelancerClient client;
	

	public FreelancerClientWrapper(FreelancerClientSettings clientSettings) {
		client = new FreelancerClient(clientSettings);
	}

	public FreelancerProjectList searchProjectsByCriteria(ProjectSearchCriteria criteria) {
		
		Set<Entry<String, Object>> params = criteria.buildParameterEntrySet();
		return client.sendSearchProjectRequest(params, null).getProjectList();
	}
	
	public FreelancerProjectDetails getProjectDetailsByProjectId(Integer projectId) {
		
		if (projectId == null) {
			throw new FreelancerClientException("Project Id must be provided");
		}
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		Map.Entry<String, Object> projectIdEntry = new AbstractMap.SimpleEntry<String, Object>("projectid", projectId);
		params.add(projectIdEntry);
		return client.sendProjectDetailsRequest(params, null).getProjectDetails();		
	}
	
	public FreelancerProjectBidList getProjectBidDetails(Integer projectId) {
		
		if (projectId == null) {
			throw new FreelancerClientException("Project Id must be provided");
		}
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		Map.Entry<String, Object> projectIdEntry = new AbstractMap.SimpleEntry<String, Object>("projectid", projectId);
		params.add(projectIdEntry);		
		return client.sendProjectBidRequest(params, null).getBidList();
	}
	
    public FreelancerUserList searchUsersByCriteria(UserSearchCriteria criteria) {
    	
    	Set<Entry<String, Object>> params = criteria.buildParameterSetEntry();
		return client.sendSearchUserRequest(params, null).getUserList();  	
    }
    
    public FreelancerUserDetails getUserDetails(Integer userId, String username) {
    	
		Set<Map.Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		if (userId != null) {
			Map.Entry<String, Object> userIdEntry = new AbstractMap.SimpleEntry<String, Object>("userid", userId);
			params.add(userIdEntry);
		} else {
			if (username != null) {
				Map.Entry<String, Object> usernameEntry = new AbstractMap.SimpleEntry<String, Object>("username", username);
				params.add(usernameEntry);
			} else {
				throw new FreelancerClientException("UserId or username must be provided");
			}
		}
		return client.sendGetUserDetailsRequest(params, null).getUserDetails();

    }
    
    public void shutDownClient() {
    	client.shutdown();
    }
}
