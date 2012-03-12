package org.pan.freelancer4j.search;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.pan.freelancer4j.model.FreelancerProjectState;

/**
 * Freelancer project criteria
 * <p>
 * Criteria for searching projects on Freelancer.com
 * 
 * @author Pance.Isajeski
 *
 */
public class ProjectSearchCriteria implements Cloneable {
	
	private Boolean isfeatured;
	
	private Boolean isnonpublic;
	
	private String searchkeyword;
	
	private List<String> searchjobtypecsv = new ArrayList<String>();
	
	private FreelancerProjectState projectState;
	
	private String budgetmin;
	
	private String budgetmax;
	
	private Boolean isfulltime;
	
	private Boolean istrial;
	
	private Boolean isgoldmembersonly;
	
	private String bidendsduration;
	
	private Integer count = 200;
	
	private Integer page = 0;
	
	private String tags;
	
	private String sort;
	
	
	public Boolean getIsfeatured() {
		return isfeatured;
	}

	public void setIsfeatured(Boolean isfeatured) {
		this.isfeatured = isfeatured;
	}

	public Boolean getIsnonpublic() {
		return isnonpublic;
	}

	public void setIsnonpublic(Boolean isnonpublic) {
		this.isnonpublic = isnonpublic;
	}

	public String getSearchkeyword() {
		return searchkeyword;
	}

	public void setSearchkeyword(String searchkeyword) {
		this.searchkeyword = searchkeyword;
	}

	public List<String> getSearchjobtypecsv() {
		return searchjobtypecsv;
	}

	public void setSearchjobtypecsv(List<String> searchjobtypecsv) {
		this.searchjobtypecsv = searchjobtypecsv;
	}

	public FreelancerProjectState getProjectState() {
		return projectState;
	}

	public void setProjectState(FreelancerProjectState projectState) {
		this.projectState = projectState;
	}

	public String getBudgetmin() {
		return budgetmin;
	}

	public void setBudgetmin(String budgetmin) {
		this.budgetmin = budgetmin;
	}

	public String getBudgetmax() {
		return budgetmax;
	}

	public void setBudgetmax(String budgetmax) {
		this.budgetmax = budgetmax;
	}

	public Boolean getIsfulltime() {
		return isfulltime;
	}

	public void setIsfulltime(Boolean isfulltime) {
		this.isfulltime = isfulltime;
	}

	public Boolean getIstrial() {
		return istrial;
	}

	public void setIstrial(Boolean istrial) {
		this.istrial = istrial;
	}

	public Boolean getIsgoldmembersonly() {
		return isgoldmembersonly;
	}

	public void setIsgoldmembersonly(Boolean isgoldmembersonly) {
		this.isgoldmembersonly = isgoldmembersonly;
	}

	public String getBidendsduration() {
		return bidendsduration;
	}

	public void setBidendsduration(String bidendsduration) {
		this.bidendsduration = bidendsduration;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public Set<Entry<String, Object>> buildParameterEntrySet() {
		
		Set<Entry<String, Object>> params = new HashSet<Map.Entry<String,Object>>();
		
		if (getIsfeatured() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("featured", getIsfeatured().equals(Boolean.TRUE) ? 1 : 0));
		}
		if (getIsnonpublic() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("nonpublic", getIsnonpublic().equals(Boolean.TRUE) ? 1 : 0));
		}
		if (getIstrial() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("trial", getIstrial().equals(Boolean.TRUE) ? 1 : 0));
		}
		if (getIsfulltime() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("fulltime", getIsfulltime().equals(Boolean.TRUE) ? 1 : 0));
		}
		if (getIsgoldmembersonly() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("for_gold_members", getIsgoldmembersonly().equals(Boolean.TRUE) ? 1 : 0));
		}
		if (getSearchkeyword() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("keyword", getSearchkeyword()));
		}
		for (String job : getSearchjobtypecsv()) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("jobs[]", job));
		}
		if (getProjectState() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("status", getProjectState().getProjectStateIdentifier()));
		}
		if (getBudgetmin() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("min_budget", getBudgetmin()));
		}
		if (getBudgetmax() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("max_budget", getBudgetmax()));
		}
		if (getBidendsduration() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("bidding_ends", getBidendsduration()));
		}
		if (getCount() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("count", getCount()));			
		}
		if (getPage() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("pg", getPage()));
		}
		if (getSort() != null) {
			params.add(new AbstractMap.SimpleEntry<String, Object>("order", getSort()));
		}
		return params;
	}

	@Override
	public ProjectSearchCriteria clone() throws CloneNotSupportedException {
		return (ProjectSearchCriteria) super.clone();
	}
	
	
}
