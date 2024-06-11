--liquibase formatted sql
--changeset douglas.ferreira:add-procedimento

CREATE SEQUENCE sq_procedimento START WITH 1 INCREMENT BY 1;

CREATE TABLE procedimento
(
    id                      NUMBER(38, 0) NOT NULL,
    situacao                NUMBER(1)     NOT NULL,
    data_criacao            TIMESTAMP     NOT NULL,
    data_atualizacao        TIMESTAMP     NOT NULL,
    nome                    VARCHAR2(255) NOT NULL,
    valor                   FLOAT(24)     NOT NULL,
    quantidade_sessoes      INTEGER,
    intervalo_entre_sessoes INTEGER,
    CONSTRAINT pk_procedimento PRIMARY KEY (id)
);