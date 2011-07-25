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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobBookmark;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isApplied",
    "isSaved",
    "savedTimestamp",
    "appliedTimestamp",
    "job"
})
@XmlRootElement(name = "job-bookmark")
public class JobBookmarkImpl
    implements Serializable, JobBookmark
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "is-applied")
    protected boolean isApplied;
    @XmlElement(name = "is-saved")
    protected boolean isSaved;
    @XmlElement(name = "saved-timestamp", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long savedTimestamp;
    @XmlElement(name = "applied-timestamp", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long appliedTimestamp;
    @XmlElement(required = true, type = JobImpl.class)
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

}
