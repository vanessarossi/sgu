package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.models.Banco;

public interface BancoService {

	public List<Banco> listarContasBancarias(String data);
	public List<Banco> listarContasBancariasPorDiaEscolhido(String data);
	public String retornaSaldo(String codigoConta, String data);
	public String retornaSaldoTotalContas();
	public String retornaSaldoTotalCaixasPorDiaEscolhido(String data);
	
}
