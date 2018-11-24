package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.spring.util.DataHoraConverter;

public class Testes {
	public static void main(String[] args) {
		
		
//		System.out.println("Data: " + DataHoraConverter.momentDate());
		
//		System.out.println("Hora: " + DataHoraConverter.momentTime());
		
		System.out.println("Data e Hora: " + DataHoraConverter.momentDateTime());
		System.out.println("Tipo Date: " + getDateTime());
		
	}
	
	
	private static Date getDateTime() { 
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
//		return dateFormat.format(date); 
		return date; 
	}
}
