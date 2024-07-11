package leccion_12_Ejercicio;

import java.time.LocalDate;

public class Reserva {
		
	// Atributos de Instancia
	private String LocataReserva = null; //Localizador de cada reserva
	private String titular = null; //Titular de la reserva
	private LocalDate fechaReserva;  //Fecha de confirmación de la reserva
	
		//// Static Nested Class
		
		// Class static con métodos y atributos static
		// Además de ser una Class Nested, es Static (realmente no tendrá constructor, será como un "contenedor" de métodos)  
		// As a member of the OuterClass, a nested class can be declared private, public, protected, or package private.
		// 		outer classes can only be declared public or package private.
		private static class LocalizadorReserva {
			
			//Localizador de una reserva está compuesto por
			// YYYY/MM/Contador. Ejemplo: 2024/07/1
			// YYYY: Año en curso
			// MM: Mes en curso
			// Contador: Número consecutivo incremental
			
			// Variables static de la Class
			
			private static String localizador; // Ultimo Localizador generado
			static {
				LocalizadorReserva.localizador = null; // Inicialización
			}
			
			private static int numeroReserva; //Número consecutivo de la reserva
			static {
				LocalizadorReserva.numeroReserva = 0; // Inicialización
			}
			
			//// Métodos de la Class
			
			private static String generaLocalizador() {
				
				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); //Obtenemos el año
				String sanyo = String.valueOf(anyo); //Transformamos año en String
				int mes = hoy.getMonthValue(); //Obtenemos el mes
				String smes = String.valueOf(mes); //Transformamos año en String
				String snumeroReserva = String.valueOf(++LocalizadorReserva.numeroReserva); // Número único consecutivo
				
				LocalizadorReserva.localizador = sanyo + "/" + smes + "/" + snumeroReserva; 
				//this.LocataReserva = LocalizadorReserva.localizador; // No puede acceder a elementos de su Class contenedora
																		// 	este es el motivo por el que hacemos un método
				return LocalizadorReserva.localizador; 		
			}
			
			// Los siguientes métodos no tiene visibilidad fuera de la Class Reserva
			// 		lo gestionamos de otra manera, creado métodos static de la Class Reserva
			/*
			private static int muestraNumeroReservas() { 			
				return LocalizadorReserva.numeroReserva; 
			}
			private static String muestraLocalizadorActual() {
				return LocalizadorReserva.localizador; 
			} 
			*/
			
		} // static class LocalizadorReserva
		
	
	//Constructor
	Reserva(String titular, String fecha) {
				
		this.LocataReserva = LocalizadorReserva.generaLocalizador(); 
		this.titular = titular; 
		this.fechaReserva = LocalDate.parse(fecha); 
	}
	
	//// Métodos static

	//Muestra número actual de reserva
	public static int muestraNumerodeReservas() {
		
		return LocalizadorReserva.numeroReserva; 
	}
	
	//Muestra localizador actual
	public static String muestraLocalizadorActual() {
		
		return LocalizadorReserva.localizador; 
	}
	
	//// Métodos públicos
	
	//Muestra la Reserva
	public void muestraReserva() {
		System.out.println("*********************************");
		System.out.println("Localizador : " + this.LocataReserva); 
		System.out.println("Titular : " + this.titular);
		System.out.println("Fecha Reserva : " + this.fechaReserva); 
	} 
	

} // class Reserva
