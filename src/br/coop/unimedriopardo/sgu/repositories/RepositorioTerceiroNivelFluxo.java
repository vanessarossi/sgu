package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;

public interface RepositorioTerceiroNivelFluxo extends JpaRepository<TerceiroNivelFluxo, String>{
	
	public List<TerceiroNivelFluxo> findByCodigoPrimeiroNivelAndCodigoSegundoNivel(String codigoPrimeiroNivel,String codigoSegundoNivel);
	public List<TerceiroNivelFluxo> findByCodigoSegundoNivel(String codigoSegundoNivel);
	
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_NIVEL_03(:data, 1, :codigoSegundoNivel, :codigoTerceiroNivel) FROM dual")
	public String calcularReceita(@Param("data")String data, @Param("codigoSegundoNivel")String codigoSegundoNivel, @Param("codigoTerceiroNivel")String codigoTerceiroNivel);
	
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_NIVEL_03(:data, 2, :codigoSegundoNivel, :codigoTerceiroNivel) FROM dual")
	public String calcularDespesa(@Param("data")String data, @Param("codigoSegundoNivel")String codigoSegundoNivel, @Param("codigoTerceiroNivel")String codigoTerceiroNivel);


}
