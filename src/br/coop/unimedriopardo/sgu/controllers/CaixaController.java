package br.coop.unimedriopardo.sgu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.coop.unimedriopardo.sgu.services.PostoAtendimentoService;

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
		model.addAttribute("postosAtendimento", postoAtendimentoService.listarPostosAtendimento());
		model.addAttribute("saldoTotal",postoAtendimentoService.retornaSaldoTotalCaixas());
		return "caixa.index.tiles";
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public String consultar(@ModelAttribute("data") String data, Model model) {
		model.addAttribute("postosAtendimento", postoAtendimentoService.listarPostosAtendimentoPorDiaEscolhido(data));
		model.addAttribute("saldoTotal",postoAtendimentoService.retornaSaldoTotalCaixasPorDiaEscolhido(data));
		return "caixa.index.tiles";
	}

}
