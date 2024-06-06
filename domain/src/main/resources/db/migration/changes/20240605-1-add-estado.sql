--liquibase formatted sql
--changeset douglas.ferreira:add-estado

CREATE SEQUENCE sq_estado START WITH 1 INCREMENT BY 1;

CREATE TABLE estado
(
    id               NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    codigo_ibge      VARCHAR2(255),
    uf               VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_estado PRIMARY KEY (id)
);

