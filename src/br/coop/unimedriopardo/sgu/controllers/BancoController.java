package br.coop.unimedriopardo.sgu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.coop.unimedriopardo.sgu.services.BancoService;

@Controller
@RequestMapping("/banco")
public class BancoController {

	private final BancoService bancoService;

	@Autowired
	public BancoController(BancoService bancoService) {
		this.bancoService = bancoService;
	}

	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("bancos", bancoService.listarContasBancarias());
		return "banco.index.tiles";
	}
}
