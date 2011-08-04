package org.pan.linkedin.model.person;

import java.util.ArrayList;
import java.util.List;

public class LinkedInPersonModelWrapper {
	
	private Integer totalResults;
	
	private List<LinkedInPersonModel> people = new ArrayList<LinkedInPersonModel>();

	public LinkedInPersonModelWrapper() {
		super();
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public List<LinkedInPersonModel> getPeople() {
		return people;
	}

	public void setPeople(List<LinkedInPersonModel> people) {
		this.people = people;
	}
}
