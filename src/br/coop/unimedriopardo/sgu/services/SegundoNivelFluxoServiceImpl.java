package br.coop.unimedriopardo.sgu.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.repositories.RepositorioSegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.SegundoNivelView;

@Service
@Transactional
public class SegundoNivelFluxoServiceImpl implements SegundoNivelFluxoService{
	
private final RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo;
	
	@Autowired
	public SegundoNivelFluxoServiceImpl(RepositorioSegundoNivelFluxo repositorioSegundoNivelFluxo) {
		super();
		this.repositorioSegundoNivelFluxo = repositorioSegundoNivelFluxo;
	}

	@Override
	public List<SegundoNivelView> pesquisarSegundoNivel(String codigoPrimeiroNivel, String data) {
		List<SegundoNivelFluxo> listaSegundoNivelFluxo = repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel(codigoPrimeiroNivel);
		List<SegundoNivelView> listaSegundoNivelComValor = new ArrayList<>();
			for(SegundoNivelFluxo segundoNivelFluxo : listaSegundoNivelFluxo ) {
				SegundoNivelView segundoNivelView = new SegundoNivelView();
				segundoNivelView.setCodigo(segundoNivelFluxo.getCodigo());
				segundoNivelView.setCodigoAcesso(segundoNivelFluxo.getCodigoAcesso());
				segundoNivelView.setCodigoNivel(segundoNivelFluxo.getCodigoNivel());
				segundoNivelView.setCodigoPrimeiroNivel(segundoNivelFluxo.getCodigoPrimeiroNivel());
				segundoNivelView.setDescricao(segundoNivelFluxo.getDescricao());
				
				if(Integer.parseInt(segundoNivelFluxo.getCodigoPrimeiroNivel()) == 1) { //1 - receita  2 - despesa
					segundoNivelView.setValorTotal(new Conversor().formataReal(repositorioSegundoNivelFluxo.calcularReceita(data, segundoNivelFluxo.getCodigoNivel())));
				}else {
					segundoNivelView.setValorTotal(new Conversor().formataReal(repositorioSegundoNivelFluxo.calcularDespesa(data, segundoNivelFluxo.getCodigoNivel())));
				}
				
				listaSegundoNivelComValor.add(segundoNivelView);
			}
		
		return listaSegundoNivelComValor;
	}

	@Override
	public String calcularSaldoReceita(String data, String codigoSegundoNivel02) {
		 return repositorioSegundoNivelFluxo.calcularReceita(data, codigoSegundoNivel02);
	}

	@Override
	public String calcularSaldoDespesa(String data, String codigoSegundoNivel02) {
		 return repositorioSegundoNivelFluxo.calcularDespesa(data, codigoSegundoNivel02);
	}

	@Override
	public List<SegundoNivelFluxo> pesquisarDescricoes(String codigoPrimeiroNivel) {
		return repositorioSegundoNivelFluxo.findByCodigoPrimeiroNivel(codigoPrimeiroNivel);
	}
}
