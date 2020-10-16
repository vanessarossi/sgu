package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.unimedriopardo.sgu.models.Comentario;

public interface RepositorioComentario extends JpaRepository<Comentario, Integer> {

	public Comentario findByCodigoAndCompetencia(String codigo, String competencia);

}
