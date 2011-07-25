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
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Company;

public class CompaniesImpl
extends BaseSchemaEntity implements Companies
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Company> companyList;
    protected Long count;
    protected Long start;
    protected Long total;

    public List<Company> getCompanyList() {
        if (companyList == null) {
            companyList = new ArrayList<Company>();
        }
        return this.companyList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long value) {
        this.start = value;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));
        setStart(XppUtils.getAttributeValueAsLongFromNode(parser, "start"));
        setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("company")) {
                CompanyImpl node = new CompanyImpl();
                node.init(parser);
                getCompanyList().add(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "companies");
        XppUtils.setAttributeValueToNode(element, "count", getCount());
        XppUtils.setAttributeValueToNode(element, "start", getStart());
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        for (Company node : getCompanyList()) {
            ((CompanyImpl) node).toXml(serializer);
        }
        
        serializer.endTag(null, "companies");
    }
}
