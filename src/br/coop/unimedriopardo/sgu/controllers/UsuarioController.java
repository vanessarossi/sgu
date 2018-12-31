package br.coop.unimedriopardo.sgu.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.coop.unimedriopardo.sgu.models.Usuario;
import br.coop.unimedriopardo.sgu.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioService usuarioService;


	@Autowired
	public UsuarioController(UsuarioService usuarioService){
		this.usuarioService = usuarioService;

	}
	
	@RequestMapping("/formulario")
	public String form(Model model) {

		model.addAttribute("usuario", new Usuario());
		return "usuario.form.tiles";
	}
	

}
