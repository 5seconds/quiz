package br.com.fiveseconds.quiz.dao;

public abstract class HibernateDao {

	protected static final String PERSISTENCE_UNIT = "game";

	public void salvar (Object obj) {}
	public void alterar (Object obj) {}
	public void remover (int id) {}
	public Object buscarPorNome(String nome) {
		return nome;}
	
	
	public abstract Class getClassEntidade();
	
	
}
