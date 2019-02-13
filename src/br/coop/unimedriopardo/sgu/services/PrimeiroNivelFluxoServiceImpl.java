package br.coop.unimedriopardo.sgu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.PrimeiroNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioPrimeiroNivelFluxo;

@Service
@Transactional
public class PrimeiroNivelFluxoServiceImpl implements PrimeiroNivelFluxoService{

	
	private final RepositorioPrimeiroNivelFluxo repositorioPrimeiroNivelFluxo;
	
	@Autowired
	public PrimeiroNivelFluxoServiceImpl(RepositorioPrimeiroNivelFluxo repositorioPrimeiroNivelFluxo) {
		super();
		this.repositorioPrimeiroNivelFluxo = repositorioPrimeiroNivelFluxo;
	}
	
	
	@Override
	public PrimeiroNivelFluxo pesquisarPrimeiroNivel(String codigoNivel) {
		return repositorioPrimeiroNivelFluxo.findByCodigoNivel(codigoNivel);
	}


	@Override
	public String calcularSaldoReceita(String data) {
		return repositorioPrimeiroNivelFluxo.calcularReceita(data);
	}


	@Override
	public String calcularSaldoDespesa(String data) {
		return repositorioPrimeiroNivelFluxo.calcularDespesa(data);
	}

}
