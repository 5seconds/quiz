<%@page import="br.com.fiveseconds.quiz.dao.AlternativaDao"%>

<%

String idResposta = request.getParameter("radioResposta");

AlternativaDao dao = new AlternativaDao();
if (dao.verificaRespostaCorreta(Integer.valueOf(idResposta))) {
	out.write("Alternativa Correta");
} else {
	out.write("Alternativa incorreta");
}






%>