package classesAndObjects;

public class Leccion_8 {

	public static void main(String[] args) {

		// Introducción_V a CLASES Y OBJETOS. 
		// (https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
		// (https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
		
		
		// Access Control: public, protected, no-level (package-private), private. 
		// Class Variables / Class Métodos : static (static fields o class variables, y métodos static invocables sin instanciar la Clase) 
		// Constantes: static final (propiedades de static además de final que indica que su valor nunca cambiará) 
		// Inicialización de: Variables / Atributos, Class variables.  
					
		
		// Control de acceso a los atributos y métodos de una Class
		// El nivel de acceso determina si puede accederse a un atributo o invocar un método de otra Class
		
		// Dos niveles de acceso:
		// Top Level: public or package-private (sin nivel explícito)
		
		// Member Level: public, private, protected o package-private (sin nivel explícito) 
		
		// Una Clase puede ser public, y será visible por todo, si no tiene nivel tiene uno implícito: package-private y es visible solamente dentro de su propio package 
		// Packages son nombres de grupos de Classes relacionadas
		
		// En Member Level, se puede user public o sin nivel (package-private), con el mismo resultado que Top Level. 
		// En Member Level hay dos niveles de acceso más: private y protected. 
		// Private significa que solo es accesible en su propia clase. 
		// Protected significa que solo puede ser accedido en su propio Package (como package-private) y además, por las Sub Clases de su Clase en otros Package. 
		
		// Ver cuadro resumen en https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
		
		// Las variables de tipo "static" son compartidas por todos los Obj por lo que se consideran variables de la Class y no del Obj, y se puede acceder a ellos sin instanciar la Class 
		// Los métodos de tipo "static", al ser métodos considerados de la Class y no del Obj, se pueden invocar sin instanciar la Class (sin crear un Ojbeto) 
		// Un uso muy común, pero no el único, de los métodos static es acceder a las variables static
		
		// La inicialización de las Variables de Instancia de una Class (cada Obj tendrá los suyos) es sencilla y pude hacerse en la definición de la Class o en el constructor 
		// Para inicializar una variables static (Class variable), podemos usar los "static initialization blocks". 
		
		
		
		//Creamos una Class que contendrá un atributo static; será una variable de la Clase, todos los Obj creados la comparten 

		class Booking {
			
			//Constantes
			static final String ELEMENTO = "Booking"; 	// Al ser "static" todos los Obj la comparten, al ser "final" es una cte. 
														// es lógico añadir "static" a "final", no tiene sentido que cada Obj tenga su propia cte. 
			
			//Abributos del Objeto, Variables del Obj, cada Obj tendrá sus propias variables. 
			private String nombre; 
			private int precio = 0; // Inicialización
			private int numReserva; 
		
			//Atributos de la Class, todos los Obj comparten la misma variable y solo existe una instancia de la misma
			private static int numActualReservas = Booking.iniNumActualReservas(); //Contador de Reservas, 
																					// Se inicializa invocando un método static 
																					// al ser static, el método se invoca con la Class no con el Obj
			
			// Métodos static, permiten su invocación sin instanciar la Class, sin crear ningún Obj
			
			// Static initialization block, inicializamos la variable static
			private static int iniNumActualReservas() {
			
					return 2024; //inicializa el número actual de reservas
			}
			
			//Retorna una variable "static",
			public static int getnumActualReservas() {
				
				return Booking.numActualReservas; 	//  es bueno acompañarla con nombre de su Class
				// return numActualReservas; 		//Obviamente esta sintaxis también funciona, pero no es la recomendada
			}	
			
			// Constructor
			public Booking (String nombre, int precio) {
				
				this.nombre = nombre; 
				this.precio = precio;
				this.numReserva = ++Booking.numActualReservas; 	//Asigna número de reserva y actualiza contador
																// Al ser una "static", pertenece a la Class y es única
			}
			
			// Métodos públicos 
			public int getNumReserva() {
				
				return this.numReserva; 
			}
			
			public void showBooking() {
				
				System.out.println(Booking.ELEMENTO + " Número : " + this.getNumReserva());
				System.out.println("Nombre : " + this.nombre);
				System.out.println("Precio : "+ this.precio);
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
		
		//Aquí es posible reinicializar la static variable numActualReservas
		//posteriormente veremos cómo podemos usar una static sin posibilidad de reinicialización 
		Booking.numActualReservas = Booking.iniNumActualReservas(); 
		System.out.println("Número actual de reservas :" + Booking.getnumActualReservas()); 
		
		//En la siguiente lección (Leccion_9_Ejercicio) veremos una amplicación de este ejemplo
		//En la siguiente lección (lección_10_Ejercicio) vermos cómo aplicar los niveles de acceso para que, por ejemplo, la variable static no se pueda reinicializar
		
	} // void main

} // public class Leccion_8 
