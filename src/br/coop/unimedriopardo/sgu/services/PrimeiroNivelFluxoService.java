package br.coop.unimedriopardo.sgu.services;

import br.coop.unimedriopardo.sgu.models.PrimeiroNivelFluxo;

public interface PrimeiroNivelFluxoService {
	
	public PrimeiroNivelFluxo pesquisarPrimeiroNivel(String codigoNivel);
	public String calcularSaldoReceita(String data);
	public String calcularSaldoDespesa(String data);

}
