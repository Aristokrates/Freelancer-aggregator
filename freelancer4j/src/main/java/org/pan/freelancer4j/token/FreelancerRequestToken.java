package org.pan.freelancer4j.token;

/**
 * Freelancer request token wrapper
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerRequestToken {
	
	private String token;
	private String tokenSecret;
	
	public FreelancerRequestToken() {
		super();
	}
	
	public FreelancerRequestToken(String token, String tokenSecret) {
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
		return "FreelancerRequestToken [token=" + token + ", tokenSecret="
				+ tokenSecret + "]";
	}
}
