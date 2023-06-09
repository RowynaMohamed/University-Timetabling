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
package org.unitime.timetable.form;

import java.util.Collection;
import java.util.Iterator;

import org.unitime.timetable.action.UniTimeAction;
import org.unitime.timetable.model.DepartmentalInstructor;
import org.unitime.timetable.model.Staff;


public class InstructorListUpdateForm implements UniTimeForm {

	// --------------------------------------------------------- Instance Variables
	private String deptCode;
	private String deptName;
	private String op;
	private Collection assignedInstr;
	private Collection availableInstr;
	private String[] assigned;
	private String[] available;
	private String[] assignedSelected = {};
	private String[] availableSelected = {};
	private String nameFormat;
	
	// Filter settings
	private String displayListType;
	private String[] displayPosType;
	
	// --------------------------------------------------------- Methods

	/**
	 * 
	 */
	private static final long serialVersionUID = 6131705766470532900L;

	@Override
	public void validate(UniTimeAction action) {}

	@Override
	public void reset(){}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String[] getAssigned() {
		return assigned;
	}

	public void setAssigned(String[] assigned) {
		this.assigned = assigned;
	}

	public Collection getAssignedInstr() {
		return assignedInstr;
	}

	public void setAssignedInstr(Collection assignedInstr) {
		this.assignedInstr = assignedInstr;
	}

	public String[] getAssignedSelected() {
		return assignedSelected;
	}

	public void setAssignedSelected(String[] assignedSelected) {
		this.assignedSelected = assignedSelected;
	}

	public String[] getAvailable() {
		return available;
	}

	public void setAvailable(String[] available) {
		this.available = available;
	}

	public Collection getAvailableInstr() {
		return availableInstr;
	}

	public void setAvailableInstr(Collection availableInstr) {
		this.availableInstr = availableInstr;
	}

	public String[] getAvailableSelected() {
		return availableSelected;
	}

	public void setAvailableSelected(String[] availableSelected) {
		this.availableSelected = availableSelected;
	}
	
    public String getDisplayListType() {
        return displayListType;
    }
    
    public void setDisplayListType(String displayListType) {
        this.displayListType = displayListType;
    }
    
    public String[] getDisplayPosType() {
        return displayPosType;
    }
    
    public void setDisplayPosType(String[] displayPosType) {
        this.displayPosType = displayPosType;
    }
    
	public void setInstructors() {
		int i = 0;
		Iterator iter = null;

		if (assignedInstr != null) {
			String[] assignedSelection = new String[assignedInstr.size()];
			assigned = new String[assignedInstr.size()];
			for (iter = assignedInstr.iterator(); iter.hasNext();) {
				DepartmentalInstructor inst = (DepartmentalInstructor) iter.next();
				assignedSelection[i] = inst.getUniqueId().toString();
				assigned[i] = inst.getUniqueId().toString();
				i++;
			}
			assignedSelected = assignedSelection;
		}

		i = 0;
		if (availableInstr != null) {
			available = new String[availableInstr.size()];
			for (iter = availableInstr.iterator(); iter.hasNext();) {
				Staff s = (Staff) iter.next();
				available[i] = s.getUniqueId().toString();
				i++;
			}
		}
		
	}
	
	public String getNameFormat() { return nameFormat; }
	public void setNameFormat(String nameFormat) { this.nameFormat = nameFormat; }
}

