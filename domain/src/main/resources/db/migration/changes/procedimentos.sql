
--changeset douglas.ferreira:seed-procedimentos_lase_lavieen
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Laser Lavieen'), 'Face', 350.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Laser Lavieen'),
        'Facial, Colo e Pescoço', 450.00);
--changeset douglas.ferreira:seed-procedimentos_preenchimento
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Preenchimento'), 'Labios', 1200.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Preenchimento'), 'Naso', 800.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Preenchimento'), 'Olheiras', 800.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_colageno
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Bioestimulador de colageno'), 'Face',
        1600.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Bioestimulador de colageno'), 'Face',
        2000.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_botox
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Botox Fullface'), 'Face', 1200.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Botox sorriso gengival'), 'Face',
        400.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_design
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Design'), 'Sobrancelhas', 30.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Design com rena'), 'Sobrancelhas',
        40.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_buco_na_linha
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Buço na linha'), 'Buço', 10.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_limpeza_pele
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Limpeza de pele comum'), 'Face', 100.00);
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Limpeza de pele com dermaplaning'),
        'Face', 150.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_Dermaplaning
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Dermaplaning'), 'Face,Pescoço ou Colo',
        400.00);
--changeset douglas.ferreira:seed-procedimentos_bioestimulador_micropigmentacao
INSERT INTO REGIAO (ID, QUANTIDADE_SESSOES, INTERVALO_ENTRE_SESSOES, PROCEDIMENTO_ID, NOME, VALOR)
VALUES ((sq_regiao.nextval), 1, 30, (SELECT ID FROM PROCEDIMENTO WHERE NOME = 'Micropigmentação'), 'Sobrancelhas',
        350.00);
