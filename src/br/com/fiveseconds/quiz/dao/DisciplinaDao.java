package br.com.fiveseconds.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiveseconds.quiz.model.Disciplina;
import br.com.fiveseconds.quiz.model.Usuario;


public class DisciplinaDao  {

	public Class getClassEntidade() {
		return Usuario.class;
		}
	
	private Connection connection;

	public DisciplinaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Disciplina> listar() {
		
		
		
			try {
				List<Disciplina> listaDisciplina= new ArrayList<Disciplina>();
				PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Disciplina");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					listaDisciplina.add(montarObjeto(rs));
				}

				rs.close();
				stmt.close();
				

				return listaDisciplina;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	
	
	public Disciplina buscarPorId(int id) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Disciplina WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Disciplina disciplina = null;
			if (rs.next()) {
				disciplina = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
		
			return disciplina;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		   }
	
		}
	
	
	private Disciplina montarObjeto(ResultSet rs) throws SQLException {

		Disciplina disciplina = new Disciplina();

		disciplina .setId(rs.getInt("id"));
		disciplina .setNome(rs.getString("nome"));
		return disciplina;
	}

	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
	
}
