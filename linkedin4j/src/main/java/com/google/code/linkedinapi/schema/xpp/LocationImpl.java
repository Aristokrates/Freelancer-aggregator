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

import com.google.code.linkedinapi.schema.Address;
import com.google.code.linkedinapi.schema.ContactInfo;
import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Location;

public class LocationImpl
    extends BaseSchemaEntity
    implements Location
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8469907482652062050L;
    protected String description;
    protected boolean isHeadquarters;
    protected boolean isActive;
    protected AddressImpl address;
    protected ContactInfoImpl contactInfo;
    protected String name;
    protected String postalCode;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("description")) {
                setDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("is-headquarters")) {
                setIsHeadquarters(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("is-active")) {
                setIsActive(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("address")) {
                AddressImpl node = new AddressImpl();
                node.init(parser);
                setAddress(node);
            } else if (name.equals("contact-info")) {
                ContactInfoImpl node = new ContactInfoImpl();
                node.init(parser);
                setContactInfo(node);
            } else if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("postal-code")) {
                setPostalCode(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("country")) {
                CountryImpl node = new CountryImpl();
                node.init(parser);
                setCountry(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "location");
        XppUtils.setElementValueToNode(element, "description", getDescription());
        XppUtils.setElementValueToNode(element, "is-headquarters", String.valueOf(isIsHeadquarters()));
        XppUtils.setElementValueToNode(element, "is-active", String.valueOf(isIsActive()));
        if (getAddress() != null) {
            ((AddressImpl) getAddress()).toXml(serializer);
        }
        if (getContactInfo() != null) {
            ((ContactInfoImpl) getContactInfo()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "name", getName());
        XppUtils.setElementValueToNode(element, "postal-code", getPostalCode());
        if (getCountry() != null) {
            ((CountryImpl) getCountry()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "location");
    }
}
