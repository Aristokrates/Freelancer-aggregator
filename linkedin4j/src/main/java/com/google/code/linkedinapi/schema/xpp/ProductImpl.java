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

import com.google.code.linkedinapi.schema.Features;
import com.google.code.linkedinapi.schema.Product;
import com.google.code.linkedinapi.schema.ProductCategory;
import com.google.code.linkedinapi.schema.ProductDeal;
import com.google.code.linkedinapi.schema.ProductType;
import com.google.code.linkedinapi.schema.Recommendations;
import com.google.code.linkedinapi.schema.SalesPersons;
import com.google.code.linkedinapi.schema.Video;

public class ProductImpl
	extends BaseSchemaEntity implements Product
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String name;
    protected ProductTypeImpl type;
    protected String description;
    protected String logoUrl;
    protected Long creationTimestamp;
    protected FeaturesImpl features;
    protected Long numRecommendations;
    protected ProductDealImpl productDeal;
    protected SalesPersonsImpl salesPersons;
    protected VideoImpl video;
    protected RecommendationsImpl recommendations;
    protected ProductCategoryImpl productCategory;
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
        this.features = (FeaturesImpl) value;
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
        this.salesPersons = (SalesPersonsImpl) value;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("type")) {
                ProductTypeImpl node = new ProductTypeImpl();
                node.init(parser);
                setType(node);
            } else if (name.equals("description")) {
                setDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("logo-url")) {
                setLogoUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("creation-timestamp")) {
                setCreationTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("features")) {
            	FeaturesImpl node = new FeaturesImpl();
            	node.init(parser);
                setFeatures(node);
            } else if (name.equals("num-recommendations")) {
                setNumRecommendations(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("product-deal")) {
                ProductDealImpl node = new ProductDealImpl();
                node.init(parser);
                setProductDeal(node);
            } else if (name.equals("sales-persons")) {
            	SalesPersonsImpl node = new SalesPersonsImpl();
            	node.init(parser);
                setSalesPersons(node);
            } else if (name.equals("video")) {
                VideoImpl node = new VideoImpl();
                node.init(parser);
                setVideo(node);
            } else if (name.equals("recommendations")) {
                RecommendationsImpl node = new RecommendationsImpl();
                node.init(parser);
                setRecommendations(node);
            } else if (name.equals("product-category")) {
                ProductCategoryImpl node = new ProductCategoryImpl();
                node.init(parser);
                setProductCategory(node);
            } else if (name.equals("website-url")) {
                setWebsiteUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("disclaimer")) {
                setDisclaimer(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "product");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "name", getName());
        if (getType() != null) {
            ((ProductTypeImpl) getType()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "description", getDescription());
        XppUtils.setElementValueToNode(element, "logo-url", getLogoUrl());
        XppUtils.setElementValueToNode(element, "creation-timestamp", getCreationTimestamp());
        if (getFeatures() != null) {
        	((FeaturesImpl) getFeatures()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "num-recommendations", getNumRecommendations());
        if (getProductDeal() != null) {
            ((ProductDealImpl) getProductDeal()).toXml(serializer);
        }
        if (getSalesPersons() != null) {
        	((SalesPersonsImpl) getSalesPersons()).toXml(serializer);
        }
        if (getVideo() != null) {
            ((VideoImpl) getVideo()).toXml(serializer);
        }
        if (getRecommendations() != null) {
            ((RecommendationsImpl) getRecommendations()).toXml(serializer);
        }
        if (getProductCategory() != null) {
            ((ProductCategoryImpl) getProductCategory()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "website-url", getWebsiteUrl());
        XppUtils.setElementValueToNode(element, "disclaimer", getDisclaimer());
        
        
        serializer.endTag(null, "product");
    }
}
