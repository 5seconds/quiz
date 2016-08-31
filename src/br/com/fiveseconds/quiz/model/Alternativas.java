package br.com.fiveseconds.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Alternativa")
public class Alternativas {

	@Id
	private int id;

	@Column
	private String descricao;

	@Column
	private String alterCorreta;

	@ManyToOne
	@JoinColumn(name = "idPerguntaFK")
	private int idPerguntaFK;

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

	public String getAlterCorreta() {
	    return alterCorreta;
	}

	public void setAlterCorreta(String alterCorreta) {
	    this.alterCorreta = alterCorreta;
	}

	public int getIdPerguntaFK() {
	    return idPerguntaFK;
	}

	public void setIdPerguntaFK(int idPerguntaFK) {
	    this.idPerguntaFK = idPerguntaFK;
	}

	


}
