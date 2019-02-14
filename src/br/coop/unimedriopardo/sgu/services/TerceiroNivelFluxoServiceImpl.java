package br.coop.unimedriopardo.sgu.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioTerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.TerceiroNivelView;

@Service
@Transactional
public class TerceiroNivelFluxoServiceImpl implements TerceiroNivelFluxoService{
	
private final RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo;
	
	@Autowired
	public TerceiroNivelFluxoServiceImpl(RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo) {
		super();
		this.repositorioTerceiroNivelFluxo = repositorioTerceiroNivelFluxo;
	}

	@Override
	public List<TerceiroNivelView> pesquisarTerceiroNivel(String codigoPrimeiroNivel, String codigoSegundoNivel,String data) {
		List<TerceiroNivelFluxo> listaTerceiroNivelFluxo = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel(codigoPrimeiroNivel, codigoSegundoNivel);
		List<TerceiroNivelView> listaTerceiroNivel = new ArrayList<>();
		for (TerceiroNivelFluxo terceiroNivelFluxo : listaTerceiroNivelFluxo) {
			TerceiroNivelView terceiroNivelView = new TerceiroNivelView();
			terceiroNivelView.setCodigo(terceiroNivelFluxo.getCodigo());
			terceiroNivelView.setCodigoAcesso(terceiroNivelFluxo.getCodigoAcesso());
			terceiroNivelView.setCodigoNivel(terceiroNivelFluxo.getCodigoNivel());
			terceiroNivelView.setCodigoPrimeiroNivel(terceiroNivelFluxo.getCodigoPrimeiroNivel());
			terceiroNivelView.setCodigoSegundoNivel(terceiroNivelFluxo.getCodigoSegundoNivel());
			terceiroNivelView.setDescricao(terceiroNivelFluxo.getDescricao());
			if (Integer.parseInt(codigoPrimeiroNivel) == 1) {
				terceiroNivelView.setValorTotal(new Conversor().formataReal(repositorioTerceiroNivelFluxo.calcularReceita(data, codigoSegundoNivel, terceiroNivelFluxo.getCodigoNivel())));
			}else {
				terceiroNivelView.setValorTotal(new Conversor().formataReal(repositorioTerceiroNivelFluxo.calcularDespesa(data, codigoSegundoNivel, terceiroNivelFluxo.getCodigoNivel())));
			}
			
			listaTerceiroNivel.add(terceiroNivelView);		
		}
		 return listaTerceiroNivel; 
	}

	@Override
	public String calcularSaldoReceita(String data, String codigoSegundoNivel, String codigoTerceiroNivel) {
		return repositorioTerceiroNivelFluxo.calcularReceita(data, codigoSegundoNivel, codigoTerceiroNivel);
	}

	@Override
	public String calcularSaldoDespesa(String data, String codigoSegundoNivel, String codigoTerceiroNivel) {
		return repositorioTerceiroNivelFluxo.calcularDespesa(data, codigoSegundoNivel, codigoTerceiroNivel);
	}

	@Override
	public List<TerceiroNivelFluxo> pesquisarTerceiroNivel() {
		return repositorioTerceiroNivelFluxo.findAll();
	}

	
}
