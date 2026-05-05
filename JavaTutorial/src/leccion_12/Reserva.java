package leccion_12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

	// Static & CTES
	private static final String ELEMENTO = "Reserva";
	private static final byte NUM_MAX_PAX = 4; // Numero máximo de clientes / pasajeros
		
	// Atributos o variables de instancia
	private String LocataReserva = null; // Localizador particular de cada reserva
	private LocalDate fechaReserva; // Fecha de confirmación de la reserva

	private Pax[] pasajeros = new Pax[Reserva.NUM_MAX_PAX]; // Pasajeros de la reserva
															// es un array de objetos
	
	//// Static Nested Class

	// Static Class con métodos y atributos de tipo static
	// Además de ser una Nested Class, es una Static Nested Class 
	// No tendrá constructor, no es la intención, será como un "contenedor" de métodos
	// Realmente necesitaremos los métodos que oferte, 
	//	pero no necesitaremos instanciar la Class para generar un Obj; no habrá constructor
	
	// Se define static porque no la vamos a instanciar, solo usaremos sus métodos
	// y además es una Class con variables y métodos comunes a cada Reserva, 
	// no deseamos genera un Obj LocalizadorReserva para cada Obj Reserva
		
	// As a member of the OuterClass, a Nested Class can be declared private,
	// public, protected, or package private.
	// Outer classes can only be declared public or package private.
	
	
	private static class LocalizadorReserva {

		// Localizador de una reserva está compuesto por
		// YYYY/MM/Contador. Ejemplo: 2024/07/1
		// YYYY: Año en curso
		// MM: Mes en curso
		// Contador: Número consecutivo incremental

		// Variables static de la Static Nested Class

		private static String localizador; // Ultimo Localizador generado
		static {
			// Normalmente inicializado desde una DDBB cuando arranca el programa
			LocalizadorReserva.localizador = null; // Inicialización
		}

		private static int numeroReserva; // Número consecutivo de la reserva
		static {
			// Normalmente inicializado desde una DDBB cuando arranca el programa
			LocalizadorReserva.numeroReserva = 0; // Inicialización
		}

		//// Métodos de la Static Nested Class
		/// Y los vamos a definir privados, por tanto,
		/// solo accesibles desde la Class contenedora

		private static String generaLocalizador() {
			// Algoritmo de generación de un nuevo Localizador
			// puede ser tan complicado como se desee. 
			// Es privado, inalcanzable fuera de la Class contenedora
			// Entonces NO es posible generar localizadores alocadamente
			// solamente se generarían 'dentro' de una Obj Reserva

			LocalDate hoy = LocalDate.now(); // Fecha actual
			int anyo = hoy.getYear(); // Obtenemos el año
			String sanyo = String.valueOf(anyo); // Transformamos año en String
			int mes = hoy.getMonthValue(); // Obtenemos el mes
			String smes = String.valueOf(mes); // Transformamos año en String
			String snumeroReserva = String.valueOf(++LocalizadorReserva.numeroReserva); // Número único consecutivo

			LocalizadorReserva.localizador = sanyo + "/" + smes + "/" + snumeroReserva;
			// this.LocataReserva = LocalizadorReserva.localizador; // No puede acceder a
			// elementos de su Class contenedora porque no sabría a cual de las instancias
			// existentes de la contenedora nos referimos. 
			// Y este es el motivo por el que hacemos este método al que accederemos
			// desde la Class contenedora
			return LocalizadorReserva.localizador;
		}

		// Al ser una private static class los siguientes métodos no tiene visibilidad
		// fuera de la Class Reserva, por tanto, deberemos gestionarlo de alguna manera
		// se opta por ocultarlos y ofrecer esta información dese Class Reserva

		// Métodos, los calificamos de private, no se permite su acceso fuera de la
		// Class Reserva

		private static int muestraNumeroReservas() {
			// Muestra el número actual de reservas

			return LocalizadorReserva.numeroReserva;
		}

		private static String muestraLocalizadorActual() {
			// Muestra el localizador actual (último generado)

			return LocalizadorReserva.localizador;
		}

	} // static class LocalizadorReserva
	
	
	//// Inner Class
	
	// Non-Static Nested Class o mayormente conocida como Inner Class
	// La gestión de pasajeros de la reserva es suficientemente complejo
	// para definir que lo sea mediante una Class
	// La definimos private porque no nos interesa que fuera de la Class Reserva
	// o clase contenedora, exista el concepto de Pax
	
	 private class Pax {

		// Static & Ctes 
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

		//// Métodos privados solamente accesibles desde la Class Reserva

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
				
		private void muestraPax() {
			// Vuelca los datos del pax

			System.out.println(Pax.ELEMENTO);
			System.out.println("Passport cliente :" + this.passport);
			System.out.println("Cliente adulto :" + this.esAdulto());
			System.out.println("Es titular :" + this.esTitular);
			System.out.println("Nombre :" + this.nombre);
			System.out.println("Apellido1 : " + this.apellido1);
			System.out.println("Apellido2 : " + this.apellido2);
		}

	} // Class Pax
	
		
	// Constructor de la Class Reserva
	Reserva(String passport, String nombre, String apellido1, String apellido2, String fechaNacimiento, String fechaReserva) {

		// Inicialmente generamos y asignamos el localizador y la fecha de la reserva
		this.LocataReserva = LocalizadorReserva.generaLocalizador(); // General locata
																		// No ha sido necesario instanciar
																		// la Class LocalizadorReserva
																		// porque es una Static Nested Class
		this.fechaReserva = LocalDate.parse(fechaReserva); // Se espera un formato "yyyy-mm-dd"
		
		// Posteriomente gestionamos los pasajeros 
		pasajeros[0] = new Pax(passport, nombre, apellido1, apellido2, fechaNacimiento, true);
	}

	//// Métodos 'public static' de la Class Reserva
	//// Son necesarios porque el problema está en que necesitarías instanciar una
	//// reserva para saber el número de reservas, y necesitamos consultarlo sin
	//// crear una Reserva, entonces definimos métodos static en Class Reserva
	//// que a la vez llamarán a los 'private static' de la Static Nested Class
	/// 
	//// Realmente no es necesario hacerlo tan complicado, 
	//// se opta por esa solución como ejemplo de las 
	//// Static Nested que ofertan métodos private static  

	// Muestra número actual de reserva
	// recordar que el método de la Static Nested Class se ha definido
	// como privado. 
	public static int muestraNumerodeReservas() {

		// return LocalizadorReserva.numeroReserva; //Es posible pero no elegante
		return LocalizadorReserva.muestraNumeroReservas(); // Mejor mediante un método privado
	}

	// Muestra localizador actual
	public static String muestraLocalizadorActual() {

		// return LocalizadorReserva.localizador; //Es posible pero no elegante
		return LocalizadorReserva.muestraLocalizadorActual(); // Mejor mediante un método privado
	}

	//// Métodos públicos

	// Muestra la Reserva
	public void muestraReserva() {
		System.out.println("*********************************");
		System.out.println(Reserva.ELEMENTO); 
		System.out.println("Localizador : " + this.LocataReserva);
		System.out.println("Fecha Reserva : " + this.fechaReserva);
		pasajeros[0].muestraPax();
	}

} // class Reserva
