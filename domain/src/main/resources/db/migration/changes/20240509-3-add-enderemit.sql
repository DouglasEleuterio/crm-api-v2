--liquibase formatted sql
--changeset douglas.ferreira:add-endermit

CREATE SEQUENCE sq_edt START WITH 1 INCREMENT BY 1;

CREATE TABLE edt_endereco_emitente
(
    edt_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    edt_x_lgr        VARCHAR2(255),
    edt_nro          VARCHAR2(255),
    edt_x_bairro     VARCHAR2(255),
    edt_c_mun        VARCHAR2(255),
    edt_x_mun        VARCHAR2(255),
    edt_uf           VARCHAR2(255),
    edt_cep          VARCHAR2(255),
    edt_c_pais       VARCHAR2(255),
    edt_x_pais       VARCHAR2(255),
    edt_fone         VARCHAR2(255),
    CONSTRAINT pk_edt_endereco_emitente PRIMARY KEY (edt_id)
);


