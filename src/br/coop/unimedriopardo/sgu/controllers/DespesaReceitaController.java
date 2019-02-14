package br.coop.unimedriopardo.sgu.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.coop.unimedriopardo.sgu.services.PrimeiroNivelFluxoService;
import br.coop.unimedriopardo.sgu.services.SegundoNivelFluxoService;
import br.coop.unimedriopardo.sgu.services.TerceiroNivelFluxoService;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.TerceiroNivelView;

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
		model.addAttribute("dataEscolhida", new Conversor().formatarData(new Date(), "dd/MM/YYYY"));
		model.addAttribute("despesa", primeiroNivelFluxoService.pesquisarPrimeiroNivel("2"));
		model.addAttribute("receita",primeiroNivelFluxoService.pesquisarPrimeiroNivel("1"));
		
		model.addAttribute("saldoTotalReceitaNivel1", new Conversor().formataReal(primeiroNivelFluxoService.calcularSaldoReceita(new Conversor().formatarData(new Date(), "YYYYMMdd"))));
		model.addAttribute("saldoTotalDespesaNivel1", new Conversor().formataReal(primeiroNivelFluxoService.calcularSaldoDespesa(new Conversor().formatarData(new Date(), "YYYYMMdd"))));
		
		model.addAttribute("segundoNivelDespesas", segundoNivelFluxoService.pesquisarSegundoNivel("2", new Conversor().formatarData(new Date(), "YYYYMMdd")));
		model.addAttribute("segundoNivelReceitas",segundoNivelFluxoService.pesquisarSegundoNivel("1", new Conversor().formatarData(new Date(), "YYYYMMdd")));
		return "despesa.receita.index.tiles";
	}
	
	
	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public String consultar(@ModelAttribute("data") String data, Model model) {
		
		model.addAttribute("dataEscolhida", new Conversor().formatarDataString(data, "dd/MM/YYYY"));
		model.addAttribute("despesa", primeiroNivelFluxoService.pesquisarPrimeiroNivel("2"));
		model.addAttribute("receita",primeiroNivelFluxoService.pesquisarPrimeiroNivel("1"));
		
		model.addAttribute("saldoTotalReceitaNivel1", new Conversor().formataReal(primeiroNivelFluxoService.calcularSaldoReceita(new Conversor().formatarDataString(data, "YYYYMMdd"))));
		model.addAttribute("saldoTotalDespesaNivel1", new Conversor().formataReal(primeiroNivelFluxoService.calcularSaldoDespesa(new Conversor().formatarDataString(data, "YYYYMMdd"))));
		
		model.addAttribute("segundoNivelDespesas", segundoNivelFluxoService.pesquisarSegundoNivel("2", new Conversor().formatarDataString(data, "YYYYMMdd")));
		model.addAttribute("segundoNivelReceitas",segundoNivelFluxoService.pesquisarSegundoNivel("1", new Conversor().formatarDataString(data, "YYYYMMdd")));
		return "despesa.receita.index.tiles";
	}
	
	
	@RequestMapping(value="/pesquisaTerceiroNivel/{codigoPrimeiroNivel}/{codigoSegundoNivel}/{data}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TerceiroNivelView> listarTerceiroNivel(@PathVariable("codigoPrimeiroNivel") String codigoPrimeiroNivel,@PathVariable("codigoSegundoNivel") String codigoSegundoNivel, @PathVariable("data") String data){
		List<TerceiroNivelView> listaTerceiroNivel = terceiroNivelFluxoService.pesquisarTerceiroNivel(codigoPrimeiroNivel,codigoSegundoNivel, data);
		return listaTerceiroNivel;
	}
	
	
}
