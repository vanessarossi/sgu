package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.PostoAtendimento;

public interface RepositorioPostoAtendimento extends JpaRepository<PostoAtendimento, String> {
	
	  @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_caixa(:codigoPosto, :data) FROM dual")
	   String calcularSaldoCaixa(@Param("codigoPosto") String codigoPosto, @Param("data") String data);
	  
	  @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_total_caixa(:data) FROM dual")
	   String calcularTotalSaldoCaixa(@Param("data") String data);
	  
	  @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_ant_caixa(:codigoPosto, :data) FROM dual")
	   String calcularTotalSaldoAnteriorCaixa(@Param("codigoPosto") String codigoPosto, @Param("data") String data);

}
