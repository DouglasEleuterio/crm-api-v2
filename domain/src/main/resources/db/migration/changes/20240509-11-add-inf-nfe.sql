--liquibase formatted sql
--changeset douglas.ferreira:add-inf-nfe


CREATE SEQUENCE sq_inf START WITH 1 INCREMENT BY 1;

CREATE TABLE inf_infnfe
(
    inf_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    inf_versao       VARCHAR2(255),
    inf_idnf         VARCHAR2(255),
    ide_id           NUMBER(38, 0),
    emt_id           NUMBER(38, 0),
    dst_id           NUMBER(38, 0),
    tot_id           NUMBER(38, 0),
    ifd_id           NUMBER(38, 0),
    CONSTRAINT pk_inf_infnfe PRIMARY KEY (inf_id)
);


ALTER TABLE inf_infnfe
    ADD CONSTRAINT uc_inf_infnfe_ide UNIQUE (ide_id);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT uc_inf_infnfe_ifd UNIQUE (ifd_id);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT uc_inf_infnfe_tot UNIQUE (tot_id);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT FK_DST_INF FOREIGN KEY (dst_id) REFERENCES dst_dst (dst_id);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT FK_EMT_INF FOREIGN KEY (emt_id) REFERENCES emt_emt (emt_id);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT FK_IDE_INF FOREIGN KEY (ide_id) REFERENCES ide_ide (ide_id);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT FK_IFD_INF FOREIGN KEY (ifd_id) REFERENCES ifd_infadic (ifd_id);

ALTER TABLE inf_infnfe
    ADD CONSTRAINT FK_TOT_INF FOREIGN KEY (tot_id) REFERENCES tot_total (tot_id);

ALTER TABLE det_det
    ADD CONSTRAINT FK_INF_DET FOREIGN KEY (inf_id) REFERENCES inf_infnfe (inf_id);


