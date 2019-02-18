package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import br.coop.unimedriopardo.sgu.models.ContaFluxo;
import br.coop.unimedriopardo.sgu.util.ContaPrincipal;
import br.coop.unimedriopardo.sgu.util.Demonstrativo;
import br.coop.unimedriopardo.sgu.util.DemonstrativoView;

public interface FluxoService {
	
	public List<DemonstrativoView> carregarDemonstrativos();
	public List<ContaFluxo> listarContas();
	public List<ContaPrincipal> valorizarConta(String dataInicial, String dataFinal);
	public List<ContaFluxo> carregarContas();
	public List<Demonstrativo> valorizarDemonstrativo(String dataInicial, String dataFinal);


}
