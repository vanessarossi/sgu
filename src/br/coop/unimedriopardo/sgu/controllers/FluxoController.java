package br.coop.unimedriopardo.sgu.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.coop.unimedriopardo.sgu.models.Comentario;
import br.coop.unimedriopardo.sgu.models.Usuario;
import br.coop.unimedriopardo.sgu.services.ComentarioService;
import br.coop.unimedriopardo.sgu.services.FluxoService;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.MovimentoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.ConteudoDemonstrativoValorizado;


@Controller
@RequestMapping("/fluxo")
public class FluxoController {
	
	private final FluxoService fluxoService;
	private final ComentarioService comentarioService;
	
	@Autowired
	public FluxoController(FluxoService fluxoService,ComentarioService comentarioService) {
		this.fluxoService = fluxoService;
		this.comentarioService = comentarioService;
	}

	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("demonstrativos", fluxoService.montarDemonstrativo());
		model.addAttribute("filiais",fluxoService.montarFilial());
		return "fluxo.index.tiles";
	}
	
	@RequestMapping("/formulario/comentario")
	public String formulario(Model model) {
		model.addAttribute("comentario", new Comentario());
		return "fluxo.comentario.form.tiles";
	}
	
	@RequestMapping("/listagem/comentario")
	public String lista(Model model) {
		model.addAttribute("comentarios", comentarioService.listarTodos());
		return "fluxo.comentario.list.tiles";
	}
	
	
	@RequestMapping(value = "/salvar/comentario", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("comentario") @Valid Comentario comentario, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "fluxo.comentario.form.tiles";
		}
		comentarioService.salvar(comentario);
		return "redirect:/fluxo/listagem/comentario";
	}
	
	
	@RequestMapping(value="/pesquisa/comentario/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Comentario pesquisaComentario(@PathVariable("id") Integer id ){
		Comentario comentario = comentarioService.pesquisaPorId(id);
		return comentario ;
	}
	
	
	@RequestMapping(value = "/editar/comentario/{id}", method = RequestMethod.GET)
	public String editar(@ModelAttribute("id") Integer id, Model model) {
		Comentario comentario = comentarioService.pesquisaPorId(id);
		model.addAttribute("comentario", comentario);
		return "fluxo.comentario.form.tiles";
	}

	@RequestMapping(value = "/excluir/comentario/{id}", method = RequestMethod.GET)
	public String excluir(@ModelAttribute("id") Integer id, Model model) {
		comentarioService.deletar(id);
		return "redirect:/fluxo/listagem/comentario";
	}

	
	@RequestMapping(value="/carregar/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<DemonstrativoValorizadoView> carregarDemonstrativo(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<DemonstrativoValorizadoView> demonstrativos = fluxoService.valorizarDemonstrativo(dataInicial, dataFinal);
		return demonstrativos ;
	}
	
	
	@RequestMapping(value="/carregar/movimento/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MovimentoValorizadoView> carregarMovimentacao(@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<MovimentoValorizadoView> movimento = fluxoService.valorizarMovimento(dataInicial, dataFinal);
		return movimento ;
	}

	
	@RequestMapping(value="/carregar/receita/{codigoNivel}/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ConteudoDemonstrativoValorizado> carregarQuartoNivelReceita(@PathVariable("codigoNivel") String codigoNivel ,@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<ConteudoDemonstrativoValorizado> quintoNivel = fluxoService.valorizarQuintoNivel(codigoNivel.substring(0,1),codigoNivel.substring(1,3),codigoNivel.substring(3,5), dataInicial, dataFinal);
		return quintoNivel ;
	}

	
	@RequestMapping(value="/carregar/despesa/{codigoNivel}/{dataInicial}/{dataFinal}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ConteudoDemonstrativoValorizado> carregarQuartoNivelDespesa(@PathVariable("codigoNivel") String codigoNivel ,@PathVariable("dataInicial") String dataInicial, @PathVariable("dataFinal") String dataFinal){
		List<ConteudoDemonstrativoValorizado> quintoNivel = fluxoService.valorizarQuintoNivel(codigoNivel.substring(0,1),codigoNivel.substring(1,3),codigoNivel.substring(3,5), dataInicial, dataFinal);
		return quintoNivel ;
	}
	
	
}

