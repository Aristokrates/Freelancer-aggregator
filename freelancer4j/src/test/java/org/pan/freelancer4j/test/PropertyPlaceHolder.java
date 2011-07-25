package org.pan.freelancer4j.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Property placeholder
 * <p>
 * Contains user defined properties injected in application
 * 
 * @author Pance.Isajeski
 *
 */
public enum PropertyPlaceHolder {
	
	INSTANCE;
	
	private Properties properties;

	private PropertyPlaceHolder() {
		
		properties = new Properties();
		
		InputStream globalPropertiesIs = PropertyPlaceHolder.class.getResourceAsStream("/freelancer.test.properties");
		try {
			properties.load(globalPropertiesIs);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
				
		initProxySettings();
		
	}

	private void initProxySettings() {
		String str = properties.getProperty("http.proxy.enabled");
		Boolean httpProxyEnabled = (str != null && str.equals("yes")) ? true : false;

		if (httpProxyEnabled != null && httpProxyEnabled) {
			Map<String, String> httpProxySettings = initHttpProxySettingsMap();
			Iterator<String> iter = httpProxySettings.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				String value = httpProxySettings.get(key);
				System.setProperty(key, value);
			}

		}
	}

	private Map<String, String> initHttpProxySettingsMap() {
		
		List<String> listOfProperties = Arrays.asList("http.proxyHost", "http.proxyPort", "http.proxyUser", 
				"http.proxyPassword", "http.nonProxyHosts", "https.proxyHost", "https.proxyPort", "https.proxyUser", 
				"https.proxyPassword", "https.nonProxyHosts");
		
		Map<String, String> proxySettingsMap = new HashMap<String, String>();
		
		for (String prop : listOfProperties) {
			proxySettingsMap.put(prop, properties.getProperty(prop));		
		}
		
		return proxySettingsMap;
	}

	public Properties getProperties() {
		return properties;
	}	
}
