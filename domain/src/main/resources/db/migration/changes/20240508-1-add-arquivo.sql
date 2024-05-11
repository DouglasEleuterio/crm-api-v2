--liquibase formatted sql
--changeset douglas.ferreira:add-arquivo

CREATE TABLE arq_arquivo
(
    arq_id               NUMBER(38, 0)  NOT NULL,
    data_criacao         TIMESTAMP      NOT NULL,
    data_atualizacao     TIMESTAMP      NOT NULL,
    arq_nm_nome          VARCHAR2(1000) NOT NULL,
    arq_an_caminho       VARCHAR2(1000) NOT NULL,
    arq_an_tipo_conteudo VARCHAR2(255)  NOT NULL,
    arq_nu_tamanho       NUMBER(38, 0)  NOT NULL,
    arq_an_pasta         VARCHAR2(255)  NOT NULL,
    arq_cd_usuario       VARCHAR2(255),
    arq_nm_usuario       VARCHAR2(255),
    arq_dh_criacao       TIMESTAMP,
    arq_cd_situacao      VARCHAR2(20)   NOT NULL,
    CONSTRAINT pk_arq_arquivo PRIMARY KEY (arq_id)
);
--changeset douglas.ferreira:add-sequence-arquivo
CREATE SEQUENCE SQ_ARQUIVO START WITH 1 INCREMENT BY 1;

--changeset douglas.ferreira:edit-remove-data-criacao-duplicado
ALTER TABLE ARQ_ARQUIVO drop column arq_dh_criacao;
ALTER TABLE ARQ_ARQUIVO drop column data_atualizacao;
--changeset douglas.ferreira:edit-add-data-criacao-duplicado
ALTER TABLE ARQ_ARQUIVO add data_atualizacao TIMESTAMP NOT NULL;
--changeset douglas.ferreira:edit-arquivo-add-mensagem-erro
ALTER TABLE ARQ_ARQUIVO add ARQ_DS_ERRO varchar2(2000);