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

	@Override
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
			contaPrincipal.setContaFluxo(contaFluxo);
			contaPrincipal.setCompetencia(new Conversor().formatarDataString(data, "dd/MM/YYYY"));
			
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
	
}
