package org.pan.elance.scheduler;

import java.util.ArrayList;
import java.util.Date;

import org.pan.elance.client.ElanceClientWrapper;
import org.pan.elance.scheduler.job.ElanceJobTrigger;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Elance quartz scheduler
 * <p>
 * Used for triggering and pausing periodically tasks for pulling jobs
 * 
 * @author Pance.Isajeski
 *
 */
public class ElanceScheduler {
	
	private Scheduler scheduler;
	
	private ElanceClientWrapper elanceClient;
	
	private ElanceObserver elanceObserver;
	
	public ElanceScheduler() {

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
			elanceClient.shutdownClient();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void startJobScheduler(ElanceJobSearchCriteria searchCriteria, Long timeDurationInMiliseconds) {
		
		try {
			checkValidityBeforeStart();
			JobDetail job = new JobDetail("elanceJobPuller", "elanceJobGroup", ElanceJobTrigger.class);
			job.getJobDataMap().put("observer", elanceObserver);
			job.getJobDataMap().put("client", elanceClient);
			job.getJobDataMap().put("criteria", searchCriteria);
			job.getJobDataMap().put("jobCache", new ArrayList<String>());			
			job.setVolatility(true);
			
			SimpleTrigger trigger = new SimpleTrigger("elanceJobTrigger",
					"elanceJobGroup",
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
			scheduler.pauseTrigger("elanceJobTrigger", "elanceJobGroup");
			
		} catch (SchedulerException e) {
			throw new RuntimeException();
		}
	}
	

	private void checkValidityBeforeStart() throws SchedulerException {
		
		if (elanceClient == null) {
			throw new RuntimeException();
		}
		if (elanceObserver == null) {
			throw new RuntimeException();
		}
		
		if (!scheduler.isStarted()) {
			scheduler.start();
		}
		
	}

	public void setElanceClient(ElanceClientWrapper elanceClient) {
		this.elanceClient = elanceClient;
	}

	public void setElanceObserver(ElanceObserver elanceObserver) {
		this.elanceObserver = elanceObserver;
	}
	
}
