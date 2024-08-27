ALTER SEQUENCE public.tb_municipio_id_municipio_seq RESTART WITH 1;

ALTER SEQUENCE public.tb_regional_id_regional_seq RESTART WITH 1;

ALTER SEQUENCE public.tb_predio_id_predio_seq RESTART WITH 1;

ALTER SEQUENCE public.tb_escola_id_escola_seq RESTART WITH 1;

ALTER SEQUENCE public.tb_predio_escola_id_predio_escola_seq RESTART WITH 1;

ALTER SEQUENCE public.tb_diagnostico_id_diagnostico_seq RESTART WITH 1;

INSERT INTO tb_municipio
(cod_munucipio, ds_nome, uf)
VALUES
(3101, 'Belo Horizonte', 'MG'),
(3102, 'Uberlândia', 'MG'),
(3103, 'Contagem', 'MG'),
(3104, 'Juiz de Fora', 'MG'),
(3105, 'Betim', 'MG');

INSERT INTO tb_regional
(id_municipio, ds_nome)
VALUES
(1, 'SRE Metropolitana A - Belo Horizonte'),
(2, 'SRE Uberlândia'),
(3, 'SRE Metropolitana B - Contagem'),
(4, 'SRE Juiz de Fora'),
(5, 'SRE Metropolitana C - Betim');

INSERT INTO tb_predio
(id_regional, ds_tipo)
VALUES
(1, 'CONSERVATORIO'),
(2, 'REGIONAL_DE_ENSINO'),
(3, 'SOCIO_ESUCATIVOS'),
(4, 'ESCOLAR'),
(5, 'ESCOLAR');

INSERT INTO tb_escola
(cod_censo, qnt_aluno, ds_nome)
VALUES
(31345678, 500, 'Escola Estadual Afonso Pena'),
(31234567, 450, 'Escola Estadual Santos Dumont'),
(31456789, 300, 'Escola Estadual Tiradentes'),
(31567890, 200, 'Escola Municipal Joaquim Nabuco'),
(31678901, 350, 'Escola Estadual Pedro II');

INSERT INTO tb_predio_escola
(id_escola, id_predio)
VALUES
(1, 1),  -- Escola Estadual Afonso Pena no Conservatório
(2, 2),  -- Escola Estadual Santos Dumont na Regional de Ensino
(3, 3),  -- Escola Estadual Tiradentes em SocioEducativas / Prisionais
(4, 4),  -- Escola Municipal Joaquim Nabuco em Escolar
(5, 5),  -- Escola Estadual Pedro II em Escolar
(1, 4),  -- Escola Estadual Afonso Pena também em Escolar
(2, 5),  -- Escola Estadual Santos Dumont também em Escolar
(3, 1),  -- Escola Estadual Tiradentes também no Conservatório
(4, 2),  -- Escola Municipal Joaquim Nabuco também na Regional de Ensino
(5, 3);  -- Escola Estadual Pedro II também em SocioEducativas / Prisionais

INSERT INTO tb_diagnostico
(ano_diagnostico, id_predio_escola, ds_status)
VALUES
(2023, 1, 'CONCLUIDO'),
(2023, 2, 'EM_ANDAMENTO'),
(2022, 3, 'AGUARDANDO_DIRETOR'),
(2023, 4, 'NAO_INICIADO'),
(2022, 5, 'AGUARDANDO_SUPERINTENDENTE'),
(2023, 1, 'EM_ANDAMENTO'),
(2022, 2, 'CONCLUIDO'),
(2023, 3, 'NAO_INICIADO'),
(2022, 4, 'AGUARDANDO_SUPERINTENDENTE'),
(2023, 5, 'AGUARDANDO_DIRETOR');