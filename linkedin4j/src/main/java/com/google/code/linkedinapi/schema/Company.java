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

package com.google.code.linkedinapi.schema;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}id" minOccurs="0"/>
 *         &lt;element ref="{}universal-name" minOccurs="0"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element name="industry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}logo-url"/>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}type"/>
 *         &lt;element ref="{}company-type"/>
 *         &lt;element ref="{}size"/>
 *         &lt;element ref="{}stock-exchange"/>
 *         &lt;element ref="{}ticker"/>
 *         &lt;element ref="{}specialties"/>
 *         &lt;element ref="{}blog-rss-url"/>
 *         &lt;element ref="{}twitter-id"/>
 *         &lt;element ref="{}square-logo-url"/>
 *         &lt;element ref="{}locations"/>
 *         &lt;element ref="{}founded-year"/>
 *         &lt;element ref="{}end-year"/>
 *         &lt;element ref="{}num-followers"/>
 *         &lt;element ref="{}email-domains"/>
 *         &lt;element ref="{}website-url"/>
 *         &lt;element name="status" type="{}company-status"/>
 *         &lt;element ref="{}employee-count-range"/>
 *       &lt;/sequence>
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Company
    extends SchemaEntity
{


    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getId();

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setId(String value);

    /**
     * Gets the value of the universalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getUniversalName();

    /**
     * Sets the value of the universalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setUniversalName(String value);

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getDescription();

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setDescription(String value);

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getIndustry();

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setIndustry(String value);

    /**
     * Gets the value of the logoUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getLogoUrl();

    /**
     * Sets the value of the logoUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setLogoUrl(String value);

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getName();

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setName(String value);

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getType();

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setType(String value);

    /**
     * Gets the value of the companyType property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyType }
     *     
     */
    CompanyType getCompanyType();

    /**
     * Sets the value of the companyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyType }
     *     
     */
    void setCompanyType(CompanyType value);

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSize();

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSize(String value);

    /**
     * Gets the value of the stockExchange property.
     * 
     * @return
     *     possible object is
     *     {@link StockExchange }
     *     
     */
    StockExchange getStockExchange();

    /**
     * Sets the value of the stockExchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockExchange }
     *     
     */
    void setStockExchange(StockExchange value);

    /**
     * Gets the value of the ticker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getTicker();

    /**
     * Sets the value of the ticker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setTicker(String value);

    /**
     * Gets the value of the specialties property.
     * 
     * @return
     *     possible object is
     *     {@link Specialties }
     *     
     */
    Specialties getSpecialties();

    /**
     * Sets the value of the specialties property.
     * 
     * @param value
     *     allowed object is
     *     {@link Specialties }
     *     
     */
    void setSpecialties(Specialties value);

    /**
     * Gets the value of the blogRssUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getBlogRssUrl();

    /**
     * Sets the value of the blogRssUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setBlogRssUrl(String value);

    /**
     * Gets the value of the twitterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getTwitterId();

    /**
     * Sets the value of the twitterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setTwitterId(String value);

    /**
     * Gets the value of the squareLogoUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSquareLogoUrl();

    /**
     * Sets the value of the squareLogoUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSquareLogoUrl(String value);

    /**
     * Gets the value of the locations property.
     * 
     * @return
     *     possible object is
     *     {@link Locations }
     *     
     */
    Locations getLocations();

    /**
     * Sets the value of the locations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Locations }
     *     
     */
    void setLocations(Locations value);

    /**
     * Gets the value of the foundedYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getFoundedYear();

    /**
     * Sets the value of the foundedYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setFoundedYear(Long value);

    /**
     * Gets the value of the endYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getEndYear();

    /**
     * Sets the value of the endYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setEndYear(Long value);

    /**
     * Gets the value of the numFollowers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getNumFollowers();

    /**
     * Sets the value of the numFollowers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setNumFollowers(Long value);

    /**
     * Gets the value of the emailDomains property.
     * 
     * @return
     *     possible object is
     *     {@link EmailDomains }
     *     
     */
    EmailDomains getEmailDomains();

    /**
     * Sets the value of the emailDomains property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailDomains }
     *     
     */
    void setEmailDomains(EmailDomains value);

    /**
     * Gets the value of the websiteUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getWebsiteUrl();

    /**
     * Sets the value of the websiteUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setWebsiteUrl(String value);

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyStatus }
     *     
     */
    CompanyStatus getStatus();

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyStatus }
     *     
     */
    void setStatus(CompanyStatus value);

    /**
     * Gets the value of the employeeCountRange property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeCountRange }
     *     
     */
    EmployeeCountRange getEmployeeCountRange();

    /**
     * Sets the value of the employeeCountRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeCountRange }
     *     
     */
    void setEmployeeCountRange(EmployeeCountRange value);

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getKey();

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setKey(String value);

}
