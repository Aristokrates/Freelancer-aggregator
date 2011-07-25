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
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationType;
import com.google.code.linkedinapi.schema.Recommendee;
import com.google.code.linkedinapi.schema.Recommender;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "recommendationType",
    "recommendationText",
    "recommendationSnippet",
    "recommender",
    "recommendee",
    "webUrl",
    "productId",
    "timestamp",
    "text",
    "reply",
    "likes"
})
@XmlRootElement(name = "recommendation")
public class RecommendationImpl
    implements Serializable, Recommendation
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "recommendation-type", required = true, type = RecommendationTypeImpl.class)
    protected RecommendationTypeImpl recommendationType;
    @XmlElement(name = "recommendation-text")
    protected String recommendationText;
    @XmlElement(name = "recommendation-snippet")
    protected String recommendationSnippet;
    @XmlElement(required = true, type = RecommenderImpl.class)
    protected RecommenderImpl recommender;
    @XmlElement(required = true, type = RecommendeeImpl.class)
    protected RecommendeeImpl recommendee;
    @XmlElement(name = "web-url")
    protected String webUrl;
    @XmlElement(name = "product-id", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long productId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long timestamp;
    protected String text;
    @XmlElement(required = true)
    protected String reply;
    @XmlElement(required = true, type = LikesImpl.class)
    protected LikesImpl likes;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public RecommendationType getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(RecommendationType value) {
        this.recommendationType = ((RecommendationTypeImpl) value);
    }

    public String getRecommendationText() {
        return recommendationText;
    }

    public void setRecommendationText(String value) {
        this.recommendationText = value;
    }

    public String getRecommendationSnippet() {
        return recommendationSnippet;
    }

    public void setRecommendationSnippet(String value) {
        this.recommendationSnippet = value;
    }

    public Recommender getRecommender() {
        return recommender;
    }

    public void setRecommender(Recommender value) {
        this.recommender = ((RecommenderImpl) value);
    }

    public Recommendee getRecommendee() {
        return recommendee;
    }

    public void setRecommendee(Recommendee value) {
        this.recommendee = ((RecommendeeImpl) value);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long value) {
        this.productId = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String value) {
        this.reply = value;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes value) {
        this.likes = ((LikesImpl) value);
    }

}
