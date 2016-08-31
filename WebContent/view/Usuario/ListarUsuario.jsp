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

<title>Bem Vindo Five Quiz !</title>


<style type="text/css">

.pagina {

margin: 0px;


}

</style>





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
    
    <script type="text/javascript" src="view/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
   <header>
	<body>
	
		 <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand page-scroll" >Five Quiz</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="ExibirIndex">Home</a>
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
    <br> <br>
 <br>
 
 <div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Pesquisar Usuário</h1>
	               		<hr />
	               	</div>
	              
	            </div> 
	<table border='1' style='width: 100%;'>
		<tr style='background-color: #E6E6E6; font-weight: bold;'>
			<td> ID </td>
			<td> NOME </td>
			<td> EMAIL </td>
			<td> AÇÕES </td>
		</tr>
	
	<c:forEach var="usuario" items="${listarUsuario}">
		<tr>
	    	<td> ${usuario.id} </td>
	    	<td> ${usuario.nome} </td>
	    	<td> ${usuario.email} </td>
	    	<td>
	    		<a href='exibirAlterarUsuarioid?=${usuario.id}' class="btn btn-warning" role="button" >Alterar</a> &nbsp;
	    		<a href='removerUsuario?id=${usuario.id}' class="btn btn-danger" role="button" >Remover</a>
	    	</td>
	    </tr>
	</c:forEach>
	</table>

	
	



</header>

</body>

</html>





