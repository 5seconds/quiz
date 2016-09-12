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

<title>Listar Usuário</title>


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
		
		$("#nome").keyup(function() {
			var texto = $('#nome').val();
			var email = $('#email').val();
			$.post("PesquisarUsuario", {'nome' : texto, 'email' : email}, function(dados) {
				$('#tabelaListarUsuario').html(dados);
			});
		});

		$("#email").keyup(function() {
			var texto = $('#nome').val();
			var email = $('#email').val();
			$.post("PesquisarUsuario", {'nome' : texto, 'email' : email}, function(dados) {
				$('#tabelaListarUsuario').html(dados);
			});
		});
		
				
	});
	

</script>


	

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





