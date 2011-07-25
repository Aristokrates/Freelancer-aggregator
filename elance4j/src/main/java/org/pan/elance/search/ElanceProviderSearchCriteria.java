package org.pan.elance.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Elance provider search criteria
 * <p>
 * For more reference: <a href="http://www.elance.com/p/api/methods/search/providers">Elance Providers</a>
 * 
 * @author Pance.Isajeski
 *
 */
public class ElanceProviderSearchCriteria {

	private String keyword;
	
	private String sortColumn;
	
	private String sortOrder;
	
	private Integer page;
	

	public ElanceProviderSearchCriteria() {
		super();
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Map<String, String> buildParameterMap() {
		
		Map<String, String> params = new HashMap<String, String>();
		
		if (keyword != null) {
			params.put("keywords", keyword);
		}
		
		if (sortColumn != null) {
			params.put("sortCol", sortColumn);
		}
		
		if (sortOrder != null) {
			params.put("sortOrder", sortOrder);
		}
		
		Integer defaultPage = 1;
		if (page != null) {
			defaultPage = page;
		}
		
		params.put("page", defaultPage.toString());
		
		return params;
	}

}
