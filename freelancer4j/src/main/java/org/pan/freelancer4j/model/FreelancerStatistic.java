package org.pan.freelancer4j.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Freelancer statistic holder
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerStatistic {
	
	private String count;
	
	private String average;

	public FreelancerStatistic() {
		super();
	}

	public FreelancerStatistic(String count, String average) {
		super();
		this.count = count;
		this.average = average;
	}

	@JsonProperty("count")
	public String getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(String count) {
		this.count = count;
	}

	@JsonProperty("avg")
	public String getAverage() {
		return average;
	}

	@JsonProperty("avg")
	public void setAverage(String average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "FreelancerStatistic [average=" + average + ", count=" + count
				+ "]";
	}
}
