DROP DATABASE IF EXISTS CEF440_AdminModule_db;

CREATE DATABASE IF NOT EXISTS CEF440_AdminModule_db;
USE CEF440_AdminModule_db;
# -----------------------------------------------------------------------------
#       TABLE : NORMAL_USER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS NORMAL_USER
 (
   NM_ID BIGINT(8) NOT NULL  ,
   LOCATION_ID INTEGER NOT NULL  ,
   USER_FULLNAME VARCHAR(50) NOT NULL  ,
   USER_NAME VARCHAR(10) NOT NULL,  
   USER_EMAIL VARCHAR(50) NOT NULL  
      DEFAULT "john.doe@email.com",
   USER_DOB DATE NOT NULL  ,
   USER_PASSWORD CHAR(32) NOT NULL  ,
   USER_TYPE CHAR(32) NOT NULL       CHECK (USER_TYPE in ("NM","FA","AD"))
   , PRIMARY KEY (NM_ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : USER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS USER
 (
   USER_ID BIGINT(8) NOT NULL  ,
   USER_FULLNAME VARCHAR(50) NOT NULL  ,
   USER_NAME VARCHAR(10) NOT NULL,
   USER_EMAIL VARCHAR(50) NOT NULL  
      DEFAULT "john.doe@email.com",
   USER_DOB DATE NOT NULL  ,
   USER_PASSWORD CHAR(32) NOT NULL  ,
   USER_TYPE CHAR(32) NOT NULL       CHECK (USER_TYPE in ("NM","FA","AD"))
   , PRIMARY KEY (USER_ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : USER_COVID_RELATED_DETAILS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS USER_COVID_RELATED_DETAILS
 (
   DETAIL_ID BIGINT(8) NOT NULL  ,
   NM_ID BIGINT(8) NOT NULL  ,
   AGENT_ID BIGINT(8) NOT NULL  ,
   COVID_CONTACTS_MULTIVALUED VARCHAR(50) NOT NULL  
      DEFAULT "None",
   COVID_AREAS_MULTIVALUED VARCHAR(30) NOT NULL  
      DEFAULT "None",
   U_GRANTSTATE CHAR(4) NOT NULL  
      DEFAULT "None"     CHECK (U_GRANTSTATE in ("Yes","None")),
   U_HEALTHSTATE CHAR(32) NOT NULL  
      DEFAULT "None"     CHECK (U_HEALTHSTATE in ("Headache","Fever","Runny Nose","Breathing Difficulty","Cough","None"))
   , PRIMARY KEY (DETAIL_ID) 
 ) 
 comment = "Users COVID19 related information";

# -----------------------------------------------------------------------------
#       TABLE : GRANTS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS GRANTS
 (
   ITEM_ID INTEGER NOT NULL  ,
   LOCATION_ID INTEGER NOT NULL  ,
   ITEM_NAME CHAR(32) NOT NULL  ,
   ITEM_CATEGORY CHAR(8) NOT NULL       CHECK (ITEM_CATEGORY in ("FD","GD"))
   , PRIMARY KEY (ITEM_ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SYSTEM_ADMIN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SYSTEM_ADMIN
 (
   ADMIN_ID BIGINT(8) NOT NULL  ,
   USER_FULLNAME VARCHAR(50) NOT NULL  ,
   USER_NAME VARCHAR(10) NOT NULL,
   USER_EMAIL VARCHAR(50) NOT NULL  
      DEFAULT "john.doe@email.com",
   USER_DOB DATE NOT NULL  ,
   USER_PASSWORD CHAR(32) NOT NULL  ,
   USER_TYPE CHAR(32) NOT NULL       CHECK (USER_TYPE in ("NM","FA","AD"))
   , PRIMARY KEY (ADMIN_ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : LOCATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOCATION
 (
   LOCATION_ID INTEGER NOT NULL  ,
   REGION CHAR(32) NOT NULL  ,
   DIVISION CHAR(32) NOT NULL  ,
   TOWN CHAR(32) NOT NULL  
   , PRIMARY KEY (LOCATION_ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : AGENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AGENT
 (
   AGENT_ID BIGINT(8) NOT NULL  ,
   ADMIN_ID BIGINT(8) NOT NULL  ,
   USER_FULLNAME VARCHAR(50) NOT NULL  ,
   USER_NAME VARCHAR(10) NOT NULL,
   USER_EMAIL VARCHAR(50) NOT NULL  
      DEFAULT "john.doe@email.com",
   USER_DOB DATE NOT NULL  ,
   USER_PASSWORD CHAR(32) NOT NULL  ,
   USER_TYPE CHAR(32) NOT NULL       CHECK (USER_TYPE in ("NM","FA","AD"))
   , PRIMARY KEY (AGENT_ID) 
 ) 
 comment = "Normal Agents Table";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE NORMAL_USER 
  ADD FOREIGN KEY FK_NORMAL_USER_LOCATION (LOCATION_ID)
      REFERENCES LOCATION (LOCATION_ID) ;


ALTER TABLE NORMAL_USER 
  ADD FOREIGN KEY FK_NORMAL_USER_USER (NM_ID)
      REFERENCES USER (USER_ID) ;


ALTER TABLE USER_COVID_RELATED_DETAILS 
  ADD FOREIGN KEY FK_USER_COVID_RELATED_DETAILS_NORMAL_USER (NM_ID)
      REFERENCES NORMAL_USER (NM_ID) ;


ALTER TABLE USER_COVID_RELATED_DETAILS 
  ADD FOREIGN KEY FK_USER_COVID_RELATED_DETAILS_AGENT (AGENT_ID)
      REFERENCES AGENT (AGENT_ID) ;


ALTER TABLE GRANTS 
  ADD FOREIGN KEY FK_GRANTS_LOCATION (LOCATION_ID)
      REFERENCES LOCATION (LOCATION_ID) ;


ALTER TABLE SYSTEM_ADMIN 
  ADD FOREIGN KEY FK_SYSTEM_ADMIN_USER (ADMIN_ID)
      REFERENCES USER (USER_ID) ;


ALTER TABLE AGENT 
  ADD FOREIGN KEY FK_AGENT_SYSTEM_ADMIN (ADMIN_ID)
      REFERENCES SYSTEM_ADMIN (ADMIN_ID) ;


ALTER TABLE AGENT 
  ADD FOREIGN KEY FK_AGENT_USER (AGENT_ID)
      REFERENCES USER (USER_ID) ;

