--liquibase formatted sql
--changeset douglas.ferreira:seed-botox

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'BOTOX', 'Terço Superior - Masculino', 1, 30, 850.00, sysdate, 1, sysdate);
INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'BOTOX', 'Terço Superior - Feminino', 1, 30, 800.00, sysdate, 1, sysdate);
INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'BOTOX_NEFERTITI', 'Pescoço', 1, 30, 100.00, sysdate, 1, sysdate);

--changeset douglas.ferreira:seed-depilacao-lazer
INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Virilha Completa', 1, 30, 150.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Axilas', 1, 30, 70.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Virilha Simples', 1, 30, 100.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Buço', 1, 30, 40.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Rosto', 1, 30, 100.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Contorno Da Barba', 1, 30, 80.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Barba Completa', 1, 30, 150.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Meia Perna', 1, 30, 170.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Perna Completa', 1, 30, 300.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Costas', 1, 30, 200.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Abdomen', 1, 30, 150.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Toráx', 1, 30, 130.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Linha Alba', 1, 30, 40.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Nariz', 1, 30, 40.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Queixo', 1, 30, 40.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Costeletas', 1, 30, 40.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Testa', 1, 30, 40.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Nuca', 1, 30, 50.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Areola', 1, 30, 50.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Mãos,Pés e Dedos', 1, 30, 50.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Pescoço', 1, 30, 80.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Braço', 1, 30, 100.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Antebraço', 1, 30, 100.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Lombar', 1, 30, 100.00, sysdate, 1, sysdate);

INSERT INTO PROCEDIMENTO (id, nome, regiao, quantidade_sessoes, intervalo_entre_sessoes, valor, data_criacao, situacao,
                          data_atualizacao)
VALUES ((sq_procedimento.nextval), 'DEPILACAO_A_LASER', 'Gluteos', 1, 30, 100.00, sysdate, 1, sysdate);

