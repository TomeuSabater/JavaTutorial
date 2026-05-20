package anonymousClassExamples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona implements GetPersonDetails {
	
	//// Variables static
	static final int MIN_ADULT_YEARS  = 18; 
	static final String ELEMENTO = "Persona";
	
	//// Variables de instancia
	private String nombre; 
	private String apellido; 
	private String fechaNacimiento; // Se espera formato yyy-mm-dd
	
	
	//// Constructor
	public Persona(String nombre, String apellido, String fechaNacimiento) {
		
		this.nombre = nombre; 
		this.apellido = apellido; 
		this.fechaNacimiento = fechaNacimiento; 
	} // Constructor 
	
	
	//// Métodos públicos
	
	public int getEdad()  {
		// Devuelve la edad en años 
		
		LocalDate fechaNacimiento = LocalDate.parse(this.fechaNacimiento);
		long anyos = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
		return (int)anyos; 
	} // getEdad() 
	
	public boolean esAdulto()  {
		// Dice si es o no adulto
		
		int anyos = this.getEdad(); 
		return ((anyos >= Persona.MIN_ADULT_YEARS) ? true : false);
	} //esAdulto
	
	public void showPersona() {
		// Vuelca los datos personales
		
		System.out.println(Persona.ELEMENTO);
		System.out.println(this.nombre);
		System.out.println(this.apellido);
		System.out.println(this.fechaNacimiento);
		System.out.println(this.getEdad());
		System.out.println("Mayor edad (" + Persona.MIN_ADULT_YEARS + "):" + esAdulto()); 	
	} // showPersona

} // Persona 

