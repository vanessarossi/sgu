package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import br.coop.unimedriopardo.sgu.util.view.DespesaReceitaValorizada;
import br.coop.unimedriopardo.sgu.util.view.DetalheValorizado;

public interface DespesaReceitaService {
	
	public List<DespesaReceitaValorizada> calcularValorReceitaDespesa(String data);
	public List<DetalheValorizado> calcularDetalhe(String codigoPrimeiroNivel, String codigoNivel, String data);
}
