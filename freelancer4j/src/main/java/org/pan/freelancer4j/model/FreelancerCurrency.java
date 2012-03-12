package org.pan.freelancer4j.model;

/**
 * Currency used on Freelancer.com and their integer representation
 * 
 * @author Pance.Isajeski
 *
 */
public enum FreelancerCurrency {
	
	USD(1),
	EUR(2),
	GBP(3),
	AUD(4),
	NZD(5),
	CAD(6);
	
	private Integer currencyId;
	
	private FreelancerCurrency(Integer currencyId) {
		this.currencyId = currencyId;
	}
	
	public Integer getCurrencyId() {
		return currencyId;
	}

	public static FreelancerCurrency getFreelancerCurrency(Integer currencyId) {
		
		if (currencyId == null) {
			return null;
		}
		
		for (FreelancerCurrency curr : FreelancerCurrency.values()) {
			if (curr.getCurrencyId().equals(currencyId)) {
				return curr;
			}
		}
		return null;
	}
}
