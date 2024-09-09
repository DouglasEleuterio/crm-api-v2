--liquibase formatted sql
--changeset douglas.ferreira:add-termo

CREATE SEQUENCE sq_termo START WITH 1 INCREMENT BY 1;

CREATE TABLE termo
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)     NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    versao           INTEGER       NOT NULL,
    documento_id     NUMBER(38, 0) NOT NULL,
    procedimento_id  NUMBER(38, 0) NOT NULL,
    CONSTRAINT pk_termo PRIMARY KEY (id)
);

ALTER TABLE termo
    ADD CONSTRAINT FK_DOCUMENTO_IN_TERMO FOREIGN KEY (documento_id) REFERENCES documento (id);

ALTER TABLE termo
    ADD CONSTRAINT FK_PROCEDIMENTO_IN_TERMO FOREIGN KEY (procedimento_id) REFERENCES procedimento (id);