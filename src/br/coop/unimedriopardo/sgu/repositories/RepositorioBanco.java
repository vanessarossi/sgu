package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.Banco;


public interface RepositorioBanco extends JpaRepository<Banco, String> {

	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_conta(:codigoConta, :data) FROM dual")
	 String calcularSaldo(@Param("codigoConta") String codigoConta, @Param("data") String data);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_ant_conta(:codigoConta, :data) FROM dual")
	 String calcularSaldoAnterior(@Param("codigoConta") String codigoConta, @Param("data") String data);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_total_conta(:data) FROM dual")
	 String calcularTotalSaldo(@Param("data") String data);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_total_conta_c(:data) FROM dual")
	 String calcularTotalSaldoContaCorrente(@Param("data") String data);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_total_aplicacao(:data) FROM dual")
	 String calcularTotalSaldoContaAplicacao(@Param("data") String data);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_total_apl_ans(:data) FROM dual")
	 String calcularTotalSaldoContaAplicacaoAns(@Param("data") String data);
	 
	 public List<Banco> findByAplicacao(String aplicacao);
	 
	 @Query(nativeQuery = true, value = "SELECT FN_UNRP_TRANFERENCIA_RECEBIDA(:dataInicial, :dataFinal, :codigoFilial) FROM dual")
	 String calcularTotalTranferenciaRecebida(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoFilial") String codigoFilial);
	 
	 @Query(nativeQuery = true, value = "SELECT FN_UNRP_TRANFERENCIA_REALIZADA(:dataInicial, :dataFinal, :codigoFilial) FROM dual")
	 String calcularTotalTranferenciaRealizada(@Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, @Param("codigoFilial") String codigoFilial);
	
}
