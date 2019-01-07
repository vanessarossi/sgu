package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;

public interface QuintoNivelFluxoService {

	public List<SegundoNivelFluxo> pesquisarQuintoNivel(String codigoPrimeiroNivel, String codigoSegundoNivel, String codigoTerceiroNivel, String codigoQuartoNivel);
}
