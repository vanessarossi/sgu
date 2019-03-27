package br.coop.unimedriopardo.sgu.services;


import java.util.List;
import br.coop.unimedriopardo.sgu.util.view.BancoView;

public interface BancoService {

	public List<BancoView> listarContasBancariaValorizada(String data);
	public String retornaSaldo(String codigoConta, String data);
	public String retornaSaldoTotalContas(String data);
	public String retornaSaldoTotalContaCorrente(String data);
	public String retornaSaldoTotalContaAplicacao(String data);
	public String retornaSaldoTotalContaAplicacaoAns(String data);
	
}
