package br.com.fiveseconds.quiz.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import br.com.fiveseconds.quiz.model.TipoUsuario;
import br.com.fiveseconds.quiz.model.Usuario;

public class TipoUsuarioDao extends HibernateDao {
	
	public Class getClassEntidade() {
		return Usuario.class;
		}
	
	private Connection connection;

	public TipoUsuarioDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	public TipoUsuario buscarPorId(int id) {

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TipoUsuario WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			TipoUsuario tipoUsuario = null;
			if (rs.next()) {
				tipoUsuario = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
		
			return tipoUsuario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private TipoUsuario montarObjeto(ResultSet rs) throws SQLException {

		TipoUsuario tipoUsuario = new TipoUsuario();

		tipoUsuario.setId(rs.getInt("id"));
		tipoUsuario.setNome(rs.getString("nome"));
		return tipoUsuario;
	}
	
	
public void fecharConexao() throws SQLException{
		
		connection.close();
	}

}
