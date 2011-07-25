package org.pan.freelancer4j.model.user;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Freelancer user list model for FreelancerUser
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerUserList {

	private Integer count;
	
	private List<FreelancerUser> users = new ArrayList<FreelancerUser>();

	public FreelancerUserList() {
		super();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("items")
	public List<FreelancerUser> getUsers() {
		return users;
	}

	@JsonProperty("items")
	public void setUsers(List<FreelancerUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "FreelancerUserList [count=" + count + ", users=" + users + "]";
	}

}
