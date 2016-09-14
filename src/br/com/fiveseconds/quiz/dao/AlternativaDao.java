package br.com.fiveseconds.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Pergunta;
import br.com.fiveseconds.quiz.model.Usuario;

public class AlternativaDao {

	/*

	private static final long serialVersionUID = 1L;

	private HttpServletRequest HttpServletRequest;

	HttpServletRequest req = (HttpServletRequest); 


	 */
	private com.mysql.jdbc.Connection connection;

	public AlternativaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
			System.out.println("Abrir conexao");
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

	public void alterar(Alternativas alternativa, Pergunta pergunta, int x) {

		try {
			String sql = "UPDATE Alternativa SET descricao = ?, AlterCorreta = ?, idPerguntaFK = ? WHERE id = ?";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, alternativa.getDescricao());
			stmt.setString(2, alternativa.getAlterCorreta());
			stmt.setInt(3, pergunta.getId());
			
			stmt.setInt(4, x);
			stmt.execute();
			stmt.close();
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

	public boolean verificaRespostaCorreta(int idResposta, Usuario usuario) {

		try {
			List<Alternativas> listaAlternativa = new ArrayList<Alternativas>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * From Alternativa where id = ? and alterCorreta=1");
			stmt.setInt(1, idResposta);


			ResultSet rs = stmt.executeQuery();

			int resposta = 0;
			Alternativas alternativa = buscarPorIdAlternativa(idResposta);
			if (rs.next()) {
				resposta = rs.getInt("alterCorreta");

			}
			rs.close();
			stmt.close();

			PerguntaDao dao = new PerguntaDao();


			if (resposta == 1) {
				dao.salvarResposta(alternativa.getIdPerguntaFK(), usuario.getId(), "1");
				dao.fecharConexao();
				return true;
			} else {
				dao.salvarResposta(alternativa.getIdPerguntaFK(), usuario.getId(), "0");
				dao.fecharConexao();
				return false;
			}
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Alternativas buscarPorId(int id, Pergunta pergunta) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alternativa WHERE idPerguntaFK = ? and id = ?");
			stmt.setInt(1, pergunta.getId());
			stmt.setInt(2, id);
			ResultSet rs = stmt.executeQuery();

			Alternativas alternativa = null;
			if (rs.next()) {
				alternativa = montarObjeto(rs);
			}

			rs.close();
			stmt.close();

			return alternativa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public Alternativas buscarPorIdAlternativa(int id) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alternativa WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Alternativas alternativa = null;
			if (rs.next()) {
				alternativa = montarObjeto(rs);
			}

			rs.close();
			stmt.close();

			return alternativa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public Alternativas buscarPorIdPerguntaFK(int y) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alternativa WHERE idPerguntaFK = ?");
			stmt.setInt(1, y);
			ResultSet rs = stmt.executeQuery();

			Alternativas alternativa = null;
			if (rs.next()) {
				alternativa = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
		
			return alternativa;
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
	
	
	public void fecharConexao() throws SQLException {
		System.out.println("Fechar conexao");
		connection.close();
	}
}