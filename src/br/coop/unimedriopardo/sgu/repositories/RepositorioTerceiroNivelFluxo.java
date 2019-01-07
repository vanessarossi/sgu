package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;

public interface RepositorioTerceiroNivelFluxo extends JpaRepository<TerceiroNivelFluxo, String>{
	
	public List<TerceiroNivelFluxo> findByCodigoPrimeiroNivelAndCodigoSegundoNivel(String codigoPrimeiroNivel,String codigoSegundoNivel);

}
