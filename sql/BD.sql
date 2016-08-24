create database projeto;

create table TipoUsuario(

id int primary key auto_increment,
nome varchar(50) not null

);

create table Usuario(

id int primary key auto_increment,
nome varchar(100) not null,
email varchar(50) not null unique,
senha varchar(15) not null,
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

foreign key (idNivelFK) references Nivel(id),
foreign key (idDisciplinaFK) references Disciplina(id)
);

create table Alternativa(

id int primary key auto_increment,
descricao varchar(500) not null,
alterCorreta varchar(200) not null,
idPerguntaFK int,

foreign	key (idPerguntaFK) references Perguntas(id)
);


-------------------------------- INSERT ------------------------------------------------------------------
insert into TipoUsuario (nome) values ("Usuario Normal");
insert into TipoUsuario (nome) values ("Usuario ADM");

insert into Usuario (nome,email,senha,tipoUsuarioFk) values ("Administrador", "administrador@adm.com","adm123",2);

insert into Disciplina (nome) values ("Engenharia de Software");
insert into Disciplina (nome) values ("Desenvolvimento Web");
insert into Disciplina (nome) values ("Lógica de Programação");

insert into Nivel (nome) values ("Básico");
insert into Nivel (nome) values ("Médio");
insert into Nivel (nome) values ("Expert");




