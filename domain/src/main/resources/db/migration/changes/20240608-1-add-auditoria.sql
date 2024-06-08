--liquibase formatted sql
--changeset douglas.ferreira:add-historico
CREATE SEQUENCE sq_historico START WITH 1 INCREMENT BY 1;

CREATE TABLE historico
(
    id                   NUMBER(38, 0) NOT NULL,
    data_criacao         TIMESTAMP     NOT NULL,
    data_atualizacao     TIMESTAMP     NOT NULL,
    tipo_evento          VARCHAR2(255),
    data_ocorrencia      TIMESTAMP     NOT NULL,
    usuario_id           VARCHAR2(255) NOT NULL,
    usuario_nome         VARCHAR2(255) NOT NULL,
    entidade_geradora_id NUMBER(38, 0),
    tipo_entidade        VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_historico PRIMARY KEY (id)
);


--changeset douglas.ferreira:add-auditoria
CREATE SEQUENCE sq_auditoria START WITH 1 INCREMENT BY 1;

CREATE TABLE auditoria
(
    id                NUMBER(38, 0)   NOT NULL,
    data_criacao      TIMESTAMP       NOT NULL,
    data_atualizacao  TIMESTAMP       NOT NULL,
    situacao_registro VARCHAR2(255)   NOT NULL,
    dado              VARCHAR2(2000) NOT NULL,
    historico_id      NUMBER(38, 0)   NOT NULL,
    CONSTRAINT pk_auditoria PRIMARY KEY (id)
);

ALTER TABLE auditoria
    ADD CONSTRAINT uc_auditoria_historico UNIQUE (historico_id);

ALTER TABLE auditoria
    ADD CONSTRAINT FK_AUDITORIA_ON_HISTORICO FOREIGN KEY (historico_id) REFERENCES historico (id);