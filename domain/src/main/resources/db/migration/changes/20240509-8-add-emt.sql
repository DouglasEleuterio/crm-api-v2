--liquibase formatted sql
--changeset douglas.ferreira:add-emt

CREATE SEQUENCE sq_emt START WITH 1 INCREMENT BY 1;

CREATE TABLE emt_emt
(
    emt_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    emt_cnpj         VARCHAR2(255),
    emt_x_nome       VARCHAR2(255),
    emt_x_fant       VARCHAR2(255),
    emt_ie           VARCHAR2(255),
    emt_crt          VARCHAR2(255),
    edt_id           NUMBER(38, 0),
    CONSTRAINT pk_emt_emt PRIMARY KEY (emt_id)
);

ALTER TABLE emt_emt
    ADD CONSTRAINT FK_EDT_EMT FOREIGN KEY (edt_id) REFERENCES edt_endereco_emitente (edt_id);


