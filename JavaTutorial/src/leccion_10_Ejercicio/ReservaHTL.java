package leccion_10_Ejercicio;

import java.time.LocalDate;

public class ReservaHTL extends Reserva {

	//// Ctes de la Class ReservaHTL

	private static final String ELEMENTO = "Reserva Hotel"; // Identifica el elemento
	private static final String TIPO_RESERVA = "HTL"; // Tipo de Reserva

	//// Atributos o Variables de la Class ReservaHTL

	// La variable que almacena el número consecutivo de reservas
	// y que se usará para construir el número único de cada reserva
	// será una private static; inaccesible desde exterior y común a todos Obj.
	private static int numReservaHtl; // Número consecutivo de reservas de tipo HTL
	static {
		// Este bloque de código de inicialización de variable static podría ser
		// complejo
		// También podría ser substituido por un método static,
		// la ventaja de inicializar static mediante método static es que se puede
		// rellamar; reinicializar
		// En este ejemplo, nos limitamos a bloque de código
		ReservaHTL.numReservaHtl = 0; // Inicialización (En entorno real podría leer de la DDBB)
	}

	//// Atributos o Variables de Instancia del Obj ReservaHTL

	private String direccionHtl;
	{
		direccionHtl = "Palma de Mallorca"; // Dirección x defecto
	}
	private char tipoHab = '\0'; // Tipo de Habitación: Simple, Doble, Triple

	//// Métodos Static

	// Genera el número particular de reserva para las reserva de HTL
	// La generación del número de reserva de HTL es responsabilidad de la Class
	// ReservaHTL no de cada Obj ReservaHTL además, manipulará la variable estática
	// numReservaHtl, por todo ello, es un
	// método static también es private; inaccesible externamente -> la static queda
	// protegida de manipulaciones externas
	private static String generaNuevoNumeroReserva() {

		// Observar cómo se evita el acceso a variables de instancia
		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); // Obtenemos el año
		String sanyo = String.valueOf(anyo); // Transformamos año en String
		String numeroHlt = String.valueOf(++ReservaHTL.numReservaHtl); // Número único consecutivo

		return (ReservaHTL.TIPO_RESERVA + "/" + sanyo + "/" + numeroHlt);

	} // generaNuevoNumeroReserva()

	// Devuelve el número actual de Reservas de Hotel
	// Se podrá obtener el valor de la private static numReservaHtl mediante un
	// método public
	public static int numReservasHotel() {

		return ReservaHTL.numReservaHtl;
	}

	//// Métodos Constructores

	// Método constructor único
	public ReservaHTL(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, String direccion,
			char habitacion, int neto) {

		// Llamamos al constructor de la Super Clase
		super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);

		// Asignamos valores particulares para ReservaHTL
		this.direccionHtl = direccion;
		this.tipoHab = habitacion;

		// Asignamos número de reserva
		this.numeroParticularReserva = ReservaHTL.generaNuevoNumeroReserva();
	}

	// Métodos públicos

	// Mostrar Reserva
	public void muestraReserva() {

		super.muestraReserva(); // Llamamos al método de la Super Class
		System.out.println(ReservaHTL.ELEMENTO);
		System.out.println("Número de Reserva :" + this.numeroParticularReserva);
		System.out.println("Dirección : " + this.direccionHtl);
		System.out.println("Tipo Habitación : " + this.tipoHab);

	} // muestraReserva

} // class ReservaHTL
