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

package com.google.code.linkedinapi.schema;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}id" minOccurs="0"/>
 *         &lt;element ref="{}title" minOccurs="0"/>
 *         &lt;element ref="{}summary" minOccurs="0"/>
 *         &lt;element ref="{}start-date" minOccurs="0"/>
 *         &lt;element ref="{}end-date" minOccurs="0"/>
 *         &lt;element ref="{}is-current"/>
 *         &lt;element ref="{}company"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}description-snippet"/>
 *         &lt;element ref="{}skills-and-experience"/>
 *         &lt;element ref="{}location" minOccurs="0"/>
 *         &lt;element ref="{}job-functions"/>
 *         &lt;element ref="{}industries"/>
 *         &lt;element ref="{}job-type"/>
 *         &lt;element ref="{}experience-level"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Position
    extends SchemaEntity
{


    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getId();

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setId(String value);

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getTitle();

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setTitle(String value);

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSummary();

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSummary(String value);

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link StartDate }
     *     
     */
    StartDate getStartDate();

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartDate }
     *     
     */
    void setStartDate(StartDate value);

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link EndDate }
     *     
     */
    EndDate getEndDate();

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndDate }
     *     
     */
    void setEndDate(EndDate value);

    /**
     * Gets the value of the isCurrent property.
     * 
     */
    boolean isIsCurrent();

    /**
     * Sets the value of the isCurrent property.
     * 
     */
    void setIsCurrent(boolean value);

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    Company getCompany();

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    void setCompany(Company value);

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getDescription();

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setDescription(String value);

    /**
     * Gets the value of the descriptionSnippet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getDescriptionSnippet();

    /**
     * Sets the value of the descriptionSnippet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setDescriptionSnippet(String value);

    /**
     * Gets the value of the skillsAndExperience property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSkillsAndExperience();

    /**
     * Sets the value of the skillsAndExperience property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSkillsAndExperience(String value);

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    Location getLocation();

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    void setLocation(Location value);

    /**
     * Gets the value of the jobFunctions property.
     * 
     * @return
     *     possible object is
     *     {@link JobFunctions }
     *     
     */
    JobFunctions getJobFunctions();

    /**
     * Sets the value of the jobFunctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobFunctions }
     *     
     */
    void setJobFunctions(JobFunctions value);

    /**
     * Gets the value of the industries property.
     * 
     * @return
     *     possible object is
     *     {@link Industries }
     *     
     */
    Industries getIndustries();

    /**
     * Sets the value of the industries property.
     * 
     * @param value
     *     allowed object is
     *     {@link Industries }
     *     
     */
    void setIndustries(Industries value);

    /**
     * Gets the value of the jobType property.
     * 
     * @return
     *     possible object is
     *     {@link JobType }
     *     
     */
    JobType getJobType();

    /**
     * Sets the value of the jobType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobType }
     *     
     */
    void setJobType(JobType value);

    /**
     * Gets the value of the experienceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link ExperienceLevel }
     *     
     */
    ExperienceLevel getExperienceLevel();

    /**
     * Sets the value of the experienceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExperienceLevel }
     *     
     */
    void setExperienceLevel(ExperienceLevel value);

}
