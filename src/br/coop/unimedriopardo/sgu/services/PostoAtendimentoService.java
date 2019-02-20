package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import br.coop.unimedriopardo.sgu.util.view.PostoAtendimentoView;

public interface PostoAtendimentoService {

	public List<PostoAtendimentoView> listarPostosAtendimentoValorizado(String data);
	public String retornaSaldo(String postoAtendimento, String data);
	public String retornaSaldoTotalCaixas(String data);
}
