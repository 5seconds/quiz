package br.com.fiveseconds.quiz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fiveseconds.quiz.model.Usuario;

public class UsuarioHibernateDao extends HibernateDao {



	private static final String PERSISTENCE_UNIT = "game";

	public void salvar(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}


	public void alterar(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}

	public void remover(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		Usuario produto = manager.find(Usuario.class, id);
		manager.getTransaction().begin();
		manager.remove(produto);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}


	public List<Usuario> listar() {
		List<Usuario> lista = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		lista = manager.createQuery("SELECT p FROM Usuario p ORDER BY p.nome").getResultList();
		manager.close();
		factory.close();
		return lista;

	}

	public Usuario buscarPorEmail(String email) {
		Usuario obj = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		obj = manager.find(Usuario.class, email);
		manager.close();
		factory.close();
		return obj;
	}

	public List<Usuario> pesquisar(String nome) {
		List<Usuario> lista = null;
		Query query = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();

		if (!nome.equals("")) {
			query = manager.createQuery("SELECT p FROM Usuario p WHERE p.nome LIKE :paramNome ORDER BY p.nome");
			query.setParameter( 0, "%" + nome + "%");

		}  else {
			query = manager.createQuery("SELECT p FROM Usuario p ORDER BY p.nome");
		}

		lista = query.getResultList();
		manager.close();
		factory.close();
		return lista;
	}

	@Override
	public Class getClassEntidade() {

		return Usuario.class;
	}


}
