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
	
	private final SegundoNivelFluxoService segundoNivelFluxoService;
	private final FluxoService fluxoService;
	
	@Autowired
	public FluxoController(SegundoNivelFluxoService segundoNivelFluxoService, FluxoService fluxoService) {
		this.segundoNivelFluxoService = segundoNivelFluxoService;
		this.fluxoService = fluxoService;
	}

	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("centrosCusto", segundoNivelFluxoService.pesquisarDescricoes("2"));
		model.addAttribute("principaisContas", fluxoService.carregarContasValorizadas("2019-01-31"));
		return "fluxo.index.tiles";
	}

}
