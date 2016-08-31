package br.com.fiveseconds.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Usuario;

public class AlternativaDao {


	public Class getClassEntidade() {
		return Usuario.class;
		}

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
			String sql = "INSERT INTO Alternativa(descricao,alterCorreta,idPerguntaFK) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, alternativa.getDescricao());
			stmt.setString(2, alternativa.getAlterCorreta());
			stmt.setInt(3, idPergunta);
			

			stmt.execute();
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Alternativas> listarPergunta(int idPergunta) {

		try {
			ArrayList<Alternativas> listaAlternativa = new ArrayList<Alternativas>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Alternativa WHERE idPerguntaFK = ?");
			stmt.setInt(1, idPergunta);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listaAlternativa.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();
			

			return listaAlternativa;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public boolean ConsultarRespostaCorreta(int id) {

		try {
			List<Alternativas> listaAlternativa = new ArrayList<Alternativas>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT alterCorreta From Alternativa where id = ? ");
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			int resposta=0;
			if (rs.next()) {
				 resposta = rs.getInt("alterCorreta");
				
			}

			rs.close();
			stmt.close();
			connection.close();
			
			
			if(resposta == 1){
				return true;
			}else{
				return false;
			}
			
			

		

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	private Alternativas montarObjeto(ResultSet rs) throws SQLException {

		Alternativas alternativa = new Alternativas();

		alternativa.setId(rs.getInt("id"));
		alternativa.setDescricao(rs.getString("descricao"));
		alternativa.setAlterCorreta(rs.getString("alterCorreta"));
		alternativa.setIdPerguntaFK(rs.getInt("idPerguntaFK"));
		
		return alternativa;
	}
	
		
	
	public void fecharConexao() throws SQLException{
		
		connection.close();
	}
}
