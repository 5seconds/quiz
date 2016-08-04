<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cadastro</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="StyleSheet" type="text/css"
	href="view/css/cadastroUsuario.css">
<link href="view/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>




	<c:import url="/view/Usuario/Menu.jsp" />



	<div class="mensagemCadastro">${mensagem}</div>


	<div class="container">
		<div class="wrapper">
			<form action="CadastrarUsuario" method="post" name="Login_Form"
				class="form-signin">
				<h3 class="form-signin-heading">Cadastre-se !</h3>
				<hr class="colorgraph">
				<br> <input type="text" class="form-control" name="nome"
					placeholder="Digite Seu Nome Completo" required="required"
					autofocus="" /> <br /> <input type="email" class="form-control"
					name="email" placeholder="Digite Seu E-mail" required="required"
					autofocus="" /> <br /> <input type="password" class="form-control"
					name="senha" placeholder="Digite Sua Senha" required="required"
					autofocus="" /> <br /> <input type="password" class="form-control"
					name="csenha" placeholder="Confirmar Senha" required="required" />

				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Login" type="Submit">Cadastrar</button>
				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="limpar" type="reset">Limpar</button>
			</form>
		</div>
	</div>






</body>
</html>