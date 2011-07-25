package org.pan.odesk.scheduler;

import java.util.List;

import org.pan.odesk.model.job.oDeskCacheJob;
import org.pan.odesk.model.job.oDeskJobModel;

/**
 * oDesk observer
 * <p>
 * Observes oDesk for new jobs and job status changes
 * 
 * @author Pance.Isajeski
 *
 */
public interface oDeskObserver {
	
	void notifyOnNewJobs(List<oDeskJobModel> jobs);

	void notifyOnJobStatusChange(List<oDeskCacheJob> changeStateJobList);

}
