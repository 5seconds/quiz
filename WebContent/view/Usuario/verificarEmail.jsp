<%@page import="br.com.fiveseconds.quiz.dao.UsuarioDao"%>
<%@page import="br.com.fiveseconds.quiz.model.Usuario"%>
<%

Usuario usuario = new Usuario();
UsuarioDao dao = new UsuarioDao();


String email = request.getParameter("email");

usuario = dao.buscarPorEmail(email);

if(usuario == null){
	out.print("true");
}else{
	out.print("false");
}



%>
