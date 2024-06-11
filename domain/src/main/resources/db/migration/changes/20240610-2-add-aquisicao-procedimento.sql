--liquibase formatted sql
--changeset douglas.ferreira:add-aquisicao-procedimento

CREATE SEQUENCE sq_aquisicao_procedimento START WITH 1 INCREMENT BY 1;

CREATE TABLE aquisicao_procedimento
(
    id                      NUMBER(38, 0) NOT NULL,
    nome                    VARCHAR2(255) NOT NULL,
    valor                   FLOAT(24)     NOT NULL,
    quantidade_sessoes      INTEGER,
    intervalo_entre_sessoes INTEGER,
    CONSTRAINT pk_aquisicao_procedimento PRIMARY KEY (id)
);