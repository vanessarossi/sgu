package br.coop.unimedriopardo.sgu.util.view.fluxo;

import java.util.List;

import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;

public class DemonstrativoView {

	private SegundoNivelFluxo segundoNivelFluxo;
	private List<TerceiroNivelDemonstrativoView> despesas;
	private List<TerceiroNivelDemonstrativoView> receitas;
	public SegundoNivelFluxo getSegundoNivelFluxo() {
		return segundoNivelFluxo;
	}
	public void setSegundoNivelFluxo(SegundoNivelFluxo segundoNivelFluxo) {
		this.segundoNivelFluxo = segundoNivelFluxo;
	}
	public List<TerceiroNivelDemonstrativoView> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<TerceiroNivelDemonstrativoView> despesas) {
		this.despesas = despesas;
	}
	public List<TerceiroNivelDemonstrativoView> getReceitas() {
		return receitas;
	}
	public void setReceitas(List<TerceiroNivelDemonstrativoView> receitas) {
		this.receitas = receitas;
	}
}
