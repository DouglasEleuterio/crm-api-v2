--liquibase formatted sql
--changeset douglas.ferreira:add-imposto-icms-00

CREATE SEQUENCE sq_icms00 START WITH 1 INCREMENT BY 1;

CREATE TABLE ic0_icms00
(
    ic0_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ic0_orig         VARCHAR2(255),
    ic0_cst          VARCHAR2(255),
    ic0_modbc        INTEGER,
    ic0_vbc          DOUBLE PRECISION,
    ic0_picms        DOUBLE PRECISION,
    ic0_vicms        DOUBLE PRECISION,
    CONSTRAINT pk_ic0_icms00 PRIMARY KEY (ic0_id)
);
ALTER TABLE icm_icms ADD ic0_id NUMBER(38, 0);

ALTER TABLE icm_icms
    ADD CONSTRAINT FK_IC0_ICM FOREIGN KEY (ic0_id) REFERENCES ic0_icms00 (ic0_id);

