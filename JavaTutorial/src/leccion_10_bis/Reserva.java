package leccion_10_bis;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

	//// Ctes de la Super Class Reserva

	private static final String ELEMENTO = "Reserva"; // Identifica el elemento
	private static final byte MAX_NUM_PAX = 4; // Numero máximo de pasajeros
	private static final byte TAX_IVA = 21; // Impuestos aplicados

	//// Atributos o variables de la Class Reserva

	// Número consecutivo de Reservas TOTALES
	private static int numReserva; // private para eliminar su visibilidad
	static {
		Reserva.numReserva = 0; // Inicialización
	}

	//// Atributos o variables de instancia, variables de cada Obj Reserva

	// Localizador de la Reserva (Código único para cada reserva)
	// Todas las Reservas tendrán este dato, por tanto, lo definimos en la Super
	// Class Reserva
	protected String numeroParticularReserva = null; // Se comienza a rellenar en la Super Class y se finaliza en cada
														// Sub Class este es el motivo por el cual es protected y no
														// private
	// Conjunto de pax de la reserva, conjunto de pasajeros
	private Pax[] pasajeros = new Pax[Reserva.MAX_NUM_PAX];

	// Fechas Inicio/Llegada, Fin/Salida
	private LocalDate fechaInicio; // Inicio o Llegada, se podría inicializar con LocalDate.now();
	private LocalDate fechaFin; // Fin o Salida, se podría inicializar con LocalDate.now();

	// Precio
	private int precioNeto = 0; // Precio sin impuestos
	private int precioBruto = 0; // Precio con impuestos
	
	//// Begin Nested Class
	
	private class Pax {
		
		// Ctes (private static) 
		private static final String ELEMENTO = "Pasajero"; // Identifica el elemento
		private static final byte MIN_ADULT_YEARS = 18; // Fija edad mínima para Adultos, podría ser una Cte para cada país
				
		//// Atributos o variables de instancia, variables de Obj Pasajero

		private String passport = null; // Pasaporte o DNI

		private String nombre = null; // Nombre de pila
		private String apellido1 = null; // Apellido1
		private String apellido2 = null; // Apellido2

		private LocalDate fechaNacimiento; // Fecha nacimiento pax
		
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
			System.out.println("Nombre :" + this.nombre);
			System.out.println("Apellido1 : " + this.apellido1);
			System.out.println("Apellido2 : " + this.apellido2);
		}
		
		//// Métodos privados

		// Determina si el pax es mayor de edad
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
	
	//// End Nested Class
	
	//// Constructores

	// Constructor único

	public Reserva(String c1_passport, String c1_nom, String c1_ap1, String c1_ap2, String c1_fechaNac,
			String c2_passport, String c2_nom, String c2_ap1, String c2_ap2, String c2_fechaNac, String c3_passport,
			String c3_nom, String c3_ap1, String c3_ap2, String c3_fechaNac, String c4_passport, String c4_nom,
			String c4_ap1, String c4_ap2, String c4_fechaNac, String fInicio, String fFin, int neto) {

		// Comienza la creación del número particular de la reserva
		// y actualizamos Reserva.numReserva para la siguiente
		this.numeroParticularReserva = String.valueOf(++Reserva.numReserva);
		
		// Asignación los pax
		if (c1_passport != null) {
			pasajeros[0] = new Pax(c1_passport, c1_nom, c1_ap1.toUpperCase(), c1_ap2, c1_fechaNac);
		} else
			pasajeros[0] = null;
		if (c2_passport != null) {
			pasajeros[1] = new Pax(c2_passport, c2_nom, c2_ap1.toUpperCase(), c2_ap2, c2_fechaNac);
		} else
			pasajeros[1] = null;
		if (c3_passport != null) {
			pasajeros[2] = new Pax(c3_passport, c3_nom, c3_ap1.toUpperCase(), c3_ap2, c3_fechaNac);
		} else
			pasajeros[2] = null;
		if (c4_passport != null) {
			pasajeros[3] = new Pax(c4_passport, c4_nom, c4_ap1.toUpperCase(), c4_ap2, c4_fechaNac);
		} else
			pasajeros[3] = null;
	
		// Fechas Inicio y Fin
		this.fechaInicio = LocalDate.parse(fInicio); // Se espera un formato yyyy-mm-dd
		this.fechaFin = LocalDate.parse(fFin); // Se espera un formato yyyy-mm-dd

		// Precios
		this.precioNeto = neto;
		this.precioBruto = this.calculaBruto(this.precioNeto);
	}

	//// Métodos Públicos

	public void muestraFechasReserva() {
		// Muestra las Fechas Inicio/Entrada Fin/Salida

		System.out.println("Fecha Inicio : " + this.fechaInicio);
		System.out.println("Fecha Fin :" + this.fechaFin);
	}

	public void muestraPax() {
		// Muestra los Pax

		byte contador = 0;
		for (Pax cliente : pasajeros) {
			if (cliente != null) {
				System.out.println("Pasajero " + ++contador);
				cliente.muestraPax();
			}
		}
	}

	public void muestraReserva() {
		// Mostrar Reserva

		System.out.println(Reserva.ELEMENTO);
		muestraPax();
		muestraFechasReserva();
		System.out.println("Precio Neto : " + this.precioNeto);
		System.out.println("Precio Bruto: " + this.precioBruto);
	}

	//// Metodos Privados

	private int calculaBruto(int neto) {
		// Calcula Precio Bruto

		return (neto + ((neto * Reserva.TAX_IVA) / 100));
	}

	//// Métodos Static públicos 

	// Gestiona una static, por tanto es un método static
	public static int numReservas() {
		// Devuelve el número actual de Reservas Totales

		return Reserva.numReserva;
	}

} // public class Reserva
