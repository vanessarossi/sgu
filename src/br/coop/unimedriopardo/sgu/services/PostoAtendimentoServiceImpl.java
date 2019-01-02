package br.coop.unimedriopardo.sgu.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.PostoAtendimento;
import br.coop.unimedriopardo.sgu.repositories.RepositorioPostoAtendimento;
import br.coop.unimedriopardo.sgu.util.Conversor;

@Service
@Transactional
public class PostoAtendimentoServiceImpl implements PostoAtendimentoService {


private final RepositorioPostoAtendimento repositorioPostoAtendimento;
	
	@Autowired
	public PostoAtendimentoServiceImpl(RepositorioPostoAtendimento repositorioPostoAtendimento) {
		super();
		this.repositorioPostoAtendimento = repositorioPostoAtendimento;
	}
	
	
	@Override
	public List<PostoAtendimento> listarPostosAtendimento() {
		List<PostoAtendimento> postosAtendimento = repositorioPostoAtendimento.findAll();
		for (PostoAtendimento postoAtendimento : postosAtendimento) {
			postoAtendimento.setSaldo(new Conversor().formataReal(retornaSaldo(postoAtendimento.getCodigo(), new Conversor().formatarData(new Date(), "YYYYMMdd"))));
		}
		return postosAtendimento;
	}


	@Override
	public String retornaSaldo(String codigoPostoAtendimento, String data) {
		String saldo = repositorioPostoAtendimento.calcularSaldoCaixa(codigoPostoAtendimento, data);
		if (saldo == null || saldo == "") {
			saldo = "0";
		}
		return saldo;
	}


	@Override
	public String retornaSaldoTotalCaixas() {
		return new Conversor().formataReal(repositorioPostoAtendimento.calcularTotalSaldoCaixa(new Conversor().formatarData(new Date(), "YYYYMMdd")));
	}


	@Override
	public String retornaSaldoTotalCaixasPorDiaEscolhido(String data) {
		String dataConvertida = new Conversor().formatarDataString(data);
		return new Conversor().formataReal(repositorioPostoAtendimento.calcularTotalSaldoCaixa(dataConvertida));
	}


	@Override
	public List<PostoAtendimento> listarPostosAtendimentoPorDiaEscolhido(String data) {
		String dataConvertida = new Conversor().formatarDataString(data);
		List<PostoAtendimento> postosAtendimento = repositorioPostoAtendimento.findAll();
		for (PostoAtendimento postoAtendimento : postosAtendimento) {
			postoAtendimento.setSaldo(new Conversor().formataReal(retornaSaldo(postoAtendimento.getCodigo(),dataConvertida)));
		}
		return postosAtendimento;
	}

}
