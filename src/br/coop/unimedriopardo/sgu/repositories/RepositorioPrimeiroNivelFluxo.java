package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.coop.unimedriopardo.sgu.models.PrimeiroNivelFluxo;

public interface RepositorioPrimeiroNivelFluxo extends JpaRepository<PrimeiroNivelFluxo, String>{
	
	public PrimeiroNivelFluxo findByCodigoNivel(String codigoNivel);

}
