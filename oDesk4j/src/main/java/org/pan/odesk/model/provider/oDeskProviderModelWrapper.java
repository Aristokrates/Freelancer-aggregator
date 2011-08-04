package org.pan.odesk.model.provider;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.pan.odesk.model.job.oDeskLister;

@JsonIgnoreProperties(ignoreUnknown=true)
public class oDeskProviderModelWrapper {
	
	private List<oDeskProviderModel> providers = new ArrayList<oDeskProviderModel>();;
	
	private oDeskLister lister;

	public oDeskProviderModelWrapper() {
		super();
	}

	public List<oDeskProviderModel> getProviders() {
		return providers;
	}

	@JsonProperty("provider")
	public void setProviders(List<oDeskProviderModel> providers) {
		this.providers = providers;
	}

	public oDeskLister getLister() {
		return lister;
	}

	@JsonProperty("lister")
	public void setLister(oDeskLister lister) {
		this.lister = lister;
	}
}
