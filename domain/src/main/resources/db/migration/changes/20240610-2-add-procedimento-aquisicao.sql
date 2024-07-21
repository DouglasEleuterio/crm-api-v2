--liquibase formatted sql
--changeset douglas.ferreira:add-procedimento-aquisicao

CREATE SEQUENCE sq_procedimento_aquisicao START WITH 1 INCREMENT BY 1;

CREATE TABLE procedimento_aquisicao
(
    id                      NUMBER(38, 0)    NOT NULL,
    nome                    VARCHAR2(255)    NOT NULL,
    regiao                  VARCHAR2(255),
    quantidade_sessoes      INTEGER,
    intervalo_entre_sessoes INTEGER,
    valor                   DOUBLE PRECISION NOT NULL,
    aqs_id                  NUMBER(38, 0)    NOT NULL,
    CONSTRAINT pk_procedimento_aquisicao PRIMARY KEY (id)
);
