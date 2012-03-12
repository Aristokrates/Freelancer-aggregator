package org.pan.odesk.model.job;

/**
 * oDesk cache job model
 * <p>
 * Model for storing jobs in job cache
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskCacheJob {
	
	private String jobId;
	
	private String active;
	
	private String dateCreated;

	public oDeskCacheJob(String jobId, String active, String dateCreated) {
		super();
		this.jobId = jobId;
		this.active = active;
		this.dateCreated = dateCreated;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "oDeskCacheJob [active=" + active + ", dateCreated="
				+ dateCreated + ", jobId=" + jobId + "]";
	}
}
