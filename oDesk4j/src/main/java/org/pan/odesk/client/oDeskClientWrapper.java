package org.pan.odesk.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.pan.odesk.json.GenericSerializer;
import org.pan.odesk.json.JacksonJsonSerializer;
import org.pan.odesk.model.job.oDeskJobModel;
import org.pan.odesk.model.job.oDeskJobWrapper;
import org.pan.odesk.model.provider.oDeskProviderModel;
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


	public List<oDeskJobModel> searchJobsByCriteria(oDeskJobSearchCriteria jobCriteria) {
		String requestUrl = "http://www.odesk.com/api/profiles/v1/search/jobs.json";
		HashMap<String, String> params = jobCriteria.buildParameterMap();
		try {
			JSONObject object = oDeskApi.getRequest(requestUrl, params);

			List<oDeskJobModel> jobs = serializer.fromJson(object.toString(), oDeskJobWrapper.class).getJobArray().getJobs();
			return jobs;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public List<oDeskProviderModel> searchProvidersByCriteria(oDeskProviderSearchCriteria providerCriteria) {
		String requestUrl = "http://www.odesk.com/api/profiles/v1/search/providers.json";
		HashMap<String, String> params = providerCriteria.buildParameterMap();
		try {

			List<oDeskProviderModel> providers = new ArrayList<oDeskProviderModel>();

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


			return providers;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}



}
