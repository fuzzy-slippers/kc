CREATE TABLE S2S_USER_ATTACHED_FORM_ATT ( 
    S2S_USER_ATTACHED_FORM_ATT_ID NUMBER(12,0) NOT NULL, 
    S2S_USER_ATTACHED_FORM_ID NUMBER(12,0) NOT NULL, 
    PROPOSAL_NUMBER VARCHAR2(8) NOT NULL, 
    CONTENT_TYPE VARCHAR2(100), 
    FILE_NAME VARCHAR2(100), 
    CONTENT_ID VARCHAR2(350), 
    UPDATE_USER VARCHAR2(60) NOT NULL, 
    UPDATE_TIMESTAMP DATE NOT NULL, 
    VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL, 
    OBJ_ID VARCHAR2(36) DEFAULT SYS_GUID() NOT NULL)
/
ALTER TABLE S2S_USER_ATTACHED_FORM_ATT 
ADD CONSTRAINT PK_S2S_USER_ATTACHED_FORM_ATT 
PRIMARY KEY (S2S_USER_ATTACHED_FORM_ATT_ID)
/
ALTER TABLE S2S_USER_ATTACHED_FORM_ATT 
ADD CONSTRAINT FK1_S2S_USER_ATTACHED_FORM_ATT 
FOREIGN KEY (S2S_USER_ATTACHED_FORM_ID) 
REFERENCES S2S_USER_ATTACHED_FORM (S2S_USER_ATTACHED_FORM_ID)
ON DELETE CASCADE
/
CREATE TABLE S2S_USER_ATTD_FORM_ATT_FILE ( 
    S2S_USER_ATTD_FORM_ATT_FILE_ID NUMBER(12,0) NOT NULL, 
    S2S_USER_ATTACHED_FORM_ATT_ID NUMBER(12,0) NOT NULL, 
    ATTACHMENT BLOB DEFAULT EMPTY_BLOB(), 
    UPDATE_USER VARCHAR2(60) NOT NULL, 
    UPDATE_TIMESTAMP DATE NOT NULL, 
    VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL, 
    OBJ_ID VARCHAR2(36) DEFAULT SYS_GUID() NOT NULL)
/
ALTER TABLE S2S_USER_ATTD_FORM_ATT_FILE 
ADD CONSTRAINT PK_S2S_USER_ATTD_FORM_ATT_FILE 
PRIMARY KEY (S2S_USER_ATTD_FORM_ATT_FILE_ID)
/
ALTER TABLE S2S_USER_ATTD_FORM_ATT_FILE 
ADD CONSTRAINT FK1_S2S_USR_ATD_FRM_ATT_FIL 
FOREIGN KEY (S2S_USER_ATTACHED_FORM_ATT_ID) 
REFERENCES S2S_USER_ATTACHED_FORM_ATT (S2S_USER_ATTACHED_FORM_ATT_ID) ON DELETE CASCADE
/