package br.coop.unimedriopardo.sgu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/banco")
public class BancoController {

		@RequestMapping("")
		public String home() {
			return "banco.index.tiles";
		}
}
