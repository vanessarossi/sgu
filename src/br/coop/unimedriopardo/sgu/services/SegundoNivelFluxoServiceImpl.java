package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
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

	@Override
	public List<SegundoNivelFluxo> pesquisarSegundoNivel(String codigoPrimeiroNivel) {
		return repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel(codigoPrimeiroNivel);
	}

	@Override
	public String calcularSaldoReceita(String data, String codigoNivel) {
		return repositorioSegundoNivelFluxo.calcularReceita(data, codigoNivel);
	}

	@Override
	public String calcularSaldoDespesa(String data, String codigoNivel) {
		return repositorioSegundoNivelFluxo.calcularDespesa(data, codigoNivel);
	}
}
