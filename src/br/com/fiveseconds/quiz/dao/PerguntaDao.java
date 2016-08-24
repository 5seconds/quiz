package br.com.fiveseconds.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiveseconds.quiz.model.Pergunta;
import br.com.fiveseconds.quiz.model.Usuario;

public class PerguntaDao extends HibernateDao {

	public Class getClassEntidade() {
		return Usuario.class;
		}
	
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
	
	public int buscarUltimoId() {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT MAX(id) id FROM Perguntas ");
			ResultSet rs = stmt.executeQuery();
			
			int id = 0	;
			while (rs.next()) {
				id = rs.getInt("id");
			}

			rs.close();
			stmt.close();
		
			return id;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public Pergunta buscarPorId(int id) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Perguntas WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Pergunta pergunta = null;
			if (rs.next()) {
				pergunta = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
		
			return pergunta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public Pergunta buscarPorPergunta(String descricao) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Perguntas WHERE descricao = ?");
			stmt.setString(1, descricao);
			ResultSet rs = stmt.executeQuery();

			Pergunta pergunta = null;
			if (rs.next()) {
				pergunta = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
		
			return pergunta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	

	private Pergunta montarObjeto(ResultSet rs) throws SQLException {

		Pergunta pergunta = new Pergunta();
		
		pergunta.setId(rs.getInt("id"));
		pergunta.setDescricao(rs.getString("descricao"));
		
		int idDisciplina = rs.getInt("idDisciplinaFK");
		DisciplinaDao dis = new DisciplinaDao();
		pergunta.setDisciplina(dis.buscarPorId(idDisciplina));
		
		int idNivel = rs.getInt("idNivelFK");
		NivelDao niv = new NivelDao();
		pergunta.setNivel(niv.buscarPorId(idNivel));
		
		return pergunta;
		
	}
	
		
	
	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
	
}
