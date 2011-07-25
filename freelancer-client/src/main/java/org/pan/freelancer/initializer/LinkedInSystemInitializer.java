package org.pan.freelancer.initializer;

import org.pan.linkedin.scheduler.LinkedInGenericScheduler;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.springframework.beans.factory.InitializingBean;

public class LinkedInSystemInitializer implements InitializingBean {

	private LinkedInGenericScheduler linkedInScheduler;
	
	private LinkedInJobSearchCriteria jobSearchCriteria;
	
	private Long jobSchedulePeriod;
	
	private Boolean enabled = false;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		if (!enabled) {
			System.out.println("Linkedin scheduler not enabled");
			return;
		}
		
		linkedInScheduler.startJobScheduler(jobSearchCriteria, jobSchedulePeriod);
	}

	public void setLinkedInScheduler(LinkedInGenericScheduler linkedInScheduler) {
		this.linkedInScheduler = linkedInScheduler;
	}

	public void setJobSearchCriteria(LinkedInJobSearchCriteria jobSearchCriteria) {
		this.jobSearchCriteria = jobSearchCriteria;
	}

	public void setJobSchedulePeriod(Long jobSchedulePeriod) {
		this.jobSchedulePeriod = jobSchedulePeriod;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
