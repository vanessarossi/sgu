package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoView;

public interface FluxoService {
	
	public List<DemonstrativoView> montarDemonstrativo();
	
	public List<DemonstrativoValorizadoView> valorizarDemonstrativo(String dataInicial, String dataFinal);

}
