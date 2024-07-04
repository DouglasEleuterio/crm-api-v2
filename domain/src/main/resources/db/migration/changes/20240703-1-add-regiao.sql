--liquibase formatted sql
--changeset douglas.ferreira:add-regiao

CREATE SEQUENCE sq_regiao START WITH 1 INCREMENT BY 1;

CREATE TABLE regiao
(
    id                      NUMBER(38, 0)    NOT NULL,
    nome                    VARCHAR2(255)    NOT NULL,
    quantidade_sessoes      INTEGER,
    intervalo_entre_sessoes INTEGER,
    valor                   DOUBLE PRECISION NOT NULL,
    procedimento_id         NUMBER(38, 0),
    CONSTRAINT pk_regiao PRIMARY KEY (id)
);

ALTER TABLE regiao
    ADD CONSTRAINT FK_REGIAO_ON_PROCEDIMENTO FOREIGN KEY (procedimento_id) REFERENCES procedimento (id);