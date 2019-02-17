package br.coop.unimedriopardo.sgu.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.models.Banco;
import br.coop.unimedriopardo.sgu.models.ContaFluxo;
import br.coop.unimedriopardo.sgu.models.PostoAtendimento;
import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioBanco;
import br.coop.unimedriopardo.sgu.repositories.RepositorioContaFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioPostoAtendimento;
import br.coop.unimedriopardo.sgu.repositories.RepositorioSegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioTerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.util.ContaPrincipal;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.Demonstrativo;
import br.coop.unimedriopardo.sgu.util.DemonstrativoClassificacao;
import br.coop.unimedriopardo.sgu.util.DemonstrativoView;

@Service
@Transactional
public class FluxoServiceImpl implements FluxoService {
	
	private final RepositorioContaFluxo repositorioContaFluxo;
	private final RepositorioBanco repositorioBanco;
	private final RepositorioPostoAtendimento repositorioPostoAtendimento;	
	private final RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo;
	private final RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo;
	
	@Autowired
	public FluxoServiceImpl(RepositorioContaFluxo repositorioContaFluxo,RepositorioBanco repositorioBanco,RepositorioPostoAtendimento repositorioPostoAtendimento,
			RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo, RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo) {
		super();
		this.repositorioContaFluxo = repositorioContaFluxo;
		this.repositorioBanco = repositorioBanco;
		this.repositorioPostoAtendimento = repositorioPostoAtendimento;
		this.repositorioSegundoNivelFluxo = repositorioSegundoNivelFluxo;
		this.repositorioTerceiroNivelFluxo = repositorioTerceiroNivelFluxo;
	}
	
	
	@Override
	public List<ContaFluxo> listarContas() {
		return repositorioContaFluxo.findAll();
	}


	public List<ContaPrincipal> carregarContasValorizadas(String data) {
		
		String dataGCS = new Conversor().formatarDataString(data, "YYYYMMdd");
		
		/** saldos bancos **/
		
		Float saldoBancoSede = 0f;
		Float saldoBancoFamacia = 0f;
		Float saldoBancoOptica = 0f;
		Float saldoBancoConstrucao = 0f;
		
		
		List<Banco> bancos = repositorioBanco.findAll();
		for (Banco banco : bancos) {
			String saldo = repositorioBanco.calcularSaldo(banco.getCodigoConta(), dataGCS);
			if (saldo == null || saldo == "") {
				saldo = "0";
			}
			
			if (banco.getCodigoFilial().equals("002")) {
				
				saldoBancoFamacia = saldoBancoFamacia + Float.parseFloat(saldo);
				
			}if (banco.getCodigoFilial().equals("003")) {
				
				saldoBancoOptica = saldoBancoOptica + Float.parseFloat(saldo);
				
			}if (banco.getCodigoFilial().equals("070")) {
				
				saldoBancoConstrucao = saldoBancoConstrucao + Float.parseFloat(saldo);
				
			}if (! banco.getCodigoFilial().equals("002") && ! banco.getCodigoFilial().equals("002") && ! banco.getCodigoFilial().equals("002")) {
				
				saldoBancoSede = saldoBancoSede + Float.parseFloat(saldo);
			}
		}
		
		/** saldos caixas **/
		Float saldoCaixaSede = 0f ;
		Float saldoCaixaFamacia = 0f;
		Float saldoCaixaOptica = 0f ;
		Float saldoCaixaConstrucao = 0f;
		
		List<PostoAtendimento> postosAtendimento = repositorioPostoAtendimento.findAll();
		
		for (PostoAtendimento postoAtendimento : postosAtendimento) {
			String saldo = repositorioPostoAtendimento.calcularSaldoCaixa(postoAtendimento.getCodigo(), dataGCS);
			if (saldo == null || saldo == "") {
				saldo = "0";
			}
			
			if (postoAtendimento.getFilial().equals("002")) {
				
				saldoCaixaFamacia = saldoCaixaFamacia + Float.parseFloat(saldo);
				
			}if (postoAtendimento.getFilial().equals("003")) {
				
				saldoCaixaOptica = saldoCaixaOptica + Float.parseFloat(saldo);
				
			}if (postoAtendimento.getFilial().equals("070")) {
				
				saldoCaixaConstrucao = saldoCaixaConstrucao + Float.parseFloat(saldo);
				
			}if ( ! postoAtendimento.getFilial().equals("002") && ! postoAtendimento.getFilial().equals("003") && ! postoAtendimento.getFilial().equals("070")) {
				
				saldoCaixaSede = saldoCaixaSede + Float.parseFloat(saldo);
			}
		}
		
		List<ContaFluxo> contasFluxo = repositorioContaFluxo.findAll();
		
		/** Inicio da montagem da Conta Principal **/
		List<ContaPrincipal> principaisContas = new ArrayList<ContaPrincipal>();
		
		for (ContaFluxo contaFluxo : contasFluxo) {
			ContaPrincipal contaPrincipal = new ContaPrincipal();
			contaPrincipal.setCodigoContaFluxo(contaFluxo.getCodigo());
			
			if (contaFluxo.getCodigo().equals("001")) {
				contaPrincipal.setValorBanco(new Conversor().formataReal(saldoBancoSede.toString()));
				contaPrincipal.setValorCaixa(new Conversor().formataReal(saldoCaixaSede.toString()));
				Float saldoTotal = saldoCaixaSede + saldoBancoSede;
				contaPrincipal.setValorTotal(new Conversor().formataReal(saldoTotal.toString()));
			}
			if (contaFluxo.getCodigo().equals("002")) {
				contaPrincipal.setValorBanco(new Conversor().formataReal(saldoBancoFamacia.toString()));
				contaPrincipal.setValorCaixa(new Conversor().formataReal(saldoCaixaFamacia.toString()));
				Float saldoTotal = saldoCaixaFamacia + saldoBancoFamacia;
				contaPrincipal.setValorTotal(new Conversor().formataReal(saldoTotal.toString()));
			}
			if (contaFluxo.getCodigo().equals("003")) {
				contaPrincipal.setValorBanco(new Conversor().formataReal(saldoBancoOptica.toString()));
				contaPrincipal.setValorCaixa(new Conversor().formataReal(saldoCaixaOptica.toString()));
				Float saldoTotal = saldoCaixaOptica + saldoBancoOptica;
				contaPrincipal.setValorTotal(new Conversor().formataReal(saldoTotal.toString()));
			}
			if (contaFluxo.getCodigo().equals("070")) {
				contaPrincipal.setValorBanco(new Conversor().formataReal(saldoBancoConstrucao.toString()));
				contaPrincipal.setValorCaixa(new Conversor().formataReal(saldoCaixaConstrucao.toString()));
				Float saldoTotal = saldoCaixaConstrucao + saldoBancoConstrucao;
				contaPrincipal.setValorTotal(new Conversor().formataReal(saldoTotal.toString()));
			}
			
			principaisContas.add(contaPrincipal);
		}
		
		return principaisContas;
	}
	
	public List<DemonstrativoView> carregarDemonstrativos(){
		
		List<SegundoNivelFluxo> listaSegundoNivelFluxo = repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel("2");
		List<DemonstrativoView> demonstrativoViews = new ArrayList<DemonstrativoView>();
		for (SegundoNivelFluxo segundoNivelFluxo : listaSegundoNivelFluxo) {
			DemonstrativoView demonstrativoView = new DemonstrativoView();
			demonstrativoView.setSegundoNivelFluxo(segundoNivelFluxo);
			
			List<TerceiroNivelFluxo> receita = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("1", segundoNivelFluxo.getCodigoNivel());
			List<TerceiroNivelFluxo> despesa = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("2", segundoNivelFluxo.getCodigoNivel());
			
			demonstrativoView.setReceitaTerceiroNivelFluxo(receita);
			demonstrativoView.setDespesaTerceiroNivelFluxo(despesa);
			
			demonstrativoViews.add(demonstrativoView);
		}
		return demonstrativoViews;
	}


	@Override
	public List<ContaFluxo> carregarContas() {
		return repositorioContaFluxo.findAll();
	}


	@Override
	public List<Demonstrativo> valorizarDemonstrativo(String dataInicial, String dataFinal) {
		
		String dataInicialGCS = new Conversor().formatarDataString(dataInicial, "YYYYMMdd");
		String dataFinalGCS = new Conversor().formatarDataString(dataFinal, "YYYYMMdd");
		
		List<Demonstrativo> demonstrativos = new ArrayList<Demonstrativo>();
		List<SegundoNivelFluxo> listaSegundoNivelFluxo = repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel("2");
		for (SegundoNivelFluxo segundoNivelFluxo : listaSegundoNivelFluxo) {
			Demonstrativo demonstrativo = new Demonstrativo();
			//id para colocar na tabela
			demonstrativo.setCodigoId(segundoNivelFluxo.getCodigoNivel());
			//pegar o valor da data atual
			
			String totalReceitaAnterior = repositorioContaFluxo.calcularTotalReceitaAnteriorSegundoNivel(dataInicialGCS, dataFinalGCS, segundoNivelFluxo.getCodigoNivel());
			String totalReceita = repositorioContaFluxo.calcularTotalReceitaSegundoNivel(dataInicialGCS, dataFinalGCS, segundoNivelFluxo.getCodigoNivel());
		    String totalReceitaPrevisto= "0";
		    
		    String totalDespesaAnterior = repositorioContaFluxo.calcularTotalDespesaAnteriorSegundoNivel(dataInicialGCS, dataFinalGCS, segundoNivelFluxo.getCodigoNivel());
		    String totalDespesa = repositorioContaFluxo.calcularTotalDespesaSegundoNivel(dataInicialGCS, dataFinalGCS, segundoNivelFluxo.getCodigoNivel());
		    String totalDespesaPrevisto = "0";
		    
		    String totalLiquidoAnterior = String.valueOf(Float.parseFloat(totalReceitaAnterior) - Float.parseFloat(totalDespesaAnterior));
		    String totalLiquido = String.valueOf(Float.parseFloat(totalReceita) - Float.parseFloat(totalDespesa));
		    String totalLiquidoPrevisto = "0";
			
			
			demonstrativo.setTotalReceitaAnterior(new Conversor().formataReal(totalReceitaAnterior));
			demonstrativo.setTotalReceita(new Conversor().formataReal(totalReceita));
			demonstrativo.setTotalReceitaPrevisto("90");
			
			demonstrativo.setTotalDespesaAnterior(new Conversor().formataReal(totalDespesaAnterior));
			demonstrativo.setTotalDespesa(new Conversor().formataReal(totalDespesa));
			demonstrativo.setTotalDespesaPrevisto("100");
			
			demonstrativo.setTotalLiquidoAnterior(new Conversor().formataReal(totalLiquidoAnterior));
			demonstrativo.setTotalLiquido(new Conversor().formataReal(totalLiquido));
			demonstrativo.setTotalLiquidoPrevisto(new Conversor().formataReal(totalLiquidoPrevisto));
			
			List<TerceiroNivelFluxo> listaTerceiroNivelDespesa = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("2", segundoNivelFluxo.getCodigoNivel());
			List<TerceiroNivelFluxo> listaTerceiroNivelReceita = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel("1", segundoNivelFluxo.getCodigoNivel());
			
			List<DemonstrativoClassificacao> receitas = new ArrayList<DemonstrativoClassificacao>();
			List<DemonstrativoClassificacao> despesas = new ArrayList<DemonstrativoClassificacao>();
			/** calculo de segundo nivel **/
			for (TerceiroNivelFluxo despesa : listaTerceiroNivelDespesa) {
				DemonstrativoClassificacao classificacao = new DemonstrativoClassificacao();
				classificacao.setCodigoId(despesa.getCodigoSegundoNivel().concat(despesa.getCodigoNivel()));
				classificacao.setValorAnterior(new Conversor().formataReal(repositorioContaFluxo.calcularTotalDespesaAnteriorTerceiroNivel(dataInicialGCS, dataFinalGCS, despesa.getCodigoSegundoNivel(), despesa.getCodigoNivel())));
				classificacao.setValor(new Conversor().formataReal(repositorioContaFluxo.calcularTotalDespesaTerceiroNivel(dataInicialGCS, dataFinalGCS, despesa.getCodigoSegundoNivel(), despesa.getCodigoNivel())));
				despesas.add(classificacao);
			}
			/** calculo de segundo nivel **/
			for (TerceiroNivelFluxo receita : listaTerceiroNivelReceita) {
				DemonstrativoClassificacao classificacao = new DemonstrativoClassificacao();
				classificacao.setCodigoId(receita.getCodigoSegundoNivel().concat(receita.getCodigoNivel()));
				classificacao.setValorAnterior(new Conversor().formataReal(repositorioContaFluxo.calcularTotalReceitaAnteriorTerceiroNivel(dataInicialGCS, dataFinalGCS, receita.getCodigoSegundoNivel(), receita.getCodigoNivel())));
				classificacao.setValor(new Conversor().formataReal(repositorioContaFluxo.calcularTotalReceitaTerceiroNivel(dataInicialGCS, dataFinalGCS, receita.getCodigoSegundoNivel(), receita.getCodigoNivel())));
				receitas.add(classificacao);
			}
			
			demonstrativo.setReceitas(receitas);
			demonstrativo.setDespesas(despesas);			
			demonstrativos.add(demonstrativo);
			
		}
			
		return demonstrativos;
	}


	@Override
	public List<ContaPrincipal> valorizarConta(String dataFinal) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
