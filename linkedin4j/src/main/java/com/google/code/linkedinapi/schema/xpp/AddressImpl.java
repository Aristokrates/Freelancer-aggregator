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

public class AddressImpl
    extends BaseSchemaEntity implements Address
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String postalCode;
    protected String countryCode;
    protected String regionCode;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String value) {
        this.street1 = value;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String value) {
        this.street2 = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String value) {
        this.regionCode = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("street1")) {
                setStreet1(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("street2")) {
                setStreet2(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("city")) {
                setCity(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("state")) {
                setState(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("postal-code")) {
                setPostalCode(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("country-code")) {
                setCountryCode(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("region-code")) {
                setRegionCode(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "address");
        XppUtils.setElementValueToNode(element, "street1", getStreet1());
        XppUtils.setElementValueToNode(element, "street2", getStreet2());
        XppUtils.setElementValueToNode(element, "city", getCity());
        XppUtils.setElementValueToNode(element, "state", getState());
        XppUtils.setElementValueToNode(element, "postal-code", getPostalCode());
        XppUtils.setElementValueToNode(element, "country-code", getCountryCode());
        XppUtils.setElementValueToNode(element, "region-code", getRegionCode());
        
        
        serializer.endTag(null, "address");
    }
}
