--liquibase formatted sql
--changeset douglas.ferreira:add-cob

CREATE SEQUENCE sq_cob START WITH 1 INCREMENT BY 1;

CREATE TABLE cob_cobr
(
    cob_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    fat_id           NUMBER(38, 0),
    CONSTRAINT pk_cob_cobr PRIMARY KEY (cob_id)
);

ALTER TABLE cob_cobr
    ADD CONSTRAINT uc_cob_cobr_fat UNIQUE (fat_id);

ALTER TABLE cob_cobr
    ADD CONSTRAINT FK_FAT_COB FOREIGN KEY (fat_id) REFERENCES fat_fat (fat_id);

--changeset douglas.ferreira:edit-tot-fk-tot
ALTER TABLE inf_infnfe
    ADD cob_id           NUMBER(38, 0);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT FK_COB_INF FOREIGN KEY (cob_id) REFERENCES cob_cobr (cob_id);

