package br.coop.unimedriopardo.sgu.services;


import java.util.List;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;

public interface TerceiroNivelFluxoService {

	public List<TerceiroNivelFluxo> pesquisarTerceiroNivel(String codigoPrimeiroNivel, String codigoSegundoNivel);
}
