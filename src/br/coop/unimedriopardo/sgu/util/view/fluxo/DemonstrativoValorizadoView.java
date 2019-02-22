package br.coop.unimedriopardo.sgu.util.view.fluxo;

import java.util.List;

public class DemonstrativoValorizadoView {
	
	private String codigoId;
	private String valorReceitaAnterior;
	private String valorReceita;
	private String valorReceitaPrevisao;
	private String valorDespesaAnterior;
	private String valorDespesa;
	private String valorDespesaPrevisao;
	
	private String valorLiquidoAnterior;
	private String valorLiquido;
	private String valorLiquidoPrevisao;
	
	List<TerceiroNivelDemonstrativoValorizadoView> receitas;
	List<TerceiroNivelDemonstrativoValorizadoView> despesas;
	public String getCodigoId() {
		return codigoId;
	}
	public void setCodigoId(String codigoId) {
		this.codigoId = codigoId;
	}
	public String getValorReceitaAnterior() {
		return valorReceitaAnterior;
	}
	public void setValorReceitaAnterior(String valorReceitaAnterior) {
		this.valorReceitaAnterior = valorReceitaAnterior;
	}
	public String getValorReceita() {
		return valorReceita;
	}
	public void setValorReceita(String valorReceita) {
		this.valorReceita = valorReceita;
	}
	public String getValorReceitaPrevisao() {
		return valorReceitaPrevisao;
	}
	public void setValorReceitaPrevisao(String valorReceitaPrevisao) {
		this.valorReceitaPrevisao = valorReceitaPrevisao;
	}
	public String getValorDespesaAnterior() {
		return valorDespesaAnterior;
	}
	public void setValorDespesaAnterior(String valorDespesaAnterior) {
		this.valorDespesaAnterior = valorDespesaAnterior;
	}
	public String getValorDespesa() {
		return valorDespesa;
	}
	public void setValorDespesa(String valorDespesa) {
		this.valorDespesa = valorDespesa;
	}
	public String getValorDespesaPrevisao() {
		return valorDespesaPrevisao;
	}
	public void setValorDespesaPrevisao(String valorDespesaPrevisao) {
		this.valorDespesaPrevisao = valorDespesaPrevisao;
	}
	public String getValorLiquidoAnterior() {
		return valorLiquidoAnterior;
	}
	public void setValorLiquidoAnterior(String valorLiquidoAnterior) {
		this.valorLiquidoAnterior = valorLiquidoAnterior;
	}
	public String getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(String valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	public String getValorLiquidoPrevisao() {
		return valorLiquidoPrevisao;
	}
	public void setValorLiquidoPrevisao(String valorLiquidoPrevisao) {
		this.valorLiquidoPrevisao = valorLiquidoPrevisao;
	}
	public List<TerceiroNivelDemonstrativoValorizadoView> getReceitas() {
		return receitas;
	}
	public void setReceitas(List<TerceiroNivelDemonstrativoValorizadoView> receitas) {
		this.receitas = receitas;
	}
	public List<TerceiroNivelDemonstrativoValorizadoView> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<TerceiroNivelDemonstrativoValorizadoView> despesas) {
		this.despesas = despesas;
	}
	
	
	
	
}
