package br.coop.unimedriopardo.sgu.services;


import java.util.List;

import br.coop.unimedriopardo.sgu.models.Banco;

public interface BancoService {

	public List<Banco> listarContasBancarias(String data);
	public String retornaSaldo(String codigoConta, String data);
	
}
