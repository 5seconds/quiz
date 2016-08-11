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

<title>Cadastro Perguntas !</title>

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
		$('#Form1').validate({

			rules : {
				nome : {
					required : true,
					minlength : 5

				},
				email : {
					required : true,
					email : true
				},
				senha : {
					required : true,
					rangelength : [ 5, 10 ]

				},
				confsenha : {
					required : true,
					equalTo : "#senha"

				}

			},
			messages : {
				nome : {
					required : "Este campo é obrigatório",
					minlength : "O nome deve ter no minimo 5 caracteres"

				},
				email : {
					required : "Este campo é obrigatório",
					email : "Informe um email válido"
				},
				senha : {
					required : "Este campo é obrigatório",
					rangelength : "Sua senha deve ter 5 a 10 caracteres"

				},
				confsenha : {
					required : "Esté Campo é obrigatório",
					equalTo : "As senhas diferem, verifique"

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
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			 <a class="navbar-brand page-scroll" href="ExibirListarUsuario" >Listar Usuario</a>
                <a class="navbar-brand page-scroll" href="ExibirCadastroPerguntas" >Cadastrar Perguntas</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				                      
                    <li>
                        <a class="page-scroll" > <b>Bem vindo,   ${usuarioLogado.nome}</b></a>
                    </li>
                    &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                    <li>
                        <a class="page-scroll" href="logout"> Sair </a>
                    </li>
                    
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

				<div class="mensagemCadastro">${mensagem}</div>

				<form class="form-horizontal" method="post"	action="CadastrarPerguntas" id="Form1">

					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Pergunta</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-comment" aria-hidden="true"></i></span>
									
					 <input	type="text" class="form-control" name="descricao" id=""	placeholder="Digite sua Pergunta" required="required"autofocus="" />
							</div>
						</div>
					</div>

					<label for="" class="cols-sm-2 control-label">Disciplina</label> 
					<select		class="btn btn-primary btn-lg btn-block login-button">
						<option>Mustard</option>
						<option>Ketchup</option>
						<option>Relish</option>
					</select> </br>

					<div class="radio">
						<label> <input type="radio" name="optionsRadios"id="optionsRadios1" value="option1" required="required"autofocus="" >&nbsp; 2 Respostas
						</label>
					</div>

					<div class="radio">
						<label> 
						<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" required="required"autofocus="" >&nbsp; 3 Respostas
						</label>
					</div>


					<div class="radio">
						<label> 
						<input type="radio" name="optionsRadios" id="optionsRadios2" value="option3" required="required"autofocus="" >&nbsp; 4 Respostas
						</label>
					</div>


					</br> </br> <label class="radio-inline"> 
					<input type="radio"	name="inlineRadioOptions" id="inlineRadio1" value="option1">
						Basíco

					</label> <label class="radio-inline">
					 <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
						Médio

					</label> <label class="radio-inline"> 
					<input type="radio"	name="inlineRadioOptions" id="inlineRadio3" value="option3">
						Expert

					</label> </br> </br> <label for="" class="cols-sm-2 control-label">Resposta 1</label>

					</br>


					<div class="input-group">
						<span class="input-group-addon"> <input type="radio"
							name="optionsRadios" id="optionsRadios2" value="option1">
						</span> 
						<input type="text" placeholder="Digite sua Resposta" 	required="required"autofocus="" class="form-control" aria-label="...">
					</div>


					</label> </br> </br> <label for="" class="cols-sm-2 control-label">Resposta 2</label>

					</br>


					<div class="input-group">
						<span class="input-group-addon"> <input type="radio"
							name="optionsRadios" id="optionsRadios2" value="option2">
						</span> 
						<input type="text" placeholder="Digite sua Resposta"required="required"autofocus=""	class="form-control" aria-label="...">
					</div>

					</label> </br> </br> <label for="" class="cols-sm-2 control-label">Resposta 3</label>

					</br>


					<div class="input-group">
						<span class="input-group-addon"> <input type="radio"
							name="optionsRadios" id="optionsRadios2" value="option3">
						</span> 
						<input type="text" placeholder="Digite sua Resposta"required="required"autofocus=""	class="form-control" aria-label="...">
					</div>

					</label> </br> </br> <label for="" class="cols-sm-2 control-label">Resposta 4</label>

					</br>


					<div class="input-group">
						<span class="input-group-addon">
						 <input type="radio" name="optionsRadios" id="optionsRadios2" value="option4">
						</span> 
						<input type="text" placeholder="Digite sua Resposta"required="required"autofocus=""	class="form-control" aria-label="...">
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