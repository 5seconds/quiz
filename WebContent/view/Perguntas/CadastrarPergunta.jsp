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
<script type="text/javascript" src="view/js/CadastrarPergunta.js"> </script>
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
	      <b style="font-size: 25px;"> Pergunta </b>
	       <textarea class="form-control" rows="2"  name="descricao" id="descricao" autofocus="" placeholder="Digite sua Pergunta"></textarea>
	    </div>
	    <br>
	    
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
	   		 <label style="font-size: 25px;"> <b > Alternativa 1 </b></label>
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="1">
			        
			      </span>
			      
			       <textarea class="form-control" rows="5"  name="resposta1" id="resposta1" placeholder="Digite sua REsposta"> </textarea>
			    	
			    </div><!-- /input-group -->
	  		</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	  
	  <br>
	  
	    <div class="row">
	   		<div class="col-lg-15">
	   		 <label style="font-size: 25px;"> <b > Alternativa 2 </b></label>
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="2">
			        
			      </span>
			      
			      <textarea class="form-control" rows="5" name="resposta2" id="resposta2" placeholder="Digite sua Resposta"> </textarea>
			    	
			    </div><!-- /input-group -->
	  		</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
		
		<br>
		
		 <div class="row">
	   		<div class="col-lg-15">
	   		 <label style="font-size: 25px;"> <b > Alternativa 3 </b></label>
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="3">
			        
			      </span>
			      
			      <textarea class="form-control" rows="5"  name="resposta3" id="resposta3" placeholder="Digite sua Resposta"> </textarea>
			    	
			    </div><!-- /input-group -->
	  		</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
		
		<br>
		
		 <div class="row">
	   		<div class="col-lg-15">
	   		 <label style="font-size: 25px;"> <b > Alternativa 4 </b></label>
			    <div class="input-group">
			     
			      <span class="input-group-addon">
			        <input type="radio" name="optionsRadios" id="optionsRadios" value="4">
			        
			      </span>
			      <textarea class="form-control" rows="5" name="resposta4" id="resposta4" placeholder="Digite sua Resposta"> </textarea>
			    
			    	
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