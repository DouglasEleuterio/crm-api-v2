--liquibase formatted sql
--changeset douglas.ferreira:add-aliquota-diferenciada

CREATE SEQUENCE sq_tad START WITH 1 INCREMENT BY 1;

CREATE TABLE tad_tab_aliquota_diferenciada
(
    tad_id                 NUMBER(38, 0) NOT NULL,
    data_criacao           TIMESTAMP     NOT NULL,
    data_atualizacao       TIMESTAMP     NOT NULL,
    tad_nu_ncm             VARCHAR2(9)   NOT NULL,
    tad_dt_inicio_vigencia date          NOT NULL,
    tad_dt_fim_vigencia    date,
    tad_st_situacao        VARCHAR2(255),
    situacao               NUMBER(1)     NOT NULL,
    CONSTRAINT pk_tad_tab_aliquota_diferenciada PRIMARY KEY (tad_id)
);
