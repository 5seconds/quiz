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

<title>Cadastro Usuario - ADM</title>

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
<script type="text/javascript" src="view/js/CadastroUsuario.js"> </script>
</head>  
      
</head>

<body >
<c:import url="/view/comum/menuADM.jsp" />
    
    <header>
          
        	<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Cadastre-se</h1>
	               		<hr />
	               	</div>
	              
	            </div> 
				<div class="main-login main-center">
				
				<div class="mensagemCadastro" style="font-size: 20px; color: yellow; "> ${mensagem} </div>
				
					<form class="form-horizontal" method="post" action="CadastrarUsuarioADM" id="Form1">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label"> Nome 
							
							</label>
							
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
									
									<input type="text" class="form-control" name="nome" id="nome" maxlength="40" placeholder="Digite seu nome" autofocus=""/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">E-mail</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i></span>
									
									<input type="email" class="form-control" name="email" id="email"  placeholder="Digite seu E-mail"  autofocus=""/>
								</div>
							</div>
						</div>

						

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Senha</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
									
									<input type="password" class="form-control" name="senha" id="senha"  placeholder="Digite sua senha" autofocus=""/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirme sua senha</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
									
									<input type="password" class="form-control" name="confsenha" id="confsenha"  placeholder="Confirme sua senha" autofocus=""/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button"> Cadastrar </button>
						</div>
						<div class="login-register">
				            <a href="ExibirLogin" style="font-size: 17px;"><b> Login </b></a>
				         </div>
					</form>
				</div>
			</div>
		</div>
        
        
    </header>

   
</body>

</html>
