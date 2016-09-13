<%@page import="br.com.fiveseconds.quiz.dao.AlternativaDao"%>

<%

String idResposta = request.getParameter("radioResposta");
AlternativaDao dao = new AlternativaDao();

if (dao.verificaRespostaCorreta(Integer.valueOf(idResposta))) {
     out.write(" Alternativa Correta  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> Pontos: " );
} 


else {
	out.write(" <b> Alternativa incorreta </b>");
}

    




%>