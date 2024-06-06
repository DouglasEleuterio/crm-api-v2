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

--  INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'nome', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 12),'codigo');
