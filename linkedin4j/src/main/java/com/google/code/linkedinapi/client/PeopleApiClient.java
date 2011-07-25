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
package com.google.code.linkedinapi.client;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.linkedinapi.client.enumeration.ConnectionModificationType;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;

/**
 * The Interface PeopleApiClient.
 */
public interface PeopleApiClient extends LinkedInAuthenticationClient {
	
    /** Field description */
    public static final Set<ProfileField> CONNECTION_FIELDS = ProfileField.valuesForConnections();
    public static final Set<FacetType> PEOPLE_FACETS = EnumSet.of(FacetType.LOCATION, FacetType.INDUSTRY, FacetType.NETWORK, FacetType.LANGUAGE, FacetType.CURRENT_COMPANY, FacetType.PAST_COMPANY, FacetType.SCHOOL);

    // Profile API. Return Profile bean

    /**
     * Gets the profile for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @return the profile for current user
     */
    public Person getProfileForCurrentUser();

    /**
     * Gets the profile by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param id the id
     * 
     * @return the profile by id
     */
    public Person getProfileById(String id);
    
    /**
     * Gets the profile by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param url the url
     * @param profileType the profile type
     * 
     * @return the profile by url
     */
    public Person getProfileByUrl(String url, ProfileType profileType);

    /**
     * Gets the profile for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param profileFields the profile fields
     * 
     * @return the profile for current user
     */
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Gets the profile by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * 
     * @return the profile by id
     */
    public Person getProfileById(String id, Set<ProfileField> profileFields);
    
    /**
     * Gets the profile by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param url the url
     * @param profileType the profile type
     * @param profileFields the profile fields
     * 
     * @return the profile by url
     */
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields);

    /**
     * Gets the profile by API request.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param apiRequest the api request
     * 
     * @return the profile by api request
     */
    public Person getProfileByApiRequest(ApiStandardProfileRequest apiRequest);
    
    // Connections API

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser();

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url);

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param profileFields the profile fields
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param profileFields the profile fields
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields);

    // Connections API with Paging

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(int start, int count);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, int start, int count);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, int start, int count);

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count);
    
    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param profileFields the profile fields
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param profileFields the profile fields
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, Date modificationDate, ConnectionModificationType modificationType);

    // Connections API with Paging

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(int start, int count, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, int start, int count, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, int start, int count, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count, Date modificationDate, ConnectionModificationType modificationType);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count, Date modificationDate, ConnectionModificationType modificationType);
    
    // Search API

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @return the people
     */
    public People searchPeople();

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, int start, int count);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, SearchSortOrder sortOrder);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, int start, int count,
                               SearchSortOrder sortOrder);
    

    // Faceted Search
    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, int start, int count, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);
    
    
    // Facets and People
    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields, SearchSortOrder sortOrder);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count,
                               SearchSortOrder sortOrder);
    

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count, List<Parameter<FacetType, String>> facets);
    
    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public PeopleSearch searchPeople(Map<SearchParameter, String> searchParameters, Set<ProfileField> profileFields, Set<FacetField> facetFields, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);
}
