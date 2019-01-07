package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.coop.unimedriopardo.sgu.models.QuintoNivelFluxo;

public interface RepositorioQuintoNivelFluxo extends JpaRepository<QuintoNivelFluxo, String>{
	
	public List<QuintoNivelFluxo> findByCodigoPrimeiroNivelAndCodigoSegundoNivelAndCodigoTerceiroNivelAndCodigoQuartoNivel(String codigoPrimeiroNivel, String codigoSegundoNivel, String codigoTerceiroNivel, String codigoQuartoNivel);

}
