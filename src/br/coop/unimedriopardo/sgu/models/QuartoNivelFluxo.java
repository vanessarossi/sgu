package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_UNRP_QUARTO_NIVEL_FLUXO")
public class QuartoNivelFluxo {
	
	@Column(name = "codigo_primeiro_nivel")
	private String codigoPrimeiroNivel;
	
	@Column(name = "codigo_segundo_nivel")
	private String codigoSegundoNivel;
	
	@Column(name = "codigo_terceiro_nivel")
	private String codigoTerceiroNivel;
	
	@Id
	@Column(name = "codigo_nivel")
	private String codigoNivel;
		
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "codigo_acesso")
	private String codigoAcesso;

	public String getCodigoPrimeiroNivel() {
		return codigoPrimeiroNivel;
	}

	public void setCodigoPrimeiroNivel(String codigoPrimeiroNivel) {
		this.codigoPrimeiroNivel = codigoPrimeiroNivel;
	}

	public String getCodigoSegundoNivel() {
		return codigoSegundoNivel;
	}

	public void setCodigoSegundoNivel(String codigoSegundoNivel) {
		this.codigoSegundoNivel = codigoSegundoNivel;
	}

	public String getCodigoTerceiroNivel() {
		return codigoTerceiroNivel;
	}

	public void setCodigoTerceiroNivel(String codigoTerceiroNivel) {
		this.codigoTerceiroNivel = codigoTerceiroNivel;
	}

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
