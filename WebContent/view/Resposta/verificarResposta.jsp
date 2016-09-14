<%@page import="br.com.fiveseconds.quiz.dao.AlternativaDao"%>

<%

String idResposta = request.getParameter("radioResposta");
AlternativaDao dao = new AlternativaDao();

if (dao.verificaRespostaCorreta(Integer.valueOf(idResposta))) {
     out.write("<b style='font-size: 20px;' class='alert alert-success'> Parabéns, Você acertou! </b>" );
} 


else {
	out.write(" <b style='font-size: 20px;' class='alert alert-danger'> Alternativa incorreta </b>");
}

    




%>