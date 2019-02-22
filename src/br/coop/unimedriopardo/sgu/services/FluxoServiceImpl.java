package br.coop.unimedriopardo.sgu.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.Banco;
import br.coop.unimedriopardo.sgu.models.Filial;
import br.coop.unimedriopardo.sgu.models.PostoAtendimento;
import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioBanco;
import br.coop.unimedriopardo.sgu.repositories.RepositorioDespesa;
import br.coop.unimedriopardo.sgu.repositories.RepositorioFilial;
import br.coop.unimedriopardo.sgu.repositories.RepositorioPostoAtendimento;
import br.coop.unimedriopardo.sgu.repositories.RepositorioReceita;
import br.coop.unimedriopardo.sgu.repositories.RepositorioSegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioTerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.DemonstrativoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.MovimentoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.TerceiroNivelDemonstrativoValorizadoView;
import br.coop.unimedriopardo.sgu.util.view.fluxo.TerceiroNivelDemonstrativoView;


@Service
@Transactional
public class FluxoServiceImpl implements FluxoService {
	
	private final RepositorioBanco repositorioBanco;
	private final RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo;
	private final RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo;
	private final RepositorioDespesa repositorioDespesa;
	private final RepositorioReceita repositorioRececita;
	private final RepositorioFilial repositorioFilial;
	private final RepositorioPostoAtendimento repositorioPostoAtendimento;

	@Autowired
	public FluxoServiceImpl(RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo,
			RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo, 
			RepositorioDespesa repositorioDespesa, RepositorioReceita repositorioReceita, 
			RepositorioFilial repositorioFilial, RepositorioBanco repositorioBanco,
			RepositorioPostoAtendimento repositorioPostoAtendimento) {
		super();
		this.repositorioSegundoNivelFluxo = repositorioSegundoNivelFluxo;
		this.repositorioTerceiroNivelFluxo = repositorioTerceiroNivelFluxo;
		this.repositorioDespesa = repositorioDespesa;
		this.repositorioRececita = repositorioReceita;
		this.repositorioFilial = repositorioFilial;
		this.repositorioBanco = repositorioBanco;
		this.repositorioPostoAtendimento = repositorioPostoAtendimento;
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
			
			
			demonstrativoValorizado.setValorReceitaAnterior(conversor.formataRealSemCifrao(valorReceitaAnterior));
			demonstrativoValorizado.setValorDespesaAnterior(conversor.formataRealSemCifrao(valorDespesaAnterior));
			demonstrativoValorizado.setValorLiquidoAnterior(conversor.formataRealSemCifrao(valorLiquidoAnterior));
			
			demonstrativoValorizado.setValorReceita(conversor.formataRealSemCifrao(valorReceita));
			demonstrativoValorizado.setValorDespesa(conversor.formataRealSemCifrao(valorDespesa));
			demonstrativoValorizado.setValorLiquido(conversor.formataRealSemCifrao(valorLiquido));
			
			demonstrativoValorizado.setValorReceitaPrevisao(conversor.formataRealSemCifrao(valorReceitaPrevisao));
			demonstrativoValorizado.setValorDespesaPrevisao(conversor.formataRealSemCifrao(valorDespesaPrevisao));
			demonstrativoValorizado.setValorLiquidoPrevisao(conversor.formataRealSemCifrao(valorLiquidoPrevisao));
			
			
			List<TerceiroNivelDemonstrativoValorizadoView> receitas = new ArrayList<>();
			List<TerceiroNivelDemonstrativoValorizadoView> despesas = new ArrayList<>();
						
		
			List<TerceiroNivelFluxo> receitasTerceiroNivelFluxo = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("1", segundoNivelFluxo.getCodigoNivel());
			List<TerceiroNivelFluxo> despesasTerceiroNivelFluxo = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("2", segundoNivelFluxo.getCodigoNivel());
			//receitas
			for (TerceiroNivelFluxo terceiroNivelFluxo : receitasTerceiroNivelFluxo) {
					TerceiroNivelDemonstrativoValorizadoView receita = new TerceiroNivelDemonstrativoValorizadoView();
					receita.setCodigoId(terceiroNivelFluxo.getCodigoSegundoNivel().concat(terceiroNivelFluxo.getCodigoNivel()));
					receita.setValorAnterior(conversor.formataRealSemCifrao(repositorioRececita.calcularSaldoAnteriorTerceiroNivel(dataInicialGCS, dataFinalGCS, "1", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel())));
					receita.setValor(conversor.formataRealSemCifrao(repositorioRececita.calcularSaldoTerceiroNivel(dataInicialGCS, dataFinalGCS, "1", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel())));
					receita.setValorPrevisao(conversor.formataRealSemCifrao(repositorioRececita.calcularSaldoPrevisaoTerceiroNivel(dataInicialGCS, dataFinalGCS, "1", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel())));
					receitas.add(receita);
			}	
			//despesas
			for(TerceiroNivelFluxo terceiroNivelFluxo : despesasTerceiroNivelFluxo) {		
				TerceiroNivelDemonstrativoValorizadoView despesa = new TerceiroNivelDemonstrativoValorizadoView();
				despesa.setCodigoId(terceiroNivelFluxo.getCodigoSegundoNivel().concat(terceiroNivelFluxo.getCodigoNivel()));
				despesa.setValorAnterior(conversor.formataRealSemCifrao(repositorioDespesa.calcularSaldoAnteriorTerceiroNivel(dataInicialGCS, dataFinalGCS, "2", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel())));
				despesa.setValor(conversor.formataRealSemCifrao(repositorioDespesa.calcularSaldoTerceiroNivel(dataInicialGCS, dataFinalGCS, "2", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel())));
				despesa.setValorPrevisao(conversor.formataRealSemCifrao(repositorioDespesa.calcularSaldoPrevisaoTerceiroNivel(dataInicialGCS, dataFinalGCS, "2", terceiroNivelFluxo.getCodigoSegundoNivel(), terceiroNivelFluxo.getCodigoNivel())));
				despesas.add(despesa);
			}
			
			demonstrativoValorizado.setReceitas(receitas);
			demonstrativoValorizado.setDespesas(despesas);
			
			listaDemonstrativoValorizada.add(demonstrativoValorizado);
		}
		
		return listaDemonstrativoValorizada;
	}

	@Override
	public List<Filial> montarFilial() {
		return repositorioFilial.findAll();
	}

	@Override
	public List<MovimentoValorizadoView> valorizarMovimento(String dataInicial, String dataFinal) {
		List<Banco> bancos = repositorioBanco.findByAplicacao("N");
		List<PostoAtendimento> postosAtendimento = repositorioPostoAtendimento.findAll();
		List<Filial> filiais = repositorioFilial.findAll();
		List<MovimentoValorizadoView> movimentosValorizado = new ArrayList<>();
		
		Conversor conversor = new Conversor();
		String dataInicialGCS = conversor.formatarDataString(dataInicial, "YYYYMMdd");
		String dataFinalGCS = conversor.formatarDataString(dataFinal, "YYYYMMdd");
		
		/** SALDO ANTERIOR BANCOS **/
		Float saldoAnteriorBancoConstrucao = 0f;
		Float saldoAnteriorBancoFarmacia = 0f;
		Float saldoAnteriorBancoOptica = 0f;
		Float saldoAnteriorBancoSede = 0f;
				
		/** SALDO BANCOS **/
		Float saldoBancoConstrucao = 0f;
		Float saldoBancoFarmacia = 0f;
		Float saldoBancoOptica = 0f;
		Float saldoBancoSede = 0f;
		
		for (Banco banco : bancos) {
			String saldoAnterior = repositorioBanco.calcularSaldoAnterior(banco.getCodigoConta(), dataInicialGCS);
			String saldo = repositorioBanco.calcularSaldo(banco.getCodigoConta(), dataFinalGCS);
			
			if (saldoAnterior == "" || saldoAnterior == null) {saldoAnterior = "0"	;}
			if (saldo == "" || saldo == null) {saldo = "0"	;}
			
			if (banco.getCodigoFilial().equals("070")) { //construcao
				saldoAnteriorBancoConstrucao = saldoAnteriorBancoConstrucao + Float.parseFloat(saldoAnterior.replace(",", "."));
				saldoBancoConstrucao = saldoBancoConstrucao + Float.parseFloat(saldo.replace(",", "."));
				
			}if (banco.getCodigoFilial().equals("002")) { //farmacia
				saldoAnteriorBancoFarmacia = saldoAnteriorBancoFarmacia + Float.parseFloat(saldoAnterior.replace(",", "."));
				saldoBancoFarmacia = saldoBancoFarmacia + Float.parseFloat(saldo.replace(",", "."));
				
			}if(banco.getCodigoFilial().equals("003")) {//optica
				saldoAnteriorBancoOptica = saldoAnteriorBancoOptica + Float.parseFloat(saldoAnterior.replace(",", "."));
				saldoBancoOptica = saldoBancoOptica + Float.parseFloat(saldo.replace(",", "."));
				
			}if( ! banco.getCodigoFilial().equals("070") && ! banco.getCodigoFilial().equals("002") && ! banco.getCodigoFilial().equals("003")) { //o que sobrou vai pra sede
				saldoAnteriorBancoSede = saldoAnteriorBancoSede + Float.parseFloat(saldoAnterior.replace(",", "."));
				saldoBancoSede = saldoBancoSede + Float.parseFloat(saldo.replace(",", "."));
			}
		}
		
		/** SALDO CAIXAS ANTERIOR**/
		Float saldoAnteriorCaixaConstrucao = 0f;
		Float saldoAnteriorCaixaFarmacia = 0f;
		Float saldoAnteriorCaixaOptica = 0f;
		Float saldoAnteriorCaixaSede = 0f;
		
		/** SALDO CAIXAS **/
		Float saldoCaixaConstrucao = 0f;
		Float saldoCaixaFarmacia = 0f;
		Float saldoCaixaOptica = 0f;
		Float saldoCaixaSede = 0f;
		
		for (PostoAtendimento postoAtendimento : postosAtendimento) {
			
			String saldoAnterior = repositorioPostoAtendimento.calcularSaldoCaixa(postoAtendimento.getCodigoPosto(), dataInicialGCS);
			String saldo = repositorioPostoAtendimento.calcularSaldoCaixa(postoAtendimento.getCodigoPosto(), dataInicialGCS);
			
			if (saldoAnterior == "" || saldoAnterior == null) {saldoAnterior = "0"	;}
			if (saldo == "" || saldo == null) {saldo = "0"	;}
			
			
			if (postoAtendimento.getCodigoFilial().equals("070")) { //construcao
				saldoAnteriorCaixaConstrucao = saldoAnteriorCaixaConstrucao + Float.parseFloat(saldoAnterior.replaceAll(",", "."));
				saldoCaixaConstrucao = saldoCaixaConstrucao + Float.parseFloat(saldo.replaceAll(",", "."));
			}if (postoAtendimento.getCodigoFilial().equals("002")) { //farmacia
				saldoAnteriorCaixaFarmacia = saldoAnteriorCaixaFarmacia + Float.parseFloat(saldoAnterior.replaceAll(",", "."));
				saldoCaixaFarmacia = saldoCaixaFarmacia + Float.parseFloat(saldo.replaceAll(",", "."));
			}if(postoAtendimento.getCodigoFilial().equals("003")) {//optica
				saldoAnteriorCaixaOptica = saldoAnteriorCaixaOptica + Float.parseFloat(saldoAnterior.replaceAll(",", "."));
				saldoCaixaOptica = saldoAnteriorCaixaOptica + Float.parseFloat(saldo.replaceAll(",", "."));
			}if( ! postoAtendimento.getCodigoFilial().equals("070") && ! postoAtendimento.getCodigoFilial().equals("002") && ! postoAtendimento.getCodigoFilial().equals("003")) { //o que sobrou vai pra sede
				saldoAnteriorCaixaSede = saldoAnteriorCaixaSede + Float.parseFloat(saldoAnterior.replaceAll(",", "."));
				saldoCaixaSede = saldoAnteriorCaixaSede+ Float.parseFloat(saldo.replaceAll(",", "."));
			}
		}
		
		
		for (Filial filial : filiais) {
			MovimentoValorizadoView movimento = new MovimentoValorizadoView();
			movimento.setCodigoId(filial.getCodigoFilial());
			switch (filial.getCodigoFilial()) {
			case "001":
				movimento.setSaldoLiquidoAnterior(conversor.formataReal(String.valueOf(saldoAnteriorBancoSede + saldoAnteriorCaixaSede)));
				movimento.setSaldoBanco(conversor.formataReal(saldoBancoSede.toString()));
				movimento.setSaldoCaixa(conversor.formataReal(saldoCaixaSede.toString()));
				movimento.setSaldoLiquido(conversor.formataReal(String.valueOf(saldoBancoSede + saldoCaixaSede)));
				break;
			case "002":
				movimento.setSaldoLiquidoAnterior(conversor.formataReal(String.valueOf(saldoAnteriorBancoFarmacia + saldoAnteriorCaixaFarmacia)));
				movimento.setSaldoBanco(conversor.formataReal(saldoBancoFarmacia.toString()));
				movimento.setSaldoCaixa(conversor.formataReal(saldoCaixaFarmacia.toString()));
				movimento.setSaldoLiquido(conversor.formataReal(String.valueOf(saldoBancoFarmacia + saldoCaixaFarmacia)));
				break;
			case "003":
				movimento.setSaldoLiquidoAnterior(conversor.formataReal(String.valueOf(saldoAnteriorBancoOptica + saldoAnteriorCaixaOptica)));
				movimento.setSaldoBanco(conversor.formataReal(saldoBancoOptica.toString()));
				movimento.setSaldoCaixa(conversor.formataReal(saldoCaixaOptica.toString()));
				movimento.setSaldoLiquido(conversor.formataReal(String.valueOf(saldoBancoOptica + saldoCaixaOptica)));
				break;
			case "070":
				movimento.setSaldoLiquidoAnterior(conversor.formataReal(String.valueOf(saldoAnteriorBancoConstrucao + saldoAnteriorCaixaConstrucao)));
				movimento.setSaldoBanco(conversor.formataReal(saldoBancoConstrucao.toString()));
				movimento.setSaldoCaixa(conversor.formataReal(saldoCaixaConstrucao.toString()));
				movimento.setSaldoLiquido(conversor.formataReal(String.valueOf(saldoBancoConstrucao + saldoCaixaConstrucao)));
				break;
			default:
				break;
			}
		
			movimentosValorizado.add(movimento);
		}
		return movimentosValorizado;
	}
}
