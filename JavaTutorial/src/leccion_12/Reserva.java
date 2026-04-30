package leccion_12;

import java.time.LocalDate;

public class Reserva {

	// Atributos o variables de instancia
	private String LocataReserva = null; // Localizador particular de cada reserva
	private String titular = null; // Titular de la reserva
	private LocalDate fechaReserva; // Fecha de confirmación de la reserva

	//// Static Nested Class

	// Class static con métodos y atributos static
	// Además de ser una Class Nested, es Static (realmente no tendrá constructor,
	// será como un "contenedor" de métodos)
	
	// As a member of the OuterClass, a nested class can be declared private,
	// public, protected, or package private.
	// Outer classes can only be declared public or package private.
	
	// Se define static porque no la vamos a instanciar, solo usaremos sus métodos
	// y además es una Class con variables y métodos comunes a cada Reserva, 
	// no deseamos genera un Obj LocalizadorReserva para cada Obj Reserva
	
	private static class LocalizadorReserva {

		// Localizador de una reserva está compuesto por
		// YYYY/MM/Contador. Ejemplo: 2024/07/1
		// YYYY: Año en curso
		// MM: Mes en curso
		// Contador: Número consecutivo incremental

		// Variables static de la Class

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

		//// Métodos de la Class

		private static String generaLocalizador() {

			LocalDate hoy = LocalDate.now(); // Fecha actual
			int anyo = hoy.getYear(); // Obtenemos el año
			String sanyo = String.valueOf(anyo); // Transformamos año en String
			int mes = hoy.getMonthValue(); // Obtenemos el mes
			String smes = String.valueOf(mes); // Transformamos año en String
			String snumeroReserva = String.valueOf(++LocalizadorReserva.numeroReserva); // Número único consecutivo

			LocalizadorReserva.localizador = sanyo + "/" + smes + "/" + snumeroReserva;
			// this.LocataReserva = LocalizadorReserva.localizador; // No puede acceder a
			// elementos de su Class contenedora porque no sabría a cual de las instancias
			// y este es el motivo por el que hacemos un método
			return LocalizadorReserva.localizador;
		}

		// Al ser una private static class los siguientes métodos no tiene visibilidad
		// fuera de la Class Reserva
		// por tanto, deberemos gestionarlo de alguna manera
		// se opta por ocultarlos y ofrecer esta información dede Class Reserva

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

	// Constructor
	Reserva(String titular, String fecha) {

		this.LocataReserva = LocalizadorReserva.generaLocalizador(); // General locata
		this.titular = titular.toUpperCase();
		this.fechaReserva = LocalDate.parse(fecha); // Se espera un formato "yyyy-mm-dd"
	}

	//// Métodos public y static
	//// Son necesarios porque el problema está en que necesitarías instanciar una
	//// reserva para saber el número de reservas, y necesitamos consultarlo sin
	//// crear una Reserva

	// Muestra número actual de reserva
	public static int muestraNumerodeReservas() {

		// return LocalizadorReserva.numeroReserva; //Es posible pero no elegante
		return LocalizadorReserva.muestraNumeroReservas();
	}

	// Muestra localizador actual
	public static String muestraLocalizadorActual() {

		// return LocalizadorReserva.localizador; //Es posible pero no elegante
		return LocalizadorReserva.muestraLocalizadorActual();
	}

	//// Métodos públicos

	// Muestra la Reserva
	public void muestraReserva() {
		System.out.println("*********************************");
		System.out.println("Localizador : " + this.LocataReserva);
		System.out.println("Titular : " + this.titular);
		System.out.println("Fecha Reserva : " + this.fechaReserva);
	}

} // class Reserva
