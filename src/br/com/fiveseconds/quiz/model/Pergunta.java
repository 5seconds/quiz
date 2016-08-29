package br.com.fiveseconds.quiz.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Perguntas")
public class Pergunta {

	@Id
	private int id;
	
	@Column
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "idNivelFK")
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name = "idDisciplinaFK")
	private Disciplina disciplina;
	
	private ArrayList<Alternativas> alternativas;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

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

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public ArrayList<Alternativas> getAlternativas() {
	    return alternativas;
	}

	public void setAlternativas(ArrayList<Alternativas> alternativas) {
	    this.alternativas = alternativas;
	}

	
	
	

}
