package classesAndObjects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import leccion_10.Reserva;

public class Leccion_11 {

	public static void main(String[] args) {

		// Introducción_VI a CLASES Y OBJETOS.
		// Preparació para Nested Class; Inner Class / Static Nested Class

		// La Class LocalizadorReserva será un "contenedor" de variables y métodos
		// static esta Class no oferta constructor, no buscamos su instanciación
		// (creación de Obj LocalizadorReserva) su función es la de "agrupar" variables
		// y métodos static
				
		class LocalizadorReserva {

			// El Localizador de una Reserva está compuesto por:
			// YYYY/MM/Contador:
			// - YYYY: Año en curso
			// - MM: Mes en curso
			// - Contador: Número consecutivo incremental
			// Ejemplos: 2026/04/1, 2026/04/2, 2026/04/3, etc.

			//// Variables

			// Variables de la Class, variables static
			
			private static int numeroReserva; // Número consecutivo de la reserva
											// necesito este dato para generar los Loc.
			static {
				// Inicialización
				LocalizadorReserva.numeroReserva = 0; // Inicialización
			}
			
			private static String localizador; // Ultimo Localizador generado
												// necesito este dato para saber qué Loc.
			static {
				// Lo más probable sería su recuperación desde una DDBB
				// cada vez que se inicia la aplicación (servidor de aplicaciones) 
				LocalizadorReserva.localizador = null; // Inicialización
			}

			//// Métodos de la Class LocalizadorReserva

			// Métodos private

			private static String generaLocalizador() {
				// Construye un nuevo Localizador
				// Se debería refinar reseteando valores si es nuevo mes o año

				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); // Obtenemos el año
				String sanyo = String.valueOf(anyo); // Transformamos año en String
				int mes = hoy.getMonthValue(); // Obtenemos el mes
				String smes = String.valueOf(mes); // Transformamos mes en String
				String snumeroReserva = String.valueOf(++LocalizadorReserva.numeroReserva); // Número único consecutivo

				LocalizadorReserva.localizador = sanyo + "/" + smes + "/" + snumeroReserva;
				return LocalizadorReserva.localizador;
			}

			// Métodos public

			public static int muestraNumeroReservas() {
				// Muestra el número actual de reservas

				return LocalizadorReserva.numeroReserva;
			}

			public static String muestraLocalizadorActual() {
				// Muestra el localizador actual (último generado)

				return LocalizadorReserva.localizador;
			}

		} // class LocalizadorReserva

		
		class Pax {
			
			// Ctes (private static) 
			private static final String ELEMENTO = "Pasajero"; // Identifica el elemento
			private static final byte MIN_ADULT_YEARS = 18; // Fija edad mínima para Adultos, podría ser una Cte para cada país
					
			//// Atributos o variables de instancia, variables de Obj Pasajero

			private String passport = null; // Pasaporte o DNI

			private String nombre = null; // Nombre de pila
			private String apellido1 = null; // Apellido1
			private String apellido2 = null; // Apellido2

			private LocalDate fechaNacimiento; // Fecha nacimiento pax
			
			private boolean esTitular = false; // Indica si es el titular de la reserva
			
			//// Constructor único

			public Pax(String passport, String nombre, String apellido1, String apellido2, String fechaNacimiento) {

				this.passport = passport;
				this.nombre = nombre.toUpperCase();
				this.apellido1 = apellido1.toUpperCase();
				this.apellido2 = (apellido2 != null) ? apellido2.toUpperCase() : null;

				this.fechaNacimiento = LocalDate.parse(fechaNacimiento); // Se espera un formato yyyy-mm-dd

			} // Constructor
			
			//// Métodos públicos

			public void muestraPax() {
				// Vuelca los datos del pax
				System.out.println(Pax.ELEMENTO);
				System.out.println("Passport cliente :" + this.passport);
				System.out.println("Cliente adulto :" + this.esAdulto());
				System.out.println("Es titular :" + this.esTitular); 
				System.out.println("Nombre :" + this.nombre);
				System.out.println("Apellido1 : " + this.apellido1);
				System.out.println("Apellido2 : " + this.apellido2);
			}
			
			//// Métodos privados

			// Determina si el Pax es mayor de edad
			private boolean esAdulto() {
				// Si el pax es mayor de edad en el momento consulta devuelve 'true'
				// Si no es mayor de edad en el momento de la consulta devuelve 'false'

				long anyos = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
				return (anyos >= Pax.MIN_ADULT_YEARS) ? true : false;

				// En una sola instrucción no quedaría claro:
				// return (ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now()) >=
				// Cliente.ADULT) ? true : false;
			} // esAdulto()
			
		} // Class Pax 
					
		
		// Probamos la Class LocalizadorReserva
		class Reserva {
			// Simula una Reserva (o compra de un objeto/servicio)

			// Ctes
			private static final byte NUM_MAX_PAX = 4; 
			
			// Atributos o variables de instancia
			private String LocataReserva = null; // Localizador de cada reserva
			private String titular = null; // Titular de la reserva
			private LocalDate fechaReserva; // Fecha de confirmación de la reserva

			private Pax[] pasajeros = new Pax[Reserva.NUM_MAX_PAX];
			
			// Constructor
			Reserva(String titular, String fecha) {
				// El Locata se genera con el método static

				this.LocataReserva = LocalizadorReserva.generaLocalizador(); // Nos proporciona un nuevo Localizador
				this.titular = titular.toUpperCase();
				this.fechaReserva = LocalDate.parse(fecha); // Se espera un formato "yyyy-mm-dd"
			}

			// Métodos públicos
			public void muestraReserva() { // Vuelca la reserva

				System.out.println("Localizador : " + this.LocataReserva);
				System.out.println("Titular : " + this.titular);
				System.out.println("Fecha Reserva :" + this.fechaReserva);
			}

		} // Class Reserva

		
		// Inicialmente, vamos a probar los métodos static 
		// de la Class LocalizadorReserva

		
		// Comprobamos datos inicales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es :" + LocalizadorReserva.muestraLocalizadorActual());

		// Generamos algunos Localizadores
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador());
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador());

		// Comprobamos los valores actuales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es : " + LocalizadorReserva.muestraLocalizadorActual());

		// Creamos una reserva
		Reserva reserva1 = new Reserva("Tomeu Sabater", "2026-04-09");
		reserva1.muestraReserva();

		// Comprobamos los valores actuales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es : " + LocalizadorReserva.muestraLocalizadorActual());

		// Observamos que la Class LocalizadorReserva solamente es utilizada en la Class
		// Reserva, y también que podemos invocar al método generaLocalizador()
		// líbremente sin necesidad de crear una nueva reserva.
		// La Class LocalizadorReserva no tiene sentido sin la Class Reserva

		// Lo que proponemos es un Ejercicio en el que se anidará la
		// Class LocalizadorReserva dentro de la Class Reserva,
		// uno de los elementos de la Class Reserva, además de sus ctes, atributos,
		// métodos, etc. será la Class LocalizadorReserva, de esta manera, ocultamos la
		// Class LocalizadoReserva (y todos sus elementos)
		// al exterior de la Class Reserva y estructuramos mejor el código.
		// Por otra parte, será imposible invocar los métodos de la Class
		// LocalizadorReserva fuera de la Class Reserva, simplemente no serán visibles
		// No obstante, es posible que necesitemos invocar algunos, como saber el último
		// número de localizador generado (y será necesario instanciar la reserva) 


		// Ver la solución en la Leccion_12_Ejercicio

	} // static void main

} // class Leccion_11 -> pasar a Leccion_12.java
