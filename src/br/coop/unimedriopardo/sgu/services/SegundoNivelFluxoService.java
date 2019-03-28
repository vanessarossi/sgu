package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;

public interface SegundoNivelFluxoService {

	public List<SegundoNivelFluxo> pesquisarSegundoNivel(String codigoPrimeiroNivel);
	public String calcularSaldoReceita(String data, String codigoNivel);
	public String calcularSaldoDespesa(String data, String codigoNivel);
}
