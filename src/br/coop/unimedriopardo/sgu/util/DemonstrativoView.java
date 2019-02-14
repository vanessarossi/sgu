package br.coop.unimedriopardo.sgu.util;

import java.util.List;
import br.coop.unimedriopardo.sgu.models.SegundoNivelFluxo;
import br.coop.unimedriopardo.sgu.models.TerceiroNivelFluxo;


public class DemonstrativoView {
		
	private SegundoNivelFluxo segundoNivelFluxo;
	private List<TerceiroNivelFluxo> receitaTerceiroNivelFluxo;
	private List<TerceiroNivelFluxo> despesaTerceiroNivelFluxo;
	public SegundoNivelFluxo getSegundoNivelFluxo() {
		return segundoNivelFluxo;
	}
	public void setSegundoNivelFluxo(SegundoNivelFluxo segundoNivelFluxo) {
		this.segundoNivelFluxo = segundoNivelFluxo;
	}
	public List<TerceiroNivelFluxo> getReceitaTerceiroNivelFluxo() {
		return receitaTerceiroNivelFluxo;
	}
	public void setReceitaTerceiroNivelFluxo(List<TerceiroNivelFluxo> receitaTerceiroNivelFluxo) {
		this.receitaTerceiroNivelFluxo = receitaTerceiroNivelFluxo;
	}
	public List<TerceiroNivelFluxo> getDespesaTerceiroNivelFluxo() {
		return despesaTerceiroNivelFluxo;
	}
	public void setDespesaTerceiroNivelFluxo(List<TerceiroNivelFluxo> despesaTerceiroNivelFluxo) {
		this.despesaTerceiroNivelFluxo = despesaTerceiroNivelFluxo;
	}
	
			
}
