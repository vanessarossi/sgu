package br.coop.unimedriopardo.uniresultado.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/caixa")
public class CaixaController {

	@RequestMapping("")
	public String home() {
		return "caixa.index.tiles";
	}

}
