package classesAndObjects;

class Leccion_7 {

	public static void main(String[] args) {

		// Introducción_IV a CLASES Y OBJETOS.

		// Sobrecarga de Constructores
		// Nombre de los métodos
		// Nested Class (Clases Anidadas)
		// Ciclo de Vida de un Objeto:
		// Declaración, Instanciación e Inicialización de Objetos.
		// Uso del Objeto
		// Destrucción del Objeto
		// Encapsulación de Objetos
		// Operador Ternario condición ? valor_si_verdadero : valor_si_falso
		// Métodos void, return, void con return
		// Métodos con Obj como parámetros de entrada
		// Métodos que retornan Obj
		// Class sin Constructor (como repositorios de métodos)
		// "This" en Constructores

		class Point {
			// Define un punto (x,y) en el espacio

			// Variables de Class, y Ctes.
			static final String ELEMENTO = "PuntoXY";

			// Variables de Instancia, privados
			private int posicionX = 0;
			private int posicionY = 0;

			// Constructor
			public Point(int valorX, int valorY) {

				this.posicionX = valorX;
				this.posicionY = valorY;
			}

			// Métodos públicos

			// Movemos la posición del punto un deltaX, deltaY
			// Nombre método es un verbo descriptivo, palabra compuesta en mayúsculas
			public void movePoint(int deltaX, int deltaY) {

				this.posicionX += deltaX; // Incremento delta X
				this.posicionY += deltaY; // Incremente delta Y
			}

			// Mostramos el Punto
			// Nombre método es un verbo descriptivo, palabra compuesta en mayúsculas
			public void showPoint() {

				System.out.println(Point.ELEMENTO);
				System.out.println("Posición X = " + this.posicionX);
				System.out.println("Posición Y = " + this.posicionY);
			}

		} // class Point

		class Rectangle {
			// Define un Rectángulo a partir de un punto en el espacio, altura y anchura

			// Variables de Class, y Ctes.
			static final String ELEMENTO = "Rectángulo";

			// Variables de Instancia, privadas
			private int valorAlto; // Define la altura
			private int valorAncho; // Define la anchura
			private Point puntoOrigen; // Posición en el plano del vértice origen del rectángulo, es un Obj
										// Realmente no es el Obj Point, es la referencia (puntero) al Obj Point
			private int valorArea; // Área del rectángulo

			// Métodos constructores x 5, Sobrecargamos el Constructor

			// Constructor "predilecto"; punto origen, alto y ancho
			// El resto de constructores se basarán en este
			public Rectangle(Point p, int w, int h) { // Origen, altura y anchura
				this.valorAncho = w;
				this.valorAlto = h;
				this.puntoOrigen = p;
				this.valorArea = getArea();
			}

			public Rectangle() { // Sin valores
				this(0, 0); // Llamamos a otro constructor
							// El "this" para llamar a otro constructor debe ser la primera instrucción
							// No se pueden "encadenar" constructores
			}

			public Rectangle(int w, int h) { // Solo altura y anchura
				this.valorAncho = w;
				this.valorAlto = h;
				this.puntoOrigen = new Point(0, 0);
				this.valorArea = getArea();
			}

			public Rectangle(Point p) { // Solo punto de origen
				this(p, 1, 1); // Llamamos al constructor "predilecto"
			}

			public Rectangle(int x, int y, int w, int h) { // coordenadas origen, alto y ancho
				this(new Point(x, y), w, h); // Llamamos al constructor "predilecto"
			}

			// Métodos públicos

			// Calcula área del rectángulo
			public int getArea() {
				// Ejemplo de utilización del operador ternario de Java
				// Sintaxis:
				// condición ? valor_si_verdadero : valor_si_falso;
				// String mensaje = (edad >= 18) ? “Eres mayor de edad” : “Eres menor de edad”;

				return (this.valorAlto == 0 || this.valorAncho == 0) ? 0 : (this.valorAlto * this.valorAncho);

				// El código anterior substituye al siguiente bloque de código
				// if (this.alto == 0 || this.ancho == 0) {
				// return 0;
				// } else {
				// return (this.alto * this.ancho);
				// }
				// Es evidente que aplicando refactorización obtendríamos:
				// el operador ternario. Es un ejemplo
				// bien codificado bastaría con : return (this.alto * this.ancho);
			}

			// Desplaza el rectángulo
			public void moveRectangle(int dX, int dY) {

				this.puntoOrigen.movePoint(dX, dY); // Invocamos el método movePoint del Obj 'origen'
				return; // Aún siendo un método "void" es posible añadir la cláusula return para indicar
						// la finalización del método
				// this.origen.movePoint(dX*2, dY*2); // Este código sería inaccesible, el
				// return fuerza la salida del método
			}

			// Muestra el rectángulo
			public void showRectangle() {

				System.out.println(Rectangle.ELEMENTO);
				this.puntoOrigen.showPoint();
				System.out.println("Ancho = " + this.valorAncho);
				System.out.println("Alto = " + this.valorAlto);
				System.out.println("Área = " + this.valorArea);
				return; // Aún siendo "void", es posible añadir la cláusula return para indicar la
						// finalización del método
			}

		} // class Rectangulo

		// Creamos un Objeto p1 a partir de la Clase Point
		// Recordamos que "p1" no es el Obj, es la variable que identifica el Obj; su
		// referencia

		Point punto1; // Declaración, la variable p1 es de type Class Point; Referenciará a un Obj de
						// tipo Point
		punto1 = new Point(3, 4); // Instanciación e Inicialización,
									// "new" instancia la Class (crea el Obj) y devuelve una referencia al Obj que
									// se almacena en la variable "p1"
									// en la creación "new" se invoca automáticamente al método constructor para
									// inicializar el Obj recién creado

		// Obviamente se puede hacer todo junto; Declaración, instanciación e
		// inicialización
		// La variable p2 es de type Class Point; Referenciará a un Obj de tipo Point
		Point punto2 = new Point(1, 1);

		// Llamadas a métodos de los Objetos
		punto1.showPoint();
		punto2.showPoint();

		// Creamos un Obj de Class Rectangle que tiene como origen el Obj de Class Point
		// recién creado
		Rectangle rectangulo1; // Declaración de variable r1; es una variable de tipo Class Rectangle
		rectangulo1 = new Rectangle(punto1, 5, 8); // Instanciación ("new") de la Class Rectangle que crea el Obj con
													// referencia r1
		// e inicialización del mismo mediante llamada a su constructor

		// Obviamente, se puede hacer todo junto
		Rectangle rectangulo3 = new Rectangle(punto2, 3, 5); // Declaración, instanciación, inicialización. Obj de Class
																// Rectangle,
		// referenciado por r3.

		// Llamadas a métodos de los Obj recién creados
		rectangulo1.showRectangle();
		rectangulo3.showRectangle();

		// Ahora mismo tenemos un Obj de Class Point al que, y mediante p1, podemos
		// referenciarlo desde dentro/fuera del rectángulo
		// Es el mismo Obj

		// Movemos el punto "p1" y también moveremos el punto "origen" del Rectángulo,
		// porque son el mismo Objeto
		punto1.movePoint(1, 1);
		punto1.showPoint();
		rectangulo1.showRectangle();

		// Movemos el punto "origen" del rectángulo y también movemos el punto "punto1",
		// son
		// el mismo Objeto
		rectangulo1.moveRectangle(-1, -1);
		rectangulo1.showRectangle();
		punto1.showPoint();

		// Creamos un Rectángulo sin tener su punto de "origen"
		Rectangle rectangulo2 = new Rectangle(1, 2, 3, 4);
		rectangulo2.showRectangle();

		// En este caso, el punto "origen" del rectángulo r2 es inaccesible desde el
		// exterior
		// No tenemos su referencia ni tenemos un getOrigen() que nos la devuelva
		// No podemos invocar movePoint() desde fuera del Objeto r2 porque no tenemos la
		// referencia de "origen" desde fuera de r2
		rectangulo2.moveRectangle(+1, +1);
		rectangulo2.showRectangle();

		// Cosas que Java permite y no son muy aconsejables,
		// más adelante veremos las Anonymous Class y las Lambda Expression que
		// formalizan este tipo de expresiones.
		new Rectangle(1, 1).showRectangle(); // Instanciamos un Objeto de tipo Rectángulo, lo mostramos pero no
												// guardamos su referencia
												// Al tener un Objeto sin referencia, la JVM liberará los recursos que
												// utiliza de manera inmediata
		int area = new Rectangle(2, 3).getArea(); // Instanciamos un Objeto de tipo Rectángulo,
													// podría servir para tener una herramienta para calcular el área de
													// un rectángulo sin necesidad de almacenar el Obj rectángulo
		System.out.println("Area = " + area);

		// Cuando un Objeto es inalcanzable, no tenemos ninguna referencia al mismo,
		// la JVM automáticamente se encarga de destruirlo (eliminar los recursos que
		// utiliza) "The Java runtime environment deletes objects when it determines
		// that they are no longer being used."
		// This process is called "Garbage Collection".
		// Una manera de "destruir" un Objeto de manera explícita es mediante la
		// asignación del valor "null" a todas las variables que lo refrencian.
		// Veamos un ejemplo:

		punto1 = null; // Todavía hay una referencia a punto1 dentro de rectangulo1
		punto2 = null;
		rectangulo1 = null; // Indiréctamente, elimina la referencia a p1, queda sin ninguna referencia
		rectangulo2 = null;
		rectangulo3 = null;
		System.out.println("Objetos destruidos");

		// Un método puede recibir un Obj como parámetro y también puede devolver un Obj
		// Ejemplo; Creamos una Class Utiles para que nos proporcione métodos que
		// gestionan Obj
		// De la Class Utiles que definimos no nos interesará tanto los Obj como sus
		// métodos
		// El Obj que instanciamos se puede ver como un 'contenedor' de métodos
		// genéricos

		class Utiles { // Esta Class no tiene constructor (es implícito),
						// la definimos como una manera de tener un "contenedor" de métodos
						// En próxima lecciones veremos las Static Class,
						// de las que podemos invocar sus métodos sin necesidad de instanciar la Class

			// Método que calcula el área de un rectángulo definido por el Obj de la Class
			// Point
			// Coordenadas origen siempre son (0,0), vertice opuesto es el definido por el
			// Obj Point
			public int areaPunto(Point puntoA) { // Recibe la referencia a un Obj de Class Point

				return Math.abs(puntoA.posicionX * puntoA.posicionY); // Valor absoluto de base * altura
			}

			// Método que genera un nuevo Punto a partir de la resta de dos Puntos
			public Point restaPuntos(Point puntoA, Point puntoB) {

				return new Point((puntoA.posicionX - puntoB.posicionX), (puntoA.posicionY - puntoB.posicionY)); // Retorna
																												// un
																												// Obj
																												// (la
				// referencia al Obj)
			}

		} // class Utiles

		// Ejemplos de uso de los métodos de la Clase Utiles

		Utiles utilities = new Utiles(); // Objeto Utiles, del que usaremos sus métodos,
		Point puntito1 = new Point(2, 2); // Obj Punto
		Point puntito2 = new Point(4, 4); // Obj Punto

		puntito1.showPoint();
		System.out.println("Area = " + utilities.areaPunto(puntito1)); // Area que define el Punto pt1
		puntito2.showPoint();
		System.out.println("Area = " + utilities.areaPunto(puntito2)); // Area que define el Punto pt2

		Point puntito3 = utilities.restaPuntos(puntito1, puntito2); // Punto resultante de la resta del Punto pt1 y
																	// Punto pt2
		puntito3.showPoint();
		System.out.println("Area = " + utilities.areaPunto(puntito3)); // Area que define el nuevo Punto pt3

	} // public static void main

} // public class Leccion_7