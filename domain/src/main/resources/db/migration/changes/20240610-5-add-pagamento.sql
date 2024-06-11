--liquibase formatted sql
--changeset douglas.ferreira:add-pagamento

CREATE SEQUENCE sq_pagamento START WITH 1 INCREMENT BY 1;

CREATE TABLE pagamento
(
    id                  NUMBER(38, 0) NOT NULL,
    situacao            NUMBER(1)     NOT NULL,
    data_criacao        TIMESTAMP     NOT NULL,
    data_atualizacao    TIMESTAMP     NOT NULL,
    data_pagamento      TIMESTAMP     NOT NULL,
    valor_taxa          FLOAT(24)     NOT NULL,
    forma_pagamento     VARCHAR2(255),
    quantidade_parcelas INTEGER       NOT NULL,
    taxa                FLOAT(24)     NOT NULL,
    aquisicao_id        NUMBER(38, 0),
    CONSTRAINT pk_pagamento PRIMARY KEY (id)
);

ALTER TABLE pagamento
    ADD CONSTRAINT FK_PAGAMENTO_ON_AQUISICAO FOREIGN KEY (aquisicao_id) REFERENCES aquisicao (id);
ALTER TABLE parcela_pagamento
    ADD CONSTRAINT FK_PARCELA_PAGAMENTO_ON_PAGAMENTO FOREIGN KEY (pagamento_id) REFERENCES pagamento (id);
