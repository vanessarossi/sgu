package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.Receita;

public interface RepositorioReceita extends JpaRepository<Receita, String> {
	/** VALOR ATUAL **/
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
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_FLUXO_NIVEL_04(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel ) from dual")
	 String calcularSaldoQuartoNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel,
									  @Param("codigoQuartoNivel") String codigoQuartoNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_FLUXO_NIVEL_05(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel , :codigoNivel ) from dual")
	 String calcularSaldoQuintoNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel,
									  @Param("codigoQuartoNivel") String codigoQuartoNivel,
									  @Param("codigoNivel") String codigoNivel);
	
	/** VALOR ANTERIOR **/
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_ANT_FLUXO_NVL_02(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel ) from dual")
	String calcularSaldoAnteriorSegundoNivel(@Param("dataInicial") String dataInicial, 
			 						  @Param("dataFinal") String dataFinal, 
			 						  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
			 						 @Param("codigoSegundoNivel") String codigoSegundoNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_ANT_FLUXO_NVL_03(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel ) from dual")
	String calcularSaldoAnteriorTerceiroNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_ANT_FLUXO_NVL_04(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel ) from dual")
	 String calcularSaldoAnteriorQuartoNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel,
									  @Param("codigoQuartoNivel") String codigoQuartoNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_ANT_FLUXO_NVL_05(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel, :codigoNivel ) from dual")
	 String calcularSaldoAnteriorQuintoNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel,
									  @Param("codigoQuartoNivel") String codigoQuartoNivel,
									  @Param("codigoNivel") String codigoNivel);
	

	/** VALOR PREVISAO **/
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_PRV_FLUXO_NVL_02(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel ) from dual")
	String calcularSaldoPrevisaoSegundoNivel(@Param("dataInicial") String dataInicial, 
			 						  @Param("dataFinal") String dataFinal, 
			 						  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
			 						 @Param("codigoSegundoNivel") String codigoSegundoNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_PRV_FLUXO_NVL_03(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel ) from dual")
	String calcularSaldoPrevisaoTerceiroNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel);
	
	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_PRV_FLUXO_NVL_04(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel ) from dual")
	 String calcularSaldoPrevisaoQuartoNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel,
									  @Param("codigoQuartoNivel") String codigoQuartoNivel);

	@Query(nativeQuery = true, value = "SELECT  FN_UNRP_SALDO_PRV_FLUXO_NVL_05(:dataInicial, :dataFinal, :codigoPrimeiroNivel , :codigoSegundoNivel, :codigoTerceiroNivel, :codigoQuartoNivel, :codigoNivel ) from dual")
	 String calcularSaldoPrevisaoQuintoNivel(@Param("dataInicial") String dataInicial, 
									  @Param("dataFinal") String dataFinal, 
									  @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
									  @Param("codigoSegundoNivel") String codigoSegundoNivel,
									  @Param("codigoTerceiroNivel") String codigoTerceiroNivel,
									  @Param("codigoQuartoNivel") String codigoQuartoNivel,
									  @Param("codigoNivel") String codigoNivel);
	
	/** MOVIMENTACAO **/
	
	/** MOVIMENTACAO ANTERIOR**/
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_MOV_ANT(:dataFinal,:filial) from dual")
	String calcularSaldoMovAnt(@Param("dataFinal") String dataFinal,
			 				   @Param("filial") String filial);
	
	/** MOVIMENTACAO ATUAL **/
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_MOV(:dataInicial,:dataFinal,:codigoPrimeiroNivel,:filial) from dual")
	String calcularSaldoMov (@Param("dataInicial") String dataInicial, 
			 				 @Param("dataFinal") String dataFinal, 
			 				 @Param("codigoPrimeiroNivel") String codigoPrimeiroNivel,
			 				 @Param("filial") String filial);
}	
