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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.ExperienceLevel;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.JobFunctions;
import com.google.code.linkedinapi.schema.JobType;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.StartDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "title",
    "summary",
    "startDate",
    "endDate",
    "isCurrent",
    "company",
    "description",
    "descriptionSnippet",
    "skillsAndExperience",
    "location",
    "jobFunctions",
    "industries",
    "jobType",
    "experienceLevel"
})
@XmlRootElement(name = "position")
public class PositionImpl
    implements Serializable, Position
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    protected String title;
    protected String summary;
    @XmlElement(name = "start-date", type = StartDateImpl.class)
    protected StartDateImpl startDate;
    @XmlElement(name = "end-date", type = EndDateImpl.class)
    protected EndDateImpl endDate;
    @XmlElement(name = "is-current")
    protected boolean isCurrent;
    @XmlElement(required = true, type = CompanyImpl.class)
    protected CompanyImpl company;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "description-snippet", required = true)
    protected String descriptionSnippet;
    @XmlElement(name = "skills-and-experience", required = true)
    protected String skillsAndExperience;
    @XmlElement(type = LocationImpl.class)
    protected LocationImpl location;
    @XmlElement(name = "job-functions", required = true, type = JobFunctionsImpl.class)
    protected JobFunctionsImpl jobFunctions;
    @XmlElement(required = true, type = IndustriesImpl.class)
    protected IndustriesImpl industries;
    @XmlElement(name = "job-type", required = true, type = JobTypeImpl.class)
    protected JobTypeImpl jobType;
    @XmlElement(name = "experience-level", required = true, type = ExperienceLevelImpl.class)
    protected ExperienceLevelImpl experienceLevel;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate value) {
        this.startDate = ((StartDateImpl) value);
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate value) {
        this.endDate = ((EndDateImpl) value);
    }

    public boolean isIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean value) {
        this.isCurrent = value;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company value) {
        this.company = ((CompanyImpl) value);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescriptionSnippet() {
        return descriptionSnippet;
    }

    public void setDescriptionSnippet(String value) {
        this.descriptionSnippet = value;
    }

    public String getSkillsAndExperience() {
        return skillsAndExperience;
    }

    public void setSkillsAndExperience(String value) {
        this.skillsAndExperience = value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location value) {
        this.location = ((LocationImpl) value);
    }

    public JobFunctions getJobFunctions() {
        return jobFunctions;
    }

    public void setJobFunctions(JobFunctions value) {
        this.jobFunctions = ((JobFunctionsImpl) value);
    }

    public Industries getIndustries() {
        return industries;
    }

    public void setIndustries(Industries value) {
        this.industries = ((IndustriesImpl) value);
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType value) {
        this.jobType = ((JobTypeImpl) value);
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel value) {
        this.experienceLevel = ((ExperienceLevelImpl) value);
    }

}
