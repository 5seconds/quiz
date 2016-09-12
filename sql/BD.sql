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

INSERT INTO `Perguntas` VALUES (13,'Segundo Pressman (2011), a defnição de defeito de software é um problema de qualidade encontrado.',1,1),(14,'Assinale a alternativa que não corresponde a um dos testes de software,realizados em softwares comerciais.',3,1),(15,' A função string do banco de dados MYSQL que retorna a posição da primeira ocorrência de uma string é denominada.',3,2),(16,'No MySQL, a função extractValue() extrai um valor de um string XML. Ela recebe dois argumentos. O segundo argumento usa uma expressão na notação: ',3,2),(17,'As tabelas que permitem a definição de Transactions e Cons- traints de chave estrangeira em MySQL devem ser configuradas como',3,2),(18,'No servidor MySQL, para apagar todos os logs binários, redefinir o arquivo de índice e criar um novo log binário, utiliza-se o',3,2),(19,'A função LAST_INSERT_ID, em MYSQL',3,2);

INSERT INTO `Alternativa` VALUES (49,'a) somente após a liberação de uso do software para os usuários fnais. ','1',13),(50,' b) antes de o software ser liberado aos usuários fnais.','0',13),(51,' c) na fase de revisão','0',13),(52,'d) na fase de levantamento de requisitos. ','0',13),(53,'a) Teste de unidade. ','0',14),(54,'b) Teste de validação. ','0',14),(55,' c) Teste de integração','0',14),(56,'d) Teste de volatilidade de requisitos ','1',14),(57,' a) STRCHR. ','0',15),(58,'b) RPAD. ','0',15),(59,'c) INSTR.','1',15),(60,'d) RTRIM.','0',15),(61,'a) Java ','0',16),(62,'b) SQL ','0',16),(63,'c) JavaScript','0',16),(64,'e) XPath ','1',16),(65,'a) MyISAM ','0',17),(66,'b) InnoDB ','1',17),(67,'c) DBTrans ','0',17),(68,'d) StrangDB ','0',17),(69,'a) DELETE LOGS ','0',18),(70,'b) TRUNCATE MASTER','0',18),(71,'c) RESET ALL ','0',18),(72,'d) RESET MASTER','1',18),(73,'a) retorna com o identificador do último octeto, dado um endereço de rede no formato IPv4,','0',19),(74,'b) utiliza o identificador da coluna informada para gerar um novo número de identificação.','0',19),(75,'c) retorna o identificador universal exclusivo para a tabela informada. ','0',19),(76,'d) retorna o último valor para uma coluna que tenha a propriedade de auto incremento. ','1',19);



