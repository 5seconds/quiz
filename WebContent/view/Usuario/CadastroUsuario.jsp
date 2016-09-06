<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cadastre-se!</title>

    <!-- Bootstrap Core CSS -->
    <link href="view/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="view/css/Form.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="view/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

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
    
     
      <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js"></script> 
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script> 
      <script type="text/javascript">
      $(document).ready(function(){
            $('#Form1').validate({

                rules:{
                       nome:{
                        required:true,
                        minlength:5

                       },
                        email:{
                          required:true,
                          email:true,
                         remote:"view/Usuario/verificarEmail.jsp"
                       },
                        senha:{
                          required:true,
                          rangelength:[5,20]

                       },
                       confsenha:{
                           required:true,
                           equalTo: "#senha"

                       }
                       

                },
                messages:{
                         nome:{
                        required:"Este campo é obrigatório",
                        minlength:"O nome deve conter no mínimo 5 caracteres"

                       },
                        email:{
                          required:"Este campo é obrigatório",
                          email:"Informe um email válido",
                          remote:"Email já cadastrado"
                       },
                        senha:{
                          required:"Este campo é obrigatório",
                          rangelength:"Sua senha deve ter 5 a 20 caracteres"

                       },
                       confsenha:{
                           required:"Esté Campo é obrigatório",
                           equalTo: "As senhas estão diferentes!  "

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
              
                <a class="navbar-brand page-scroll">Five Quiz</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="ExibirIndex">Página Inicial</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="ExibirLogin">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="ExibirCadastrarUsuario">Cadastre-se</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
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
				
					<form class="form-horizontal" method="post" action="CadastrarUsuario" id="Form1">
						
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
