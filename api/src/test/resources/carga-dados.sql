insert into exemplo (id, nome, descricao, data_criacao, data_atualizacao, situacao) values (1, 'Teste de Nome', 'Teste de Descrição', TIMESTAMP '2022-09-23 16:59:16.000000', TIMESTAMP '2023-08-01 17:08:54.000000', true);

INSERT INTO estado
values (sq_estado.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goiás', '52','GO');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Abadia de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200050');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Abadiânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200100');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Acreúna', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200134');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Adelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200159');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Água Fria de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200175');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Água Limpa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200209');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Águas Lindas de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200258');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alexânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200308');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aloândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200506');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Horizonte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200555');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alto Paraíso de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200605');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Alvorada do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200803');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amaralina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200829');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Americano do Brasil', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200852');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Amorinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5200902');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anápolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201108');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anhanguera', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201207');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Anicuns', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201306');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aparecida de Goiânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201405');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aparecida do Rio Doce', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201454');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aporé', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201504');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201603');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aragarças', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201702');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aragoiânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5201801');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Araguapaz', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5202155');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Arenópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5202353');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aruanã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5202502');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Aurilândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5202601');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Avelinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5202809');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Baliza', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203104');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Barro Alto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203203');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bela Vista de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203302');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Jardim de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203401');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bom Jesus de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203500');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bonfinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203559');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Bonópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203575');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Brazabrantes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203609');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Britânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203807');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriti Alegre', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203906');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buriti de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203939');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Buritinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5203962');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cabeceiras', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204003');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cachoeira Alta', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204102');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cachoeira de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204201');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cachoeira Dourada', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204250');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204300');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caiapônia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204409');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caldas Novas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204508');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caldazinha', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204557');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campestre de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204607');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campinaçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204656');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campinorte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204706');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campo Alegre de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204805');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campo Limpo de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204854');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campos Belos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204904');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Campos Verdes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5204953');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Carmo do Rio Verde', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205000');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Castelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205059');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Catalão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205109');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Caturaí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205208');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cavalcante', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205307');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ceres', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205406');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cezarina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205455');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Chapadão do Céu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205471');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cidade Ocidental', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205497');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cocalzinho de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205513');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Colinas do Sul', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205521');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Córrego do Ouro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205703');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Corumbá de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205802');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Corumbaíba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5205901');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cristalina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206206');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cristianópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206305');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Crixás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206404');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cromínia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206503');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Cumari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206602');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Damianópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206701');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Damolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206800');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Davinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5206909');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Diorama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207105');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Divinópolis de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208301');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Doverlândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207253');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Edealina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207352');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Edéia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207402');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Estrela do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207501');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Faina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207535');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Fazenda Nova', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207600');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Firminópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207808');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Flores de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5207907');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Formosa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208004');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Formoso', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208103');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Gameleira de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208152');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goianápolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208400');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goiandira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208509');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goianésia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208608');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goiânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208707');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goianira', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208806');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5208905');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Goiatuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209101');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Gouvelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209150');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guapó', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209200');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guaraíta', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209291');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guarani de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209408');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Guarinos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209457');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Heitoraí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209606');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Hidrolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209705');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Hidrolina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209804');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Iaciara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209903');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Inaciolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209937');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Indiara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5209952');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Inhumas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210000');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipameri', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210109');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ipiranga de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210158');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Iporá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210208');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Israelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210307');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaberaí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210406');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaguari', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210562');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itaguaru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210604');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itajá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210802');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapaci', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5210901');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapirapuã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211008');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itapuranga', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211206');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itarumã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211305');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itauçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211404');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Itumbiara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211503');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ivolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211602');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jandaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211701');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaraguá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211800');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jataí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5211909');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jaupaci', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212006');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jesúpolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212055');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Joviânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212105');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Jussara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212204');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Lagoa Santa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212253');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Leopoldo de Bulhões', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212303');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Luziânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212501');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mairipotaba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212600');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mambaí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212709');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mara Rosa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212808');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Marzagão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212907');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Matrinchã', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5212956');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Maurilândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213004');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mimoso de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213053');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Minaçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213087');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mineiros', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213103');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Moiporá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213400');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Monte Alegre de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213509');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Montes Claros de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213707');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Montividiu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213756');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Montividiu do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213772');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Morrinhos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213806');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Morro Agudo de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213855');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mossâmedes', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5213905');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mozarlândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214002');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mundo Novo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214051');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Mutunópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214101');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nazário', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214408');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nerópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214507');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Niquelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214606');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova América', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214705');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Aurora', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214804');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Crixás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214838');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Glória', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214861');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Iguaçu de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214879');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Roma', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5214903');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Nova Veneza', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215009');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Brasil', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215207');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Gama', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215231');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Novo Planalto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215256');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Orizona', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215306');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ouro Verde de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215405');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Ouvidor', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215504');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Padre Bernardo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215603');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palestina de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215652');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmeiras de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215702');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palmelo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215801');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Palminópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5215900');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Panamá', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5216007');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paranaiguara', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5216304');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Paraúna', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5216403');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Perolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5216452');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Petrolina de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5216809');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pilar de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5216908');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piracanjuba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5217104');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Piranhas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5217203');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pirenópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5217302');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pires do Rio', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5217401');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Planaltina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5217609');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Pontalina', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5217708');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porangatu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218003');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Porteirão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218052');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Portelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218102');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Posse', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218300');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Professor Jamil', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218391');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Quirinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218508');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rialma', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218607');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rianápolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218706');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Quente', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218789');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rio Verde', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218805');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Rubiataba', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5218904');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sanclerlândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219001');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Bárbara de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219100');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Cruz de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219209');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Fé de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219258');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Helena de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219308');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Isabel', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219357');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rita do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219407');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rita do Novo Destino', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219456');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Rosa de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219506');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Tereza de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219605');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santa Terezinha de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219704');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio da Barra', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219712');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219738');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Santo Antônio do Descoberto', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219753');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Domingos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219803');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Francisco de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5219902');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João da Paraúna', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220058');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São João d Aliança', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220009');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Luís de Montes Belos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220108');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Luiz do Norte', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220157');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel do Araguaia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220207');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Miguel do Passa Quatro', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220264');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Patrício', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220280');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'São Simão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220405');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Senador Canedo', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220454');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Serranópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220504');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Silvânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220603');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Simolândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220686');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Sítio d Abadia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5220702');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Taquaral de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221007');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Teresina de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221080');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Terezópolis de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221197');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Três Ranchos', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221304');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Trindade', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221403');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Trombas', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221452');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Turvânia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221502');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Turvelândia', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221551');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uirapuru', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221577');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uruaçu', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221601');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Uruana', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221700');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Urutaí', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221809');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Valparaíso de Goiás', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221858');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Varjão', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5221908');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vianópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5222005');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vicentinópolis', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5222054');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vila Boa', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5222203');

INSERT INTO cidade values (sq_cidade.nextval,(SELECT SYSDATE AS current_date FROM dual), (SELECT SYSDATE AS current_date FROM dual), 'Vila Propício', (select ID from ESTADO where ESTADO.CODIGO_IBGE = 52),'5222302');
