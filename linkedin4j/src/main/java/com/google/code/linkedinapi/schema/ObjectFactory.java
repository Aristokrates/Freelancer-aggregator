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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import com.google.code.linkedinapi.schema.impl.ActionImpl;
import com.google.code.linkedinapi.schema.impl.ActivityImpl;
import com.google.code.linkedinapi.schema.impl.AddressImpl;
import com.google.code.linkedinapi.schema.impl.AnswerImpl;
import com.google.code.linkedinapi.schema.impl.AnswersImpl;
import com.google.code.linkedinapi.schema.impl.ApiStandardProfileRequestImpl;
import com.google.code.linkedinapi.schema.impl.ApplicationImpl;
import com.google.code.linkedinapi.schema.impl.AttributionImpl;
import com.google.code.linkedinapi.schema.impl.AuthorImpl;
import com.google.code.linkedinapi.schema.impl.AuthorityImpl;
import com.google.code.linkedinapi.schema.impl.AuthorizationImpl;
import com.google.code.linkedinapi.schema.impl.AuthorsImpl;
import com.google.code.linkedinapi.schema.impl.BucketImpl;
import com.google.code.linkedinapi.schema.impl.BucketsImpl;
import com.google.code.linkedinapi.schema.impl.CertificationImpl;
import com.google.code.linkedinapi.schema.impl.CertificationsImpl;
import com.google.code.linkedinapi.schema.impl.CompaniesImpl;
import com.google.code.linkedinapi.schema.impl.CompanyImpl;
import com.google.code.linkedinapi.schema.impl.CompanyJobUpdateImpl;
import com.google.code.linkedinapi.schema.impl.CompanyPersonUpdateImpl;
import com.google.code.linkedinapi.schema.impl.CompanyProfileUpdateImpl;
import com.google.code.linkedinapi.schema.impl.CompanySearchImpl;
import com.google.code.linkedinapi.schema.impl.CompanyStatusImpl;
import com.google.code.linkedinapi.schema.impl.CompanyTypeImpl;
import com.google.code.linkedinapi.schema.impl.ConnectionsImpl;
import com.google.code.linkedinapi.schema.impl.ContactInfoImpl;
import com.google.code.linkedinapi.schema.impl.ContentImpl;
import com.google.code.linkedinapi.schema.impl.CountryImpl;
import com.google.code.linkedinapi.schema.impl.CurrentShareImpl;
import com.google.code.linkedinapi.schema.impl.DateImpl;
import com.google.code.linkedinapi.schema.impl.DateOfBirthImpl;
import com.google.code.linkedinapi.schema.impl.EditorImpl;
import com.google.code.linkedinapi.schema.impl.EducationImpl;
import com.google.code.linkedinapi.schema.impl.EducationsImpl;
import com.google.code.linkedinapi.schema.impl.EmailDomainsImpl;
import com.google.code.linkedinapi.schema.impl.EmployeeCountRangeImpl;
import com.google.code.linkedinapi.schema.impl.EndDateImpl;
import com.google.code.linkedinapi.schema.impl.ErrorImpl;
import com.google.code.linkedinapi.schema.impl.ExperienceLevelImpl;
import com.google.code.linkedinapi.schema.impl.ExpirationDateImpl;
import com.google.code.linkedinapi.schema.impl.FacetImpl;
import com.google.code.linkedinapi.schema.impl.FacetsImpl;
import com.google.code.linkedinapi.schema.impl.FeaturesImpl;
import com.google.code.linkedinapi.schema.impl.HeadersImpl;
import com.google.code.linkedinapi.schema.impl.HowToApplyImpl;
import com.google.code.linkedinapi.schema.impl.HttpHeaderImpl;
import com.google.code.linkedinapi.schema.impl.ImAccountImpl;
import com.google.code.linkedinapi.schema.impl.ImAccountsImpl;
import com.google.code.linkedinapi.schema.impl.IndustriesImpl;
import com.google.code.linkedinapi.schema.impl.IndustryImpl;
import com.google.code.linkedinapi.schema.impl.InventorImpl;
import com.google.code.linkedinapi.schema.impl.InventorsImpl;
import com.google.code.linkedinapi.schema.impl.InvitationRequestImpl;
import com.google.code.linkedinapi.schema.impl.ItemContentImpl;
import com.google.code.linkedinapi.schema.impl.JobBookmarkImpl;
import com.google.code.linkedinapi.schema.impl.JobBookmarksImpl;
import com.google.code.linkedinapi.schema.impl.JobFunctionImpl;
import com.google.code.linkedinapi.schema.impl.JobFunctionsImpl;
import com.google.code.linkedinapi.schema.impl.JobImpl;
import com.google.code.linkedinapi.schema.impl.JobPosterImpl;
import com.google.code.linkedinapi.schema.impl.JobSearchImpl;
import com.google.code.linkedinapi.schema.impl.JobSuggestionsImpl;
import com.google.code.linkedinapi.schema.impl.JobTypeImpl;
import com.google.code.linkedinapi.schema.impl.JobsImpl;
import com.google.code.linkedinapi.schema.impl.LanguageImpl;
import com.google.code.linkedinapi.schema.impl.LanguagesImpl;
import com.google.code.linkedinapi.schema.impl.LikeImpl;
import com.google.code.linkedinapi.schema.impl.LikesImpl;
import com.google.code.linkedinapi.schema.impl.LocationImpl;
import com.google.code.linkedinapi.schema.impl.LocationsImpl;
import com.google.code.linkedinapi.schema.impl.MailboxItemImpl;
import com.google.code.linkedinapi.schema.impl.MemberGroupImpl;
import com.google.code.linkedinapi.schema.impl.MemberGroupsImpl;
import com.google.code.linkedinapi.schema.impl.MemberUrlImpl;
import com.google.code.linkedinapi.schema.impl.MemberUrlResourcesImpl;
import com.google.code.linkedinapi.schema.impl.NameTypeImpl;
import com.google.code.linkedinapi.schema.impl.NetworkImpl;
import com.google.code.linkedinapi.schema.impl.NetworkStatsImpl;
import com.google.code.linkedinapi.schema.impl.NewPositionImpl;
import com.google.code.linkedinapi.schema.impl.OfficeImpl;
import com.google.code.linkedinapi.schema.impl.OldPositionImpl;
import com.google.code.linkedinapi.schema.impl.OriginalUpdateImpl;
import com.google.code.linkedinapi.schema.impl.PatentImpl;
import com.google.code.linkedinapi.schema.impl.PatentsImpl;
import com.google.code.linkedinapi.schema.impl.PeopleImpl;
import com.google.code.linkedinapi.schema.impl.PeopleSearchImpl;
import com.google.code.linkedinapi.schema.impl.PersonActivitiesImpl;
import com.google.code.linkedinapi.schema.impl.PersonImpl;
import com.google.code.linkedinapi.schema.impl.PhoneNumberImpl;
import com.google.code.linkedinapi.schema.impl.PhoneNumbersImpl;
import com.google.code.linkedinapi.schema.impl.PositionImpl;
import com.google.code.linkedinapi.schema.impl.PositionsImpl;
import com.google.code.linkedinapi.schema.impl.PosterImpl;
import com.google.code.linkedinapi.schema.impl.PostingDateImpl;
import com.google.code.linkedinapi.schema.impl.ProductCategoryImpl;
import com.google.code.linkedinapi.schema.impl.ProductDealImpl;
import com.google.code.linkedinapi.schema.impl.ProductImpl;
import com.google.code.linkedinapi.schema.impl.ProductTypeImpl;
import com.google.code.linkedinapi.schema.impl.ProductsImpl;
import com.google.code.linkedinapi.schema.impl.ProficiencyImpl;
import com.google.code.linkedinapi.schema.impl.ProfileFieldImpl;
import com.google.code.linkedinapi.schema.impl.PropertyImpl;
import com.google.code.linkedinapi.schema.impl.PublicationAuthorImpl;
import com.google.code.linkedinapi.schema.impl.PublicationImpl;
import com.google.code.linkedinapi.schema.impl.PublicationsImpl;
import com.google.code.linkedinapi.schema.impl.PublisherImpl;
import com.google.code.linkedinapi.schema.impl.QuestionCategoriesImpl;
import com.google.code.linkedinapi.schema.impl.QuestionCategoryImpl;
import com.google.code.linkedinapi.schema.impl.QuestionImpl;
import com.google.code.linkedinapi.schema.impl.RecipientImpl;
import com.google.code.linkedinapi.schema.impl.RecipientsImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationTypeImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationsGivenImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationsImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationsReceivedImpl;
import com.google.code.linkedinapi.schema.impl.RecommendeeImpl;
import com.google.code.linkedinapi.schema.impl.RecommenderImpl;
import com.google.code.linkedinapi.schema.impl.RelatedConnectionsImpl;
import com.google.code.linkedinapi.schema.impl.RelationToViewerImpl;
import com.google.code.linkedinapi.schema.impl.RenewalImpl;
import com.google.code.linkedinapi.schema.impl.RoleImpl;
import com.google.code.linkedinapi.schema.impl.SalesPersonsImpl;
import com.google.code.linkedinapi.schema.impl.ServiceProviderImpl;
import com.google.code.linkedinapi.schema.impl.ShareImpl;
import com.google.code.linkedinapi.schema.impl.SiteGroupRequestImpl;
import com.google.code.linkedinapi.schema.impl.SiteJobRequestImpl;
import com.google.code.linkedinapi.schema.impl.SiteStandardProfileRequestImpl;
import com.google.code.linkedinapi.schema.impl.SkillImpl;
import com.google.code.linkedinapi.schema.impl.SkillsImpl;
import com.google.code.linkedinapi.schema.impl.SourceImpl;
import com.google.code.linkedinapi.schema.impl.SpecialtiesImpl;
import com.google.code.linkedinapi.schema.impl.StartDateImpl;
import com.google.code.linkedinapi.schema.impl.StatusImpl;
import com.google.code.linkedinapi.schema.impl.StockExchangeImpl;
import com.google.code.linkedinapi.schema.impl.ThreeCurrentPositionsImpl;
import com.google.code.linkedinapi.schema.impl.ThreePastPositionsImpl;
import com.google.code.linkedinapi.schema.impl.TwitterAccountImpl;
import com.google.code.linkedinapi.schema.impl.TwitterAccountsImpl;
import com.google.code.linkedinapi.schema.impl.UpdateActionImpl;
import com.google.code.linkedinapi.schema.impl.UpdateCommentImpl;
import com.google.code.linkedinapi.schema.impl.UpdateCommentsImpl;
import com.google.code.linkedinapi.schema.impl.UpdateContentImpl;
import com.google.code.linkedinapi.schema.impl.UpdateImpl;
import com.google.code.linkedinapi.schema.impl.UpdatesImpl;
import com.google.code.linkedinapi.schema.impl.VideoImpl;
import com.google.code.linkedinapi.schema.impl.VisibilityImpl;
import com.google.code.linkedinapi.schema.impl.YearsImpl;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.google.code.linkedinapi.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static Void _useJAXBProperties = null;
    private final static QName _Summary_QNAME = new QName("", "summary");
    private final static QName _Honors_QNAME = new QName("", "honors");
    private final static QName _PublicProfileUrl_QNAME = new QName("", "public-profile-url");
    private final static QName _Disclaimer_QNAME = new QName("", "disclaimer");
    private final static QName _MainAddress_QNAME = new QName("", "main-address");
    private final static QName _NumRecommenders_QNAME = new QName("", "num-recommenders");
    private final static QName _City_QNAME = new QName("", "city");
    private final static QName _ThumbnailUrl_QNAME = new QName("", "thumbnail-url");
    private final static QName _SavedTimestamp_QNAME = new QName("", "saved-timestamp");
    private final static QName _Ticker_QNAME = new QName("", "ticker");
    private final static QName _EndYear_QNAME = new QName("", "end-year");
    private final static QName _DescriptionSnippet_QNAME = new QName("", "description-snippet");
    private final static QName _WebUrl_QNAME = new QName("", "web-url");
    private final static QName _Year_QNAME = new QName("", "year");
    private final static QName _Feature_QNAME = new QName("", "feature");
    private final static QName _LastName_QNAME = new QName("", "last-name");
    private final static QName _Activities_QNAME = new QName("", "activities");
    private final static QName _Salary_QNAME = new QName("", "salary");
    private final static QName _ImAccountName_QNAME = new QName("", "im-account-name");
    private final static QName _EmailDomain_QNAME = new QName("", "email-domain");
    private final static QName _ProductId_QNAME = new QName("", "product-id");
    private final static QName _IsActive_QNAME = new QName("", "is-active");
    private final static QName _SkillsAndExperience_QNAME = new QName("", "skills-and-experience");
    private final static QName _SubmittedUrl_QNAME = new QName("", "submitted-url");
    private final static QName _Number_QNAME = new QName("", "number");
    private final static QName _IsSaved_QNAME = new QName("", "is-saved");
    private final static QName _RecommendationText_QNAME = new QName("", "recommendation-text");
    private final static QName _Associations_QNAME = new QName("", "associations");
    private final static QName _Month_QNAME = new QName("", "month");
    private final static QName _UniversalName_QNAME = new QName("", "universal-name");
    private final static QName _Comment_QNAME = new QName("", "comment");
    private final static QName _PictureUrl_QNAME = new QName("", "picture-url");
    private final static QName _ContentType_QNAME = new QName("", "content-type");
    private final static QName _Subject_QNAME = new QName("", "subject");
    private final static QName _RequestId_QNAME = new QName("", "request-id");
    private final static QName _SiteJobUrl_QNAME = new QName("", "site-job-url");
    private final static QName _PostingTimestamp_QNAME = new QName("", "posting-timestamp");
    private final static QName _IsCurrent_QNAME = new QName("", "is-current");
    private final static QName _CountryCode_QNAME = new QName("", "country-code");
    private final static QName _IsLiked_QNAME = new QName("", "is-liked");
    private final static QName _CreationTimestamp_QNAME = new QName("", "creation-timestamp");
    private final static QName _Timestamp_QNAME = new QName("", "timestamp");
    private final static QName _Distance_QNAME = new QName("", "distance");
    private final static QName _Title_QNAME = new QName("", "title");
    private final static QName _ExpirationTimestamp_QNAME = new QName("", "expiration-timestamp");
    private final static QName _WebsiteUrl_QNAME = new QName("", "website-url");
    private final static QName _Reply_QNAME = new QName("", "reply");
    private final static QName _NumConnectionsCapped_QNAME = new QName("", "num-connections-capped");
    private final static QName _UpdateType_QNAME = new QName("", "update-type");
    private final static QName _EyebrowUrl_QNAME = new QName("", "eyebrow-url");
    private final static QName _CustomerJobCode_QNAME = new QName("", "customer-job-code");
    private final static QName _IsApplied_QNAME = new QName("", "is-applied");
    private final static QName _AppliedTimestamp_QNAME = new QName("", "applied-timestamp");
    private final static QName _TrackingPixelUrl_QNAME = new QName("", "tracking-pixel-url");
    private final static QName _Degree_QNAME = new QName("", "degree");
    private final static QName _PhoneType_QNAME = new QName("", "phone-type");
    private final static QName _FirstName_QNAME = new QName("", "first-name");
    private final static QName _BlogRssUrl_QNAME = new QName("", "blog-rss-url");
    private final static QName _NumConnections_QNAME = new QName("", "num-connections");
    private final static QName _SequenceNumber_QNAME = new QName("", "sequence-number");
    private final static QName _Notes_QNAME = new QName("", "notes");
    private final static QName _Body_QNAME = new QName("", "body");
    private final static QName _Count_QNAME = new QName("", "count");
    private final static QName _ApplicationUrl_QNAME = new QName("", "application-url");
    private final static QName _IsLikable_QNAME = new QName("", "is-likable");
    private final static QName _CurrentStatus_QNAME = new QName("", "current-status");
    private final static QName _IsHeadquarters_QNAME = new QName("", "is-headquarters");
    private final static QName _IsCommentable_QNAME = new QName("", "is-commentable");
    private final static QName _ErrorCode_QNAME = new QName("", "error-code");
    private final static QName _SquareLogoUrl_QNAME = new QName("", "square-logo-url");
    private final static QName _Phone2_QNAME = new QName("", "phone2");
    private final static QName _CurrentStatusTimestamp_QNAME = new QName("", "current-status-timestamp");
    private final static QName _Type_QNAME = new QName("", "type");
    private final static QName _Phone1_QNAME = new QName("", "phone1");
    private final static QName _ProviderAccountName_QNAME = new QName("", "provider-account-name");
    private final static QName _ConnectType_QNAME = new QName("", "connect-type");
    private final static QName _Level_QNAME = new QName("", "level");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _Value_QNAME = new QName("", "value");
    private final static QName _ResolvedUrl_QNAME = new QName("", "resolved-url");
    private final static QName _SubmittedImageUrl_QNAME = new QName("", "submitted-image-url");
    private final static QName _Text_QNAME = new QName("", "text");
    private final static QName _Fax_QNAME = new QName("", "fax");
    private final static QName _ProviderAccountId_QNAME = new QName("", "provider-account-id");
    private final static QName _LogoUrl_QNAME = new QName("", "logo-url");
    private final static QName _PartnerJobId_QNAME = new QName("", "partner-job-id");
    private final static QName _Display_QNAME = new QName("", "display");
    private final static QName _Code_QNAME = new QName("", "code");
    private final static QName _Url_QNAME = new QName("", "url");
    private final static QName _ShortenedUrl_QNAME = new QName("", "shortened-url");
    private final static QName _Size_QNAME = new QName("", "size");
    private final static QName _NumRecommendations_QNAME = new QName("", "num-recommendations");
    private final static QName _Active_QNAME = new QName("", "active");
    private final static QName _Day_QNAME = new QName("", "day");
    private final static QName _EmailAddress_QNAME = new QName("", "email-address");
    private final static QName _Headline_QNAME = new QName("", "headline");
    private final static QName _Interests_QNAME = new QName("", "interests");
    private final static QName _NumFollowers_QNAME = new QName("", "num-followers");
    private final static QName _NumResults_QNAME = new QName("", "num-results");
    private final static QName _State_QNAME = new QName("", "state");
    private final static QName _ContractId_QNAME = new QName("", "contract-id");
    private final static QName _FoundedYear_QNAME = new QName("", "founded-year");
    private final static QName _NumLikes_QNAME = new QName("", "num-likes");
    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _Selected_QNAME = new QName("", "selected");
    private final static QName _ImAccountType_QNAME = new QName("", "im-account-type");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _RecommendationSnippet_QNAME = new QName("", "recommendation-snippet");
    private final static QName _TwitterId_QNAME = new QName("", "twitter-id");
    private final static QName _AppId_QNAME = new QName("", "app-id");
    private final static QName _LocationDescription_QNAME = new QName("", "location-description");
    private final static QName _Street2_QNAME = new QName("", "street2");
    private final static QName _Street1_QNAME = new QName("", "street1");
    private final static QName _SchoolName_QNAME = new QName("", "school-name");
    private final static QName _PostalCode_QNAME = new QName("", "postal-code");
    private final static QName _UpdateKey_QNAME = new QName("", "update-key");
    private final static QName _Message_QNAME = new QName("", "message");
    private final static QName _ReferralBonus_QNAME = new QName("", "referral-bonus");
    private final static QName _RegionCode_QNAME = new QName("", "region-code");
    private final static QName _FieldOfStudy_QNAME = new QName("", "field-of-study");
    private final static QName _Specialty_QNAME = new QName("", "specialty");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.google.code.linkedinapi.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MailboxItem }
     * 
     */
    public MailboxItem createMailboxItem() {
        return new MailboxItemImpl();
    }

    /**
     * Create an instance of {@link CompanyProfileUpdate }
     * 
     */
    public CompanyProfileUpdate createCompanyProfileUpdate() {
        return new CompanyProfileUpdateImpl();
    }

    /**
     * Create an instance of {@link MemberGroup }
     * 
     */
    public MemberGroup createMemberGroup() {
        return new MemberGroupImpl();
    }

    /**
     * Create an instance of {@link HowToApply }
     * 
     */
    public HowToApply createHowToApply() {
        return new HowToApplyImpl();
    }

    /**
     * Create an instance of {@link EmailDomains }
     * 
     */
    public EmailDomains createEmailDomains() {
        return new EmailDomainsImpl();
    }

    /**
     * Create an instance of {@link Editor }
     * 
     */
    public Editor createEditor() {
        return new EditorImpl();
    }

    /**
     * Create an instance of {@link Industries }
     * 
     */
    public Industries createIndustries() {
        return new IndustriesImpl();
    }

    /**
     * Create an instance of {@link Recommendation }
     * 
     */
    public Recommendation createRecommendation() {
        return new RecommendationImpl();
    }

    /**
     * Create an instance of {@link Like }
     * 
     */
    public Like createLike() {
        return new LikeImpl();
    }

    /**
     * Create an instance of {@link Recommendations }
     * 
     */
    public Recommendations createRecommendations() {
        return new RecommendationsImpl();
    }

    /**
     * Create an instance of {@link TwitterAccounts }
     * 
     */
    public TwitterAccounts createTwitterAccounts() {
        return new TwitterAccountsImpl();
    }

    /**
     * Create an instance of {@link Features }
     * 
     */
    public Features createFeatures() {
        return new FeaturesImpl();
    }

    /**
     * Create an instance of {@link Renewal }
     * 
     */
    public Renewal createRenewal() {
        return new RenewalImpl();
    }

    /**
     * Create an instance of {@link Application }
     * 
     */
    public Application createApplication() {
        return new ApplicationImpl();
    }

    /**
     * Create an instance of {@link Authorization }
     * 
     */
    public Authorization createAuthorization() {
        return new AuthorizationImpl();
    }

    /**
     * Create an instance of {@link SiteJobRequest }
     * 
     */
    public SiteJobRequest createSiteJobRequest() {
        return new SiteJobRequestImpl();
    }

    /**
     * Create an instance of {@link Locations }
     * 
     */
    public Locations createLocations() {
        return new LocationsImpl();
    }

    /**
     * Create an instance of {@link InvitationRequest }
     * 
     */
    public InvitationRequest createInvitationRequest() {
        return new InvitationRequestImpl();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new QuestionImpl();
    }

    /**
     * Create an instance of {@link RecommendationType }
     * 
     */
    public RecommendationType createRecommendationType() {
        return new RecommendationTypeImpl();
    }

    /**
     * Create an instance of {@link Skill }
     * 
     */
    public Skill createSkill() {
        return new SkillImpl();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new CountryImpl();
    }

    /**
     * Create an instance of {@link ExperienceLevel }
     * 
     */
    public ExperienceLevel createExperienceLevel() {
        return new ExperienceLevelImpl();
    }

    /**
     * Create an instance of {@link PhoneNumbers }
     * 
     */
    public PhoneNumbers createPhoneNumbers() {
        return new PhoneNumbersImpl();
    }

    /**
     * Create an instance of {@link Companies }
     * 
     */
    public Companies createCompanies() {
        return new CompaniesImpl();
    }

    /**
     * Create an instance of {@link Inventors }
     * 
     */
    public Inventors createInventors() {
        return new InventorsImpl();
    }

    /**
     * Create an instance of {@link MemberUrl }
     * 
     */
    public MemberUrl createMemberUrl() {
        return new MemberUrlImpl();
    }

    /**
     * Create an instance of {@link Specialties }
     * 
     */
    public Specialties createSpecialties() {
        return new SpecialtiesImpl();
    }

    /**
     * Create an instance of {@link OldPosition }
     * 
     */
    public OldPosition createOldPosition() {
        return new OldPositionImpl();
    }

    /**
     * Create an instance of {@link JobType }
     * 
     */
    public JobType createJobType() {
        return new JobTypeImpl();
    }

    /**
     * Create an instance of {@link Certification }
     * 
     */
    public Certification createCertification() {
        return new CertificationImpl();
    }

    /**
     * Create an instance of {@link JobBookmark }
     * 
     */
    public JobBookmark createJobBookmark() {
        return new JobBookmarkImpl();
    }

    /**
     * Create an instance of {@link Languages }
     * 
     */
    public Languages createLanguages() {
        return new LanguagesImpl();
    }

    /**
     * Create an instance of {@link Recipients }
     * 
     */
    public Recipients createRecipients() {
        return new RecipientsImpl();
    }

    /**
     * Create an instance of {@link PeopleSearch }
     * 
     */
    public PeopleSearch createPeopleSearch() {
        return new PeopleSearchImpl();
    }

    /**
     * Create an instance of {@link Video }
     * 
     */
    public Video createVideo() {
        return new VideoImpl();
    }

    /**
     * Create an instance of {@link JobPoster }
     * 
     */
    public JobPoster createJobPoster() {
        return new JobPosterImpl();
    }

    /**
     * Create an instance of {@link ProductType }
     * 
     */
    public ProductType createProductType() {
        return new ProductTypeImpl();
    }

    /**
     * Create an instance of {@link NetworkStats }
     * 
     */
    public NetworkStats createNetworkStats() {
        return new NetworkStatsImpl();
    }

    /**
     * Create an instance of {@link RelatedConnections }
     * 
     */
    public RelatedConnections createRelatedConnections() {
        return new RelatedConnectionsImpl();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new CompanyImpl();
    }

    /**
     * Create an instance of {@link SiteStandardProfileRequest }
     * 
     */
    public SiteStandardProfileRequest createSiteStandardProfileRequest() {
        return new SiteStandardProfileRequestImpl();
    }

    /**
     * Create an instance of {@link RecommendationsGiven }
     * 
     */
    public RecommendationsGiven createRecommendationsGiven() {
        return new RecommendationsGivenImpl();
    }

    /**
     * Create an instance of {@link PostingDate }
     * 
     */
    public PostingDate createPostingDate() {
        return new PostingDateImpl();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new LocationImpl();
    }

    /**
     * Create an instance of {@link SiteGroupRequest }
     * 
     */
    public SiteGroupRequest createSiteGroupRequest() {
        return new SiteGroupRequestImpl();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new PublisherImpl();
    }

    /**
     * Create an instance of {@link ApiStandardProfileRequest }
     * 
     */
    public ApiStandardProfileRequest createApiStandardProfileRequest() {
        return new ApiStandardProfileRequestImpl();
    }

    /**
     * Create an instance of {@link PersonActivities }
     * 
     */
    public PersonActivities createPersonActivities() {
        return new PersonActivitiesImpl();
    }

    /**
     * Create an instance of {@link ServiceProvider }
     * 
     */
    public ServiceProvider createServiceProvider() {
        return new ServiceProviderImpl();
    }

    /**
     * Create an instance of {@link QuestionCategories }
     * 
     */
    public QuestionCategories createQuestionCategories() {
        return new QuestionCategoriesImpl();
    }

    /**
     * Create an instance of {@link Job }
     * 
     */
    public Job createJob() {
        return new JobImpl();
    }

    /**
     * Create an instance of {@link Share }
     * 
     */
    public Share createShare() {
        return new ShareImpl();
    }

    /**
     * Create an instance of {@link Role }
     * 
     */
    public Role createRole() {
        return new RoleImpl();
    }

    /**
     * Create an instance of {@link UpdateComment }
     * 
     */
    public UpdateComment createUpdateComment() {
        return new UpdateCommentImpl();
    }

    /**
     * Create an instance of {@link CompanyType }
     * 
     */
    public CompanyType createCompanyType() {
        return new CompanyTypeImpl();
    }

    /**
     * Create an instance of {@link Inventor }
     * 
     */
    public Inventor createInventor() {
        return new InventorImpl();
    }

    /**
     * Create an instance of {@link ContactInfo }
     * 
     */
    public ContactInfo createContactInfo() {
        return new ContactInfoImpl();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new UpdateImpl();
    }

    /**
     * Create an instance of {@link JobFunctions }
     * 
     */
    public JobFunctions createJobFunctions() {
        return new JobFunctionsImpl();
    }

    /**
     * Create an instance of {@link SalesPersons }
     * 
     */
    public SalesPersons createSalesPersons() {
        return new SalesPersonsImpl();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new StatusImpl();
    }

    /**
     * Create an instance of {@link Skills }
     * 
     */
    public Skills createSkills() {
        return new SkillsImpl();
    }

    /**
     * Create an instance of {@link RecommendationsReceived }
     * 
     */
    public RecommendationsReceived createRecommendationsReceived() {
        return new RecommendationsReceivedImpl();
    }

    /**
     * Create an instance of {@link Positions }
     * 
     */
    public Positions createPositions() {
        return new PositionsImpl();
    }

    /**
     * Create an instance of {@link EmployeeCountRange }
     * 
     */
    public EmployeeCountRange createEmployeeCountRange() {
        return new EmployeeCountRangeImpl();
    }

    /**
     * Create an instance of {@link MemberGroups }
     * 
     */
    public MemberGroups createMemberGroups() {
        return new MemberGroupsImpl();
    }

    /**
     * Create an instance of {@link CompanyPersonUpdate }
     * 
     */
    public CompanyPersonUpdate createCompanyPersonUpdate() {
        return new CompanyPersonUpdateImpl();
    }

    /**
     * Create an instance of {@link QuestionCategory }
     * 
     */
    public QuestionCategory createQuestionCategory() {
        return new QuestionCategoryImpl();
    }

    /**
     * Create an instance of {@link Products }
     * 
     */
    public Products createProducts() {
        return new ProductsImpl();
    }

    /**
     * Create an instance of {@link TwitterAccount }
     * 
     */
    public TwitterAccount createTwitterAccount() {
        return new TwitterAccountImpl();
    }

    /**
     * Create an instance of {@link JobSuggestions }
     * 
     */
    public JobSuggestions createJobSuggestions() {
        return new JobSuggestionsImpl();
    }

    /**
     * Create an instance of {@link CompanyStatus }
     * 
     */
    public CompanyStatus createCompanyStatus() {
        return new CompanyStatusImpl();
    }

    /**
     * Create an instance of {@link NameType }
     * 
     */
    public NameType createNameType() {
        return new NameTypeImpl();
    }

    /**
     * Create an instance of {@link Likes }
     * 
     */
    public Likes createLikes() {
        return new LikesImpl();
    }

    /**
     * Create an instance of {@link Authority }
     * 
     */
    public Authority createAuthority() {
        return new AuthorityImpl();
    }

    /**
     * Create an instance of {@link ProductCategory }
     * 
     */
    public ProductCategory createProductCategory() {
        return new ProductCategoryImpl();
    }

    /**
     * Create an instance of {@link Visibility }
     * 
     */
    public Visibility createVisibility() {
        return new VisibilityImpl();
    }

    /**
     * Create an instance of {@link JobFunction }
     * 
     */
    public JobFunction createJobFunction() {
        return new JobFunctionImpl();
    }

    /**
     * Create an instance of {@link Source }
     * 
     */
    public Source createSource() {
        return new SourceImpl();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
    public Activity createActivity() {
        return new ActivityImpl();
    }

    /**
     * Create an instance of {@link PhoneNumber }
     * 
     */
    public PhoneNumber createPhoneNumber() {
        return new PhoneNumberImpl();
    }

    /**
     * Create an instance of {@link Proficiency }
     * 
     */
    public Proficiency createProficiency() {
        return new ProficiencyImpl();
    }

    /**
     * Create an instance of {@link HttpHeader }
     * 
     */
    public HttpHeader createHttpHeader() {
        return new HttpHeaderImpl();
    }

    /**
     * Create an instance of {@link ThreePastPositions }
     * 
     */
    public ThreePastPositions createThreePastPositions() {
        return new ThreePastPositionsImpl();
    }

    /**
     * Create an instance of {@link RelationToViewer }
     * 
     */
    public RelationToViewer createRelationToViewer() {
        return new RelationToViewerImpl();
    }

    /**
     * Create an instance of {@link Answers }
     * 
     */
    public Answers createAnswers() {
        return new AnswersImpl();
    }

    /**
     * Create an instance of {@link Bucket }
     * 
     */
    public Bucket createBucket() {
        return new BucketImpl();
    }

    /**
     * Create an instance of {@link Years }
     * 
     */
    public Years createYears() {
        return new YearsImpl();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new DateImpl();
    }

    /**
     * Create an instance of {@link MemberUrlResources }
     * 
     */
    public MemberUrlResources createMemberUrlResources() {
        return new MemberUrlResourcesImpl();
    }

    /**
     * Create an instance of {@link Patents }
     * 
     */
    public Patents createPatents() {
        return new PatentsImpl();
    }

    /**
     * Create an instance of {@link Recommendee }
     * 
     */
    public Recommendee createRecommendee() {
        return new RecommendeeImpl();
    }

    /**
     * Create an instance of {@link Action }
     * 
     */
    public Action createAction() {
        return new ActionImpl();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new AddressImpl();
    }

    /**
     * Create an instance of {@link DateOfBirth }
     * 
     */
    public DateOfBirth createDateOfBirth() {
        return new DateOfBirthImpl();
    }

    /**
     * Create an instance of {@link ThreeCurrentPositions }
     * 
     */
    public ThreeCurrentPositions createThreeCurrentPositions() {
        return new ThreeCurrentPositionsImpl();
    }

    /**
     * Create an instance of {@link Educations }
     * 
     */
    public Educations createEducations() {
        return new EducationsImpl();
    }

    /**
     * Create an instance of {@link CompanySearch }
     * 
     */
    public CompanySearch createCompanySearch() {
        return new CompanySearchImpl();
    }

    /**
     * Create an instance of {@link Authors }
     * 
     */
    public Authors createAuthors() {
        return new AuthorsImpl();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new ProductImpl();
    }

    /**
     * Create an instance of {@link ExpirationDate }
     * 
     */
    public ExpirationDate createExpirationDate() {
        return new ExpirationDateImpl();
    }

    /**
     * Create an instance of {@link CurrentShare }
     * 
     */
    public CurrentShare createCurrentShare() {
        return new CurrentShareImpl();
    }

    /**
     * Create an instance of {@link StartDate }
     * 
     */
    public StartDate createStartDate() {
        return new StartDateImpl();
    }

    /**
     * Create an instance of {@link Education }
     * 
     */
    public Education createEducation() {
        return new EducationImpl();
    }

    /**
     * Create an instance of {@link ItemContent }
     * 
     */
    public ItemContent createItemContent() {
        return new ItemContentImpl();
    }

    /**
     * Create an instance of {@link OriginalUpdate }
     * 
     */
    public OriginalUpdate createOriginalUpdate() {
        return new OriginalUpdateImpl();
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new AnswerImpl();
    }

    /**
     * Create an instance of {@link JobSearch }
     * 
     */
    public JobSearch createJobSearch() {
        return new JobSearchImpl();
    }

    /**
     * Create an instance of {@link Position }
     * 
     */
    public Position createPosition() {
        return new PositionImpl();
    }

    /**
     * Create an instance of {@link Facets }
     * 
     */
    public Facets createFacets() {
        return new FacetsImpl();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new PropertyImpl();
    }

    /**
     * Create an instance of {@link Connections }
     * 
     */
    public Connections createConnections() {
        return new ConnectionsImpl();
    }

    /**
     * Create an instance of {@link PublicationAuthor }
     * 
     */
    public PublicationAuthor createPublicationAuthor() {
        return new PublicationAuthorImpl();
    }

    /**
     * Create an instance of {@link Jobs }
     * 
     */
    public Jobs createJobs() {
        return new JobsImpl();
    }

    /**
     * Create an instance of {@link Industry }
     * 
     */
    public Industry createIndustry() {
        return new IndustryImpl();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new AuthorImpl();
    }

    /**
     * Create an instance of {@link Network }
     * 
     */
    public Network createNetwork() {
        return new NetworkImpl();
    }

    /**
     * Create an instance of {@link Publications }
     * 
     */
    public Publications createPublications() {
        return new PublicationsImpl();
    }

    /**
     * Create an instance of {@link NewPosition }
     * 
     */
    public NewPosition createNewPosition() {
        return new NewPositionImpl();
    }

    /**
     * Create an instance of {@link ImAccount }
     * 
     */
    public ImAccount createImAccount() {
        return new ImAccountImpl();
    }

    /**
     * Create an instance of {@link Recipient }
     * 
     */
    public Recipient createRecipient() {
        return new RecipientImpl();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new ErrorImpl();
    }

    /**
     * Create an instance of {@link Certifications }
     * 
     */
    public Certifications createCertifications() {
        return new CertificationsImpl();
    }

    /**
     * Create an instance of {@link StockExchange }
     * 
     */
    public StockExchange createStockExchange() {
        return new StockExchangeImpl();
    }

    /**
     * Create an instance of {@link ProfileField }
     * 
     */
    public ProfileField createProfileField() {
        return new ProfileFieldImpl();
    }

    /**
     * Create an instance of {@link Patent }
     * 
     */
    public Patent createPatent() {
        return new PatentImpl();
    }

    /**
     * Create an instance of {@link UpdateAction }
     * 
     */
    public UpdateAction createUpdateAction() {
        return new UpdateActionImpl();
    }

    /**
     * Create an instance of {@link Headers }
     * 
     */
    public Headers createHeaders() {
        return new HeadersImpl();
    }

    /**
     * Create an instance of {@link UpdateContent }
     * 
     */
    public UpdateContent createUpdateContent() {
        return new UpdateContentImpl();
    }

    /**
     * Create an instance of {@link Poster }
     * 
     */
    public Poster createPoster() {
        return new PosterImpl();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new PersonImpl();
    }

    /**
     * Create an instance of {@link Office }
     * 
     */
    public Office createOffice() {
        return new OfficeImpl();
    }

    /**
     * Create an instance of {@link UpdateComments }
     * 
     */
    public UpdateComments createUpdateComments() {
        return new UpdateCommentsImpl();
    }

    /**
     * Create an instance of {@link CompanyJobUpdate }
     * 
     */
    public CompanyJobUpdate createCompanyJobUpdate() {
        return new CompanyJobUpdateImpl();
    }

    /**
     * Create an instance of {@link Recommender }
     * 
     */
    public Recommender createRecommender() {
        return new RecommenderImpl();
    }

    /**
     * Create an instance of {@link Language }
     * 
     */
    public Language createLanguage() {
        return new LanguageImpl();
    }

    /**
     * Create an instance of {@link ProductDeal }
     * 
     */
    public ProductDeal createProductDeal() {
        return new ProductDealImpl();
    }

    /**
     * Create an instance of {@link ImAccounts }
     * 
     */
    public ImAccounts createImAccounts() {
        return new ImAccountsImpl();
    }

    /**
     * Create an instance of {@link EndDate }
     * 
     */
    public EndDate createEndDate() {
        return new EndDateImpl();
    }

    /**
     * Create an instance of {@link Facet }
     * 
     */
    public Facet createFacet() {
        return new FacetImpl();
    }

    /**
     * Create an instance of {@link Attribution }
     * 
     */
    public Attribution createAttribution() {
        return new AttributionImpl();
    }

    /**
     * Create an instance of {@link Publication }
     * 
     */
    public Publication createPublication() {
        return new PublicationImpl();
    }

    /**
     * Create an instance of {@link Content }
     * 
     */
    public Content createContent() {
        return new ContentImpl();
    }

    /**
     * Create an instance of {@link Updates }
     * 
     */
    public Updates createUpdates() {
        return new UpdatesImpl();
    }

    /**
     * Create an instance of {@link People }
     * 
     */
    public People createPeople() {
        return new PeopleImpl();
    }

    /**
     * Create an instance of {@link JobBookmarks }
     * 
     */
    public JobBookmarks createJobBookmarks() {
        return new JobBookmarksImpl();
    }

    /**
     * Create an instance of {@link Buckets }
     * 
     */
    public Buckets createBuckets() {
        return new BucketsImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "summary")
    public JAXBElement<String> createSummary(String value) {
        return new JAXBElement<String>(_Summary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "honors")
    public JAXBElement<String> createHonors(String value) {
        return new JAXBElement<String>(_Honors_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "public-profile-url")
    public JAXBElement<String> createPublicProfileUrl(String value) {
        return new JAXBElement<String>(_PublicProfileUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "disclaimer")
    public JAXBElement<String> createDisclaimer(String value) {
        return new JAXBElement<String>(_Disclaimer_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "main-address")
    public JAXBElement<String> createMainAddress(String value) {
        return new JAXBElement<String>(_MainAddress_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-recommenders")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createNumRecommenders(Long value) {
        return new JAXBElement<Long>(_NumRecommenders_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "city")
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "thumbnail-url")
    public JAXBElement<String> createThumbnailUrl(String value) {
        return new JAXBElement<String>(_ThumbnailUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "saved-timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createSavedTimestamp(Long value) {
        return new JAXBElement<Long>(_SavedTimestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ticker")
    public JAXBElement<String> createTicker(String value) {
        return new JAXBElement<String>(_Ticker_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "end-year")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createEndYear(Long value) {
        return new JAXBElement<Long>(_EndYear_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description-snippet")
    public JAXBElement<String> createDescriptionSnippet(String value) {
        return new JAXBElement<String>(_DescriptionSnippet_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "web-url")
    public JAXBElement<String> createWebUrl(String value) {
        return new JAXBElement<String>(_WebUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "year")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createYear(Long value) {
        return new JAXBElement<Long>(_Year_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "feature")
    public JAXBElement<String> createFeature(String value) {
        return new JAXBElement<String>(_Feature_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "last-name")
    public JAXBElement<String> createLastName(String value) {
        return new JAXBElement<String>(_LastName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "activities")
    public JAXBElement<String> createActivities(String value) {
        return new JAXBElement<String>(_Activities_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "salary")
    public JAXBElement<String> createSalary(String value) {
        return new JAXBElement<String>(_Salary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "im-account-name")
    public JAXBElement<String> createImAccountName(String value) {
        return new JAXBElement<String>(_ImAccountName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "email-domain")
    public JAXBElement<String> createEmailDomain(String value) {
        return new JAXBElement<String>(_EmailDomain_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "product-id")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createProductId(Long value) {
        return new JAXBElement<Long>(_ProductId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-active")
    public JAXBElement<Boolean> createIsActive(Boolean value) {
        return new JAXBElement<Boolean>(_IsActive_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "skills-and-experience")
    public JAXBElement<String> createSkillsAndExperience(String value) {
        return new JAXBElement<String>(_SkillsAndExperience_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "submitted-url")
    public JAXBElement<String> createSubmittedUrl(String value) {
        return new JAXBElement<String>(_SubmittedUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "number")
    public JAXBElement<String> createNumber(String value) {
        return new JAXBElement<String>(_Number_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-saved")
    public JAXBElement<Boolean> createIsSaved(Boolean value) {
        return new JAXBElement<Boolean>(_IsSaved_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "recommendation-text")
    public JAXBElement<String> createRecommendationText(String value) {
        return new JAXBElement<String>(_RecommendationText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "associations")
    public JAXBElement<String> createAssociations(String value) {
        return new JAXBElement<String>(_Associations_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "month")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createMonth(Long value) {
        return new JAXBElement<Long>(_Month_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "universal-name")
    public JAXBElement<String> createUniversalName(String value) {
        return new JAXBElement<String>(_UniversalName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "comment")
    public JAXBElement<String> createComment(String value) {
        return new JAXBElement<String>(_Comment_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "picture-url")
    public JAXBElement<String> createPictureUrl(String value) {
        return new JAXBElement<String>(_PictureUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NetworkUpdateContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "content-type")
    public JAXBElement<NetworkUpdateContentType> createContentType(NetworkUpdateContentType value) {
        return new JAXBElement<NetworkUpdateContentType>(_ContentType_QNAME, NetworkUpdateContentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subject")
    public JAXBElement<String> createSubject(String value) {
        return new JAXBElement<String>(_Subject_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "request-id")
    public JAXBElement<String> createRequestId(String value) {
        return new JAXBElement<String>(_RequestId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "site-job-url")
    public JAXBElement<String> createSiteJobUrl(String value) {
        return new JAXBElement<String>(_SiteJobUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "posting-timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createPostingTimestamp(Long value) {
        return new JAXBElement<Long>(_PostingTimestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-current")
    public JAXBElement<Boolean> createIsCurrent(Boolean value) {
        return new JAXBElement<Boolean>(_IsCurrent_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "country-code")
    public JAXBElement<String> createCountryCode(String value) {
        return new JAXBElement<String>(_CountryCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-liked")
    public JAXBElement<Boolean> createIsLiked(Boolean value) {
        return new JAXBElement<Boolean>(_IsLiked_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "creation-timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createCreationTimestamp(Long value) {
        return new JAXBElement<Long>(_CreationTimestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createTimestamp(Long value) {
        return new JAXBElement<Long>(_Timestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "distance")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createDistance(Long value) {
        return new JAXBElement<Long>(_Distance_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title")
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement<String>(_Title_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "expiration-timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createExpirationTimestamp(Long value) {
        return new JAXBElement<Long>(_ExpirationTimestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "website-url")
    public JAXBElement<String> createWebsiteUrl(String value) {
        return new JAXBElement<String>(_WebsiteUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "reply")
    public JAXBElement<String> createReply(String value) {
        return new JAXBElement<String>(_Reply_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-connections-capped")
    public JAXBElement<Boolean> createNumConnectionsCapped(Boolean value) {
        return new JAXBElement<Boolean>(_NumConnectionsCapped_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NetworkUpdateReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "update-type")
    public JAXBElement<NetworkUpdateReturnType> createUpdateType(NetworkUpdateReturnType value) {
        return new JAXBElement<NetworkUpdateReturnType>(_UpdateType_QNAME, NetworkUpdateReturnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "eyebrow-url")
    public JAXBElement<String> createEyebrowUrl(String value) {
        return new JAXBElement<String>(_EyebrowUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "customer-job-code")
    public JAXBElement<String> createCustomerJobCode(String value) {
        return new JAXBElement<String>(_CustomerJobCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-applied")
    public JAXBElement<Boolean> createIsApplied(Boolean value) {
        return new JAXBElement<Boolean>(_IsApplied_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "applied-timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createAppliedTimestamp(Long value) {
        return new JAXBElement<Long>(_AppliedTimestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tracking-pixel-url")
    public JAXBElement<String> createTrackingPixelUrl(String value) {
        return new JAXBElement<String>(_TrackingPixelUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "degree")
    public JAXBElement<String> createDegree(String value) {
        return new JAXBElement<String>(_Degree_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhoneType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "phone-type")
    public JAXBElement<PhoneType> createPhoneType(PhoneType value) {
        return new JAXBElement<PhoneType>(_PhoneType_QNAME, PhoneType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "first-name")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "blog-rss-url")
    public JAXBElement<String> createBlogRssUrl(String value) {
        return new JAXBElement<String>(_BlogRssUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-connections")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createNumConnections(Long value) {
        return new JAXBElement<Long>(_NumConnections_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sequence-number")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createSequenceNumber(Long value) {
        return new JAXBElement<Long>(_SequenceNumber_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "notes")
    public JAXBElement<String> createNotes(String value) {
        return new JAXBElement<String>(_Notes_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "body")
    public JAXBElement<String> createBody(String value) {
        return new JAXBElement<String>(_Body_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "count")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createCount(Long value) {
        return new JAXBElement<Long>(_Count_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "application-url")
    public JAXBElement<String> createApplicationUrl(String value) {
        return new JAXBElement<String>(_ApplicationUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-likable")
    public JAXBElement<Boolean> createIsLikable(Boolean value) {
        return new JAXBElement<Boolean>(_IsLikable_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "current-status")
    public JAXBElement<String> createCurrentStatus(String value) {
        return new JAXBElement<String>(_CurrentStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-headquarters")
    public JAXBElement<Boolean> createIsHeadquarters(Boolean value) {
        return new JAXBElement<Boolean>(_IsHeadquarters_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-commentable")
    public JAXBElement<Boolean> createIsCommentable(Boolean value) {
        return new JAXBElement<Boolean>(_IsCommentable_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "error-code")
    public JAXBElement<String> createErrorCode(String value) {
        return new JAXBElement<String>(_ErrorCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "square-logo-url")
    public JAXBElement<String> createSquareLogoUrl(String value) {
        return new JAXBElement<String>(_SquareLogoUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "phone2")
    public JAXBElement<String> createPhone2(String value) {
        return new JAXBElement<String>(_Phone2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "current-status-timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createCurrentStatusTimestamp(Long value) {
        return new JAXBElement<Long>(_CurrentStatusTimestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "phone1")
    public JAXBElement<String> createPhone1(String value) {
        return new JAXBElement<String>(_Phone1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "provider-account-name")
    public JAXBElement<String> createProviderAccountName(String value) {
        return new JAXBElement<String>(_ProviderAccountName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InviteConnectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "connect-type")
    public JAXBElement<InviteConnectType> createConnectType(InviteConnectType value) {
        return new JAXBElement<InviteConnectType>(_ConnectType_QNAME, InviteConnectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProficiencyLevelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "level")
    public JAXBElement<ProficiencyLevelType> createLevel(ProficiencyLevelType value) {
        return new JAXBElement<ProficiencyLevelType>(_Level_QNAME, ProficiencyLevelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "value")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createValue(String value) {
        return new JAXBElement<String>(_Value_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "resolved-url")
    public JAXBElement<String> createResolvedUrl(String value) {
        return new JAXBElement<String>(_ResolvedUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "submitted-image-url")
    public JAXBElement<String> createSubmittedImageUrl(String value) {
        return new JAXBElement<String>(_SubmittedImageUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "text")
    public JAXBElement<String> createText(String value) {
        return new JAXBElement<String>(_Text_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fax")
    public JAXBElement<String> createFax(String value) {
        return new JAXBElement<String>(_Fax_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "provider-account-id")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createProviderAccountId(Long value) {
        return new JAXBElement<Long>(_ProviderAccountId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "logo-url")
    public JAXBElement<String> createLogoUrl(String value) {
        return new JAXBElement<String>(_LogoUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "partner-job-id")
    public JAXBElement<String> createPartnerJobId(String value) {
        return new JAXBElement<String>(_PartnerJobId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "display")
    public JAXBElement<Boolean> createDisplay(Boolean value) {
        return new JAXBElement<Boolean>(_Display_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "url")
    public JAXBElement<String> createUrl(String value) {
        return new JAXBElement<String>(_Url_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "shortened-url")
    public JAXBElement<String> createShortenedUrl(String value) {
        return new JAXBElement<String>(_ShortenedUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "size")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createSize(String value) {
        return new JAXBElement<String>(_Size_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-recommendations")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createNumRecommendations(Long value) {
        return new JAXBElement<Long>(_NumRecommendations_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "active")
    public JAXBElement<Boolean> createActive(Boolean value) {
        return new JAXBElement<Boolean>(_Active_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "day")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createDay(Long value) {
        return new JAXBElement<Long>(_Day_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "email-address")
    public JAXBElement<String> createEmailAddress(String value) {
        return new JAXBElement<String>(_EmailAddress_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "headline")
    public JAXBElement<String> createHeadline(String value) {
        return new JAXBElement<String>(_Headline_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "interests")
    public JAXBElement<String> createInterests(String value) {
        return new JAXBElement<String>(_Interests_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-followers")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createNumFollowers(Long value) {
        return new JAXBElement<Long>(_NumFollowers_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-results")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createNumResults(Long value) {
        return new JAXBElement<Long>(_NumResults_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "state")
    public JAXBElement<String> createState(String value) {
        return new JAXBElement<String>(_State_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "contract-id")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createContractId(Long value) {
        return new JAXBElement<Long>(_ContractId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "founded-year")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createFoundedYear(Long value) {
        return new JAXBElement<Long>(_FoundedYear_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-likes")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createNumLikes(Long value) {
        return new JAXBElement<Long>(_NumLikes_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "selected")
    public JAXBElement<Boolean> createSelected(Boolean value) {
        return new JAXBElement<Boolean>(_Selected_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "im-account-type")
    public JAXBElement<ImAccountType> createImAccountType(ImAccountType value) {
        return new JAXBElement<ImAccountType>(_ImAccountType_QNAME, ImAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "recommendation-snippet")
    public JAXBElement<String> createRecommendationSnippet(String value) {
        return new JAXBElement<String>(_RecommendationSnippet_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "twitter-id")
    public JAXBElement<String> createTwitterId(String value) {
        return new JAXBElement<String>(_TwitterId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "app-id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createAppId(String value) {
        return new JAXBElement<String>(_AppId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "location-description")
    public JAXBElement<String> createLocationDescription(String value) {
        return new JAXBElement<String>(_LocationDescription_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "street2")
    public JAXBElement<String> createStreet2(String value) {
        return new JAXBElement<String>(_Street2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "street1")
    public JAXBElement<String> createStreet1(String value) {
        return new JAXBElement<String>(_Street1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "school-name")
    public JAXBElement<String> createSchoolName(String value) {
        return new JAXBElement<String>(_SchoolName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "postal-code")
    public JAXBElement<String> createPostalCode(String value) {
        return new JAXBElement<String>(_PostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "update-key")
    public JAXBElement<String> createUpdateKey(String value) {
        return new JAXBElement<String>(_UpdateKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "referral-bonus")
    public JAXBElement<String> createReferralBonus(String value) {
        return new JAXBElement<String>(_ReferralBonus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "region-code")
    public JAXBElement<String> createRegionCode(String value) {
        return new JAXBElement<String>(_RegionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "field-of-study")
    public JAXBElement<String> createFieldOfStudy(String value) {
        return new JAXBElement<String>(_FieldOfStudy_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "specialty")
    public JAXBElement<String> createSpecialty(String value) {
        return new JAXBElement<String>(_Specialty_QNAME, String.class, null, value);
    }

}
