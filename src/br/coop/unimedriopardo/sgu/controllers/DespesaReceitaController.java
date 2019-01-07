package br.coop.unimedriopardo.sgu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.coop.unimedriopardo.sgu.services.PrimeiroNivelFluxoService;
import br.coop.unimedriopardo.sgu.services.SegundoNivelFluxoService;

@Controller
@RequestMapping("/despesareceita")
public class DespesaReceitaController {

	
	private final PrimeiroNivelFluxoService primeiroNivelFluxoService;
	private final SegundoNivelFluxoService segundoNivelFluxoService;

	@Autowired
	public DespesaReceitaController(PrimeiroNivelFluxoService primeiroNivelFluxoService, SegundoNivelFluxoService segundoNivelFluxoService) {
		this.primeiroNivelFluxoService = primeiroNivelFluxoService;
		this.segundoNivelFluxoService = segundoNivelFluxoService;
	}
	
	
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("despesa", primeiroNivelFluxoService.pesquisarPrimeiroNivelPorCodigoNivel("2"));
		model.addAttribute("segundoNivelDespesas", segundoNivelFluxoService.pesquisarSegundoNivelPorCodigoPrimeiroNivel("2"));
		model.addAttribute("receita",primeiroNivelFluxoService.pesquisarPrimeiroNivelPorCodigoNivel("1"));
		model.addAttribute("segundoNivelReceitas",segundoNivelFluxoService.pesquisarSegundoNivelPorCodigoPrimeiroNivel("1"));
		return "despesa.receita.index.tiles";
	}
	
	
}
