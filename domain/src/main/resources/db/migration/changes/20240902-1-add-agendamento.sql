--liquibase formatted sql
--changeset douglas.ferreira:add-agendamento

CREATE SEQUENCE SQ_AGENDAMENTO START WITH 1 INCREMENT BY 1;

CREATE TABLE agendamento
(
    id                        NUMBER(38, 0) NOT NULL,
    situacao                  NUMBER(1)     NOT NULL,
    data_criacao              TIMESTAMP     NOT NULL,
    data_atualizacao          TIMESTAMP     NOT NULL,
    dia_todo                  NUMBER(1)     NOT NULL,
    titulo                    VARCHAR2(255) NOT NULL,
    inicio                    TIMESTAMP     NOT NULL,
    fim                       TIMESTAMP     NOT NULL,
    cor                       VARCHAR2(255) NOT NULL,
    confirmado                NUMBER(1)     NOT NULL,
    aquisicao_procedimento_id NUMBER(38, 0),
    CONSTRAINT pk_agendamento PRIMARY KEY (id)
);

ALTER TABLE agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_AQUISICAO_PROCEDIMENTO
        FOREIGN KEY (aquisicao_procedimento_id) REFERENCES aquisicao_procedimento (id);
--changeset douglas.ferreira:edit-agendamento-profissional
ALTER TABLE agendamento add profissional_id NUMBER(38, 0) default 1 NOT NULL;

ALTER TABLE agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_PROFISSIONAL FOREIGN KEY (profissional_id) REFERENCES profissional (id);
--changeset douglas.ferreira:edit-agendamento-add-execucao
ALTER TABLE agendamento add executado NUMBER(1) default 0 NOT NULL;
