--liquibase formatted sql
--changeset douglas.ferreira:add-imposto-ipi-ipint

CREATE SEQUENCE sq_ipint START WITH 1 INCREMENT BY 1;

CREATE TABLE ipn_ipint
(
    ipn_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ipn_cst          VARCHAR2(255),
    CONSTRAINT pk_ipn_ipint PRIMARY KEY (ipn_id)
);
ALTER TABLE ipi_ipi ADD ipn_id NUMBER(38, 0);

ALTER TABLE ipi_ipi
    ADD CONSTRAINT FK_IPN_IPI FOREIGN KEY (ipn_id) REFERENCES ipn_ipint (ipn_id);


