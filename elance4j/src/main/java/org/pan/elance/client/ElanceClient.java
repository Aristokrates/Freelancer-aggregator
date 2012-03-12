package org.pan.elance.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Basic Elance Http client
 * 
 * @author Pance.Isajeski
 *
 */
public class ElanceClient {
	
	private HttpClient httpClient;
	
	final static int HTTP_RESPONSE_503 = 503;
	private String apiKey;

	public ElanceClient(String apiKey) {
		super();
		this.apiKey = apiKey;
		httpClient = getDefaultHttpClient();
	}

    public JSONObject getRequest(String url, Map<String, String> params) throws JSONException {
        return request(url, params);
    }

	private JSONObject request(String url, Map<String, String> params) throws JSONException {
		
		params.put("oauth_consumer_key", this.apiKey);
		String uri = mergeParamsToUri(url, params);
		return doGetRequest(uri);
	}
	
    private JSONObject doGetRequest(String url) throws JSONException {
    	
        JSONObject json = null;
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response;

        try {
            response = httpClient.execute(httpGet);
          
            if(response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    
                    json = new JSONObject(result);
                }
            } else {
                json = genError(response.getStatusLine().getStatusCode(), response.getStatusLine().toString());
            }
        } catch (ClientProtocolException e) {
            json = genError(HTTP_RESPONSE_503, "Exception: ClientProtocolException");
        } catch (IOException e) {
            json = genError(HTTP_RESPONSE_503, "Exception: IOException");
        } catch (JSONException e) {
            json = genError(HTTP_RESPONSE_503, "Exception: JSONException");  
        } catch (Exception e) {
            json = genError(HTTP_RESPONSE_503, "Exception: Exception " + e.toString());
        } finally {
            httpGet.abort();
        }
        
        return json;
    }
    
    
    private static JSONObject genError(Integer code, String message) throws JSONException {
        return new JSONObject("{error: {code: \"" + code.toString() + "\", message: \"" + message + "\"}}");
    }
    
	@SuppressWarnings("deprecation")
	private static HttpClient getDefaultHttpClient() {		
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, "utf-8");
        params.setBooleanParameter("http.protocol.expect-continue", false);
        params.setIntParameter(AllClientPNames.CONNECTION_TIMEOUT, 20 * 1000);
        params.setIntParameter(AllClientPNames.SO_TIMEOUT, 30 * 1000);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(new Scheme("https", PlainSocketFactory.getSocketFactory(), 443));
        ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(params, registry);
        return new DefaultHttpClient(cm, params);
	}
	
	public void shutdown() {
		try
		{
			this.httpClient.getConnectionManager().shutdown();
		}
		catch (Exception ignore)
		{
			// ignored
		}
	}
	
    private static String mergeParamsToUri(String uri, Map<String, String> params) {
        uri = (uri.length() > 0) ? uri + "&" : "?";
        
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                uri += key + "=" + URLEncoder.encode(value, "UTF-8") + "&";
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Can not encode value: " + value);
            }
        }
        return uri.substring(0, uri.length()-1);
    }

}
