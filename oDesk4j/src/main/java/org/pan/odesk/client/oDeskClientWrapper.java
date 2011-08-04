package org.pan.odesk.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.pan.odesk.json.GenericSerializer;
import org.pan.odesk.json.JacksonJsonSerializer;
import org.pan.odesk.model.job.oDeskJobWrapper;
import org.pan.odesk.model.job.oDeskLister;
import org.pan.odesk.model.provider.oDeskProviderModel;
import org.pan.odesk.model.provider.oDeskProviderModelWrapper;
import org.pan.odesk.model.provider.oDeskProviderSkillModel;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.pan.odesk.search.oDeskProviderSearchCriteria;

/**
 * oDesk API client wrapper
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskClientWrapper {

	private oDeskAPI oDeskApi;
	private GenericSerializer serializer;

	public oDeskClientWrapper(String appSecret, String appKey, String apiToken) {
		super();
		this.oDeskApi = new oDeskAPI(appSecret, appKey);
		oDeskApi.setApiToken(apiToken);
		serializer = new JacksonJsonSerializer();
	}


	public oDeskJobWrapper searchJobsByCriteria(oDeskJobSearchCriteria jobCriteria) {
		String requestUrl = "http://www.odesk.com/api/profiles/v1/search/jobs.json";
		HashMap<String, String> params = jobCriteria.buildParameterMap();
		try {
			JSONObject object = oDeskApi.getRequest(requestUrl, params);
			JSONObject jobsObject = object.getJSONObject("jobs");

			return serializer.fromJson(jobsObject.toString(), oDeskJobWrapper.class);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public oDeskProviderModelWrapper searchProvidersByCriteria(oDeskProviderSearchCriteria providerCriteria) {
		String requestUrl = "http://www.odesk.com/api/profiles/v1/search/providers.json";
		HashMap<String, String> params = providerCriteria.buildParameterMap();
		try {

			List<oDeskProviderModel> providers = new ArrayList<oDeskProviderModel>();
			oDeskProviderModelWrapper modelWrapper = new oDeskProviderModelWrapper();

			JSONObject object = oDeskApi.getRequest(requestUrl, params);

			JSONObject providersObject = object.getJSONObject("providers");
			JSONArray providersArrays = providersObject.getJSONArray("provider");

			for (int i=0; i < providersArrays.length() ; i++) {
				JSONObject singleProvider = (JSONObject) providersArrays.get(i);

				oDeskProviderModel providerModel = serializer.fromJson(singleProvider.toString(), oDeskProviderModel.class);

				try {
					JSONObject skills = singleProvider.getJSONObject("skills");
					JSONArray skillsArray = skills.getJSONArray("skill");

					for (int j=0; j<skillsArray.length() ; j++) {

						JSONObject skillJson = (JSONObject) skillsArray.get(j);
						oDeskProviderSkillModel skillModel = serializer.fromJson(skillJson.toString(), oDeskProviderSkillModel.class);
						providerModel.addProviderSkill(skillModel);
					}
				} catch (Exception e) {
					
				}
				providers.add(providerModel);
			}
			modelWrapper.setProviders(providers);
			
			JSONObject listerJson = providersObject.getJSONObject("lister");
			oDeskLister lister = serializer.fromJson(listerJson.toString(), oDeskLister.class);
			modelWrapper.setLister(lister);
			
			return modelWrapper;		

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public oDeskProviderModel getProviderById(String providerId) {
		String requestUrl = "http://www.odesk.com/api/profiles/v1/providers/";
		
		requestUrl += providerId + "/brief.json";
		
		try {
			JSONObject object = oDeskApi.getRequest(requestUrl);
			JSONObject providerObject = object.getJSONObject("profile");
			oDeskProviderModel providerModel = serializer.fromJson(providerObject.toString(), oDeskProviderModel.class);
			System.out.println(serializer.toJson(providerModel));
			return providerModel;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
