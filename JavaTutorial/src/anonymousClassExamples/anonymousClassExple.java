package anonymousClassExamples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class anonymousClassExple {

	public static void main(String[] args) {

		// Tenemos un interface denominado GetPersonDetails 
		// que oferta los métodos:
		// 		public int getEdad(); 
		// 		public boolean esAdulto(); 
		// 		public void showPersona(); 
		// Tenemos una Class Persona que implemente el Interface
		
		
		// Usamos la clase 
		
		String nombre = "Tomeu";
		String apellido = "Sabater";
		String fechaNacimiento = "1966-03-18";
		
		
		GetPersonDetails personita = new Persona("Tomeu", "Sabater", "1966-03-18");
		personita.showPersona();
		
		// Deseamos usar alguno de los métodos de Persona
		
		System.out.println("La edad es :" + personita.getEdad());
		System.out.println("Es adulto :" + personita.esAdulto());
		personita.showPersona();
			
		
		// Nos damos cuenta que no devuelve el valor deseado
		// realmente, en el caso que tratamos, el mayor de edad con 21 años
		// pero es un caso especial
		// Hay que crear otro método o reescribir el método, 
		// o hacer una clase anónima para reecribir solamente el método
			
		
		GetPersonDetails personita2 = new GetPersonDetails() {
		
			@Override
			public boolean esAdulto(){ 
				
				// Reescribimos el método puesto que necesitamos otra fecha
				final int MIN_ADULT_YEARS  = 21; 
								
				int anyos = personita.getEdad(); // Llamamos al  método "normal"
				return ((anyos >= MIN_ADULT_YEARS) ? true : false);
			} //esAdulto
			
			public int getEdad(
					
					personita.
					
					); 
			public boolean esAdulto(); 
			public void showPersona(); 

			
		};  
			
		
	}

}
