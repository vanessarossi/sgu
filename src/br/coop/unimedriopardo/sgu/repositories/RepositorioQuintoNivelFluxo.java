package br.coop.unimedriopardo.sgu.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.QuintoNivelFluxo;

public interface RepositorioQuintoNivelFluxo extends JpaRepository<QuintoNivelFluxo, String>{
	
	
	public List<QuintoNivelFluxo> findByCodigoPrimeiroNivelAndCodigoSegundoNivelAndCodigoTerceiroNivelAndCodigoQuartoNivel(String codigoPrimeiroNivel, 
			String codigoSegundoNivel, String codigoTerceiroNivel, String codigoQuartoNivel);
	
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_NIVEL_05(:data, :codigoPrimeiroNivel, :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel ,:codigoNivel) FROM dual")
	public String calcularTotal(@Param("data")String data, 
								@Param("codigoPrimeiroNivel")String codigoPrimeiroNivel, @Param("codigoSegundoNivel")String codigoSegundoNivel,
								@Param("codigoTerceiroNivel")String codigoTerceiroNivel,@Param("codigoQuartoNivel")String codigoQuartoNivel,
								@Param("codigoNivel")String codigoNivel);
}
