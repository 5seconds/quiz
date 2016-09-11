<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar">
		
					<a class="navbar-brand page-scroll">Five Quiz</a>
		            <a class="navbar-brand page-scroll" href="ExibirHomeAdm">Página Inicial</a>
					<a class="navbar-brand page-scroll" href="ExibirListarUsuario">Listar Usuário</a>
					<a class="navbar-brand page-scroll" href="ExibirCadastroUsuarioADM">Cadastrar Usuário</a>
					<a class="navbar-brand page-scroll"href="ExibirCadastroPerguntas">Cadastrar Perguntas</a>
					<a class="navbar-brand page-scroll"href="ExibirListarPerguntas">Listar Perguntas</a>
		
					<ul class="nav navbar-nav navbar-right">
		
						<li><a class="page-scroll">Bem vindo,&nbsp; <b> ${usuarioLogado.nome}</b></a></li> 
						
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<li><a class="page-scroll" href="logout"> Sair </a></li>
		
					</ul>
				
		
		
		</nav>
	