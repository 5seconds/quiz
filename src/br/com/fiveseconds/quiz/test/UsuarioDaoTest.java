package br.com.fiveseconds.quiz.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.fiveseconds.quiz.dao.UsuarioDao;
import br.com.fiveseconds.quiz.model.TipoUsuario;
import br.com.fiveseconds.quiz.model.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDaoTest {
	
	@Test
	
	public void Asalvar() throws SQLException {
		
		Usuario usuario = new Usuario();
		usuario.setNome("julio");
		usuario.setEmail("j@hotmail.com");
		usuario.setSenha("julio");

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(1);
		usuario.setTipoUsuario(tipoUsuario);
		
		UsuarioDao dao = new UsuarioDao();
		dao.salvar(usuario);
		
		Usuario usuarioSalvo = dao.buscarPorEmail(usuario.getEmail());

		Assert.assertEquals(usuarioSalvo.getEmail(), usuario.getEmail());
		
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("gilson");
		usuario2.setEmail("g@hotmail.com");
		usuario2.setSenha("gilson");

		TipoUsuario tipoUsuario2 = new TipoUsuario();
		tipoUsuario2.setId(1);
		usuario2.setTipoUsuario(tipoUsuario2);
		
		UsuarioDao dao2 = new UsuarioDao();
		dao2.salvar(usuario2);
		
		Usuario usuarioSalvo2 = dao2.buscarPorEmail(usuario2.getEmail());

		Assert.assertEquals(usuarioSalvo2.getEmail(), usuario2.getEmail());

		
		dao2.fecharConexao();
	}

	@Test
	public void Blistar() throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		List<Usuario> usuarios = dao.listar();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		dao.fecharConexao();
	}
	
	@Test
	public void Calterar() throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setNome("Felix");
		usuario.setEmail("f@hotmail.com");
		usuario.setSenha("Felix");
		usuario.setId(2);

		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);

		Usuario usuarioAlterado = dao.buscarPorEmail("f@hotmail.com");
		
		Assert.assertEquals(usuarioAlterado.getEmail(), usuario.getEmail());
		dao.fecharConexao();
	}

	@Test
	public void Dremover() throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		
		Usuario usuarioRemovido = dao.buscarPorEmail("f@hotmail.com");
		dao.remover(usuarioRemovido);
		usuarioRemovido = dao.buscarPorEmail("f@hotmail.com");

		Assert.assertEquals(usuarioRemovido, null);
		dao.fecharConexao();
	}

	
}