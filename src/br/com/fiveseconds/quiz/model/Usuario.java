package br.com.fiveseconds.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	private int id;
	
	@NotEmpty(message="O Nome deve ser preenchido")
	@Size(min = 5, max = 50, message="O Nome deve deve ter um tamanho de 5 a 50 caracteres")
	@Column
	private String nome;
	
	@NotEmpty(message="O Email deve ser preenchido")
	@Size(min = 5, max = 50, message="O Email deve deve ter um tamanho de 5 a 50 caracteres")
	@Column
	private String email;
	
	
	@NotEmpty(message="A Senha deve ser preenchido")
	@Size(min = 5, max = 50, message="A Senha deve deve ter um tamanho de 5 a 10 caracteres")
	@Column
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "tipoUsuarioFK")
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