package interfacesExamples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocataHTL implements LocalizadorInterface {
	
	static final String HTL = "HTL"; 
	static int contadorHTL = 0; 
	
	public String generaLocata() {
		
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter fechaHoyFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = hoy.format(fechaHoyFormato);
		
		return (LocataHTL.HTL + fechaFormateada + " - " + LocataHTL.contadorHTL++); 
	}
	
}
