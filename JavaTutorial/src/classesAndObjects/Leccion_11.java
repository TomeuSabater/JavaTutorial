package classesAndObjects;

import java.time.LocalDate;

public class Leccion_11 {

	public static void main(String[] args) {

		// Introducción_VI a CLASES Y OBJETOS. 
		// Preparació para Nested Class; Inner Class / Static Class
		
		
		class LocalizadorReserva {
			
			// El Localizador de una Reserva está compuesto por:
			// YYYY/MM/Contador:
			// 	- YYYY: Año en curso
			// 	- MM: Mes en curso
			// 	- Contador: Número consecutivo incremental
			// Ejemplos: 2024/07/1, 2024/08/2, 2024/08/3, etc. 
			
			// Variables de la Class, Variables static
			
			private static String localizador; // Ultimo Localizador generado
			static {
				LocalizadorReserva.localizador = null; // Inicialización
			}
			
			private static int numeroReserva; //Número consecutivo de la reserva
			static {
				LocalizadorReserva.numeroReserva = 0; // Inicialización
			}
			
			// Métodos de la Class
			private static String generaLocalizador() {
				
				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); //Obtenemos el año
				String sanyo = String.valueOf(anyo); //Transformamos año en String
				int mes = hoy.getMonthValue(); //Obtenemos el mes
				String smes = String.valueOf(mes); //Transformamos año en String
				String snumeroReserva = String.valueOf(++LocalizadorReserva.numeroReserva); // Número único consecutivo
				
				LocalizadorReserva.localizador = sanyo + "/" + smes + "/" + snumeroReserva; 
				return LocalizadorReserva.localizador; 		
			}
			
			public static int muestraNumeroReservas() {
				
				return LocalizadorReserva.numeroReserva; 
			}
			
			public static String muestraLocalizadorActual() {
				
				return LocalizadorReserva.localizador; 
			}
				
		} // class LocalizadorReserva
		
		
		class Reserva {
			
			// Atributos de Instancia
			private String LocataReserva = null; //Localizador de cada reserva
			private String titular = null; //Titular de la reserva
			private LocalDate fechaReserva;  //Fecha de confirmación de la reserva
			
			//Constructor
			Reserva(String titular, String fecha) {
						
				this.LocataReserva = LocalizadorReserva.generaLocalizador(); // Nos proporciona un nuevo Localizador
				this.titular = titular; 
				this.fechaReserva = LocalDate.parse(fecha); 
			}
			
			//Métodos públicos
			public void muestraReserva() {
				
				System.out.println("Localizador : " + this.LocataReserva); 
				System.out.println("Titular : " + this.titular);
				System.out.println("Fecha Reserva :" +this.fechaReserva); 
			} 
			
		} //Class Reserva
				
		
		//Inicialmente, vamos a probar el generador de locatas
		
		//Comprobamos datos inicales
		System.out.println("Número actual de reservas es:" + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es :" + LocalizadorReserva.muestraLocalizadorActual()); 
	
		//Generamos dos Localizadores
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador()); 
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador()); 
				
		//Comprobamos los valores actuales
		System.out.println("Número de reservas es:" + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es :" + LocalizadorReserva.muestraLocalizadorActual()); 
		
		//Creamos una reserva
		Reserva r1 = new Reserva("Tomeu Sabater", "2024-04-09"); 
		r1.muestraReserva(); 
		
		//Observamos que la Class LocalizadorReserva solamente es utilizada en la Class Reserva y que podemos llamar al método generaLocalizador() sin problemas. 
		//Lo que proponemos es un Ejercicio en el que se anidará la Class LocalizadorReserva en la Class Reserva, 
		// 	de esta manera, ocultamos todos los métodos de la Class LocalizadoReserva y estructuramos mejor el código.
		//Ver la solución en la Leccion_12_Ejercicio			
				
	} // static void main

} // class Leccion_11
