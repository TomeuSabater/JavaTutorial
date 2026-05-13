package interfacesExamples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PaxUtilities implements PaxUtilitiesInterface{
	
	
	static final int ESMAYOR = 18; 	// Mayor de edad en EU
	static final int USMAYOR = 21;  // Mayor de edad en US
	
	// 
	public String nombrePaxLimpio(String nombreOriginal) {
				
		// Limpiamos y formateamos el String que nos pasn
		
		String NomLimpio; // Variable temporal 
		
		NomLimpio = nombreOriginal.replaceAll("[^a-zA-Z]", "");
		
		if (NomLimpio == "") {
			return null; 
		} else {
			return NomLimpio.toUpperCase(); 
		}
	}
	
	public Boolean esAdulto(String fechaNacimiento, String codigoPais){
		
		// Determinamos si el pax es adulto (>18 años) 
		
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento);
		long anyos = ChronoUnit.YEARS.between(fechaNac, LocalDate.now());
		
		switch (codigoPais) {
			case "EU": // Europa
				return (anyos >= PaxUtilities.ESMAYOR) ? true : false;
			case "US": // USA
				return (anyos >= PaxUtilities.USMAYOR) ? true : false;
		}
		return true; 
	} // esAdulto
	
	// 
	public float getPesoPaxIMP(float pesoPaxMDC) {
		
		return 3.3f; 
	}

}
