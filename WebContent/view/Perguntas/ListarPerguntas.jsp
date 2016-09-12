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

.linha {
	text-align: center;
	font-size: 20px;
	color: yellow;
	font-size: 20px;
}

.linha2 {
	text-align: center;
	font-size: 22px;
	color: white;
	font-size: 20px;
}

.tabela {
	border: 1px solid #000;
	border-collapse: collapse;
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

		$("#descricao").keyup(function() {
			var texto = $('#descricao').val();
			$.post("AjaxPergunta", {
				'descricao' : texto,
			}, function(dados) {
				$('#tabelaListarPergunta').html(dados);
			});
		});
	});
</script>

</head>

<body >

	<c:import url="/view/comum/menuADM.jsp" />




	<header> <br>
	


	<div class="panel-heading">

		<div class="panel-title text-center">
			<h1 class="title">Pesquisar Perguntas</h1>
			<hr />
		</div>
	</div>




	<br>
	<br>

	<center>

		
		<div style='color: black; font-weight: bold; margin-left: 500px; margin-right: 500px' class="col-xs-6">
		
			<input type="text" class="form-control " id="descricao" name="descricao" autofocus=""		placeholder="Digite a pergunta">

		</div>
		<br>
		<br>
		<br>
		<br>
	


		<table  id="tabelaListarPergunta" class="table " style="background-color:black ;" >
			<thead >
				<tr >
					<th style="width: 3%; vertical-align: middle; text-align: center; font-size: 20px;">ID</th>
					<th style="width: 50%; vertical-align: middle; text-align: center; font-size: 20px;">PERGUNTA</th>
					<th style="width: 5%; vertical-align: middle; text-align: center; font-size: 20px;">NÍVEL</th>
					<th style="width: 8%; vertical-align: middle; text-align: center; font-size: 20px;">DISCIPLINA</th>
					<th style="width: 5%; vertical-align: middle; text-align: center; font-size: 20px;">AÇÕES</th>
				</tr>
			</thead>

			<c:forEach var="pergunta" items="${LISTAR}">
				<tr>
					<td style="width: 3%; vertical-align: middle; text-align: center; font-size: 15px;" >${pergunta.id}</td>
					<td style="width: 50%; vertical-align: middle; text-align: center; font-size: 20px;">${pergunta.descricao}</td>
					<td style="width: 5%; vertical-align: middle; text-align: center; font-size: 15px; color: yellow;">${pergunta.nivel.nome}</td>
					<td style="width: 8%; vertical-align: middle; text-align: center; font-size: 15px;  color: pink;">${pergunta.disciplina.nome}</td>
					<td style="width: 5%; vertical-align: middle; text-align: center; font-size: 15px;">
					<a href='PerguntabuscarPorId?id=${pergunta.id}'	class="btn btn-warning" role="button">E</a> &nbsp;

					<a href='removerPergunta?id=${pergunta.id}'	onclick=" return confirm('Confirma exclusão do registro')"class="btn btn-danger" role="button">R</a></td>
				</tr>
			</c:forEach>
		</table>

	</center>



	</header>

</body>

</html>





