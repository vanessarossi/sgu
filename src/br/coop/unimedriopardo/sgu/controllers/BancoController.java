package br.coop.unimedriopardo.sgu.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.coop.unimedriopardo.sgu.services.BancoService;
import br.coop.unimedriopardo.sgu.util.Conversor;

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
		model.addAttribute("bancos", bancoService.listarContasBancarias(new Conversor().formatarData(new Date(), "YYYYMMdd")));
		model.addAttribute("dataAtual", new Conversor().formatarData(new Date(), "dd/MM/YYYY"));
		return "banco.index.tiles";
	}
}
