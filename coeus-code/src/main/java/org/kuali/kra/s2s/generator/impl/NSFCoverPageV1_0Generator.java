/*
 * Copyright 2005-2014 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.s2s.generator.impl;

import gov.grants.apply.forms.nsfCoverPageV10.DegreeTypeDataType;
import gov.grants.apply.forms.nsfCoverPageV10.NSFCoverPageDocument;
import gov.grants.apply.forms.nsfCoverPageV10.NSFCoverPageDocument.NSFCoverPage;
import gov.grants.apply.forms.nsfCoverPageV10.NSFCoverPageDocument.NSFCoverPage.CoPIInfo;
import gov.grants.apply.forms.nsfCoverPageV10.NSFCoverPageDocument.NSFCoverPage.CoPIInfo.CoPI;
import gov.grants.apply.forms.nsfCoverPageV10.NSFCoverPageDocument.NSFCoverPage.NSFUnitConsideration;
import gov.grants.apply.forms.nsfCoverPageV10.NSFCoverPageDocument.NSFCoverPage.OtherInfo;
import gov.grants.apply.forms.nsfCoverPageV10.NSFCoverPageDocument.NSFCoverPage.PIInfo;
import gov.grants.apply.system.attachmentsV10.AttachedFileDataType;
import gov.grants.apply.system.attachmentsV10.AttachmentGroupMin1Max100DataType;
import gov.grants.apply.system.globalLibraryV10.YesNoDataType;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.propdev.api.person.ProposalPersonContract;
import org.kuali.coeus.propdev.api.person.ProposalPersonDegreeContract;
import org.kuali.coeus.propdev.api.person.ProposalPersonYnqContract;
import org.kuali.coeus.propdev.api.ynq.ProposalYnqContract;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.api.attachment.NarrativeContract;
import org.kuali.kra.s2s.generator.FormGenerator;
import org.kuali.kra.s2s.util.S2SConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is used to generate XML Document object for grants.gov NSFCoverPageV1.0. This form is generated using XMLBean API's
 * generated by compiling NSFCoverPageV1.0 schema.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
@FormGenerator("NSFCoverPageV1_0Generator")
public class NSFCoverPageV1_0Generator extends NSFCoverPageBaseGenerator {


    private static final String QUESTION_ID_ACCOMPLISHMENT_RENEWAL = "8";
    private static final String QUESTION_ID_ISCURRENT_PI = "19";
    private static final DegreeTypeDataType.Enum DEFAULT_DEGREE_TYPE = DegreeTypeDataType.UKNW_NO_DEGREE_INFORMATION_SPECIFIED;

    /**
     * 
     * This method returns NSFCoverPageDocument object based on proposal development document which contains the
     * NSFCoverPageDocument informations NSFUnitConsideration,FundingOpportunityNumber,PIInfo,CoPIInfo,OtherInfo,and
     * SingleCopyDocuments for a particular proposal
     * 
     * @return nsfCoverPageDocument {@link XmlObject} of type NSFCoverPageDocument.
     */
    private NSFCoverPageDocument getNSFCoverPage() {

        NSFCoverPageDocument nsfCoverPageDocument = NSFCoverPageDocument.Factory.newInstance();
        NSFCoverPage nsfCoverPage = NSFCoverPage.Factory.newInstance();
        nsfCoverPage.setFormVersion(S2SConstants.FORMVERSION_1_0);
        nsfCoverPage.setFundingOpportunityNumber(pdDoc.getDevelopmentProposal().getProgramAnnouncementNumber());
        nsfCoverPage.setNSFUnitConsideration(getNSFUnitConsideration());
        nsfCoverPage.setPIInfo(getPIInfo());
        nsfCoverPage.setCoPIInfo(getCoPI());
        nsfCoverPage.setOtherInfo(getOtherInfo());

        AttachmentGroupMin1Max100DataType attachmentGroup = AttachmentGroupMin1Max100DataType.Factory.newInstance();
        attachmentGroup.setAttachedFileArray(getAttachedFileDataTypes());
        nsfCoverPage.setSingleCopyDocuments(attachmentGroup);

        nsfCoverPageDocument.setNSFCoverPage(nsfCoverPage);
        return nsfCoverPageDocument;
    }

    /**
     * 
     * This method returns DivisionCode and ProgramCode information for the NSFUnitConsideration type.
     * 
     * @return NSFUnitConsideration object containing unit consideration informations like Division Code and Program code.
     */
    private NSFUnitConsideration getNSFUnitConsideration() {
        NSFUnitConsideration unitConsideration = NSFUnitConsideration.Factory.newInstance();
        unitConsideration.setDivisionCode(pdDoc.getDevelopmentProposal().getAgencyDivisionCode());
        unitConsideration.setProgramCode(pdDoc.getDevelopmentProposal().getAgencyProgramCode());
        return unitConsideration;
    }

    /**
     * 
     * This method returns Investigator status,DisclosureLobbyingActivities,ExploratoryResearch,HistoricPlaces,
     * HighResolutionGraphics and AccomplishmentRenewal information for the OtherInfo type.
     * 
     * @return OtherInfo object containing other informations about the principal investigator.
     */
    private OtherInfo getOtherInfo() {
        OtherInfo otherInfo = OtherInfo.Factory.newInstance();
        YesNoDataType.Enum yesNoDataType = getYNQAnswer(QUESTION_ID_BEGIN_INVESTIGATOR);
        if (yesNoDataType != null) {
            otherInfo.setIsBeginInvestigator(yesNoDataType);
        }
        yesNoDataType = getLobbyingAnswer();
        if (yesNoDataType != null) {
            otherInfo.setIsDisclosureLobbyingActivities(yesNoDataType);
        }
        yesNoDataType = getYNQAnswer(QUESTION_ID_EXPLORATORY_RESEARCH);
        if (yesNoDataType != null) {
            otherInfo.setIsExploratoryResearch(yesNoDataType);
        }
        yesNoDataType = getYNQAnswer(QUESTION_ID_HISTORIC_PLACES);
        if (yesNoDataType != null) {
            otherInfo.setIsHistoricPlaces(yesNoDataType);
        }

        String proposalTypeCode = pdDoc.getDevelopmentProposal().getProposalTypeCode();
        if (proposalTypeCode != null) {
            otherInfo.setIsAccomplishmentRenewal(proposalTypeCode.equals(QUESTION_ID_ACCOMPLISHMENT_RENEWAL) ? YesNoDataType.YES
                    : YesNoDataType.NO);
        }
        yesNoDataType = getYNQAnswer(QUESTION_ID_RESOLUTION_GRAPHICS);
        if (yesNoDataType != null) {
            otherInfo.setIsHighResolutionGraphics(yesNoDataType);
        }
        return otherInfo;
    }

    /**
     * 
     * This method returns attachment type for the form and it can be of type Personal Data or Proprietary Information.
     * 
     * @return AttachedFileDataType[] array of attachments based on the narrative type code.
     */
	private AttachedFileDataType[] getAttachedFileDataTypes() {
		List<AttachedFileDataType> attachedFileDataTypeList = new ArrayList<AttachedFileDataType>();
		for (NarrativeContract narrative : pdDoc.getDevelopmentProposal()
				.getNarratives()) {
			if (narrative.getNarrativeType().getCode() != null) {
				int narrativeTypeCode = Integer.parseInt(narrative.getNarrativeType().getCode());
				if (narrativeTypeCode == PERSONAL_DATA
						|| narrativeTypeCode == PROPRIETARY_INFORMATION 
						|| narrativeTypeCode == SINGLE_COPY_DOCUMENT) {
                    AttachedFileDataType attachedFileDataType = getAttachedFileType(narrative);
					if(attachedFileDataType != null){
						attachedFileDataTypeList.add(attachedFileDataType);
					}
				}
			}
		}
		return attachedFileDataTypeList
				.toArray(new AttachedFileDataType[attachedFileDataTypeList
						.size()]);
	}
    
    /**
     * 
     * This method returns PIInfo informations such as DegreeType,DegreeYear,CurrentPI status, for the PI.
     * 
     * @return PIInfo object containing principal investigator Degree details.
     */
    private PIInfo getPIInfo() {
        PIInfo pInfo = PIInfo.Factory.newInstance();
        ProposalPersonContract PI = s2sUtilService.getPrincipalInvestigator(pdDoc);
        if (PI != null) {
            for (ProposalPersonDegreeContract personDegree : PI.getProposalPersonDegrees()) {
                DegreeTypeDataType.Enum degreeType = DEFAULT_DEGREE_TYPE;               
                if (personDegree.getDegreeType() != null && personDegree.getDegreeType().getCode() != null) {
                    StringBuilder degreeTypeDetail = new StringBuilder();
                    degreeTypeDetail.append(personDegree.getDegreeType().getCode());
                    degreeTypeDetail.append(": ");
                    degreeTypeDetail.append(personDegree.getDegreeType().getDescription());
                    degreeType = DegreeTypeDataType.Enum.forString( degreeTypeDetail.toString());
                    if(degreeType==null){
                        //Some degrees in nthe database are not available DegreeType. Therefor this extra check.
                        degreeType=DEFAULT_DEGREE_TYPE;
                    }
                }
                else {
                    degreeType = DEFAULT_DEGREE_TYPE;
                }
                pInfo.setDegreeType(degreeType);
                if (personDegree.getGraduationYear() != null) {
                    pInfo.setDegreeYear(getYearAsCalendar(personDegree.getGraduationYear()));
                }
            }
            pInfo.setIsCurrentPI(getYNQAnswer(QUESTION_ID_ISCURRENT_PI));
        }
        return pInfo;
    }
    
    /**
     * 
     * This method returns CoPIInfo informations such as Name,DegreeType,DegreeYear for the CoPI.
     * 
     * @return CoPIInfo object containing Co-principal investigator Degree details.
     */
    private CoPIInfo getCoPI() {

        CoPIInfo coPIInfo = CoPIInfo.Factory.newInstance();
        int count = 0;
        ProposalPersonContract coInvestigator = null;
        for (ProposalPersonContract proposalPerson : pdDoc.getDevelopmentProposal().getProposalPersons()) {
            if (proposalPerson.getProposalPersonRoleId() != null
                    && proposalPerson.getProposalPersonRoleId().equals(PI_C0_INVESTIGATOR)) {
                count++;
            }
        }
        CoPI[] coPIArray = new CoPI[count];
        count = 0;
        
        for (ProposalPersonContract proposalPerson : pdDoc.getDevelopmentProposal().getProposalPersons()) {
            if (proposalPerson.getProposalPersonRoleId() != null
                    && proposalPerson.getProposalPersonRoleId().equals(PI_C0_INVESTIGATOR)) {
                coInvestigator = proposalPerson;
                CoPI coPI = CoPI.Factory.newInstance();
                coPI.setName(globLibV10Generator.getHumanNameDataType(coInvestigator));
                for (ProposalPersonDegreeContract personDegree : coInvestigator.getProposalPersonDegrees()) {
                    DegreeTypeDataType.Enum degreeType=DEFAULT_DEGREE_TYPE;
                    if (personDegree!=null && personDegree.getDegreeType() != null && personDegree.getDegreeType().getCode() != null) {
                        StringBuilder degreeTypeDetail = new StringBuilder();
                        degreeTypeDetail.append(personDegree.getDegreeType().getCode());
                        degreeTypeDetail.append(": ");
                        degreeTypeDetail.append(personDegree.getDegreeType().getDescription());
                        degreeType = DegreeTypeDataType.Enum.forString(degreeTypeDetail.toString());
                        if(degreeType==null){
                            //Some degrees in nthe database are not available DegreeType. Therefor this extra check.
                            degreeType=DEFAULT_DEGREE_TYPE;
                        }
                    }
                    coPI.setDegreeType(degreeType);
                    if (personDegree.getGraduationYear() != null) {
                        coPI.setDegreeYear(getYearAsCalendar(personDegree.getGraduationYear()));
                    }
                }
                coPIArray[count] = coPI;
                count++;
            }
        }
        coPIInfo.setCoPIArray(coPIArray);
        return coPIInfo;
    }

    

    /**
     * 
     * This method returns YesNo data type YNQ answers based on the ProposalYnq QuestionId
     * 
     * @param questionId Proposal Ynq question id
     * @return answer (YesNoDataType.Enum) corresponding to the question id.
     */
    private YesNoDataType.Enum getYNQAnswer(String questionId) {

        YesNoDataType.Enum answer = null;
        for (ProposalYnqContract proposalYnq : pdDoc.getDevelopmentProposal().getProposalYnqs()) {
            if (proposalYnq.getYnq() != null && proposalYnq.getYnq().getQuestionId().equals(questionId)) {
                if (proposalYnq.getAnswer() != null) {
                    answer = (proposalYnq.getAnswer().equals(S2SConstants.PROPOSAL_YNQ_ANSWER_Y) ? YesNoDataType.YES
                            : YesNoDataType.NO);
                }
                break;
            }
        }
        return answer;
    }

    /**
     * 
     * This method returns YesNo data type Lobbying answers based on the ProposalYnq QuestionId
     * 
     * @return answer (YesNoDataType.Enum) corresponding to Ynq question id.
     */
    private YesNoDataType.Enum getLobbyingAnswer() {

        YesNoDataType.Enum answer = YesNoDataType.NO;
        for (ProposalPersonContract proposalPerson : pdDoc.getDevelopmentProposal().getProposalPersons()) {
            if (proposalPerson.getProposalPersonRoleId() != null
                    && proposalPerson.getProposalPersonRoleId().equals(PRINCIPAL_INVESTIGATOR)
                    || proposalPerson.getProposalPersonRoleId().equals(PI_C0_INVESTIGATOR)) {
                for (ProposalPersonYnqContract personYnq : proposalPerson.getProposalPersonYnqs()) {
                    if (personYnq != null) {
                        if (personYnq.getQuestionId() != null && personYnq.getQuestionId().equals(PROPOSAL_YNQ_LOBBYING_ACTIVITIES.toString())) {
                            if (personYnq.getAnswer() != null && personYnq.getAnswer().equals(S2SConstants.PROPOSAL_YNQ_ANSWER_Y)) {
                                return YesNoDataType.YES;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    /**
     * This method creates {@link XmlObject} of type {@link NSFCoverPageDocument} by populating data from the given
     * {@link ProposalDevelopmentDocument}
     * 
     * @param proposalDevelopmentDocument for which the {@link XmlObject} needs to be created
     * @return {@link XmlObject} which is generated using the given {@link ProposalDevelopmentDocument}
     * @see org.kuali.kra.s2s.generator.S2SFormGenerator#getFormObject(ProposalDevelopmentDocument)
     */
    public XmlObject getFormObject(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        this.pdDoc = proposalDevelopmentDocument;
        return getNSFCoverPage();
    }
}
