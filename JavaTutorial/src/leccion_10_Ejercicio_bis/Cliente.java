package leccion_10_Ejercicio_bis;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {
	
	//// Ctes de la Class 

	private static final String ELEMENTO = "Cliente"; // Identifica el elemento
	private static final byte ADULT = 18; // Fija edad mínima para Adultos
	
	//// Atributos o Variables de Instancia
	
	private boolean esTitular = false; // Indica si es el titular de la reserva
	private boolean esAdulto = false; // Indica si el titular es o no mayor de edad
	
	private String passport = null; // Pasaporte o DNI 
	
	private String nombre = null; // Nombre de pila
	private String apellido1 = null; // Apellido1
	private String apellido2 = null; // Apellido2
		
	private LocalDate fechaNacimiento; // Fecha nacimiento pax 
	
	// Constructores
	
	// Constructor con apellido2
	public Cliente(boolean esTitular, String passport, String nombre, String apellido1, String apellido2, String fechaNacimiento) {
		
		this.esTitular = esTitular; 
		
		this.passport = passport; 
		this.nombre = nombre; 
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento); // Se espera un formato yyyy-mm-dd	
		// Llamamos al método que determina si es o no Adulto
		this.esAdulto = this.esAdulto(); 

	} // Constructor 
	
	// Constructor sin apellido1
	public Cliente(boolean esTitular, String passport, String nombre, String apellido1, String fechaNacimiento) {	
		
		// Llamamos al constructor principal
		this(esTitular, passport, nombre, apellido1, null, fechaNacimiento); 
	} // Constructor 
		
	
	// Métodos públicos
		
	// Determina si el pax es mayor de edad
	private boolean esAdulto() {
		
		//Si el titular es mayor de edad devuelve true
		//Si el titular no es mayor de edad devuelve false
		
		long anyos = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());	
		return (anyos >= Cliente.ADULT) ? true : false;
		
		// En una sola instrucción
		//return (ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now()) >= Cliente.ADULT) ? true : false;	
	} // esAdulto()
	
	
	// Asigna la titularidad, a condición de que sea mayor de edad
	// retorna true si se ha asignado 
	// retorn false si es menor de edad y no se asigna
	public boolean setTitular() {
		
		if (this.esAdulto) { 
			this.esTitular = true;
			return true; 
		} else { 
			return false;
		}
	} // setTitular() 
	
	// Devuelve si es titular o no 	
	public boolean getTitular() {
		
		return this.esTitular; 
	} // getTitular()
	
	
} // public class Cliente 
