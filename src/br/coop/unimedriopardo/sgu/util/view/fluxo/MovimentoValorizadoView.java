package br.coop.unimedriopardo.sgu.util.view.fluxo;

public class MovimentoValorizadoView {
	
	//private String saldoBanco;
	//private String saldoCaixa;
	//private String saldoTranferenciaRealizada;
	//private String saldoTranferenciaRecebida;
	
	
	private String codigoId;
	private String saldoLiquidoAnterior;
	private String totalReceita;
	private String totalDespesa;
	private String saldoLiquido;
	public String getCodigoId() {
		return codigoId;
	}
	public void setCodigoId(String codigoId) {
		this.codigoId = codigoId;
	}
	public String getSaldoLiquidoAnterior() {
		return saldoLiquidoAnterior;
	}
	public void setSaldoLiquidoAnterior(String saldoLiquidoAnterior) {
		this.saldoLiquidoAnterior = saldoLiquidoAnterior;
	}
	public String getTotalReceita() {
		return totalReceita;
	}
	public void setTotalReceita(String totalReceita) {
		this.totalReceita = totalReceita;
	}
	public String getTotalDespesa() {
		return totalDespesa;
	}
	public void setTotalDespesa(String totalDespesa) {
		this.totalDespesa = totalDespesa;
	}
	public String getSaldoLiquido() {
		return saldoLiquido;
	}
	public void setSaldoLiquido(String saldoLiquido) {
		this.saldoLiquido = saldoLiquido;
	}
	
}
