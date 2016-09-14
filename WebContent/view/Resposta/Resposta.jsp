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

<title> Jogo </title>

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
<script type="text/javascript" src="view/js/Resposta.js"> </script>
</head>

<style type="text/css">
.mensagemResposta {
	font-family: sans-serif;
	font-style: bold;
	font-size: 25px;
	
}

.divPergunta {
	font-family: sans-serif;
	font-style: bold;
	background-color: black;
	color: white;
	padding-right:40px;
	padding-left: 40px;
	padding-bottom: 10px;
	padding-top: 10px;
	text-align: justify;
}
.teste{
	padding-right:400px;
	padding-left: 400px;
}

.divResposta {
	font-family: sans-serif;
	font-style: italic;
	padding-right: 300px;
	padding-left: 500px;
	text-align: justify;
}

.nivel {
	font-size: 20px;
	color: yellow;
}
</style>


</head>

<body >

	<c:import url="/view/comum/menu.jsp" />


<header> 
	<br>
	<br>
	<br>
	
	

	<form action="pesquisarPergunta" id="form">
		<center>
 			<span class="nivel"> Nível >> </span> 
			
			   <select name="nivel" id="nivel"	class="btn btn-primary  login-button">
				
				<option value=""> Selecione </option>

				<c:forEach items="${listaNivel}" var="obj">

					<option value="${obj.id}"
						
						<c:if test="${obj.id eq pergunta.nivel.id}"> selected="selected" </c:if>> ${obj.nome}

					</option>
				
				</c:forEach>
			</select>
			
			 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			 
			 <span class="nivel">	Disciplina >> </span>
			 
			  <select name="disciplina" id="disciplina"	class="btn btn-primary  login-button">

				<option value=""> Selecione </option>

				<c:forEach items="${listaDiciplina}" var="obj">

					<option value="${obj.id}"
					
							<c:if test="${obj.id eq pergunta.disciplina.id}">selected="selected"</c:if>>${obj.nome}
					
					</option>

				</c:forEach>
				
			</select>
			
			 <br> <br> 
			<div class="form-group ">
				
				<button type="submit"  class="btn btn-primary login-button"> Pesquisar </button>
			
			</div>

		</center>
	</form>

	<br>
	<br>
	<div class="mensagemCadastro" style="font-size: 20px; color: red; "> ${msg} </div>
	<br>
	<form class="form-horizontal" method="post" action="responder"	id="Form1">

		<input type="hidden" name="nivel" id="idNivel"	value="${pergunta.nivel.id}"> 
		<input type="hidden"name="disciplina" id="idDisciplina" value="${pergunta.disciplina.id}">
		<input type="hidden" id="idPergunta" name="idPergunta" value="">
		<input type="hidden" id="idResposta" name="idResposta" value="">

		<c:forEach var="pergunta" items="${listaPergunta}">
			
						<div class="teste">
							<h3 class="divPergunta" style="text-transform: uppercase;"> &nbsp;&nbsp;&nbsp;${pergunta.descricao}</h3>
						</div>
						
						<div class="form-group">
							<br />
							<c:forEach var="resposta" items="${pergunta.alternativas}">
			
								<div class="divResposta">
									<input type="radio" id="radioResposta" name="radioResposta"	value="${resposta.id}" required="required">
										
										<span class="mensagemResposta"> 
										
											&nbsp;&nbsp;${resposta.descricao}
										</span>
										<p></p>
								</div>
									
									<c:if
										test="${idPergunta eq pergunta.id and idResposta eq resposta.id}">
										 ${msg} 
									</c:if>
							
							</c:forEach>
						</div>
								
							<br> <br>
							
							<div class="container">
								<div id="div1" role="alert"	style="display: none">
								</div>
							</div>
						<br>
						<br>
						
						<nav>
							  <ul class="pager">
								    <li> <a href="anterior">Anterior</a> </li>
								    
								    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    
								    <button type="button" id="btn"class="btn btn-primary btn-xl page-scroll">Responder</button>
								    
								     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    
								    <li><a href="proximo">Proximo</a></li>
							  </ul>
						</nav>
						
						<br>
						<br>
		</c:forEach>
		
		
	</form>

	<br />
	<br />
	<br />
	<br />




</header>

</body>
</html>