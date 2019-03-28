package br.coop.unimedriopardo.sgu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.repositories.RepositorioQuintoNivelFluxo;

@Service
@Transactional
public class QuintoNivelFluxoServiceImpl implements QuintoNivelFluxoService{
	
	
	private final RepositorioQuintoNivelFluxo repositorioQuintoNivelFluxo;
	
	@Autowired
	public QuintoNivelFluxoServiceImpl(RepositorioQuintoNivelFluxo repositorioQuintoNivelFluxo) {
		super();
		this.repositorioQuintoNivelFluxo = repositorioQuintoNivelFluxo;
	}
	

	
		
}
