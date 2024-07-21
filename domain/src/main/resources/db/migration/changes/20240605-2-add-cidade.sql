--liquibase formatted sql
--changeset douglas.ferreira:add-cidade

CREATE SEQUENCE sq_cidade START WITH 1 INCREMENT BY 1;

CREATE TABLE cidade
(
    id               NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    estado_id        NUMBER(38, 0),
    codigo_ibge      VARCHAR2(255),
    CONSTRAINT pk_cidade PRIMARY KEY (id)
);

ALTER TABLE cidade
    ADD CONSTRAINT FK_CIDADE_ON_ESTADO FOREIGN KEY (estado_id) REFERENCES estado (id);

