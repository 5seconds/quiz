create database projeto;

create table TipoUsuario(

id int primary key auto_increment,
nome varchar(50) not null

);

create table Usuario(

id int primary key auto_increment,
nome varchar(100) not null,
email varchar(50) not null unique,
senha varchar(100) not null,
tipoUsuarioFk int,

foreign key (tipoUsuarioFK) references TipoUsuario(id)
);

create table Disciplina(

id int primary key auto_increment,
nome varchar(100) not null
);

create table Nivel(

id int primary key auto_increment,
nome varchar(100) not null
);


create table Perguntas(

id int primary key auto_increment,
descricao varchar(1000) not null,
idNivelFK int,
idDisciplinaFK int,

foreign key (idNivelFK) references Nivel(id)
 ON DELETE CASCADE,
foreign key (idDisciplinaFK) references Disciplina(id)
 ON DELETE CASCADE
);

delete from Perguntas where id = 1;

create table Alternativa(

id int primary key auto_increment,
descricao varchar(500) not null,
alterCorreta varchar(200) not null,
idPerguntaFK int,

foreign	key (idPerguntaFK) references Perguntas(id)
 ON DELETE CASCADE

);

-------------------------------- INSERT ------------------------------------------------------------------
insert into TipoUsuario (nome) values ("Usuario Normal");
insert into TipoUsuario (nome) values ("Usuario ADM");

insert into Usuario (nome,email,senha,tipoUsuarioFk) values ("Administrador", "administrador@adm.com","adm123",2);

insert into Disciplina (nome) values ("Engenharia de Software");
insert into Disciplina (nome) values ("Banco de Dados");
insert into Disciplina (nome) values ("Desenvolvimento Web");

insert into Nivel (nome) values ("Básico");
insert into Nivel (nome) values ("Médio");
insert into Nivel (nome) values ("Expert");


-------------------------  PERGUNTAS ----------------------------

--- BANCO DE DADOS ---

INSERT INTO `Perguntas` VALUES (15,' A função string do banco de dados MYSQL que retorna a posição da primeira ocorrência de uma string é denominada.',3,2),(16,'No MySQL, a função extractValue() extrai um valor de um string XML. Ela recebe dois argumentos. O segundo argumento usa uma expressão na notação: ',3,2),(17,'As tabelas que permitem a definição de Transactions e Cons- traints de chave estrangeira em MySQL devem ser configuradas como',3,2),(18,'No servidor MySQL, para apagar todos os logs binários, redefinir o arquivo de índice e criar um novo log binário, utiliza-se o',3,2),(19,'A função LAST_INSERT_ID, em MYSQL',3,2),(20,'Na criação de um banco de dados relacional, por suas características, podem ser utilizados como chave primária ',1,2),(21,'A unidade lógica de armazenamento de banco de dados usada para agrupar as demais estruturas lógicas relacionadas, apenas especificando a localização de armazenamento do banco de dados, é denominada ?',2,2),(22,' É um comando do tipo DDL (Data Definition Language) no SQL:',1,2),(23,'Em um cluster, as',1,2),(24,'Qual o comando no Mysql para inserir, alterar e listar dados de uma tabela, respectivamente?',1,2),(25,'O Projeto de um banco de dados é normalmente dividido em fases. Assinale a afirmativa correta.',2,2),(26,'No Modelo Relacional de Dados, o mecanismo fundamental para manter a consistência dos dados e evitar registros órfãos é denominado',2,2),(27,'O SQL Server NÃO possui dados para armazenar',1,2),(29,'No MySQL, o comando SQL \" SELECT* FROM T ORDER BY A DESC LIMIT 4,8\" provoca: ',2,2);

INSERT INTO `Alternativa` VALUES (57,' a) STRCHR. ','0',15),(58,'b) RPAD. ','0',15),(59,'c) INSTR.','1',15),(60,'d) RTRIM.','0',15),(61,'a) Java ','0',16),(62,'b) SQL ','0',16),(63,'c) JavaScript','0',16),(64,'e) XPath ','1',16),(65,'a) MyISAM ','0',17),(66,'b) InnoDB ','1',17),(67,'c) DBTrans ','0',17),(68,'d) StrangDB ','0',17),(69,'a) DELETE LOGS ','0',18),(70,'b) TRUNCATE MASTER','0',18),(71,'c) RESET ALL ','0',18),(72,'d) RESET MASTER','1',18),(73,'a) retorna com o identificador do último octeto, dado um endereço de rede no formato IPv4,','0',19),(74,'b) utiliza o identificador da coluna informada para gerar um novo número de identificação.','0',19),(75,'c) retorna o identificador universal exclusivo para a tabela informada. ','0',19),(76,'d) retorna o último valor para uma coluna que tenha a propriedade de auto incremento. ','1',19),(77,' a) NOME, MATRÍCULA e CÓDIGO_ PEÇA ','0',20),(78,'\r\nb) NOME, SALÁRIO e CARGO_FUNÇÃO\r\n ','0',20),(79,'c) CPF, MATRÍCULA e CÓDIGO_PEÇA\r\n ','1',20),(80,' d) CPF, SALÁRIO e CARGO_FUNÇÃO ','0',20),(81,'a) schema object. ','0',21),(82,'b) data block.  ','0',21),(83,'c)  extent. ','0',21),(84,'d) tablespace.  ','1',21),(85,' a) SELECT. ','0',22),(86,' b) DELETE. ','0',22),(87,' c) INSERT. ','0',22),(88,' d) CREATE. ','1',22),(89,'a) colunas das tabelas relacionadas são chamadas key hashing.  ','0',23),(90,' b) linhas das tabelas relacionadas são chamadas key index. \r\n','0',23),(91,'c) colunas das tabelas relacionadas são chamadas column key.  ','0',23),(92,'d) colunas das tabelas relacionadas são chamadas cluster key. ','1',23),(93,' A) ALTER TABLE, UPDATE, SELECT','0',24),(94,' B) INSERT INTO, ALTER TABLE, SELECT ','1',24),(95,' C) INSERT INTO, ALTER TABLE, UPDATE','0',24),(96,' D) INSERT INTO, SELECT, ALTER TABLE','0',24),(97,'A) Projeto Conceitual: é analisado um modelo de dados em função do SGBD definido e usa modelo de dados para descrever a realidade.  ','0',25),(98,'B) Projeto Lógico: linguagem usada para especificar esquemas lógicos, consiste em criar um modelo físico de dados a partir do modelo conceitual independente do SGBD escolhido. ','0',25),(99,'C) Projeto Físico: descreve estruturas de armazenamento e métodos de acesso. ','1',25),(100,'D)  Projeto Conceitual: define como os dados são armazenados no SGBD específico.','0',25),(101,'A) Integridade Relacional.\r\n ','0',26),(102,'B) Integridade de Chave.  ','0',26),(103,'C)  Dependência Funcional.','0',26),(104,'D) Integridade Referencial. ','1',26),(105,'  A) ALTER TABLE, UPDATE, SELECT','0',27),(106,'  B) INSERT INTO, ALTER TABLE, SELECT ','1',27),(107,'  C) INSERT INTO, ALTER TABLE, UPDATE','0',27),(108,'  D) INSERT INTO, SELECT, ALTER TABLE','0',27),(113,'A)  a ordenação dos oito primeiros registros de T, como especificado, e a exibição dos quatro primeiros registros na ordem; ','0',29),(114,'B)  a ordenação dos registros de T, como especificado, e a exibição dos quatro primeiros registros, pois o segundo parâmetro é ignorado; ','0',29),(115,'C)  a ordenação dos registros de T, como especificado, e a exibição de oito registros a partir do quarto, na ordem; ','1',29),(116,'D)  a ordenação dos quatro primeiros registros de T a partir do oitavo, como especificado, e a exibição desses, na ordem.  ','0',29);
 
--- ENGENHARIA DE SOFTWARE ---


--- DESENVOLVIMENTO WEB ---

