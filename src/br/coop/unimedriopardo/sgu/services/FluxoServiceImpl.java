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
			String valorReceitaAnterior = repositorioRececita.calcularSaldoAnteriorSegundoNivel(dataInicialGCS, dataFinalGCS, "1", segundoNivelFluxo.getCodigoNivel());
			String valorDespesaAnterior = repositorioDespesa.calcularSaldoAnteriorSegundoNivel(dataInicialGCS, dataFinalGCS, "2", segundoNivelFluxo.getCodigoNivel());
			String valorDespesa = repositorioDespesa.calcularSaldoSegundoNivel(dataInicialGCS, dataFinalGCS, "2", segundoNivelFluxo.getCodigoNivel());
			String valorReceita = repositorioRececita.calcularSaldoSegundoNivel(dataInicialGCS, dataFinalGCS, "1", segundoNivelFluxo.getCodigoNivel());
			String valorReceitaPrevisao = repositorioRececita.calcularSaldoPrevisaoSegundoNivel(dataInicialGCS, dataFinalGCS, "1", segundoNivelFluxo.getCodigoNivel());
			String valorDespesaPrevisao = repositorioDespesa.calcularSaldoPrevisaoSegundoNivel(dataInicialGCS, dataFinalGCS, "2", segundoNivelFluxo.getCodigoNivel());
			
			String valorLiquidoAnterior =  String.valueOf((Float.parseFloat(valorReceitaAnterior.replace(",", ".")) - Float.parseFloat(valorDespesaAnterior.replace(",", ".")))) ;
			String valorLiquido = String.valueOf((Float.parseFloat(valorReceita.replace(",", ".")) - Float.parseFloat(valorDespesa.replace(",", "."))));
			String valorLiquidoPrevisao = String.valueOf((Float.parseFloat(valorReceitaPrevisao.replace(",", ".")) - Float.parseFloat(valorDespesaPrevisao.replace(",", "."))));
			
			
			demonstrativoValorizado.setValorReceitaAnterior(valorReceitaAnterior);
			demonstrativoValorizado.setValorDespesaAnterior(valorDespesaAnterior);
			demonstrativoValorizado.setValorLiquidoAnterior(valorLiquidoAnterior);
			
			demonstrativoValorizado.setValorReceita(valorReceita);
			demonstrativoValorizado.setValorDespesa(valorDespesa);
			demonstrativoValorizado.setValorLiquido(valorLiquido);
			
			demonstrativoValorizado.setValorReceitaPrevisao(valorReceitaPrevisao);
			demonstrativoValorizado.setValorDespesaPrevisao(valorDespesaPrevisao);
			demonstrativoValorizado.setValorLiquidoPrevisao(valorLiquidoPrevisao);
			
			
			List<TerceiroNivelDemonstrativoValorizadoView> receitas = new ArrayList<>();
			List<TerceiroNivelDemonstrativoValorizadoView> despesas = new ArrayList<>();
						
		
			List<TerceiroNivelFluxo> receitasTerceiroNivelFluxo = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("1", segundoNivelFluxo.getCodigoNivel());
			List<TerceiroNivelFluxo> despesasTerceiroNivelFluxo = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("2", segundoNivelFluxo.getCodigoNivel());
			//receitas
			for (TerceiroNivelFluxo terceiroNivelFluxo : receitasTerceiroNivelFluxo) {
					TerceiroNivelDemonstrativoValorizadoView receita = new TerceiroNivelDemonstrativoValorizadoView();
					receita.setCodigoId(terceiroNivelFluxo.getCodigoSegundoNivel().concat(terceiroNivelFluxo.getCodigoNivel()));
					receita.setValorAnterior((repositorioRececita.calcularSaldoAnteriorTerceiroNivel(dataInicialGCS, dataFinalGCS, "1", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel())));
					receita.setValor(repositorioRececita.calcularSaldoTerceiroNivel(dataInicialGCS, dataFinalGCS, "1", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel()));
					receita.setValorPrevisao(repositorioRececita.calcularSaldoPrevisaoTerceiroNivel(dataInicialGCS, dataFinalGCS, "1", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel()));
					receitas.add(receita);
			}	
			//despesas
			for(TerceiroNivelFluxo terceiroNivelFluxo : despesasTerceiroNivelFluxo) {		
				TerceiroNivelDemonstrativoValorizadoView despesa = new TerceiroNivelDemonstrativoValorizadoView();
				despesa.setCodigoId(terceiroNivelFluxo.getCodigoSegundoNivel().concat(terceiroNivelFluxo.getCodigoNivel()));
				despesa.setValorAnterior(repositorioDespesa.calcularSaldoAnteriorTerceiroNivel(dataInicialGCS, dataFinalGCS, "2", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel()));
				despesa.setValor(repositorioDespesa.calcularSaldoTerceiroNivel(dataInicialGCS, dataFinalGCS, "2", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel()));
				despesa.setValorPrevisao(repositorioDespesa.calcularSaldoPrevisaoTerceiroNivel(dataInicialGCS, dataFinalGCS, "2", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel()));
				despesas.add(despesa);
			}
			
			demonstrativoValorizado.setReceitas(receitas);
			demonstrativoValorizado.setDespesas(despesas);
			
			listaDemonstrativoValorizada.add(demonstrativoValorizado);
		}
		
		return listaDemonstrativoValorizada;
	}
	
	
	
}
