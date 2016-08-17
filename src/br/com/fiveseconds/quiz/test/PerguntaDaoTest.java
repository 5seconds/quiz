package br.com.fiveseconds.quiz.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.dao.PerguntaDao;
import br.com.fiveseconds.quiz.model.Disciplina;
import br.com.fiveseconds.quiz.model.Nivel;
import br.com.fiveseconds.quiz.model.Pergunta;

public class PerguntaDaoTest {
	
	@Test
	public void Asalvar() throws SQLException{
		
		NivelDao nivelDao = new NivelDao();
		Nivel nivel = nivelDao.buscarPorId(1);
		
		DisciplinaDao disciplinaDao = new DisciplinaDao();
		Disciplina disciplina = disciplinaDao.buscarPorId(1);
		
		Pergunta pergunta = new Pergunta();
		pergunta.setDescricao("sdasdasdas");
		pergunta.setDisciplina(disciplina);
		pergunta.setNivel(nivel);
		
		PerguntaDao perguntaDao = new PerguntaDao();
		perguntaDao.salvar(pergunta);
		
		Pergunta pergunta2 = perguntaDao.buscarPorPergunta(pergunta.getDescricao());
		
		Assert.assertEquals(pergunta2.getDescricao(), pergunta.getDescricao());
		
		perguntaDao.fecharConexao();
		
	}
	
	
}
