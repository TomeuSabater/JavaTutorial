package anonymousClassExamples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class anonymousClassExple {

	public static void main(String[] args) {

		// Tenemos un interface denominado GetPersonDetails 
		// que oferta los métodos
		// 		public int getEdad(); 
		// 		public boolean esAdulto(); 
		// 		public void showPersona(); 
		// Tenemos una Class Persona que implemente el Interface
		
		
		// Usamos la clase 
		
		GetPersonDetails personita = new Persona("Tomeu", "Sabater", "1966-03-18");
		personita.showPersona();
		
		// Deseamos usar alguno de los métodos de Persona
		System.out.println("La edad es :" + personita.getEdad()); 
		
		// Nos damos cuenta que no devuelve el valor deseado
		// realmene queremos días y años para saber si está cerca de su próximo año
		// Hay que reescribir el método, o hacer una clase anónima para reescribir el método
		
		GetPersonDetails personita2 = new GetPersonDetails() {
			
			public int getEdad() { return 10; }
			public boolean esAdulto(){ return true;}
			public void showPersona(){}
			
		};  
			
		
	}

}
