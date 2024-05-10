--liquibase formatted sql
--changeset douglas.ferreira:add-icmstot

CREATE SEQUENCE sq_ict START WITH 1 INCREMENT BY 1;

CREATE TABLE ict_icmstot
(
    ict_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ict_vbc          VARCHAR2(255),
    ict_vicms        VARCHAR2(255),
    ict_vicmsdeson   VARCHAR2(255),
    ict_vfcp         VARCHAR2(255),
    ict_vbcst        VARCHAR2(255),
    ict_vst          VARCHAR2(255),
    ict_vfcpst       VARCHAR2(255),
    ict_vfcpstret    VARCHAR2(255),
    ict_v_prod       VARCHAR2(255),
    ict_v_frete      VARCHAR2(255),
    ict_v_seg        VARCHAR2(255),
    ict_v_desc       VARCHAR2(255),
    ict_vii          VARCHAR2(255),
    ict_vipi         VARCHAR2(255),
    ict_vipidevol    VARCHAR2(255),
    ict_vpis         VARCHAR2(255),
    ict_vcofins      VARCHAR2(255),
    ict_v_outro      VARCHAR2(255),
    ict_vnf          VARCHAR2(255),
    CONSTRAINT pk_ict_icmstot PRIMARY KEY (ict_id)
);


ALTER TABLE tot_total
    ADD CONSTRAINT FK_ICT_TOT FOREIGN KEY (ict_id) REFERENCES ict_icmstot (ict_id);