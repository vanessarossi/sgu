package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import br.coop.unimedriopardo.sgu.models.Usuario;

public interface UsuarioService {
	
	public Usuario salvar(Usuario usuario);
	public List<Usuario> listagemOrdenada();
	public Usuario pesquisaPorId(Integer id);
	public void deletar(Integer id);
	public Usuario pesquisaPorLogin(String login);

}
