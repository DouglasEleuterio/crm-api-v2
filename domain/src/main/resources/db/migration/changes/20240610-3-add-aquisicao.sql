--liquibase formatted sql
--changeset douglas.ferreira:add-aquisicao

CREATE SEQUENCE sq_aquisicao START WITH 1 INCREMENT BY 1;

CREATE TABLE aquisicao
(
    id               NUMBER(38, 0)    NOT NULL,
    situacao         NUMBER(1)        NOT NULL,
    data_criacao     TIMESTAMP        NOT NULL,
    data_atualizacao TIMESTAMP        NOT NULL,
    data_aquisicao   date             NOT NULL,
    valor_aquisicao  DOUBLE PRECISION NOT NULL,
    valor_desconto   DOUBLE PRECISION NOT NULL,
    cliente_id       NUMBER(38, 0),
    CONSTRAINT pk_aquisicao PRIMARY KEY (id)
);

ALTER TABLE aquisicao
    ADD CONSTRAINT uc_aquisicao_cliente UNIQUE (cliente_id);

ALTER TABLE aquisicao
    ADD CONSTRAINT FK_AQUISICAO_ON_CLIENTE FOREIGN KEY (cliente_id) REFERENCES cliente (id);

ALTER TABLE aquisicao_procedimento
    ADD CONSTRAINT FK_AQUISICAO_PROCEDIMENTO_ON_AQUISICAO FOREIGN KEY (aquisicao_id) REFERENCES aquisicao (id);
--changeset douglas.ferreira:edit-aquisicao-cliente-remove-uc
ALTER TABLE aquisicao
    DROP CONSTRAINT uc_aquisicao_cliente;
