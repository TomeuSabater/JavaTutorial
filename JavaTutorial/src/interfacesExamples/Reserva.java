package interfacesExamples;

public class Reserva {
	
	// Variables de instancia
	
	String[] localizadorReserva = new String[3]; // Contiene los 3 localizadores 
	
	private String nombre; 
	private String apellido1;
	private String fechaNacimiento; // Se espera formato yyy-mm-dd
	private Boolean esAdulto = false; // Según país
	private String codigoPaisIATA; // Código país en IATA
	private float pesoPaxMDC; // Peso en metrico decimal
	private float pesoPaxIMP; // Peson en imperial
	
	LocalizadorInterface localizadorHTL = new LocataHTL(); // Para generar nuevo Localizador Hotel
	LocalizadorInterface localizadorVUE = new LocataVUE(); // Para generar nuevo Localizador Vuelo
	LocalizadorInterface localizadorTRL = new LocataTRL(); // Para generar nuevo Localizador Traslado
	
	PaxUtilitiesInterface pax = new PaxUtilities(); //Para manipular datos de pax
		
	// Constructor
	public Reserva(String nombre, String apellido1, String fechaNacimiento, String codigoPaisIATA, float pesoPaxMDC) {
				
		this.localizadorReserva[0] = localizadorHTL.generaLocata(); 
		this.localizadorReserva[1] = localizadorVUE.generaLocata(); 
		this.localizadorReserva[2] = localizadorTRL.generaLocata(); 
		
		this.nombre = pax.nombrePaxLimpio(nombre);
		this.apellido1 = pax.nombrePaxLimpio(apellido1);
		
		this.codigoPaisIATA = codigoPaisIATA; 
		this.fechaNacimiento = fechaNacimiento; 
		this.esAdulto = pax.esAdulto(fechaNacimiento, codigoPaisIATA); 
		
		this.pesoPaxMDC = pesoPaxMDC; 
		this.pesoPaxIMP = pax.getPesoPaxIMP(pesoPaxMDC); 
		
	} // Constructor 
	
	// Métodos públicos
	public void showReserva() {
		
		System.out.println("Localizador :" + this.localizadorReserva[0]);
		System.out.println("Localizador :" + this.localizadorReserva[1]);
		System.out.println("Localizador :" + this.localizadorReserva[2]);
		System.out.println("Nombre :" + this.nombre);
		System.out.println("Apellido :" + this.apellido1);
		System.out.println("Fecha Nacimiento :" + this.fechaNacimiento);
		System.out.println("Es adulto :" + this.esAdulto);
		System.out.println("codigoPaisIATA :" + this.codigoPaisIATA);
		System.out.println("pesoPaxMDC :" + this.pesoPaxMDC);
		System.out.println("pesoPaxIMP :" + this.pesoPaxIMP);
	} // showReserva
	
} // Class Reserva 
