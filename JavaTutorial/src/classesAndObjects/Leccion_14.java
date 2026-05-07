package classesAndObjects;

public class Leccion_14 {
	
	// Introducción_VII a CLASES Y OBJETOS. 
	
	// Local Class (Caso especial de una Inner Class) 
	
	// Hasta el momento, hemos visto las Nested Class (Inner / Static) 
	// que permite la definición de una Class dentro de una Class contenedora.
	
	// Local Classes are classes that are defined in a block, 
	// which is a group of zero or more statements between balanced braces. 
	// You typically find local classes defined in the body of a method.
	
	// Local Classes are non-static because they have access to instance members 
	// of the enclosing block. Consequently, they cannot contain most kinds of static declarations.
	
	// Local Classes are similar to Inner Classes because they cannot define or declare any static members.
	// You cannot declare static initializers or member interfaces in a Local Class. 
	// A Local Class can have static members provided that they are constant variables
		
	public static void main(String[] args) {
		
		class EjemploClassLocal {  
			
			// Variables de la Class
			private static final String SOLONUMEROS = "[^0-9]"; 
			
			// Métodos estáticos de la EjemploClassLocal
			// 	Y este método es 'complejo' por lo que optamos por 
			// 	estructuralo definiendo una Local Class 'PhoneNumberLocalClass'
			private static void validaTelefono(String tfValidar) {
			
				//Variables locales del método static
				//es una final, por tanto la Local Class has access
				final byte longNumTf  = 11; 
											
				//******** LOCAL CLASS EXAMPLE 
				// Local Class, this Class is defined inside the static method
				// A local class has access to the members of its enclosing class.
				class PhoneNumberLocalClass {
					
					//Variables de Instancia
					private String tfFormateado = null; // Número formateado
					
					//Constructor
					PhoneNumberLocalClass(String tfOriginal) {
						
						//Elimina cualquier carácter excepto 0-9
						String tfLimpio = tfOriginal.replaceAll(SOLONUMEROS, ""); 
						// Comprobamos la longitud depués de limpiarlo
						if (tfLimpio.length() == longNumTf) {
							tfFormateado = tfLimpio; 
						} else {
							tfFormateado = null; 
						}
					} //Constructor
						
					// Métodos de la Local Class
					private String getNumeroFormateado() {
						return this.tfFormateado; 
					}
					
					private void printOriginalNumbers() {
						System.out.println("Número original es :" + tfValidar); // Local class can access parameters of method enclosing the class
					}
					
				} // class PhoneNumber //******** LOCAL CLASS EXAMPLE 
				
				// Creamos Obj de Local Class
				PhoneNumberLocalClass objNumTfLocal = new PhoneNumberLocalClass(tfValidar); 
				
				// Llamamos a método de la Local Class
				objNumTfLocal.printOriginalNumbers();
				
				// El if de abajo debería refactorizarse, 
				// llama dos veces al mismo método de la Local Class
				if (objNumTfLocal.getNumeroFormateado() == null) {
					System.out.println("Número NO es válido");
				} else {
					System.out.println("Número formateado es " + objNumTfLocal.getNumeroFormateado()); 
				}
									
			} //private static void validaTelefono

		} // class LocalClassExample
		
		EjemploClassLocal.validaTelefono("+34-606-975-760"); //Llamada al método estático
		EjemploClassLocal.validaTelefono("971-456-7890"); //Llamada al método estático
		EjemploClassLocal.validaTelefono("971123456-789"); //Llamada al método estático
		EjemploClassLocal.validaTelefono("123456-789"); //Llamada al método estático
		EjemploClassLocal.validaTelefono("+34-871-951-916"); //Llamada al método estático
		
	} // public static void main
	
	// El código mostrado aquí no es óptimo ya que es un ejemplo de las posibilidades de una Local Class
	// Haremos un ejemplo similar pero más sencillo en lección_15_Ejercicio 

} // public class Leccion_14
