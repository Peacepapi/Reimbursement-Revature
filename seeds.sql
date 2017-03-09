DROP TABLE IF EXISTS ERS_USER_ROLES;
DROP TABLE IF EXISTS ERS_UERS;
DROP TABLE IF EXISTS ERS_REIMBURSEMENT_TYPE;
DROP TABLE IF EXISTS ERS_REIMBURSEMENT_STATUS;
DROP TABLE IF EXISTS ERS_REIMBURSEMENT;

-- USERS TABLE
CREATE TABLE "PIERCE"."ERS_USERS"
 (	"ERS_USERS_ID" NUMBER NOT NULL ENABLE,
"ERS_USERNAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
"ERS_PASSWORD" VARCHAR2(50 BYTE) NOT NULL ENABLE,
"USER_FIRST_NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
"USER_LAST_NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
"USER_EMAIL" VARCHAR2(150 BYTE) NOT NULL ENABLE,
"USER_ROLE_ID" NUMBER NOT NULL ENABLE,
 CONSTRAINT "ERS_USERS_PK" PRIMARY KEY ("ERS_USERS_ID")
USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
TABLESPACE "USERS"  ENABLE,
 CONSTRAINT "ERS_USERS_UNV1" UNIQUE ("ERS_USERNAME", "USER_EMAIL")
USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
TABLESPACE "USERS"  ENABLE,
 CONSTRAINT "USER_ROLES_FK" FOREIGN KEY ("USER_ROLE_ID")
  REFERENCES "PIERCE"."ERS_USER_ROLES" ("ERS_USER_ROLE_ID") ENABLE
 ) SEGMENT CREATION DEFERRED
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
NOCOMPRESS LOGGING
TABLESPACE "USERS" ;
-- USER ROLES TABLE
CREATE TABLE "PIERCE"."ERS_USER_ROLES"
 (	"ERS_USER_ROLE_ID" NUMBER NOT NULL ENABLE,
"USER_ROLE" VARCHAR2(10 BYTE) NOT NULL ENABLE,
 CONSTRAINT "ERS_USER_ROLES_PK" PRIMARY KEY ("ERS_USER_ROLE_ID")
USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
TABLESPACE "USERS"  ENABLE
 ) SEGMENT CREATION IMMEDIATE
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
NOCOMPRESS LOGGING
STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
TABLESPACE "USERS" ;
-- Reimbursement Type
  CREATE TABLE "PIERCE"."ERS_REIMBURSEMENT_TYPE"
   (	"REIMB_TYPE_ID" NUMBER NOT NULL ENABLE,
	"REIMB_TYPE" VARCHAR2(10 BYTE) NOT NULL ENABLE,
	 CONSTRAINT "ERS_REIMBURSEMENT_TYPE_PK" PRIMARY KEY ("REIMB_TYPE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
-- Reimbursement Status
  CREATE TABLE "PIERCE"."ERS_REIMBURSEMENT_STATUS"
   (	"REIMB_STATUS_ID" NUMBER NOT NULL ENABLE,
	"REIMB_STATUS" VARCHAR2(10 BYTE) NOT NULL ENABLE,
	 CONSTRAINT "ERS_REIMBURSEMENT_STATUS_PK" PRIMARY KEY ("REIMB_STATUS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
-- Reimbursement
  CREATE TABLE "PIERCE"."ERS_REIMBURSEMENT"
   (	"REIMB_ID" NUMBER NOT NULL ENABLE,
	"REIMB_AMOUNT" NUMBER NOT NULL ENABLE,
	"REIMB_SUBMITTED" TIMESTAMP (6) NOT NULL ENABLE,
	"REIMB_RESOLVED" TIMESTAMP (6),
	"REIMB_DESCRIPTION" VARCHAR2(250 BYTE),
	"REIMB_RECEIPT" BLOB,
	"REIMB_AUTHOR" NUMBER NOT NULL ENABLE,
	"REIMB_RESOLVER" NUMBER,
	"REIMB_STATUS_ID" NUMBER NOT NULL ENABLE,
	"REIMB_TYPE_ID" NUMBER NOT NULL ENABLE,
	 CONSTRAINT "ERS_REIMBURSEMENT_PK" PRIMARY KEY ("REIMB_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
  TABLESPACE "USERS"  ENABLE,
	 CONSTRAINT "ERS_REIMBURSEMENT_TYPE_FK" FOREIGN KEY ("REIMB_TYPE_ID")
	  REFERENCES "PIERCE"."ERS_REIMBURSEMENT_TYPE" ("REIMB_TYPE_ID") ENABLE,
	 CONSTRAINT "ERS_REIMBURSEMENT_STATUS_FK" FOREIGN KEY ("REIMB_STATUS_ID")
	  REFERENCES "PIERCE"."ERS_REIMBURSEMENT_STATUS" ("REIMB_STATUS_ID") ENABLE,
	 CONSTRAINT "ERS_USERS_FK_AUTH" FOREIGN KEY ("REIMB_AUTHOR")
	  REFERENCES "PIERCE"."ERS_USERS" ("ERS_USERS_ID") ENABLE,
	 CONSTRAINT "ERS_USERS_FK_RESLVR" FOREIGN KEY ("REIMB_RESOLVER")
	  REFERENCES "PIERCE"."ERS_USERS" ("ERS_USERS_ID") ENABLE
   ) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
 NOCOMPRESS LOGGING
  TABLESPACE "USERS"
 LOB ("REIMB_RECEIPT") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES ) ;

-- REIMBURSEMENT_SEQ
CREATE SEQUENCE REIMBURSEMENT_SEQ INCREMENT BY 1 START WITH 1 MINVALUE 1;
-- REIMBURSEMENT TRIGGER
create or replace TRIGGER REIMB_PK_GENERATOR_TRIGGER
  BEFORE INSERT ON ERS_REIMBURSEMENT
  FOR EACH ROW
  DECLARE
    pk number;
  BEGIN
    SELECT REIMBURSEMENT_SEQ.NEXTVAL
    INTO pk
    FROM dual;
    :NEW.REIMB_ID := pk;
  END;
-- create view for the joins
CREATE VIEW V_All_Reimb AS
SELECT reimb.REIMB_ID AS reimb_id,
      reimb.REIMB_AMOUNT AS reimb_amount,
      reimb.REIMB_SUBMITTED AS reimb_submitted,
      reimb.REIMB_DESCRIPTION AS reimb_description,
      reimb.REIMB_RECEIPT AS reimb_receipt,
      reimb.REIMB_RESOLVED AS reimb_resolved,
      reimb.REIMB_AUTHOR AS reimb_author,
      reimb.REIMB_RESOLVER AS reimb_resolver,
      reimb.REIMB_STATUS_ID AS reimb_status_id,
      reimb.REIMB_TYPE_ID AS reimb_type_id,
      status.REIMB_STATUS_ID AS status_id,
      status.REIMB_STATUS AS status,
      type.REIMB_TYPE_ID AS type_id,
      type.REIMB_TYPE AS type,
      author.ERS_USERS_ID AS author_id,
      author.ERS_USERNAME AS author_name,
      author.ERS_PASSWORD AS author_password,
      author.USER_FIRST_NAME AS author_fName,
      author.USER_LAST_NAME AS author_lName,
      author.USER_EMAIL AS author_email,
      author.USER_ROLE_ID AS author_roleId,
      authorRole.ERS_USER_ROLE_ID AS authorRole_id,
      authorRole.USER_ROLE AS authorRole,
      resolvsr.ERS_USERS_ID AS resolvsr_id,
      resolvsr.ERS_USERNAME AS resolvsr_name,
      resolvsr.ERS_PASSWORD AS resolvsr_password,
      resolvsr.USER_FIRST_NAME AS resolvsr_fName,
      resolvsr.USER_LAST_NAME AS resolvsr_lName,
      resolvsr.USER_EMAIL AS resolvsr_email,
      resolvsr.USER_ROLE_ID AS resolvsr_roleId,
      resolvsrRole.ERS_USER_ROLE_ID AS resolvsrRole_id,
      resolvsrRole.USER_ROLE AS resolvsrRole
FROM ERS_REIMBURSEMENT reimb
LEFT JOIN ERS_REIMBURSEMENT_STATUS status
ON reimb.REIMB_STATUS_ID = status.REIMB_STATUS_ID
LEFT JOIN ERS_REIMBURSEMENT_TYPE type
ON reimb.REIMB_TYPE_ID = type.REIMB_TYPE_ID
LEFT JOIN ERS_USERS author
ON reimb.REIMB_AUTHOR = author.ERS_USERS_ID
LEFT JOIN ERS_USER_ROLES authorRole
ON author.ERS_USERS_ID = authorRole.ERS_USER_ROLE_ID
LEFT JOIN ERS_USERS resolvsr
ON reimb.REIMB_RESOLVER = resolvsr.ERS_USERS_ID
LEFT JOIN ERS_USER_ROLES resolvsrRole
ON resolvsr.ERS_USERS_ID = resolvsrRole.ERS_USER_ROLE_ID;
-- Status seeds
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES (1,'Pending');
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES (2,'Approved');
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES (3,'Denied');
-- Type seeds
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (1, 'Lodgings');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (2, 'Travel');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (3, 'Food');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (4, 'Other');
-- USER ROLES seeds DATA
INSERT INTO ERS_USER_ROLES VALUES(1,'Employee');
INSERT INTO ERS_USER_ROLES VALUES(2,'FinancialM');
-- User seeds Data
INSERT INTO ERS_USERS(ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
  VALUES (1, 'SDippy', 'password', 'Sharon', 'Dippy', 'gettingdippy@home.com', 2);
INSERT INTO ERS_USERS(ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
  VALUES (2, 'YungGoose', '$2a$10$prJN.EEp6iCavAw2X9d6p.Q1BpSj.q9LZNVCPWHFz.bhTzzyen/WG', 'Sharoasfn', 'Derpy', 'gengdippy@home.com', 2);
-- Reimbursement seeds data
INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID)
VALUES (12.43,SYSDATE,2,1,1);
INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID)
VALUES (92.43,SYSDATE,1,1,2);
