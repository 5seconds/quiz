<%@page import="br.com.fiveseconds.quiz.dao.AlternativaDao"%>

<%

String idResposta = request.getParameter("radioResposta");
int cont = 0;
AlternativaDao dao = new AlternativaDao();




if (dao.verificaRespostaCorreta(Integer.valueOf(idResposta))) {
	cont++;
     out.write(" Alternativa Correta  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> Pontos: " + cont );
} 


else {
	out.write(" <b> Alternativa incorreta </b>");
}






%>