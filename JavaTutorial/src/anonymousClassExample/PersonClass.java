package anonymousClassExample;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonClass implements PersonDetailsInterface {

////Class para implementar un Obj Persona

	//// Variables static
	static final int MIN_ADULT_YEARS  = 18; 
	static final String ELEMENTO = "Persona";
	
	//// Variables de instancia
	 String nombre; 
	 String apellido; 
	 String fechaNacimiento; // Se espera formato yyy-mm-dd
	 String nacionalidad; // Se espera formato "EU" / "USA"
	
	//// Métodos
		
	// Constructor
		
	public PersonClass(String nombre, String apellido, String fechaNacimiento, String nacionalidad) {
		// Constructor único
			
		this.nombre = nombre; 
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento; 
		this.nacionalidad = nacionalidad; 		
	} // Constructor
	
	// Métodos públicos del Interface 
	
	@Override
	public int getEdad() {
		
		// Devuelve la edad en años 
		
		LocalDate fechaNacimiento = LocalDate.parse(this.fechaNacimiento);
		long anyos = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
		return (int)anyos; 
	} // getEdad()
	
	@Override
	public boolean esAdulto() {		
		// Dice si es o no adulto
		
		int anyos = this.getEdad(); 
		return ((anyos >= PersonClass.MIN_ADULT_YEARS) ? true : false);
	} // esAdulto()
	
	@Override
	public void showPersona() {
		// Vuelca los datos personales
		
		System.out.println(PersonClass.ELEMENTO);
		System.out.println(this.nombre);
		System.out.println(this.apellido);
		System.out.println(this.nacionalidad);
		System.out.println(this.fechaNacimiento);
		System.out.println(this.nacionalidad); 
		System.out.println(this.getEdad());
		System.out.println("Mayor edad (" + PersonClass.MIN_ADULT_YEARS + "):" + esAdulto()); 
	}; 
	
	 
}
