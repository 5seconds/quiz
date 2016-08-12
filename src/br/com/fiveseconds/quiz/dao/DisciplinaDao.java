package br.com.fiveseconds.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiveseconds.quiz.model.Disciplina;


public class DisciplinaDao {

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
	
	
	private Disciplina montarObjeto(ResultSet rs) throws SQLException {

		Disciplina disciplina = new Disciplina();

		disciplina .setId(rs.getInt("id"));
		disciplina .setNome(rs.getString("nome"));
		return disciplina;
	}

	
	
}
