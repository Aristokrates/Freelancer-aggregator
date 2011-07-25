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

package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.CompanyStatus;
import com.google.code.linkedinapi.schema.CompanyType;
import com.google.code.linkedinapi.schema.EmailDomains;
import com.google.code.linkedinapi.schema.EmployeeCountRange;
import com.google.code.linkedinapi.schema.Locations;
import com.google.code.linkedinapi.schema.Specialties;
import com.google.code.linkedinapi.schema.StockExchange;

public class CompanyImpl
	extends BaseSchemaEntity implements Company
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String universalName;
    protected String description;
    protected String industry;
    protected String logoUrl;
    protected String name;
    protected String type;
    protected CompanyTypeImpl companyType;
    protected String size;
    protected StockExchangeImpl stockExchange;
    protected String ticker;
    protected SpecialtiesImpl specialties;
    protected String blogRssUrl;
    protected String twitterId;
    protected String squareLogoUrl;
    protected LocationsImpl locations;
    protected Long foundedYear;
    protected Long endYear;
    protected Long numFollowers;
    protected EmailDomainsImpl emailDomains;
    protected String websiteUrl;
    protected CompanyStatusImpl status;
    protected EmployeeCountRangeImpl employeeCountRange;
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
        this.type = ((String) value);
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
        this.stockExchange = (StockExchangeImpl) value;
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
        this.specialties = (SpecialtiesImpl) value;
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

    public CompanyStatusImpl getStatus() {
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

    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setKey(XppUtils.getAttributeValueFromNode(parser, "key"));
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("universal-name")) {
                setUniversalName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("description")) {
                setDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("industry")) {
                setIndustry(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("logo-url")) {
                setLogoUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("type")) {
                setType(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("company-type")) {
                CompanyTypeImpl node = new CompanyTypeImpl();
                node.init(parser);
                setCompanyType(node);
            } else if (name.equals("size")) {
                setSize(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("stock-exchange")) {
            	StockExchangeImpl node = new StockExchangeImpl();
            	node.init(parser);
                setStockExchange(node);
            } else if (name.equals("ticker")) {
                setTicker(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("specialties")) {
            	SpecialtiesImpl node = new SpecialtiesImpl();
            	node.init(parser);
                setSpecialties(node);
            } else if (name.equals("blog-rss-url")) {
                setBlogRssUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("twitter-id")) {
                setTwitterId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("square-logo-url")) {
                setSquareLogoUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("locations")) {
                LocationsImpl node = new LocationsImpl();
                node.init(parser);
                setLocations(node);
            } else if (name.equals("founded-year")) {
                setFoundedYear(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("end-year")) {
                setEndYear(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("num-followers")) {
                setNumFollowers(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("email-domains")) {
                EmailDomainsImpl node = new EmailDomainsImpl();
                node.init(parser);
                setEmailDomains(node);
            } else if (name.equals("website-url")) {
                setWebsiteUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("status")) {
                CompanyStatusImpl node = new CompanyStatusImpl();
                node.init(parser);
                setStatus(node);
            } else if (name.equals("employee-count-range")) {
                EmployeeCountRangeImpl node = new EmployeeCountRangeImpl();
                node.init(parser);
                setEmployeeCountRange(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "company");
        XppUtils.setAttributeValueToNode(element, "key", getKey());
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "universal-name", getUniversalName());
        XppUtils.setElementValueToNode(element, "description", getDescription());
        XppUtils.setElementValueToNode(element, "industry", getIndustry());
        XppUtils.setElementValueToNode(element, "logo-url", getLogoUrl());
        XppUtils.setElementValueToNode(element, "name", getName());
        XppUtils.setElementValueToNode(element, "type", getType());
        if (getCompanyType() != null) {
            ((CompanyTypeImpl) getCompanyType()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "size", getSize());
        if (getStockExchange() != null) {
        	((StockExchangeImpl) getStockExchange()).toXml(serializer);
        	
        }
        XppUtils.setElementValueToNode(element, "ticker", getTicker());
        if (getSpecialties() != null) {
        	((SpecialtiesImpl) getSpecialties()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "blog-rss-url", getBlogRssUrl());
        XppUtils.setElementValueToNode(element, "twitter-id", getTwitterId());
        XppUtils.setElementValueToNode(element, "square-logo-url", getSquareLogoUrl());
        if (getLocations() != null) {
            ((LocationsImpl) getLocations()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "founded-year", getFoundedYear());
        XppUtils.setElementValueToNode(element, "end-year", getEndYear());
        XppUtils.setElementValueToNode(element, "num-followers", getNumFollowers());
        if (getEmailDomains() != null) {
            ((EmailDomainsImpl) getEmailDomains()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "website-url", getWebsiteUrl());
        if (getStatus() != null) {
            ((CompanyStatusImpl) getStatus()).toXml(serializer);
        }
        if (getEmployeeCountRange() != null) {
            ((EmployeeCountRangeImpl) getEmployeeCountRange()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "company");
    }
}
