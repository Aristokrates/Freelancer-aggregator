package org.pan.freelancer4j.model.user;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.freelancer4j.model.FreelancerResponseWrapper;

/**
 * Freelancer Wrapper for list model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerUserWrapper extends FreelancerResponseWrapper {
	
	private FreelancerUserList userList;
	
	public FreelancerUserWrapper() {
		super();
	}

	public FreelancerUserWrapper(FreelancerUserList userList) {
		super();
		this.userList = userList;
	}

	@JsonProperty("json-result")
	public FreelancerUserList getUserList() {
		return userList;
	}

	@JsonProperty("json-result")
	public void setUserList(FreelancerUserList userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "FreelancerUserWrapper [userList=" + userList + "]";
	}
}
