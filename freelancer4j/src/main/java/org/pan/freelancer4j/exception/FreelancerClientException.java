package org.pan.freelancer4j.exception;

/**
 * Custom freelancer exception wrapper
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerClientException extends RuntimeException {

	private static final long serialVersionUID = 87225397499260556L;

	public FreelancerClientException() {
		super();
	}

	public FreelancerClientException(String message) {
		super(message);
	}

	public FreelancerClientException(Throwable cause) {
		super(cause);
	}
	
}
