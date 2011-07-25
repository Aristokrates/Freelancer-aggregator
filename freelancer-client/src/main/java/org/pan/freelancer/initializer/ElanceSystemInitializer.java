package org.pan.freelancer.initializer;

import org.pan.elance.scheduler.ElanceScheduler;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

/**
 * Elance initializer
 * <p>
 * Initializes elance job scheduler
 * 
 * @author Pance.Isajeski
 *
 */
public class ElanceSystemInitializer implements InitializingBean {
	
	private ElanceScheduler elanceScheduler;
	
	private ElanceJobSearchCriteria jobSearchCriteria;
	
	private Long jobSchedulePeriod;
	
	private Boolean enabled = false;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		if (!enabled) {
			System.out.println("Elance scheduler not enabled");
			return;
		}
		
		elanceScheduler.startJobScheduler(jobSearchCriteria, jobSchedulePeriod);
	}

	@Required
	public void setElanceScheduler(ElanceScheduler elanceScheduler) {
		this.elanceScheduler = elanceScheduler;
	}

	@Required
	public void setJobSearchCriteria(ElanceJobSearchCriteria jobSearchCriteria) {
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
