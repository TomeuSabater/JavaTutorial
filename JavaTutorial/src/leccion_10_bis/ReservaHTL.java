package leccion_10_bis;

import java.time.LocalDate;

// Class Reserva de HOTEL
public class ReservaHTL extends Reserva {

	//// Ctes de la Class ReservaHTL

	private static final String ELEMENTO = "Reserva Hotel"; // Identifica el elemento
	private static final String TIPO_RESERVA = "HTL"; // Tipo de Reserva

	//// Atributos o variables de la Class ReservaHTL

	private static int numReservaHtl; // Número consecutivo de reservas de tipo HTL
	static {
		ReservaHTL.numReservaHtl = 0; // Inicialización
	}

	//// Atributos o variables de instancia de los Obj ReservaHTL

	private String direccionHtl; // Dirección Postal del Hotel
	{
		this.direccionHtl = "Palma de Mallorca";
	}
	private char tipoHab = '\0'; // Tipo de Habitación: Simple, Doble, Triple

	//// Métodos Constructores

	// Método constructor único
	public ReservaHTL(String p1Passport, String p1Nom, String p1Ap1, String p1Ap2, String p1FechaNac, String p2Passport,
			String p2Nom, String c2_ap1, String c2_ap2, String c2_fechaNac, String c3_passport, String p3Nom,
			String c3_ap1, String c3_ap2, String c3_fechaNac, String c4_passport, String p4Nom, String c4_ap1,
			String c4_ap2, String c4_fechaNac, String fInicio, String fFin, String direccion, char tipoHabitacion,
			int precioNeto) {

		// Llamamos al constructor de la Super Class
		super(p1Passport, p1Nom, p1Ap1, p1Ap2, p1FechaNac, p2Passport, p2Nom, c2_ap1, c2_ap2, c2_fechaNac, c3_passport,
				p3Nom, c3_ap1, c3_ap2, c3_fechaNac, c4_passport, p4Nom, c4_ap1, c4_ap2, c4_fechaNac, fInicio, fFin,
				precioNeto);

		// Asignamos valores particulares para ReservaHTL
		this.direccionHtl = (direccion != null) ? direccion : this.direccionHtl;
		this.tipoHab = tipoHabitacion; // Podría ser un "enum"

		// Construimos el número de la reserva; Concatenación de Strings
		// Se ha iniciado su confección en la super Class reserva
		this.numeroParticularReserva = this.numeroParticularReserva + ReservaHTL.generaNuevoNumeroReserva();
	}

	// Métodos públicos

	public void muestraReserva() {
		// Mostrar datos de una Reserva

		System.out.println(ReservaHTL.ELEMENTO);
		super.muestraReserva(); // Llamamos al método de la Super Class
		System.out.println("Número de Reserva :" + this.numeroParticularReserva);
		System.out.println("Dirección : " + this.direccionHtl);
		System.out.println("Tipo Habitación : " + this.tipoHab);

	} // muestraReserva

	//// Métodos Static

	private static String generaNuevoNumeroReserva() {
		// Genera el número particular de reserva para las reserva de HTL
		// La generación del número de reserva de HTL es responsabilidad de la Class
		// ReservaHTL no de cada Obj ReservaHTL además, manipulará la variable estática
		// numReservaHtl, por todo ello, es un método static

		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); // Obtenemos el año
		String sanyo = String.valueOf(anyo); // Transformamos año en String
		String numeroHlt = String.valueOf(++ReservaHTL.numReservaHtl); // Número único consecutivo para el tipo de
																		// reserva

		return ("/" + ReservaHTL.TIPO_RESERVA + "/" + sanyo + "/" + numeroHlt);

	} // generaNuevoNumeroReserva()

	public static int numReservasHotel() {
		// Devuelve el número actual de Reservas de Hotel

		return ReservaHTL.numReservaHtl;
	}

} // class ReservaHTL
