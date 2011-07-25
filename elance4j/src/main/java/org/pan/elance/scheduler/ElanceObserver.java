package org.pan.elance.scheduler;

import java.util.List;

import org.pan.elance.model.job.ElanceJobModel;

/**
 * Elance observer interface
 * <p>
 * Used for observing new job on Elance
 * 
 * @author Pance.Isajeski
 *
 */
public interface ElanceObserver {
	
	void notifyOnNewJobs(List<ElanceJobModel> jobs);

}
