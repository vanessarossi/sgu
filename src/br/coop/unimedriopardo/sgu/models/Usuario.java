package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "sgu_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQ_SGU_USUARIO")
    @SequenceGenerator(sequenceName = "SEQ_SGU_USUARIO", allocationSize = 1, name = "PK_SEQ_SGU_USUARIO")
	private Integer id;

	@NotBlank
	@Length(min = 3, max = 100)
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@NotBlank
	@Length(min = 3, max = 50)
	@Column(name = "login", length = 50, nullable = false)
	private String login;

	@Column(name = "senha", length = 150)
	private String senha;

	@Email
	@Column(name = "email", length = 200)
	private String email;

	@NotNull
	@Column(name = "ativo", nullable = false)
	private String ativo;

	@NotBlank
	@Column(name = "perfil", length = 100, nullable = false)
	private String perfil;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
}
