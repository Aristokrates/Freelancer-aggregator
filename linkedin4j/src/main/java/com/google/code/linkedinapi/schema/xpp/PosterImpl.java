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

import com.google.code.linkedinapi.schema.Poster;
import com.google.code.linkedinapi.schema.Role;

public class PosterImpl
extends BaseSchemaEntity implements Poster
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected boolean display;
    protected RoleImpl role;
    protected String emailAddress;

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean value) {
        this.display = value;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role value) {
        this.role = ((RoleImpl) value);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("display")) {
                setDisplay(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("role")) {
                RoleImpl node = new RoleImpl();
                node.init(parser);
                setRole(node);
            } else if (name.equals("email-address")) {
                setEmailAddress(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "poster");
        XppUtils.setElementValueToNode(element, "display", String.valueOf(isDisplay()));
        if (getRole() != null) {
            ((RoleImpl) getRole()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "email-address", getEmailAddress());
        
        
        serializer.endTag(null, "poster");
    }
}
