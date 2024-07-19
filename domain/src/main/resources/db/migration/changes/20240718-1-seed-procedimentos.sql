--liquibase formatted sql
--changeset douglas.ferreira:seed-procedimentos

INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Depilação a Lazer');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Botox');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Botox Nefertiti');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Laser Lavieen');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Preenchimento');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Rinomodelação');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Bioestimulador de colageno');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Botox Fullface');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Botox sorriso gengival');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Design');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Design com rena');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Buço na linha');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Limpeza de pele comum');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Limpeza de pele com dermaplaning');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Dermaplaning');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Dermapen');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Micropigmentação');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Retoque micropigmentação');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Pelling quimico');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Aplicação varizes');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Aplicação de enzimas');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Lipo de papada enzimatica');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Massagem modeladora');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Massagem relaxante');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Massagem drenagem');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Massagem para flacidez');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Massagem para celulite');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Lift facial');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Radiofrequencia');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Lipocavitação');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Cone yndu');
INSERT INTO PROCEDIMENTO
VALUES ((sq_procedimento.nextval), 1, sysdate, sysdate, 'Sessão detox');

--changeset douglas.ferreira:seed-procedimentos_depilação_lazer
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Virilha Completa', 150);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Axilas', 70.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Virilha Simples', 100.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Buço', 40.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Rosto', 100.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Contorno DA Barba', 80.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Barba Completa', 150.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Meia Perna', 170.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Perna Completa', 300.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Costas', 200.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Abdomen', 150.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Toráx', 130.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Linha Alba', 40.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Nariz', 40.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Queixo', 40.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Costeletas', 40.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Testa', 40.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Nuca', 50.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Areola', 50.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Mãos,Pés e Dedos', 50.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Pescoço', 80.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Braço', 100.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Antebraço', 100.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Lombar', 100.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, 1, 'Gluteos', 100.00);

--changeset douglas.ferreira:seed-procedimentos_botox
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Botox'), 'Terço Superior - Masculino', 850.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Botox'), 'Terço Superior - Feminino', 800.00);

INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Botox Nefertiti'), 'Pescoço', 1000.00);

--changeset douglas.ferreira:seed-procedimentos_lase_lavieen
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Laser Lavieen'), 'Face', 350.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Laser Lavieen'), 'Facial, Colo e Pescoço', 450.00);
--changeset douglas.ferreira:seed-procedimentos_preenchimento
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Preenchimento'), 'Labios', 1200.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Preenchimento'), 'Naso', 800.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Preenchimento'), 'Olheiras', 800.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_colageno
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Bioestimulador de colageno'), 'Face', 1600.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Bioestimulador de colageno'), 'Face', 2000.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_botox
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Botox Fullface'), 'Face', 1200.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Botox sorriso gengival'), 'Face', 400.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_design
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Design'), 'Sobrancelhas', 30.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Design com rena'), 'Sobrancelhas', 40.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_buco_na_linha
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Buço na linha'), 'Buço', 10.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_limpeza_pele
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Limpeza de pele comum'), 'Face', 100.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Limpeza de pele com dermaplaning'), 'Face', 150.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_Dermaplaning
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Dermaplaning'), 'Face,Pescoço ou Colo', 400.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_micropigmentacao
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Micropigmentação'), 'Sobrancelhas', 350.00);
