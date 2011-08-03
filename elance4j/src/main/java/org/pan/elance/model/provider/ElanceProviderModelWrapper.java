package org.pan.elance.model.provider;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Wrapper around Elance provider model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceProviderModelWrapper {
	
	private String totalResults;
	
	private Integer totalPages;
	
	private Integer page;
	
	private String numResults;
	
	private Map<Integer, ElanceProviderModel> providersMap = new HashMap<Integer, ElanceProviderModel>();

	public ElanceProviderModelWrapper() {
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

	public Map<Integer, ElanceProviderModel> getProvidersMap() {
		return providersMap;
	}

	@JsonProperty("pageResults")
	public void setProvidersMap(Map<Integer, ElanceProviderModel> providersMap) {
		this.providersMap = providersMap;
	}

	@Override
	public String toString() {
		return "ElanceProviderModelWrapper [page=" + page + ", totalPages="
				+ totalPages + ", providersMap=" + providersMap + "]";
	}
}
