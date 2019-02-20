package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_UNRP_CONTA_BANCARIA")
public class Banco {

	@Id
	@Column(name = "codigo_conta")
	private String codigoConta;
	
	@Column(name = "nome_conta")
	private String nomeConta;
	
	@Column(name = "codigo_filial")
	private String codigoFilial;
	
	@Column(name = "razao_filial")
	private String razaoFilial;
	
	@Column(name = "conta_aplicacao")
	private String contaAplicacao;

	public String getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(String codigoConta) {
		this.codigoConta = codigoConta;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
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

	public String getContaAplicacao() {
		return contaAplicacao;
	}

	public void setContaAplicacao(String contaAplicacao) {
		this.contaAplicacao = contaAplicacao;
	}
		
}
