package br.coop.unimedriopardo.sgu.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversor {
	
		public String formatarData(Date data, String formato) {
			SimpleDateFormat formatoData = new SimpleDateFormat(formato);
			String dataFormatada = formatoData.format(data);
			return dataFormatada;
		}
		
		public String formatarDataString(String data) {
			String dataFormatada = data.replace("-", "");
			return dataFormatada;
		}
		
		public String formataReal(String valorString) {
			BigDecimal valor = new BigDecimal (valorString);  
			NumberFormat nf = NumberFormat.getCurrencyInstance();  
			String formatado = nf.format (valor);
			return formatado;
		}
}
