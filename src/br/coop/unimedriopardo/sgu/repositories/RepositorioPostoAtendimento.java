package br.coop.unimedriopardo.sgu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.PostoAtendimento;

public interface RepositorioPostoAtendimento extends JpaRepository<PostoAtendimento, String> {
	
	@Query(value = "fn_unrp_saldo_caixa(?1,?2)")
	  public String calcularSaldoCaixa(String codigoPostoAtendimento, String data);
	
}
