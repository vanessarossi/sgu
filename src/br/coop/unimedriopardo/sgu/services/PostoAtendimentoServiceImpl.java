package br.coop.unimedriopardo.sgu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.PostoAtendimento;
import br.coop.unimedriopardo.sgu.repositories.RepositorioPostoAtendimento;

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
			postoAtendimento.setSaldo(retornaSaldo(postoAtendimento.getCodigo(), "20181231"));
		}
		return postosAtendimento;
	}


	@Override
	public String retornaSaldo(String postoAtendimento, String data) {
		return repositorioPostoAtendimento.calcularSaldoCaixa(postoAtendimento, data);
	}

}
