package org.pan.freelancer4j.model.user.details;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.freelancer4j.model.FreelancerResponseWrapper;

/**
 * Wrapper for freelancer user details model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerUserDetailsWrapper extends FreelancerResponseWrapper {
	
	private FreelancerUserDetails userDetails;

	public FreelancerUserDetailsWrapper() {
		super();
	}

	@JsonProperty("user")
	public FreelancerUserDetails getUserDetails() {
		return userDetails;
	}

	@JsonProperty("user")
	public void setUserDetails(FreelancerUserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "FreelancerUserDetailsWrapper [userDetails=" + userDetails + "]";
	}
}
