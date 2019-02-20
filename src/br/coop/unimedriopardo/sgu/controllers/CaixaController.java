package br.coop.unimedriopardo.sgu.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.coop.unimedriopardo.sgu.services.PostoAtendimentoService;
import br.coop.unimedriopardo.sgu.util.Conversor;

@Controller
@RequestMapping("/caixa")
public class CaixaController {

	private final PostoAtendimentoService postoAtendimentoService;

	@Autowired
	public CaixaController(PostoAtendimentoService postoAtendimentoService) {
		this.postoAtendimentoService = postoAtendimentoService;
	}

	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("postosAtendimento", postoAtendimentoService.listarPostosAtendimentoValorizado(new Conversor().formatarData(new Date(),"YYYYMMdd")));
		model.addAttribute("saldoTotal",postoAtendimentoService.retornaSaldoTotalCaixas(new Conversor().formatarData(new Date(),"YYYYMMdd")));
		model.addAttribute("dataEscolhida", new Conversor().formatarData(new Date(), "dd/MM/YYYY"));
		return "caixa.index.tiles";
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public String consultar(@ModelAttribute("data") String data, Model model) {
		model.addAttribute("postosAtendimento", postoAtendimentoService.listarPostosAtendimentoValorizado(new Conversor().formatarDataString(data,"YYYYMMdd")));
		model.addAttribute("saldoTotal",postoAtendimentoService.retornaSaldoTotalCaixas(new Conversor().formatarDataString(data,"YYYYMMdd")));
		model.addAttribute("dataEscolhida", new Conversor().formatarDataString(data, "dd/MM/YYYY"));
		return "caixa.index.tiles";
	}

}
