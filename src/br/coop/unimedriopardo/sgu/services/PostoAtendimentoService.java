package br.coop.unimedriopardo.sgu.services;

import java.util.List;


import br.coop.unimedriopardo.sgu.models.PostoAtendimento;

public interface PostoAtendimentoService {

	public List<PostoAtendimento> listarPostosAtendimento();
	public String retornaSaldo(String postoAtendimento, String data);
}
