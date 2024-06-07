--liquibase formatted sql
--changeset douglas.ferreira:add-cidade

CREATE SEQUENCE sq_cidade START WITH 1 INCREMENT BY 1;

CREATE TABLE cidade
(
    id               NUMBER(38, 0) NOT NULL,
    data_criacao     TIMESTAMP     NOT NULL,
    data_atualizacao TIMESTAMP     NOT NULL,
    nome             VARCHAR2(255) NOT NULL,
    estado_id        NUMBER(38, 0),
    codigo_ibge      VARCHAR2(255),
    CONSTRAINT pk_cidade PRIMARY KEY (id)
);

ALTER TABLE cidade
    ADD CONSTRAINT FK_CIDADE_ON_ESTADO FOREIGN KEY (estado_id) REFERENCES estado (id);

--changeset douglas.ferreira:seed-cidade-rondonia

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alta Floresta D Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100015');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Alegre dos Parecis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100379');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Paraíso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100403');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alvorada D Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100346');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ariquemes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100023');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buritis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100452');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cabixi', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100031');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cacaulândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cacoal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100049');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campo Novo de Rondônia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Candeias do Jamari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Castanheiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100908');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cerejeiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100056');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chupinguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100924');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colorado do Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100064');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Corumbiara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100072');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Costa Marques', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100080');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cujubim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100940');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Espigão D Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100098');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Governador Jorge Teixeira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guajará-Mirim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100106');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapuã do Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100114');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ji-Paraná', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100122');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Machadinho D Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100130');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ministro Andreazza', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mirante da Serra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monte Negro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Brasilândia D Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100148');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Mamoré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100338');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova União', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101435');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Horizonte do Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100502');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ouro Preto do Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100155');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Parecis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101450');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pimenta Bueno', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100189');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pimenteiras do Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101468');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Velho', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Médici', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100254');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Primavera de Rondônia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101476');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Crespo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100262');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rolim de Moura', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100288');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Luzia D Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100296');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Felipe D Oeste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101484');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Francisco do Guaporé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101492');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel do Guaporé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100320');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Seringueiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Teixeirópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101559');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Theobroma', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Urupá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101708');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vale do Anari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101757');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vale do Paraíso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1101807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vilhena', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 11),'1100304');

--changeset douglas.ferreira:seed-cidade-acre
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acrelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200013');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Assis Brasil', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200054');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brasiléia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bujari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200138');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Capixaba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200179');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cruzeiro do Sul', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Epitaciolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200252');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Feijó', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jordão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200328');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mâncio Lima', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200336');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Manoel Urbano', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200344');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marechal Thaumaturgo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200351');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Plácido de Castro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200385');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Acre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Walter', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200393');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Branco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rodrigues Alves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200427');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rosa do Purus', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200435');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sena Madureira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Senador Guiomard', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200450');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tarauacá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Xapuri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'1200708');
--changeset douglas.ferreira:seed-cidade-amazonas

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alvarães', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300029');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amaturá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300060');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anamã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300086');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anori', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Apuí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300144');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Atalaia do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300201');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Autazes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300300');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barcelos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300409');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barreirinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Benjamin Constant', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Beruri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300631');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Boa Vista do Ramos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300680');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Boca do Acre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Borba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300805');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caapiranga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300839');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Canutama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1300904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Carauari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Careiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Careiro da Várzea', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301159');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Coari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Codajás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Eirunepé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Envira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fonte Boa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guajará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301654');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Humaitá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301704');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipixuna', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301803');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Iranduba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301852');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itacoatiara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301902');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itamarati', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1301951');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapiranga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Japurá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302108');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Juruá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302207');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jutaí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302306');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lábrea', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302405');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Manacapuru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302504');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Manaquiri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302553');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Manaus', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302603');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Manicoré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302702');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maraã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302801');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maués', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1302900');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nhamundá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303007');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Olinda do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303106');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Airão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Aripuanã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Parintins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303403');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pauini', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303502');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Figueiredo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303536');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Preto da Eva', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303569');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Isabel do Rio Negro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio do Içá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Gabriel da Cachoeira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Paulo de Olivença', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303908');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Sebastião do Uatumã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1303957');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Silves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tabatinga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304062');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tapauá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tefé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tonantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304237');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uarini', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304260');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Urucará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Urucurituba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 13),'1304401');

--changeset douglas.ferreira:seed-cidade-roraima
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Alegre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400050');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amajari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400027');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Boa Vista', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bonfim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400159');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cantá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400175');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caracaraí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caroebe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400233');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Iracema', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400282');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mucajaí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Normandia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pacaraima', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400456');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rorainópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400472');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João da Baliza', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Luiz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uiramutã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 14),'1400704');
--changeset douglas.ferreira:seed-cidade-para

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Abaetetuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500107');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Abel Figueiredo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500131');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500206');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Afuá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500305');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Água Azul do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500347');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alenquer', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500404');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Almeirim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500503');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Altamira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500602');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anajás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500701');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ananindeua', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500800');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anapu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500859');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Augusto Corrêa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500909');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aurora do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1500958');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aveiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501006');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bagre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501105');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Baião', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501204');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bannach', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501253');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barcarena', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501303');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Belém', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501402');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Belterra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501451');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Benevides', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501501');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Jesus do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501576');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bonito', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501600');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bragança', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501709');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brasil Novo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501725');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brejo Grande do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501758');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Breu Branco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501782');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Breves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501808');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bujaru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501907');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cachoeira do Arari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502004');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cachoeira do Piriá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1501956');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cametá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502103');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Canaã dos Carajás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502152');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Capanema', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502202');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Capitão Poço', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502301');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Castanhal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502400');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chaves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502509');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colares', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502608');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Conceição do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502707');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Concórdia do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502756');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cumaru do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502764');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Curionópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502772');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Curralinho', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502806');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Curuá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502855');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Curuçá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502905');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dom Eliseu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502939');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Eldorado do Carajás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1502954');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Faro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503002');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Floresta do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503044');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Garrafão do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503077');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goianésia do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503093');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Gurupá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503101');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Igarapé-Açu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503200');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Igarapé-Miri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503309');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Inhangapi', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503408');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipixuna do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503457');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Irituia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503507');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaituba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503606');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itupiranga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503705');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jacareacanga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503754');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jacundá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503804');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Juruti', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1503903');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Limoeiro do Ajuru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504000');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mãe do Rio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504059');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Magalhães Barata', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504109');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marabá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504208');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maracanã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504307');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marapanim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504406');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marituba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504422');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Medicilândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504455');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Melgaço', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504505');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mocajuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504604');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Moju', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504703');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mojuí dos Campos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504752');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monte Alegre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504802');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Muaná', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504901');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Esperança do Piriá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504950');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Ipixuna', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1504976');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Timboteua', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505007');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Progresso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505031');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Repartimento', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505064');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Óbidos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505106');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Oeiras do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Oriximiná', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ourém', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505403');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ourilândia do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505437');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pacajá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505486');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palestina do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505494');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paragominas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505502');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Parauapebas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505536');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pau D Arco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505551');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Peixe-Boi', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piçarra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505635');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Placas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505650');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ponta de Pedras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Portel', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto de Moz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1505908');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Prainha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Primavera', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Quatipuru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506112');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Redenção', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506138');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Maria', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506161');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rondon do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506187');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rurópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506195');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Salinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Salvaterra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Bárbara do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506351');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Cruz do Arari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Izabel do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Luzia do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506559');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Maria das Barreiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506583');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Maria do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santana do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506708');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santarém', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santarém Novo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1506906');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio do Tauá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507003');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Caetano de Odivelas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Domingos do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507151');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Domingos do Capim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507201');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Félix do Xingu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507300');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Francisco do Pará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507409');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Geraldo do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507458');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João da Ponta', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507466');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João de Pirabas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507474');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel do Guamá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Sebastião da Boa Vista', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sapucaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507755');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Senador José Porfírio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507805');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Soure', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tailândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507953');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Terra Alta', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507961');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Terra Santa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1507979');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tomé-Açu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tracuateua', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508035');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Trairão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508050');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tucumã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508084');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tucuruí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ulianópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508126');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uruará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508159');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vigia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Viseu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vitória do Xingu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508357');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Xinguara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 15),'1508407');
--changeset douglas.ferreira:seed-cidade-amapa

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amapá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600105');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Calçoene', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600204');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cutias', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600212');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ferreira Gomes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600238');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaubal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600253');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Laranjal do Jari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600279');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Macapá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600303');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mazagão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600402');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Oiapoque', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600501');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pedra Branca do Amapari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600154');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Grande', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600535');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pracuúba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600550');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santana', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600600');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Serra do Navio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600055');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tartarugalzinho', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600709');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vitória do Jari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 16),'1600808');
--changeset douglas.ferreira:seed-cidade-tocantins
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Abreulândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1700251');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aguiarnópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1700301');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aliança do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1700350');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Almas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1700400');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alvorada', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1700707');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ananás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1701002');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Angico', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1701051');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aparecida do Rio Negro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1701101');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aragominas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1701309');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araguacema', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1701903');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araguaçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702000');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araguaína', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702109');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araguanã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702158');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araguatins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702208');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Arapoema', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702307');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Arraias', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702406');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Augustinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702554');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aurora do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702703');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Axixá do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1702901');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Babaçulândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703008');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bandeirantes do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703057');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barra do Ouro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703073');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barrolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703107');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bernardo Sayão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703206');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Jesus do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703305');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brasilândia do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703602');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brejinho de Nazaré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703701');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriti do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703800');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cachoeirinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703826');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campos Lindos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703842');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cariri do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703867');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Carmolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703883');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Carrasco Bonito', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703891');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caseara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1703909');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Centenário', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1704105');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chapada da Natividade', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1705102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chapada de Areia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1704600');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colinas do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1705508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colméia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1716703');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Combinado', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1705557');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Conceição do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1705607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Couto Magalhães', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1706001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cristalândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1706100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Crixás do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1706258');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Darcinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1706506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dianópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Divinópolis do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707108');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dois Irmãos do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707207');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dueré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707306');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Esperantina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707405');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fátima', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707553');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Figueirópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707652');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Filadélfia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1707702');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Formoso do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1708205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goianorte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1708304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goiatins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1709005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guaraí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1709302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Gurupi', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1709500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipueiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1709807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itacajá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1710508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaguatins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1710706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapiratins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1710904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaporã do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1711100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaú do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1711506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Juarina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1711803');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa da Confusão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1711902');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1711951');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lajeado', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1712009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lavandeira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1712157');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lizarda', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1712405');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Luzinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1712454');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marianópolis do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1712504');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mateiros', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1712702');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maurilândia do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1712801');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Miracema do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1713205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Miranorte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1713304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monte do Carmo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1713601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monte Santo do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1713700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Muricilândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1713957');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Natividade', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1714203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nazaré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1714302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Olinda', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1714880');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Rosalândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1715002');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Acordo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1715101');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Alegre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1715150');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Jardim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1715259');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Oliveira de Fátima', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1715507');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1721000');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmeirante', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1715705');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmeiras do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1713809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmeirópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1715754');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paraíso do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1716109');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paranã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1716208');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pau D Arco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1716307');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pedro Afonso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1716505');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Peixe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1716604');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pequizeiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1716653');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pindorama do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1717008');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piraquê', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1717206');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pium', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1717503');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ponte Alta do Bom Jesus', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1717800');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ponte Alta do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1717909');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Alegre do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718006');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Nacional', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718204');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Praia Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718303');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Kennedy', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718402');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pugmil', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718451');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Recursolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718501');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Riachinho', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718550');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio da Conceição', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718659');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio dos Bois', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718709');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Sono', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718758');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sampaio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718808');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sandolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718840');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Fé do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718865');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Maria do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718881');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rita do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718899');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rosa do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1718907');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Tereza do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1719004');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Terezinha do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720002');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Bento do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720101');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Félix do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720150');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720200');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Salvador do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720259');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Sebastião do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720309');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Valério', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720499');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Silvanópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720655');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sítio Novo do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720804');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sucupira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720853');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tabocão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1708254');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Taguatinga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720903');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Taipas do Tocantins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720937');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Talismã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1720978');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tocantínia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1721109');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tocantinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1721208');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tupirama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1721257');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tupiratins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1721307');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Wanderlândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1722081');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Xambioá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 17),'1722107');

--changeset douglas.ferreira:seed-cidade-maranhao

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Açailândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100055');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Afonso Cunha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100105');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Água Doce do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100154');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alcântara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100204');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aldeias Altas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100303');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Altamira do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100402');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Alegre do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100436');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Alegre do Pindaré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100477');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Parnaíba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100501');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amapá do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100550');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amarante do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100600');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anajatuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100709');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anapurus', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100808');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Apicum-Açu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100832');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araguanã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100873');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araioses', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100907');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Arame', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2100956');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Arari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101004');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Axixá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101103');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bacabal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101202');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bacabeira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101251');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bacuri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101301');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bacurituba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101350');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Balsas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101400');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barão de Grajaú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101509');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barra do Corda', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101608');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barreirinhas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101707');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bela Vista do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101772');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Belágua', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101731');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Benedito Leite', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101806');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bequimão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101905');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bernardo do Mearim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101939');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Boa Vista do Gurupi', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2101970');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Jardim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102002');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Jesus das Selvas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102036');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Lugar', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102077');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brejo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102101');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brejo de Areia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102150');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriti', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102200');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriti Bravo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102309');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriticupu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102325');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buritirana', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102358');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cachoeira Grande', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102374');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cajapió', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102408');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cajari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102507');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campestre do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102556');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cândido Mendes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102606');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cantanhede', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102705');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Capinzal do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102754');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Carolina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102804');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Carutapera', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2102903');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caxias', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103000');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cedral', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103109');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Central do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103125');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Centro do Guilherme', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103158');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Centro Novo do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103174');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chapadinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103208');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cidelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103257');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Codó', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103307');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Coelho Neto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103406');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colinas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103505');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Conceição do Lago-Açu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103554');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Coroatá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103604');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cururupu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103703');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Davinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103752');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dom Pedro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103802');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Duque Bacelar', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2103901');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Esperantinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104008');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Estreito', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104057');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Feira Nova do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104073');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fernando Falcão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104081');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Formosa da Serra Negra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104099');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fortaleza dos Nogueiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104107');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fortuna', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104206');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Godofredo Viana', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104305');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Gonçalves Dias', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104404');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Governador Archer', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104503');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Governador Edison Lobão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104552');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Governador Eugênio Barros', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104602');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Governador Luiz Rocha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104628');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Governador Newton Bello', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104651');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Governador Nunes Freire', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104677');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Graça Aranha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104701');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Grajaú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104800');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guimarães', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2104909');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Humberto de Campos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Icatu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Igarapé do Meio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105153');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Igarapé Grande', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Imperatriz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaipava do Grajaú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105351');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapecuru Mirim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itinga do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105427');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jatobá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105450');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jenipapo dos Vieiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105476');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'João Lisboa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Joselândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Junco do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105658');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lago da Pedra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105708');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lago do Junco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lago dos Rodrigues', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105948');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lago Verde', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105906');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa do Mato', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105922');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa Grande do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105963');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lajeado Novo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2105989');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lima Campos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106003');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Loreto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Luís Domingues', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106201');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Magalhães de Almeida', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106300');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maracaçumé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106326');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marajá do Sena', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106359');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maranhãozinho', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106375');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mata Roma', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106409');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Matinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Matões', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Matões do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106631');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Milagres do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106672');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mirador', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Miranda do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106755');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mirinzal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106805');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monção', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2106904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Montes Altos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Morros', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nina Rodrigues', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Colinas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107258');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Iorque', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Olinda do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107357');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Olho d Água das Cunhãs', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Olinda Nova do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107456');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paço do Lumiar', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmeirândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paraibano', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107704');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Parnarama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107803');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Passagem Franca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2107902');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pastos Bons', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paulino Neves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108058');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paulo Ramos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108108');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pedreiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108207');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pedro do Rosário', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108256');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Penalva', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108306');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Peri Mirim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108405');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Peritoró', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108454');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pindaré-Mirim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108504');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pinheiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108603');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pio XII', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108702');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pirapemas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108801');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Poção de Pedras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2108900');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Franco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109007');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Rico do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109056');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Dutra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109106');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Juscelino', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Médici', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109239');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Sarney', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109270');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Presidente Vargas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Primeira Cruz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109403');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Raposa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109452');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Riachão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109502');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ribamar Fiquene', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109551');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rosário', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sambaíba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Filomena do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109759');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Helena', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Inês', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2109908');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Luzia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Luzia do Paruá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110039');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Quitéria do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rita', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santana do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110237');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Amaro do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110278');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio dos Lopes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Benedito do Rio Preto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Bento', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Bernardo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Domingos do Azeitão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110658');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Domingos do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110708');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Félix de Balsas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Francisco do Brejão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110856');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Francisco do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2110906');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João Batista', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111003');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João do Carú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111029');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João do Paraíso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111052');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João do Soter', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111078');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João dos Patos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São José de Ribamar', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111201');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São José dos Basílios', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111250');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Luís', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111300');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Luís Gonzaga do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111409');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Mateus do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Pedro da Água Branca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111532');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Pedro dos Crentes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111573');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Raimundo das Mangabeiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Raimundo do Doca Bezerra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111631');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Roberto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111672');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Vicente Ferrer', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Satubinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111722');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Senador Alexandre Costa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111748');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Senador La Rocque', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111763');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Serrano do Maranhão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111789');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sítio Novo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111805');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sucupira do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sucupira do Riachão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2111953');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tasso Fragoso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Timbiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Timon', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Trizidela do Vale', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112233');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tufilândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112274');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tuntum', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Turiaçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Turilândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112456');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tutóia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Urbano Santos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vargem Grande', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112704');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Viana', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112803');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vila Nova dos Martírios', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112852');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vitória do Mearim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2112902');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vitorino Freire', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2113009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Zé Doca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 21),'2114007');
--changeset douglas.ferreira:seed-cidade-piaui

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acauã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200053');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Agricolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200103');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Água Branca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200202');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alagoinha do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200251');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alegrete do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200277');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Longá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200301');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Altos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200400');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alvorada do Gurguéia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200459');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amarante', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200509');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Angical do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200608');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anísio de Abreu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200707');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Antônio Almeida', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200806');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aroazes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200905');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aroeiras do Itaim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2200954');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Arraial', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201002');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Assunção do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201051');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Avelino Lopes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201101');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Baixa Grande do Ribeiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201150');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barra D Alcântara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201176');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201200');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barreiras do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201309');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barro Duro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201408');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Batalha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201507');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bela Vista do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201556');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Belém do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201572');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Beneditinos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201606');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bertolínia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201705');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Betânia do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201739');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Boa Hora', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201770');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bocaina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201804');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Jesus', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201903');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Princípio do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201919');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bonfim do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201929');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Boqueirão do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201945');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brasileira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201960');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brejo do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2201988');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriti dos Lopes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202000');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriti dos Montes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202026');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cabeceiras do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202059');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cajazeiras do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202075');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cajueiro da Praia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202083');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caldeirão Grande do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202091');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campinas do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202109');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campo Alegre do Fidalgo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202117');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campo Grande do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202133');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campo Largo do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202174');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campo Maior', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202208');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Canavieira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202251');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Canto do Buriti', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202307');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Capitão de Campos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202406');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Capitão Gervásio Oliveira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202455');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caracol', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202505');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caraúbas do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202539');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caridade do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202554');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Castelo do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202604');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caxingó', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202653');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cocal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202703');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cocal de Telha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202711');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cocal dos Alves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202729');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Coivaras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202737');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colônia do Gurguéia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202752');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colônia do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202778');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Conceição do Canindé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202802');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Coronel José Dias', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202851');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Corrente', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2202901');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cristalândia do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203008');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cristino Castro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203107');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Curimatá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203206');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Currais', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203230');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Curral Novo do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203271');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Curralinhos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203255');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Demerval Lobão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203305');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dirceu Arcoverde', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203354');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dom Expedito Lopes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203404');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Dom Inocêncio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203453');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Domingos Mourão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203420');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Elesbão Veloso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203503');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Eliseu Martins', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203602');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Esperantina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203701');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fartura do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203750');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Flores do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203800');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Floresta do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203859');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Floriano', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2203909');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Francinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204006');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Francisco Ayres', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204105');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Francisco Macedo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204154');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Francisco Santos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204204');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fronteiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204303');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Geminiano', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204352');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Gilbués', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204402');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guadalupe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204501');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guaribas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204550');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Hugo Napoleão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204600');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ilha Grande', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204659');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Inhuma', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204709');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipiranga do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204808');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Isaías Coelho', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2204907');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itainópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205003');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaueira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jacobina do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205151');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaicós', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205201');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jardim do Mulato', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205250');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jatobá do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205276');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jerumenha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205300');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'João Costa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205359');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Joaquim Pires', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205409');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Joca Marques', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205458');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'José de Freitas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Juazeiro do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205516');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Júlio Borges', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205524');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jurema', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205532');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa Alegre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205557');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa de São Francisco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205573');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa do Barro do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205565');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205581');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa do Sítio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205599');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoinha do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205540');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Landri Sales', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Luís Correia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Luzilândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205805');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Madeiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205854');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Manoel Emídio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marcolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2205953');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marcos Parente', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Massapê do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206050');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Matias Olímpio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Miguel Alves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Miguel Leão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Milton Brandão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206357');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monsenhor Gil', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monsenhor Hipólito', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monte Alegre do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Morro Cabeça no Tempo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206654');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Morro do Chapéu do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206670');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Murici dos Portelas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206696');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nazaré do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206704');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nazária', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206720');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nossa Senhora de Nazaré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206753');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nossa Senhora dos Remédios', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206803');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Santa Rita', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207959');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Oriente do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206902');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Santo Antônio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2206951');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Oeiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Olho D Água do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207108');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Padre Marcos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207207');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paes Landim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207306');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pajeú do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207355');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmeira do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207405');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmeirais', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207504');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paquetá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207553');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Parnaguá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207603');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Parnaíba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207702');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Passagem Franca do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207751');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Patos do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207777');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pau D Arco do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207793');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paulistana', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207801');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pavussu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207850');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pedro II', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207900');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pedro Laurentino', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2207934');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Picos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208007');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pimenteiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208106');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pio IX', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piracuruca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piripiri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208403');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208502');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porto Alegre do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208551');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Prata do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Queimada Nova', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208650');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Redenção do Gurguéia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Regeneração', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Riacho Frio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208858');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ribeira do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208874');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ribeiro Gonçalves', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2208908');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Grande do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Cruz do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Cruz dos Milagres', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209153');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Filomena', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Luz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rosa do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209377');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santana do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209351');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio de Lisboa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio dos Milagres', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209450');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Inácio do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Braz do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209559');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Félix do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Francisco de Assis do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209658');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Francisco do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209708');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Gonçalo do Gurguéia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209757');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Gonçalo do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João da Canabrava', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209856');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João da Fronteira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209872');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João da Serra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209906');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João da Varjota', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209955');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João do Arraial', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2209971');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210003');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São José do Divino', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210052');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São José do Peixe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São José do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210201');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Julião', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210300');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Lourenço do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210359');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Luis do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210375');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel da Baixa Grande', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210383');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel do Fidalgo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210391');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel do Tapuio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210409');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Pedro do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Raimundo Nonato', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sebastião Barros', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210623');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sebastião Leal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210631');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sigefredo Pacheco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210656');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Simões', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Simplício Mendes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210805');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Socorro do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sussuapara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210938');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tamboril do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210953');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tanque do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2210979');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Teresina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'União', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uruçuí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Valença do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Várzea Branca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211357');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Várzea Grande', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vera Mendes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vila Nova do Piauí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Wall Ferraz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 22),'2211704');
--changeset douglas.ferreira:seed-cidade-ceara

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Abaiara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300101');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acarape', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300150');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acaraú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300200');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acopiara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300309');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aiuaba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300408');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alcântaras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300507');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Altaneira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300606');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Santo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300705');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amontada', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300754');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Antonina do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300804');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Apuiarés', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2300903');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aquiraz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301000');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aracati', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301109');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aracoiaba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301208');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ararendá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301257');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araripe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301307');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aratuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301406');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Arneiroz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301505');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Assaré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301604');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aurora', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301703');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Baixio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301802');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Banabuiú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301851');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barbalha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301901');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barreira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2301950');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302008');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barroquinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302057');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Baturité', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302107');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Beberibe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302206');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bela Cruz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302305');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Boa Viagem', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302404');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brejo Santo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302503');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Camocim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302602');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campos Sales', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302701');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Canindé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302800');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Capistrano', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2302909');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caridade', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303006');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cariré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303105');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caririaçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303204');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cariús', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303303');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Carnaubal', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303402');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cascavel', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303501');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Catarina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303600');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Catunda', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303659');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caucaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303709');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cedro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303808');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chaval', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303907');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Choró', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303931');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chorozinho', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2303956');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Coreaú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304004');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Crateús', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304103');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Crato', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304202');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Croatá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304236');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cruz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304251');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Deputado Irapuan Pinheiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304269');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ereré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304277');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Eusébio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304285');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Farias Brito', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304301');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Forquilha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304350');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fortaleza', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304400');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fortim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304459');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Frecheirinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304509');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'General Sampaio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304608');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Graça', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304657');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Granja', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304707');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Granjeiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304806');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Groaíras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304905');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guaiúba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2304954');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guaraciaba do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guaramiranga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Hidrolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Horizonte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305233');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ibaretama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305266');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ibiapina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ibicuitinga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305332');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Icapuí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305357');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Icó', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Iguatu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Independência', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipaporanga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305654');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipaumirim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305704');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305803');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipueiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2305902');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Iracema', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Irauçuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306108');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaiçaba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306207');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaitinga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306256');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapajé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306306');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapipoca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306405');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapiúna', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306504');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itarema', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306553');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itatira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306603');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaguaretama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306702');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaguaribara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306801');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaguaribe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2306900');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaguaruana', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307007');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jardim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307106');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jati', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jijoca de Jericoacoara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307254');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Juazeiro do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jucás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307403');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lavras da Mangabeira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307502');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Limoeiro do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Madalena', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307635');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maracanaú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307650');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maranguape', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marco', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Martinópole', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2307908');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Massapê', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mauriti', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Meruoca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Milagres', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Milhã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308351');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Miraíma', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308377');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Missão Velha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mombaça', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monsenhor Tabosa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Morada Nova', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308708');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Moraújo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Morrinhos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2308906');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mucambo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309003');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mulungu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309102');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Olinda', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309201');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Russas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309300');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Oriente', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309409');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ocara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309458');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Orós', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309508');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pacajus', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309607');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pacatuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309706');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pacoti', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309805');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pacujá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2309904');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palhano', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310001');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmácia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310100');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paracuru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310209');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paraipaba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310258');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Parambu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310308');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paramoti', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310407');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pedra Branca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310506');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Penaforte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310605');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pentecoste', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310704');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pereiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310803');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pindoretama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310852');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piquet Carneiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310902');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pires Ferreira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2310951');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Poranga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311009');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porteiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311108');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Potengi', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311207');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Potiretama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311231');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Quiterianópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311264');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Quixadá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311306');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Quixelô', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311355');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Quixeramobim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311405');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Quixeré', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311504');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Redenção', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311603');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Reriutaba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311702');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Russas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311801');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Saboeiro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311900');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Salitre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2311959');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Quitéria', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312205');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santana do Acaraú', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312007');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santana do Cariri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312106');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Benedito', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312304');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Gonçalo do Amarante', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312403');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João do Jaguaribe', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312502');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Luís do Curu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312601');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Senador Pompeu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312700');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Senador Sá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312809');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sobral', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2312908');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Solonópole', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313005');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tabuleiro do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313104');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tamboril', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313203');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tarrafas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313252');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tauá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313302');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tejuçuoca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313351');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tianguá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313401');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Trairi', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313500');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Tururu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313559');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ubajara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313609');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Umari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313708');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Umirim', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313757');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uruburetama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313807');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uruoca', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313906');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Varjota', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2313955');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Várzea Alegre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2314003');
INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Viçosa do Ceará', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 23),'2314102');




























































































































































































































































































































































































































































--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
