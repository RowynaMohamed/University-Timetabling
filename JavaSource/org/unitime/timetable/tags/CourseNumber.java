/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * The Apereo Foundation licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
*/
package org.unitime.timetable.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.TextField;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Tomas Muller
 */
@StrutsTag(name = "course-number", tldTagClass = "org.unitime.timetable.tags.CourseNumberTag", description = "GWT-based course number suggestions box")
public class CourseNumber extends TextField {
	final public static String TEMPLATE = "course-number";
	
	private String outerStyle = null;
	private String configuration = null;
	
	public CourseNumber(final ValueStack stack, final HttpServletRequest request, final HttpServletResponse response) {
        super(stack, request, response);
    }
	
	@StrutsTagAttribute(description="Outer style", type="String")
	public void setOuterStyle(String outerStyle) { this.outerStyle = outerStyle; }
	
	@StrutsTagAttribute(description="Configuration", type="String")
	public void setConfiguration(String configuration) { this.configuration = configuration; }
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}
	
	protected void evaluateExtraParams() {
        super.evaluateExtraParams();
        if (configuration != null) {
            addParameter("configuration", findValue(configuration, String.class));
        }
        
        if (outerStyle != null) {
            addParameter("outerStyle", findValue(outerStyle, String.class));
        }
	}
}