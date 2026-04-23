package classesAndObjects;

import java.time.LocalDate;

public class Leccion_8 {

	public static void main(String[] args) {

		// Introducción_V a CLASES Y OBJETOS.

		// (https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
		// (https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)

		// Access Control: public, protected, no-level (package-private), private.
		// Class Variables / Class Métodos : static (static fields o class variables, y
		// métodos static invocables sin instanciar la Clase)
		// Constantes: static final (propiedades de static además de final que indica
		// que su valor nunca cambiará)
		// Inicialización de: Variables / Atributos, Class variables.

		// Control de acceso a los atributos y métodos de una Class
		// El nivel de acceso determina si se puede acceder a un atributo o invocar un
		// método de un Obj desde otro Obj
		// Access level modifiers determine whether other classes can use a particular
		// field or invoke a particular method.

		// Hay dos niveles de acceso:
		// Top Level: public or package-private (sin nivel explícito)
		// Member Level: public, private, protected o package-private (sin nivel
		// explícito)

		// Una Class puede ser "public", y será visible por todo, si no tiene nivel
		// tiene uno implícito el "package-private" y es visible solamente dentro de su
		// propio Package.
		// Un Packages es una agrupación de Class relacionadas

		// En Member Level, se puede usar public o sin nivel (package-private), con el
		// mismo resultado que Top Level.
		// En Member Level hay dos niveles de acceso más: private y protected.
		// El calificativo "private" significa que solo es accesible en su propia clase.
		// El calificativo "protected" significa que solo puede ser accedido en su
		// propio Package (como package-private) y además por las Sub Clases de su Clase
		// en otros Package.

		// Ver cuadro resumen en
		// https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html

		// Tips on Choosing an Access Level
		// If other programmers use your Class, you want to ensure that errors from
		// misuse cannot happen. Access levels can help you to this.
		// Use the most restrictive access level. Use "private" unless you have a good
		// reason not to. En el caso de variables de instancia estás obligando al uso de
		// Setter / Getter o métodos públicos, encapsulando y controlando la variable.
		// En el caso de métodos solamente ofertas aquellas funcionalidades consideradas
		// públicas.
		// En definitiva, asigna el nivel más alto "private" y relájalo a medida que se
		// necesite.

		// Las variables de tipo "static" son compartidas por todos los Obj por lo que
		// se consideran variables de la Class y no del Obj y se puede acceder a ellas
		// sin instanciar la Class.
		// Los métodos de tipo "static", al ser métodos considerados de la Class y no
		// del Obj, se pueden invocar sin instanciar la Class esto es, sin crear un Obj
		// Un uso muy común y de sentido común, pero no el único, de los métodos
		// "static" es acceder a las variables "static"

		// Recordamos que la inicialización de las variables de instancia de una Class
		// (cada Obj tendrá los suyos) es sencilla y pude hacerse en la propia
		// definición de la Class (valor inicial) o en el constructor.
		// Para inicializar una variables "static" (Class variable), podemos usar los
		// "static initialization blocks".

		// Veamos ejemplos de todo lo anterior
		// Creamos una Class que contendrá un atributo "static"; será una variable de la
		// Class, entonces todos los Obj creados la comparten, es la misma

		class Bicycle {

			// Constantes, al ser una cte lo más habitual es definirla como estática, pero
			// no es obligatorio, si no es estática, cada Obj tendrá una cte particular.
			private static final String ELEMENTO = "Bicycle";

			// Variables de la Class, que será la misma para todos los Obj
			// Es estática por lo que es accesible y como no es una cte esmodificable por
			// todos los Obj. Si uno la modifica la modifica para todos.
			// Al ser estática, también es accesible y modificable sin necesidad de
			// instanciar la Class, es decir, sin la necesidad de un Obj.
			private static int numTotalBikes = 0; // Contiene el número total de bicicletas

			// Variables del Obj, variables de instancia, cada Obj tendrá sus propias
			// variables
			private String nombreBike;
			private int precio = 0; // En € sin deciamles
			private int numSerialBike; // Número único de cada bicicleta

			// Método constructor
			public Bicycle(String nombre, int precio) {

				// Obviamos setters, es ejemplo teórico
				this.nombreBike = nombre;
				this.precio = precio;
				this.numSerialBike = ++Bicycle.numTotalBikes; // Asigna siguiente número de serie
																// La manera correcta es ClassName.staticVariableName
			}

			// Métodos públicos
			public void showBike() {

				System.out.println(Bicycle.ELEMENTO);
				System.out.println("Serial Number = " + this.numSerialBike);
				System.out.println("Bike name = " + this.nombreBike);
				System.out.println("Precio = " + this.precio + "€");
			}
		} // class Bicyle.

		Bicycle bicicleta1 = new Bicycle("Orbea", 1500);
		bicicleta1.showBike();

		Bicycle bicicleta2 = new Bicycle("BH", 1700);
		bicicleta2.showBike();

		// Veamos ese número de serie
		// La manera correcta de referenciar una estática es
		// ClassName.stacticVariableName
		// Aunque funcione, se desaconseja objName.stacticVariableName

		System.out.println("Valor de la 'private static int numTotalBikes' = " + bicicleta1.numTotalBikes); // Awful
		System.out.println("Valor de la 'private static int numTotalBikes' = " + Bicycle.numTotalBikes); // This is the
																									// way !!!

		// Hacemos un ejemplo un poco más complejo

		class Booking {

			// Constantes
			static final String ELEMENTO = "Booking"; // Al ser 'static' todos los Obj la comparten.
														// Al ser "final" es una cte.
														// Es lógico añadir "static" a "final", no tiene sentido que
														// cada Obj tenga su propia cte.

			// Atributos de la Class, son variables static, todos los Obj comparten la misma
			// y solo existe una instancia de la misma
			private static int numActualReservas = Booking.initNumActualReservas(); // Contador de Reservas,
																					// Se puede inicializaz invocando un
																					// método static.
																					// Al ser una static, el método se
																					// invoca ClassName.methodName

			// Abributos del Objeto, variables del Obj, variables de instancia, cada Obj
			// tendrá sus propias variables.
			private String nombre; // Nombre pasajero
			private int precio = 0; // Definición e nicialización
			private int numReserva; // Valor dependiente de la static numActualReservas

			// Métodos static, permiten su invocación sin instanciar la Class; sin crear
			// ningún Obj

			// Static initialization block, inicializamos la variable static
			// La inicialización de una static admite un bloque de código
			// La inicialización de una static también admite una llamada a un método static
			private static int initNumActualReservas() {

				// Inicializa el Booking.numActualReservas
				// Puede ser un bloque de código complejo
				return (LocalDate.now().getYear());
			}

			// Método static que retorna una variable "static",
			// No hace falta instanciar un Obj para invocar este método
			// Al igual que las variables estáticas, un método estático pertenece a la Class
			public static int getnumActualReservas() {

				return Booking.numActualReservas; // Es recomendado acompañarla con nombre de su Class
				// return numActualReservas; //Obviamente esta sintaxis también funciona, pero
				// no es la recomendada
				// return this.numActualReservas; // Genera error, porque no es posible
				// referenciar un Obj desde un método estático, no tiene sentido
			}

			// Método constructor, ofertamos solamente uno
			public Booking(String nombre, int precio) {

				// Ejemplo teórico, obviamos setters
				this.nombre = nombre;
				this.precio = precio;
				this.numReserva = ++Booking.numActualReservas; // Asigna número de reserva y actualiza contador
																// Al ser una "static", el contador pertenece a la Class
																// y es compartido
			}

			// Métodos públicos
			public int getNumReserva() {

				return this.numReserva; // De cada reserva particular
			}

			public void showBooking() {

				System.out.println(Booking.ELEMENTO + " Número : " + this.getNumReserva());
				System.out.println("Nombre : " + this.nombre);
				System.out.println("Precio : " + this.precio);
			}

		} // public class booking

		// Inicialmente, indagamos el número actual de reservas
		// Observar que NO se instancia nada, al ser estática no se es necesario
		System.out.println("Número Inicial de reservas = " + Booking.getnumActualReservas());
		// Booking.numActualReservas = 0; // No es posible fuera de la Class porque es
		// private, siguientes lecciones haremos ejemplos.

		// Creamos dos reservas
		Booking booking1 = new Booking("Tomeu Sabater", 1000);
		booking1.showBooking();

		Booking bk2 = new Booking("Juan Pérez", 1500);
		bk2.showBooking();

		// Indagamos el número actual de reservas
		// saber cuántas reservas hay hasta el momento
		System.out.println("Número actual de reservas :" + Booking.getnumActualReservas());

		// Indagamos sobre el elemento
		System.out.println("Elemento es : " + Booking.ELEMENTO);

		// Aquí SI es posible reinicializar la static variable Booking.numActualReservas
		// a su
		// valor inicial posteriormente veremos cómo podemos usar una static sin
		// posibilidad de
		// reinicialización
		Booking.numActualReservas = Booking.initNumActualReservas(); // perfectamete legal
		System.out.println("Número actual de reservas :" + Booking.getnumActualReservas());

		// Booking.numActualReservas = 0; // Esto, obviamente también sería posible.
		// En la siguiente lección (Leccion_9_Ejercicio) veremos una amplicación de este
		// ejemplo. En la siguiente lección (lección_10_Ejercicio) veremos cómo aplicar
		// los niveles de acceso para que, por ejemplo, la variable static no se pueda
		// reinicializar

	} // void main

} // public class Leccion_8 --> Pasar a Lección_9_Ejercicio.java,
	// Lección_10_Ejercicio.java y Leccion_10_Ejercicio_bis.java
