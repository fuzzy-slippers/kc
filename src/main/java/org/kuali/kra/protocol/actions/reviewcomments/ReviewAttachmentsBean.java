/*
 * Copyright 2005-2010 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
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
package org.kuali.kra.protocol.actions.reviewcomments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.kuali.kra.protocol.onlinereview.ProtocolReviewAttachment;

public abstract class ReviewAttachmentsBean implements Serializable {


    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -376105485699731967L;
    
    private String errorPropertyKey;
    private ProtocolReviewAttachment newReviewAttachment;
    private List<ProtocolReviewAttachment> reviewAttachments;
    private List<ProtocolReviewAttachment> deletedReviewAttachments;
    // flag to hide reviewer name for this bean.
    private boolean hideReviewerName;
    /**
     * Constructs a ReviewerAttachmentsBean.
     */
    public ReviewAttachmentsBean(String errorPropertyKey) {
        this.errorPropertyKey = errorPropertyKey + ".reviewAttachmentsBean";        
        this.newReviewAttachment = getNewProtocolReviewAttachmentInstanceHook();
        this.reviewAttachments = new ArrayList<ProtocolReviewAttachment>();
        this.deletedReviewAttachments = new ArrayList<ProtocolReviewAttachment>();
    }

    protected abstract ProtocolReviewAttachment getNewProtocolReviewAttachmentInstanceHook();
    
    public String getErrorPropertyName() {
        return errorPropertyKey;
    }
    

    public boolean isHideReviewerName() {
        return hideReviewerName;
    }

    public void setHideReviewerName(boolean hideReviewerName) {
        this.hideReviewerName = hideReviewerName;
    }
    
    public ProtocolReviewAttachment getNewReviewAttachment() {
        return newReviewAttachment;
    }

    public void setNewReviewAttachment(ProtocolReviewAttachment newReviewAttachment) {
        this.newReviewAttachment = newReviewAttachment;
    }

    public List<ProtocolReviewAttachment> getReviewAttachments() {
        return reviewAttachments;
    }

    public void setReviewAttachments(List<ProtocolReviewAttachment> reviewAttachments) {
        this.reviewAttachments = reviewAttachments;
    }

    public List<ProtocolReviewAttachment> getDeletedReviewAttachments() {
        return deletedReviewAttachments;
    }

    public void setDeletedReviewAttachments(List<ProtocolReviewAttachment> deletedReviewAttachments) {
        this.deletedReviewAttachments = deletedReviewAttachments;
    }
}