package classesAndObjects;

public class Leccion_14 {
	
	// Introducción_VII a CLASES Y OBJETOS. 
	
	// Local Class (Caso especial de una Inner Class) 
	
	// Hasta el momento, hemos visto las Nested Class (Inner / Static) que es una Class dentro de una Class contenedora.
	// La Nested Class es un elemento más de la Class contenedora, y le podemos aplicar control de acceso y visibilidad; static, private, public, etc.  

	// Local Classes are similar to Inner Classes because they cannot define or declare any static members.
	// You cannot declare static initializers or member interfaces in a Local Class. 
	// A Local Class can have static members provided that they are constant variables
		
	public static void main(String[] args) {
		

		class LocalClassExample {  
			
			// Variables de la Class
			private static String regularExpression = "[^0-9]"; 
			
			// Métodos estáticos 
			public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
			
				//Variables locales del método
				byte numberLength  = 10; //final or effectively final, then local class has access
							
				
				//******** LOCAL CLASS EXAMPLE 
				// Local Class, this Class is defined inside the static method
				// A local class has access to the members of its enclosing class.
				class PhoneNumber {
					
					//Variables de Instancia
					private String formattedPhoneNumber = null; 
					
					//Constructor
					PhoneNumber(String phoneNumber) {
						
						// numberLength  = 7; Error because must be a final or an effectively final 
						String currentNumber = phoneNumber.replaceAll(regularExpression, ""); //Elimina cualquier carácter excepto 0-9
						if (currentNumber.length() == numberLength) {
							formattedPhoneNumber = currentNumber; 
						} else {
							formattedPhoneNumber = null; 
						}
					} //Constructor
						
					// Métodos públicos de la Local Class
					private String getNumber() {
						return this.formattedPhoneNumber; 
					}
					
					private void printOriginalNumbers() {
						System.out.println("Original numbers are :" + phoneNumber1 + " and " + phoneNumber2); // Local class can access parameters of method enclosing the class
					}
					
				} // class PhoneNumber //******** LOCAL CLASS EXAMPLE 
								
				
				PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1); // Creamos Obj de Local Class
				PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2); // Creamos Obj de Local Class
				
				myNumber1.printOriginalNumbers();
				
				// El if de abajo debería refactorizarse, llama dos veces al mismo método
				if (myNumber1.getNumber() == null) 
					System.out.println("First number is invalid");
				else
					System.out.println("First number is " + myNumber1.getNumber()); 
				
				if (myNumber2.getNumber() == null)
					System.out.println("Second number is invalid");
				else
					System.out.println("Second number is " + myNumber2.getNumber()); 
					
			} //public static void validatePhoneNumber

		} // class LocalClassExample //******** LOCAL CLASS
		

		LocalClassExample.validatePhoneNumber("123-456-7890", "456-7890"); //Llamada al método estático
		
	} // public static void main
	
	// No me acaba de convencer mucho, vamos a ver si lo podemos refactorizar de alguna manera y darle algún sentido
	// Haremos un ejemplo similar pero con validatePhoneNumber(un_único_numero) en lugar de dos en lección_15_Ejercicio 
	// El código no es óptimo ya que es un ejemplo de las posibilidades de una Local Class

} // public class Leccion_14
