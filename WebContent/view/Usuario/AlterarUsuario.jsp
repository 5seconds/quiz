<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Usuario</title>

 <link rel="StyleSheet" type="text/css" href="view/css/alterar.css">
 <link href="view/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>


</head>
<body class="corbody">


	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a
			href="ExibirCadastrarADM">Cadastrar Usuarios</a></li>
		<li role="presentation"><a href="listarADM">Lista Usuarios</a></li>
		
	</ul>
	
	
	
	<div class="mensagemAlterar"> ${mensagem} </div>

	<hr>
	<h3 class="titulo">Alterar Produto</h3>
	<hr>
	
	<div class="container">

<div class="row">

    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    
             
        <form  role="form" action="alterarADM" method="post">
		
			<h2> Alterar Usuario <small></small></h2>
			<hr class="colorgraph">
			
			</br> 
			
			<input type="hidden" name="id" value="${usuario.id}">
			
	
			<div class="form-group">
				<input type="text" name="nome" value="${usuario.nome}" id="display_name" class="form-control input-lg" placeholder="Digite seu Nome" tabindex="3">
			</div>
			
			<div class="form-group">
				<input type="email" name="email" value="${usuario.email}" id="email" class="form-control input-lg" placeholder="Digite Seu Email" tabindex="4">
			</div>
			
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="senha" value="${usuario.senha}" id="password" class="form-control input-lg" placeholder="Digite Sua Senha" tabindex="5">
					</div>
				</div>
				
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="senhaConfirme" id="password_confirmation" class="form-control input-lg" placeholder="Confirme Sua Senha" tabindex="6">
					</div>
				</div>
			</div>
		
			
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Enviar" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				<div class="col-xs-12 col-md-6"><input type="reset" class="btn btn-success btn-block btn-lg" value="Limpar"></div>
			</div>
		</form>
	</div>
</div>
	

</body>
</html>