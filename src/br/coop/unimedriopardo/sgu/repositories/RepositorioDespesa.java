package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.Despesa;

public interface RepositorioDespesa extends JpaRepository<Despesa, String>{
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_FLUXO_NIVEL_02(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel ) from dual")
	String calcularSaldoSegundoNivel(@Param("dataInicial") String dataInicial, 
			 						  @Param("dataFinal") String dataFinal, 
			 						  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
			 						 @Param("codigoSegundoNivel") String codigoSegundoNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_FLUXO_NIVEL_03(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel ) from dual")
	String calcularSaldoTerceiroNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_FLUXO_NIVEL_03(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel ) from dual")
	 String calcularSaldoQuartoNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel,
									  @Param("codigoQuartoNivel") String codigoQuartoNivel);
}
