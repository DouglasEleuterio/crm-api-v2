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
    prc_cd_situacao_finalizacao   VARCHAR2(255) ,
    CONSTRAINT pk_prc_processamento PRIMARY KEY (prc_id)
);
--changeset douglas.ferreira:edit-add-origem
ALTER TABLE prc_processamento add PRC_CD_ORIGEM_PROCESSAMENTO   VARCHAR2(255) NOT NULL;
--changeset douglas.ferreira:edit-add-quantidade
ALTER TABLE prc_processamento add  NU_QUANTIDADE_PROCESSADA  NUMBER(38, 0) ;
--changeset douglas.ferreira:edit-add-quantidade-a-processar
ALTER TABLE prc_processamento add  NU_QUANTIDADE_PARA_PROCESSAR  NUMBER(38, 0) NOT NULL;
--changeset douglas.ferreira:edit-add-quantidade-erro
ALTER TABLE prc_processamento add  NU_QUANTIDADE_ERRO  NUMBER(38, 0) ;