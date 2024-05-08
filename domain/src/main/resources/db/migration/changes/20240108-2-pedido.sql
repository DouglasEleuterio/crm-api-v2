--liquibase formatted sql
--changeset douglas.ferreira:pedido

CREATE SEQUENCE sq_pedido START WITH 1 INCREMENT BY 1;

CREATE TABLE pedido
(
    id               NUMBER(38, 0)    NOT NULL,
    situacao         NUMBER(1)        NOT NULL,
    data_criacao     TIMESTAMP        NOT NULL,
    data_atualizacao TIMESTAMP        NOT NULL,
    cliente_id       NUMBER(38, 0),
    valor_total      DOUBLE PRECISION NOT NULL,
    desconto         DOUBLE PRECISION NOT NULL,
    valor_total_itens      DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_pedido PRIMARY KEY (id)
);

ALTER TABLE pedido
    ADD CONSTRAINT FK_PEDIDO_ON_CLIENTE FOREIGN KEY (cliente_id) REFERENCES cliente (id);