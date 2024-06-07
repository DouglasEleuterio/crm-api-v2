--liquibase formatted sql
--changeset douglas.ferreira:add-estado

CREATE SEQUENCE sq_estado START WITH 1 INCREMENT BY 1;

CREATE TABLE estado
(
    id               NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    codigo_ibge      VARCHAR2(255),
    uf               VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_estado PRIMARY KEY (id)
);

--changeset douglas.ferreira:seed-estado
INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acre', '12','AC');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alagoas', '27','AL');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amapá', '16','AP');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amazonas', '13','AM');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bahia', '29','BA');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ceará', '23','CE');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Distrito Federal', '53','DF');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Espírito Santo', '32','ES');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goiás', '52','GO');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maranhão', '21','MA');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mato Grosso', '51','MT');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mato Grosso do Sul', '50','MS');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Minas Gerais', '31','MG');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pará', '15','PA');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paraíba', '25','PB');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paraná', '41','PR');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pernambuco', '26','PE');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piauí', '22','PI');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Grande do Norte', '24','RN');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Grande do Sul', '43','RS');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio de Janeiro', '33','RJ');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rondônia', '11','RO');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Roraima', '14','RR');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Catarina', '42','SC');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Paulo', '35','SP');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sergipe', '28','SE');

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tocantins', '17','TO');