package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.ContaFluxo;

public interface RepositorioContaFluxo extends JpaRepository<ContaFluxo, String> {
	
	@Query(nativeQuery = true, value = "SELECT fn_unrp_receita_class_02_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel) FROM dual")
	 String calcularTotalReceitaSegundoNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel );
	
	@Query(nativeQuery = true, value = "SELECT fn_unrp_despesa_class_02_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel) FROM dual")
	 String calcularTotalDespesaSegundoNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel );
	
	
	@Query(nativeQuery = true, value = "SELECT fn_unrp_receita_class_03_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel, :codigoNivel) FROM dual")
	 String calcularTotalReceitaTerceiroNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel, @Param("codigoNivel") String codigoNivel );
	
	
	@Query(nativeQuery = true, value = "SELECT fn_unrp_despesa_class_03_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel, :codigoNivel) FROM dual")
	 String calcularTotalDespesaTerceiroNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel, @Param("codigoNivel") String codigoNivel );

	/** ANTERIOR **/
		
	@Query(nativeQuery = true, value = "SELECT fn_unrp_rec_ant_cla_02_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel) FROM dual")
	 String calcularTotalReceitaAnteriorSegundoNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel );
	
	@Query(nativeQuery = true, value = "SELECT fn_unrp_desp_ant_cla_02_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel) FROM dual")
	 String calcularTotalDespesaAnteriorSegundoNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel );
	
	
	@Query(nativeQuery = true, value = "SELECT fn_unrp_rec_ant_cla_03_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel, :codigoNivel) FROM dual")
	 String calcularTotalReceitaAnteriorTerceiroNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel, @Param("codigoNivel") String codigoNivel );
	
	
	@Query(nativeQuery = true, value = "SELECT fn_unrp_desp_ant_cla_03_fluxo(:dataInicial, :dataFinal, :codigoSegundoNivel, :codigoNivel) FROM dual")
	 String calcularTotalDespesaAnteriorTerceiroNivel(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoSegundoNivel") String codigoSegundoNivel, @Param("codigoNivel") String codigoNivel );

	
}
