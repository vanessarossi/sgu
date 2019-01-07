package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.coop.unimedriopardo.sgu.models.QuartoNivelFluxo;


public interface RepositorioQuartoNivelFluxo extends JpaRepository<QuartoNivelFluxo, String>{
	
	public List<QuartoNivelFluxo> findByCodigoPrimeiroNivelAndCodigoSegundoNivelAndCodigoTerceiroNivel(String codigoPrimeiroNivel, String codigoSegundoNivel, String codigoTerceiroNivel);

}
