package br.coop.unimedriopardo.sgu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.repositories.RepositorioSegundoNivelFluxo;



@Service
@Transactional
public class SegundoNivelFluxoServiceImpl implements SegundoNivelFluxoService{
	
private final RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo;
	
	@Autowired
	public SegundoNivelFluxoServiceImpl(RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo) {
		super();
		this.repositorioSegundoNivelFluxo = repositorioSegundoNivelFluxo;
	}
}
