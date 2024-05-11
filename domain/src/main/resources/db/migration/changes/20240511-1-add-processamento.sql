--liquibase formatted sql
--changeset douglas.ferreira:add-processamento

CREATE SEQUENCE sq_processamento START WITH 1 INCREMENT BY 1;

CREATE TABLE prc_processamento
(
    prc_id                        NUMBER(38, 0) NOT NULL,
    data_criacao                  TIMESTAMP     NOT NULL,
    data_atualizacao              TIMESTAMP     NOT NULL,
    prc_dh_inicio                 TIMESTAMP     NOT NULL,
    prc_dh_fim                    TIMESTAMP,
    prc_dh_ultimo_processamento   TIMESTAMP,
    prc_cd_situacao_processamento VARCHAR2(255) NOT NULL,
    prc_cd_situacao_finalizacao   VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_prc_processamento PRIMARY KEY (prc_id)
);