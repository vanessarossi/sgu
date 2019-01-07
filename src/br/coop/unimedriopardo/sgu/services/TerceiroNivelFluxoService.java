package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;

public interface TerceiroNivelFluxoService {

	public List<SegundoNivelFluxo> pesquisarTerceiroNivel(String codigoPrimeiroNivel, String codigoSegundoNivel);
}
