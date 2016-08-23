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

	public void salvar(Alternativas alternativa, int idPergunta) {
		try {
			String sql = "INSERT INTO Alternativa(descricao,alterCoreta,idPerguntaFK) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, alternativa.getDescricao());
			stmt.setString(2, alternativa.getAlterCorreta());
			stmt.setInt(3, idPergunta);
			

			stmt.execute();
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
		
	
	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
}
