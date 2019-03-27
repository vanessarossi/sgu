package br.coop.unimedriopardo.sgu.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.coop.unimedriopardo.sgu.models.Banco;
import br.coop.unimedriopardo.sgu.repositories.RepositorioBanco;
import br.coop.unimedriopardo.sgu.util.Conversor;
import br.coop.unimedriopardo.sgu.util.view.BancoView;


@Service
@Transactional
public class BancoServiceImpl implements BancoService {

	private final RepositorioBanco repositorioBanco;
	
	@Autowired
	public BancoServiceImpl(RepositorioBanco repositorioBanco) {
		super();
		this.repositorioBanco = repositorioBanco;
	}

	@Override
	public List<BancoView> listarContasBancariaValorizada(String data) {
		List<Banco> contasBancarias = repositorioBanco.findAll();
		List<BancoView> contasBancoView = new ArrayList<BancoView>();
		for (Banco banco : contasBancarias) {
			BancoView bancoView = new BancoView();
			bancoView.setCodigoConta(banco.getCodigoConta());
			bancoView.setNomeConta(banco.getNomeConta());
			bancoView.setCodigoFilial(banco.getCodigoFilial());
			bancoView.setRazaoFilial(banco.getRazaoFilial());
			bancoView.setAplicacao(banco.getAplicacao());
			bancoView.setValor(new Conversor().formataReal(retornaSaldo(banco.getCodigoConta(), data)));
			contasBancoView.add(bancoView);
		}
		return contasBancoView;
	}

	@Override
	public String retornaSaldo(String codigoConta, String data) {
		String saldo = repositorioBanco.calcularSaldo(codigoConta, data);
		if (saldo == null || saldo == "") {
			saldo = "0";
		}
		return saldo;
	}


	@Override
	public String retornaSaldoTotalContas(String data) {
		return new Conversor().formataReal(repositorioBanco.calcularTotalSaldo(data));
	}

	@Override
	public String retornaSaldoTotalContaCorrente(String data) {
		return new Conversor().formataReal(repositorioBanco.calcularTotalSaldoContaCorrente(data));
	}

	@Override
	public String retornaSaldoTotalContaAplicacao(String data) {
		return new Conversor().formataReal(repositorioBanco.calcularTotalSaldoContaAplicacao(data));
	}

	@Override
	public String retornaSaldoTotalContaAplicacaoAns(String data) {
		return new Conversor().formataReal(repositorioBanco.calcularTotalSaldoContaAplicacaoAns(data));
	}

}