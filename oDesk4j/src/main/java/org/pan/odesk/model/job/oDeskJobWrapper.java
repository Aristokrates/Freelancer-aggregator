package org.pan.odesk.model.job;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * oDesk Job array model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskJobWrapper {
	
	private List<oDeskJobModel> jobs = new ArrayList<oDeskJobModel>();;
	
	private oDeskLister lister;

	public oDeskJobWrapper() {
		super();
	}

	public oDeskJobWrapper(List<oDeskJobModel> jobs, oDeskLister lister) {
		super();
		this.jobs = jobs;
		this.lister = lister;
	}

	public List<oDeskJobModel> getJobs() {
		return jobs;
	}

	@JsonProperty("job")
	public void setJobs(List<oDeskJobModel> jobs) {
		this.jobs = jobs;
	}

	public oDeskLister getLister() {
		return lister;
	}

	@JsonProperty("lister")
	public void setLister(oDeskLister lister) {
		this.lister = lister;
	}
}
