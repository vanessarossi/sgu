package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_UNRP_CONTA_BANCARIA")
public class Banco {

	@Column(name = "filial")
	private String filial;
	
	@Column(name = "codigo_filial")
	private String codigoFilial;

	@Id
	@Column(name = "codigo_conta")
	private String codigoConta;
	
	@Column(name = "nome_conta")
	private String nomeConta;

	@Column(name = "conta_aplicacao")
	private String contaAplicacao;
	
	@Column(name = "saldo")
	private String saldo;

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getCodigoFilial() {
		return codigoFilial;
	}

	public void setCodigoFilial(String codigoFilial) {
		this.codigoFilial = codigoFilial;
	}

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

	public String getContaAplicacao() {
		return contaAplicacao;
	}

	public void setContaAplicacao(String contaAplicacao) {
		this.contaAplicacao = contaAplicacao;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
}
