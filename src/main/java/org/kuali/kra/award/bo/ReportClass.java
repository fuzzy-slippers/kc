/*
 * Copyright 2006-2008 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kuali.kra.award.bo;

import java.util.LinkedHashMap;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;

/**
 * 
 * This class represents the ReportClass business object and is mapped to
 * REPORT_CLASS table.
 */
public class ReportClass extends KraPersistableBusinessObjectBase { 
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2641812275218339806L;
    private String reportClassCode; 
    private String description; 
    private boolean generateReportRequirements; 
    
    /**
     * Constructs a ReportClass.java
     */
    public ReportClass() { 

    } 
    
    /**
     * 
     * @return
     */
    public String getReportClassCode() {
        return reportClassCode;
    }

    /**
     * 
     * @param reportClassCode
     */
    public void setReportClassCode(String reportClassCode) {
        this.reportClassCode = reportClassCode;
    }

    /**
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     */
    public boolean getGenerateReportRequirements() {
        return generateReportRequirements;
    }

    /**
     * 
     * @param generateReportRequirements
     */
    public void setGenerateReportRequirements(boolean generateReportRequirements) {
        this.generateReportRequirements = generateReportRequirements;
    }   

    /**
     * 
     * @see org.kuali.core.bo.BusinessObjectBase#toStringMapper()
     */
    @Override 
    protected LinkedHashMap<String,Object> toStringMapper() {
        LinkedHashMap<String,Object> hashMap = new LinkedHashMap<String,Object>();
        hashMap.put("reportClassCode", getReportClassCode());
        hashMap.put("description", getDescription());
        hashMap.put("generateReportRequirements", getGenerateReportRequirements());
        return hashMap;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((reportClassCode == null) ? 0 : reportClassCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ReportClass other = (ReportClass) obj;
        if (reportClassCode == null) {
            if (other.reportClassCode != null)
                return false;
        }
        else if (!reportClassCode.equals(other.reportClassCode))
            return false;
        return true;
    }
    
}