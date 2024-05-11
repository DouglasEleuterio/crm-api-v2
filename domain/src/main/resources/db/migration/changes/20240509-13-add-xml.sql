--liquibase formatted sql
--changeset douglas.ferreira:add-xml

CREATE SEQUENCE sq_xml START WITH 1 INCREMENT BY 1;

CREATE TABLE xml_xml
(
    xml_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    xml_versao       VARCHAR2(255),
    nfe_id           NUMBER(38, 0),
    CONSTRAINT pk_xml_xml PRIMARY KEY (xml_id)
);

ALTER TABLE xml_xml
    ADD CONSTRAINT uc_xml_xml_nfe UNIQUE (nfe_id);

ALTER TABLE xml_xml
    ADD CONSTRAINT XML_NFE_XML FOREIGN KEY (nfe_id) REFERENCES nfe_nfe (nfe_id);


--changeset douglas.ferreira:edit-xml-add-arquivo
ALTER TABLE xml_xml ADD ARQ_ID NUMBER(38, 0);
ALTER TABLE xml_xml
    ADD CONSTRAINT XML_ARQ_XML FOREIGN KEY (ARQ_ID) REFERENCES ARQ_ARQUIVO (ARQ_ID);
