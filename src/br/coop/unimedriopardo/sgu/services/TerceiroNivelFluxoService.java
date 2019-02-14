package br.coop.unimedriopardo.sgu.services;


import java.util.List;
import br.coop.unimedriopardo.sgu.util.TerceiroNivelView;

public interface TerceiroNivelFluxoService {

	public List<TerceiroNivelView> pesquisarTerceiroNivel(String codigoPrimeiroNivel, String codigoSegundoNivel, String data);
	public String calcularSaldoReceita(String data, String codigoSegundoNivel, String codigoTerceiroNivel);
	public String calcularSaldoDespesa(String data, String codigoSegundoNivel, String codigoTerceiroNivel);
}
