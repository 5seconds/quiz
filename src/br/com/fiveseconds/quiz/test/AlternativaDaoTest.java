package br.com.fiveseconds.quiz.test;

import java.sql.SQLException;

import org.junit.Test;

import br.com.fiveseconds.quiz.dao.AlternativaDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Pergunta;

public class AlternativaDaoTest {
	
	@Test
	public void buscarPorId() throws SQLException{
		PerguntaDao perguntaDao = new PerguntaDao();
		Pergunta pergunta = perguntaDao.buscarPorId(1);
		
		Alternativas alternativas = new Alternativas();
		alternativas.setDescricao("a");
		alternativas.setAlterCorreta("b");
		alternativas.setIdPerguntaFK(2);
		
		
		AlternativaDao alternativaDao = new AlternativaDao();
		alternativaDao.salvar(alternativas, pergunta.getId());
		
		AlternativaDao dao = new AlternativaDao();
		dao.fecharConexao();
	}
	
}
