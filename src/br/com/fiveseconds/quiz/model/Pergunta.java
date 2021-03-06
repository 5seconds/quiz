package br.com.fiveseconds.quiz.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class Pergunta {

	
	private int id;
	

	private String descricao;
	

	private Nivel nivel;
	

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
