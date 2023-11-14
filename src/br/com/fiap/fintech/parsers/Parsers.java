package br.com.fiap.fintech.parsers;

import java.time.LocalDate;

public class Parsers {
	
	public static Integer parsersStringToInt (String valor){
		try {
			Integer retorno = Integer.parseInt(valor);
			return retorno;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static LocalDate parsersStringToLocalDate (String valor){
		
		try {
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate retorno = LocalDate.parse(valor);
			return retorno;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Long parsersStringToLong (String valor){
		
		try {
			Long retorno = Long.parseLong(valor);
			return retorno;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Double parsersStringToDouble (String valor){
		
		try {
			Double retorno = Double.parseDouble(valor);
			return retorno;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
