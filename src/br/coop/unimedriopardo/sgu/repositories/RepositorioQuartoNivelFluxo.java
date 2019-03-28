package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.QuartoNivelFluxo;


public interface RepositorioQuartoNivelFluxo extends JpaRepository<QuartoNivelFluxo, String>{
	
	public List<QuartoNivelFluxo> findByCodigoPrimeiroNivelAndCodigoSegundoNivelAndCodigoTerceiroNivel(String codigoPrimeiroNivel, String codigoSegundoNivel, String codigoTerceiroNivel);
	
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_NIVEL_04(:data, 1, :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel) FROM dual")
	public String calcularReceita(@Param("data")String data, @Param("codigoSegundoNivel")String codigoSegundoNivel, @Param("codigoTerceiroNivel")String codigoTerceiroNivel, @Param("codigoQuartoNivel")String codigoQuartoNivel);
	
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_NIVEL_04(:data, 2, :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel) FROM dual")
	public String calcularDespesa(@Param("data")String data, @Param("codigoSegundoNivel")String codigoSegundoNivel, @Param("codigoTerceiroNivel")String codigoTerceiroNivel, @Param("codigoQuartoNivel")String codigoQuartoNivel);

}
