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
		
		
		public String formatarCompString(String data, String formatoNovo) {
			SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
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
		
		
		public String formatarCompetenciaString(String data, String formatoNovo) {
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
			BigDecimal valor = new BigDecimal(valorString);
			NumberFormat nf = NumberFormat.getCurrencyInstance();  
			nf.setMaximumFractionDigits(2);
			nf.setMinimumFractionDigits(2);
			String formatado = nf.format (valor);
			return formatado;
		}
		
		public String formataRealSemCifrao(String valorString) {
			valorString = valorString.replace(",", ".");
			BigDecimal valor = new BigDecimal (valorString);  
			NumberFormat nf = NumberFormat.getInstance();  
			nf.setMaximumFractionDigits(2);
			nf.setMinimumFractionDigits(2);
			String formatado = nf.format (valor);
			return formatado;
		}
		
		public String calcularCompetenciaAnterior(String competenciaAtual) {
				String mes = competenciaAtual.substring(0,2);
				String ano = competenciaAtual.substring(3,7);
				
				if((Integer.parseInt(mes)-1) < 1) {
					mes = "12";
					ano = String.valueOf(Integer.parseInt(ano) - 1);
				}else{
					if(String.valueOf(Integer.parseInt(mes)-1).length() == 1) {
						mes = "0"+String.valueOf(Integer.parseInt(mes)-1);
					}else {
						mes = String.valueOf(Integer.parseInt(mes)-1);
					}
				}
			
			return mes+"/"+ano;
		}

		public String calcularCompetenciaPrevisao(String competenciaAtual) {
			
			String mes = competenciaAtual.substring(0,2);
			String ano = competenciaAtual.substring(3,7);
			
			if((Integer.parseInt(mes)+1) > 12) {
				mes = "01";
				ano = String.valueOf(Integer.parseInt(ano) + 1);
			}else{
				if(String.valueOf(Integer.parseInt(mes) + 1).length() == 1) {
					mes = "0"+String.valueOf(Integer.parseInt(mes) + 1);
				}else {
					mes = String.valueOf(Integer.parseInt(mes) + 1);
				}
			}
		
		return mes+"/"+ano;
		}
}
