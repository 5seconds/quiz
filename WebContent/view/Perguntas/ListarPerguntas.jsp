<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="pt">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Listar Perguntas</title>


<style type="text/css">
.pagina {
	margin: 0px;
}
</style>





<!-- Bootstrap Core CSS -->
<link href="view/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="view/css/Form.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="view/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="view/css/magnific-popup.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="view/css/creative.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript" src="view/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		
		$("#pergunta").keyup(function() {
			var texto = $('#pergunta').val();
			
			$.post("PesquisarPergunta", {'pergunta' : texto, }, function(dados) {
				$('#tabelaListarPergunta').html(dados);
			});
		});

	});
</script>
</head>

<body id="page-top">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			        	
              <a class="navbar-brand page-scroll">Five Quiz</a>
              <a class="navbar-brand page-scroll" href="ExibirHomeAdm">Página Inicial</a>
			<a class="navbar-brand page-scroll" href="ExibirListarUsuario">Listar Usuario</a>
				
			 <a class="navbar-brand page-scroll"href="ExibirCadastroPerguntas">Cadastrar Perguntas</a>
			 <a class="navbar-brand page-scroll"href="ExibirListarPerguntas">Listar Perguntas</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">

				<li><a class="page-scroll"> <b>Bem vindo,&nbsp;
							${usuarioLogado.nome}</b></a></li> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
				<li><a class="page-scroll" href="logout"> Sair </a></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>



    <header>
        
	<br>
	<br>
	<br>

	<div class="panel-heading">

		<div class="panel-title text-center">
			<h1 class="title">Pesquisar Perguntas</h1>
			<hr />
		</div>
	</div>
	
	
	<div  style='color: black; font-weight: bold;'>
    	Pergunta: <input type="text"  id="pergunta" name="pegunta">
    
	</div>


	
	
	<br><br><br>
	
<center>

	<table id="tabelaListarPergunta" border='1' style='width: 80%; text-align: center'>
		<thead>
			<tr >
				<th > ID</th>
				<th >PERGUNTA</th>
				<th >NÍVEL</th>
				<th >DISCIPLINA </th>
				<th > AÇÕES </th>
			</tr>
		</thead>

		<c:forEach var="p" items="${listarPergunta}">
			<tr>
				<td>${p.id}</td>
				<td>${p.descricao}</td>
				<td>${p.nivel}</td>
				<td>${p.disciplina}</td>
				<td>	
					<a href='exibirAlterarPergunta?id=${p.id}'	class="btn btn-info" role="button"> Alterar </a> &nbsp; 
					<a href='removerPergunta?id=${p.id}' class="btn btn-danger" role="button"> Remover </a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</center>
	
	
	
</header>

</body>

</html>





