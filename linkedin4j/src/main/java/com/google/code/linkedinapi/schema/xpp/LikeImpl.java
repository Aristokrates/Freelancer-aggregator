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

import com.google.code.linkedinapi.schema.Like;
import com.google.code.linkedinapi.schema.Person;

public class LikeImpl
extends BaseSchemaEntity implements Like
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long timestamp;
    protected PersonImpl person;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("timestamp")) {
                setTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("person")) {
                PersonImpl node = new PersonImpl();
                node.init(parser);
                setPerson(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "like");
        XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
        if (getPerson() != null) {
            ((PersonImpl) getPerson()).toXml(serializer);
        }
        
        serializer.endTag(null, "like");
    }
}
