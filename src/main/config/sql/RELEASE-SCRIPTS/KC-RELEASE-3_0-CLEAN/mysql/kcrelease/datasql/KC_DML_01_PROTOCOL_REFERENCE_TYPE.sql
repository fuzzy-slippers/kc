delimiter /
TRUNCATE TABLE PROTOCOL_REFERENCE_TYPE
/
INSERT INTO PROTOCOL_REFERENCE_TYPE (PROTOCOL_REFERENCE_TYPE_CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (1,'CALGB','Y','admin',NOW(),UUID(),1)
/
INSERT INTO PROTOCOL_REFERENCE_TYPE (PROTOCOL_REFERENCE_TYPE_CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (2,'RTOG','Y','admin',NOW(),UUID(),1)
/
INSERT INTO PROTOCOL_REFERENCE_TYPE (PROTOCOL_REFERENCE_TYPE_CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (3,'IRBNet','Y','admin',NOW(),UUID(),1)
/
INSERT INTO PROTOCOL_REFERENCE_TYPE (PROTOCOL_REFERENCE_TYPE_CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (4,'COAG','Y','admin',NOW(),UUID(),1)
/
delimiter ;