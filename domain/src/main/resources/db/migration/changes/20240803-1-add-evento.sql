--liquibase formatted sql
--changeset douglas.ferreira:add-evento

CREATE SEQUENCE sq_evento START WITH 1 INCREMENT BY 1;

CREATE TABLE evento
(
    id                        NUMBER(38, 0) NOT NULL,
    situacao                  NUMBER(1)     NOT NULL,
    data_criacao              TIMESTAMP     NOT NULL,
    data_atualizacao          TIMESTAMP     NOT NULL,
    dia_todo                  NUMBER(1)     NOT NULL,
    titulo                    VARCHAR2(255) NOT NULL,
    inicio                    TIMESTAMP     NOT NULL,
    fim                       TIMESTAMP     NOT NULL,
    cor                       VARCHAR2(255) NOT NULL,
    confirmado                NUMBER(1)     NOT NULL,
    aquisicao_procedimento_id NUMBER(38, 0),
    CONSTRAINT pk_evento PRIMARY KEY (id)
);

ALTER TABLE evento
    ADD CONSTRAINT FK_EVENTO_ON_AQUISICAO_PROCEDIMENTO
        FOREIGN KEY (aquisicao_procedimento_id) REFERENCES aquisicao_procedimento (id);
