package Leccion_13_bis;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

	// Ctes de la Class
	private static final String ELEMENTO = "Reserva"; // Identifica el elemento
	private static final byte MAX_NUM_PAX = 3; // Número máximo de pasajeros
	private static final byte MIN_ADULT_YEARS = 18; // Fija edad mínima para Adultos
	private static final String PASAJERO = "Pasajero"; // Tipo pasajero
	private static final String TITULAR = "Pasajero Titular"; // Tipo pasajero

	// Atributos o variables de instancia
	private String LocataReserva = null; // Localizador de cada reserva
	private LocalDate fechaReserva;
	{
		this.fechaReserva = LocalDate.now(); // Fecha de creación de la reserva
	}
	private Pasajero[] pax = new Pasajero[Reserva.MAX_NUM_PAX]; // Primer pax es titular

	//// Static Nested Class

	private static class LocalizadorReserva {

		// LocalizadorReserva es una static nested Class de la Class Reserva

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

	private class Pasajero {

		//// Class para los Pax o Clientes de una reserva

		// Ctes de la Class
		private static final String ELEMENTO = "Pasajero"; // Identifica el elemento

		// Atributos o variables de instancia, variables de Obj Pasajero
		private String passport = null; // Pasaporte o DNI
		private String nombre = null; // Nombre de pila
		private String primerApellido = null; // Apellido1
		private String segundoApellido = null; // Apellido2
		private LocalDate fechaNacimiento; // Fecha nacimiento pax

		// Constructor único
		public Pasajero(String pPassport, String pNombre, String pApellido1, String pApellido2, String pFechaNac) {

			this.passport = pPassport;
			this.nombre = pNombre.toUpperCase();
			this.primerApellido = pApellido1.toUpperCase();
			if (pApellido2 != null)
				this.segundoApellido = pApellido2.toUpperCase();
			this.fechaNacimiento = LocalDate.parse(pFechaNac); // Se espera un formato yyyy-mm-dd
		}

		//// Métodos privados

		private boolean esAdulto() {
			// Determina si el pax es mayor de edad
			// 'true' si es mayor de edad en momento de la consulta

			long anyos = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
			return (anyos >= Reserva.MIN_ADULT_YEARS) ? true : false;
		}

		private void muestraPax(byte contador) {
			// Vuelca los datos del pax
			System.out.println(Pasajero.ELEMENTO);
			if (contador == 1) {
				System.out.println(Reserva.TITULAR);
			} else {
				System.out.println(Reserva.PASAJERO);
			}
			System.out.println("Passport cliente :" + this.passport);
			System.out.println("Cliente adulto :" + this.esAdulto());
			System.out.println("Nombre :" + this.nombre);
			System.out.println("Apellido1 : " + this.primerApellido);
			System.out.println("Apellido2 : " + this.segundoApellido);
			System.out.println("Fecha Nac : " + this.fechaNacimiento);
		}

	} // private class Pasajero

	//// Constructores

	// Constructor único
	Reserva(String c1_passport, String c1_nom, String c1_ap1, String c1_ap2, String c1_fechaNac, String c2_passport,
			String c2_nom, String c2_ap1, String c2_ap2, String c2_fechaNac, String c3_passport, String c3_nom,
			String c3_ap1, String c3_ap2, String c3_fechaNac) {

		// Inicialmente asignamos localizador
		this.LocataReserva = LocalizadorReserva.generaLocalizador(); // General locata

		// Asignamos los pax
		// Asignación los pax
		if (c1_passport != null) {
			pax[0] = new Pasajero(c1_passport, c1_nom, c1_ap1, c1_ap2, c1_fechaNac);
		} else
			pax[0] = null;
		if (c2_passport != null) {
			pax[1] = new Pasajero(c2_passport, c2_nom, c2_ap1, c2_ap2, c2_fechaNac);
		} else
			pax[1] = null;
		if (c3_passport != null) {
			pax[2] = new Pasajero(c3_passport, c3_nom, c3_ap1, c3_ap2, c3_fechaNac);
		} else
			pax[2] = null;

	} // Constructor

	//// Métodos public

	// Muestra la Reserva
	public void muestraReserva() {
		System.out.println("*********************************");
		System.out.println(Reserva.ELEMENTO);
		System.out.println("Localizador : " + this.LocataReserva);
		System.out.println("Fecha Reserva : " + this.fechaReserva);
		// Mostramos los pax
		this.muestraPax();
	}

	public boolean sonAdultos() {
		// 'true' si todos pax son adultos
		boolean resultado = true;
		for (Pasajero cliente : pax) {
			if (cliente != null) {
				if (!cliente.esAdulto()) {
					resultado = false;
					break; // No hace falta comprobar el resto
				}
			}
		}
		return resultado;
	}

	//// Metodos privados

	private void muestraPax() {
		// Muestra los Pax
		byte contador = 0;
		for (Pasajero cliente : pax) {
			if (cliente != null) {
				System.out.println("Pasajero " + ++contador);
				cliente.muestraPax(contador);
			}
		}
	} // muestraPax()

	//// Métodos static

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

}
// public class Reserva
