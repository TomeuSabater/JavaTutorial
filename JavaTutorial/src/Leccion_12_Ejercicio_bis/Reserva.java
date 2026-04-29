package Leccion_12_Ejercicio_bis;

import java.time.LocalDate;

// Class Reserva contiene dos Nested Class
//	se hace para comparar las diferencias entre una
//	Inner Class y una Static Nested Class

// - LocalizadorReservaStatic: Es una Static Nested Class
// - LocalizadorReservaInner: Es una Inner Class

// Localizador de una reserva está compuesto por
// 	- YYYY/MM/Contador. Ejemplo: 2024/07/1
// 	- YYYY: Año en curso
// 	- MM: Mes en curso
// 	- Contador: Número consecutivo incremental

public class Reserva {
	
	// Atributos de Instancia
	private String LocataReservaStatic = null; // Primer Localizador de cada reserva
	private String LocataReservaInner = null; // Segundo Localizador de cada reserva 
	private String titular = null; //Titular de la reserva
	private LocalDate fechaReserva;  //Fecha de confirmación de la reserva
	
		//// Static Nested Class
		
		// Class static con métodos y atributos static
		// Además de ser una Class Nested, es Static (realmente no tendrá constructor, será como un "contenedor" de métodos)  
		// As a member of the OuterClass, a nested class can be declared private, public, protected, or package private.
		// 		outer classes can only be declared public or package private.
		private static class LocalizadorReservaStatic {
						
			// Variables static de la Class
			
			private static String localizador; // Ultimo Localizador generado
			static {
				LocalizadorReservaStatic.localizador = null; // Inicialización
			}
			
			private static int numeroReserva; //Número consecutivo de la reserva
			static {
				LocalizadorReservaStatic.numeroReserva = 0; // Inicialización
			}
			
			//// Métodos de la Class
			
			private static String generaLocalizador() {
				
				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); //Obtenemos el año
				String sanyo = String.valueOf(anyo); //Transformamos año en String
				int mes = hoy.getMonthValue(); //Obtenemos el mes
				String smes = String.valueOf(mes); //Transformamos año en String
				String snumeroReserva = String.valueOf(++LocalizadorReservaStatic.numeroReserva); // Número único consecutivo
				
				LocalizadorReservaStatic.localizador = sanyo + "/" + smes + "/" + snumeroReserva; 
				//this.LocataReserva = LocalizadorReserva.localizador; // No puede acceder a elementos de su Class contenedora
																		// 	este es el motivo por el que hacemos un método
				return LocalizadorReservaStatic.localizador; 		
			}
		} // private static class LocalizadorReservaStatic
		
				
		//// Nested Class (Inner Class) 
				
		private class LocalizadorReservaInner {
			
			// Variables Static de la Class
			
			private static String Localizador; // Ultimo Localizador Generado
			static {
				LocalizadorReservaInner.Localizador = null; // Inicialización
			}
			
			private static int numeroReserva; // Númeo Consecutivo de Reserva
			static {
				LocalizadorReservaInner.numeroReserva = 0; // Inicialización
			}
			
			//// Métodos de la Class
			
			private static String generaLocalizador() {
				
				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); // Año en curso
				String sanyo = String.valueOf(anyo); // Transformamos año en String
				int mes = hoy.getMonthValue(); // Obtenemos mes en curso
				String smes = String.valueOf(mes); // Transformamos año en String
				String snumeroReserva = String.valueOf(++LocalizadorReservaInner.numeroReserva); // Numero único consecutivo
				
				LocalizadorReservaInner.Localizador = sanyo + "/" + smes + "/" + snumeroReserva; 
				return LocalizadorReservaInner.Localizador; 
			}
		} // private class LocalizadorReservaInner
			
	//Constructor
	Reserva(String titular, String fecha) {
				
		this.LocataReservaStatic = LocalizadorReservaStatic.generaLocalizador(); 
		this.LocataReservaInner = LocalizadorReservaInner.generaLocalizador(); 
		this.titular = titular; 
		this.fechaReserva = LocalDate.parse(fecha); 
	}
	
	//// Métodos static

	//Muestra número actual de reserva del localizador Static
	public static int muestraNumerodeReservaStatic() {
		
		return LocalizadorReservaStatic.numeroReserva; 
	}
	
	//Muestra número actual de reseva del localizador Inner
	public static int muestraNumerodeReservaInner() {
		
		return LocalizadorReservaInner.numeroReserva; 
	}
	
	//Muestra localizador actual del localizador Static
	public static String muestraLocalizadorActualStatic() {
		
		return LocalizadorReservaStatic.localizador; 
	}
	
	//Muestra localizador actual del localizador Inner
	public static String muestraLocalizadorActualInner() {
		
		return LocalizadorReservaInner.Localizador; 
	}
	
	//// Métodos públicos
	
	//Muestra la Reserva
	public void muestraReserva() {
		System.out.println("*********************************");
		System.out.println("Localizador : " + this.LocataReservaStatic); 
		System.out.println("Localizador : " + this.LocataReservaInner); 
		System.out.println("Titular : " + this.titular);
		System.out.println("Fecha Reserva : " + this.fechaReserva); 
	} 
	
} // class Reserva