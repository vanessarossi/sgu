package br.coop.unimedriopardo.sgu.services;


import java.util.List;
import br.coop.unimedriopardo.sgu.util.SegundoNivelView;

public interface SegundoNivelFluxoService {

	public List<SegundoNivelView> pesquisarSegundoNivel(String codigoPrimeiroNivel, String data);
	public String calcularSaldoReceita(String data, String codigoSegundoNivel02);
	public String calcularSaldoDespesa(String data, String codigoSegundoNivel02);
}
