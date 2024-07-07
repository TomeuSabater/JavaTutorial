package classesAndObjects;

public class Leccion_8 {

	public static void main(String[] args) {

		// Introducción_V a CLASES Y OBJETOS. 
		// (https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
		// (https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
		
		
		// Access Control: public, protected, no-level (package-private), private. 
		// Class Variables / Métodos : static (static fields o class variables, y métodos static invocables sin instanciar la Clase) 
		// Constantes: static final (propiedades de static además de final que indica que su valor nunca cambiará) 
		// Inicialización de: Variables / Atributos, Class variables.  
		
				
		
		// Control de acceso a los atributos y métodos de una Clase
		// El nivel de acceso determina si puede accederse a un atributo o invocar un método de otra clase
		
		// Dos niveles de acceso:
		// Top Level: public or package-private (sin nivel explícito)
		
		// Member Level: public, private, protected o package-private (sin nivel explícito) 
		
		// Una Clase puede ser public, y será visible por todo, si no tiene nivel (package-private), es visible solamente dentro de su propio package 
		// Packages son nombres de grupos de Clases relacionadas
		
		// En Member Level, se puede user public o sin nivel (package-private), con el mismo resultado que Top Level. En Member Level hay dos niveles de acceso más
		// private y protected. Private signifcia que solo es accesible en su propia clase. Protected significa que solo puede ser accedido en su propio Package (como package-private)
		// y además, por las Sub Clases de su Clase en otros Package. 
		
		// Ver cuadro resumen
		
		// Variables static son compartidas por todos los Objetos y son variables de la Clase
		// Métodos static se pueden invocar sin instanciar la Clase (sin crear un Ojbeto) y su uso más común es acceder a variables static
		
		// La inicialización de Atributos de una Clase es sencilla y pude hacerse en la definición de la clase o en el constructor 
		// Para inicializar una variables static (Class variable), podemos usar los "static initialization blocks". 
				
		
		
		//Creamos una Class que contendrá un atributo static; será una variable de la Clase, todos los Objetos la comparten 

		class Booking {
			
			//Constantes
			static final String ELEMENTO = "Booking";
			
			//Abributos del Objeto
			private String nombre; 
			private int precio = 0; // Inicialización
			private int numReserva; 
		
			//Atributos de la Clase
			private static int numActualReservas = Booking.iniNumActualReservas(); //Contador de Reservas
			
			// Static initialization block
			private static int iniNumActualReservas() {
			
					return 2024; //inicializa el número actual de reservas
			}
			
			// Métodos static, permite invocarlo sin instanciar la Class
			public static int getnumActualReservas() {
				
				return Booking.numActualReservas; 
			}	
			
			// Constructor
			public Booking (String nombre, int precio) {
				
				this.nombre = nombre; 
				this.precio = precio;
				this.numReserva = ++Booking.numActualReservas; //Asigna número de reserva y actualiza contador
			}
			
			// Métodos públicos 
			public int getNumReserva() {
				
				return this.numReserva; 
			}
			
			public void showBooking() {
				
				System.out.println(Booking.ELEMENTO + " Número : " + this.getNumReserva());
				System.out.println(this.nombre);
				System.out.println(this.precio);
			}
			
		} // public class booking
		
		
		// Creamos dos reservas
		Booking bk1 = new Booking("Tomeu Sabater", 1000);
		bk1.showBooking();
		
		Booking bk2 = new Booking("Juan Pérez", 1500);
		bk2.showBooking();
		
		//Indagamos el número actual de reservas
		System.out.println("Número actual de reservas :" + Booking.getnumActualReservas()); 
		
		//Indagamos sobre el elemento
		System.out.println("Elemento es : " + Booking.ELEMENTO); 
		
		//Inicialización de la static variable
		Booking.numActualReservas = Booking.iniNumActualReservas(); 
		System.out.println("Número actual de reservas :" + Booking.getnumActualReservas()); 
		
		//En la siguiente lección (Leccion_9_Ejercicio) veremos cómo podemos inicializar una static sin posibilidad de reinicialización
		
	} // void main

} // public class Leccion_8 
