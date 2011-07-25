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
import com.google.code.linkedinapi.schema.ExpirationDate;
import com.google.code.linkedinapi.schema.HowToApply;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobPoster;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Poster;
import com.google.code.linkedinapi.schema.PostingDate;
import com.google.code.linkedinapi.schema.Renewal;
import com.google.code.linkedinapi.schema.SiteJobRequest;

public class JobImpl
extends BaseSchemaEntity implements Job
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String partnerJobId;
    protected Long contractId;
    protected String customerJobCode;
    protected Boolean active;
    protected PostingDateImpl postingDate;
    protected ExpirationDateImpl expirationDate;
    protected CompanyImpl company;
    protected String description;
    protected String descriptionSnippet;
    protected String skillsAndExperience;
    protected PositionImpl position;
    protected Long expirationTimestamp;
    protected JobPosterImpl jobPoster;
    protected String locationDescription;
    protected Long postingTimestamp;
    protected String salary;
    protected SiteJobRequestImpl siteJobRequest;
    protected String siteJobUrl;
    protected String referralBonus;
    protected PosterImpl poster;
    protected HowToApplyImpl howToApply;
    protected String trackingPixelUrl;
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
        this.postingDate = (PostingDateImpl) value;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate value) {
        this.expirationDate = (ExpirationDateImpl) value;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position value) {
        this.position = ((PositionImpl) value);
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("partner-job-id")) {
                setPartnerJobId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("contract-id")) {
                setContractId(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("customer-job-code")) {
                setCustomerJobCode(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("active")) {
                setActive(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("posting-date")) {
            	PostingDateImpl node = new PostingDateImpl();
            	node.init(parser);
                setPostingDate(node);
            } else if (name.equals("expiration-date")) {
            	ExpirationDateImpl node = new ExpirationDateImpl();
            	node.init(parser);
                setExpirationDate(node);
            } else if (name.equals("company")) {
                CompanyImpl node = new CompanyImpl();
                node.init(parser);
                setCompany(node);
            } else if (name.equals("description")) {
                setDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("skills-and-experience")) {
                setSkillsAndExperience(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("description-snippet")) {
                setDescriptionSnippet(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("position")) {
                PositionImpl node = new PositionImpl();
                node.init(parser);
                setPosition(node);
            } else if (name.equals("expiration-timestamp")) {
                setExpirationTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("job-poster")) {
                JobPosterImpl node = new JobPosterImpl();
                node.init(parser);
                setJobPoster(node);
            } else if (name.equals("location-description")) {
                setLocationDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("posting-timestamp")) {
                setPostingTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("salary")) {
                setSalary(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("site-job-request")) {
                SiteJobRequestImpl node = new SiteJobRequestImpl();
                node.init(parser);
                setSiteJobRequest(node);
            } else if (name.equals("site-job-url")) {
                setSiteJobUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("referral-bonus")) {
                setReferralBonus(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("poster")) {
                PosterImpl node = new PosterImpl();
                node.init(parser);
                setPoster(node);
            } else if (name.equals("how-to-apply")) {
                HowToApplyImpl node = new HowToApplyImpl();
                node.init(parser);
                setHowToApply(node);
            } else if (name.equals("tracking-pixel-url")) {
                setTrackingPixelUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("renew")) {
            	RenewalImpl node = new RenewalImpl();
                node.init(parser);
                setRenewal(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "job");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "partner-job-id", getPartnerJobId());
        XppUtils.setElementValueToNode(element, "contract-id", getContractId());
        XppUtils.setElementValueToNode(element, "customer-job-code", getCustomerJobCode());
        XppUtils.setElementValueToNode(element, "active", isActive());
        if (getPostingDate() != null) {
            ((PostingDateImpl) getPostingDate()).toXml(serializer);
        }
        if (getExpirationDate() != null) {
            ((ExpirationDateImpl) getExpirationDate()).toXml(serializer);
        }
        if (getCompany() != null) {
            ((CompanyImpl) getCompany()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "description", getDescription());
        XppUtils.setElementValueToNode(element, "skills-and-experience", getSkillsAndExperience());
        XppUtils.setElementValueToNode(element, "description-snippet", getDescriptionSnippet());
        if (getPosition() != null) {
            ((PositionImpl) getPosition()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "expiration-timestamp", getExpirationTimestamp());
        if (getJobPoster() != null) {
            ((JobPosterImpl) getJobPoster()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "location-description", getLocationDescription());
        XppUtils.setElementValueToNode(element, "posting-timestamp", getPostingTimestamp());
        XppUtils.setElementValueToNode(element, "salary", getSalary());
        if (getSiteJobRequest() != null) {
            ((SiteJobRequestImpl) getSiteJobRequest()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "site-job-url", getSiteJobUrl());
        XppUtils.setElementValueToNode(element, "referral-bonus", getReferralBonus());
        if (getPoster() != null) {
            ((PosterImpl) getPoster()).toXml(serializer);
        }
        if (getHowToApply() != null) {
            ((HowToApplyImpl) getHowToApply()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "tracking-pixel-url", getTrackingPixelUrl());
        if (getRenewal() != null) {
            ((RenewalImpl) getRenewal()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "job");
    }
}
