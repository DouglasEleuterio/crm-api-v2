--liquibase formatted sql
--changeset douglas.ferreira:add-imposto-ipi

CREATE SEQUENCE sq_ipitrib START WITH 1 INCREMENT BY 1;

CREATE TABLE ipt_ipitrib
(
    ipt_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ipt_cst          VARCHAR2(255),
    ipt_q_unid       INTEGER,
    ipt_vipi         DOUBLE PRECISION,
    ipt_v_unid       DOUBLE PRECISION,
    CONSTRAINT pk_ipt_ipitrib PRIMARY KEY (ipt_id)
);

CREATE SEQUENCE sq_ipi START WITH 1 INCREMENT BY 1;

CREATE TABLE ipi_ipi
(
    ipi_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ic6_c_enq        VARCHAR2(255),
    ipt_id           NUMBER(38, 0),
    CONSTRAINT pk_ipi_ipi PRIMARY KEY (ipi_id)
);

ALTER TABLE ipi_ipi
    ADD CONSTRAINT uc_ipi_ipi_ipt UNIQUE (ipt_id);

ALTER TABLE ipi_ipi
    ADD CONSTRAINT FK_IPT_IPI FOREIGN KEY (ipt_id) REFERENCES ipt_ipitrib (ipt_id);

