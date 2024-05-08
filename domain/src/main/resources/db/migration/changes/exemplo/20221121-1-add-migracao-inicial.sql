-- liquibase formatted sql
-- changeset douglas.ferreira:add-migracao-inicial

CREATE SEQUENCE sq_revisao START WITH 1 INCREMENT BY 1;

CREATE TABLE revision
(
    id            NUMBER(38, 0) NOT NULL,
    user_id       VARCHAR2(150) NOT NULL,
    username      VARCHAR2(150) NOT NULL,
    user_ip       VARCHAR2(30),
    revision_date TIMESTAMP,
    CONSTRAINT pk_revision PRIMARY KEY (id)
);
