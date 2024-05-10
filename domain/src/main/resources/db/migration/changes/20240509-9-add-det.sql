--liquibase formatted sql
--changeset douglas.ferreira:add-det

CREATE SEQUENCE sq_det START WITH 1 INCREMENT BY 1;

CREATE TABLE det_det
(
    det_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    inf_id           NUMBER(38, 0),
    prd_id           NUMBER(38, 0),
    CONSTRAINT pk_det_det PRIMARY KEY (det_id)
);

ALTER TABLE det_det
    ADD CONSTRAINT uc_det_det_prd UNIQUE (prd_id);


ALTER TABLE det_det
    ADD CONSTRAINT FK_PRD_DET FOREIGN KEY (prd_id) REFERENCES prd_prod (prd_id);


