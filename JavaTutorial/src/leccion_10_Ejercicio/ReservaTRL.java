package leccion_10_Ejercicio;

import java.time.LocalDate;

public class ReservaTRL extends Reserva {

	//// Ctes de la Class ReservaTRL

	private static final String ELEMENTO = "Reserva Traslado"; // Identifica el elemento
	private static final String TIPO_RESERVA = "TRL"; // Tipo de Reserva

	//// Atributos o Variables de la Clase

	private static int numReservaTrl; // Número consecutivo de reservas de tipo TRL
	static {
		ReservaTRL.numReservaTrl = 0; // Inicialización
	}

	//// Atributos o Variables de Instancia del Objeto ReservaHTL

	private String recogidaTrl = null; // Lugar de recogida
	private String destinoTrl = null; // Lugar de destino

	//// Métodos Static

	// Genera el número de reserva para la reserva de Traslado
	private static String generaNuevoNumeroReserva() {

		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); // Obtenemos el año
		String sanyo = String.valueOf(anyo); // Transformamos año en String
		String numeroTrl = String.valueOf(++ReservaTRL.numReservaTrl); // Número único consecutivo

		return (ReservaTRL.TIPO_RESERVA + "/" + sanyo + "/" + numeroTrl);

	} // generaNuevoNumeroReserva()

	// Devuelve el número actual de Reservas de Traslado
	// oferta la posibilidad de consultar este valor private static
	public static int numReservasTraslado() {

		return ReservaTRL.numReservaTrl;
	}

	//// Métodos Constructores

	// Método constructor único
	public ReservaTRL(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin,
			String direccion1, String direccion2, int neto) {

		// Llamamos al constructor de la Super Clase
		super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);

		// Asignamos valores particulares para ReservaHTL
		this.recogidaTrl = direccion1; // Origen
		this.destinoTrl = direccion2; // Destino

		// Asignamos número de reserva
		this.numeroParticularReserva = ReservaTRL.generaNuevoNumeroReserva();
	}

	// Métodos públicos

	// Mostrar Reserva
	public void muestraReserva() {

		super.muestraReserva(); // Llamamos al método de la Super Class
		System.out.println(ReservaTRL.ELEMENTO);
		System.out.println("Número de Reserva :" + this.numeroParticularReserva);
		System.out.println("Dirección : " + this.recogidaTrl);
		System.out.println("Tipo Habitación : " + this.destinoTrl);

	} // muestraReserva

} // public class ReservaTRL
