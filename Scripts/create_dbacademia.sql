DROP DATABASE IF EXISTS DBACADEMIA;
CREATE DATABASE DBACADEMIA;
USE DBACADEMIA;


CREATE TABLE ENDERECO(
ID INT NOT NULL AUTO_INCREMENT
, RUA VARCHAR(250)
, NUMERO VARCHAR(5)
, CEP VARCHAR(8)
, COMPLEMENTO VARCHAR(10)
, BAIRRO VARCHAR(250)
, CIDADE VARCHAR(250)
, ESTADO VARCHAR(2)
, PRIMARY KEY(ID)
);

CREATE TABLE PESSOA(
ID INT NOT NULL AUTO_INCREMENT
, ID_ENDERECO INT
, NOME VARCHAR(250)
, CPF VARCHAR(11)
, TELEFONE VARCHAR(11)
, DT_NASCIMENTO VARCHAR(8)
, PRIMARY KEY(ID)
, FOREIGN KEY (ID_ENDERECO) REFERENCES ENDERECO(ID)
);

CREATE TABLE TIPOUSUARIO (
ID INT NOT NULL AUTO_INCREMENT
, DESCRICAO VARCHAR(12)
, PRIMARY KEY(ID)
);

CREATE TABLE USUARIO (
ID INT NOT NULL AUTO_INCREMENT
, ID_PESSOA INT
, ID_TIPOUSUARIO INT
, MATRICULA INT
, VALORHORA DOUBLE
, EMAIL VARCHAR(100)
, LOGIN VARCHAR(10)
, SENHA VARCHAR(4)
, DT_CADASTRO DATETIME
, DT_EXPIRACAO DATETIME
, PRIMARY KEY(ID)
, FOREIGN KEY (ID_PESSOA) REFERENCES PESSOA(ID)
, FOREIGN KEY (ID_TIPOUSUARIO) REFERENCES TIPOUSUARIO(ID)
);


CREATE TABLE TREINO(
ID INT NOT NULL AUTO_INCREMENT
, ID_CLIENTE INT
, ID_PROFISSIONAL INT
, DT_CADASTRO DATETIME
, DT_TERMINO DATETIME
, NIVEL STRING VARCHAR 15
, TREINO TEXT
, PRIMARY KEY(ID)
, FOREIGN KEY (ID_CLIENTE) REFERENCES USUARIO(ID)
, FOREIGN KEY (ID_PROFISSIONAL) REFERENCES USUARIO(ID)
);


CREATE TABLE AGENDAMENTO(
ID INT NOT NULL AUTO_INCREMENT
, ID_CLIENTE INT
, ID_PROFISSIONAL INT 
, DATAHORA_INICIO DATETIME
, DATAHORA_FINAL DATETIME
, PRIMARY KEY(ID)
, FOREIGN KEY (ID_CLIENTE) REFERENCES USUARIO(ID)
, FOREIGN KEY (ID_PROFISSIONAL) REFERENCES USUARIO(ID)
);