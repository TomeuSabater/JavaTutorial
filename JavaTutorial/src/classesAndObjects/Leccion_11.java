package classesAndObjects;

import java.time.LocalDate;

public class Leccion_11 {

	public static void main(String[] args) {

		// Introducción_VI a CLASES Y OBJETOS. 
		// Preparació para Nested Class; Inner Class / Static Nested Class
		
		
		// La Class LocalizadorReserva será un "contenedor" de variables y métodos static
		// 		esta Class no oferta constructor, su función es la de "agrupar" variables static y métodos de manipulación de estas variables
		class LocalizadorReserva {
			
			// El Localizador de una Reserva está compuesto por:
			// YYYY/MM/Contador:
			// 	- YYYY: Año en curso
			// 	- MM: Mes en curso
			// 	- Contador: Número consecutivo incremental
			// Ejemplos: 2024/07/1, 2024/08/2, 2024/08/3, etc. 
			
			//// Variables
			
			// Variables de la Class, Variables static
			
			private static String localizador; // Ultimo Localizador generado
			static {
				LocalizadorReserva.localizador = null; // Inicialización
			}
			
			private static int numeroReserva; //Número consecutivo de la reserva
			static {
				LocalizadorReserva.numeroReserva = 0; // Inicialización
			}
			
			//// Métodos de la Class
			
			// Métodos private
						
			private static String generaLocalizador() { // Construye un nuevo Localizador
				
				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); //Obtenemos el año
				String sanyo = String.valueOf(anyo); //Transformamos año en String
				int mes = hoy.getMonthValue(); //Obtenemos el mes
				String smes = String.valueOf(mes); //Transformamos año en String
				String snumeroReserva = String.valueOf(++LocalizadorReserva.numeroReserva); // Número único consecutivo
				
				LocalizadorReserva.localizador = sanyo + "/" + smes + "/" + snumeroReserva; 
				return LocalizadorReserva.localizador; 		
			}
						
			// Métodos public
			
			public static int muestraNumeroReservas() { // Muestra el número actual de reservas 
				
				return LocalizadorReserva.numeroReserva; 
			}
			
			public static String muestraLocalizadorActual() { // Muestra el localizador actual (último generado) 
				
				return LocalizadorReserva.localizador; 
			}
				
		} // class LocalizadorReserva
		
		
		class Reserva { // Simula una Reserva (o compra de un objeto/servicio)
			
			// Atributos o Variables de Instancia
			private String LocataReserva = null; //Localizador de cada reserva
			private String titular = null; //Titular de la reserva
			private LocalDate fechaReserva;  //Fecha de confirmación de la reserva
			
			//Constructor
			Reserva(String titular, String fecha) {
						
				this.LocataReserva = LocalizadorReserva.generaLocalizador(); // Nos proporciona un nuevo Localizador
				this.titular = titular; 
				this.fechaReserva = LocalDate.parse(fecha); // Se espera un formato "yyyy-mm-dd"
			}
			
			//Métodos públicos
			public void muestraReserva() { //Vuelca la reserva
				
				System.out.println("Localizador : " + this.LocataReserva); 
				System.out.println("Titular : " + this.titular);
				System.out.println("Fecha Reserva :" +this.fechaReserva); 
			} 
			
		} //Class Reserva
				
		
		//Inicialmente, vamos a probar los métodos static de la Class LocalizadorReserva
		
		//Comprobamos datos inicales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es :" + LocalizadorReserva.muestraLocalizadorActual()); 
	
		//Generamos algunos Localizadores
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador()); 
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador()); 
				
		//Comprobamos los valores actuales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es : " + LocalizadorReserva.muestraLocalizadorActual()); 
		
				
		//Creamos una reserva
		Reserva r1 = new Reserva("Tomeu Sabater", "2024-04-09"); 
		r1.muestraReserva(); 
		
		//Comprobamos los valores actuales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es : " + LocalizadorReserva.muestraLocalizadorActual()); 
				
		//Observamos que la Class LocalizadorReserva solamente es utilizada en la Class Reserva
		//		y también que podemos invocar al método generaLocalizador() líbremente sin necesidad de crear una nueva reserva. 
		//Lo que proponemos es un Ejercicio en el que se anidará la Class LocalizadorReserva dentro de la Class Reserva, 
		//		uno de los elementos de la Class Reserva, además de sus ctes, atributos, métodos, etc. será la Class LocalizadorReserva,
		// 		de esta manera, ocultamos la Class LocalizadoReserva (y todos sus elementos) al exterior de la Class Reserva y estructuramos mejor el código.
		
		//Ver la solución en la Leccion_12_Ejercicio		
				
	} // static void main

} // class Leccion_11
