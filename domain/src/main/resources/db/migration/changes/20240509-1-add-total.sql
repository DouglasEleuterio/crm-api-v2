--liquibase formatted sql
--changeset douglas.ferreira:add-total

CREATE SEQUENCE sq_tot START WITH 1 INCREMENT BY 1;

CREATE TABLE tot_total
(
    tot_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ict_id           NUMBER(38, 0),
    CONSTRAINT pk_tot_total PRIMARY KEY (tot_id)
);

ALTER TABLE tot_total
    ADD CONSTRAINT uc_tot_total_ict UNIQUE (ict_id);
