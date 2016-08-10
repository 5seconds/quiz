package br.com.fiveseconds.quiz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiveseconds.quiz.model.Usuario;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDao {

	
	private Connection connection;

	public LoginDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public Usuario buscarUsuario(Usuario usuario) {
		
		try {
		Usuario usuarioConsultado = null;
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM Usuario WHERE email = ? and senha = ?");
		stmt.setString(1, usuario.getEmail());
		stmt.setString(2, usuario.getSenha());
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
		usuarioConsultado = montarObjeto(rs);
		}
		
		rs.close();
		stmt.close();
		
		return usuarioConsultado;
		
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


	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
	
}
