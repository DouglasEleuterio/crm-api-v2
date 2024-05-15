--liquibase formatted sql
--changeset douglas.ferreira:add-imposto-icms

CREATE SEQUENCE sq_icms60 START WITH 1 INCREMENT BY 1;

CREATE TABLE ic6_icms60
(
    ic6_id              NUMBER(38, 0) NOT NULL,
    data_criacao        TIMESTAMP     NOT NULL,
    data_atualizacao    TIMESTAMP     NOT NULL,
    ic6_pst             DOUBLE PRECISION,
    ic6_origg           VARCHAR2(255),
    ic6_cst             VARCHAR2(255),
    ic6_vbcstret        DOUBLE PRECISION,
    ic6_vicmssubstituto DOUBLE PRECISION,
    ic6_vicmsstret      DOUBLE PRECISION,
    CONSTRAINT pk_ic6_icms60 PRIMARY KEY (ic6_id)
);

CREATE SEQUENCE sq_icms START WITH 1 INCREMENT BY 1;

CREATE TABLE icm_icms
(
    icm_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ic6_id           NUMBER(38, 0),
    CONSTRAINT pk_icm_icms PRIMARY KEY (icm_id)
);

ALTER TABLE icm_icms
    ADD CONSTRAINT uc_icm_icms_ic6 UNIQUE (ic6_id);

ALTER TABLE icm_icms
    ADD CONSTRAINT FK_IC6_ICM FOREIGN KEY (ic6_id) REFERENCES ic6_icms60 (ic6_id);

