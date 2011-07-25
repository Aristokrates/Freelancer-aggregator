package org.pan.freelancer4j.scheduler;

import java.util.List;

import org.pan.freelancer4j.model.project.FreelancerCacheProject;
import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidEntity;

/**
 * Freelance observer interface
 * <p>
 * Observes for new projects, project status changes and new project bids
 * 
 * @author Pance.Isajeski
 *
 */
public interface FreelancerObserver {
	
	void notifyOnNewProject(List<FreelancerProject> projects);

	void notifyOnProjectStatusChange(List<FreelancerCacheProject> projects);
	
	void notifyOnNewBids(List<FreelancerProjectBidEntity> projectBidEntityList);
}
