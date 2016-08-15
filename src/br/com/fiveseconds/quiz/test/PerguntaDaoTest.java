package br.com.fiveseconds.quiz.test;

import org.junit.Test;

import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Nivel;
import br.com.fiveseconds.quiz.model.Pergunta;

public class PerguntaDaoTest {
	
	@Test
	public void Asalvar(){
		
		NivelDao nivelDao = new NivelDao();
		Nivel nivel = nivelDao.buscarPorId(1);
		
		
		Pergunta pergunta = new Pergunta();
		pergunta.setDescricao("1111");
		
		PerguntaDao perguntaDao = new PerguntaDao();
		perguntaDao.salvar(pergunta);
	
	}
	
	
}
