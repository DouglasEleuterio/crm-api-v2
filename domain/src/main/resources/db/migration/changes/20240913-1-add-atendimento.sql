--liquibase formatted sql
--changeset douglas.ferreira:add-atendimento

CREATE SEQUENCE sq_atendimento START WITH 1 INCREMENT BY 1;

CREATE TABLE atendimento
(
    id               NUMBER(38, 0) NOT NULL,
    situacao         NUMBER(1)     NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    data             TIMESTAMP     NOT NULL,
    arquivo_id       NUMBER(38, 0),
    agendamento_id   NUMBER(38, 0),
    CONSTRAINT pk_atendimento PRIMARY KEY (id)
);

ALTER TABLE atendimento
    ADD CONSTRAINT uc_atendimento_arquivo UNIQUE (arquivo_id);

ALTER TABLE atendimento
    ADD CONSTRAINT AGENDAMENTO_ON_ATENDIMENTO FOREIGN KEY (agendamento_id) REFERENCES agendamento (id);

ALTER TABLE atendimento
    ADD CONSTRAINT ARQUIVO_ON_ATENDIMENTO FOREIGN KEY (arquivo_id) REFERENCES arq_arquivo (arq_id);