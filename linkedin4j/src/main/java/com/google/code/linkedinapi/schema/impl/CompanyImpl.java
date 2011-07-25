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

package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.CompanyStatus;
import com.google.code.linkedinapi.schema.CompanyType;
import com.google.code.linkedinapi.schema.EmailDomains;
import com.google.code.linkedinapi.schema.EmployeeCountRange;
import com.google.code.linkedinapi.schema.Locations;
import com.google.code.linkedinapi.schema.Specialties;
import com.google.code.linkedinapi.schema.StockExchange;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "universalName",
    "description",
    "industry",
    "logoUrl",
    "name",
    "type",
    "companyType",
    "size",
    "stockExchange",
    "ticker",
    "specialties",
    "blogRssUrl",
    "twitterId",
    "squareLogoUrl",
    "locations",
    "foundedYear",
    "endYear",
    "numFollowers",
    "emailDomains",
    "websiteUrl",
    "status",
    "employeeCountRange"
})
@XmlRootElement(name = "company")
public class CompanyImpl
    implements Serializable, Company
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "universal-name")
    protected String universalName;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String industry;
    @XmlElement(name = "logo-url", required = true)
    protected String logoUrl;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(name = "company-type", required = true, type = CompanyTypeImpl.class)
    protected CompanyTypeImpl companyType;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String size;
    @XmlElement(name = "stock-exchange", required = true, type = StockExchangeImpl.class)
    protected StockExchangeImpl stockExchange;
    @XmlElement(required = true)
    protected String ticker;
    @XmlElement(required = true, type = SpecialtiesImpl.class)
    protected SpecialtiesImpl specialties;
    @XmlElement(name = "blog-rss-url", required = true)
    protected String blogRssUrl;
    @XmlElement(name = "twitter-id", required = true)
    protected String twitterId;
    @XmlElement(name = "square-logo-url", required = true)
    protected String squareLogoUrl;
    @XmlElement(required = true, type = LocationsImpl.class)
    protected LocationsImpl locations;
    @XmlElement(name = "founded-year", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long foundedYear;
    @XmlElement(name = "end-year", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long endYear;
    @XmlElement(name = "num-followers", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long numFollowers;
    @XmlElement(name = "email-domains", required = true, type = EmailDomainsImpl.class)
    protected EmailDomainsImpl emailDomains;
    @XmlElement(name = "website-url", required = true)
    protected String websiteUrl;
    @XmlElement(required = true, type = CompanyStatusImpl.class)
    protected CompanyStatusImpl status;
    @XmlElement(name = "employee-count-range", required = true, type = EmployeeCountRangeImpl.class)
    protected EmployeeCountRangeImpl employeeCountRange;
    @XmlAttribute
    protected String key;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getUniversalName() {
        return universalName;
    }

    public void setUniversalName(String value) {
        this.universalName = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String value) {
        this.industry = value;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String value) {
        this.logoUrl = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType value) {
        this.companyType = ((CompanyTypeImpl) value);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String value) {
        this.size = value;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange value) {
        this.stockExchange = ((StockExchangeImpl) value);
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String value) {
        this.ticker = value;
    }

    public Specialties getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Specialties value) {
        this.specialties = ((SpecialtiesImpl) value);
    }

    public String getBlogRssUrl() {
        return blogRssUrl;
    }

    public void setBlogRssUrl(String value) {
        this.blogRssUrl = value;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String value) {
        this.twitterId = value;
    }

    public String getSquareLogoUrl() {
        return squareLogoUrl;
    }

    public void setSquareLogoUrl(String value) {
        this.squareLogoUrl = value;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations value) {
        this.locations = ((LocationsImpl) value);
    }

    public Long getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(Long value) {
        this.foundedYear = value;
    }

    public Long getEndYear() {
        return endYear;
    }

    public void setEndYear(Long value) {
        this.endYear = value;
    }

    public Long getNumFollowers() {
        return numFollowers;
    }

    public void setNumFollowers(Long value) {
        this.numFollowers = value;
    }

    public EmailDomains getEmailDomains() {
        return emailDomains;
    }

    public void setEmailDomains(EmailDomains value) {
        this.emailDomains = ((EmailDomainsImpl) value);
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String value) {
        this.websiteUrl = value;
    }

    public CompanyStatus getStatus() {
        return status;
    }

    public void setStatus(CompanyStatus value) {
        this.status = ((CompanyStatusImpl) value);
    }

    public EmployeeCountRange getEmployeeCountRange() {
        return employeeCountRange;
    }

    public void setEmployeeCountRange(EmployeeCountRange value) {
        this.employeeCountRange = ((EmployeeCountRangeImpl) value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String value) {
        this.key = value;
    }

}
