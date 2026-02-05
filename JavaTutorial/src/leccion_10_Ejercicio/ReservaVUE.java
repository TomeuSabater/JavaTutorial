package leccion_10_Ejercicio;

import java.time.LocalDate;

public class ReservaVUE extends Reserva{
		
	////Ctes de la Class ReservaHTL
	
	private static final String ELEMENTO = "Reserva Vuelo"; // Identifica el elemento
	private static final String TIPO_RESERVA = "VUE"; //Tipo de Reserva
	
	//// Atributos o Variables de la Clase 
	
	private static int numReservaVue; // Número consecutivo de reservas de tipo VUE
	static {
		ReservaVUE.numReservaVue = 0; //Inicialización
	}
				
	//// Atributos o Variables de Instancia del Objeto ReservaVUE
	
	private String apSalida = null; // A/P de salida: Código 3 letras aeropuerto de salida, Eje: PMI
	private String apLlegada = null; //A/P de llegada: Código 3 letras aeropuerto de llegada, Eje: MAD

	//// Métodos Constructores
	
	// Método constructor único
	public ReservaVUE(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, String Ap1, String Ap2, int neto) {
		
		// Llamamos al constructor de la Super Clase 
		super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);
		
		//Asignamos valores particulares para ReservaHTL
		this.apSalida = Ap1; 
		this.apSalida = Ap2; 
		
		//Asignamos número de reserva
		this.numeroParticularReserva = ReservaVUE.generaNuevoNumeroReserva(); 
	}
	
	//// Métodos Static
	
	// Devuelve el número actual de Reservas de Vuelo
	public static int numReservasVuelo() {
		
		return ReservaVUE.numReservaVue; 
	}
	
	//Genera el número de reserva para la reserva de Vuelo 
	private static String generaNuevoNumeroReserva() {
		
		LocalDate hoy = LocalDate.now(); // Fecha actual
		int anyo = hoy.getYear(); //Obtenemos el año
		String sanyo = String.valueOf(anyo); //Transformamos año en String
		String numeroVue = String.valueOf(++ReservaVUE.numReservaVue); // Número único consecutivo
		
		return (ReservaVUE.TIPO_RESERVA + "/" + sanyo + "/" + numeroVue); 
	} // generaNuevoNumeroReserva()
	
	//// Métodos públicos
	
	//Mostrar Reserva 
	public void muestraReserva() {
		
		super.muestraReserva(); //Llamamos al método de la Super Class
		System.out.println(ReservaVUE.ELEMENTO); 
		System.out.println("Número de Reserva :" + this.numeroParticularReserva); 
		System.out.println("A/P Salida : " + this.apSalida);
		System.out.println("A/P Llegada : " + this.apLlegada); 
		
	} // muestraReserva

} // class ReservaVUE --> Pasar a Leccion_10_Ejercicio para un ejemplo 'completo' 
