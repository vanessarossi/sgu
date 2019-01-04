package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_UNRP_PRIMEIRO_NIVEL_FLUXO")
public class PrimeiroNivelFluxo {
	
	@Id
	@Column(name = "codigo_nivel")
	private String codigoNivel;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "codigo_acesso")
	private String codigoAcesso;
	
	public String getCodigoNivel() {
		return codigoNivel;
	}

	public void setCodigoNivel(String codigoNivel) {
		this.codigoNivel = codigoNivel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}
}
