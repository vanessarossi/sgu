package br.coop.unimedriopardo.sgu.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.models.QuartoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioQuartoNivelFluxo;

@Service
@Transactional
public class QuartoNivelFluxoServiceImpl implements QuartoNivelFluxoService{
	
	private final RepositorioQuartoNivelFluxo repositorioQuartoNivelFluxo;
	
	@Autowired
	public QuartoNivelFluxoServiceImpl(RepositorioQuartoNivelFluxo repositorioQuartoNivelFluxo) {
		super();
		this.repositorioQuartoNivelFluxo = repositorioQuartoNivelFluxo;
	}

	@Override
	public List<QuartoNivelFluxo> pesquisarQuartoNivel(String codigoPrimeiroNivel, String codigoSegundoNivel,
			String codigoTerceiroNivel) {
		return repositorioQuartoNivelFluxo.findAll();
	}

	
}
