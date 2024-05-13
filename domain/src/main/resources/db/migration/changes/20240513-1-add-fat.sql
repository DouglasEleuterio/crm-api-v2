--liquibase formatted sql
--changeset douglas.ferreira:add-fat

CREATE SEQUENCE sq_fat START WITH 1 INCREMENT BY 1;

CREATE TABLE fat_fat
(
    fat_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    fat_v_orig       VARCHAR2(255),
    fat_n_fat        VARCHAR2(255),
    fat_v_desc       VARCHAR2(255),
    fat_v_liq        VARCHAR2(255),
    CONSTRAINT pk_fat_fat PRIMARY KEY (fat_id)
);