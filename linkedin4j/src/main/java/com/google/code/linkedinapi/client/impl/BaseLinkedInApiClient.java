/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientException;
import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls;
import com.google.code.linkedinapi.client.constant.ParameterNames;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls.LinkedInApiUrlBuilder;
import com.google.code.linkedinapi.client.enumeration.CompanyField;
import com.google.code.linkedinapi.client.enumeration.ConnectionModificationType;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.HttpMethod;
import com.google.code.linkedinapi.client.enumeration.JobField;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProductField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchScope;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Attribution;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.CompanySearch;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Content;
import com.google.code.linkedinapi.schema.Error;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.HttpHeader;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobBookmark;
import com.google.code.linkedinapi.schema.JobBookmarks;
import com.google.code.linkedinapi.schema.JobSearch;
import com.google.code.linkedinapi.schema.JobSuggestions;
import com.google.code.linkedinapi.schema.Jobs;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Products;
import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.Share;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.Visibility;
import com.google.code.linkedinapi.schema.VisibilityType;

/**
 * @author Nabeel Mukhtar
 *
 */
public abstract class BaseLinkedInApiClient implements LinkedInApiClient {

    /** Field description */
    private static final String GZIP_ENCODING = "gzip";
    
    /** Field description */
    private static final Charset UTF_8_CHAR_SET = Charset.forName(ApplicationConstants.CONTENT_ENCODING);
    
    /** Field description */
    private final SchemaElementFactory<?> OBJECT_FACTORY = createObjectFactory();

    /** The static logger. */
    protected final Logger LOG = Logger.getLogger(getClass().getCanonicalName());
    
    /** Field description */
    private LinkedInAccessToken accessToken;

    /** Field description */
    private LinkedInApiConsumer apiConsumer;

    /** Field description */
    private Map<String, String> requestHeaders;

    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    protected BaseLinkedInApiClient(String consumerKey, String consumerSecret) {
        requestHeaders = new HashMap<String, String>();

        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
        apiConsumer = new LinkedInApiConsumer(consumerKey, consumerSecret);
    }

    /**
     * {@inheritDoc}
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * {@inheritDoc}
     */
    public void addRequestHeader(String headerName, String headerValue) {
        requestHeaders.put(headerName, headerValue);
    }

    /**
     * {@inheritDoc}
     */
    public void removeRequestHeader(String headerName) {
        requestHeaders.remove(headerName);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void addLocale(Locale locale) {
    	// TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    public void setApiConsumer(LinkedInApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedInApiConsumer getApiConsumer() {
        return apiConsumer;
    }

    /**
     * {@inheritDoc}
     */
    public void setAccessToken(LinkedInAccessToken accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedInAccessToken getAccessToken() {
        return accessToken;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID, id).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields) {
        assertNotNullOrEmpty("id", id);
        assertNotNull("profile fields", profileFields);
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url) {
        assertNotNullOrEmpty("url", url);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.URL, url, true).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields) {
        assertNotNullOrEmpty("url", url);
        assertNotNull("profile fields", profileFields);
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField(ParameterNames.URL, url, true).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields) {
        assertNotNull("profile fields", profileFields);
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, int start, int count) {
        assertNotNullOrEmpty("id", id);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID,
                                            id).withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count) {
        assertNotNullOrEmpty("id", id);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("profile fields", profileFields);
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).withParameter(ParameterNames.START,
                                                String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                    String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, int start, int count) {
        assertNotNullOrEmpty("url", url);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.URL, url,
                                            true).withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count) {
        assertNotNullOrEmpty("url", url);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("profile fields", profileFields);
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField(ParameterNames.URL, url, true).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).withParameter(ParameterNames.START,
                                                String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                    String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(int start, int count) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("profile fields", profileFields);
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }
    
    // nabeel
    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("id", id);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID, id).withParameter(ParameterNames.MODIFIED_SINCE,
                String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("id", id);
        assertNotNull("profile fields", profileFields);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).withParameter(ParameterNames.MODIFIED_SINCE,
                                                    String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("url", url);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.URL, url, true).withParameter(ParameterNames.MODIFIED_SINCE,
                String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("url", url);
        assertNotNull("profile fields", profileFields);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);
        
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField(ParameterNames.URL, url, true).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).withParameter(ParameterNames.MODIFIED_SINCE,
                                                    String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);
    	
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameter(ParameterNames.MODIFIED_SINCE,
                String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNull("profile fields", profileFields);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);
        
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameter(ParameterNames.MODIFIED_SINCE,
                String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, int start, int count, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("id", id);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID,
                                            id).withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).withParameter(ParameterNames.MODIFIED_SINCE,
                                                        String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("id", id);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("profile fields", profileFields);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);
        
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).withParameter(ParameterNames.START,
                                                String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                    String.valueOf(count)).withParameter(ParameterNames.MODIFIED_SINCE,
                                                            String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, int start, int count, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("url", url);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.URL, url,
                                            true).withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).withParameter(ParameterNames.MODIFIED_SINCE,
                                                        String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count, Date modificationDate, ConnectionModificationType modificationType) {
        assertNotNullOrEmpty("url", url);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("profile fields", profileFields);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);
        
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField(ParameterNames.URL, url, true).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                            profileFields).withParameter(ParameterNames.START,
                                                String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                    String.valueOf(count)).withParameter(ParameterNames.MODIFIED_SINCE,
                                                            String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(int start, int count, Date modificationDate, ConnectionModificationType modificationType) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).withParameter(ParameterNames.MODIFIED_SINCE,
                                                        String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count, Date modificationDate, ConnectionModificationType modificationType) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("profile fields", profileFields);
        assertNotNull("modification date", modificationDate);
        assertNotNull("modification type", modificationType);
        
        profileFields.retainAll(CONNECTION_FIELDS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).withParameter(ParameterNames.MODIFIED_SINCE,
                                                        String.valueOf(modificationDate.getTime())).withParameterEnum(ParameterNames.MODIFICATION, modificationType).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(int start, int count) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Date startDate, Date endDate) {
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.AFTER,
                                            String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                String.valueOf(endDate.getTime())).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes) {
        assertNotNull("update types", updateTypes);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameterEnumSet(ParameterNames.TYPE, updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("update types", updateTypes);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).withParameterEnumSet(ParameterNames.TYPE, updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate) {
        assertNotNull("update types", updateTypes);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.AFTER,
                                            String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                String.valueOf(endDate.getTime())).withParameterEnumSet(ParameterNames.TYPE,
                                                    updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate) {
        assertNotNull("update types", updateTypes);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).withParameter(ParameterNames.AFTER,
                                                String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                    String.valueOf(endDate.getTime())).withParameterEnumSet(ParameterNames.TYPE,
                                                        updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate, boolean showHiddenMembers) {
        assertNotNull("update types", updateTypes);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).withParameter(ParameterNames.AFTER,
                                                String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                    String.valueOf(endDate.getTime())).withParameterEnumSet(ParameterNames.TYPE,
                                                        updateTypes).withParameter(ParameterNames.SHOW_HIDDEN_MEMBERS,
                                                                String.valueOf(showHiddenMembers)).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.SCOPE, "self").buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(int start, int count) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(Date startDate, Date endDate) {
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.AFTER,
                                            String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                String.valueOf(endDate.getTime())).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes) {
        assertNotNull("update types", updateTypes);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.SCOPE, "self").withParameterEnumSet(ParameterNames.TYPE, updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes, int start, int count) {
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("update types", updateTypes);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).withParameterEnumSet(ParameterNames.TYPE, updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate) {
        assertNotNull("update types", updateTypes);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.AFTER,
                                            String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                String.valueOf(endDate.getTime())).withParameterEnumSet(ParameterNames.TYPE,
                                                    updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate) {
        assertNotNull("update types", updateTypes);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).withParameter(ParameterNames.AFTER,
                                                String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                    String.valueOf(endDate.getTime())).withParameterEnumSet(ParameterNames.TYPE,
                                                        updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(String id) {
    	assertNotNullOrEmpty("id", id);    	
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.USER_UPDATES);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withParameter(ParameterNames.SCOPE, "self").buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(String id, int start, int count) {
    	assertNotNullOrEmpty("id", id);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.USER_UPDATES);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(String id, Date startDate, Date endDate) {
    	assertNotNullOrEmpty("id", id);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.USER_UPDATES);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.AFTER,
                                            String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                String.valueOf(endDate.getTime())).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes) {
    	assertNotNullOrEmpty("id", id);
        assertNotNull("update types", updateTypes);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.USER_UPDATES);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withParameter(ParameterNames.SCOPE, "self").withParameterEnumSet(ParameterNames.TYPE, updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes, int start, int count) {
    	assertNotNullOrEmpty("id", id);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        assertNotNull("update types", updateTypes);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.USER_UPDATES);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).withParameterEnumSet(ParameterNames.TYPE, updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate) {
    	assertNotNullOrEmpty("id", id);
        assertNotNull("update types", updateTypes);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.USER_UPDATES);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.AFTER,
                                            String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                String.valueOf(endDate.getTime())).withParameterEnumSet(ParameterNames.TYPE,
                                                    updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate) {
    	assertNotNullOrEmpty("id", id);
        assertNotNull("update types", updateTypes);
        assertNotNull("start date", startDate);
        assertNotNull("end date", endDate);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.USER_UPDATES);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withParameter(ParameterNames.SCOPE, "self").withParameter(ParameterNames.START, String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                            String.valueOf(count)).withParameter(ParameterNames.AFTER,
                                                String.valueOf(startDate.getTime())).withParameter(ParameterNames.BEFORE,
                                                    String.valueOf(endDate.getTime())).withParameterEnumSet(ParameterNames.TYPE,
                                                        updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateComments getNetworkUpdateComments(String networkUpdateId) {
        assertNotNullOrEmpty("network update id", networkUpdateId);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATE_COMMENTS);
        String                apiUrl  = builder.withField(ParameterNames.UPDATE_KEY, networkUpdateId).buildUrl();

        return readResponse(UpdateComments.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    public Person getProfileById(String id, ProfileType profileType) {
        return getProfileById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID,
                                            id).withFieldEnum(ParameterNames.PROFILE_TYPE, ProfileType.STANDARD).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    public Person getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields) {
        return getProfileById(id, profileFields);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, Set<ProfileField> profileFields) {
        assertNotNullOrEmpty("id", id);
        assertNotNull("profile fields", profileFields);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).withFieldEnum(ParameterNames.PROFILE_TYPE,
                                            ProfileType.STANDARD).withFieldEnumSet(ParameterNames.FIELD_SELECTORS,
                                                profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType) {
        assertNotNullOrEmpty("url", url);
        assertNotNull("profile type", profileType);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.URL, url,
                                            true).withFieldEnum(ParameterNames.PROFILE_TYPE, profileType).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields) {
        assertNotNullOrEmpty("url", url);
        assertNotNull("profile fields", profileFields);
        assertNotNull("profile type", profileType);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withField(ParameterNames.URL, url, true).withFieldEnum(ParameterNames.PROFILE_TYPE,
                                            profileType).withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields) {
        assertNotNull("profile fields", profileFields);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByApiRequest(ApiStandardProfileRequest apiRequest) {
        assertNotNull("api request", apiRequest);

        if (apiRequest.getHeaders() != null) {
            return readResponse(Person.class,
                                callApiMethod(apiRequest.getUrl(), apiRequest.getHeaders().getHttpHeaderList()));
        } else {
            return readResponse(Person.class, callApiMethod(apiRequest.getUrl()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postComment(String networkUpdateId, String commentText) {
        assertNotNullOrEmpty("network update id", networkUpdateId);
        assertNotNullOrEmpty("comment", commentText);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_COMMENT);
        String                apiUrl  = builder.withField(ParameterNames.UPDATE_KEY, networkUpdateId).buildUrl();
        UpdateComment         comment = OBJECT_FACTORY.createUpdateComment();

        comment.setComment(commentText);
        callApiMethod(apiUrl, marshallObject(comment), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postNetworkUpdate(String updateText) {
        assertNotNullOrEmpty("network update", updateText);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_UPDATE);
        String                apiUrl  = builder.buildUrl();
        Activity              update  = OBJECT_FACTORY.createActivity();

        update.setBody(updateText);
        update.setLocale(Locale.getDefault().toString());
        update.setContentType(NetworkUpdateContentType.LINKED_IN_HTML);
        update.setTimestamp(System.currentTimeMillis());
        callApiMethod(apiUrl, marshallObject(update), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters) {
        assertNotNull("search parameters", searchParameters);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, int start, int count,
			SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			int start, int count, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			int start, int count, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("profile fields", profileFields);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, int start, int count,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, SearchSortOrder sortOrder,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public People searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, int start, int count,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        PeopleSearch response = readResponse(PeopleSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getPeople();
	}
    
    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count,
			SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields, SearchSortOrder sortOrder,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters,
			Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("profile fields", profileFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.PEOPLE);
        filterFacets(facets, PEOPLE_FACETS, SearchScope.PEOPLE);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, profileFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        return readResponse(PeopleSearch.class, callApiMethod(apiUrl));
	}
	
    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInviteByEmail(String email, String firstName, String lastName, String subject, String message) {
        assertNotNullOrEmpty("email", email);
        assertNotNullOrEmpty("firstName", firstName);
        assertNotNullOrEmpty("lastName", lastName);
        assertNotNullOrEmpty("subject", subject);
        assertNotNullOrEmpty("message", message);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl  = builder.buildUrl();
        MailboxItem           invite  = OBJECT_FACTORY.createMailboxItem();

        invite.setBody(message);
        invite.setSubject(subject);
        invite.setRecipients(OBJECT_FACTORY.createRecipients());

        Person person = OBJECT_FACTORY.createPerson();

        person.setPath(createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_INVITE_EMAIL_PERSON_PATH).withField(ParameterNames.EMAIL,
                email).buildUrl());
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Recipient recepient = OBJECT_FACTORY.createRecipient();

        recepient.setPerson(person);
        invite.getRecipients().getRecipientList().add(recepient);
        invite.setItemContent(OBJECT_FACTORY.createItemContent());

        InvitationRequest request = OBJECT_FACTORY.createInvitationRequest();

        request.setConnectType(InviteConnectType.FRIEND);
        invite.getItemContent().setInvitationRequest(request);
        callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInviteById(String recepientId, String subject, String message, String authHeader) {
        assertNotNullOrEmpty("recepient id", recepientId);
        assertNotNullOrEmpty("subject", subject);
        assertNotNullOrEmpty("message", message);
        assertNotNullOrEmpty("auth header", authHeader);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl  = builder.buildUrl();
        MailboxItem           invite  = OBJECT_FACTORY.createMailboxItem();

        invite.setBody(message);
        invite.setSubject(subject);
        invite.setRecipients(OBJECT_FACTORY.createRecipients());

        Person person = OBJECT_FACTORY.createPerson();

        person.setPath(createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_INVITE_ID_PERSON_PATH).withField(ParameterNames.ID,
                recepientId).buildUrl());

        Recipient recepient = OBJECT_FACTORY.createRecipient();

        recepient.setPerson(person);
        invite.getRecipients().getRecipientList().add(recepient);
        invite.setItemContent(OBJECT_FACTORY.createItemContent());

        InvitationRequest request = OBJECT_FACTORY.createInvitationRequest();

        request.setConnectType(InviteConnectType.FRIEND);

        String[] authTuple = authHeader.split(":");

        if (authTuple.length == 2) {
            Authorization authorization = OBJECT_FACTORY.createAuthorization();

            authorization.setName(authTuple[0]);
            authorization.setValue(authTuple[1]);
            request.setAuthorization(authorization);
        }

        invite.getItemContent().setInvitationRequest(request);
        callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInviteToPerson(Person recepient, String subject, String message) {
        assertNotNull("recepient", recepient);
        assertNotNull("recepient api request", recepient.getApiStandardProfileRequest());

        String authHeader = null;

        if (recepient.getApiStandardProfileRequest().getHeaders() != null) {
            for (HttpHeader header : recepient.getApiStandardProfileRequest().getHeaders().getHttpHeaderList()) {
                if (ApplicationConstants.AUTH_HEADER_NAME.equals(header.getName())) {
                    authHeader = header.getValue();

                    break;
                }
            }
        }

        sendInviteById(recepient.getId(), subject, message, authHeader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(List<String> recepientIds, String subject, String message) {
        assertNotNullOrEmpty("recepient ids", recepientIds);
        assertNotNullOrEmpty("subject", subject);
        assertNotNullOrEmpty("message", message);

        LinkedInApiUrlBuilder builder     = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl      = builder.buildUrl();
        MailboxItem           messageItem = OBJECT_FACTORY.createMailboxItem();

        messageItem.setBody(message);
        messageItem.setSubject(subject);
        messageItem.setRecipients(OBJECT_FACTORY.createRecipients());

        for (String recepientId : recepientIds) {
            Person person = OBJECT_FACTORY.createPerson();

            person.setPath(createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE_PERSON_PATH).withField(ParameterNames.ID,
                    recepientId).buildUrl());

            Recipient recepient = OBJECT_FACTORY.createRecipient();

            recepient.setPerson(person);
            messageItem.getRecipients().getRecipientList().add(recepient);
        }

        callApiMethod(apiUrl, marshallObject(messageItem), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     * @deprecated Use {@link #postShare(String, String, String, String, VisibilityType)}
     */
    @Override
    @Deprecated
    public void updateCurrentStatus(String statusText) {
    	updateCurrentStatus(statusText, false);
    }
    
    /**
     * {@inheritDoc}
     * @deprecated Use {@link #postShare(String, String, String, String, VisibilityType, boolean)}
     */
    @Override
    @Deprecated
    public void updateCurrentStatus(String statusText, boolean postToTwitter) {
        if (isNullOrEmpty(statusText)) {
            deleteCurrentStatus();
        } else {
            LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_STATUS);
            if (postToTwitter) {
            	builder.withParameter(ParameterNames.TWITTER_POST, "true");
            }
            String                apiUrl  = builder.buildUrl();
            Object                status  = OBJECT_FACTORY.createCurrentStatus(statusText);

            callApiMethod(apiUrl, marshallObject(status), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT,
                          HttpURLConnection.HTTP_NO_CONTENT);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCurrentStatus() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_STATUS);
        String                apiUrl  = builder.buildUrl();

        callApiMethod(apiUrl, null, null, HttpMethod.DELETE, HttpURLConnection.HTTP_NO_CONTENT);
    }

	@Override
	public Likes getNetworkUpdateLikes(String networkUpdateId) {
        assertNotNullOrEmpty("network update id", networkUpdateId);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATE_LIKES);
        String                apiUrl  = builder.withField(ParameterNames.UPDATE_KEY, networkUpdateId).buildUrl();

        return readResponse(Likes.class, callApiMethod(apiUrl));
	}

	@Override
	public void likePost(String networkUpdateId) {
        assertNotNullOrEmpty("network update id", networkUpdateId);
        
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATE_LIKE);
        String                apiUrl  = builder.withField(ParameterNames.UPDATE_KEY, networkUpdateId).buildUrl();
        Object share = OBJECT_FACTORY.createIsLiked(true);

        callApiMethod(apiUrl, marshallObject(share), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT,
                      HttpURLConnection.HTTP_CREATED);
	}

	@Override
	public void postShare(String commentText, String title, String url,
			String imageUrl, VisibilityType visibility) {
		postShare(commentText, title, null, url, imageUrl, visibility, false);
	}

	@Override
	public void postShare(String commentText, String title, String url,
			String imageUrl, VisibilityType visibilityType, boolean postToTwitter) {
		postShare(commentText, title, null, url, imageUrl, visibilityType, postToTwitter);
	}
	
	@Override
	public void postShare(String commentText, String title, String description, String url,
			String imageUrl, VisibilityType visibilityType) {
		postShare(commentText, title, description, url, imageUrl, visibilityType, false);		
	}
	
	@Override
	public void postShare(String commentText, String title, String description, String url,
			String imageUrl, VisibilityType visibilityType, boolean postToTwitter) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_SHARE);
        if (postToTwitter) {
        	builder.withParameter(ParameterNames.TWITTER_POST, "true");
        }
        String                apiUrl  = builder.buildUrl();
        Share share = OBJECT_FACTORY.createShare();
        share.setComment(commentText);
        Content content = OBJECT_FACTORY.createContent();
        content.setSubmittedUrl(url);
        content.setSubmittedImageUrl(imageUrl);
        content.setTitle(title);
        content.setDescription(description);
        share.setContent(content);
        Visibility visibility = OBJECT_FACTORY.createVisibility();
        visibility.setCode(visibilityType);
        share.setVisibility(visibility);

        callApiMethod(apiUrl, marshallObject(share), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
	}
	
	@Override
	public void reShare(String shareId, String commentText, VisibilityType visibilityType) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.RE_SHARE);
        String                apiUrl  = builder.buildUrl();
        Share share = OBJECT_FACTORY.createShare();
        share.setComment(commentText);
        Attribution attribution = OBJECT_FACTORY.createAttribution();
        Share refShare = OBJECT_FACTORY.createShare();
        refShare.setId(shareId);
        attribution.setShare(refShare);
        share.setAttribution(attribution);
        Visibility visibility = OBJECT_FACTORY.createVisibility();
        visibility.setCode(visibilityType);
        share.setVisibility(visibility);

        callApiMethod(apiUrl, marshallObject(share), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
	}

	@Override
	public void unlikePost(String networkUpdateId) {
        assertNotNullOrEmpty("network update id", networkUpdateId);
        
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATE_LIKE);
        String                apiUrl  = builder.withField(ParameterNames.UPDATE_KEY, networkUpdateId).buildUrl();
        Object share = OBJECT_FACTORY.createIsLiked(false);

        callApiMethod(apiUrl, marshallObject(share), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT,
                      HttpURLConnection.HTTP_CREATED);
	}
	
	@Override
	public void bookmarkJob(String jobId) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.BOOKMARK_JOB);
        String apiUrl = builder.buildUrl();
        JobBookmark bookmark = OBJECT_FACTORY.createJobBookmark();
        Job job = OBJECT_FACTORY.createJob();
        job.setId(jobId);
        bookmark.setJob(job);
        callApiMethod(apiUrl, marshallObject(bookmark), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                HttpURLConnection.HTTP_CREATED);
	}

	@Override
	public void closeJob(String partnerJobId) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.CLOSE_JOB);
        String                apiUrl  = builder.withField(ParameterNames.ID, partnerJobId).buildUrl();

        callApiMethod(apiUrl, null, null, HttpMethod.DELETE, HttpURLConnection.HTTP_OK);
	}

	@Override
	public JobBookmarks getJobBookmarks() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_JOB_BOOKMARKS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        return readResponse(JobBookmarks.class, callApiMethod(apiUrl));
	}

	@Override
	public JobBookmarks getJobBookmarks(Set<JobField> jobFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_JOB_BOOKMARKS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).buildUrl();

        return readResponse(JobBookmarks.class, callApiMethod(apiUrl));
	}
	
	@Override
	public Job getJobById(String id) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_JOB_BY_ID);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID,
                                            id).buildUrl();

        return readResponse(Job.class, callApiMethod(apiUrl));
	}

	@Override
	public Job getJobById(String id, Set<JobField> jobFields) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_JOB_BY_ID);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withField(ParameterNames.ID,
                                            id).buildUrl();

        return readResponse(Job.class, callApiMethod(apiUrl));
	}

	@Override
	public Jobs getJobSuggestions() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_JOB_SUGGESTIONS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        JobSuggestions response = readResponse(JobSuggestions.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

	@Override
	public Jobs getJobSuggestions(Set<JobField> jobFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_JOB_SUGGESTIONS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).buildUrl();

        JobSuggestions response = readResponse(JobSuggestions.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

	@Override
	public void postJob(Job job) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_JOB);
        String                apiUrl  = builder.buildUrl();
        callApiMethod(apiUrl, marshallObject(job), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                HttpURLConnection.HTTP_OK);
	}

	@Override
	public void renewJob(String partnerJobId, String contractId) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.RENEW_JOB);
        String                apiUrl  = builder.withField(ParameterNames.ID, partnerJobId).buildUrl();
        Job job = OBJECT_FACTORY.createJob();
        job.setContractId(Long.parseLong(contractId));
        job.setRenewal(OBJECT_FACTORY.createRenewal());

        callApiMethod(apiUrl, marshallObject(job), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT,
                HttpURLConnection.HTTP_OK);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public Jobs searchJobs() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters) {
        assertNotNull("search parameters", searchParameters);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, int start, int count,
			SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			int start, int count, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			int start, int count, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("job fields", jobFields);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, int start, int count,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, SearchSortOrder sortOrder,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Jobs searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, int start, int count,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        JobSearch response = readResponse(JobSearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getJobs();
	}
    
    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count,
			SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields, SearchSortOrder sortOrder,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public JobSearch searchJobs(Map<SearchParameter, String> searchParameters,
			Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("job fields", jobFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.JOBS);
        filterFacets(facets, JOB_FACETS, SearchScope.JOBS);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_JOBS_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, jobFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        return readResponse(JobSearch.class, callApiMethod(apiUrl));
	}

	@Override
	public void unbookmarkJob(String jobId) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.UNBOOKMARK_JOB);
        String                apiUrl  = builder.withField(ParameterNames.ID, jobId).buildUrl();

        callApiMethod(apiUrl, null, null, HttpMethod.DELETE, HttpURLConnection.HTTP_NO_CONTENT);
	}

	@Override
	public void updateJob(String partnerJobId, Job job) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.RENEW_JOB);
        String                apiUrl  = builder.withField(ParameterNames.ID, partnerJobId).buildUrl();

        callApiMethod(apiUrl, marshallObject(job), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT,
                HttpURLConnection.HTTP_OK);
	}

	@Override
	public void followCompany(String id) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.FOLLOW_COMPANY);
        String apiUrl = builder.buildUrl();
        Company company = OBJECT_FACTORY.createCompany();
        company.setId(id);
        callApiMethod(apiUrl, marshallObject(company), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                HttpURLConnection.HTTP_CREATED);
	}

	@Override
	public Companies getCompaniesByEmailDomain(String emailDomain) {
        assertNotNullOrEmpty("email domain", emailDomain);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANIES_BY_EMAIL_DOMAIN);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.EMAIL,
        									emailDomain).buildUrl();

        return readResponse(Companies.class, callApiMethod(apiUrl));
	}

	@Override
	public Companies getCompaniesByEmailDomain(String emailDomain, Set<CompanyField> companyFields) {
        assertNotNullOrEmpty("email domain", emailDomain);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANIES_BY_EMAIL_DOMAIN);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withField(ParameterNames.EMAIL,
        									emailDomain).buildUrl();

        return readResponse(Companies.class, callApiMethod(apiUrl));
	}

	@Override
	public Company getCompanyById(String id) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_BY_ID);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID,
        									id).buildUrl();

        return readResponse(Company.class, callApiMethod(apiUrl));
	}

	@Override
	public Company getCompanyById(String id, Set<CompanyField> companyFields) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_BY_ID);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withField(ParameterNames.ID,
        									id).buildUrl();

        return readResponse(Company.class, callApiMethod(apiUrl));
	}

	@Override
	public Company getCompanyByUniversalName(String universalName) {
        assertNotNullOrEmpty("universal name", universalName);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_BY_UNIVERSAL_NAME);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.NAME,
        									universalName).buildUrl();

        return readResponse(Company.class, callApiMethod(apiUrl));
	}

	@Override
	public Company getCompanyByUniversalName(String universalName, Set<CompanyField> companyFields) {
        assertNotNullOrEmpty("universal name", universalName);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_BY_UNIVERSAL_NAME);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withField(ParameterNames.NAME,
        									universalName).buildUrl();

        return readResponse(Company.class, callApiMethod(apiUrl));
	}

	@Override
	public Products getCompanyProducts(String id) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_PRODUCTS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID,
        									id).buildUrl();

        return readResponse(Products.class, callApiMethod(apiUrl));
	}

	@Override
	public Products getCompanyProducts(String id, Set<ProductField> productFields) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_PRODUCTS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, productFields).withField(ParameterNames.ID,
        									id).buildUrl();

        return readResponse(Products.class, callApiMethod(apiUrl));
	}

	@Override
	public Products getCompanyProducts(String id, int start, int count) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_PRODUCTS);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withField(ParameterNames.ID,
        									id).withParameter(ParameterNames.START,
                                                    String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                            String.valueOf(count)).buildUrl();

        return readResponse(Products.class, callApiMethod(apiUrl));
	}

	@Override
	public Products getCompanyProducts(String id, Set<ProductField> productFields, int start, int count) {
        assertNotNullOrEmpty("id", id);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_COMPANY_PRODUCTS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, productFields).withField(ParameterNames.ID,
        									id).withParameter(ParameterNames.START,
                                                    String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                            String.valueOf(count)).buildUrl();

        return readResponse(Products.class, callApiMethod(apiUrl));
	}

	@Override
	public Companies getFollowedCompanies() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_FOLLOWED_COMPANIES);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        return readResponse(Companies.class, callApiMethod(apiUrl));
	}

	@Override
	public Companies getFollowedCompanies(Set<CompanyField> companyFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_FOLLOWED_COMPANIES);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).buildUrl();

        return readResponse(Companies.class, callApiMethod(apiUrl));
	}

	@Override
	public Companies getSuggestedCompanies() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_SUGGESTED_COMPANIES);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        return readResponse(Companies.class, callApiMethod(apiUrl));
	}

	@Override
	public Companies getSuggestedCompanies(Set<CompanyField> companyFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_SUGGESTED_COMPANIES);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).buildUrl();

        return readResponse(Companies.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public Companies searchCompanies() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters) {
        assertNotNull("search parameters", searchParameters);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, int start, int count,
			SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			int start, int count, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			int start, int count, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withEmptyField(ParameterNames.FIELD_SELECTORS).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("company fields", companyFields);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, int start, int count,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, SearchSortOrder sortOrder,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Companies searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, int start, int count,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        CompanySearch response = readResponse(CompanySearch.class, callApiMethod(apiUrl));
        return (response == null)? null : response.getCompanies();
	}
    
    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields, SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count,
			SearchSortOrder sortOrder) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  = builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameter(ParameterNames.START,
                                            String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                String.valueOf(count)).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields, SearchSortOrder sortOrder,
			List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertNotNull("sort order", sortOrder);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT, sortOrder).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters,
			Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count,
			SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets) {
        assertNotNull("search parameters", searchParameters);
        assertNotNull("company fields", companyFields);
        assertNotNull("facet fields", facetFields);
        assertNotNullOrEmpty("facets", facets);
        assertPositiveNumber("start", start);
        assertPositiveNumber("count", count);
        filterSearchParameters(searchParameters, SearchScope.COMPANIES);
        filterFacets(facets, COMPANY_FACETS, SearchScope.COMPANIES);

        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_COMPANIES_FACETS);
        String                apiUrl  =
            builder.withFieldEnumSet(ParameterNames.FIELD_SELECTORS, companyFields).withFieldEnumSet(ParameterNames.FACET_FIELDS, facetFields).withParameterEnumMap(searchParameters).withFacets(facets).withParameterEnum(ParameterNames.SORT,
                                         sortOrder).withParameter(ParameterNames.START,
                                             String.valueOf(start)).withParameter(ParameterNames.COUNT,
                                                 String.valueOf(count)).buildUrl();

        return readResponse(CompanySearch.class, callApiMethod(apiUrl));
	}

	@Override
	public void unfollowCompany(String id) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.UNFOLLOW_COMPANY);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).buildUrl();

        callApiMethod(apiUrl, null, null, HttpMethod.DELETE, HttpURLConnection.HTTP_NO_CONTENT);
	}
	
    /**
     * Method description
     *
     *
     *
     *
     * @param clazz
     * @param is
     * @param <T>
     *
     * @return
     */
    protected <T> T readResponse(Class<T> clazz, InputStream is) {
        try {
            return unmarshallObject(clazz, is);
        } finally {
            closeStream(is);
        }
    }

    /**
     *
     *
     * @param apiUrl
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl) {
    	final List<HttpHeader> httpHeaders = Collections.emptyList();
        return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK, httpHeaders);
    }

    /**
     *
     *
     * @param apiUrl
     * @param httpHeaders
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, List<HttpHeader> httpHeaders) {
        return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK, httpHeaders);
    }

    /**
     *
     *
     * @param apiUrl
     * @param expected
     * @param httpHeaders
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, int expected, List<HttpHeader> httpHeaders) {
        try {
            LinkedInOAuthService oAuthService =
                LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(apiConsumer.getConsumerKey(),
                    apiConsumer.getConsumerSecret());
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }

            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }
            
            for (HttpHeader header : httpHeaders) {
                request.setRequestProperty(header.getName(), header.getValue());
            }
            
            oAuthService.signRequestWithToken(request, accessToken);
            request.connect();

            if (request.getResponseCode() != expected) {
                Error error = readResponse(Error.class,
                                           getWrappedInputStream(request.getErrorStream(),
                                               GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));

                throw createLinkedInApiClientException(error);
            } else {
                return getWrappedInputStream(request.getInputStream(),
                                             GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     *
     *
     * @param apiUrl
     * @param xmlContent
     * @param contentType
     * @param method
     * @param expected
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, String xmlContent, String contentType, HttpMethod method,
            int expected) {
        try {
            LinkedInOAuthService oAuthService =
                LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(apiConsumer.getConsumerKey(),
                    apiConsumer.getConsumerSecret());
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }

            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }

            request.setRequestMethod(method.fieldName());
            request.setDoOutput(true);
            oAuthService.signRequestWithToken(request, accessToken);

            if (contentType != null) {
                request.setRequestProperty("Content-Type", contentType);
            }

            if (xmlContent != null) {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(request.getOutputStream(), UTF_8_CHAR_SET));

                out.print(xmlContent);
                out.flush();
                out.close();
            }

            request.connect();

            if (request.getResponseCode() != expected) {
                Error error = readResponse(Error.class,
                                           getWrappedInputStream(request.getErrorStream(),
                                               GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));

                throw createLinkedInApiClientException(error);
            } else {
                return getWrappedInputStream(request.getInputStream(),
                                             GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     * Method description
     *
     *
     * @param is
     *
     */
    protected void closeStream(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while closing stream.", e);	
        }
    }

    /**
     * Method description
     *
     *
     * @param connection
     *
     */
    protected void closeConnection(HttpURLConnection connection) {
        try {
        	if (connection != null) {
        		connection.disconnect();
        	}
        } catch (Exception e) {
        	LOG.log(Level.SEVERE, "An error occurred while disconnecting connection.", e);	
        }
    }
    
    /**
     * Method description
     *
     *
     * @param error
     * @return
     */
    protected LinkedInApiClientException createLinkedInApiClientException(Error error) {
        final String message    = error.getMessage();
        final String errorCode  = error.getErrorCode();
        final String requestId  = error.getRequestId();
        final int    statusCode = (error.getStatus() == null)
                                  ? 0
                                  : error.getStatus().intValue();
        final Date   timestamp  = (error.getTimestamp() == null)
                                  ? new Date()
                                  : new Date(error.getTimestamp());

        return new LinkedInApiClientException(message, statusCode, errorCode, timestamp, requestId);
    }

    /**
     * Method description
     *
     *
     * @param is
     * @param gzip
     * @return
     * @throws IOException
     */
    protected InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
        if (gzip) {
            return new BufferedInputStream(new GZIPInputStream(is));
        } else {
            return new BufferedInputStream(is);
        }
    }
    
    /**
     * Get property as long.
     *
     * @param s
     *
     * @return
     */
    protected boolean isNullOrEmpty(String s) {
        return ((s == null) || (s.length() == 0));
    }

    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertNotNullOrEmpty(String name, String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertNotNullOrEmpty(String name, Collection<?> value) {
        if ((value == null) || value.isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertPositiveNumber(String name, int value) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be less than zero.");
        }
    }

    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertNotNull(String name, Object value) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }
    
    protected void filterSearchParameters(Map<SearchParameter, String> searchParameters, SearchScope scope) {
    	Iterator<SearchParameter> iter = searchParameters.keySet().iterator();
    	while (iter.hasNext()) {
    		SearchParameter parameter = iter.next();
    		if (!parameter.hasScope(scope)) {
    			LOG.warning("Parameter " + parameter + " is not valid for scope " + scope 
    					+ ". It will be dropped from the criteria.");
    			iter.remove();
    		}
		}
    }
    
    protected void filterFacets(List<Parameter<FacetType, String>> facets, Set<FacetType> allowedFacets, SearchScope scope) {
    	Iterator<Parameter<FacetType, String>> iter = facets.iterator();
    	while (iter.hasNext()) {
    		Parameter<FacetType, String> facet = iter.next();
    		if (!allowedFacets.contains(facet.getName())) {
    			LOG.warning("Facet " + facet.getName() + " is not valid for scope " + scope 
    					+ ". It will be dropped from the criteria.");
    			iter.remove();
    		}
    	}
    }
    
	/**
	 * Stolen liberally from http://www.kodejava.org/examples/266.html
	 */
	protected static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
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
    
    /**
     * Method description
     *
     *
     *
     * @param clazz
     * @param xmlContent
     * @param <T>
     *
     * @return
     */
    protected abstract <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent);

    /**
     * Method description
     *
     *
     * @param element
     *
     * @return
     */
    protected abstract String marshallObject(Object element);

    /**
     * Method description
     *
     *
     * @param urlFormat
     *
     * @return
     */
    protected abstract LinkedInApiUrlBuilder createLinkedInApiUrlBuilder(String urlFormat);

    /**
     * Method description
     *
     * @return
     */
    protected abstract SchemaElementFactory<?> createObjectFactory();
}
