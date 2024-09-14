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
    documento_id     NUMBER(38, 0),
    agendamento_id   NUMBER(38, 0),
    CONSTRAINT pk_atendimento PRIMARY KEY (id)
);

CREATE TABLE profissional_atendimento
(
    atendimento_id  NUMBER(38, 0) NOT NULL,
    profissional_id NUMBER(38, 0) NOT NULL
);

ALTER TABLE atendimento
    ADD CONSTRAINT uc_atendimento_documento UNIQUE (documento_id);

ALTER TABLE atendimento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_ATENDIMENTO FOREIGN KEY (agendamento_id) REFERENCES agendamento (id);

ALTER TABLE atendimento
    ADD CONSTRAINT FK_ARQUIVO_ON_ATENDIMENTO FOREIGN KEY (documento_id) REFERENCES documento (id);

ALTER TABLE profissional_atendimento
    ADD CONSTRAINT fk_atendimento_on_profissional_atendimento FOREIGN KEY (atendimento_id) REFERENCES atendimento (id);

ALTER TABLE profissional_atendimento
    ADD CONSTRAINT fk_atendimento_on_profissional_atendimentowYc7HX FOREIGN KEY (profissional_id) REFERENCES profissional (id);