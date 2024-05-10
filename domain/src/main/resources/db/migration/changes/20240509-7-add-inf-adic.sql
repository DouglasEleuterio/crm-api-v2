--liquibase formatted sql
--changeset douglas.ferreira:add-inf-adic

CREATE SEQUENCE sq_ifd START WITH 1 INCREMENT BY 1;

CREATE TABLE ifd_infadic
(
    ifd_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ifd_inf_cpl      VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_ifd_infadic PRIMARY KEY (ifd_id)
);

--changeset douglas.ferreira:edit-inf-adic-ifd_inf_cpl-length
ALTER TABLE ifd_infadic MODIFY (ifd_inf_cpl VARCHAR2(2000) )


