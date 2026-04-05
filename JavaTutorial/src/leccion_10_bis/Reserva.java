package leccion_10_bis;

import java.time.LocalDate;

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
	private Pasajero[] pax = new Pasajero[Reserva.MAX_NUM_PAX];

	// Fechas Inicio/Llegada, Fin/Salida
	private LocalDate fechaInicio; // Inicio o Llegada, se podría inicializar con LocalDate.now();
	private LocalDate fechaFin; // Fin o Salida, se podría inicializar con LocalDate.now();

	// Precio
	private int precioNeto = 0; // Precio sin impuestos
	private int precioBruto = 0; // Precio con impuestos

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
			pax[0] = new Pasajero(c1_passport, c1_nom, c1_ap1, c1_ap2, c1_fechaNac);
		} else
			pax[0] = null;
		if (c2_passport != null) {
			pax[1] = new Pasajero(c2_passport, c2_nom, c2_ap1, c2_ap2, c2_fechaNac);
		} else
			pax[1] = null;
		if (c3_passport != null) {
			pax[3] = new Pasajero(c3_passport, c3_nom, c3_ap1, c3_ap2, c3_fechaNac);
		} else
			pax[2] = null;
		if (c4_passport != null) {
			pax[4] = new Pasajero(c4_passport, c4_nom, c4_ap1, c4_ap2, c4_fechaNac);
		} else
			pax[3] = null;

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
		for (Pasajero cliente : pax) {
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

	//// Métodos Static

	// Gestiona una static, por tanto es un método static
	public static int numReservas() {
		// Devuelve el número actual de Reservas Totales

		return Reserva.numReserva;
	}

} // public class Reserva
