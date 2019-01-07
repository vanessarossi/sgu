package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;

public interface RepositorioSegundoNivelFluxo extends JpaRepository<SegundoNivelFluxo, String>{
	
	public List<SegundoNivelFluxo> findByCodigoPrimeiroNivel(String codigoPrimeiroNivel);

}
