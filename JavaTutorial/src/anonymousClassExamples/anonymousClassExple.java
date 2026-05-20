package anonymousClassExamples;

public class anonymousClassExple {

	public static void main(String[] args) {

		// Tenemos un interface denominado GetPersonDetails 
		// que oferta los métodos:
		// 		public int getEdad(); 
		// 		public boolean esAdulto(); 
		// 		public void showPersona(); 
		// Tenemos una Class Persona que implemente el Interface
		
		
		// Instanciamos la Class Persona
		
		String nombre = "Tomeu";
		String apellido = "Sabater";
		String fechaNacimiento = "1966-03-18";
				
		GetPersonDetails persona1 = new Persona(nombre, apellido, fechaNacimiento);
		
		// Deseamos usar alguno de los métodos de Persona
		System.out.println("La edad es :" + persona1.getEdad());
		System.out.println("Es adulto :" + persona1.esAdulto());
		persona1.showPersona();
			
		
		// Nos damos cuenta que en un caso especial no devuelve el valor deseado
		// realmente, en el caso que tratamos, es mayor de edad con 21 años
		// pero es un caso especial. 
		// Podemos; 
		// - Crear un método adicional en el Interface
		// - Reescribir el método pasando un parámetro con los años mínimos (peligroso hay que reescribir código), 
		// - Hacer una anonymous class para reecribir solamente el método
		// Y decidimos reescribir un método del interface
		
		
		nombre = "Gabriel";
		apellido = "Sabater";
		fechaNacimiento = "2026-03-18";
		
		// Instanciamos la Class Persona
		GetPersonDetails persona2 = new Persona(nombre, apellido, fechaNacimiento);
	
		// Deseamos usar alguno de los métodos de Persona
		System.out.println("La edad es :" + persona1.getEdad());
		System.out.println("Es adulto :" + persona1.esAdulto());
		persona1.showPersona();
				
		GetPersonDetails personaUSA = new GetPersonDetails() {
			// Anonymous Class, se define la Class y se instancia un único Obj a la vez
			// se observa que el Obj instancia la definición de la Class directamente
			// por tanto, la Class no tiene nombre (anonymous) 
			
			final int MIN_ADULT_YEARS  = 18; 
			
			public int getEdad() {
				// Este método no cambia, podemos utilizar el original 
				return persona2.getEdad(); 
			}
			
			@Override
			public boolean esAdulto() {
				// Este es el método que cambia, lo reescribimos
				
				int anyos = this.getEdad(); 
				return ((anyos >= MIN_ADULT_YEARS) ? true : false);
			}
			public void showPersona() {
				// Este método no cambia, lo reescribimos
				persona2.showPersona();
				
			}
		}; 
		
		personaUSA.showPersona();
		
		
	} // main

} // anonymousClassExple
