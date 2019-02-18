package br.coop.unimedriopardo.sgu.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.coop.unimedriopardo.sgu.services.FluxoService;
import br.coop.unimedriopardo.sgu.services.SegundoNivelFluxoService;
import br.coop.unimedriopardo.sgu.util.ContaPrincipal;
import br.coop.unimedriopardo.sgu.util.Demonstrativo;


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
		model.addAttribute("demonstrativos", fluxoService.carregarDemonstrativos());
		model.addAttribute("contas",fluxoService.carregarContas());
		return "fluxo.index.tiles";
	}
	
	@RequestMapping(value="/carregar/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Demonstrativo> carregarDemonstrativo(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<Demonstrativo> demonstrativos = fluxoService.valorizarDemonstrativo(dataInicial,dataFinal);
		return demonstrativos ;
	}
	
	@RequestMapping(value="/carregar/movimentacao/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ContaPrincipal> carregarMovimentacao(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<ContaPrincipal> movimentacao = fluxoService.valorizarConta(dataInicial, dataFinal);
		return movimentacao ;
	}

}
