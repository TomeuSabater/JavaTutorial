package interfacesExamples;

public class PaxUtilities implements PaxUtilitiesInterface{
	
	// Esta class 
	
	public String nombrePaxLimpio(String nombreOriginal) {
	
		return "hola"; 
	}
	
	public Boolean esAdulto(String fechaNacimiento, String codigoPais){
		
		return true; 
	}
	
	public float getPesoPaxIMP(float pesoPaxMDC) {
		
		return 3.3f; 
	}

}
