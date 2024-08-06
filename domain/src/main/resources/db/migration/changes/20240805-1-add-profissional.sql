--liquibase formatted sql
--changeset douglas.ferreira:add-profissional

CREATE SEQUENCE sq_profissional START WITH 1 INCREMENT BY 1;

CREATE TABLE profissional
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)     NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_profissional PRIMARY KEY (id)
);
--changeset douglas.ferreira:seed-profissional
INSERT INTO profissional VALUES ((sq_profissional.nextval), 1, sysdate, sysdate, 'Dra. Lara Stival');

--changeset douglas.ferreira:edit-regiao
ALTER TABLE regiao add profissional_id NUMBER(38, 0) default 1 NOT NULL;

ALTER TABLE regiao
    ADD CONSTRAINT FK_REGIAO_ON_PROFISSIONAL FOREIGN KEY (profissional_id) REFERENCES profissional (id);

--changeset douglas.ferreira:edit-evento-profissional
ALTER TABLE evento add profissional_id NUMBER(38, 0) default 1 NOT NULL;

ALTER TABLE evento
    ADD CONSTRAINT FK_EVENTO_ON_PROFISSIONAL FOREIGN KEY (profissional_id) REFERENCES profissional (id);

--changeset douglas.ferreira:edit-aquisicao_procedimento-profissional
ALTER TABLE aquisicao_procedimento add profissional_id NUMBER(38, 0) default 1 NOT NULL;

ALTER TABLE aquisicao_procedimento
    ADD CONSTRAINT FK_AQUISICAO_PROCEDIMENTO_ON_PROFISSIONAL FOREIGN KEY (profissional_id) REFERENCES profissional (id);

