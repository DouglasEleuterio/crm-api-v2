--liquibase formatted sql
--changeset douglas.ferreira:add-imposto-cofins

CREATE SEQUENCE sq_cofinsaliq START WITH 1 INCREMENT BY 1;

CREATE TABLE cfa_cofinsaliq
(
    cfa_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    cfa_vcofins      DOUBLE PRECISION,
    cfa_cst          VARCHAR2(255),
    cfa_vbc          DOUBLE PRECISION,
    cfa_pcofins      DOUBLE PRECISION,
    CONSTRAINT pk_cfa_cofinsaliq PRIMARY KEY (cfa_id)
);

CREATE SEQUENCE sq_cofins START WITH 1 INCREMENT BY 1;

CREATE TABLE cof_cofins
(
    cofins_id        NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    cfa_id           NUMBER(38, 0),
    CONSTRAINT pk_cof_cofins PRIMARY KEY (cofins_id)
);

ALTER TABLE cof_cofins
    ADD CONSTRAINT uc_cof_cofins_cfa UNIQUE (cfa_id);

ALTER TABLE cof_cofins
    ADD CONSTRAINT FK_CFA_COF FOREIGN KEY (cfa_id) REFERENCES cfa_cofinsaliq (cfa_id);