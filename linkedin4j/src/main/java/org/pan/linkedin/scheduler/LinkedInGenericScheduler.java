package org.pan.linkedin.scheduler;

import java.util.ArrayList;
import java.util.Date;

import org.pan.linkedin.client.LinkedInClientWrapper;
import org.pan.linkedin.scheduler.job.LinkedInJobTrigger;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class LinkedInGenericScheduler {	
	
	private Scheduler scheduler;
	
	private LinkedInClientWrapper linkedInClient;
	
	private LinkedInObserver linkedInObserver;
	
	public LinkedInGenericScheduler() {

		super();

		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			scheduler = sf.getScheduler();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void destroy() {
		try {
			scheduler.shutdown(true);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void startJobScheduler(LinkedInJobSearchCriteria searchCriteria, Long timeDurationInMiliseconds) {
		
		try {
			checkValidityBeforeStart();
			JobDetail job = new JobDetail("linkedinJobPuller", "linkedinJobGroup", LinkedInJobTrigger.class);
			job.getJobDataMap().put("observer", linkedInObserver);
			job.getJobDataMap().put("client", linkedInClient);
			job.getJobDataMap().put("criteria", searchCriteria);
			job.getJobDataMap().put("jobCache", new ArrayList<String>());			
			job.setVolatility(true);
			
			SimpleTrigger trigger = new SimpleTrigger("linkedinJobTrigger",
					"linkedinJobGroup",
					new Date(),
					null,
					SimpleTrigger.REPEAT_INDEFINITELY,
					timeDurationInMiliseconds);

			scheduler.scheduleJob(job, trigger);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}	


	public void endProjectScheduler() {

		try {
			scheduler.pauseTrigger("linkedinJobTrigger", "linkedinJobGroup");
			
		} catch (SchedulerException e) {
			throw new RuntimeException();
		}
	}
	

	private void checkValidityBeforeStart() throws SchedulerException {
		
		if (linkedInClient == null) {
			throw new RuntimeException();
		}
		if (linkedInObserver == null) {
			throw new RuntimeException();
		}
		
		if (!scheduler.isStarted()) {
			scheduler.start();
		}
		
	}

	public void setLinkedInClient(LinkedInClientWrapper linkedInClient) {
		this.linkedInClient = linkedInClient;
	}

	public void setLinkedInObserver(LinkedInObserver linkedInObserver) {
		this.linkedInObserver = linkedInObserver;
	}

}
