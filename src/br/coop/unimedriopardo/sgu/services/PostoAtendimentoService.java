package br.coop.unimedriopardo.sgu.services;

import java.util.List;


import br.coop.unimedriopardo.sgu.models.PostoAtendimento;

public interface PostoAtendimentoService {

	public List<PostoAtendimento> listarPostosAtendimento();
	public List<PostoAtendimento> listarPostosAtendimentoPorDiaEscolhido(String data);
	public String retornaSaldo(String postoAtendimento, String data);
	public String retornaSaldoTotalCaixas();
	public String retornaSaldoTotalCaixasPorDiaEscolhido(String data);
}
