package classesAndObjects;

public class InterfacesExample {

	
	// Ejemplo de Interface 
	
	// Mayoritariamente se utiliza como "contrato"; es una manera de 
	// publicar los métodos que se ofertarán que se podrán utilizar sin 
	// exponer el código de los mismos. 
	// Permite publicar un método sin tener el desarrollo del mismo. 
	// No obstante, en el momento de la ejecución, será necesario que el 
	// método esté completamente desarrollado. 
	
	// In Java, an interface is a reference type, similar to a class, 
	// that can contain only constants, method signatures, default methods, 
	// static methods (private or public, not protected), 
	// instance non-abstract methods (private, not public, not protected), and nested types. 
	
	// Method bodies exist only for default methods, private methods and static methods. 
	// Interfaces cannot be instantiated—they can only be implemented by classes or extended by other interfaces. 

	public interface PaxDetails {
	
		// Interace que define los métodos que podremos invocar
		
		String nombrePaxLimpio(String nombreOriginal);
		Boolean esAdulto(String fechaNacimiento);
		
		float getPesoPaxIMP(float pesoPaxMDC); 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
