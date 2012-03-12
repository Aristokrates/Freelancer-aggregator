package org.pan.freelancer4j.token;

/**
 * Freelancer access token wrapper
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerAccessToken {

	private String token;
	private String tokenSecret;

	public FreelancerAccessToken() {
		super();
	}
	
	public FreelancerAccessToken(String token, String tokenSecret) {
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
		return "FreelancerAccessToken [token=" + token + ", tokenSecret="
				+ tokenSecret + "]";
	}

	public boolean isValid()
	{
		if (this.getToken() == null)
		{
			return false;
		}
		else if (this.getToken().trim().length() == 0)
		{
			return false;
		}
		else if (this.getTokenSecret() == null)
		{
			return false;
		}
		else if (this.getTokenSecret().trim().length() == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
}
