package leccion_10_Ejercicio_bis;

import java.time.LocalDate;

//Class Reserva de TRASLADO
public class ReservaTRL extends Reserva {

	//// Ctes de la Class ReservaTRL

	private static final String ELEMENTO = "Reserva Traslado"; // Identifica el elemento
	private static final String TIPO_RESERVA = "TRL"; // Tipo de Reserva

	//// Atributos o variables de la Class

	private static int numReservaTrl; // Número consecutivo de reservas de tipo TRL
	static {
		ReservaTRL.numReservaTrl = 0; // Inicialización
	}

	//// Atributos o variables de instancia de los Obj ReservaTRL

	private String recogidaTrl = null; // Lugar de recogida
	private String destinoTrl = null; // Lugar de destino

	//// Métodos Constructores

	// Método constructor único
	public ReservaTRL(String c1_passport, String c1_nom1, String c1_ap1, String c1_ap2, String c1_fechaNac,
			String c2_passport, String c2_nom, String c2_ap1, String c2_ap2, String c2_fechaNac, String c3_passport,
			String c3_nom, String c3_ap1, String c3_ap2, String c3_fechaNac, String c4_passport, String c4_nom,
			String c4_ap1, String c4_ap2, String c4_fechaNac, String fInicio, String fFin, String direccion1,
			String direccion2, int neto) {

		// Llamamos al constructor de la Super Clase
		super(c1_passport, c1_nom1, c1_ap1, c1_ap2, c1_fechaNac, c2_passport, c2_nom, c2_ap1, c2_ap2, c2_fechaNac,
				c3_passport, c3_nom, c3_ap1, c3_ap2, c3_fechaNac, c4_passport, c4_nom, c4_ap1, c4_ap2, c4_fechaNac,
				fInicio, fFin, neto);

		// Asignamos valores particulares para ReservaHTL
		this.recogidaTrl = direccion1; // Origen
		this.destinoTrl = direccion2; // Destino

		// Asignamos número de reserva
		this.numeroParticularReserva = this.numeroParticularReserva + ReservaTRL.generaNuevoNumeroReserva();
	}

	//// Métodos públicos

	public void muestraReserva() {
		// Mostrar Reserva

		super.muestraReserva(); // Llamamos al método de la Super Class
		System.out.println(ReservaTRL.ELEMENTO);
		System.out.println("Número de Reserva :" + this.numeroParticularReserva);
		System.out.println("Dirección : " + this.recogidaTrl);
		System.out.println("Tipo Habitación : " + this.destinoTrl);

	} // muestraReserva

	//// Métodos Static

	public static int numReservasTraslado() {
		// Devuelve el número actual de Reservas de Traslado

		return ReservaTRL.numReservaTrl;
	}

	private static String generaNuevoNumeroReserva() {
		// Genera el número de reserva para la reserva de traslado
		// Obviamente es una static que no toca variables de instancia

		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); // Obtenemos el año
		String sanyo = String.valueOf(anyo); // Transformamos año en String
		String numeroTrl = String.valueOf(++ReservaTRL.numReservaTrl); // Número único consecutivo para el tipo de
																		// reserva

		return ("/" + ReservaTRL.TIPO_RESERVA + "/" + sanyo + "/" + numeroTrl);
	} // generaNuevoNumeroReserva()

} // public class ReservaTRL
