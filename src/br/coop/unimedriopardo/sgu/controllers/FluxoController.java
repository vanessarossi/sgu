package br.coop.unimedriopardo.sgu.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.coop.unimedriopardo.sgu.services.FluxoService;
import br.coop.unimedriopardo.sgu.services.SegundoNivelFluxoService;



@Controller
@RequestMapping("/fluxo")
public class FluxoController {
	
	
	private final FluxoService fluxoService;
	
	@Autowired
	public FluxoController(SegundoNivelFluxoService segundoNivelFluxoService, FluxoService fluxoService) {
		this.fluxoService = fluxoService;
	}

	@RequestMapping("")
	public String home(Model model) {

		return "fluxo.index.tiles";
	}
	/**
	@RequestMapping(value="/carregar/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Demonstrativo> carregarDemonstrativo(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){

		return null ;
	}
	
	@RequestMapping(value="/carregar/movimentacao/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ContaPrincipal> carregarMovimentacao(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		
		return null ;
	}
	
	**/

}
