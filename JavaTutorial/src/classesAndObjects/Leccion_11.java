package classesAndObjects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import leccion_10.Reserva;

public class Leccion_11 {

	public static void main(String[] args) {

		// Introducción_VI a CLASES Y OBJETOS.
		// Preparació para Nested Class; Inner Class / Static Nested Class

		// La Class LocalizadorReserva será un "contenedor" de variables y métodos
		// static
		// esta Class no oferta constructor, no buscamos su instanciación
		// (creación de Obj LocalizadorReserva) su función es la de "agrupar" variables
		// y métodos static

		// La Class Pax se encarga de gestionar los pasajeros de una reserva

		// Como primer paso, definir ambas Class con entidad propia externas
		// a la Class Reserva, posteriormente las incluiremos
		// como Nested Class de la Class Reserva

		class LocalizadorReserva {

			// El Localizador de una Reserva está compuesto por:
			// YYYY/MM/Contador:
			// - YYYY: Año en curso
			// - MM: Mes en curso
			// - Contador: Número consecutivo incremental
			// Ejemplos: 2026/04/1, 2026/04/2, 2026/04/3, etc.

			//// Variables

			// Variables de la Class, variables static

			static final String ELEMENTO = "LocalizadorReserva";

			private static int numeroReserva; // Número consecutivo de la reserva
												// necesito este dato para generar los Loc.
			static {
				// Inicialización
				LocalizadorReserva.numeroReserva = 0; // Inicialización
			}

			private static String lastLocator; // Ultimo Localizador generado
												// necesitamos este dato para saber
												// el localizador actual
			static {
				// Lo más probable sería su recuperación desde una DDBB
				// cada vez que se inicia la aplicación (servidor de aplicaciones)
				LocalizadorReserva.lastLocator = null; // Inicialización
			}

			//// Constructor
			// No existe, no es necesario

			//// Métodos de la Class LocalizadorReserva

			// Métodos private

			public static String generaLocalizador() {
				// Construye un nuevo Localizador
				// Se debería refinar; reseteando valores si es nuevo mes, año
				// si es para HTL, VUE, TRL, etc.

				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); // Obtenemos el año
				String sanyo = String.valueOf(anyo); // Transformamos año en String
				int mes = hoy.getMonthValue(); // Obtenemos el mes
				String smes = String.valueOf(mes); // Transformamos mes en String
				String snumeroReserva = String.valueOf(++LocalizadorReserva.numeroReserva); // Número único consecutivo

				LocalizadorReserva.lastLocator = sanyo + "/" + smes + "/" + snumeroReserva;
				return LocalizadorReserva.lastLocator;
			}

			// Métodos public

			public static int muestraNumeroReservas() {
				// Muestra el número actual de la static numeroReserva

				return LocalizadorReserva.numeroReserva;
			}

			public static String muestraLocalizadorActual() {
				// Muestra el localizador actual (último generado)

				return LocalizadorReserva.lastLocator;
			}

		} // class LocalizadorReserva

		class Pax {

			// Ctes (private static)
			private static final String ELEMENTO = "Pasajero"; // Identifica el elemento
			private static final byte MIN_ADULT_YEARS = 18; // Fija edad mínima para Adultos,
															// podría ser una Cte para cada país

			//// Atributos o variables de instancia, variables de Obj Pasajero

			private String passport = null; // Pasaporte o DNI

			private String nombre = null; // Nombre de pila
			private String apellido1 = null; // Apellido1
			private String apellido2 = null; // Apellido2

			private LocalDate fechaNacimiento; // Fecha nacimiento pax

			private boolean esTitular = false; // Indica si es el titular de la reserva

			//// Constructor único

			public Pax(String passport, String nombre, String apellido1, String apellido2, String fechaNacimiento,
					boolean estitular) {

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

			private boolean esAdulto() {
				// Determina si el Pax es mayor de edad
				// Si el pax es mayor de edad en este momento devuelve 'true'
				// Si no es mayor de edad en este momento devuelve 'false'

				long anyos = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
				return (anyos >= Pax.MIN_ADULT_YEARS) ? true : false;

				// En una sola instrucción no quedaría claro:
				// return (ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now()) >=
				// Cliente.ADULT) ? true : false;
			} // esAdulto()

		} // Class Pax

		// Probamos la Class LocalizadorReserva y la Class Pax

		class Reserva {
			// Simula una Reserva (o compra de un objeto/servicio)

			// Ctes
			private static final String ELEMENTO = "Reserva";
			private static final byte NUM_MAX_PAX = 4; // Numero máximo de clientes / pasajeros

			// Atributos o variables de instancia
			private String LocataReserva = null; // Localizador particular de cada reserva
			private LocalDate fechaReserva; // Fecha de creción de la reserva
			private Pax[] pasajeros = new Pax[Reserva.NUM_MAX_PAX]; // Pasajeros de la reserva
																	// es un array de objetos

			// Constructor único
			Reserva(String passport, String nombre, String apellido1, String apellido2, String fechaNacimiento,
					boolean titular) {

				// El localizador de la reserva se genera con un método static (gestiona
				// variables static), y no se requerirá instanciar la Class LocalizadorReserva
				LocataReserva = LocalizadorReserva.generaLocalizador();

				// Asignamos la fecha de la reserva a "ahora"
				fechaReserva = LocalDate.now(); // Asignamos momento actual

				// Asignamos los Pax (este ejemplo es teórico solo hay uno)
				pasajeros[0] = new Pax(passport, nombre, apellido1, apellido2, fechaNacimiento, titular);
			}

			// Métodos públicos
			public void muestraReserva() {
				// Vuelca la reserva

				System.out.println("Elemento : " + Reserva.ELEMENTO);
				System.out.println("Localizador : " + this.LocataReserva);
				System.out.println("Fecha Reserva :" + this.fechaReserva);
				pasajeros[0].muestraPax();
			}

		} // Class Reserva

		// Inicialmente, vamos a probar los métodos static
		// de la Class LocalizadorReserva, así se entienden mejor
		// Se observa que no es necesario instanciar la Class LocalizadorReserva
		// para invocar a sus métodos estáticos

		// Comprobamos datos inicales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es :" + LocalizadorReserva.muestraLocalizadorActual());

		// Generamos algunos Localizadores
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador());
		System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador());

		// Comprobamos los valores actuales
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es : " + LocalizadorReserva.muestraLocalizadorActual());

		// Creamos algunas reservas
		Reserva reserva1 = new Reserva("42.023.096-C", "Tomeu", "Sabater", null, "1966-03-18", true);
		reserva1.muestraReserva();

		Reserva reserva2 = new Reserva("44.965.695-V", "Pepito", "Pérez", null, "1965-05-27", false);
		reserva2.muestraReserva();

		// Comprobamos los valores actuales de las static
		System.out.println("Número actual de reservas es : " + LocalizadorReserva.muestraNumeroReservas());
		System.out.println("Localizador actual es : " + LocalizadorReserva.muestraLocalizadorActual());

		// Observamos que la Class LocalizadorReserva solamente es utilizada en la Class
		// Reserva, y que también que podemos invocar al método generaLocalizador()
		// líbremente sin necesidad de crear una nueva reserva.
		// Pero la Class LocalizadorReserva no tiene sentido sin la Class Reserva

		// Observar que la Class Pax solamente es utilizada en la Class Reserva
		// Tampoco tendría mucho sentido fuera de la reserva ya que un cliente o
		// pasajeros siempre estará asociado a una reserva/venta

		// Lo que proponemos es, a continuación, un Ejercicio en el que se anidarán la
		// Class LocalizadorReserva y la Class Pax dentro de la Class Reserva, como
		// 'elementos' de la Class Reserva, además de sus otras ctes, atributos,
		// métodos, etc. serán Nested Class (Clases anidadas)
		// De esta manera, 'ocultamos' estas Class y todos sus elementos
		// al exterior de la Class Reserva.
		// Este anidamiento pretende la 'ocultación' o encapsulación de estas Class y
		// una mejor estructuració de todo el código.

		// Por otra parte, veremos que no nos interesa llamar a métodos de la Class Pax
		// sin la existencia de la Class Reserva que la contiene.
		// No obstante, sí que nos puede interesar llamara a métodos de la Class
		// LocalizadorReserva, por ejemplo, saber el número de localizador actual sin
		// tener que instanciar la Class Reserva.
		// Para permitir esto último, la diferencia será que:
		// - la Class Pax será una NESTED CLASS a secas, conocidas como 'INNER CLASS'
		// - la Class LocalizadorReserva será un 'STATIC NESTED CLASS'

		// Ver la solución en la Leccion_12_Ejercicio
		// Antes, revisar NestedClasses.java para un ejemplo clarificador de la
		// diferencia entre las Inner Class y Static Nested Class

	} // static void main

} // class Leccion_11 -> pasar a NestedClasses.java y Leccion_12.java
