package br.coop.unimedriopardo.sgu.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.coop.unimedriopardo.sgu.models.Usuario;
import br.coop.unimedriopardo.sgu.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping("/formulario")
	public String form(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario.form.tiles";
	}

	@RequestMapping("/listagem")
	public String list(Model model) {
		model.addAttribute("usuarios", usuarioService.listagemOrdenada());
		return "usuario.list.tiles";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "usuario.form.tiles";
		}
		usuarioService.salvar(usuario);
		return "redirect:/usuario/listagem";
	}

	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public String editar(@ModelAttribute("id") Integer id, Model model) {
		Usuario usuario = usuarioService.pesquisaPorId(id);
		model.addAttribute("usuario", usuario);
		return "usuario.form.tiles";
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@ModelAttribute("id") Integer id, Model model) {
		usuarioService.deletar(id);
		return "redirect:/usuario/listagem";
	}
}
