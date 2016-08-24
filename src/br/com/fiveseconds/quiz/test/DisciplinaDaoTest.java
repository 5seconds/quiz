package br.com.fiveseconds.quiz.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.fiveseconds.quiz.dao.DisciplinaDao;
import br.com.fiveseconds.quiz.model.Disciplina;

public class DisciplinaDaoTest {

	@Test
	public void Blistar() throws SQLException {
		DisciplinaDao dao = new DisciplinaDao();
		List<Disciplina> disciplinas = dao.listar();

		System.out.println(disciplinas);
		
		dao.fecharConexao();
		

	}
}
