<%@page import="br.com.fiveseconds.quiz.model.Usuario"%>
<%@page import="br.com.fiveseconds.quiz.dao.AlternativaDao"%>

<%

String idResposta = request.getParameter("radioResposta");
Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
AlternativaDao dao = new AlternativaDao();

if (dao.verificaRespostaCorreta(Integer.valueOf(idResposta),usuario)) {
	
     out.write("<b style='font-size: 20px;'> Parabéns, Você acertou! </b>" );
} 


else {
	out.write(" <b style='font-size: 15px;'> Alternativa incorreta </b>");
}

    




%>