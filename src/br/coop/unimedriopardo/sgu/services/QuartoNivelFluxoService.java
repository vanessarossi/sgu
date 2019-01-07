package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.models.QuartoNivelFluxo;


public interface QuartoNivelFluxoService {

	public List<QuartoNivelFluxo> pesquisarQuartoNivel(String codigoPrimeiroNivel, String codigoSegundoNivel, String codigoTerceiroNivel);
	
	
}	