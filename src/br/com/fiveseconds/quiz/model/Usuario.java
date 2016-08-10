package br.com.fiveseconds.quiz.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {

	
	private int id;
	
	@NotEmpty(message="O Nome deve ser preenchido")
	@Size(min = 5, max = 50, message="O Nome deve deve ter um tamanho de 5 a 50 caracteres")
	private String nome;
	
	@NotEmpty(message="O Email deve ser preenchido")
	@Size(min = 5, max = 50, message="O Email deve deve ter um tamanho de 5 a 50 caracteres")
	private String email;
	
	
	@NotEmpty(message="A Senha deve ser preenchido")
	@Size(min = 5, max = 50, message="A Senha deve deve ter um tamanho de 5 a 10 caracteres")
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
	
	
	
}
