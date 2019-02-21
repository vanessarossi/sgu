package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.coop.unimedriopardo.sgu.models.Receita;

public interface RepositorioReceita extends JpaRepository<Receita, String> {

}
