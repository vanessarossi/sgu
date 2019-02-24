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
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.MovimentoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.QuartoNivelDemonstrativoValorizado;


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
		model.addAttribute("demonstrativos", fluxoService.montarDemonstrativo());
		model.addAttribute("filiais",fluxoService.montarFilial());
		return "fluxo.index.tiles";
	}
	
	@RequestMapping(value="/carregar/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<DemonstrativoValorizadoView> carregarDemonstrativo(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<DemonstrativoValorizadoView> demonstrativos = fluxoService.valorizarDemonstrativo(dataInicial, dataFinal);
		return demonstrativos ;
	}
	
	
	@RequestMapping(value="/carregar/movimento/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MovimentoValorizadoView> carregarMovimentacao(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<MovimentoValorizadoView> movimento = fluxoService.valorizarMovimento(dataInicial, dataFinal);
		return movimento ;
	}

	
	@RequestMapping(value="/carregar/receita/{codigoNivel}/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<QuartoNivelDemonstrativoValorizado> carregarQuintoNivelReceita(@PathVariable("codigoNivel") String codigoNivel ,@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<QuartoNivelDemonstrativoValorizado> quintoNivel = fluxoService.valorizarQuintoNivel(codigoNivel.substring(0,1),codigoNivel.substring(1,3),codigoNivel.substring(3,5), dataInicial, dataFinal);
		return quintoNivel ;
	}

	
	@RequestMapping(value="/carregar/despesa/{codigoNivel}/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<QuartoNivelDemonstrativoValorizado> carregarQuintoNivelDespesa(@PathVariable("codigoNivel") String codigoNivel ,@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<QuartoNivelDemonstrativoValorizado> quintoNivel = fluxoService.valorizarQuintoNivel(codigoNivel.substring(0,1),codigoNivel.substring(1,3),codigoNivel.substring(3,5), dataInicial, dataFinal);
		return quintoNivel ;
	}
}

