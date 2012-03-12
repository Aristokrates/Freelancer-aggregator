package org.pan.odesk.scheduler;

import java.util.Date;
import java.util.HashMap;

import org.pan.odesk.client.oDeskClientWrapper;
import org.pan.odesk.model.job.oDeskCacheJob;
import org.pan.odesk.scheduler.job.oDeskJobTrigger;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * oDesk quartz scheduler
 * <p>
 * Used for triggering and pausing periodically tasks for pulling jobs from oDesk
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskScheduler {
	
	private Scheduler scheduler;
	
	private oDeskClientWrapper oDeskClient;
	
	private oDeskObserver oDeskObserver;
	
	public oDeskScheduler() {

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
	
	public void startJobScheduler(oDeskJobSearchCriteria searchCriteria, Long timeDurationInMiliseconds) {
		
		try {
			checkValidityBeforeStart();
			JobDetail job = new JobDetail("jobPuller", "jobGroup", oDeskJobTrigger.class);
			job.getJobDataMap().put("observer", oDeskObserver);
			job.getJobDataMap().put("client", oDeskClient);
			job.getJobDataMap().put("criteria", searchCriteria);
			job.getJobDataMap().put("checkpointDate", null);
			job.getJobDataMap().put("jobCache", new HashMap<Integer, oDeskCacheJob>());			
			job.setVolatility(true);
			
			SimpleTrigger trigger = new SimpleTrigger("jobTrigger",
					"jobGroup",
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
			scheduler.pauseTrigger("jobTrigger", "jobGroup");
			
		} catch (SchedulerException e) {
			throw new RuntimeException();
		}
	}
	

	private void checkValidityBeforeStart() throws SchedulerException {
		
		if (oDeskClient == null) {
			throw new RuntimeException();
		}
		if (oDeskObserver == null) {
			throw new RuntimeException();
		}
		
		if (!scheduler.isStarted()) {
			scheduler.start();
		}
		
	}

	public void setoDeskClient(oDeskClientWrapper oDeskClient) {
		this.oDeskClient = oDeskClient;
	}

	public void setoDeskObserver(oDeskObserver oDeskObserver) {
		this.oDeskObserver = oDeskObserver;
	}
}
