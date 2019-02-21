package br.coop.unimedriopardo.sgu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.coop.unimedriopardo.sgu.services.PrimeiroNivelFluxoService;
import br.coop.unimedriopardo.sgu.services.SegundoNivelFluxoService;
import br.coop.unimedriopardo.sgu.services.TerceiroNivelFluxoService;


@Controller
@RequestMapping("/despesareceita")
public class DespesaReceitaController {

	
	private final PrimeiroNivelFluxoService primeiroNivelFluxoService;
	private final SegundoNivelFluxoService segundoNivelFluxoService;
	private final TerceiroNivelFluxoService terceiroNivelFluxoService;

	@Autowired
	public DespesaReceitaController(PrimeiroNivelFluxoService primeiroNivelFluxoService, SegundoNivelFluxoService segundoNivelFluxoService, TerceiroNivelFluxoService terceiroNivelFluxoService) {
		this.primeiroNivelFluxoService = primeiroNivelFluxoService;
		this.segundoNivelFluxoService = segundoNivelFluxoService;
		this.terceiroNivelFluxoService = terceiroNivelFluxoService;
	}
	
	
	@RequestMapping("")
	public String home(Model model) {

		return "despesa.receita.index.tiles";
	}
	
	
	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public String consultar(@ModelAttribute("data") String data, Model model) {
	
		return "despesa.receita.index.tiles";
	}
	
	/**
	@RequestMapping(value="/pesquisaTerceiroNivel/{codigoPrimeiroNivel}/{codigoSegundoNivel}/{data}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TerceiroNivelView> listarTerceiroNivel(@PathVariable("codigoPrimeiroNivel") String codigoPrimeiroNivel,@PathVariable("codigoSegundoNivel") String codigoSegundoNivel, @PathVariable("data") String data){
		List<TerceiroNivelView> listaTerceiroNivel = terceiroNivelFluxoService.pesquisarTerceiroNivel(codigoPrimeiroNivel,codigoSegundoNivel, data);
		return listaTerceiroNivel;
	}
	**/
	
}
