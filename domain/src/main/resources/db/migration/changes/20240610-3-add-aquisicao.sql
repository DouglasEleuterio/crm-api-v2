--liquibase formatted sql
--changeset douglas.ferreira:add-aquisicao

CREATE SEQUENCE sq_aquisicao START WITH 1 INCREMENT BY 1;

CREATE TABLE aquisicao
(
    id                        NUMBER(38, 0) NOT NULL,
    situacao                  NUMBER(1)     NOT NULL,
    data_criacao              TIMESTAMP     NOT NULL,
    data_atualizacao          TIMESTAMP     NOT NULL,
    data_aquisicao            TIMESTAMP     NOT NULL,
    valor_aquisicao           FLOAT(24)     NOT NULL,
    valor_desconto            FLOAT(24)     NOT NULL,
    cliente_id                NUMBER(38, 0),
    aquisicao_procedimento_id NUMBER(38, 0),
    CONSTRAINT pk_aquisicao PRIMARY KEY (id)
);

ALTER TABLE aquisicao
    ADD CONSTRAINT FK_AQUISICAO_ON_AQUISICAO_PROCEDIMENTO FOREIGN KEY (aquisicao_procedimento_id) REFERENCES aquisicao_procedimento (id);

ALTER TABLE aquisicao
    ADD CONSTRAINT FK_AQUISICAO_ON_CLIENTE FOREIGN KEY (cliente_id) REFERENCES cliente (id);