package br.coop.unimedriopardo.sgu.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.models.PostoAtendimento;
import br.coop.unimedriopardo.sgu.repositories.RepositorioPostoAtendimento;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.view.PostoAtendimentoView;

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
	public List<PostoAtendimentoView> listarPostosAtendimentoValorizado(String data) {
		List<PostoAtendimento> postosAtendimento = repositorioPostoAtendimento.findAll();
		List<PostoAtendimentoView> postosAtendimentoView = new ArrayList<PostoAtendimentoView>();
		for (PostoAtendimento postoAtendimento : postosAtendimento) {
			PostoAtendimentoView postoAtendimentoView = new PostoAtendimentoView();
			postoAtendimentoView.setCodigoPosto(postoAtendimento.getCodigoPosto());
			postoAtendimentoView.setDescricao(postoAtendimento.getDescricao());
			postoAtendimentoView.setCodigoFilial(postoAtendimento.getCodigoFilial());
			postoAtendimentoView.setRazaoFilial(postoAtendimento.getRazaoFilial());
			postoAtendimentoView.setValor(new Conversor().formataReal(retornaSaldo(postoAtendimento.getCodigoPosto(),data)));
			postosAtendimentoView.add(postoAtendimentoView);
		}
		return postosAtendimentoView;
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
	public String retornaSaldoTotalCaixas(String data) {
		return new Conversor().formataReal(repositorioPostoAtendimento.calcularTotalSaldoCaixa(data));
	}

}
