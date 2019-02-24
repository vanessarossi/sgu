package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import br.coop.unimedriopardo.sgu.models.QuintoNivelFluxo;

public interface QuintoNivelFluxoService {
	
	public List<QuintoNivelFluxo> pesquisarPorPrimeiroNivelSegundoNivelETerceiroNivel(String codigoPrimeiroNivel,
										String codigoSegundoNivel,
										String codigoTerceiroNivel);

	
}
