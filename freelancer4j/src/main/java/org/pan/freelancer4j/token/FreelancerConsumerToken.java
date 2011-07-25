package org.pan.freelancer4j.token;

/**
 * Freelancer consumer token representation
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerConsumerToken {
	
	private String token;
	private String tokenSecret;
	
	public FreelancerConsumerToken() {
		super();
	}
	
	public FreelancerConsumerToken(String token, String tokenSecret) {
		super();
		this.token = token;
		this.tokenSecret = tokenSecret;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTokenSecret() {
		return tokenSecret;
	}
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	@Override
	public String toString() {
		return "FreelancerConsumerToken [token=" + token + ", tokenSecret="
				+ tokenSecret + "]";
	}
	
	

}
