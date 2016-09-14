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

<title>Listar Usuarios</title>

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
<script type="text/javascript" src="view/js/ListarUsuario.js"> </script>

<style type="text/css">
.pagina {
	margin: 0px;
}

.linha{

text-align: center; 
font-size: 20px;
color: yellow;
font-size: 20px;
}

.linha2{

text-align: center; 
font-size: 22px;
color: white;
font-size: 22px;

}
.tabela { 

border: 1px solid #000; 
border-collapse: collapse; }
</style>
</head>

<body >

	<c:import url="/view/comum/menuADM.jsp" />




    <header>
        
	<br>
	<br>
	<br>

	<div class="panel-heading">

		<div class="panel-title text-center">
			<h1 class="title">Pesquisar Usuário</h1>
			<hr />
		</div>
	</div>
	<br><br>
	<center>
	
	<div  style='color: black; font-weight: bold;'>
    	 <input type="text"  id="nome" name="nome" autofocus="" placeholder="Digite o nome">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="email"  id="email" name="email" autofocus="" placeholder="Digite o email">
	</div>
</center>

	
	
	<br><br><br>
	
<center>

	<table class="tabela" id="tabelaListarUsuario" border='0' style='  width: 60%; text-align: center'>
		<thead>
			<tr >
				<th class="linha"> ID</th>
				<th class="linha" >NOME</th>
				<th  class="linha">EMAIL</th>
				<th  class="linha">AÇÕES</th>
			</tr>
		</thead>
		<c:forEach var="usuario" items="${listarUsuario}">
			<tr >
				
				<td class="linha2">${usuario.id}</td>
				<td class="linha2">${usuario.nome}</td>
				<td class="linha2">${usuario.email}</td>
				<td class='linha2'>	
					<a href="removerUsuario?id=${usuario.id}"	onclick=" return confirm('Confirma exclusão do registro')"class="btn btn-danger" role="button">R</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</center>

	
	
	
</header>

</body>

</html>





