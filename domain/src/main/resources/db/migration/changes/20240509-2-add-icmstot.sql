--liquibase formatted sql
--changeset douglas.ferreira:add-icmstot

CREATE SEQUENCE sq_ict START WITH 1 INCREMENT BY 1;

CREATE TABLE ict_icmstot
(
    ict_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    ict_vbc          DOUBLE PRECISION,
    ict_vicms        DOUBLE PRECISION,
    ict_vicmsdeson   DOUBLE PRECISION,
    ict_vfcp         DOUBLE PRECISION,
    ict_vbcst        DOUBLE PRECISION,
    ict_vst          DOUBLE PRECISION,
    ict_vfcpst       DOUBLE PRECISION,
    ict_vfcpstret    DOUBLE PRECISION,
    ict_v_prod       DOUBLE PRECISION,
    ict_v_frete      DOUBLE PRECISION,
    ict_v_seg        DOUBLE PRECISION,
    ict_v_desc       DOUBLE PRECISION,
    ict_vii          DOUBLE PRECISION,
    ict_vipi         DOUBLE PRECISION,
    ict_vipidevol    DOUBLE PRECISION,
    ict_vpis         DOUBLE PRECISION,
    ict_vcofins      DOUBLE PRECISION,
    ict_v_outro      DOUBLE PRECISION,
    ict_vnf          DOUBLE PRECISION,
    CONSTRAINT pk_ict_icmstot PRIMARY KEY (ict_id)
);


ALTER TABLE tot_total
    ADD CONSTRAINT FK_ICT_TOT FOREIGN KEY (ict_id) REFERENCES ict_icmstot (ict_id);