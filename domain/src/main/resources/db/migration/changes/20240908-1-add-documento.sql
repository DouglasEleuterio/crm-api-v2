--liquibase formatted sql
--changeset douglas.ferreira:add-documento

CREATE SEQUENCE sq_documento START WITH 1 INCREMENT BY 1;

CREATE TABLE documento
(
    id       NUMBER(38, 0) NOT NULL,
    conteudo CLOB          NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    CONSTRAINT pk_documento PRIMARY KEY (id)
);