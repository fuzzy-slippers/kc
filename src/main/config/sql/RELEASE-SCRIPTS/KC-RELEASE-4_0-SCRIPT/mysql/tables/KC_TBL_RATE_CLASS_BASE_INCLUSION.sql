DELIMITER /
CREATE TABLE RATE_CLASS_BASE_INCLUSION ( 
    RATE_CLASS_BASE_INCL_ID DECIMAL(12,0) NOT NULL, 
    RATE_CLASS_CODE VARCHAR(3) NOT NULL, 
    RATE_TYPE_CODE VARCHAR(3), 
    RATE_CLASS_CODE_INCL VARCHAR(3) NOT NULL, 
    RATE_TYPE_CODE_INCL VARCHAR(3), 
    UPDATE_TIMESTAMP DATE NOT NULL, 
    UPDATE_USER VARCHAR(60) NOT NULL, 
    VER_NBR DECIMAL(8,0) DEFAULT 1 NOT NULL, 
    OBJ_ID VARCHAR(36) NOT NULL) ENGINE InnoDB CHARACTER SET utf8 COLLATE utf8_bin
/
ALTER TABLE RATE_CLASS_BASE_INCLUSION 
ADD CONSTRAINT PK_RATE_CLASS_BASE_INCLUSION
PRIMARY KEY (RATE_CLASS_BASE_INCL_ID)
/
DELIMITER ;