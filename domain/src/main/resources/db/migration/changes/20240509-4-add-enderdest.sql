--liquibase formatted sql
--changeset douglas.ferreira:add-enderdest

CREATE SEQUENCE sq_end START WITH 1 INCREMENT BY 1;

CREATE TABLE end_dst
(
    end_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    end_x_lgr        VARCHAR2(255),
    end_nro          VARCHAR2(255),
    end_x_cpl        VARCHAR2(255),
    end_x_bairro     VARCHAR2(255),
    end_c_mun        VARCHAR2(255),
    end_x_mun        VARCHAR2(255),
    end_uf           VARCHAR2(255),
    end_cep          VARCHAR2(255),
    end_c_pais       VARCHAR2(255),
    end_x_pais       VARCHAR2(255),
    end_fone         VARCHAR2(255),
    CONSTRAINT pk_end_dst PRIMARY KEY (end_id)
);


