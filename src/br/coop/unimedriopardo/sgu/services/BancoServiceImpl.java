package br.coop.unimedriopardo.sgu.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.Banco;
import br.coop.unimedriopardo.sgu.repositories.RepositorioBanco;
import br.coop.unimedriopardo.sgu.util.Conversor;


@Service
@Transactional
public class BancoServiceImpl implements BancoService {

	private final RepositorioBanco repositorioBanco;
	
	@Autowired
	public BancoServiceImpl(RepositorioBanco repositorioBanco) {
		super();
		this.repositorioBanco = repositorioBanco;
	}

	@Override
	public List<Banco> listarContasBancarias(String data) {
		
		List<Banco> contasBancarias = repositorioBanco.findAll();
		for (Banco banco : contasBancarias) {
			banco.setSaldo(new Conversor().formataReal(retornaSaldo(banco.getCodigoConta(), data)));
		}
		return contasBancarias;
	}

	@Override
	public String retornaSaldo(String codigoConta, String data) {
		return repositorioBanco.calcularSaldo(codigoConta, data);
	}

}
