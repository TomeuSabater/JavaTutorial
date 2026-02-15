package leccion_10_Ejercicio_bis;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {
		
	//// Class para los Pax o Clientes de una reserva
		
	//// Ctes de la Class 

	private static final String ELEMENTO = "Cliente"; // Identifica el elemento
	private static final byte ADULT = 18; // Fija edad mínima para Adultos, podría ser una Cte para cada país
	
	//// Atributos o Variables de Instancia

	private String passport = null; // Pasaporte o DNI 
	
	private String nombre = null; // Nombre de pila
	private String apellido1 = null; // Apellido1
	private String apellido2 = null; // Apellido2
		
	private LocalDate fechaNacimiento; // Fecha nacimiento pax 
	
	// Constructor único 
	
	public Cliente(String passport, String nombre, String apellido1, String apellido2, String fechaNacimiento) {
				
		this.passport = passport; 
		this.nombre = nombre; 
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento); // Se espera un formato yyyy-mm-dd	

	} // Constructor 

	
	// Métodos privados
		
	// Determina si el pax es mayor de edad
	// Se opta por no almacenar edad al ser un dato dinámico
	// en su lugar se ofrece método que proporciona esta info
	private boolean esAdulto() {
		
		//Si el titular es mayor de edad en el momento consulta devuelve 'true'
		//Si el titular no es mayor de edad en el momento de la consulta devuelve 'false'
		
		long anyos = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());	
		return (anyos >= Cliente.ADULT) ? true : false;
		
		// En una sola instrucción no quedaría claro:
		// return (ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now()) >= Cliente.ADULT) ? true : false;	
	} // esAdulto()

	
	public void muestraPax() {
		// Vuelca los datos del pax
		System.out.println(Cliente.ELEMENTO); 
		System.out.println("Passport cliente :" + this.passport); 
		System.out.println("Cliente adulto :" + this.esAdulto()); 
		System.out.println("Nombre :" + this.nombre); 
		System.out.println("Apellido1 : " + this.apellido1);
		System.out.println("Apellido2 : " + this.apellido2);	
	}
	
} // public class Cliente 
