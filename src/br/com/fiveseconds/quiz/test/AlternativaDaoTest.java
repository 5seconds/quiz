package br.com.fiveseconds.quiz.test;

import org.junit.Test;

import br.com.fiveseconds.quiz.dao.AlternativaDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Pergunta;

public class AlternativaDaoTest {
	
	@Test
	public void buscarPorId(){
		PerguntaDao perguntaDao = new PerguntaDao();
		Pergunta pergunta = perguntaDao.buscarPorId(1);
		
		Alternativas alternativas = new Alternativas();
		alternativas.setDescricao("a");
		alternativas.setAlterCorreta("b");
		alternativas.setIdPerguntaFK(pergunta.getId());
		
		
		AlternativaDao alternativaDao = new AlternativaDao();
		alternativaDao.salvar(pergunta);
		
		
		
		
		
		
		
	}
	
}
