package com.spring.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DataHoraConverter {
	
	public static String momentTime() {
	    Calendar data;
        data = Calendar.getInstance();
        
        int horas = data.get(Calendar.HOUR_OF_DAY);
        int minutos = data.get(Calendar.MINUTE);
        int segundos = data.get(Calendar.SECOND);
                
		return horas + ":" + minutos + ":" + segundos;
	}
	
	public static LocalDate momentDate() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		 
		String dataAtual = formato.format(calendar.getTime());
		
		DateTimeFormatter formatoDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataAtual, formatoDeData);
        
		return data;
	}

	public static String momentDateTime() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		 
		String dataHoraAtual = formato.format(calendar.getTime());
		
//		System.out.println("class"+dataHoraAtual);
		
//		DateTimeFormatter formatoDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		LocalDate data = LocalDate.parse(dataHoraAtual, formatoDeData);
        
		return dataHoraAtual;
	}
}
