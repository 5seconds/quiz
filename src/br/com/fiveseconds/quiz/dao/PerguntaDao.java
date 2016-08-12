package br.com.fiveseconds.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiveseconds.quiz.model.Pergunta;
import br.com.fiveseconds.quiz.model.Usuario;

public class PerguntaDao {

	
	private com.mysql.jdbc.Connection connection;

	public PerguntaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Pergunta pergunta) {
		try {
			String sql = "INSERT INTO Pergunta (descricao, idNivelFK, idDisciplinaFK) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pergunta.getDescricao());
			stmt.setInt(2, pergunta.getIdNivelFK());
			stmt.setInt(3, pergunta.getIdDisciplinaFK());
			stmt.execute();
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Pergunta montarObjeto(ResultSet rs) throws SQLException {

		Pergunta pergunta = new Pergunta();

		pergunta.setId(rs.getInt("id"));
		pergunta.setDescricao(rs.getString("descricao"));
		pergunta.setIdNivelFK(rs.getInt("email"));
		pergunta.setIdDisciplinaFK(rs.getInt("idDisciplinaFK"));
		return pergunta;
	}
	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
	
	
}
