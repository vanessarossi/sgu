package br.coop.unimedriopardo.sgu.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioSegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioTerceiroNivelFluxo;

@Service
@Transactional
public class TerceiroNivelFluxoServiceImpl implements TerceiroNivelFluxoService{
	
private final RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo;
	
	@Autowired
	public TerceiroNivelFluxoServiceImpl(RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo) {
		super();
		this.repositorioTerceiroNivelFluxo = repositorioTerceiroNivelFluxo;
	}

	@Override
	public List<SegundoNivelFluxo> pesquisarTerceiroNivel(String codigoPrimeiroNivel, String codigoSegundoNivel) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
