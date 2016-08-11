package br.com.fiveseconds.quiz.model;

public class Pergunta {

	private int id;
	
	private String descricao;
	
	private int idNivelFK;
	
	private int idDisciplinaFK;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdNivelFK() {
		return idNivelFK;
	}

	public void setIdNivelFK(int idNivelFK) {
		this.idNivelFK = idNivelFK;
	}

	public int getIdDisciplinaFK() {
		return idDisciplinaFK;
	}

	public void setIdDisciplinaFK(int idDisciplinaFK) {
		this.idDisciplinaFK = idDisciplinaFK;
	}
	
	

}
