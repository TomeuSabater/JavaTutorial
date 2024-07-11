package Leccion_12_Ejercicio_bis_bis;

import java.time.LocalDate;

//Class Reserva contiene dos Nested Class
//- LocalizadorReservaStatic: Es una Static Nested Class
//- LocalizadorReservaInner: Es una Inner Class

//Localizador de una reserva está compuesto por
//	- YYYY/MM/Contador. Ejemplo: 2024/07/1
//	- YYYY: Año en curso
//	- MM: Mes en curso
//	- Contador: Número consecutivo incremental

public class Reserva {
	
	// Atributos de Instancia

	private String LocataReserva = null; // Segundo Localizador de cada reserva 
	private String titular = null; //Titular de la reserva
	private LocalDate fechaReserva;  //Fecha de confirmación de la reserva
	
	// Atributos de la Class
	private static String Localizador; // Ultimo Localizador Generado
	static {
		Reserva.Localizador = null; // Inicialización
	}
	
	private static int numeroReserva; // Número Consecutivo de Reserva
	static {
		Reserva.numeroReserva = 0; // Inicialización
	}
		
		//// Private Nested Class (Inner Class) 
				
		private class LocalizadorReserva {
					
			// Atributos de la Class
			private LocalDate hoy; // Contiene fecha de hoy
			private int anyo; // Contiene el año en curso
			private int mes; // Contiene mes en curso
						
			//// Constructor
			
			LocalizadorReserva() {
				
				this.hoy = LocalDate.now(); // Fecha actual
				this.anyo = hoy.getYear(); // Año en curso
				this.mes = hoy.getMonthValue(); // Obtenemos mes en curso
			}
						
			//// Métodos de la Class
			
			private String generaLocalizador() {
				
				String sanyo; // Contiene el año en String
				String smes; // Contiene el mes en String
				String snumeroReserva; // Contiene número reserva en string
				
				sanyo = String.valueOf(this.anyo); // Transformamos año en String
				smes = String.valueOf(this.mes); // Transformamos año en String
				snumeroReserva = String.valueOf(++Reserva.numeroReserva); // Numero único consecutivo
				
				Reserva.Localizador = sanyo + "/" + smes + "/" + snumeroReserva; 
				return Reserva.Localizador;  
			}
			
		} // private class LocalizadorReservaInner
	
	//// Constructor
		
	Reserva(String titular, String fecha) {
		
		LocalizadorReserva lr = new LocalizadorReserva(); // Instanciamos la Inner Class
		this.LocataReserva = lr.generaLocalizador(); // Generamos el Locata
		
		this.titular = titular; 
		this.fechaReserva = LocalDate.parse(fecha); 
	}
	
	//// Métodos static

	//Muestra número actual de reserva
	public static int muestraNumerodeReserva() {
		
		return Reserva.numeroReserva; 
	}
	
	//Muestra localizador actual
	public static String muestraLocalizador() {
		
		return 	Reserva.Localizador; 
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