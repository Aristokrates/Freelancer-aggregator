package org.pan.elance.model.job;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Wrapper around elance job mode
 * <p>
 * For more reference: <a href="http://www.elance.com/p/api/methods/search/jobs">Elance Job</a>
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceJobModelWrapper {
	
	private Map<Integer, ElanceJobModel> jobMap = new HashMap<Integer, ElanceJobModel>();

	public ElanceJobModelWrapper() {
		super();
	}

	public Map<Integer, ElanceJobModel> getJobMap() {
		return jobMap;
	}

	@JsonProperty("pageResults")
	public void setJobMap(Map<Integer, ElanceJobModel> jobMap) {
		this.jobMap = jobMap;
	}
	
}
