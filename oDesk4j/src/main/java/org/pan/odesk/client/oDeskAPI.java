package org.pan.odesk.client;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * oDesk Client Http client
 * 
 * @author Pance.Isajeski
 *
 */
public class oDeskAPI {
    final static int METHOD_GET     = 1;
    final static int METHOD_POST    = 2;
    final static int METHOD_PUT     = 3;
    final static int METHOD_DELETE  = 4;
    
    final static String URL_AUTH    = "https://www.odesk.com/services/api/auth";
    final static String URL_TOKENS  = "http://www.odesk.com/api/auth/v1/keys/tokens.json";
    final static String URL_FROBS   = "http://www.odesk.com/api/auth/v1/keys/frobs.json";
    final static String OVERLOAD_VAR= "http_method";
    
    static String api_key   = "";
    static String secret    = "";
    static String api_token = "";
    static String frob      = "";

    /**
     * Constructor
     * 
     * @param   secret  Secret key
     * @param   api_key API's application key
     * */
    public oDeskAPI(String secret, String api_key) {
        if (secret == "") {
            throw new RuntimeException("You must define 'secret key'");
        } else {
            oDeskAPI.secret = secret;
        }
        
        if (api_key == "") {
            throw new RuntimeException("You must define 'application key'");
        } else {
            oDeskAPI.api_key = api_key;
        }
    }
    
    /**
     * Get URL for authorization process
     * 
     * @throws  JSONException
     * @return  {@link String}
     * */
    public String getAuthUrl() throws JSONException {
        String frob = oDeskAPI.getFrob();
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("frob", frob);
        
        String api_sig = calcApiSig(oDeskAPI.secret, p);
        
        return oDeskAPI.URL_AUTH + getApiKeysUri(api_sig) + "&frob=" + frob;
    }
    
    /**
     * Do GET request
     * 
     * @param   url             Request URL
     * @param   params          Additional params
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject getRequest(String url, HashMap<String, String> params) throws JSONException {
        return request(METHOD_GET, url, params);
    }
    
    /**
     * Do GET request
     * 
     * @param   url             Request URL
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject getRequest(String url) throws JSONException {
        return getRequest(url, new HashMap<String, String>());
    }
    
    /**
     * Do POST request
     * 
     * @param   url             Request URL
     * @param   params          Additional params
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject postRequest(String url, HashMap<String, String> params) throws JSONException {
        return request(METHOD_POST, url, params);
    }
    
    /**
     * Do POST request
     * 
     * @param   url             Request URL
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject postRequest(String url) throws JSONException {
        return postRequest(url, new HashMap<String, String>());
    }
    
    /**
     * Do PUT request
     * 
     * @param   url             Request URL
     * @param   params          Additional params
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject putRequest(String url, HashMap<String, String> params) throws JSONException {
        return request(METHOD_PUT, url, params);
    }
    
    /**
     * Do PUT request
     * 
     * @param   url             Request URL
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject putRequest(String url) throws JSONException {
        return putRequest(url, new HashMap<String, String>());
    }
    
    /**
     * Do DELETE request
     * 
     * @param   url             Request URL
     * @param   params          Additional params
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject deleteRequest(String url, HashMap<String, String> params) throws JSONException {
        return request(METHOD_DELETE, url, params);
    }
    
    /**
     * Do DELETE request
     * 
     * @param   url             Request URL
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public JSONObject deleteRequest(String url) throws JSONException {
        return deleteRequest(url, new HashMap<String, String>());
    }
    
    /**
     * HTTP request wrapper
     * 
     * @param   type            Type of HTTP request
     * @param   url             Request URL
     * @param   params          Additional params
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject request(Integer type, String url, HashMap<String, String> params) throws JSONException {
        params.put("api_token", oDeskAPI.api_token);
        
        if (type == METHOD_PUT) {
            params.put(oDeskAPI.OVERLOAD_VAR, "put");
        } else if (type == METHOD_DELETE) {
            params.put(oDeskAPI.OVERLOAD_VAR, "delete");
        }
        
        String api_sig = calcApiSig(oDeskAPI.secret, params);
        String uri = mergeParamsToUri(getApiKeysUri(api_sig), params);
        String myurl = url + uri;
        
        return sendRequest(myurl, type);
    }
    
    /**
     * HTTP request wrapper
     * 
     * @param   type            Type of HTTP request
     * @param   url             Request URL
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static JSONObject request(Integer type, String url) throws JSONException {
        return request(type, url, new HashMap<String, String>());
    }
    
    /**
     * Get auth frob
     * 
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public static String getFrob() throws JSONException {
        String api_sig = calcApiSig(oDeskAPI.secret);
        JSONObject json = oDeskRestClient.getJSONObject(oDeskAPI.URL_FROBS + getApiKeysUri(api_sig));
        oDeskAPI.frob = json.getString("frob");

        return oDeskAPI.frob;
    }
    
    /**
     * Get token based on auth frob, can be called obly after getFrob(),
     * which setup auth frob in class property
     * 
     * @throws  JSONException
     * @return  {@link JSONObject}
     * */
    public String getApiToken() throws JSONException {
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("frob", oDeskAPI.frob);
        
        String api_sig = calcApiSig(oDeskAPI.secret, p);        
        JSONObject json = oDeskRestClient.getJSONObject(oDeskAPI.URL_TOKENS + getApiKeysUri(api_sig) + "&frob=" + frob);
        oDeskAPI.api_token = json.getString("token");

        return oDeskAPI.api_token;
    }
    
    public void setApiToken(String apiToken) {
    	oDeskAPI.api_token = apiToken;
    }
    
    private static JSONObject sendRequest(String url, Integer type) throws JSONException {
        return oDeskRestClient.getJSONObject(url, type);
    }
    
    @SuppressWarnings("unused")
    private static JSONObject sendRequest(String url) throws JSONException {
        return sendRequest(url, METHOD_GET);
    }
    
    private static String getApiKeysUri(String api_sig) {
        return "?api_key=" + oDeskAPI.api_key + "&api_sig=" + api_sig;
    }
    
    private static String mergeParamsToUri(String uri, HashMap<String, String> params) {
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
    
    private static String calcApiSig(String app_secret, HashMap<String, String> params) {
        params.put("api_key", oDeskAPI.api_key);
        return md5(app_secret + normalizeParams(params));
    }
    
    private static String calcApiSig(String app_secret) {
        return calcApiSig(app_secret, new HashMap<String, String>());
    }
    
    private static String normalizeParams(HashMap<String, String> params, String rkey) {
        String line = "";
        
        if (params.size() == 0)
            return line;
        
        Map<String, String> myparams = sortMapByKey(params);
        for (Map.Entry<String, String> entry : myparams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            
            //TODO: support multidimensional arrays  
            try {
                line += rkey + key + URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 encoding not supported in URLEncode");
            }
        }
        
        return line;
    }
    
    private static String normalizeParams(HashMap<String, String> params) {
        return normalizeParams(params, "");
    }
    
    private static String md5(String str) {
        String md5;
        
        try {
            MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
            mdEnc.update(str.getBytes(), 0, str.length());
            md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not supported");
        }
        
        return md5;
    }
    
    private static Map<String, String> sortMapByKey(Map<String, String> aItems){
        TreeMap<String, String> result =
          new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER)
        ;
        result.putAll(aItems);
        
        return result;
    }
}
