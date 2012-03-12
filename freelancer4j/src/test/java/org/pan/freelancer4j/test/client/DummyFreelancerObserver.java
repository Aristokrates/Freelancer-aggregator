package org.pan.freelancer4j.test.client;

import java.util.List;

import org.pan.freelancer4j.model.project.FreelancerCacheProject;
import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidEntity;
import org.pan.freelancer4j.scheduler.FreelancerObserver;

public class DummyFreelancerObserver implements FreelancerObserver {

	@Override
	public void notifyOnNewProject(List<FreelancerProject> projects) {
		System.out.println("Dummy notification on new projects: " + projects);
		
	}

	@Override
	public void notifyOnProjectStatusChange(List<FreelancerCacheProject> projects) {
		System.out.println("Dummy notification on project status change: " + projects);
		
	}

	@Override
	public void notifyOnNewBids(List<FreelancerProjectBidEntity> projectBidEntityList) {
		System.out.println("Dummy notification on new projects bids: " + projectBidEntityList);		
	}
	
	

}
