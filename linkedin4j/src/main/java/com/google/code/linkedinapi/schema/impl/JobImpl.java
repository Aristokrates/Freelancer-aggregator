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
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.ExpirationDate;
import com.google.code.linkedinapi.schema.HowToApply;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobPoster;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Poster;
import com.google.code.linkedinapi.schema.PostingDate;
import com.google.code.linkedinapi.schema.Renewal;
import com.google.code.linkedinapi.schema.SiteJobRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "partnerJobId",
    "contractId",
    "customerJobCode",
    "active",
    "postingDate",
    "expirationDate",
    "company",
    "description",
    "descriptionSnippet",
    "position",
    "skillsAndExperience",
    "expirationTimestamp",
    "jobPoster",
    "locationDescription",
    "postingTimestamp",
    "salary",
    "siteJobRequest",
    "siteJobUrl",
    "referralBonus",
    "poster",
    "howToApply",
    "trackingPixelUrl",
    "renewal"
})
@XmlRootElement(name = "job")
public class JobImpl
    implements Serializable, Job
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "partner-job-id", required = true)
    protected String partnerJobId;
    @XmlElement(name = "contract-id", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long contractId;
    @XmlElement(name = "customer-job-code")
    protected String customerJobCode;
    protected Boolean active;
    @XmlElement(name = "posting-date", type = PostingDateImpl.class)
    protected PostingDateImpl postingDate;
    @XmlElement(name = "expiration-date", type = ExpirationDateImpl.class)
    protected ExpirationDateImpl expirationDate;
    @XmlElement(required = true, type = CompanyImpl.class)
    protected CompanyImpl company;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "description-snippet", required = true)
    protected String descriptionSnippet;
    @XmlElement(required = true, type = PositionImpl.class)
    protected PositionImpl position;
    @XmlElement(name = "skills-and-experience", required = true)
    protected String skillsAndExperience;
    @XmlElement(name = "expiration-timestamp", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long expirationTimestamp;
    @XmlElement(name = "job-poster", required = true, type = JobPosterImpl.class)
    protected JobPosterImpl jobPoster;
    @XmlElement(name = "location-description", required = true)
    protected String locationDescription;
    @XmlElement(name = "posting-timestamp", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long postingTimestamp;
    @XmlElement(required = true)
    protected String salary;
    @XmlElement(name = "site-job-request", required = true, type = SiteJobRequestImpl.class)
    protected SiteJobRequestImpl siteJobRequest;
    @XmlElement(name = "site-job-url", required = true)
    protected String siteJobUrl;
    @XmlElement(name = "referral-bonus")
    protected String referralBonus;
    @XmlElement(type = PosterImpl.class)
    protected PosterImpl poster;
    @XmlElement(name = "how-to-apply", type = HowToApplyImpl.class)
    protected HowToApplyImpl howToApply;
    @XmlElement(name = "tracking-pixel-url")
    protected String trackingPixelUrl;
    @XmlElement(type = RenewalImpl.class)
    protected RenewalImpl renewal;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getPartnerJobId() {
        return partnerJobId;
    }

    public void setPartnerJobId(String value) {
        this.partnerJobId = value;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long value) {
        this.contractId = value;
    }

    public String getCustomerJobCode() {
        return customerJobCode;
    }

    public void setCustomerJobCode(String value) {
        this.customerJobCode = value;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean value) {
        this.active = value;
    }

    public PostingDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(PostingDate value) {
        this.postingDate = ((PostingDateImpl) value);
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate value) {
        this.expirationDate = ((ExpirationDateImpl) value);
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position value) {
        this.position = ((PositionImpl) value);
    }

    public String getSkillsAndExperience() {
        return skillsAndExperience;
    }

    public void setSkillsAndExperience(String value) {
        this.skillsAndExperience = value;
    }

    public Long getExpirationTimestamp() {
        return expirationTimestamp;
    }

    public void setExpirationTimestamp(Long value) {
        this.expirationTimestamp = value;
    }

    public JobPoster getJobPoster() {
        return jobPoster;
    }

    public void setJobPoster(JobPoster value) {
        this.jobPoster = ((JobPosterImpl) value);
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String value) {
        this.locationDescription = value;
    }

    public Long getPostingTimestamp() {
        return postingTimestamp;
    }

    public void setPostingTimestamp(Long value) {
        this.postingTimestamp = value;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String value) {
        this.salary = value;
    }

    public SiteJobRequest getSiteJobRequest() {
        return siteJobRequest;
    }

    public void setSiteJobRequest(SiteJobRequest value) {
        this.siteJobRequest = ((SiteJobRequestImpl) value);
    }

    public String getSiteJobUrl() {
        return siteJobUrl;
    }

    public void setSiteJobUrl(String value) {
        this.siteJobUrl = value;
    }

    public String getReferralBonus() {
        return referralBonus;
    }

    public void setReferralBonus(String value) {
        this.referralBonus = value;
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster value) {
        this.poster = ((PosterImpl) value);
    }

    public HowToApply getHowToApply() {
        return howToApply;
    }

    public void setHowToApply(HowToApply value) {
        this.howToApply = ((HowToApplyImpl) value);
    }

    public String getTrackingPixelUrl() {
        return trackingPixelUrl;
    }

    public void setTrackingPixelUrl(String value) {
        this.trackingPixelUrl = value;
    }

    public Renewal getRenewal() {
        return renewal;
    }

    public void setRenewal(Renewal value) {
        this.renewal = ((RenewalImpl) value);
    }

}
