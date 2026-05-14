package interfacesExamples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocataVUE implements LocalizadorInterface{
	
	static final String VUE = "VUE"; 
	static int contadorVUE = 0; 
	
	public String generaLocata() {
		
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter fechaHoyFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = hoy.format(fechaHoyFormato);
		
		return (LocataVUE.VUE + fechaFormateada + " - " + LocataVUE.contadorVUE++); 
	}
}
