package br.com.fiveseconds.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiveseconds.quiz.model.Pergunta;

public class AlternativaDao {

    

	private com.mysql.jdbc.Connection connection;

	public AlternativaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Pergunta pergunta) {
		try {
			String sql = "INSERT INTO Perguntas (descricao,idDisciplinaFK,idNivelFK) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pergunta.getDescricao());
			stmt.setInt(2, pergunta.getDisciplina().getId());
			stmt.setInt(3, pergunta.getNivel().getId());
			

			stmt.execute();
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void consultar(Pergunta pergunta) {
		try {
			String sql = "SELEC MAX(id) FROM Perguntas";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pergunta.getDescricao());
			stmt.setInt(2, pergunta.getDisciplina().getId());
			stmt.setInt(3, pergunta.getNivel().getId());
			

			stmt.execute();
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
}
