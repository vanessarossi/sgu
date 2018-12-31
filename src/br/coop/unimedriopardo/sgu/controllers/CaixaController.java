package br.coop.unimedriopardo.sgu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "caixa.index.tiles";
	}

}
