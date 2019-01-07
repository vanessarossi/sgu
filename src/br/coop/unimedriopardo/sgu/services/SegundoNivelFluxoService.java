package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;

public interface SegundoNivelFluxoService {

	public List<SegundoNivelFluxo> pesquisarSegundoNivelPorCodigoPrimeiroNivel(String codigoPrimeiroNivel);
}
