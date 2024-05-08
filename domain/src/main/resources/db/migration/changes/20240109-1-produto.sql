--liquibase formatted sql
--changeset douglas.ferreira:produto

CREATE SEQUENCE sq_produto START WITH 1 INCREMENT BY 1;

CREATE TABLE produto
(
    id               NUMBER(38, 0)    NOT NULL,
    situacao         NUMBER(1)        NOT NULL,
    data_criacao     TIMESTAMP        NOT NULL,
    data_atualizacao TIMESTAMP        NOT NULL,
    nome             VARCHAR2(255)    NOT NULL,
    preco            DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_produto PRIMARY KEY (id)
);