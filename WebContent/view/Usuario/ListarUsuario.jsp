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

</head>

	<hr>
	<h3>Pesquisar Usuários</h3>
	<hr>
	
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
	    		<a href='#?id=${usuario.id}'>Editar</a> &nbsp;
	    		<a href='#?id=${usuario.id}'>Remover</a>
	    	</td>
	    </tr>
	</c:forEach>
	</table>





</body>

</html>



