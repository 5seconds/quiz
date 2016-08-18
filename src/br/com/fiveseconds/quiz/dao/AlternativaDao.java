package br.com.fiveseconds.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Pergunta;
import br.com.fiveseconds.quiz.model.Usuario;

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
	
	
	
	public Alternativas buscarPorId(int id) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELEC MAX(id) FROM Perguntas WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Alternativas alternativas= null;
			if (rs.next()) {
				alternativas = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
		
			return alternativas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
		

	private Alternativas montarObjeto(ResultSet rs) throws SQLException {

		Alternativas alternativas = new Alternativas();

		alternativas.setId(rs.getInt("id"));
		alternativas.setDescricao(rs.getString("descricao"));
		alternativas.setAlterCorreta(rs.getString("alternativa"));
		
		return alternativas;
	}
	
	
	
	
	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
}
