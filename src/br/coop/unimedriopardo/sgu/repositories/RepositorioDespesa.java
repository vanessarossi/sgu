package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import br.coop.unimedriopardo.sgu.models.Despesa;

public interface RepositorioDespesa extends JpaRepository<Despesa, String>{

}
