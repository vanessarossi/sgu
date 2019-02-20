package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_UNRP_POSTO_ATENDIMENTO")
public class PostoAtendimento {
	
	@Id
	@Column(name = "codigo_posto")
	private String codigoPosto;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "codigo_filial")
	private String codigoFilial;
	
	@Column(name = "razao_filial")
	private String razaoFilial;

	public String getCodigoPosto() {
		return codigoPosto;
	}

	public void setCodigoPosto(String codigoPosto) {
		this.codigoPosto = codigoPosto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoFilial() {
		return codigoFilial;
	}

	public void setCodigoFilial(String codigoFilial) {
		this.codigoFilial = codigoFilial;
	}

	public String getRazaoFilial() {
		return razaoFilial;
	}

	public void setRazaoFilial(String razaoFilial) {
		this.razaoFilial = razaoFilial;
	}
		
}
