package br.coop.unimedriopardo.uniresultado.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fluxo")
public class FluxoController {

	@RequestMapping("")
	public String home() {
		return "fluxo.index.tiles";
	}
}
