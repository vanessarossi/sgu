package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.Banco;


public interface RepositorioBanco extends JpaRepository<Banco, String> {

	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_conta(:codigoConta, :data) FROM dual")
	 String calcularSaldo(@Param("codigoConta") String codigoConta, @Param("data") String data);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_total_conta(:data) FROM dual")
	 String calcularTotalSaldo(@Param("data") String data);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_anterior_conta(:codigoConta, :dataInicial) FROM dual")
	 String calcularSaldoDiaAnterior(@Param("codigoConta") String codigoConta, @Param("dataInicial") String dataInicial);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_trans_entrou(:codigoConta, :dataInicial, :dataFinal) FROM dual")
	 String calcularSaldoTransferenciaEntrou(@Param("codigoConta") String codigoConta, @Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal);
	 
	 @Query(nativeQuery = true, value = "SELECT fn_unrp_saldo_trans_saiu(:codigoConta, :dataInicial, :dataFinal) FROM dual")
	 String calcularSaldoTransferenciaSaiu(@Param("codigoConta") String codigoConta, @Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal);
}
