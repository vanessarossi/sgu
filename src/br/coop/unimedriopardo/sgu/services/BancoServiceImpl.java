package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.Banco;
import br.coop.unimedriopardo.sgu.repositories.RepositorioBanco;


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
	public List<Banco> listarContasBancarias() {
		return repositorioBanco.findAll();
	}

}
