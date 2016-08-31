<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jogo</title>


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
<style type="text/css">
.funkyradio div {
	clear: both;
	overflow: hidden;
	margin-left: 300px;
	margin-right: 300px;
	color: white;
	font-size: 25px;
}

.funkyradio div:hover {
	color: #ccc;
}

.funkyradio label {
	width: 100%;
	border-radius: 3px;
	border: 1px solid #D1D3D4;
	font-weight: normal;
}

.funkyradio input[type="radio"]:empty, .funkyradio input[type="checkbox"]:empty
	{
	display: none;
}

.funkyradio input[type="radio"]:empty ~ label, .funkyradio input[type="checkbox"]:empty 
	 ~ label {
	position: relative;
	line-height: 2.5em;
	text-indent: 3.25em;
	margin-top: 2em;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

.funkyradio input[type="radio"]:empty ~ label:before, .funkyradio input[type="checkbox"]:empty 
	 ~ label:before {
	position: absolute;
	display: block;
	top: 0;
	bottom: 0;
	left: 0;
	content: '';
	width: 2.5em;
	background: #D1D3D4;
	border-radius: 3px 0 0 3px;
}

.funkyradio input[type="radio"]:checked ~ label:before, .funkyradio input[type="checkbox"]:checked 
	 ~ label:before {
	content: '\2714';
	text-indent: .9em;
	color: #fff;
	background-color: #ccc;
}

.funkyradio-primary input[type="radio"]:checked ~ label:before,
	.funkyradio-primary input[type="checkbox"]:checked ~ label:before {
	color: #fff;
	background-color: #337ab7;
}

.funkyradio-success input[type="radio"]:checked ~ label:before,
	.funkyradio-success input[type="checkbox"]:checked ~ label:before {
	color: #fff;
	background-color: #5cb85c;
}

.funkyradio-danger input[type="radio"]:checked ~ label:before,
	.funkyradio-danger input[type="checkbox"]:checked ~ label:before {
	color: #fff;
	background-color: #d9534f;
}
</style>



</head>

<body id="page-top">


	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">

				<li><a class="page-scroll"> <b>Bem vindo,
							${usuarioLogado.nome}</b></a></li> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
				<li><a class="page-scroll" href="logout"> Sair </a></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<header> <br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>





	<form class="form-horizontal" method="post" action="responder"
		id="Form1">


		<c:forEach var="pergunta" items="${listaPergunta}">


			<div class="form">${pergunta.descricao}</div>

			<div class="form-group">


				<c:forEach var="resposta" items="${pergunta.alternativas}">

					<div class="radio">
						<label><input type="radio" name="radio"
							value="${resposta.id}">${resposta.descricao}</label>
					</div>
					<div class="mensagemCadastro">${msg}</div>


				</c:forEach>
			</div>
			<br>
			<br>
			<button type="submit" class="btn btn-primary btn-xl page-scroll">Responder
			</button>

			<br>
			<br>

		</c:forEach>






	</form>

	</br>
	</br>
	</br>
	</br>


	</header>

</body>
</html>