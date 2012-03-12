package org.pan.freelancer4j.model.project;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Project budget json to Java bean mapping model
 * <p>
 * Maps the project budget json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectBudget {
	
	private String minimum;
	
	private String maximum;	

	public FreelancerProjectBudget() {
		super();
	}

	public FreelancerProjectBudget(String minimum, String maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	@JsonProperty("min")
	public String getMinimum() {
		return minimum;
	}

	@JsonProperty("min")
	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

	@JsonProperty("max")
	public String getMaximum() {
		return maximum;
	}

	@JsonProperty("max")
	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}

	@Override
	public String toString() {
		return "FreelancerProjectBudget [maximum=" + maximum + ", minimum="
				+ minimum + "]";
	}
}
