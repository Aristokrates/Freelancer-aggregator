package org.pan.elance.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.pan.elance.json.GenericSerializer;
import org.pan.elance.json.JacksonJsonSerializer;
import org.pan.elance.model.job.ElanceJobModel;
import org.pan.elance.model.job.ElanceJobModelWrapper;
import org.pan.elance.model.provider.ElanceProviderModel;
import org.pan.elance.model.provider.ElanceProviderModelWrapper;
import org.pan.elance.model.provider.details.ElanceProviderDetailsModel;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.pan.elance.search.ElanceProviderSearchCriteria;

/**
 * Elance client wrrapper.
 * 
 * Wraps the request as search criterias and response as elance model
 * 
 * @author Pance.Isajeski
 *
 */
public class ElanceClientWrapper {

	private ElanceClient elanceClient;
	private GenericSerializer serializer;

	public ElanceClientWrapper(String apiKey) {

		super();
		this.elanceClient = new ElanceClient(apiKey);
		serializer = new JacksonJsonSerializer();	
	}

	public List<ElanceJobModel> searchJobsByCriteria(ElanceJobSearchCriteria searchCriteria) {

		String requestUrl = "http://api.elance.com/api/search/jobs";
		Map<String, String> params = searchCriteria.buildParameterMap();

		try {
			JSONObject object = elanceClient.getRequest(requestUrl, params);
			JSONObject dataJson = object.getJSONObject("data");
			
			ElanceJobModelWrapper jobWrapper = serializer.fromJson(dataJson.toString(), ElanceJobModelWrapper.class);
			return new ArrayList<ElanceJobModel>(jobWrapper.getJobMap().values());
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public List<ElanceProviderModel> searchProvidersByCriteria(ElanceProviderSearchCriteria searchCriteria) {

		String requestUrl = "http://api.elance.com/api/search/providers";
		Map<String, String> params = searchCriteria.buildParameterMap();
		
		try {
			JSONObject object = elanceClient.getRequest(requestUrl, params);
			JSONObject dataJson = object.getJSONObject("data");
			ElanceProviderModelWrapper providerWrapper = serializer.fromJson(dataJson.toString(), ElanceProviderModelWrapper.class);
			return new ArrayList<ElanceProviderModel>(providerWrapper.getProvidersMap().values());
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public ElanceProviderDetailsModel getProviderDetailsById(Integer providerId) {
		
		String requestUrl = "http://api.elance.com/api/profile/getProviderProfile";
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("userId", providerId.toString());
		
		try {
			JSONObject object = elanceClient.getRequest(requestUrl, params);
			JSONObject dataJson = object.getJSONObject("data");
			JSONObject providerProfileJson = dataJson.getJSONObject("providerProfile");
			ElanceProviderDetailsModel detailsModel = serializer.fromJson(providerProfileJson.toString(), ElanceProviderDetailsModel.class);
			return detailsModel;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public void shutdownClient() {
		this.elanceClient.shutdown();
	}
}
