package anonymousClassExample;

public class Principal {

	public static void main(String[] args) {

		// Variables de Instancia
		String nombre = "Tomeu";
		String apellidos = "Sabater Bosch";
		String fechaNacimiento = "1966-01-01";
		String nacionalidad = "EU";
				
		// Instanciamos un Obj 
		PersonClass persona1 = new PersonClass(nombre, apellidos, fechaNacimiento, nacionalidad);
		System.out.println("************");
		
		// Deseamos usar alguno de los métodos de Persona
		System.out.println("La edad es :" + persona1.getEdad());
		System.out.println("Es adulto :" + persona1.esAdulto());
		persona1.showPersona();
		
		////  Instanciamos otra persona 
		nombre = "Gabriel";
		apellidos = "Sabater Sabater";
		fechaNacimiento = "2006-01-01";
		nacionalidad = "USA"; 
				
		// Instanciamos la Class Persona
		PersonClass persona2 = new PersonClass(nombre, apellidos, fechaNacimiento, nacionalidad);
		System.out.println("************");
		System.out.println("La edad es :" + persona2.getEdad());
		System.out.println("Es adulto :" + persona2.esAdulto());
		persona2.showPersona();

				
		// Nos damos cuenta que en un caso especial no devuelve el valor deseado
		// realmente, en el caso que tratamos, es mayor de edad con 21 años
		// pero es un caso especial. 
		// Podemos; 
		// - Crear un método adicional en el Interface
		// - Reescribir el método pasando un parámetro con los años mínimos (peligroso hay que reescribir código), 
		// - Hacer una anonymous class para reecribir solamente el método
		// Y decidimos reescribir un método del interface
							
				
		if (persona2.nacionalidad == "USA") {
		
			PersonDetailsInterface personaAnonymous = new PersonDetailsInterface() {
				
				final int MIN_ADULT_YEARS = 21; 
				final String ELEMENTO = "Persona Anonima";
				
				@Override
				public int getEdad() {
				// Mismo método no se reescribe
					
					return persona2.getEdad();
				} 
				
				@Override
				public boolean esAdulto() {
				// Reescribimos  el método 
					
					int anyos = this.getEdad(); 
					return ((anyos >= MIN_ADULT_YEARS) ? true : false);
				}
				
				@Override
				public void showPersona() {
					// Mismo método no se reescribe

					System.out.println(this.ELEMENTO);
					System.out.println(persona2.nombre);
					System.out.println(persona2.apellido);
					System.out.println(persona2.fechaNacimiento);
					System.out.println(persona2.nacionalidad);
					System.out.println(this.getEdad());
					System.out.println("Mayor edad (" + this.MIN_ADULT_YEARS + "):" + esAdulto()); 
				}
				
			}; // personaAnonymous
			System.out.println("************");
			personaAnonymous.showPersona();
		
		} // if (persona2.nacionalidad == "USA")
			
	} // main

} // Principal
