package br.coop.unimedriopardo.sgu.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.coop.unimedriopardo.sgu.models.Usuario;
import br.coop.unimedriopardo.sgu.repositories.RepositorioUsuario;

public class SguUserDetailsService implements UserDetailsService{
	

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = repositorioUsuario.findByLogin(login);
		if (usuario == null || usuario.getAtivo().equals("0")) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		Set<GrantedAuthority> perfis = new HashSet<GrantedAuthority>();
		perfis.add(new SimpleGrantedAuthority(usuario.getPerfil()));
		return new User(usuario.getLogin(), usuario.getSenha(), perfis);
	}
}
