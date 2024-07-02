package leccion_10_Ejercicio;

import java.time.LocalDate;

public class ReservaHTL extends Reserva{
	
	//// Ctes de la Class ReservaHTL
	
	static final String ELEMENTO = "Reserva Hotel"; // Identifica el elemento
	private static final String TIPO_RESERVA = "HTL"; //Tipo de Reserva
	
	//// Atributos o Variables de la Clase 
	
	private static int numReservaHtl; // Número consecutivo de reservas de tipo HTL
	static {
		ReservaHTL.numReservaHtl = 0; //Inicialización
	}
				
	//// Atributos o Variables de Instancia del Objeto ReservaHTL
	
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
		this.numeroReserva = generaNuevoNumeroReserva(); 
	}
	
	//// Métodos Static
	
	// Devuelve el número actual de Reservas de Hotel
	public static int numReservasHotel() {
		
		return ReservaHTL.numReservaHtl; 
	}
	
	// Métodos privados
	
	//Genera el número de reserva para la reserva de hotel 
	private String generaNuevoNumeroReserva() {
		
		String numero = null; // Contendrá el localizador generado
		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); //Obtenemos el año
		String sanyo = String.valueOf(anyo); //Transformamos año en String
		String numeroHlt = String.valueOf(++ReservaHTL.numReservaHtl); // Número único consecutivo
		
		numero = ReservaHTL.TIPO_RESERVA + "/" + sanyo + "/" + numeroHlt; 
		return numero; 
	} // generaNuevoNumeroReserva()
	
	// Métodos públicos
	
	//Mostrar Reserva 
	public void muestraReserva() {
		
		super.muestraReserva(); //Llamamos al método de la Super Class
		System.out.println(ReservaHTL.ELEMENTO); 
		System.out.println("Número de Reserva :" + this.numeroReserva); 
		System.out.println("Dirección : " + this.direccionHtl);
		System.out.println("Tipo Habitación : " + this.tipoHab); 
		
	} // muestraReserva
		
} // class ReservaHTL
	
