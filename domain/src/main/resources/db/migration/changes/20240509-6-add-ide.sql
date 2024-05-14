--liquibase formatted sql
--changeset douglas.ferreira:add-ide

CREATE SEQUENCE sq_ide START WITH 1 INCREMENT BY 1;

CREATE TABLE ide_ide
(
    ide_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ide_cuf          VARCHAR2(255),
    ide_cnf          VARCHAR2(255),
    ide_nat_op       VARCHAR2(255),
    ide_mod          VARCHAR2(255),
    ide_serie        VARCHAR2(255),
    ide_nnf          NUMBER(38, 0),
    ide_dh_emi       VARCHAR2(255),
    ide_dh_sai_ent   VARCHAR2(255),
    ide_tpnf         VARCHAR2(255),
    ide_id_dest      VARCHAR2(255),
    ide_c_munfg      VARCHAR2(255),
    ide_tp_imp       VARCHAR2(255),
    ide_tp_emis      VARCHAR2(255),
    ide_cdv          VARCHAR2(255),
    ide_tp_amb       VARCHAR2(255),
    ide_finnfe       VARCHAR2(255),
    ide_ind_final    VARCHAR2(255),
    ide_ind_pres     VARCHAR2(255),
    ide_ind_interme  VARCHAR2(255),
    ide_proc_emi     VARCHAR2(255),
    ide_ver_proc     VARCHAR2(255),
    CONSTRAINT pk_ide_ide PRIMARY KEY (ide_id)
);

