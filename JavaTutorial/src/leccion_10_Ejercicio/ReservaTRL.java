package leccion_10_Ejercicio;

import java.time.LocalDate;

public class ReservaTRL extends Reserva{
	
	////Ctes de la Class ReservaTRL
	
	static final String ELEMENTO = "Reserva Traslado"; // Identifica el elemento
	private static final String TIPO_RESERVA = "TRL"; //Tipo de Reserva
	
	//// Atributos o Variables de la Clase 
	
	private static int numReservaTrl; // Número consecutivo de reservas de tipo HTL
	static {
		ReservaTRL.numReservaTrl = 0; //Inicialización
	}
				
	//// Atributos o Variables de Instancia del Objeto ReservaHTL
	
	private String RecogidaTrl = null; // Lugar de recogida
	private String DestinoTrl = null;  // Lugar de destino
	
	//// Métodos Constructores
	
	// Método constructor único
	public ReservaTRL(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, String direccion1, String direccion2, int neto) {
		
		// Llamamos al constructor de la Super Clase 
		super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);
		
		//Asignamos valores particulares para ReservaHTL
		this.RecogidaTrl = direccion1;  // Origen
		this.DestinoTrl = direccion2; // Destino
		
		//Asignamos número de reserva
		this.numeroReserva = generaNuevoNumeroReserva(); 
	}
	
	//// Métodos Static
	
	// Devuelve el número actual de Reservas de Hotel
	public static int numReservasTraslado() {
		
		return ReservaTRL.numReservaTrl; 
	}
	
	// Métodos privados
	
	//Genera el número de reserva para la reserva de hotel 
	private String generaNuevoNumeroReserva() {
		
		String numero = null; // Contendrá el localizador generado
		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); //Obtenemos el año
		String sanyo = String.valueOf(anyo); //Transformamos año en String
		String numeroTrl = String.valueOf(++ReservaTRL.numReservaTrl); // Número único consecutivo
		
		numero = ReservaTRL.TIPO_RESERVA + "/" + sanyo + "/" + numeroTrl; 
		return numero; 
	} // generaNuevoNumeroReserva()
	
	// Métodos públicos
	
	//Mostrar Reserva 
	public void muestraReserva() {
		
		super.muestraReserva(); //Llamamos al método de la Super Class
		System.out.println(ReservaTRL.ELEMENTO); 
		System.out.println("Número de Reserva :" + this.numeroReserva); 
		System.out.println("Dirección : " + this.RecogidaTrl);
		System.out.println("Tipo Habitación : " + this.DestinoTrl); 
		
	} // muestraReserva
	

} // public class ReservaTRL
