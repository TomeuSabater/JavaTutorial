package leccion_15_Ejercicio;

public class ValidatePhoneNumber {

	// Variables de Class
	private static String regularExpression = "[^0-9]"; 
	
	// Método estático que contendrá la Local Class
	static boolean ParseNumber(String phonenumber) {
		
		// Variables del método
		byte numberLength  = 9; //final or effectively final, then local class has access
		
		// Local Class
		class PhoneNumber {
			
			//Variables de Instancia
			private String formattedPhoneNumber = null; 
			
			//Constructor
			PhoneNumber(String phoneNumber) {
				
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");
				if (currentNumber.length() == numberLength) {
					this.formattedPhoneNumber = currentNumber; 
				}
			} // //Constructor
			
			// Métodos públicos de la Local Class
			private String getNumber() {
				return this.formattedPhoneNumber; 
			}
		} // Local Class
		
		PhoneNumber myNumber = new PhoneNumber(phonenumber);
		
		if (myNumber.getNumber() == null)
			return false;
		else 
			return true; 
	} // private static boolean ParseNumber(String phonenumber)
	
} // ValidatePhoneNumber
