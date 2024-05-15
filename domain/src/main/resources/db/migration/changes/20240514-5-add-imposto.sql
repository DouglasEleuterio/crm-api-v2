--liquibase formatted sql
--changeset douglas.ferreira:add-imposto

CREATE SEQUENCE sq_imposto START WITH 1 INCREMENT BY 1;

CREATE TABLE imp_imposto
(
    imp_id           NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    icm_id           NUMBER(38, 0),
    ipi_id           NUMBER(38, 0),
    cof_id           NUMBER(38, 0),
    pis_id           NUMBER(38, 0),
    CONSTRAINT pk_imp_imposto PRIMARY KEY (imp_id)
);

ALTER TABLE imp_imposto
    ADD CONSTRAINT uc_imp_imposto_cof UNIQUE (cof_id);

ALTER TABLE imp_imposto
    ADD CONSTRAINT uc_imp_imposto_icm UNIQUE (icm_id);

ALTER TABLE imp_imposto
    ADD CONSTRAINT uc_imp_imposto_ipi UNIQUE (ipi_id);

ALTER TABLE imp_imposto
    ADD CONSTRAINT uc_imp_imposto_pis UNIQUE (pis_id);

ALTER TABLE imp_imposto
    ADD CONSTRAINT FK_COF_IMP FOREIGN KEY (cof_id) REFERENCES cof_cofins (cofins_id);

ALTER TABLE imp_imposto
    ADD CONSTRAINT FK_ICM_IMP FOREIGN KEY (icm_id) REFERENCES icm_icms (icm_id);

ALTER TABLE imp_imposto
    ADD CONSTRAINT FK_IPI_IMP FOREIGN KEY (ipi_id) REFERENCES ipi_ipi (ipi_id);

ALTER TABLE imp_imposto
    ADD CONSTRAINT FK_PIS_IMP FOREIGN KEY (pis_id) REFERENCES pis_pis (pis_id);
--changeset douglas.ferreira:add-det-imposto-fk
ALTER TABLE det_det
    ADD CONSTRAINT FK_IMP_DET FOREIGN KEY (imp_id) REFERENCES imp_imposto (imp_id);