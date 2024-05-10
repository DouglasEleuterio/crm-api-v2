--liquibase formatted sql
--changeset douglas.ferreira:add-dest

CREATE SEQUENCE sq_dst START WITH 1 INCREMENT BY 1;

CREATE TABLE dst_dst
(
    dst_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    dst_cnpj         VARCHAR2(255),
    dst_x_nome       VARCHAR2(255),
    dst_indiedest    VARCHAR2(255),
    dst_ie           VARCHAR2(255),
    end_id           NUMBER(38, 0),
    CONSTRAINT pk_dst_dst PRIMARY KEY (dst_id)
);

ALTER TABLE dst_dst
    ADD CONSTRAINT FK_END_DST FOREIGN KEY (end_id) REFERENCES end_dst (end_id);
