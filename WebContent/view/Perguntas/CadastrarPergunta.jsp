<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title> Cadastro Perguntas</title>

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


<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#meuForm').validate({

			rules : {
				descricao : {
					required : true,
					minlength : 10

				},
				disciplina : {
					required : true
					
				},
				nivel : {
					required : true
					

				},
				resposta1 : {
					required : true,
					

				},
				resposta2 : {
					required : true,
					

				},
				resposta3 : {
					required : true,
					
					

				},
				resposta4 : {
					required : true,
					
					

				},
				optionsRadios : {
					required : true,
					
				}

			},
			messages : {
				descricao : {
					required : "Este campo é obrigatório",
					minlength : "A Pergunta deve conter no minimo 10 caracteres"

				},
				disciplina : {
					required : "Este campo é obrigatório",
					
				},
				nivel : {
					required : "Este campo é obrigatório",
					

				},
				resposta1 : {
					required : "Este campo é obrigatório",
					
				},
				resposta2 : {
					required : "Este campo é obrigatório",
					
				},
				resposta3 : {
					required : "Este campo é obrigatório",
					
					
				},
				resposta4 : {
					required : "Este campo é obrigatório",
					
				},

				optionsRadios : {
					required : "Este campo é obrigatório",
					
				}
			}

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
			<a class="navbar-brand page-scroll" href="ExibirListarUsuario">Listar Usuário</a>
			<a class="navbar-brand page-scroll" href="ExibirCadastroUsuarioADM">Cadastrar Usuário</a>
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


	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Cadastro de Perguntas</h1>
					<hr />
				</div>

			</div>
			<div class="main-login main-center">

				<div class="mensagemCadastro" style="font-size: 20px; color: yellow; ">${mensagem}</div>

				<form class="form-horizontal" method="post" action="CadastrarPerguntas" id="meuForm">

					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Pergunta</label>
							<div class="input-group">
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-comment" aria-hidden="true"></i>
								</span> 
								<input type="text" class="form-control" name="descricao" id="descricao" autofocus="" placeholder="Digite sua Pergunta"/>
							</div>
						
					</div>

					

					<label for="" class="cols-sm-2 control-label">
						 Disciplina
					</label> 
					
					<select name="disciplina" id="disciplina" class="btn btn-primary btn-lg btn-block login-button">

						<option value="">Selecione</option>
						<c:forEach items="${listaDisciplina}" var="obj">
							<option value="${obj.id}">${obj.nome}</option>
						</c:forEach>
					</select>
					 
					 </br> 
					
					<label for="" class="cols-sm-2 control-label">
						Nivel De Pergunta
					</label> 
					
					<select name="nivel" id="nivel" class="btn btn-primary btn-lg btn-block login-button">

						<option value="">Selecione</option>
						<c:forEach items="${listaNivel}" var="obj">
							<option value="${obj.id}">${obj.nome}</option>
						</c:forEach>
					</select> </br>
					
					
					</br> 
					
					 <label for="" class="cols-sm-2 control-label">Resposta 1</label>

					
					<div class="input-group">
						<span class="input-group-addon"> 
						
						<input type="radio" name="optionsRadios" id="optionsRadios" value="1" >
						</span> 
						<input type="text" name="resposta1" id="resposta1"  placeholder="Digite sua Resposta" autofocus="" class="form-control" >
					</div>


					 </br> 
					 
					 <label for="" class="cols-sm-2 control-label">Resposta 2</label>

					
					<div class="input-group">
						<span class="input-group-addon"> 
						
						<input type="radio" name="optionsRadios" id="optionsRadios" value="2" >
						</span> 
						<input type="text" name="resposta2" id="resposta2" placeholder="Digite sua Resposta" autofocus="" class="form-control" >
					</div>

					 </br> 
					 
					<label for="" class="cols-sm-2 control-label">Resposta 3</label>

				
					<div class="input-group">
						<span class="input-group-addon"> 
						
						<input type="radio" name="optionsRadios" id="optionsRadios" value="3" >
						
						</span> 
						<input type="text" name="resposta3" id="resposta3" placeholder="Digite sua Resposta" autofocus="" class="form-control" >
					</div>

					 </br>
					 
					  <label for="" class="cols-sm-2 control-label">Resposta 4</label>

					
					<div class="input-group">
						<span class="input-group-addon"> 
						
						<input type="radio" name="optionsRadios" id="optionsRadios" value="4">
						</span> 
						<input type="text" name="resposta4" id="resposta4" placeholder="Digite sua Resposta" autofocus="" class="form-control" >
					</div>



                            </br> </br>
					
					
					
					<div class="form-group ">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block login-button">Cadastrar</button>
					</div>

				</form>
			</div>
		</div>
	</div>


	</header>


</body>

</html>