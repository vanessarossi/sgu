package br.coop.unimedriopardo.sgu.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.PrimeiroNivelFluxo;
import br.coop.unimedriopardo.sgu.models.QuartoNivelFluxo;
import br.coop.unimedriopardo.sgu.models.QuintoNivelFluxo;
import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioPrimeiroNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioQuartoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioQuintoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioSegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioTerceiroNivelFluxo;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.view.DespesaReceitaValorizada;
import br.coop.unimedriopardo.sgu.util.view.DetalheValorizado;

@Service
@Transactional
public class DespesaReceitaServiceImpl implements DespesaReceitaService {

	private final RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo;
	private final RepositorioPrimeiroNivelFluxo repositorioPrimeiroNivelFluxo;
	private final RepositorioTerceiroNivelFluxo repositorioTerceiroNivelFluxo;
	private final RepositorioQuartoNivelFluxo repositorioQuartoNivelFluxo;
	private final RepositorioQuintoNivelFluxo repositorioQuintoNivelFluxo;
	
	@Autowired
	public DespesaReceitaServiceImpl(RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo, RepositorioPrimeiroNivelFluxo repositorioPrimeiroNivelFluxo,
			RepositorioTerceiroNivelFluxo repositorioTerceiroFluxo, RepositorioQuartoNivelFluxo repositorioQuartoNivelFluxo, RepositorioQuintoNivelFluxo repositorioQuintoNivelFluxo) {
		super();
		this.repositorioSegundoNivelFluxo = repositorioSegundoNivelFluxo;
		this.repositorioPrimeiroNivelFluxo = repositorioPrimeiroNivelFluxo;
		this.repositorioTerceiroNivelFluxo = repositorioTerceiroFluxo;
		this.repositorioQuartoNivelFluxo = repositorioQuartoNivelFluxo;
		this.repositorioQuintoNivelFluxo = repositorioQuintoNivelFluxo;
	}

	@Override
	public List<DespesaReceitaValorizada> calcularValorReceitaDespesa(String data) {
		Conversor conversor = new Conversor();
		String dataGCS = conversor.formatarDataString(data, "YYYYMMdd");
		List<DespesaReceitaValorizada> despesasReceitas = new ArrayList<DespesaReceitaValorizada>();
		
		/** PRIMEIRO NIVEL **/
		List<PrimeiroNivelFluxo> primeiroNivel = repositorioPrimeiroNivelFluxo.findAll();
			for (PrimeiroNivelFluxo primeiroNivelFluxo : primeiroNivel) {
				DespesaReceitaValorizada despesaReceitaValorizada = new DespesaReceitaValorizada();
				despesaReceitaValorizada.setCodigo(primeiroNivelFluxo.getCodigoNivel());
				String valor = "";
				if(primeiroNivelFluxo.getCodigoNivel().equals("1")) {
					valor = conversor.formataRealSemCifrao(repositorioPrimeiroNivelFluxo.calcularReceita(dataGCS));
				}else{
					valor = conversor.formataRealSemCifrao(repositorioPrimeiroNivelFluxo.calcularDespesa(dataGCS));
				}
				despesaReceitaValorizada.setValorTotal(valor);
				
				despesasReceitas.add(despesaReceitaValorizada);
			}
		

		/** SEGUNDO NIVEL **/
		List<SegundoNivelFluxo> receitas = repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel("1");
		for (SegundoNivelFluxo receita : receitas) {
			DespesaReceitaValorizada despesaReceitaValorizada = new DespesaReceitaValorizada();
			despesaReceitaValorizada.setCodigo(receita.getCodigoPrimeiroNivel().concat(receita.getCodigoNivel()));
			String valor = conversor.formataRealSemCifrao(repositorioSegundoNivelFluxo.calcularReceita(dataGCS, receita.getCodigoNivel()));
			despesaReceitaValorizada.setValorTotal(valor);
			despesasReceitas.add(despesaReceitaValorizada);
		}
		List<SegundoNivelFluxo> despesas = repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel("2");
		for (SegundoNivelFluxo despesa : despesas) {
				DespesaReceitaValorizada despesaReceitaValorizada = new DespesaReceitaValorizada();
				despesaReceitaValorizada.setCodigo(despesa.getCodigoPrimeiroNivel().concat(despesa.getCodigoNivel()));
				String valor = conversor.formataRealSemCifrao(repositorioSegundoNivelFluxo.calcularDespesa(dataGCS, despesa.getCodigoNivel()));
				despesaReceitaValorizada.setValorTotal(valor);
				despesasReceitas.add(despesaReceitaValorizada);
		}	
		return despesasReceitas;
	}

	@Override
	public List<DetalheValorizado> calcularDetalhe(String codigoPrimeiroNivel, String codigoNivel, String data) {
		Conversor conversor = new Conversor();
		String dataGCS = conversor.formatarDataString(data, "YYYYMMdd");
		/** pesquisa terceiro **/
		List<TerceiroNivelFluxo> listaTerceiroNivel = repositorioTerceiroNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivel(codigoPrimeiroNivel, codigoNivel);
		
		List<QuartoNivelFluxo> listaQuartoNivel = new ArrayList<QuartoNivelFluxo>();
		List<QuintoNivelFluxo> listaQuintoNivel = new ArrayList<QuintoNivelFluxo>();
		
		for (TerceiroNivelFluxo terceiroNivelFluxo : listaTerceiroNivel) {
			listaQuartoNivel.addAll(repositorioQuartoNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivelAndCodigoTerceiroNivel(terceiroNivelFluxo.getCodigoPrimeiroNivel(), terceiroNivelFluxo.getCodigoSegundoNivel(),terceiroNivelFluxo.getCodigoNivel()));
		}
		for (QuartoNivelFluxo quartoNivelFluxo : listaQuartoNivel) {
			listaQuintoNivel.addAll(repositorioQuintoNivelFluxo.findByCodigoPrimeiroNivelAndCodigoSegundoNivelAndCodigoTerceiroNivelAndCodigoQuartoNivel(
					quartoNivelFluxo.getCodigoPrimeiroNivel(), quartoNivelFluxo.getCodigoSegundoNivel(), quartoNivelFluxo.getCodigoTerceiroNivel(), quartoNivelFluxo.getCodigoNivel()));
		}
		
		List<DetalheValorizado> detalhes = new ArrayList<DetalheValorizado>();
		for (QuintoNivelFluxo quintoNivelFluxo : listaQuintoNivel) {
			DetalheValorizado detalhe = new DetalheValorizado();
			detalhe.setDescricao(quintoNivelFluxo.getDescricao());
			detalhe.setValorTotal(conversor.formataRealSemCifrao(repositorioQuintoNivelFluxo.calcularTotal(dataGCS, quintoNivelFluxo.getCodigoPrimeiroNivel(), 
						quintoNivelFluxo.getCodigoSegundoNivel(), quintoNivelFluxo.getCodigoTerceiroNivel(), 
						quintoNivelFluxo.getCodigoQuartoNivel(), quintoNivelFluxo.getCodigoNivel())));
			detalhes.add(detalhe);
		}
		return detalhes;
	}
	
}
