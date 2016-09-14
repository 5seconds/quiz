<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Cadastrar Pergunta</title>

<!-- Bootstrap Core CSS -->
<link href="view/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="view/css/Form.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="view/css/font-awesome.min.css" rel="stylesheet"	type="text/css">
<link	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- Plugin CSS -->
<link href="view/css/magnific-popup.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="view/css/creative.min.css" rel="stylesheet">

<script type="text/javascript"	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js"></script>
<script type="text/javascript"	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="view/js/ListarPerguntas.js"> </script>

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

		<form action="ExibirListarPerguntas" id="form">
		<center>

			<span class="nivel"> Nível >> </span> <select name="nivel" id="nivel"
				class="btn btn-primary  login-button">
				<option value="">Selecione</option>

				<c:forEach items="${listaNivel}" var="obj">

					<option value="${obj.id}"
						<c:if test="${obj.id eq pergunta.nivel.id}">selected="selected"</c:if>>${obj.nome}

					</option>
				</c:forEach>
			</select> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span class="nivel">
				Disciplina >> </span> <select name="disciplina" id="disciplina"
				class="btn btn-primary  login-button">

				<option value="">Selecione</option>

				<c:forEach items="${listaDiciplina}" var="obj">

					<option value="${obj.id}"
						<c:if test="${obj.id eq pergunta.disciplina.id}">selected="selected"</c:if>>${obj.nome}
					</option>

				</c:forEach>
			</select> <br> <br> <br>
			<div class="form-group ">
				<button type="submit" class="btn btn-primary login-button">Pesquisar</button>
			</div>

		</center>
	</form>

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

			<c:forEach var="pergunta" items="${listaPergunta}">
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





