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

import com.google.code.linkedinapi.schema.ContactInfo;

public class ContactInfoImpl
    extends BaseSchemaEntity implements ContactInfo
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String phone1;
    protected String phone2;
    protected String fax;

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String value) {
        this.phone1 = value;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String value) {
        this.phone2 = value;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String value) {
        this.fax = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("phone1")) {
                setPhone1(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("phone2")) {
                setPhone2(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("fax")) {
                setFax(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "contact-info");
        XppUtils.setElementValueToNode(element, "phone1", getPhone1());
        XppUtils.setElementValueToNode(element, "phone2", getPhone2());
        XppUtils.setElementValueToNode(element, "fax", getFax());
        
        
        serializer.endTag(null, "contact-info");
    }
}
