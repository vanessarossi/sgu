package br.coop.unimedriopardo.uniresultado.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "prestador")
public class Prestador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Length(min = 3, max = 150)
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@NotBlank
	@Length(min = 3, max = 20)
	@Column(name = "prestador_origem", length = 20, nullable = false)
	private String prestadorOrigem;

	@NotBlank
	@Length(min = 3, max = 100)
	@Column(name = "sistema_prestador", length = 100, nullable = false)
	private String sistemaPrestador;
	
	@NotBlank
	@Length(min = 3, max = 500)
	@Column(name = "endpoint", length = 500, nullable = false)
	private String endpoint;
	
	@NotBlank
	@Length(min = 3, max = 50)
	@Column(name = "senha_webservice", length = 50, nullable = false)
	private String senhaWebservice;

	@NotBlank
	@Length(min = 3, max = 50)
	@Column(name = "login_webservice", length = 50, nullable = false)
	private String loginWebservice;
	
	@OneToMany(mappedBy = "prestador", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Usuario> usuarios;

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

	public String getPrestadorOrigem() {
		return prestadorOrigem;
	}

	public void setPrestadorOrigem(String prestadorOrigem) {
		this.prestadorOrigem = prestadorOrigem;
	}

	public String getSistemaPrestador() {
		return sistemaPrestador;
	}

	public void setSistemaPrestador(String sistemaPrestador) {
		this.sistemaPrestador = sistemaPrestador;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getSenhaWebservice() {
		return senhaWebservice;
	}

	public void setSenhaWebservice(String senhaWebservice) {
		this.senhaWebservice = senhaWebservice;
	}

	public String getLoginWebservice() {
		return loginWebservice;
	}

	public void setLoginWebservice(String loginWebservice) {
		this.loginWebservice = loginWebservice;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
