package br.coop.unimedriopardo.sgu.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioDespesa;
import br.coop.unimedriopardo.sgu.repositories.RepositorioQuintoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioReceita;
import br.coop.unimedriopardo.sgu.repositories.RepositorioSegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioTerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.TerceiroNivelDemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.TerceiroNivelDemonstrativoView;


@Service
@Transactional
public class FluxoServiceImpl implements FluxoService {
	
	private final RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo;
	private final RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo;
	private final RepositorioQuintoNivelFluxo repositorioQuintoNivelFluxo;
	private final RepositorioDespesa repositorioDespesa;
	private final RepositorioReceita repositorioRececita;

	@Autowired
	public FluxoServiceImpl(RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo,RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo, RepositorioDespesa repositorioDespesa, RepositorioQuintoNivelFluxo repositorioQuintoNivelFluxo,
			RepositorioReceita repositorioReceita) {
		super();
		this.repositorioSegundoNivelFluxo = repositorioSegundoNivelFluxo;
		this.repositorioTerceiroNivelFluxo = repositorioTerceiroNivelFluxo;
		this.repositorioDespesa = repositorioDespesa;
		this.repositorioQuintoNivelFluxo = repositorioQuintoNivelFluxo;
		this.repositorioRececita = repositorioReceita;
	}

	@Override
	public List<DemonstrativoView> montarDemonstrativo() {
		List<SegundoNivelFluxo> listaSegundoNivel = repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel("2");
		List<DemonstrativoView> listaDemonstrativoView = new ArrayList<>();
		for (SegundoNivelFluxo segundoNivelFluxo : listaSegundoNivel) {
				DemonstrativoView demonstrativoView = new DemonstrativoView();
				demonstrativoView.setSegundoNivelFluxo(segundoNivelFluxo);
				List<TerceiroNivelDemonstrativoView> despesas = new ArrayList<>();
				List<TerceiroNivelDemonstrativoView> receitas = new ArrayList<>();
				
				List<TerceiroNivelFluxo> receitasTerceiroNivelFluxo = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("1", segundoNivelFluxo.getCodigoNivel());
				List<TerceiroNivelFluxo> despesasTerceiroNivelFluxo = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("2", segundoNivelFluxo.getCodigoNivel());
				//receitas
				for (TerceiroNivelFluxo terceiroNivelFluxo : receitasTerceiroNivelFluxo) {
						TerceiroNivelDemonstrativoView receita = new TerceiroNivelDemonstrativoView();
						receita.setTerceiroNivelFluxo(terceiroNivelFluxo);
						receitas.add(receita);
				}	
				//despesas
				for(TerceiroNivelFluxo terceiroNivelFluxo : despesasTerceiroNivelFluxo) {		
						TerceiroNivelDemonstrativoView despesa = new TerceiroNivelDemonstrativoView();
						despesa.setTerceiroNivelFluxo(terceiroNivelFluxo);
						despesas.add(despesa);
				}
			demonstrativoView.setDespesas(despesas);
			demonstrativoView.setReceitas(receitas);
			
			listaDemonstrativoView.add(demonstrativoView);
		}
		return listaDemonstrativoView;
	}

	@Override
	public List<DemonstrativoValorizadoView> valorizarDemonstrativo(String dataInicial, String dataFinal) {
		List<SegundoNivelFluxo> listaSegundoNivel = repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel("2");
		List<DemonstrativoValorizadoView> listaDemonstrativoValorizada = new ArrayList<>();
		Conversor conversor = new Conversor();
		String dataInicialGCS = conversor.formatarDataString(dataInicial, "YYYYMMdd");
		String dataFinalGCS = conversor.formatarDataString(dataFinal, "YYYYMMdd");
		for (SegundoNivelFluxo segundoNivelFluxo : listaSegundoNivel) {
			DemonstrativoValorizadoView demonstrativoValorizado = new DemonstrativoValorizadoView();
			demonstrativoValorizado.setCodigoId(segundoNivelFluxo.getCodigoNivel());
			demonstrativoValorizado.setValorDespesa(repositorioDespesa.calcularSaldoSegundoNivel(dataInicialGCS, dataFinalGCS, "2", segundoNivelFluxo.getCodigoNivel()));
			demonstrativoValorizado.setValorReceita(repositorioRececita.calcularSaldoSegundoNivel(dataInicialGCS, dataFinalGCS, "1", segundoNivelFluxo.getCodigoNivel()));
			
			List<TerceiroNivelDemonstrativoValorizadoView> receitas = new ArrayList<>();
			List<TerceiroNivelDemonstrativoValorizadoView> despesas = new ArrayList<>();
			
			
			demonstrativoValorizado.setDespesas(despesas);
			demonstrativoValorizado.setReceitas(receitas);
			
			listaDemonstrativoValorizada.add(demonstrativoValorizado);
		}
		
		return listaDemonstrativoValorizada;
	}
	
	
	
}
