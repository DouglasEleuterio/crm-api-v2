--liquibase formatted sql
--changeset douglas.ferreira:item-de-venda

CREATE SEQUENCE sq_item_pedido START WITH 1 INCREMENT BY 1;

CREATE TABLE item_de_pedido
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)     NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    quantidade       NUMBER(38, 0),
    valor_unitario   DOUBLE PRECISION,
    pedido_id        NUMBER(38, 0),
    produto_id       NUMBER(38, 0),
    CONSTRAINT pk_item_de_pedido PRIMARY KEY (id)
);

ALTER TABLE item_de_pedido
    ADD CONSTRAINT FK_ITEM_DE_PEDIDO_ON_PEDIDO FOREIGN KEY (pedido_id) REFERENCES pedido (id);

ALTER TABLE item_de_pedido
    ADD CONSTRAINT FK_ITEM_DE_PEDIDO_ON_PRODUTO FOREIGN KEY (produto_id) REFERENCES produto (id);