package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.unimedriopardo.sgu.models.Banco;


public interface RepositorioBanco extends JpaRepository<Banco, String> {

}
