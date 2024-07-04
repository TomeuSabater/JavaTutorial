package leccion_15_Ejercicio;

public class Leccion_15_Ejercicio {

	public static void main(String[] args) {
		
		// Introducción_VII a CLASES Y OBJETOS. 
		
		// Local Class
		// Local classes are similar to inner classes because they cannot define or declare any static members.
		// You cannot declare static initializers or member interfaces in a local class. 
		// A local class can have static members provided that they are constant variables
		
		// Refactorizamos Lección_14.java
		// Generamos una Class ValidatePhoneNumber que contendrá un método público estático ParseNumber(String phonenumber) que devuelve un booleano
		// El método estático ParseNumber(String phonenumber) contiene una Local Class CheckNumber
		
		
		if (ValidatePhoneNumber.ParseNumber("606975760"))
			System.out.println("Es válido");
		else
			System.out.println("No lo es");

		if (ValidatePhoneNumber.ParseNumber("606-975-760"))
			System.out.println("Es válido");
		else
			System.out.println("No lo es");
		
		if (ValidatePhoneNumber.ParseNumber("+34 606-975-760"))
			System.out.println("Es válido");
		else
			System.out.println("No lo es");
		
	} // public static void main

} // class Leccion_15_Ejercicio
