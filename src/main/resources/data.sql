-- Carga inicial idempotente (não duplica com várias réplicas/reinícios)
INSERT INTO pessoas (nome, data_nascimento)
SELECT 'Maria Silva', '1990-05-14' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM pessoas WHERE nome = 'Maria Silva');

INSERT INTO pessoas (nome, data_nascimento)
SELECT 'João Souza', '1985-11-02' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM pessoas WHERE nome = 'João Souza');

INSERT INTO pessoas (nome, data_nascimento)
SELECT 'Ana Oliveira', '2000-01-27' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM pessoas WHERE nome = 'Ana Oliveira');
