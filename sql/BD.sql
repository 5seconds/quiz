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
insert into Disciplina (nome) values ("Programação");

insert into Nivel (nome) values ("Básico");
insert into Nivel (nome) values ("Médio");
insert into Nivel (nome) values ("Expert");


-------------------------  PERGUNTAS ----------------------------

--- BANCO DE DADOS ---

INSERT INTO `Perguntas` VALUES (15,' A função string do banco de dados MYSQL que retorna a posição da primeira ocorrência de uma string é denominada.',3,2),(16,'No MySQL, a função extractValue() extrai um valor de um string XML. Ela recebe dois argumentos. O segundo argumento usa uma expressão na notação: ',3,2),(17,'As tabelas que permitem a definição de Transactions e Cons- traints de chave estrangeira em MySQL devem ser configuradas como',3,2),(18,'No servidor MySQL, para apagar todos os logs binários, redefinir o arquivo de índice e criar um novo log binário, utiliza-se o',3,2),(19,'A função LAST_INSERT_ID, em MYSQL',3,2),(20,'Na criação de um banco de dados relacional, por suas características, podem ser utilizados como chave primária ',1,2),(21,'A unidade lógica de armazenamento de banco de dados usada para agrupar as demais estruturas lógicas relacionadas, apenas especificando a localização de armazenamento do banco de dados, é denominada ?',2,2),(22,' É um comando do tipo DDL (Data Definition Language) no SQL:',1,2),(23,'Em um cluster, as',1,2),(24,'Qual o comando no Mysql para inserir, alterar e listar dados de uma tabela, respectivamente?',1,2),(25,'O Projeto de um banco de dados é normalmente dividido em fases. Assinale a afirmativa correta.',2,2),(26,'No Modelo Relacional de Dados, o mecanismo fundamental para manter a consistência dos dados e evitar registros órfãos é denominado',2,2),(27,'O SQL Server NÃO possui dados para armazenar',1,2),(29,'No MySQL, o comando SQL \" SELECT* FROM T ORDER BY A DESC LIMIT 4,8\" provoca: ',2,2);

INSERT INTO `Alternativa` VALUES (57,' a) STRCHR. ','0',15),(58,'b) RPAD. ','0',15),(59,'c) INSTR.','1',15),(60,'d) RTRIM.','0',15),(61,'a) Java ','0',16),(62,'b) SQL ','0',16),(63,'c) JavaScript','0',16),(64,'e) XPath ','1',16),(65,'a) MyISAM ','0',17),(66,'b) InnoDB ','1',17),(67,'c) DBTrans ','0',17),(68,'d) StrangDB ','0',17),(69,'a) DELETE LOGS ','0',18),(70,'b) TRUNCATE MASTER','0',18),(71,'c) RESET ALL ','0',18),(72,'d) RESET MASTER','1',18),(73,'a) retorna com o identificador do último octeto, dado um endereço de rede no formato IPv4,','0',19),(74,'b) utiliza o identificador da coluna informada para gerar um novo número de identificação.','0',19),(75,'c) retorna o identificador universal exclusivo para a tabela informada. ','0',19),(76,'d) retorna o último valor para uma coluna que tenha a propriedade de auto incremento. ','1',19),(77,' a) NOME, MATRÍCULA e CÓDIGO_ PEÇA ','0',20),(78,'\r\nb) NOME, SALÁRIO e CARGO_FUNÇÃO\r\n ','0',20),(79,'c) CPF, MATRÍCULA e CÓDIGO_PEÇA\r\n ','1',20),(80,' d) CPF, SALÁRIO e CARGO_FUNÇÃO ','0',20),(81,'a) schema object. ','0',21),(82,'b) data block.  ','0',21),(83,'c)  extent. ','0',21),(84,'d) tablespace.  ','1',21),(85,' a) SELECT. ','0',22),(86,' b) DELETE. ','0',22),(87,' c) INSERT. ','0',22),(88,' d) CREATE. ','1',22),(89,'a) colunas das tabelas relacionadas são chamadas key hashing.  ','0',23),(90,' b) linhas das tabelas relacionadas são chamadas key index. \r\n','0',23),(91,'c) colunas das tabelas relacionadas são chamadas column key.  ','0',23),(92,'d) colunas das tabelas relacionadas são chamadas cluster key. ','1',23),(93,' A) ALTER TABLE, UPDATE, SELECT','0',24),(94,' B) INSERT INTO, ALTER TABLE, SELECT ','1',24),(95,' C) INSERT INTO, ALTER TABLE, UPDATE','0',24),(96,' D) INSERT INTO, SELECT, ALTER TABLE','0',24),(97,'A) Projeto Conceitual: é analisado um modelo de dados em função do SGBD definido e usa modelo de dados para descrever a realidade.  ','0',25),(98,'B) Projeto Lógico: linguagem usada para especificar esquemas lógicos, consiste em criar um modelo físico de dados a partir do modelo conceitual independente do SGBD escolhido. ','0',25),(99,'C) Projeto Físico: descreve estruturas de armazenamento e métodos de acesso. ','1',25),(100,'D)  Projeto Conceitual: define como os dados são armazenados no SGBD específico.','0',25),(101,'A) Integridade Relacional.\r\n ','0',26),(102,'B) Integridade de Chave.  ','0',26),(103,'C)  Dependência Funcional.','0',26),(104,'D) Integridade Referencial. ','1',26),(105,'  A) ALTER TABLE, UPDATE, SELECT','0',27),(106,'  B) INSERT INTO, ALTER TABLE, SELECT ','1',27),(107,'  C) INSERT INTO, ALTER TABLE, UPDATE','0',27),(108,'  D) INSERT INTO, SELECT, ALTER TABLE','0',27),(113,'A)  a ordenação dos oito primeiros registros de T, como especificado, e a exibição dos quatro primeiros registros na ordem; ','0',29),(114,'B)  a ordenação dos registros de T, como especificado, e a exibição dos quatro primeiros registros, pois o segundo parâmetro é ignorado; ','0',29),(115,'C)  a ordenação dos registros de T, como especificado, e a exibição de oito registros a partir do quarto, na ordem; ','1',29),(116,'D)  a ordenação dos quatro primeiros registros de T a partir do oitavo, como especificado, e a exibição desses, na ordem.  ','0',29);
 
--- ENGENHARIA DE SOFTWARE ---


--- Programação  ---
INSERT INTO `Perguntas` VALUES (1,'Framework para desenvolvimento de aplicações Java EE, que integra tecnologias JSF e EJB 3, entre outras, resultando num framework unificado, completo e sofisticado. Trata-se de ',1,3),(2,'Em uma aplicação Java que acessa banco de dados, as interfaces Connection, Statement e ResultSet devem ser importadas do pacote',1,3),(3,'Para definição e manipulação de uma exceção em Java, devem constar no programa, obrigatoriamente, os termos ',1,3),(4,'No Java, é uma interface que não permite elementos duplicados e modela a abstração matemática de conjunto. Contém apenas métodos herdados da interface Collection e adiciona a restrição de que elementos duplicados são proibidos.\r\n\r\nA interface citada é: ',1,3),(5,'É um framework MVC utilizado no desenvolvimento de aplicações para a internet de forma visual, que utiliza o recurso de arrastar e soltar os componentes na tela para definir suas propriedades:',1,3),(6,'O framework JavaServer Faces (JSF) é utilizado no desenvolvimento de aplicações web que utiliza o design pattern MVC. O JSF',2,3),(7,'Sobre o framework JavaServer Faces é correto afirmar: ',2,3),(8,'No JavaServer Pages a tag <%=conteúdo %>é uma',2,3),(9,'No cilco de vida do JSF copiar os parâmetros de requisição para valores submetidos pelos componentes, é a tarefa típica da fase ',2,3),(10,'O JSF extrai todos os valores digitados pelo usuário e guarda esse valor nos seus respectivos componentes. Se o valor digitado não coincidir com o componente, um erro vai ser adicionado na classe FacesContext e será mostrado na fase Render Response Phase.\r\n\r\nNo ciclo de vida do JSF trata-se de um evento típico da fase ',2,3),(11,'Os três estados de objeto definidos pelo framework Hibernate são:',3,3),(12,'Por suas características, Hibernate 3.5 constitui uma ferramenta com a finalidade de realizar o seguinte tipo de mapeamento ',3,3),(13,'No mapeamento hibernate, pode-se utilizar o recurso das collections, incluindo as indexadas. São exemplos de collections indexadas',3,3),(14,'Sobre o framework de mapeamento objeto/relacional Hibernate, é correto afirmar que',3,3);
INSERT INTO `Alternativa` VALUES (1,'a) EJB 3.\r\n\r\n\r\n','0',1),(2,' b) Hibernate 3.','0',1),(3,' c) Jboss Portlets.','0',1),(4,' d) Jboss Seam 2. ','1',1),(5,' a) java.jdbc.\r\n\r\n\r\n','0',2),(6,' b) java.beans.','0',2),(7,' c) javax.jdbc.','0',2),(8,' d) java.sql. ','1',2),(9,' a) try e catch. ','1',3),(10,' b) try e finally.\r\n\r\n','0',3),(11,' c) finally e catch.','0',3),(12,' d) finally e retry. ','0',3),(13,' a) List.\r\n\r\n\r\n','0',4),(14,' b) Set.','1',4),(15,' c) ArrayList.','0',4),(16,' d) Map. ','0',4),(17,' a) Enterprise JavaBeans.\r\n\r\n\r\n','0',5),(18,' b) JavaServer Faces.','1',5),(19,' c) Java 2 Enterprise Edition.','0',5),(20,' d) Servlets. ','0',5),(21,'\r\na) disponibiliza controles pré-construídos e código para manipular eventos, estimulando o uso de código Java convencional no componente View do MVC.\r\n\r\n\r\n\r\n','0',6),(22,'b) recebe requisições dos componentes da View do MVC, através do servlet FaveServerServlet.','0',6),(23,'c) armazena os mapeamentos das ações e regras de navegação em projetos JSF nos arquivos WEB- INF.xml e FACES-CONFIG.xml.\r\n','0',6),(24,'d) possui bibliotecas que suportam Ajax (Asynchronous JavaScript And XML). ','1',6),(25,' a) A grande limitação do JSF é a dificuldade de integração com outros frameworks como Spring, JPA e EJB.\r\n\r\n\r\n','0',7),(26,' b) Expression Language (EL) é a linguagem utilizada para apresentação de conteúdo em aplicações que utilizam JSF. Sua principal limitação é a impossibilidade de acessar valores e métodos em beans gerenciados.','0',7),(27,'c) Facelets é uma parte da especificação JSF e também a tecnologia para implementar as regras de negócio em aplicações que utilizam JSF.','0',7),(28,' d) Disponibiliza as bibliotecas de tags core e html para criar as páginas que compõem a interface do usuário. ','1',7),(29,' a) Directive tag.\r\n\r\n\r\n','0',8),(30,' b) Scriplet tag.','0',8),(31,' c) Action tag.','0',8),(32,' d) Expression tag. ','1',8),(33,' a) Restaurar Visão (Restore view).\r\n\r\n\r\n','0',9),(34,' b) Invocar aplicação (Invoke application).','0',9),(35,' c) Aplicar valores de requisição (Apply request values).','1',9),(36,' d) Processar validações (Process validation). ','0',9),(37,' a) Process Validations Phase.\r\n\r\n\r\n','0',10),(38,' b) Restore View Phase.','0',10),(39,' c) Apply Request Values Phase.','1',10),(40,' d) Update Model Values Phase. ','0',10),(41,'  a) Temporário (Temporary), Permanente (Permanent) e Resiliente (Resilient).\r\n\r\n\r\n','0',11),(42,' b) Transiente (Transient), Persistente (Persistent) e Resiliente (Resilient).','0',11),(43,' c) Temporário (Temporary), Persistente (Persistent) e Destacado (Detached).','0',11),(44,' d) Transiente (Transient), Persistente (Persistent) e Destacado (Detached). ','1',11),(45,' a) objeto/relacional para Java.\r\n\r\n\r\n\r\n','1',12),(46,'     b) gerencial/operacional para sites interativos textuais.','0',12),(47,'     c) entidade/relacionamento para modelagem de dados.','0',12),(48,'     d) lógico/físico para desenvolvimento por meio da prototipação.','0',12),(49,' a) Arrays, Bags e Records.\r\n\r\n\r\n','0',13),(50,' b) Records, Lists e Maps.','0',13),(51,' c) Maps, Arrays e Bags.','0',13),(52,' d) Lists, Maps e Arrays. ','1',13),(53,' \r\na) um objeto se encontra no estado detached quando tiver sido criado com o construtor new, estando ainda desvinculado de qualquer session (sessão) do Hibernate.\r\n\r\n\r\n','0',14),(54,' b) um objeto gerenciado pelo Hibernate se encontra no estado transient quando tiver sido criado vinculado a uma session (sessão) do Hibernate, mas ainda não tiver sido gravado no banco de dados.','0',14),(55,' c) um objeto gerenciado pelo Hibernate se encontra no estado persistent quando a session (sessão) a que o mesmo estava vinculado foi fechada e, em conseqüência, o objeto já foi gravado no banco de dados.','0',14),(56,' d) uma session do Hibernate não é thread-safe, o que significa que pode gerar resultados imprevisíveis e instabilidade se uma instância for utilizada, simultaneamente, por mais de uma thread da aplicação sem a devida sincronização do acesso à mesma. ','1',14);

