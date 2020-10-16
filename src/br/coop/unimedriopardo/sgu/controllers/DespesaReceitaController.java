package br.coop.unimedriopardo.sgu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.coop.unimedriopardo.sgu.services.DespesaReceitaService;
import br.coop.unimedriopardo.sgu.services.PrimeiroNivelFluxoService;
import br.coop.unimedriopardo.sgu.services.SegundoNivelFluxoService;
import br.coop.unimedriopardo.sgu.util.view.DespesaReceitaValorizada;
import br.coop.unimedriopardo.sgu.util.view.DetalheValorizado;

@Controller
@RequestMapping("/despesareceita")
public class DespesaReceitaController {

	private final PrimeiroNivelFluxoService primeiroNivelFluxoService;
	private final SegundoNivelFluxoService segundoNivelFluxoService;
	private final DespesaReceitaService despesaReceitaService;
	
	@Autowired
	public DespesaReceitaController(PrimeiroNivelFluxoService primeiroNivelFluxoService, SegundoNivelFluxoService segundoNivelFluxoService,
			DespesaReceitaService despesaReceitaService) {
		this.primeiroNivelFluxoService = primeiroNivelFluxoService;
		this.segundoNivelFluxoService = segundoNivelFluxoService;
		this.despesaReceitaService = despesaReceitaService;
	}
	
	
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("receita",primeiroNivelFluxoService.pesquisarPrimeiroNivel("1"));
		model.addAttribute("segundoNivelReceitas",segundoNivelFluxoService.pesquisarSegundoNivel("1"));
		
		model.addAttribute("despesa",primeiroNivelFluxoService.pesquisarPrimeiroNivel("2"));
		model.addAttribute("segundoNivelDespesas",segundoNivelFluxoService.pesquisarSegundoNivel("2"));
		return "despesa.receita.index.tiles";
	}
	
	@RequestMapping(value="/calcular/segundoNivel/{data}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<DespesaReceitaValorizada> pesquisaComentario(@PathVariable("data") String data ){
			List<DespesaReceitaValorizada> despesasReceitas = despesaReceitaService.calcularValorReceitaDespesa(data); 
		return despesasReceitas ;
	}
	
	@RequestMapping(value="/calcular/detalhe/{codigoPrimeiroNivel}/{codigoNivel}/{data}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<DetalheValorizado> pesquisaDetalhe(@PathVariable("codigoPrimeiroNivel") String codigoPrimeiroNivel, @PathVariable("codigoNivel") String codigoNivel, @PathVariable("data") String data ){
			List<DetalheValorizado> detalhes = despesaReceitaService.calcularDetalhe(codigoPrimeiroNivel, codigoNivel, data);
		return detalhes ;
	}
		
}
