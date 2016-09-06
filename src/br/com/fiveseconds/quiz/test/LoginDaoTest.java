package br.com.fiveseconds.quiz.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.fiveseconds.quiz.dao.LoginDao;
import br.com.fiveseconds.quiz.model.TipoUsuario;
import br.com.fiveseconds.quiz.model.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginDaoTest {
	
	@Test
	public void login() throws SQLException {
		LoginDao loginDao = new LoginDao();
		
		Usuario usuario = new Usuario();
		usuario.setSenha("12345");
		usuario.setEmail("administrador@adm.com");
		
		Usuario usuarioLogin = loginDao.buscarPorEmail(usuario);
	
		Assert.assertEquals(usuario.getEmail(), usuarioLogin.getEmail());
	
		
		loginDao.fecharConexao();
		
		
	}

}