package br.coop.unimedriopardo.uniresultado.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/despesareceita")
public class DespesaReceitaController {

	@RequestMapping("")
	public String home() {
		return "despesa.receita.index.tiles";
	}
}
