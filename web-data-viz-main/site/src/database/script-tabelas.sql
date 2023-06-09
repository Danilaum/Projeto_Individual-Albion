CREATE TABLE usuario (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50),
	email VARCHAR(50),
	senha VARCHAR(50)
);
CREATE DATABASE aquatech;
drop database aquatech;
 USE aquatech;
select * from usuario;

create table aquario (
/* em nossa regra de negócio, um aquario tem apenas um sensor */
	id INT PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(300)
);





/*
esta tabela "medida" deve estar de acordo com o comando INSERT
do ambiente de DESENVOLVIMENTO do arquivo "main.js"
*/

create table medida (
	id INT PRIMARY KEY AUTO_INCREMENT,
	dht11_umidade DECIMAL(10,2),
	dht11_temperatura DECIMAL(10,2),
	luminosidade DECIMAL,
	lm35_temperatura DECIMAL(10,2),
	chave TINYINT,
	momento DATETIME,
	fk_aquario INT,
    valor varchar(45),
	FOREIGN KEY (fk_aquario) REFERENCES aquario(id)
);
select * from medida;
select valor from medida order by  id desc limit 4;
truncate table medida;
                   
                    