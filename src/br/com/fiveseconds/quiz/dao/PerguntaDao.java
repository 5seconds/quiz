package br.com.fiveseconds.quiz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiveseconds.quiz.model.Alternativas;
import br.com.fiveseconds.quiz.model.Pergunta;

public class PerguntaDao  {

	
	private com.mysql.jdbc.Connection connection;

	public PerguntaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
			System.out.println("Abrir conexao");
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
	
	public void alterar(Pergunta pergunta) {

		try {
			String sql = "UPDATE Perguntas SET descricao = ?, idNivelFK = ?, idDisciplinaFK = ? WHERE id = ?";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pergunta.getDescricao());
			stmt.setInt(2, pergunta.getNivel().getId());
			stmt.setInt(3, pergunta.getDisciplina().getId());
			stmt.setInt(4, pergunta.getId());
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
	
	
	
	public List<Pergunta> listar() {

		try {
			List<Pergunta> listaPergunta= new ArrayList<Pergunta>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Perguntas");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listaPergunta.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();
			

			return listaPergunta;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Pergunta> listarPerguntaUnica(int limit) {

		try {
			List<Pergunta> listaPergunta= new ArrayList<Pergunta>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Perguntas limit ?,1");
			stmt.setInt(1, limit);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listaPergunta.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();
			

			return listaPergunta;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public int buscarOrdem() {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT MAX(ordem) ordem FROM Perguntas ");
			ResultSet rs = stmt.executeQuery();
			
			int ordem = 0	;
			while (rs.next()) {
				ordem = rs.getInt("ordem");
			}

			rs.close();
			stmt.close();
		
			return ordem;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<Pergunta> pesquisar(Pergunta pergunta) {
		try {
		List<Pergunta> listaPergunta = new ArrayList<Pergunta>();
		PreparedStatement stmt = null;
		
		
		
	    if (pergunta.getNivel() != null && pergunta.getDisciplina() == null) {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas WHERE idNivelFK = ? ORDER BY id");
		stmt.setInt(1, pergunta.getNivel().getId());
		}
	    else if (pergunta.getNivel() == null && pergunta.getDisciplina() != null) {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas WHERE idDisciplinaFK = ? ORDER BY id");
		stmt.setInt(1, pergunta.getDisciplina().getId());
		}
	    else if (pergunta.getNivel() != null && pergunta.getDisciplina() != null) {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas WHERE idDisciplinaFK = ? AND idNivelFK = ? ORDER BY id");
		stmt.setInt(1, pergunta.getDisciplina().getId());
		stmt.setInt(2, pergunta.getNivel().getId());
		}
	    else {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas ORDER BY id");
		}
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			listaPergunta.add(montarObjeto(rs));
		}
		rs.close();
		stmt.close();
		connection.close();
		return listaPergunta;
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		
		}
	
	public List<Pergunta> pesquisarLimit(Pergunta pergunta, int limit) {
		//limit  = 0;
	    
	    try {
		List<Pergunta> listaPergunta = new ArrayList<Pergunta>();
		PreparedStatement stmt = null;
		
		
		
	    if (pergunta.getNivel() != null && pergunta.getDisciplina() == null) {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas WHERE idNivelFK = ? LIMIT ?,1");
		stmt.setInt(1, pergunta.getNivel().getId());
		stmt.setInt(2, limit);
		}
	    else if (pergunta.getNivel() == null && pergunta.getDisciplina() != null) {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas WHERE idDisciplinaFK = ? LIMIT ?,1");
		stmt.setInt(1, pergunta.getDisciplina().getId());
		stmt.setInt(2, limit);
		}
	    else if (pergunta.getNivel() != null && pergunta.getDisciplina() != null) {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas WHERE idDisciplinaFK = ? AND idNivelFK = ? LIMIT ?,1");
		stmt.setInt(1, pergunta.getDisciplina().getId());
		stmt.setInt(2, pergunta.getNivel().getId());
		stmt.setInt(3, limit);
		}
	    else {
		stmt = this.connection.prepareStatement("SELECT * FROM Perguntas LIMIT ?,1");
		stmt.setInt(1, limit);
		}
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			listaPergunta.add(montarObjeto(rs));
		}
		
		rs.close();
		stmt.close();
		connection.close();
		
		return listaPergunta;
		
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		
		}
	
	public List<Pergunta> AjaxPergunta(String descricao) {

		try {
			List<Pergunta> lista = new ArrayList<Pergunta>();

			PreparedStatement stmt = null;


			
			if (!descricao.equals("") ) {
				stmt = this.connection.prepareStatement("SELECT * FROM Perguntas WHERE descricao LIKE ? ORDER BY descricao");
				stmt.setString(1, "%" + descricao + "%");
			}
			else{
				stmt = this.connection.prepareStatement("SELECT * FROM Perguntas ORDER BY descricao");
			}
			

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			    lista.add(montarObjeto(rs));
			}
			rs.close();
			stmt.close();

			connection.close();
			return lista;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	public void remover(Pergunta pergunta) {

		try {
			String sql = "DELETE FROM Perguntas WHERE id = ? ";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, pergunta.getId());
			stmt.execute();

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
		dis.fecharConexao();
		
		int idNivel = rs.getInt("idNivelFK");
		NivelDao niv = new NivelDao();
		pergunta.setNivel(niv.buscarPorId(idNivel));
		niv.fecharConexao();
		
		AlternativaDao dao = new AlternativaDao();
		ArrayList<Alternativas> lista = dao.listarPergunta(pergunta.getId());
		pergunta.setAlternativas(lista);
		dao.fecharConexao();
		
		pergunta.setAlternativas(lista);
		dao.fecharConexao();
		
		return pergunta;
		
	}
	/*
	public void alterar(Usuario usuario) {

		String sql = "UPDATE Perguntas SET descricao = ? , email = ? , senha = ? WHERE id = ?";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	*/	
	
	public void salvarResposta(int idPergunta, int codigoUsuario, String respostaCorreta) {
		try {
			String sql = "INSERT INTO Resposta (idPerguntasFK,idUsuarioFK,correto) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idPergunta);
			stmt.setInt(2, codigoUsuario);
			stmt.setString(3, respostaCorreta);
			

			stmt.execute();
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void fecharConexao() throws SQLException{
	    System.out.println("Fechar  conexao");
		connection.close();
	}
	
}