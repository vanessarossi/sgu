package br.coop.unimedriopardo.sgu.util.view.fluxo;

public class MovimentoValorizadoView {
	
	private String codigoId;
	private String saldoLiquidoAnterior;
	private String saldoBanco;
	private String saldoCaixa;
	private String saldoLiquido;
	private String saldoTranferenciaRealizada;
	private String saldoTranferenciaRecebida;
	
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
	public String getSaldoBanco() {
		return saldoBanco;
	}
	public void setSaldoBanco(String saldoBanco) {
		this.saldoBanco = saldoBanco;
	}
	public String getSaldoCaixa() {
		return saldoCaixa;
	}
	public void setSaldoCaixa(String saldoCaixa) {
		this.saldoCaixa = saldoCaixa;
	}
	public String getSaldoLiquido() {
		return saldoLiquido;
	}
	public void setSaldoLiquido(String saldoLiquido) {
		this.saldoLiquido = saldoLiquido;
	}
	public String getSaldoTranferenciaRealizada() {
		return saldoTranferenciaRealizada;
	}
	public void setSaldoTranferenciaRealizada(String saldoTranferenciaRealizada) {
		this.saldoTranferenciaRealizada = saldoTranferenciaRealizada;
	}
	public String getSaldoTranferenciaRecebida() {
		return saldoTranferenciaRecebida;
	}
	public void setSaldoTranferenciaRecebida(String saldoTranferenciaRecebida) {
		this.saldoTranferenciaRecebida = saldoTranferenciaRecebida;
	}
}
