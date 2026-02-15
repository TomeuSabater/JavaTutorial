package leccion_10_Ejercicio_bis;

import java.time.LocalDate;

//Class Reserva de TRASLADO
public class ReservaTRL extends Reserva{
	
	////Ctes de la Class ReservaTRL
	
	private static final String ELEMENTO = "Reserva Traslado"; // Identifica el elemento
	private static final String TIPO_RESERVA = "TRL"; //Tipo de Reserva
	
	//// Atributos o Variables de la Clase 
	
	private static int numReservaTrl; // Número consecutivo de reservas de tipo HTL
	static {
		ReservaTRL.numReservaTrl = 0; //Inicialización
	}
				
	//// Atributos o Variables de Instancia del Objeto ReservaHTL
	
	private String RecogidaTrl = null; // Lugar de recogida
	private String DestinoTrl = null;  // Lugar de destino
	
	
	//// Métodos Static
	
	// Devuelve el número actual de Reservas de Hotel
	public static int numReservasTraslado() {
		
		return ReservaTRL.numReservaTrl; 
	}
		
	//Genera el número de reserva para la reserva de hotel 
	private static String generaNuevoNumeroReserva() {
		
		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); //Obtenemos el año
		String sanyo = String.valueOf(anyo); //Transformamos año en String
		String numeroTrl = String.valueOf(++ReservaTRL.numReservaTrl); // Número único consecutivo para el tipo de reserva
		
		return ("/" + ReservaTRL.TIPO_RESERVA + "/" + sanyo + "/" + numeroTrl);
	} // generaNuevoNumeroReserva()
	
	
	//// Métodos Constructores
	
	// Método constructor único
	public ReservaTRL(String c1_passport, String c1_nom1, String c1_ap1, String c1_ap2, String c1_fechaNac,
			String c2_passport, String c2_nom, String c2_ap1, String c2_ap2, String c2_fechaNac, 
			String c3_passport, String c3_nom, String c3_ap1, String c3_ap2, String c3_fechaNac, 
			String c4_passport, String c4_nom, String c4_ap1, String c4_ap2, String c4_fechaNac,			
			String fInicio, String fFin, String direccion1, String direccion2, int neto) {
		
		// Llamamos al constructor de la Super Clase 
		super(c1_passport, c1_nom1, c1_ap1, c1_ap2, c1_fechaNac,
				c2_passport, c2_nom, c2_ap1, c2_ap2, c2_fechaNac, 
				c3_passport, c3_nom, c3_ap1, c3_ap2, c3_fechaNac, 
				c4_passport, c4_nom, c4_ap1, c4_ap2, c4_fechaNac, 
				fInicio, fFin, neto);
		
		//Asignamos valores particulares para ReservaHTL
		this.RecogidaTrl = direccion1;  // Origen
		this.DestinoTrl = direccion2; // Destino
		
		//Asignamos número de reserva
		this.numeroParticularReserva = this.numeroParticularReserva + ReservaTRL.generaNuevoNumeroReserva(); 
	}
		
	// Métodos públicos
	
	//Mostrar Reserva 
	public void muestraReserva() {
		
		super.muestraReserva(); //Llamamos al método de la Super Class
		System.out.println(ReservaTRL.ELEMENTO); 
		System.out.println("Número de Reserva :" + this.numeroParticularReserva); 
		System.out.println("Dirección : " + this.RecogidaTrl);
		System.out.println("Tipo Habitación : " + this.DestinoTrl); 
		
	} // muestraReserva
	

} // public class ReservaTRL
