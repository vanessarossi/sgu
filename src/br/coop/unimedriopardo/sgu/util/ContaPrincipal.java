package br.coop.unimedriopardo.sgu.util;

import br.coop.unimedriopardo.sgu.models.ContaFluxo;

public class ContaPrincipal {
	
	private ContaFluxo contaFluxo;
	private String competencia;
	private String valorBanco;
	private String valorCaixa;
	private String valorTotal;
	public ContaFluxo getContaFluxo() {
		return contaFluxo;
	}
	public void setContaFluxo(ContaFluxo contaFluxo) {
		this.contaFluxo = contaFluxo;
	}
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	public String getValorBanco() {
		return valorBanco;
	}
	public void setValorBanco(String valorBanco) {
		this.valorBanco = valorBanco;
	}
	public String getValorCaixa() {
		return valorCaixa;
	}
	public void setValorCaixa(String valorCaixa) {
		this.valorCaixa = valorCaixa;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
}
