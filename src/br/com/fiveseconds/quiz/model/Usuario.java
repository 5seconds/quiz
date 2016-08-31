package br.com.fiveseconds.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class Usuario {


	private int id;
	

	private String nome;
	
	
	private String email;
	
	
	
	private String senha;
	

	private TipoUsuario tipoUsuario;
	
	private String confirmeSenha;
	
	public String getConfirmeSenha() {
		return confirmeSenha;
	}
	public void setConfirmeSenha(String confirmeSenha) {
		this.confirmeSenha = confirmeSenha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	@Override
	public String toString() {
		return "Id = " +id+ ", nome = " +nome+ ", email = " +email+ ", senha = " +senha;
	}
	
	
	
}