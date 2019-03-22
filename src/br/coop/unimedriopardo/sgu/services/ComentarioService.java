package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import br.coop.unimedriopardo.sgu.models.Comentario;

public interface ComentarioService {
	
	public void salvar(Comentario comentario);
	public void deletar(Integer id);
	public Comentario pesquisarPorCodigoECompetencia(String codigo, String competencia);
	public List<Comentario> listarTodos();
	public Comentario pesquisaPorId(Integer id);
}
