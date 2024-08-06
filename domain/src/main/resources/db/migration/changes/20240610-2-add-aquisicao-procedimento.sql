--liquibase formatted sql
--changeset douglas.ferreira:add-aquisicao-procedimento

CREATE SEQUENCE sq_aquisicao_procedimento START WITH 1 INCREMENT BY 1;

CREATE TABLE aquisicao_procedimento
(
    id                      NUMBER(38, 0)    NOT NULL,
    nome                    VARCHAR2(255)    NOT NULL,
    procedimento_origem_id  NUMBER(38, 0),
    intervalo_entre_sessoes INTEGER,
    quantidade_sessoes      INTEGER,
    valor                   DOUBLE PRECISION NOT NULL,
    aquisicao_id            NUMBER(38, 0)    NOT NULL,
    CONSTRAINT pk_aquisicao_procedimento PRIMARY KEY (id)
);
--changeset douglas.ferreira:add-aquisicao-procedimento-nome-procedimento
ALTER TABLE aquisicao_procedimento add procedimento VARCHAR2(255);
--changeset douglas.ferreira:edit-aquisicao-procedimento-origem-regiao
ALTER TABLE aquisicao_procedimento rename COLUMN procedimento_origem_id to regiao_origem_id

