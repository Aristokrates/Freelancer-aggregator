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

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.ExperienceLevel;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.JobFunctions;
import com.google.code.linkedinapi.schema.JobType;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.StartDate;

public class PositionImpl
    extends BaseSchemaEntity
    implements Position
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4485115686667474338L;
    protected String id;
    protected String title;
    protected String summary;
    protected StartDateImpl startDate;
    protected EndDateImpl endDate;
    protected boolean isCurrent;
    protected CompanyImpl company;
    protected String description;
    protected String descriptionSnippet;
    protected String skillsAndExperience;
    protected LocationImpl location;
    protected JobFunctionsImpl jobFunctions;
    protected IndustriesImpl industries;
    protected JobTypeImpl jobType;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("title")) {
                setTitle(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("summary")) {
                setSummary(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("start-date")) {
                StartDateImpl node = new StartDateImpl();
                node.init(parser);
                setStartDate(node);
            } else if (name.equals("end-date")) {
                EndDateImpl node = new EndDateImpl();
                node.init(parser);
                setEndDate(node);
            } else if (name.equals("is-current")) {
                setIsCurrent(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("company")) {
                CompanyImpl node = new CompanyImpl();
                node.init(parser);
                setCompany(node);
            } else if (name.equals("description")) {
                setDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("description-snippet")) {
                setDescriptionSnippet(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("skills-and-experience")) {
                setSkillsAndExperience(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("location")) {
                LocationImpl node = new LocationImpl();
                node.init(parser);
                setLocation(node);
            } else if (name.equals("job-functions")) {
                JobFunctionsImpl node = new JobFunctionsImpl();
                node.init(parser);
                setJobFunctions(node);
            } else if (name.equals("industries")) {
                IndustriesImpl node = new IndustriesImpl();
                node.init(parser);
                setIndustries(node);
            } else if (name.equals("job-type")) {
                JobTypeImpl node = new JobTypeImpl();
                node.init(parser);
                setJobType(node);
            } else if (name.equals("experience-level")) {
                ExperienceLevelImpl node = new ExperienceLevelImpl();
                node.init(parser);
                setExperienceLevel(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "position");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "title", getTitle());
        XppUtils.setElementValueToNode(element, "summary", getSummary());
        if (getStartDate() != null) {
            ((StartDateImpl) getStartDate()).toXml(serializer);
        }
        if (getEndDate() != null) {
            ((EndDateImpl) getEndDate()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "is-current", String.valueOf(isIsCurrent()));
        if (getCompany() != null) {
            ((CompanyImpl) getCompany()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "description", getDescription());
        XppUtils.setElementValueToNode(element, "description-snippet", getDescriptionSnippet());
        XppUtils.setElementValueToNode(element, "skills-and-experience", getSkillsAndExperience());
        if (getLocation() != null) {
            ((LocationImpl) getLocation()).toXml(serializer);
        }
        if (getJobFunctions() != null) {
            ((JobFunctionsImpl) getJobFunctions()).toXml(serializer);
        }
        if (getIndustries() != null) {
            ((IndustriesImpl) getIndustries()).toXml(serializer);
        }
        if (getJobType() != null) {
            ((JobTypeImpl) getJobType()).toXml(serializer);
        }
        if (getExperienceLevel() != null) {
            ((ExperienceLevelImpl) getExperienceLevel()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "position");
    }
}
