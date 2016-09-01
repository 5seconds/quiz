package br.com.fiveseconds.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiveseconds.quiz.model.Usuario;

public class UsuarioDao {

	public Class getClassEntidade() {
		return Usuario.class;
	}

	private Connection connection;

	public UsuarioDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Usuario usuario) {
		try {
			String sql = "INSERT INTO Usuario (nome, email, senha, tipoUsuarioFk) VALUES (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getTipoUsuario().getId());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> listar() {

		try {
			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Usuario ORDER BY nome;");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listaUsuario.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaUsuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscarPorId(int id) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usuario WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Usuario usuario = null;
			if (rs.next()) {
				usuario = montarObjeto(rs);
			}

			rs.close();
			stmt.close();

			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Usuario buscarPorEmail(String email) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usuario WHERE email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			Usuario usuario = null;
			if (rs.next()) {
				usuario = montarObjeto(rs);
			}

			rs.close();
			stmt.close();

			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Usuario usuario) {

		String sql = "UPDATE Usuario SET nome = ? , email = ? , senha = ? WHERE id = ?";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Usuario usuario) {

		try {
			String sql = "DELETE FROM Usuario WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Usuario montarObjeto(ResultSet rs) throws SQLException {

		Usuario usuario = new Usuario();

		usuario.setId(rs.getInt("id"));
		usuario.setNome(rs.getString("nome"));
		usuario.setEmail(rs.getString("email"));
		usuario.setSenha(rs.getString("senha"));
		int id = rs.getInt("tipoUsuarioFk");
		return usuario;
	}

	

	public List<Usuario> pesquisar(Usuario usuario) {
		
		try {
			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			PreparedStatement stmt = null;
		
			
			
			if (!usuario.getNome().equals("") && usuario.getEmail().equals("")) {
			stmt = this.connection.prepareStatement("SELECT * FROM Usuario WHERE nome LIKE ? ORDER BY nome");
			stmt.setString(1, "%" + usuario.getNome() + "%");
			} 
			
			else if (usuario.getNome().equals("") && !usuario.getEmail().equals("") ) {
			stmt = this.connection.prepareStatement("SELECT * FROM Usuario WHERE email = ? ORDER BY nome ");
			stmt.setString(1, usuario.getEmail());
			} 
			
			else if (!usuario.getNome().equals("") && !usuario.getEmail().equals("")) {
			stmt = this.connection.prepareStatement("SELECT * FROM Usuario WHERE nome LIKE ? AND email	= ? ORDER BY nome");
			stmt.setString(1, "%" + usuario.getNome() + "%");
			stmt.setString(2, usuario.getEmail());
			} 
			else {
			stmt = this.connection.prepareStatement("SELECT * FROM Usuario ORDER BY nome ");
			}
		
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			listaUsuario.add(montarObjeto(rs));
			}
			rs.close();
			stmt.close();

			connection.close();
			return listaUsuario;
			
			} catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}
	
	
	public void fecharConexao() throws SQLException {

		connection.close();
	}

}
