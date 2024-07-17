--liquibase formatted sql
--changeset douglas.ferreira:add-regiao_procedimento_aquisicao

CREATE SEQUENCE SQ_REGIAO_PROCEDIMENTO_AQUISICAO START WITH 1 INCREMENT BY 1;

CREATE TABLE regiao_procedimento_aquisicao
(
    id                      NUMBER(38, 0)    NOT NULL,
    nome                    VARCHAR2(255)    NOT NULL,
    quantidade_sessoes      INTEGER,
    intervalo_entre_sessoes INTEGER,
    valor                   DOUBLE PRECISION NOT NULL,
    aquisicao_procedimento  NUMBER(38, 0),
    CONSTRAINT pk_regiao_procedimento_aquisicao PRIMARY KEY (id)
);

ALTER TABLE regiao_procedimento_aquisicao
    ADD CONSTRAINT FK_REGIAO_PROCEDIMENTO_AQUISICAO_ON_AQUISICAO_PROCEDIMENTO FOREIGN KEY (aquisicao_procedimento) REFERENCES aquisicao_procedimento (id);