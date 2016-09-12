<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title> Cadastro Perguntas</title>

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


<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#meuForm').validate({

			rules : {
				descricao : {
					required : true,
					minlength : 10

				},
				disciplina : {
					required : true
					
				},
				nivel : {
					required : true
					

				},
				resposta1 : {
					required : true,
					

				},
				resposta2 : {
					required : true,
					

				},
				resposta3 : {
					required : true,
					
					

				},
				resposta4 : {
					required : true,
					
					

				},
				optionsRadios : {
					required : true,
					
				}

			},
			messages : {
				descricao : {
					required : "Este campo é obrigatório",
					minlength : "A Pergunta deve conter no minimo 10 caracteres"

				},
				disciplina : {
					required : "Este campo é obrigatório",
					
				},
				nivel : {
					required : "Este campo é obrigatório",
					

				},
				resposta1 : {
					required : "Este campo é obrigatório",
					
				},
				resposta2 : {
					required : "Este campo é obrigatório",
					
				},
				resposta3 : {
					required : "Este campo é obrigatório",
					
					
				},
				resposta4 : {
					required : "Este campo é obrigatório",
					
				},

				optionsRadios : {
					required : "Selecione qual a resposta CORRETA",
					
				}
			}

		});
	});
</script>
</head>

<body >

<c:import url="/view/comum/menuADM.jsp" />
		

<header>

	<br><br><br><br><br><br>
		<div class="panel-heading">

		<div class="panel-title text-center">
			<h1 class="title">Cadastrar Perguntas</h1>
			<hr />
		</div>
	</div>
	
	<br><br><br>
	
		
	<div class="container">
	 <form  method="post" action="CadastrarPerguntas" id="meuForm" > 
	    
	    <div class="mensagemCadastro" style="font-size: 20px; color: yellow; "><b>${mensagem}</b></div>
	    
	    <div class="form-group row">
	       <input type="text" class="form-control " name="descricao" id="descricao" autofocus="" placeholder="Digite sua Pergunta">
	    </div>
	    
	       				<label for="" class="cols-sm-2 control-label">
							 Disciplina
						</label> 
						
						<select name="disciplina" id="disciplina" class="btn btn-primary  ">
	
							<option value="">Selecione</option>
							<c:forEach items="${listaDisciplina}" var="obj">
								<option value="${obj.id}">${obj.nome}</option>
							</c:forEach>
						</select>
						 
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<label for="" class="cols-sm-2 control-label">
							Nivel De Pergunta
						</label> 
						
						<select name="nivel" id="nivel" class="btn btn-primary ">
	
							<option value="">Selecione</option>
							<c:forEach items="${listaNivel}" var="obj">
								<option value="${obj.id}">${obj.nome}</option>
							</c:forEach>
						</select> </br>
						
						<br>
	       
	       
	       
	   <div class="row">
	   		<div class="col-lg-15">
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="1">
			        
			      </span>
			      
			      <input type="text" name="resposta1" id="resposta1"  placeholder="Digite sua Resposta" autofocus="" class="form-control">
			    	
			    </div><!-- /input-group -->
	  		</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	  
	  <br>
	  
	    <div class="row">
	   		<div class="col-lg-15">
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="2">
			        
			      </span>
			      
			      <input type="text" name="resposta2" id="resposta2"  placeholder="Digite sua Resposta" autofocus="" class="form-control">
			    	
			    </div><!-- /input-group -->
	  		</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
		
		<br>
		
		 <div class="row">
	   		<div class="col-lg-15">
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="3">
			        
			      </span>
			      
			      <input type="text" name="resposta3" id="resposta3"  placeholder="Digite sua Resposta" autofocus="" class="form-control">
			    	
			    </div><!-- /input-group -->
	  		</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
		
		<br>
		
		 <div class="row">
	   		<div class="col-lg-15">
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="4">
			        
			      </span>
			      
			      <input type="text" name="resposta4" id="resposta4"  placeholder="Digite sua Resposta" autofocus="" class="form-control">
			    	
			    </div><!-- /input-group -->
	  		</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	     <br>
	   
	  			
	                            </br> </br>
						
						
						
						<div class="form-group ">
							<button type="submit"class="btn btn-success">Cadastrar</button>
					&nbsp;&nbsp;&nbsp;
							<button type="reset"class="btn btn-danger dropdown-toggle">   Limpar   </button>
						</div>
						
  
     
</form>
</div>
	




</header>


</body>

</html>