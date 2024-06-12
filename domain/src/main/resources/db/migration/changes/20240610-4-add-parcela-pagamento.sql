--liquibase formatted sql
--changeset douglas.ferreira:add-parcela-pagamento

CREATE SEQUENCE sq_parcela_pagamento START WITH 1 INCREMENT BY 1;

CREATE TABLE parcela_pagamento
(
    id               NUMBER(38, 0) NOT NULL,
    data_credito     date          NOT NULL,
    valor_credito    FLOAT(24)     NOT NULL,
    valor_taxa       FLOAT(24)     NOT NULL,
    recebido         NUMBER(1)     NOT NULL,
    numero_parcela   INTEGER       NOT NULL,
    pagamento_id     NUMBER(38, 0),
    data_atualizacao TIMESTAMP     NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    dataCriacao      TIMESTAMP     NOT NULL,
    situacao         NUMBER(1)     NOT NULL,
    CONSTRAINT pk_parcela_pagamento PRIMARY KEY (id)
);

