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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Address;
import com.google.code.linkedinapi.schema.ContactInfo;
import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Location;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "isHeadquarters",
    "isActive",
    "address",
    "contactInfo",
    "name",
    "postalCode",
    "country"
})
@XmlRootElement(name = "location")
public class LocationImpl
    implements Serializable, Location
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "is-headquarters")
    protected boolean isHeadquarters;
    @XmlElement(name = "is-active")
    protected boolean isActive;
    @XmlElement(required = true, type = AddressImpl.class)
    protected AddressImpl address;
    @XmlElement(name = "contact-info", required = true, type = ContactInfoImpl.class)
    protected ContactInfoImpl contactInfo;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "postal-code", required = true)
    protected String postalCode;
    @XmlElement(required = true, type = CountryImpl.class)
    protected CountryImpl country;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isIsHeadquarters() {
        return isHeadquarters;
    }

    public void setIsHeadquarters(boolean value) {
        this.isHeadquarters = value;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address value) {
        this.address = ((AddressImpl) value);
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo value) {
        this.contactInfo = ((ContactInfoImpl) value);
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country value) {
        this.country = ((CountryImpl) value);
    }

}
