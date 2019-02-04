package br.coop.unimedriopardo.sgu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;
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
		model.addAttribute("despesa", primeiroNivelFluxoService.pesquisarPrimeiroNivel("2"));
		model.addAttribute("receita",primeiroNivelFluxoService.pesquisarPrimeiroNivel("1"));
		
		model.addAttribute("segundoNivelDespesas", segundoNivelFluxoService.pesquisarSegundoNivel("2"));
		model.addAttribute("segundoNivelReceitas",segundoNivelFluxoService.pesquisarSegundoNivel("1"));
		return "despesa.receita.index.tiles";
	}
	
	
	@RequestMapping(value="/pesquisaTerceiroNivel/{codigoPrimeiroNivel}/{codigoSegundoNivel}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TerceiroNivelFluxo> listarTerceiroNivel(@PathVariable("codigoPrimeiroNivel") String codigoPrimeiroNivel,@PathVariable("codigoSegundoNivel") String codigoSegundoNivel){
		System.out.print("Primeiro"+codigoPrimeiroNivel);
		System.out.print("Segundo"+codigoSegundoNivel);
		List<TerceiroNivelFluxo> listaTerceiroNivel = terceiroNivelFluxoService.pesquisarTerceiroNivel(codigoPrimeiroNivel,codigoSegundoNivel);
		return listaTerceiroNivel;
	}
	
	
}
