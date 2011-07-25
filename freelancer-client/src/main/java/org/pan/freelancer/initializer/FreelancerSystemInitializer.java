package org.pan.freelancer.initializer;

import java.util.ArrayList;
import java.util.List;

import org.pan.freelancer4j.scheduler.FreelancerGenericScheduler;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

/**
 * Freelancer.com initializer
 * <p>
 * Initializes freelancer project and project bid scheduling
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerSystemInitializer implements InitializingBean {
	
	private FreelancerGenericScheduler scheduler;
	private List<Integer> projectIds = new ArrayList<Integer>();
	private Long projectSchedulePeriod;
	private Long projectBidSchedulePeriod;
	private ProjectSearchCriteria initialProjectSearchCriteria;
	
	private Boolean enabled = false;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		if (!enabled) {
			System.out.println("Freelancer scheduler not enabled");
			return;
		}
		
		scheduler.startProjectScheduler(initialProjectSearchCriteria, projectSchedulePeriod);
		scheduler.startProjectBidScheduler(projectIds, projectBidSchedulePeriod);
	}

	@Required
	public void setScheduler(FreelancerGenericScheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Required
	public void setProjectIds(List<Integer> projectIds) {
		this.projectIds = projectIds;
	}

	@Required
	public void setProjectSchedulePeriod(Long projectSchedulePeriod) {
		this.projectSchedulePeriod = projectSchedulePeriod;
	}

	@Required
	public void setProjectBidSchedulePeriod(Long projectBidSchedulePeriod) {
		this.projectBidSchedulePeriod = projectBidSchedulePeriod;
	}

	@Required
	public void setInitialProjectSearchCriteria(
			ProjectSearchCriteria initialProjectSearchCriteria) {
		this.initialProjectSearchCriteria = initialProjectSearchCriteria;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}	
	
}
