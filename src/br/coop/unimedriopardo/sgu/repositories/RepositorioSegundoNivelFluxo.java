package br.coop.unimedriopardo.sgu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;

public interface RepositorioSegundoNivelFluxo extends JpaRepository<SegundoNivelFluxo, String>{
	
	public List<SegundoNivelFluxo> findByCodigoPrimeiroNivel(String codigoPrimeiroNivel);
	
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_NIVEL_02(:data,1, :codigoSegundoNivel) FROM dual")
	public String calcularReceita(@Param("data")String data, @Param("codigoSegundoNivel")String codigoSegundoNivel);
	
	@Query(nativeQuery = true, value = "SELECT FN_UNRP_SALDO_NIVEL_02(:data,2, :codigoSegundoNivel) FROM dual")
	public String calcularDespesa(@Param("data")String data, @Param("codigoSegundoNivel")String codigoSegundoNivel);

}

