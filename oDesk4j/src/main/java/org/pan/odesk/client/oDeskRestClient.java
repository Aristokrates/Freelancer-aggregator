package org.pan.odesk.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * oDesk API Rest client
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskRestClient {
	
    final static int METHOD_GET     = 1;
    final static int METHOD_POST    = 2;
    final static int METHOD_PUT     = 3;
    final static int METHOD_DELETE  = 4;
    
    final static int HTTP_RESPONSE_503 = 503;
    
    /**
     * Get JSON response
     * 
     * @param   url             Request URL
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject getJSONObject(String url) throws JSONException {
        return oDeskRestClient.getJSONObject(url, METHOD_GET, new HashMap<String, String>());
    }
    
    /**
     * Get JSON response
     * 
     * @param   url             Request URL
     * @param   method          HTTP Method
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject getJSONObject(String url, Integer method) throws JSONException {
        return oDeskRestClient.getJSONObject(url, method, new HashMap<String, String>());
    }
    
    /**
     * Get JSON response
     * 
     * @param   url             Request URL
     * @param   method          HTTP method
     * @param   params          POST parameters
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject getJSONObject(String url, Integer method, HashMap<String, String> params) throws JSONException {
        switch (method) {
        case METHOD_GET:
            return doGetRequest(url);
        case METHOD_POST:
        case METHOD_PUT:
        case METHOD_DELETE:
            return doPostRequest(url, params);
        default:
            throw new RuntimeException("HTTP method not supported.");
        }
    }
    
    private static JSONObject doPostRequest(String url, HashMap<String, String> params) throws JSONException {
    	
        JSONObject json = null;
        HttpClient postClient = getDefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse response;
        
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                nameValuePairs.add(new BasicNameValuePair(key, value));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            
            response = postClient.execute(httpPost);
            
            if(response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                
                if (entity != null) {
                    InputStream instream = entity.getContent();  
                    String result = convertStreamToString(instream);
                    instream.close();
                    
                    json = new JSONObject(result);
                }
            } else {
                json = oDeskRestClient.genError(response.getStatusLine().getStatusCode(), response.getStatusLine().toString());
            }
        } catch (ClientProtocolException e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: ClientProtocolException");
        } catch (IOException e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: IOException");
        } catch (JSONException e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: JSONException");  
        } catch (Exception e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: Exception " + e.toString());
        } finally {
            httpPost.abort();
        }
        
        return json;
    }
    
    private static JSONObject doGetRequest(String url) throws JSONException {
        JSONObject json = null;
        HttpClient httpClient = getDefaultHttpClient();
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
                json = oDeskRestClient.genError(response.getStatusLine().getStatusCode(), response.getStatusLine().toString());
            }
        } catch (ClientProtocolException e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: ClientProtocolException");
        } catch (IOException e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: IOException");
        } catch (JSONException e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: JSONException");  
        } catch (Exception e) {
            json = oDeskRestClient.genError(HTTP_RESPONSE_503, "Exception: Exception " + e.toString());
        } finally {
            httpGet.abort();
        }
        
        return json;
    }
    
    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
  
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return sb.toString();
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
    
    private static JSONObject genError(Integer code, String message) throws JSONException {
        // TODO: HTTP-Status (404, etc), for now return status line
        return new JSONObject("{error: {code: \"" + code.toString() + "\", message: \"" + message + "\"}}");
    }
}
