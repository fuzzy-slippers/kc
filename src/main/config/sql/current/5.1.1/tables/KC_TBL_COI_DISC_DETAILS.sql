alter table COI_DISC_DETAILS add ENTITY_DISPOSITION_CODE NUMBER(3,0)
/

update COI_DISC_DETAILS set ENTITY_DISPOSITION_CODE = 210 where ENTITY_STATUS_CODE = '1'
/

update COI_DISC_DETAILS set ENTITY_DISPOSITION_CODE = 320 where ENTITY_STATUS_CODE = '2'
/

alter table COI_DISC_DETAILS drop column ENTITY_STATUS_CODE
/