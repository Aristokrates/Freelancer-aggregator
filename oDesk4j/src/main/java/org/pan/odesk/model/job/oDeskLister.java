package org.pan.odesk.model.job;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * oDesk lister
 * <p>
 * Contains metadata information returned on search response
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskLister {
	
	private String totalItems;
	
	private String sort;

	public oDeskLister() {
		super();
	}

	public oDeskLister(String totalItems, String sort) {
		super();
		this.totalItems = totalItems;
		this.sort = sort;
	}

	public String getTotalItems() {
		return totalItems;
	}

	@JsonProperty("total_items")
	public void setTotalItems(String totalItems) {
		this.totalItems = totalItems;
	}

	public String getSort() {
		return sort;
	}

	@JsonProperty("sort")
	public void setSort(String sort) {
		this.sort = sort;
	}
}
