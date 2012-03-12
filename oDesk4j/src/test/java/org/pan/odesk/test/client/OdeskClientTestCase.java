package org.pan.odesk.test.client;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;
import org.pan.odesk.client.oDeskAPI;
import org.pan.odesk.client.oDeskClientWrapper;
import org.pan.odesk.model.job.oDeskJobModel;
import org.pan.odesk.model.provider.oDeskProviderModel;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.pan.odesk.search.oDeskProviderSearchCriteria;
import org.pan.odesk.test.BaseTestCase;

public class OdeskClientTestCase extends BaseTestCase {
	
	private String secret = "85aa9c7694df99f2";
	private String apiKey = "e3de62ebf5544155513afa74b84b0ff3";
	
	private String apiToken = "1eb8386d287c3fc8f177841e6aa8e1c1";
	
	@Test
	@Ignore
	public void testClient() throws JSONException {
		oDeskAPI api = new oDeskAPI(secret, apiKey);
		String authUrl = api.getAuthUrl();
		
		String apiToken = api.getApiToken();
				
		System.out.println(apiToken);
	}
	
	@Test
	@Ignore
	public void testClientRequests() throws JSONException {
		oDeskAPI api = new oDeskAPI(secret, apiKey);
		api.setApiToken(apiToken);

		String requestUrl = "http://www.odesk.com/api/profiles/v1/search/jobs.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("page", "0;1000");
		
		System.out.println(api.getRequest(requestUrl, params));
	}
	
	@Test
	public void testJobClientWrapper() throws JSONException {
		
		oDeskAPI api = new oDeskAPI(secret, apiKey);
		api.setApiToken(apiToken);
		
		oDeskClientWrapper wrapper = new oDeskClientWrapper(secret, apiKey, apiToken);
		
		oDeskJobSearchCriteria criteria = new oDeskJobSearchCriteria();
		criteria.setPage(0);
		criteria.setCount(200);
		criteria.setStatusForSearching("In progress");
		
		List<oDeskJobModel> jobs = wrapper.searchJobsByCriteria(criteria).getJobs();
		
		System.out.println(jobs);
	}
	
	@Test
	public void testProviderClientWrapper() throws JSONException {
		
		oDeskAPI api = new oDeskAPI(secret, apiKey);
		api.setApiToken(apiToken);
		
		oDeskClientWrapper wrapper = new oDeskClientWrapper(secret, apiKey, apiToken);
		
		oDeskProviderSearchCriteria criteria = new oDeskProviderSearchCriteria();
		criteria.setPage(0);
		criteria.setCount(200);
		
		List<oDeskProviderModel> providers = wrapper.searchProvidersByCriteria(criteria).getProviders();
		
		System.out.println(providers);
	}

}
