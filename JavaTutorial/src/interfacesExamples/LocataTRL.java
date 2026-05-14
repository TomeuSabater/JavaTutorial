package interfacesExamples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocataTRL implements LocalizadorInterface{
	
	static final String TRL = "TRL"; 
	static int contadorTRL = 0; 
	
	public String generaLocata() {
		
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter fechaHoyFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = hoy.format(fechaHoyFormato);
		
		return (LocataTRL.TRL + fechaFormateada + " - " + LocataTRL.contadorTRL++); 
	}
}