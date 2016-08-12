package br.com.fiveseconds.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiveseconds.quiz.model.Nivel;

public class NivelDao {

	

	private Connection connection;

	public NivelDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Nivel> listar() {
		
		
		
			try {
				List<Nivel> listaNivel= new ArrayList<Nivel>();
				PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Nivel");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					listaNivel.add(montarObjeto(rs));
				}

				rs.close();
				stmt.close();
				

				return listaNivel;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	
	
	private Nivel montarObjeto(ResultSet rs) throws SQLException {

		Nivel nivel = new Nivel();

		nivel.setId(rs.getInt("id"));
		nivel.setNome(rs.getString("nome"));
		return nivel ;
	}
}
