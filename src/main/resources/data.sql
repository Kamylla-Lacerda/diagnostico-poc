-- tb_municipio
INSERT INTO tb_municipio (CD_MUNICIPIO, NM_MUNICIPIO, SG_UF, CD_COMPLETO, CD_CEP_INICIAL, CD_CEP_FINAL, FL_ATIVO) VALUES
(3106200, 'Contagem', 'MG', 3106200, '32000-000', '32000-999', TRUE),
(3100104, 'Belo Horizonte', 'MG', 3100104, '30000-000', '31999-999', TRUE),
(3102305, 'Betim', 'MG', 3102305, '32600-000', '32699-999', TRUE),
(3102305, 'Abadia dos Dourados', 'MG', 3107854, '32800-000', '32899-999', TRUE);

-- tb_regional
INSERT INTO tb_regional (CD_CENSO, NM_REGIONAL, NM_REGIONAL_REDUZIDO, SG_REGIONAL, DS_EMAIL, CD_SSC, FL_ATIVO) VALUES
(3101, 'Superintendência Regional de Ensino Metropolitana A', 'SRE Metropolitana A', 'SMA', 'contato@srea.org.br', '1234', TRUE),
(3102, 'Superintendência Regional de Ensino Metropolitana B', 'SRE Metropolitana B', 'SMB', 'contato@sreb.org.br', '5678', TRUE),
(3103, 'Superintendência Regional de Ensino Monte Carmelo', 'SRE Monte Carmelo', 'SMC', 'contato@sremontecarmelo.org.br', '9101', TRUE);

-- tb_municipio_regional
INSERT INTO tb_municipio_regional (FL_ATIVO, ID_MUNICIPIO, ID_REGIONAL) VALUES
(TRUE, 1, 2), -- Contagem - SRE Metropolitana B
(TRUE, 2, 1), -- Belo Horizonte - SRE Metropolitana A
(TRUE, 3, 2), -- Betim - SRE Metropolitana B
(TRUE, 4, 1); -- Abadia dos Dourados - SRE Monte Carmelo


-- tb_predio
INSERT INTO tb_predio (CD_PREDIO, AA_CONSTRUCAO, DS_LOGRADOURO, NR_LOGRADOURO, DS_COMPLEMENTO, DS_BAIRRO, DS_DISTRITO, DS_CEP, TP_PREDIO, ID_MUNICIPIO_REGIONAL) VALUES
(1001, 1990, 'Rua A', 10, '', 'Centro', 'Distrito 1', '32010-000', 'ESCOLAR', 2),
(1002, 2000, 'Rua B', 200, '', 'Centro', 'Distrito 2', '30130-002', 'ESCOLAR', 2),
(1003, 2012, 'Rua C', 300, 'Bloco A', 'Centro', 'Distrito 3', '32600-000', 'REGIONAL_DE_ENSINO', 1),
(1004, 2018, 'Rua D', 400, '', 'São Jorge', 'Distrito 4', '38400-000', 'CONSERVATORIO', 3),
(1005, 2021, 'Rua E', 500, '', 'Centro', 'Distrito 5', '36000-000', 'SOCIOEDUCATIVAS_PRISIONAIS', 4);

-- tb_escola
INSERT INTO tb_escola (CD_CENSO, NM_ESCOLA, NR_ALUNO) VALUES
(12345678, 'Escola Municipal Dr. Francisco Gontijo', 500),
(87654321, 'Escola Estadual Governador Milton Campos', 300),
(11223344, 'Colégio Santo Agostinho', 450),
(55667788, 'Escola Estadual Professor Eurico Vilela', 600),
(99887766, 'Escola Estadual João XXIII', 350),
(22334455, 'Escola Municipal Jardim Liberdade', 420);

-- tb_predio_escola
INSERT INTO tb_predio_escola (FL_ENDERECO_PRINCIPAL, ID_PREDIO, ID_ESCOLA) VALUES
(TRUE, 1, 1),
(TRUE, 2, 2),
(TRUE, 3, 3),
(TRUE, 4, 4),
(TRUE, 5, 5),
(TRUE, 1, 6),
(FALSE, 4, 2);

-- tb_diagnostico
INSERT INTO tb_diagnostico (QT_ALUNO, NM_ESCOLA, TP_ESCOLA, TP_ENSINO_ESCOLA, TP_PREDIO, FL_ENDERECO_PRINCIPAL, FL_TOMBAMENTO, NR_PAVIMENTOS, NR_BLOCOS, TP_CONSTRUCAO, QT_AREA_TOTAL, QT_AREA_CONSTRUIDA, DS_TELEFONE, DS_EMAIL, OB_PREDIO, AA_DIAGNOSTICO, ST_DIAGNOSTICO, DS_JUSTIFICATIVA_DIAGNOSTICO, ID_PREDIO_ESCOLA) VALUES
(500, 'Escola Municipal Dr. Francisco Gontijo', 'REGULAR', 'ENSINO_FUNDAMENTAL_II', 'ESCOLAR', TRUE, 1, 3, 2, 'ALVENARIA_CONVENCIONAL', 1500.0, 1200.0, '3133333333', 'dr.gontijo@escola.com.br', 'Bom estado geral', 2023, 'CONCLUIDO', 'Diagnóstico realizado com sucesso.', 1),
(300, 'Escola Estadual Governador Milton Campos', 'REGULAR', 'ENSINO_MEDIO', 'ESCOLAR', FALSE, 0, 2, 1, 'CONCRETO_ARMADO', 2000.0, 1600.0, '3144444444', 'milton.campos@escola.gov.br', 'Necessita de pequenas reformas', 2024, 'EM_ANDAMENTO', 'Reformas necessárias em algumas áreas.', 7);
