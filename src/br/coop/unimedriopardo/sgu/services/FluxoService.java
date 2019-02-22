package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.models.Filial;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.MovimentoValorizadoView;

public interface FluxoService {
	
	public List<DemonstrativoView> montarDemonstrativo();
	public List<Filial> montarFilial();
	
	public List<DemonstrativoValorizadoView> valorizarDemonstrativo(String dataInicial, String dataFinal);
	public List<MovimentoValorizadoView> valorizarMovimento(String dataInicial, String dataFinal);
	

}
