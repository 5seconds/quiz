package br.com.fiveseconds.quiz.teste;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;


import br.com.fiveseconds.quiz.dao.UsuarioDao;
import br.com.fiveseconds.quiz.model.TipoUsuario;
import br.com.fiveseconds.quiz.model.Usuario;

public class CadastroUsuarioTeste {

	@Test
	public void CadastroUsuario() throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setNome("felix");
		usuario.setEmail("felix@hotmail.com");
		usuario.setSenha("1234");	
		TipoUsuario tipoUsuario = new TipoUsuario ();
		tipoUsuario.setId(1);
		usuario.setTipoUsuario(tipoUsuario);
		
		UsuarioDao dao = new UsuarioDao();
		dao.salvar(usuario);
		dao.fecharConexao();
		Assert.assertEquals("felix", usuario);

	}
	
}
