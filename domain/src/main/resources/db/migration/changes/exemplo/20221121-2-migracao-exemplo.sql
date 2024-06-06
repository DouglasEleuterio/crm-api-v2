--liquibase formatted sql
--changeset douglas.ferreira:migracao-exemplo-relacao

CREATE TABLE exemplo_relacao
(
    id   NUMBER(38, 0) NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_exemplo_relacao PRIMARY KEY (id)
);

--changeset douglas.ferreira:migracao-exemplo

CREATE TABLE exemplo
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)     NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    descricao        VARCHAR2(255) NOT NULL,
    fk_relacao       NUMBER(38, 0) NOT NULL,
    CONSTRAINT pk_exemplo PRIMARY KEY (id)
);

ALTER TABLE exemplo
    ADD CONSTRAINT FK_EXEMPLO_ON_FK_RELACAO FOREIGN KEY (fk_relacao) REFERENCES exemplo_relacao (id);

CREATE TABLE exemplo_root_filho_one
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)    NOT NULL,
    data_criacao     TIMESTAMP    NOT NULL,
    data_atualizacao TIMESTAMP    NOT NULL,
    descricao        VARCHAR2(36) NOT NULL,
    CONSTRAINT pk_exemplo_root_filho_one PRIMARY KEY (id)
);

CREATE TABLE exemplo_root
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)    NOT NULL,
    data_criacao     TIMESTAMP    NOT NULL,
    data_atualizacao TIMESTAMP    NOT NULL,
    nome             VARCHAR2(36) NOT NULL,
    fk_filho_one     NUMBER(38, 0) NOT NULL,
    CONSTRAINT pk_exemplo_root PRIMARY KEY (id)
);

ALTER TABLE exemplo_root
    ADD CONSTRAINT FK_EXEMPLO_ROOT_ON_FK_FILHO_ONE FOREIGN KEY (fk_filho_one) REFERENCES exemplo_root_filho_one (id);

CREATE TABLE exemplo_root_filho_many
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)    NOT NULL,
    data_criacao     TIMESTAMP    NOT NULL,
    data_atualizacao TIMESTAMP    NOT NULL,
    descricao        VARCHAR2(36) NOT NULL,
    fk_root          NUMBER(38, 0) NOT NULL,
    CONSTRAINT pk_exemplo_root_filho_many PRIMARY KEY (id)
);

ALTER TABLE exemplo_root_filho_many
    ADD CONSTRAINT FK_EXEMPLO_ROOT_FILHO_MANY_ON_FK_ROOT FOREIGN KEY (fk_root) REFERENCES exemplo_root (id);

--changeset douglas.ferreira:sequence-exemplo
CREATE SEQUENCE sq_exemplo START WITH 1 INCREMENT BY 1;

