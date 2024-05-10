--liquibase formatted sql
--changeset douglas.ferreira:add-prod

CREATE SEQUENCE sq_prd START WITH 1 INCREMENT BY 1;

CREATE TABLE prd_prod
(
    prd_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    prd_c_prod       VARCHAR2(255),
    prd_cean         VARCHAR2(255),
    prd_x_prod       VARCHAR2(255),
    prd_ncm          VARCHAR2(255),
    prd_cfop         VARCHAR2(255),
    prd_u_com        VARCHAR2(255),
    prd_q_com        VARCHAR2(255),
    prd_v_un_com     VARCHAR2(255),
    prd_v_prod       VARCHAR2(255),
    prd_ceantrib     VARCHAR2(255),
    prd_u_trib       VARCHAR2(255),
    prd_q_trib       VARCHAR2(255),
    prd_v_un_trib    VARCHAR2(255),
    prd_ind_tot      VARCHAR2(255),
    CONSTRAINT pk_prd_prod PRIMARY KEY (prd_id)
);
