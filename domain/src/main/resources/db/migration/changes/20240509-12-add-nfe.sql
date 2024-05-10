--liquibase formatted sql
--changeset douglas.ferreira:add-nfe

CREATE SEQUENCE sq_nfe START WITH 1 INCREMENT BY 1;

CREATE TABLE nfe_nfe
(
    nfe_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    inf_id           NUMBER(38, 0),
    CONSTRAINT pk_nfe_nfe PRIMARY KEY (nfe_id)
);

ALTER TABLE nfe_nfe
    ADD CONSTRAINT uc_nfe_nfe_inf UNIQUE (inf_id);

ALTER TABLE nfe_nfe
    ADD CONSTRAINT FK_INFNFE_NFE FOREIGN KEY (inf_id) REFERENCES inf_infnfe (inf_id);


