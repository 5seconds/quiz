package br.com.fiveseconds.quiz.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.fiveseconds.quiz.dao.NivelDao;
import br.com.fiveseconds.quiz.model.Nivel;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NivelDaoTest {
	
	@Test
	public void Blistar() throws SQLException {
		NivelDao dao = new NivelDao();
		List<Nivel> niveis = dao.listar();

		System.out.println(niveis);
		
		dao.fecharConexao();

	}
}
