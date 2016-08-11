package br.com.fiveseconds.quiz.teste;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.fiveseconds.quiz.dao.UsuarioDao;
import br.com.fiveseconds.quiz.model.TipoUsuario;
import br.com.fiveseconds.quiz.model.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		Usuario usuarioSalvo = dao.buscarPorEmail(usuario.getEmail());
		
		Assert.assertEquals(usuarioSalvo.getEmail(), usuario.getEmail());
		dao.fecharConexao();
	}
	
	@Test
	public void AlterarUsuario() throws SQLException{
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		
		Usuario usuario1 = dao.buscarPorEmail("felix@hotmail.com");
		
		usuario.setNome("julio");
		usuario.setEmail("felix@hotmail.com");
		usuario.setSenha("4321");
		
		TipoUsuario tipoUsuario = new TipoUsuario ();
		tipoUsuario.setId(1);
		usuario.setTipoUsuario(tipoUsuario);
         
		dao.alterar(usuario);
		Usuario usuarioAlterado = dao.buscarPorEmail(usuario.getEmail());
		

		Assert.assertEquals(usuarioAlterado.getEmail(), usuario.getEmail());
		dao.fecharConexao();
		
	}
	
	@Test
	public void DeletarUsuario() throws SQLException {
		
		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioRemovido = dao.buscarPorEmail("felix@hotmail.com");
		dao.remover(usuarioRemovido);
		usuarioRemovido = dao.buscarPorEmail("felix@hotmail.com");
		
		Assert.assertEquals(usuarioRemovido, null);
		dao.fecharConexao();
	}
	
}