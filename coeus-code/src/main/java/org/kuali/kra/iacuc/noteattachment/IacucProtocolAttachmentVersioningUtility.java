/*
 * Copyright 2005-2014 The Kuali Foundation
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
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.coeus.common.framework.version.VersioningService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.ProtocolFormBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentProtocolBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentService;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentVersioningUtilityBase;

public class IacucProtocolAttachmentVersioningUtility extends ProtocolAttachmentVersioningUtilityBase {

    public IacucProtocolAttachmentVersioningUtility(ProtocolFormBase form) {
        super(form, getProtocolAttachmentService(), KcServiceLocator.getService(VersioningService.class));
    }
    
    private static ProtocolAttachmentService getProtocolAttachmentService() {
        return KcServiceLocator.getService("iacucProtocolAttachmentService");
    }

    @Override
    protected Class<? extends ProtocolAttachmentProtocolBase> getProtocolAttachmentProtocolClassHook() {
        return IacucProtocolAttachmentProtocol.class;
    }


}