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

import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.CompanySearch;
import com.google.code.linkedinapi.schema.Facets;

public class CompanySearchImpl
	extends BaseSchemaEntity implements CompanySearch
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected CompaniesImpl companies;
    protected Long numResults;
    protected FacetsImpl facets;

    public Companies getCompanies() {
        return companies;
    }

    public void setCompanies(Companies value) {
        this.companies = ((CompaniesImpl) value);
    }

    public Long getNumResults() {
        return numResults;
    }

    public void setNumResults(Long value) {
        this.numResults = value;
    }

    public Facets getFacets() {
        return facets;
    }

    public void setFacets(Facets value) {
        this.facets = ((FacetsImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("companies")) {
                CompaniesImpl node = new CompaniesImpl();
                node.init(parser);
                setCompanies(node);
            } else if (name.equals("num-results")) {
                setNumResults(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("facets")) {
                FacetsImpl node = new FacetsImpl();
                node.init(parser);
                setFacets(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "company-search");
        if (getCompanies() != null) {
            ((CompaniesImpl) getCompanies()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "num-results", getNumResults());
        if (getFacets() != null) {
            ((FacetsImpl) getFacets()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "company-search");
    }
}
