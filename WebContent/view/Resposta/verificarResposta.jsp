<%@page import="br.com.fiveseconds.quiz.dao.AlternativaDao"%>

<%

String idResposta = request.getParameter("radioResposta");
AlternativaDao dao = new AlternativaDao();

if (dao.verificaRespostaCorreta(Integer.valueOf(idResposta))) {
     out.write("<b style='font-size: 20px;'> Parabéns, Você acertou! </b>" );
} 


else {
	out.write(" <b style='font-size: 15px;'> Alternativa incorreta </b>");
}

    




%>