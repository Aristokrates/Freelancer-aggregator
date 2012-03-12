package org.pan.freelancer.initializer;

import org.pan.odesk.scheduler.oDeskScheduler;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

/**
 * oDesk initializer
 * <p>
 * Initializes oDesk job scheduling
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskSystemInitializer implements InitializingBean {
	
	private oDeskScheduler oDeskScheduler;
	
	private oDeskJobSearchCriteria jobSearchCriteria;
	
	private Long jobSchedulePeriod;
	
	private Boolean enabled;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		if (!enabled) {
			System.out.println("oDesk scheduler not enabled");
			return;
		}
		
		oDeskScheduler.startJobScheduler(jobSearchCriteria, jobSchedulePeriod);
	}

	@Required
	public void setoDeskScheduler(oDeskScheduler oDeskScheduler) {
		this.oDeskScheduler = oDeskScheduler;
	}

	@Required
	public void setJobSearchCriteria(oDeskJobSearchCriteria jobSearchCriteria) {
		this.jobSearchCriteria = jobSearchCriteria;
	}

	@Required
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
