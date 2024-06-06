--liquibase formatted sql
--changeset douglas.ferreira:add-endereco

CREATE SEQUENCE sq_endereco START WITH 1 INCREMENT BY 1;

CREATE TABLE endereco
(
    id               NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    logradouro       VARCHAR2(255) NOT NULL,
    numero           VARCHAR2(255) NOT NULL,
    complemento      VARCHAR2(255) NOT NULL,
    bairro           VARCHAR2(255) NOT NULL,
    cidade_id        NUMBER(38, 0) NOT NULL,
    cep              VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_endereco PRIMARY KEY (id)
);

ALTER TABLE endereco
    ADD CONSTRAINT FK_ENDERECO_ON_CIDADE FOREIGN KEY (cidade_id) REFERENCES cidade (id);

