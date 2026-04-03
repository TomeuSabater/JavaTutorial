package leccion_10_Ejercicio_bis;

import java.time.LocalDate;

//Class Reserva de VUELO
public class ReservaVUE extends Reserva {

	//// Ctes de la Class ReservaHTL

	private static final String ELEMENTO = "Reserva Vuelo"; // Identifica el elemento
	private static final String TIPO_RESERVA = "VUE"; // Tipo de Reserva

	//// Atributos o Variables de la Clase

	private static int numReservaVue; // Número consecutivo de reservas de tipo VUE
	static {
		ReservaVUE.numReservaVue = 0; // Inicialización
	}

	//// Atributos o Variables de Instancia del Objeto ReservaVUE

	private String apSalida;
	{ // A/P de salida: Código 3 letras aeropuerto de salida, Eje: PMI
		apSalida = "PMI";
	};
	private String apLlegada = null; // A/P de llegada: Código 3 letras aeropuerto de llegada, Eje: MAD

	//// Métodos Constructores

	// Método constructor único
	public ReservaVUE(String c1_passport, String c1_nom1, String c1_ap1, String c1_ap2, String c1_fechaNac,
			String c2_passport, String c2_nom, String c2_ap1, String c2_ap2, String c2_fechaNac, String c3_passport,
			String c3_nom, String c3_ap1, String c3_ap2, String c3_fechaNac, String c4_passport, String c4_nom,
			String c4_ap1, String c4_ap2, String c4_fechaNac, String fInicio, String fFin, String Ap1, String Ap2,
			int neto) {

		// Llamamos al constructor de la Super Clase
		super(c1_passport, c1_nom1, c1_ap1, c1_ap2, c1_fechaNac, c2_passport, c2_nom, c2_ap1, c2_ap2, c2_fechaNac,
				c3_passport, c3_nom, c3_ap1, c3_ap2, c3_fechaNac, c4_passport, c4_nom, c4_ap1, c4_ap2, c4_fechaNac,
				fInicio, fFin, neto);

		// Asignamos valores particulares para ReservaHTL
		this.apSalida = (Ap1 != null) ? Ap1 : this.apSalida;
		this.apLlegada = Ap2;

		// Asignamos número de reserva
		this.numeroParticularReserva = this.numeroParticularReserva + ReservaVUE.generaNuevoNumeroReserva();
	}

	//// Métodos Static

	// Devuelve el número actual de Reservas de Vuelo
	public static int numReservasVuelo() {

		return ReservaVUE.numReservaVue;
	}

	// Genera el número de reserva para la reserva de vuelo
	private static String generaNuevoNumeroReserva() {

		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); // Obtenemos el año
		String sanyo = String.valueOf(anyo); // Transformamos año en String
		String numeroHlt = String.valueOf(++ReservaVUE.numReservaVue); // Número único consecutivo para el tipo de
																		// reserva

		return ("/" + ReservaVUE.TIPO_RESERVA + "/" + sanyo + "/" + numeroHlt);
	} // generaNuevoNumeroReserva()

	//// Métodos públicos

	// Mostrar Reserva
	public void muestraReserva() {

		super.muestraReserva(); // Llamamos al método de la Super Class
		System.out.println(ReservaVUE.ELEMENTO);
		System.out.println("Número de Reserva :" + this.numeroParticularReserva);
		System.out.println("A/P Salida : " + this.apSalida);
		System.out.println("A/P Llegada : " + this.apLlegada);

	} // muestraReserva

} // class ReservaVUE
