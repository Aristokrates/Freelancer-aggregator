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

import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobBookmark;

public class JobBookmarkImpl
extends BaseSchemaEntity implements JobBookmark
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected boolean isApplied;
    protected boolean isSaved;
    protected Long savedTimestamp;
    protected Long appliedTimestamp;
    protected JobImpl job;

    public boolean isIsApplied() {
        return isApplied;
    }

    public void setIsApplied(boolean value) {
        this.isApplied = value;
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean value) {
        this.isSaved = value;
    }

    public Long getSavedTimestamp() {
        return savedTimestamp;
    }

    public void setSavedTimestamp(Long value) {
        this.savedTimestamp = value;
    }

    public Long getAppliedTimestamp() {
        return appliedTimestamp;
    }

    public void setAppliedTimestamp(Long value) {
        this.appliedTimestamp = value;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job value) {
        this.job = ((JobImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("is-applied")) {
                setIsApplied(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("is-saved")) {
                setIsSaved(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("saved-timestamp")) {
                setSavedTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("applied-timestamp")) {
                setAppliedTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("job")) {
                JobImpl node = new JobImpl();
                node.init(parser);
                setJob(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "job-bookmark");
        XppUtils.setElementValueToNode(element, "is-applied", String.valueOf(isIsApplied()));
        XppUtils.setElementValueToNode(element, "is-saved", String.valueOf(isIsSaved()));
        XppUtils.setElementValueToNode(element, "saved-timestamp", getSavedTimestamp());
        XppUtils.setElementValueToNode(element, "applied-timestamp", getAppliedTimestamp());
        if (getJob() != null) {
            ((JobImpl) getJob()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "job-bookmark");
    }
}
