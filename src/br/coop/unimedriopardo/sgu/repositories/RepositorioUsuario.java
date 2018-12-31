package br.coop.unimedriopardo.sgu.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.unimedriopardo.sgu.models.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

	public Usuario findByLogin(String login);
}
