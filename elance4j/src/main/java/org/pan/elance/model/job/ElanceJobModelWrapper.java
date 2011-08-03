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
	
	private String totalResults;
	
	private Integer totalPages;
	
	private Integer page;
	
	private String numResults;
	
	private Map<Integer, ElanceJobModel> jobMap = new HashMap<Integer, ElanceJobModel>();

	public ElanceJobModelWrapper() {
		super();
	}
	
	public String getTotalResults() {
		return totalResults;
	}

	@JsonProperty("totalResults")
	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	@JsonProperty("totalPages")
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPage() {
		return page;
	}

	@JsonProperty("page")
	public void setPage(Integer page) {
		this.page = page;
	}

	public String getNumResults() {
		return numResults;
	}

	@JsonProperty("numResults")
	public void setNumResults(String numResults) {
		this.numResults = numResults;
	}

	public Map<Integer, ElanceJobModel> getJobMap() {
		return jobMap;
	}

	@JsonProperty("pageResults")
	public void setJobMap(Map<Integer, ElanceJobModel> jobMap) {
		this.jobMap = jobMap;
	}

	@Override
	public String toString() {
		return "ElanceJobModelWrapper [page=" + page + ", totalPages="
				+ totalPages + ", jobMap=" + jobMap + "]";
	}
}
