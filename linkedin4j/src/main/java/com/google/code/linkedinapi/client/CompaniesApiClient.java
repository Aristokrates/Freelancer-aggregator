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

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.linkedinapi.client.enumeration.CompanyField;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.ProductField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.CompanySearch;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.Products;

/**
 * The Interface CompaniesApiClient.
 */
public interface CompaniesApiClient extends LinkedInAuthenticationClient {
    public static final Set<FacetType> COMPANY_FACETS = EnumSet.of(FacetType.LOCATION, FacetType.INDUSTRY, FacetType.NETWORK, FacetType.COMPANY_SIZE, FacetType.NUM_FOLLOWERS_RANGE, FacetType.FORTUNE);
	
	/**
	 * Gets the company by id.
	 * 
	 * @param id the id
	 * 
	 * @return the company by id
	 */
	public Company getCompanyById(String id);
	
	/**
	 * Gets the company by id.
	 * 
	 * @param id the id
	 * @param companyFields the company fields
	 * 
	 * @return the company by id
	 */
	public Company getCompanyById(String id, Set<CompanyField> companyFields);
	
	/**
	 * Gets the company by universal name.
	 * 
	 * @param universalName the universal name
	 * 
	 * @return the company by universal name
	 */
	public Company getCompanyByUniversalName(String universalName);
	
	/**
	 * Gets the company by universal name.
	 * 
	 * @param universalName the universal name
	 * @param companyFields the company fields
	 * 
	 * @return the company by universal name
	 */
	public Company getCompanyByUniversalName(String universalName, Set<CompanyField> companyFields);
	
	/**
	 * Gets the companies by email domain.
	 * 
	 * @param emailDomain the email domain
	 * 
	 * @return the companies by email domain
	 */
	public Companies getCompaniesByEmailDomain(String emailDomain);
	
	/**
	 * Gets the companies by email domain.
	 * 
	 * @param emailDomain the email domain
	 * @param companyFields the company fields
	 * 
	 * @return the companies by email domain
	 */
	public Companies getCompaniesByEmailDomain(String emailDomain, Set<CompanyField> companyFields);
	
	/**
	 * Gets the followed companies.
	 * 
	 * @return the followed companies
	 */
	public Companies getFollowedCompanies();
	
	/**
	 * Gets the followed companies.
	 * 
	 * @param companyFields the company fields
	 * 
	 * @return the followed companies
	 */
	public Companies getFollowedCompanies(Set<CompanyField> companyFields);
	
	/**
	 * Follow company.
	 * 
	 * @param id the id
	 */
	public void followCompany(String id);
	
	/**
	 * Unfollow company.
	 * 
	 * @param id the id
	 */
	public void unfollowCompany(String id);
	
	/**
	 * Gets the suggested companies.
	 * 
	 * @return the suggested companies
	 */
	public Companies getSuggestedCompanies();
	
	/**
	 * Gets the suggested companies.
	 * 
	 * @param companyFields the company fields
	 * 
	 * @return the suggested companies
	 */
	public Companies getSuggestedCompanies(Set<CompanyField> companyFields);
	
	/**
	 * Gets the company products.
	 * 
	 * @param id the id
	 * 
	 * @return the company products
	 */
	public Products getCompanyProducts(String id);
	
	/**
	 * Gets the company products.
	 * 
	 * @param id the id
	 * @param productFields the product fields
	 * 
	 * @return the company products
	 */
	public Products getCompanyProducts(String id, Set<ProductField> productFields);
	
	/**
	 * Gets the company products.
	 * 
	 * @param id the id
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the company products
	 */
	public Products getCompanyProducts(String id, int start, int count);
	
	/**
	 * Gets the company products.
	 * 
	 * @param id the id
	 * @param productFields the product fields
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the company products
	 */
	public Products getCompanyProducts(String id, Set<ProductField> productFields, int start, int count);
	
    /**
     * Search companies.
     * 
     * @return the companies
     */
    public Companies searchCompanies();
    
    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, int start, int count);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param start the start
     * @param count the count
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, int start, int count);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param sortOrder the sort order
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, SearchSortOrder sortOrder);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, int start, int count,
                               SearchSortOrder sortOrder);
    

    // Faceted Search
    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, int start, int count, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param start the start
     * @param count the count
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, int start, int count, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the companies
     */
    public Companies searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);
    
    
    // Facets and Companies
    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * @param sortOrder the sort order
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields, SearchSortOrder sortOrder);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count,
                               SearchSortOrder sortOrder);
    

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * @param facets the facets
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * @param facets the facets
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count, List<Parameter<FacetType, String>> facets);
    
    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search companies.
     * 
     * @param searchParameters the search parameters
     * @param companyFields the company fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the company search
     */
    public CompanySearch searchCompanies(Map<SearchParameter, String> searchParameters, Set<CompanyField> companyFields, Set<FacetField> facetFields, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);
}
