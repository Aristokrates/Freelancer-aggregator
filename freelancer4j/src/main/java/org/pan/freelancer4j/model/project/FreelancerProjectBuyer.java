package org.pan.freelancer4j.model.project;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Project buyer json to Java bean mapping model
 * <p>
 * Maps the project buyer json representation returned from freelancer into java bean
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FreelancerProjectBuyer {
	
	private String url;
	
	private Integer id;
	
	private String username;

	public FreelancerProjectBuyer() {
		super();
	}

	public FreelancerProjectBuyer(String url, Integer id, String username) {
		super();
		this.url = url;
		this.id = id;
		this.username = username;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "FreelancerProjectBuyer [id=" + id + ", url=" + url
				+ ", username=" + username + "]";
	}
}
