package org.pan.elance.test.client;

import java.util.List;

import org.junit.Test;
import org.pan.elance.client.ElanceClientWrapper;
import org.pan.elance.model.provider.ElanceProviderModel;
import org.pan.elance.model.provider.details.ElanceProviderDetailsModel;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.pan.elance.search.ElanceProviderSearchCriteria;

public class ElanceClientTest {
	
	private static final String apiKey = "46fe5b098fcf8254ccb321eb1ef13f5d24a35cec";
	
	@Test
	public void testJobElanceClient() {
		ElanceClientWrapper client = new ElanceClientWrapper(apiKey);
		
		ElanceJobSearchCriteria crit  = new ElanceJobSearchCriteria();
		crit.setPage(1);
		
		System.out.println(client.searchJobsByCriteria(crit).size());
	}
	
	@Test
	public void testProviderElanceClient() {
		ElanceClientWrapper client = new ElanceClientWrapper(apiKey);
		
		ElanceProviderSearchCriteria crit  = new ElanceProviderSearchCriteria();
		crit.setPage(0);
		
		List<ElanceProviderModel> elanceProviders = client.searchProvidersByCriteria(crit);
		System.out.println(elanceProviders);
	}
	
	@Test
	public void testProviderDetailsElanceClient() {
		ElanceClientWrapper client = new ElanceClientWrapper(apiKey);

		ElanceProviderDetailsModel elanceProviderDetails = client.getProviderDetailsById(1646579);
		System.out.println(elanceProviderDetails);
	}

}
