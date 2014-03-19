delimiter /
TRUNCATE TABLE VALID_PROTO_SUB_TYPE_QUAL
/
INSERT INTO SEQ_VALID_SUBM_REVW_TYPE_QUAL VALUES (null)
/
INSERT INTO VALID_PROTO_SUB_TYPE_QUAL (VALID_PROTO_SUB_TYPE_QUAL_ID,SUBMISSION_TYPE_CODE,SUBMISSION_TYPE_QUAL_CODE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES ((SELECT MAX(ID) FROM SEQ_VALID_SUBM_REVW_TYPE_QUAL),(SELECT SUBMISSION_TYPE_CODE FROM SUBMISSION_TYPE WHERE DESCRIPTION = 'FYI'),(SELECT SUBMISSION_TYPE_QUAL_CODE FROM SUBMISSION_TYPE_QUALIFIER WHERE DESCRIPTION = 'Modification/Amendment/Revisions/Significant New Finding'),'admin',NOW(),UUID(),1)
/
INSERT INTO SEQ_VALID_SUBM_REVW_TYPE_QUAL VALUES (null)
/
INSERT INTO VALID_PROTO_SUB_TYPE_QUAL (VALID_PROTO_SUB_TYPE_QUAL_ID,SUBMISSION_TYPE_CODE,SUBMISSION_TYPE_QUAL_CODE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES ((SELECT MAX(ID) FROM SEQ_VALID_SUBM_REVW_TYPE_QUAL),(SELECT SUBMISSION_TYPE_CODE FROM SUBMISSION_TYPE WHERE DESCRIPTION = 'FYI'),(SELECT SUBMISSION_TYPE_QUAL_CODE FROM SUBMISSION_TYPE_QUALIFIER WHERE DESCRIPTION = 'Annual Scheduled by IRB'),'admin',NOW(),UUID(),1)
/
INSERT INTO SEQ_VALID_SUBM_REVW_TYPE_QUAL VALUES (null)
/
INSERT INTO VALID_PROTO_SUB_TYPE_QUAL (VALID_PROTO_SUB_TYPE_QUAL_ID,SUBMISSION_TYPE_CODE,SUBMISSION_TYPE_QUAL_CODE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES ((SELECT MAX(ID) FROM SEQ_VALID_SUBM_REVW_TYPE_QUAL),(SELECT SUBMISSION_TYPE_CODE FROM SUBMISSION_TYPE WHERE DESCRIPTION = 'FYI'),(SELECT SUBMISSION_TYPE_QUAL_CODE FROM SUBMISSION_TYPE_QUALIFIER WHERE DESCRIPTION = 'Contingent/Conditional Approval/Deferred Approval/ Non-Approval'),'admin',NOW(),UUID(),1)
/
INSERT INTO SEQ_VALID_SUBM_REVW_TYPE_QUAL VALUES (null)
/
INSERT INTO VALID_PROTO_SUB_TYPE_QUAL (VALID_PROTO_SUB_TYPE_QUAL_ID,SUBMISSION_TYPE_CODE,SUBMISSION_TYPE_QUAL_CODE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES ((SELECT MAX(ID) FROM SEQ_VALID_SUBM_REVW_TYPE_QUAL),(SELECT SUBMISSION_TYPE_CODE FROM SUBMISSION_TYPE WHERE DESCRIPTION = 'FYI'),(SELECT SUBMISSION_TYPE_QUAL_CODE FROM SUBMISSION_TYPE_QUALIFIER WHERE DESCRIPTION = 'Protocol-related COI Report'),'admin',NOW(),UUID(),1)
/
INSERT INTO SEQ_VALID_SUBM_REVW_TYPE_QUAL VALUES (null)
/
INSERT INTO VALID_PROTO_SUB_TYPE_QUAL (VALID_PROTO_SUB_TYPE_QUAL_ID,SUBMISSION_TYPE_CODE,SUBMISSION_TYPE_QUAL_CODE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES ((SELECT MAX(ID) FROM SEQ_VALID_SUBM_REVW_TYPE_QUAL),(SELECT SUBMISSION_TYPE_CODE FROM SUBMISSION_TYPE WHERE DESCRIPTION = 'FYI'),(SELECT SUBMISSION_TYPE_QUAL_CODE FROM SUBMISSION_TYPE_QUALIFIER WHERE DESCRIPTION = 'Self report for Noncompliance'),'admin',NOW(),UUID(),1)
/
INSERT INTO SEQ_VALID_SUBM_REVW_TYPE_QUAL VALUES (null)
/
INSERT INTO VALID_PROTO_SUB_TYPE_QUAL (VALID_PROTO_SUB_TYPE_QUAL_ID,SUBMISSION_TYPE_CODE,SUBMISSION_TYPE_QUAL_CODE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES ((SELECT MAX(ID) FROM SEQ_VALID_SUBM_REVW_TYPE_QUAL),(SELECT SUBMISSION_TYPE_CODE FROM SUBMISSION_TYPE WHERE DESCRIPTION = 'FYI'),(SELECT SUBMISSION_TYPE_QUAL_CODE FROM SUBMISSION_TYPE_QUALIFIER WHERE DESCRIPTION = 'Unanticipated Problems'),'admin',NOW(),UUID(),1)
/
INSERT INTO SEQ_VALID_SUBM_REVW_TYPE_QUAL VALUES (null)
/
INSERT INTO VALID_PROTO_SUB_TYPE_QUAL (VALID_PROTO_SUB_TYPE_QUAL_ID,SUBMISSION_TYPE_CODE,SUBMISSION_TYPE_QUAL_CODE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES ((SELECT MAX(ID) FROM SEQ_VALID_SUBM_REVW_TYPE_QUAL),(SELECT SUBMISSION_TYPE_CODE FROM SUBMISSION_TYPE WHERE DESCRIPTION = 'FYI'),(SELECT SUBMISSION_TYPE_QUAL_CODE FROM SUBMISSION_TYPE_QUALIFIER WHERE DESCRIPTION = 'DSMB Report'),'admin',NOW(),UUID(),1)
/
delimiter ;