--liquibase formatted sql
--changeset douglas.ferreira:add-cliente

CREATE SEQUENCE sq_cliente START WITH 1 INCREMENT BY 1;

CREATE TABLE cliente
(
    id               NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    cpf              VARCHAR2(255) NOT NULL,
    email            VARCHAR2(255) NOT NULL,
    telefone         VARCHAR2(255) NOT NULL,
    endereco_id      NUMBER(38, 0) NOT NULL,
    data_nascimento  date          NOT NULL,
    situacao         NUMBER(1)     NOT NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (id)
);

ALTER TABLE cliente
    ADD CONSTRAINT uc_cliente_cpf UNIQUE (cpf);

ALTER TABLE cliente
    ADD CONSTRAINT uc_cliente_email UNIQUE (email);

ALTER TABLE cliente
    ADD CONSTRAINT uc_cliente_endereco UNIQUE (endereco_id);

ALTER TABLE cliente
    ADD CONSTRAINT uc_cliente_telefone UNIQUE (telefone);

ALTER TABLE cliente
    ADD CONSTRAINT FK_CLIENTE_ON_ENDERECO FOREIGN KEY (endereco_id) REFERENCES endereco (id);