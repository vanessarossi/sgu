package br.coop.unimedriopardo.sgu.util;

import java.util.List;

public class Demonstrativo {
	
	private String codigoId;

	private String totalReceitaAnterior;
	private String totalReceita;
	private String totalReceitaPrevisto;
	
	private String totalDespesaAnterior;
	private String totalDespesa;
	private String totalDespesaPrevisto;
	
	private String totalLiquidoAnterior;
	private String totalLiquido;
	private String totalLiquidoPrevisto;
	
	private List<DemonstrativoClassificacao> despesas;
	private List<DemonstrativoClassificacao> receitas;
	public String getCodigoId() {
		return codigoId;
	}
	public void setCodigoId(String codigoId) {
		this.codigoId = codigoId;
	}
	public String getTotalReceitaAnterior() {
		return totalReceitaAnterior;
	}
	public void setTotalReceitaAnterior(String totalReceitaAnterior) {
		this.totalReceitaAnterior = totalReceitaAnterior;
	}
	public String getTotalReceita() {
		return totalReceita;
	}
	public void setTotalReceita(String totalReceita) {
		this.totalReceita = totalReceita;
	}
	public String getTotalReceitaPrevisto() {
		return totalReceitaPrevisto;
	}
	public void setTotalReceitaPrevisto(String totalReceitaPrevisto) {
		this.totalReceitaPrevisto = totalReceitaPrevisto;
	}
	public String getTotalDespesaAnterior() {
		return totalDespesaAnterior;
	}
	public void setTotalDespesaAnterior(String totalDespesaAnterior) {
		this.totalDespesaAnterior = totalDespesaAnterior;
	}
	public String getTotalDespesa() {
		return totalDespesa;
	}
	public void setTotalDespesa(String totalDespesa) {
		this.totalDespesa = totalDespesa;
	}
	public String getTotalDespesaPrevisto() {
		return totalDespesaPrevisto;
	}
	public void setTotalDespesaPrevisto(String totalDespesaPrevisto) {
		this.totalDespesaPrevisto = totalDespesaPrevisto;
	}
	public String getTotalLiquidoAnterior() {
		return totalLiquidoAnterior;
	}
	public void setTotalLiquidoAnterior(String totalLiquidoAnterior) {
		this.totalLiquidoAnterior = totalLiquidoAnterior;
	}
	public String getTotalLiquido() {
		return totalLiquido;
	}
	public void setTotalLiquido(String totalLiquido) {
		this.totalLiquido = totalLiquido;
	}
	public String getTotalLiquidoPrevisto() {
		return totalLiquidoPrevisto;
	}
	public void setTotalLiquidoPrevisto(String totalLiquidoPrevisto) {
		this.totalLiquidoPrevisto = totalLiquidoPrevisto;
	}
	public List<DemonstrativoClassificacao> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<DemonstrativoClassificacao> despesas) {
		this.despesas = despesas;
	}
	public List<DemonstrativoClassificacao> getReceitas() {
		return receitas;
	}
	public void setReceitas(List<DemonstrativoClassificacao> receitas) {
		this.receitas = receitas;
	}
}
