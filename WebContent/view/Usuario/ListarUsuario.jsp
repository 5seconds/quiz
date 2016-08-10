<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>

 <link rel="StyleSheet" type="text/css" href="view/css/lista.css">
 <link rel="StyleSheet" type="text/css" href="view/css/main.css">
    <link rel="StyleSheet" type="text/css" href="view/css/ie8.css">
    <link rel="StyleSheet" type="text/css" href="view/css/font-awesome.min.css">
   <link href="view/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
   
</head>
<body class="corbody">

<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="ExibirCadastrarADM">Cadastrar Usuarios</a></li>
  <li role="presentation"><a href="listarADM">Lista Usuarios</a></li>

  </ul>



<hr>
<h2 class="titulo">Lista de Usuarios</h2>
<hr>



<table border='1' style='width: 100%;' class="table">

<tr style='background-color: #E6E6E6; font-weight: bold;'>

<td> ID </td>
<td> Tipo De Usuario </td>
<td> NOME </td>
<td> EMAIL </td>
<td> SENHA </td>
<td> AÇÕES </td>

<c:forEach var="usuario" items="${listaUsuario}">
<tr>

<td class="tds"> ${usuario.id} </td>
<td class="tds"> ${usuario.tipoUsuario.nome} </td>
<td class="tds"> ${usuario.nome} </td>
<td class="tds"> ${usuario.email} </td>
<td class="tds"> ${usuario.senha} </td>

<td>
<a href="exibirAlterarADM?id=${usuario.id}">Editar</a> &nbsp; &nbsp; &nbsp;
<a href="removerADM?id=${usuario.id}">Remover</a>
</td>
</c:forEach>
</table>



</body>
</html>