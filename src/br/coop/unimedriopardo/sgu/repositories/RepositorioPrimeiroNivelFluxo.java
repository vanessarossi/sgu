package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.PrimeiroNivelFluxo;

public interface RepositorioPrimeiroNivelFluxo extends JpaRepository<PrimeiroNivelFluxo, String>{
	
	public PrimeiroNivelFluxo findByCodigoNivel(String codigoNivel);
	
	@Query(nativeQuery = true, value = "SELECT NVL(FN_UNRP_SALDO_NIVEL_01(:data, 1),0) FROM dual")
	 String calcularReceita(@Param("data") String data);
	
	@Query(nativeQuery = true, value = "SELECT NVL(FN_UNRP_SALDO_NIVEL_01(:data, 2),0) FROM dual")
	 String calcularDespesa(@Param("data") String data);

}
