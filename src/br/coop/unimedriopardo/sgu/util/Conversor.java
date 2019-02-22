package br.coop.unimedriopardo.sgu.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversor {
	
		public String formatarData(Date data, String formato) {
			SimpleDateFormat formatoData = new SimpleDateFormat(formato);
			String dataFormatada = formatoData.format(data);
			return dataFormatada;
		}
		
		public String formatarDataString(String data, String formatoNovo) {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = formato.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			formato.applyPattern(formatoNovo);
			String dataFormatada = formato.format(date);
			return dataFormatada;
		}
		
		public String formataReal(String valorString) {
			valorString = valorString.replace(",", ".");
			BigDecimal valor = new BigDecimal (valorString);  
			NumberFormat nf = NumberFormat.getCurrencyInstance();  
			String formatado = nf.format (valor);
			return formatado;
		}
		
		public String formataRealSemCifrao(String valorString) {
			valorString = valorString.replace(",", ".");
			BigDecimal valor = new BigDecimal (valorString);  
			NumberFormat nf = NumberFormat.getInstance();  
			String formatado = nf.format (valor);
			return formatado;
		}
}
