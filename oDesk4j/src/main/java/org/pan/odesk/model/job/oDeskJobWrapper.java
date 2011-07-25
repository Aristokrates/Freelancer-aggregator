package org.pan.odesk.model.job;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * oDesk job wrapper around job array model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskJobWrapper {
	
	private oDeskJobArray jobArray;

	public oDeskJobWrapper() {
		super();
	}

	public oDeskJobWrapper(oDeskJobArray jobArray) {
		super();
		this.jobArray = jobArray;
	}

	public oDeskJobArray getJobArray() {
		return jobArray;
	}

	@JsonProperty("jobs")
	public void setJobArray(oDeskJobArray jobArray) {
		this.jobArray = jobArray;
	}
	
}
