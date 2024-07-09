package leccion_10_Ejercicio_bis;

import java.time.LocalDate;

public class ReservaHTL extends Reserva{
	
	//// Ctes de la Class ReservaHTL
	
	private static final String ELEMENTO = "Reserva Hotel"; // Identifica el elemento
	private static final String TIPO_RESERVA = "HTL"; //Tipo de Reserva
	
	//// Atributos o Variables de la Class ReservaHTL 
	
	private static int numReservaHtl; // Número consecutivo de reservas de tipo HTL
	static {
		ReservaHTL.numReservaHtl = 0; //Inicialización
	}
				
	//// Atributos o Variables de Instancia del Obj ReservaHTL
	
	private String direccionHtl = null; // Dirección Postal del Hotel
	private char tipoHab = '\0';  //Tipo de Habitación: Simple, Doble, Triple

	
	//// Métodos Constructores
	
	// Método constructor único
	public ReservaHTL(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, String direccion, char habitacion, int neto) {
		
		// Llamamos al constructor de la Super Clase 
		super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);
		
		//Asignamos valores particulares para ReservaHTL
		this.direccionHtl = direccion; 
		this.tipoHab = habitacion; 
		
		//Asignamos número de reserva
		this.numeroParticularReserva = this.numeroParticularReserva + ReservaHTL.generaNuevoNumeroReserva(); 
	}
	
	//// Métodos Static
	
	//Genera el número particular de reserva para las reserva de HTL 
	//La generación del número de reserva de HTL es responsabilidad de la Class ReservaHTL no de cada Obj ReservaHTL
	//además, manipulará la variable estática numReservaHtl, por todo ello, es un método static
	private static String generaNuevoNumeroReserva() {

		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); //Obtenemos el año
		String sanyo = String.valueOf(anyo); //Transformamos año en String
		String numeroHlt = String.valueOf(++ReservaHTL.numReservaHtl); // Número único consecutivo para el tipo de reserva
		
		return ("/" + ReservaHTL.TIPO_RESERVA + "/" + sanyo + "/" + numeroHlt);

	} // generaNuevoNumeroReserva()
		
	// Devuelve el número actual de Reservas de Hotel
	public static int numReservasHotel() {
		
		return ReservaHTL.numReservaHtl; 
	}
		
	// Métodos públicos
	
	//Mostrar Reserva 
	public void muestraReserva() {
		
		super.muestraReserva(); //Llamamos al método de la Super Class
		System.out.println(ReservaHTL.ELEMENTO); 
		System.out.println("Número de Reserva :" + this.numeroParticularReserva); 
		System.out.println("Dirección : " + this.direccionHtl);
		System.out.println("Tipo Habitación : " + this.tipoHab); 
		
	} // muestraReserva
		
} // class ReservaHTL
	
