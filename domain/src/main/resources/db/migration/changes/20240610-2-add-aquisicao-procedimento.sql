--liquibase formatted sql
--changeset douglas.ferreira:add-aquisicao-procedimento

CREATE SEQUENCE sq_aquisicao_procedimento START WITH 1 INCREMENT BY 1;

CREATE TABLE aquisicao_procedimento
(
    id                      NUMBER(38, 0)    NOT NULL,
    data_criacao            TIMESTAMP        NOT NULL,
    data_atualizacao        TIMESTAMP        NOT NULL,
    nome                    VARCHAR2(255)    NOT NULL,
    valor                   DOUBLE PRECISION NOT NULL,
    quantidade_sessoes      INTEGER,
    intervalo_entre_sessoes INTEGER,
    procedimento_origem_id  NUMBER(38, 0),
    aquisicao_id            NUMBER(38, 0)    NOT NULL,
    CONSTRAINT pk_aquisicao_procedimento PRIMARY KEY (id)
);
