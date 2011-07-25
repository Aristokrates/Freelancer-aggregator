package org.pan.elance.model.provider;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Wrapper around Elance provider model
 * 
 * @author Pance.Isajeski
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ElanceProviderModelWrapper {
	
	private Map<Integer, ElanceProviderModel> providersMap = new HashMap<Integer, ElanceProviderModel>();

	public ElanceProviderModelWrapper() {
		super();
	}

	public Map<Integer, ElanceProviderModel> getProvidersMap() {
		return providersMap;
	}

	@JsonProperty("pageResults")
	public void setProvidersMap(Map<Integer, ElanceProviderModel> providersMap) {
		this.providersMap = providersMap;
	}
}
