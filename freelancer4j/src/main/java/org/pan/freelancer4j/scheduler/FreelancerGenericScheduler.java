package org.pan.freelancer4j.scheduler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pan.freelancer4j.client.FreelancerClientWrapper;
import org.pan.freelancer4j.exception.FreelancerClientException;
import org.pan.freelancer4j.model.project.FreelancerCacheProject;
import org.pan.freelancer4j.model.project.bids.FreelancerCacheProjectBid;
import org.pan.freelancer4j.scheduler.job.FreelancerProjectBidJob;
import org.pan.freelancer4j.scheduler.job.FreelancerProjectJob;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Freelancer quartz scheduler
 * <p>
 * Triggering and pausing periodically tasks for pulling projects and project bids
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerGenericScheduler {	

	private Scheduler scheduler;
	
	private FreelancerClientWrapper freelancerClient;
	
	private FreelancerObserver freelancerObserver;

	public FreelancerGenericScheduler() {

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
			freelancerClient.shutDownClient();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setFreelancerClient(FreelancerClientWrapper freelancerClientWrapper) {
		this.freelancerClient = freelancerClientWrapper;
	}
	
	public void setFreelancerObserver(FreelancerObserver freelancerObserver) {
		this.freelancerObserver = freelancerObserver;
	}

	public void startProjectScheduler(ProjectSearchCriteria searchCriteria, Long timeDurationInMiliseconds) {
		
		try {
			checkValidityBeforeStart();
			JobDetail job = new JobDetail("projectJob", "projectGroup", FreelancerProjectJob.class);
			job.getJobDataMap().put("observer", freelancerObserver);
			job.getJobDataMap().put("client", freelancerClient);
			job.getJobDataMap().put("criteria", searchCriteria);
			job.getJobDataMap().put("projectCache", new HashMap<Integer, FreelancerCacheProject>());			
			job.setVolatility(true);
			
			SimpleTrigger trigger = new SimpleTrigger("projectTrigger",
					"projectGroup",
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
			scheduler.pauseTrigger("projectTrigger", "projectGroup");
			
		} catch (SchedulerException e) {
			throw new RuntimeException();
		}
	}


	public void startProjectBidScheduler(List<Integer> projectIdList, Long timeDurationInMiliseconds) {		

		try {
			checkValidityBeforeStart();

			JobDetail job = new JobDetail("projectBidJob", "projectBidGroup", FreelancerProjectBidJob.class);
			job.setVolatility(true);
			job.getJobDataMap().put("projectIdList", projectIdList);
			job.getJobDataMap().put("observer", freelancerObserver);
			job.getJobDataMap().put("client", freelancerClient);
			job.getJobDataMap().put("bidCache", new HashMap<Integer, Map<Integer, FreelancerCacheProjectBid>>());

			SimpleTrigger trigger = new SimpleTrigger("projectBidTrigger",
					"projectBidGroup",
					new Date(),
					null,
					SimpleTrigger.REPEAT_INDEFINITELY,
					timeDurationInMiliseconds);

			scheduler.scheduleJob(job, trigger);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	private void checkValidityBeforeStart() throws SchedulerException {
		
		if (freelancerClient == null) {
			throw new FreelancerClientException("Freelancer client not set");
		}
		if (freelancerObserver == null) {
			throw new FreelancerClientException("Register an observer first");
		}
		
		if (!scheduler.isStarted()) {
			scheduler.start();
		}
		
		
	}

	public void endProjectBidScheduler() {

		try {
			scheduler.pauseTrigger("projectBidTrigger", "projectBidGroup");
		} catch (SchedulerException e) {
			throw new RuntimeException();
		}		
	}
}
