--liquibase formatted sql
--changeset douglas.ferreira:add-imposto-pis

CREATE SEQUENCE sq_pisaliq START WITH 1 INCREMENT BY 1;

CREATE TABLE pia_pisaliq
(
    pia_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    pia_vpis         DOUBLE PRECISION,
    pia_cst          VARCHAR2(255),
    pia_vbc          DOUBLE PRECISION,
    pia_ppis         DOUBLE PRECISION,
    CONSTRAINT pk_pia_pisaliq PRIMARY KEY (pia_id)
);

CREATE SEQUENCE sq_pis START WITH 1 INCREMENT BY 1;

CREATE TABLE pis_pis
(
    pis_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    pia_id           NUMBER(38, 0),
    CONSTRAINT pk_pis_pis PRIMARY KEY (pis_id)
);

ALTER TABLE pis_pis
    ADD CONSTRAINT uc_pis_pis_pia UNIQUE (pia_id);

ALTER TABLE pis_pis
    ADD CONSTRAINT FK_PIA_PIS FOREIGN KEY (pia_id) REFERENCES pia_pisaliq (pia_id);
