package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.Comentario;
import br.coop.unimedriopardo.sgu.repositories.RepositorioComentario;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService{

	private final RepositorioComentario repositorioComentario;
	
	@Autowired
	public ComentarioServiceImpl(RepositorioComentario repositorioComentario) {
		super();
		this.repositorioComentario = repositorioComentario;
	}

	@Override
	public void salvar(Comentario comentario) {
		repositorioComentario.save(comentario);
	}

	@Override
	public void deletar(Integer id) {
		repositorioComentario.delete(id);
	}

	@Override
	public Comentario pesquisarPorCodigoECompetencia(String codigo, String competencia) {
		return repositorioComentario.findByCodigoAndCompetencia(codigo,competencia);
	}

	@Override
	public List<Comentario> listarTodos() {
		return repositorioComentario.findAll();
	}

	@Override
	public Comentario pesquisaPorId(Integer id) {
		return repositorioComentario.findOne(id);
	}
}
