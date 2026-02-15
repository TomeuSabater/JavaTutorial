package leccion_10_Ejercicio;

import java.time.LocalDate;

public class Reserva {
			
	//// Ctes de la Super Class Reserva
	private static final String ELEMENTO = "Reserva"; // Identifica el elemento 
	private static final byte MAX_NUM_PAX = 4; // Numero máximo de pasajeros
	private static final byte IVA = 21; // Impuestos aplicados
	
	//// Atributos o Variables de Instancia
	
	// Localizador de la Reserva (Código único para cada reserva)
	// Todas las Reservas tendrán este dato; lo definimos en la Super Class Reserva
	protected String numeroParticularReserva = null; //Se rellenará en la sub clase, no puede ser private 
	
	// Pax, máximo de 4
	private String[] pax = new String[Reserva.MAX_NUM_PAX];
	
	// Fechas Inicio/Llegada, Fin/Salida
	private LocalDate fechaInicio;  // Inicio o Llegada, se podría inicializar con LocalDate.now();
	private LocalDate fechaFin; // Fin o Salida, se podría inicializar con LocalDate.now();
	
	// Precio
	private int precioNeto = 0; //Precio sin impuestos
	private int precioBruto = 0; //Precio con impuestos
	
	//// Métodos Constructor
	
	// Constructor único
	public Reserva(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, int neto) {
		
		//Asigna pax
		this.asignaPax(pax1, pax2, pax3, pax4); // Asigna los pax 
		
		//Fechas Inicio y Fin
		this.fechaInicio = LocalDate.parse(fInicio); // Se espera un formato yyyy-mm-dd
		this.fechaFin = LocalDate.parse(fFin); 	// Se espera un formato yyyy-mm-dd
		
		//Precios
		this.precioNeto = neto; 
		this.precioBruto = this.calculaBruto(this.precioNeto); 
	}
	
	//// Metodos Privados
	
	// Asigna Pax
	private void asignaPax(String p1, String p2, String p3, String p4) {
		
		this.pax[0] = p1; 
		this.pax[1] = p2;
		this.pax[2] = p3;
		this.pax[3] = p4; 	
	}
	
	// Calcula Precio Bruto
	private int calculaBruto(int neto) {
		
		return (neto + ((neto * Reserva.IVA) / 100)); 
	}
	
	//// Métodos Públicos
	
	// Muestra las Fechas Inicio/Entrada Fin/Salida 
	public void muestraFechasReserva()  {
		
		System.out.println("Fecha Inicio : " + this.fechaInicio);
		System.out.println("Fecha Fin :" + this.fechaFin); 
	}
				
	// Muestra los Pax
	public void muestraPax() {
		
		byte contador = 0; 
		for (String pasajero : this.pax) {
			System.out.println("Pasajero " + ++contador + " : " + pasajero);
		}
	}
	
	// Mostrar Reserva 
	public void muestraReserva() {
		
		System.out.println(Reserva.ELEMENTO); 
		muestraPax(); 
		muestraFechasReserva(); 
		System.out.println("Precio Neto : " + this.precioNeto);
		System.out.println("Precio Bruto: " + this.precioBruto); 
	} 
		
} // public class Reserva 
