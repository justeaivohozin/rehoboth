CREATE SCHEMA IF NOT EXISTS person_sch;

CREATE SEQUENCE person_sch.PES_ID_PER START WITH 1;
CREATE SEQUENCE person_sch.PES_ID_TL START WITH 1;
CREATE SEQUENCE person_sch.PES_ID_CON START WITH 1;


CREATE TABLE IF NOT EXISTS person_sch.PERSON_SERVICE_CONTACT
(
    CONTACT_ID             bigint       NOT NULL,
    CONTACT_EMAIL          varchar(255) NOT NULL,
    CONTACT_PHONE_NUMBER   varchar(255) NOT NULL,
    ADDRESS_ROAD           varchar(255) NOT NULL,
    ADDRESS_NUMBER         int          NOT NULL,
    ADDRESS_TOWN           varchar(255),
    ADDRESS_ZIPCODE        varchar(255),
    SOCIAL_MEDIA_FACEBOOK  varchar(255),
    SOCIAL_MEDIA_INSTAGRAM varchar(255),
    SOCIAL_MEDIA_LINKEDIN  varchar(255),
    SOCIAL_MEDIA_SNAPCHAT  varchar(255),
    CONSTRAINT CONTACT_PK PRIMARY KEY (CONTACT_ID)
);


CREATE TABLE IF NOT EXISTS person_sch.PERSON_SERVICE_PERSON
(
    PERSON_ID         integer NOT NULL,
    PERSON_FIRST_NAME varchar NOT NULL,
    PERSON_LAST_NAME  varchar NOT NULL,
    PERSON_BIRTH_NAME DATE,
    PERSON_CAMPUS_ID  integer,
    PERSON_SEX        varchar NOT NULL,
    CONTACT_ID        integer,
    CONSTRAINT PERSON_PK PRIMARY KEY (PERSON_ID),
    CONSTRAINT FK_PS_PERSON_ON_PS_CONTACT FOREIGN KEY (CONTACT_ID) REFERENCES person_sch.PERSON_SERVICE_CONTACT (CONTACT_ID)
);


CREATE TABLE IF NOT EXISTS person_sch.PERSON_SERVICE_TITLE
(
    TITLE_ID   integer NOT NULL,
    TITLE_NAME varchar NOT NULL,
    PERSON_ID  integer,
    CONSTRAINT TITLE_FK PRIMARY KEY (TITLE_ID),
    CONSTRAINT FK_PS_PERSON_ON_PS_CONTACT FOREIGN KEY (PERSON_ID) REFERENCES person_sch.PERSON_SERVICE_PERSON (PERSON_ID)
);
