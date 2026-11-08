-- ==========================================
-- SCRIPT SQL: Sistema de Localização Acadêmica (SLA)
-- ==========================================

CREATE DATABASE IF NOT EXISTS sla_db;
USE sla_db;

-- 1. Tabela de Perfis (ALUNO, PROFESSOR)
CREATE TABLE perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- 2. Tabela de Usuários (Login autenticado)
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    perfil_id INT NOT NULL,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

-- 3. Tabela de Salas (Diferenciando Teóricas e Laboratórios)
CREATE TABLE sala (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bloco VARCHAR(20) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    tipo VARCHAR(50) NOT NULL -- Ex: 'TEORICA', 'LABORATORIO'
);

-- 4. Tabela de Disciplinas
CREATE TABLE disciplina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- 5. Tabela de Alocações (Mapeia a aula do usuário, horário e sala)
CREATE TABLE alocacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    disciplina_id INT NOT NULL,
    sala_id INT NOT NULL,
    horario VARCHAR(50) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id),
    FOREIGN KEY (sala_id) REFERENCES sala(id)
);

-- ==========================================
-- INSERÇÃO DE DADOS INICIAIS (REQUISITO MÍNIMO)
-- ==========================================

INSERT INTO perfil (nome) VALUES ('ALUNO'), ('PROFESSOR');

INSERT INTO sala (bloco, numero, tipo) VALUES 
('Bloco A', 'Sala 102', 'TEORICA'),
('Bloco B', 'Lab 04', 'LABORATORIO');

INSERT INTO disciplina (nome) VALUES 
('Engenharia de Software II'),
('Banco de Dados');

-- Inserindo 2 Alunos e 2 Professores
INSERT INTO usuario (nome, email, senha, perfil_id) VALUES 
('Lucas Silva', 'lucas.aluno@uniceplac.edu.br', '123456', 1),
('Mariana Souza', 'mariana.aluna@uniceplac.edu.br', '123456', 1),
('Prof. Roberto Santos', 'roberto.prof@uniceplac.edu.br', '123456', 2),
('Profª. Juliana Lima', 'juliana.prof@uniceplac.edu.br', '123456', 2);

-- Vinculando alocações de exemplo
INSERT INTO alocacao (usuario_id, disciplina_id, sala_id, horario) VALUES 
(1, 1, 1, 'Segunda-feira - 19:00h às 20:40h'),
(2, 2, 2, 'Terça-feira - 20:50h às 22:30h'),
(3, 1, 1, 'Segunda-feira - 19:00h às 20:40h'),
(4, 2, 2, 'Terça-feira - 20:50h às 22:30h');