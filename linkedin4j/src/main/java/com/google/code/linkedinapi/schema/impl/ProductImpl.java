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
import com.google.code.linkedinapi.schema.Features;
import com.google.code.linkedinapi.schema.Product;
import com.google.code.linkedinapi.schema.ProductCategory;
import com.google.code.linkedinapi.schema.ProductDeal;
import com.google.code.linkedinapi.schema.ProductType;
import com.google.code.linkedinapi.schema.Recommendations;
import com.google.code.linkedinapi.schema.SalesPersons;
import com.google.code.linkedinapi.schema.Video;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "name",
    "type",
    "description",
    "logoUrl",
    "creationTimestamp",
    "features",
    "numRecommendations",
    "productDeal",
    "salesPersons",
    "video",
    "recommendations",
    "productCategory",
    "websiteUrl",
    "disclaimer"
})
@XmlRootElement(name = "product")
public class ProductImpl
    implements Serializable, Product
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true, type = ProductTypeImpl.class)
    protected ProductTypeImpl type;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "logo-url", required = true)
    protected String logoUrl;
    @XmlElement(name = "creation-timestamp", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long creationTimestamp;
    @XmlElement(required = true, type = FeaturesImpl.class)
    protected FeaturesImpl features;
    @XmlElement(name = "num-recommendations", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long numRecommendations;
    @XmlElement(name = "product-deal", required = true, type = ProductDealImpl.class)
    protected ProductDealImpl productDeal;
    @XmlElement(name = "sales-persons", required = true, type = SalesPersonsImpl.class)
    protected SalesPersonsImpl salesPersons;
    @XmlElement(required = true, type = VideoImpl.class)
    protected VideoImpl video;
    @XmlElement(type = RecommendationsImpl.class)
    protected RecommendationsImpl recommendations;
    @XmlElement(name = "product-category", required = true, type = ProductCategoryImpl.class)
    protected ProductCategoryImpl productCategory;
    @XmlElement(name = "website-url", required = true)
    protected String websiteUrl;
    protected String disclaimer;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType value) {
        this.type = ((ProductTypeImpl) value);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String value) {
        this.logoUrl = value;
    }

    public Long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Long value) {
        this.creationTimestamp = value;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features value) {
        this.features = ((FeaturesImpl) value);
    }

    public Long getNumRecommendations() {
        return numRecommendations;
    }

    public void setNumRecommendations(Long value) {
        this.numRecommendations = value;
    }

    public ProductDeal getProductDeal() {
        return productDeal;
    }

    public void setProductDeal(ProductDeal value) {
        this.productDeal = ((ProductDealImpl) value);
    }

    public SalesPersons getSalesPersons() {
        return salesPersons;
    }

    public void setSalesPersons(SalesPersons value) {
        this.salesPersons = ((SalesPersonsImpl) value);
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video value) {
        this.video = ((VideoImpl) value);
    }

    public Recommendations getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(Recommendations value) {
        this.recommendations = ((RecommendationsImpl) value);
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory value) {
        this.productCategory = ((ProductCategoryImpl) value);
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String value) {
        this.websiteUrl = value;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String value) {
        this.disclaimer = value;
    }

}
