package leccion_13_Ejercicio;

import java.time.LocalDate;

public class Reserva {
			
		//Variables estáticas y privadas, variables de la Clase, comunes para todas las instancias Reserva, ocultas fuera de la Clase
		private static int numeroReserva; //Número consecutivo de la reserva
		static {
			Reserva.numeroReserva = 0; // Inicialización
		}
		
		private static String localizador; // Ultimo Localizador generado
		static {
			Reserva.localizador = null; // Inicialización
		}
	
		// Atributos de Instancia, particulares para cada instancia de Reserva
		private String LocataReserva = null; //Localizador de cada reserva particular
		private String titular = null; //Titular de la reserva
		private LocalDate fechaReserva;  //Fecha de confirmación de la reserva
		
		//Constructor
		Reserva(String titular, String fecha) {
					
			this.LocataReserva = generaLocalizador(); 
			this.titular = titular; 
			this.fechaReserva = LocalDate.parse(fecha); 
			//this.LocataReserva = LocalizadorReserva.generaLocalizador(); //demostración del problema
		}
		
		//Métodos estáticos públicos, se pueden invocar fuera de la clase
		public static int muestraNumeroReservas() {
			
			return Reserva.numeroReserva; 
		}
		
		public static String muestraLocalizadorActual() {
			
			return Reserva.localizador; 
		}
				
		//Métodos privados, ocultos fuera de la clase 
		private String generaLocalizador() {
			
			LocalDate hoy = LocalDate.now(); // Fecha actual
			int anyo = hoy.getYear(); //Obtenemos el año
			String sanyo = String.valueOf(anyo); //Transformamos año en String
			int mes = hoy.getMonthValue(); //Obtenemos el mes
			String smes = String.valueOf(mes); //Transformamos año en String
			String snumeroReserva = String.valueOf(++Reserva.numeroReserva); // Número único consecutivo
			
			Reserva.localizador = sanyo + "/" + smes + "/" + snumeroReserva; 
			return Reserva.localizador; //Se retorna el valor		
		}
		
		
		//Métodos públicos
		public void muestraReserva() {
			System.out.println("*********************************");
			System.out.println("Localizador : " + this.LocataReserva); 
			System.out.println("Titular : " + this.titular);
			System.out.println("Fecha Reserva :" +this.fechaReserva); 
		} 

	} // class Reserva


