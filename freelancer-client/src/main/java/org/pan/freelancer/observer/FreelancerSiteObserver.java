package org.pan.freelancer.observer;

import java.util.List;

import org.pan.freelancer4j.model.project.FreelancerCacheProject;
import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidEntity;
import org.pan.freelancer4j.scheduler.FreelancerObserver;

/**
 * Freelancer Observer Implementation
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerSiteObserver implements FreelancerObserver {

	@Override
	public void notifyOnProjectStatusChange(List<FreelancerCacheProject> projects) {
		System.out.println("Freelancer notification on project status change: " + projects);
		
	}

	@Override
	public void notifyOnNewBids(List<FreelancerProjectBidEntity> projectBidEntityList) {
		System.out.println("Freelancer notification on new projects bids: " + projectBidEntityList);	
		
	}

	@Override
	public void notifyOnNewProject(List<FreelancerProject> projects) {
		System.out.println("Freelancer notification on new projects: " + projects);		
	}

}
