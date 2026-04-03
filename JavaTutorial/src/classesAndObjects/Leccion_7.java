package classesAndObjects;

class Leccion_7 {

	public static void main(String[] args) {

		// Introducción_IV a CLASES Y OBJETOS.

		// Sobrecarga de Constructores
		// Nombre de los métodos
		// Nested Class (Clases Anidadas)
		// Ciclo de Vida de un Objeto:
		// Declaración, Instanciación e Inicialización de Objetos.
		// Uso del Objeto, Destrucción del Objeto
		// Encapsulación de Objetos
		// Operador Ternario condición ? valor_si_verdadero : valor_si_falso
		// Métodos void, return, void con return
		// Métodos con Obj como parámetros de entrada
		// Métodos que retornan Obj
		// Class sin Constructor (como repositorios de métodos)
		// Creación de Obj para uso de métodos
		// "This" en Constructores

		class Point {
			// Define un punto (x,y) en el espacio

			// Variables de Class, y Ctes.
			static final String ELEMENTO = "PuntoXY";

			// Variables de Instancia, privadas
			private int posicionX = 0;
			private int posicionY = 0;

			// Constructor
			public Point(int valorX, int valorY) {

				this.posicionX = valorX; // Obviamos setter
				this.posicionY = valorY; // Obviamos setter
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

				System.out.println(Point.ELEMENTO); // Se acompaña del nombre de la Class
				System.out.println(this); // Se muestra la referencia de este Obj
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
										// Recordar que no es el Obj Point, es la referencia (puntero) al Obj Point
			private int valorArea; // Área del rectángulo

			// Métodos constructores x 5, Sobrecargamos el Constructor 5 veces

			// Constructor "predilecto"; punto origen, alto y ancho
			// y el resto de constructores se basarán en este
			public Rectangle(Point punto, int ancho, int alto) { // Origen, anchura y altura

				// Obviamos setters, es un ejemplo teórico
				this.valorAncho = ancho;
				this.valorAlto = alto;
				this.puntoOrigen = punto;
				this.valorArea = getArea(); // Invocamos un método para calculo área
			}

			public Rectangle(int alto, int ancho) { // Solo altura y anchura

				// Obviamos setters, es un ejemplo práctico
				this.valorAncho = ancho;
				this.valorAlto = alto;
				this.puntoOrigen = new Point(0, 0); // Instanciamos Class para Obj puntoOrigen
				this.valorArea = getArea(); // Invocamos un método para calculo área
			}

			public Rectangle() { // Sin ningún valor

				this(0, 0); // Llamamos a otro constructor
							// El "this" para llamar a otro constructor debe ser la primera instrucción
			}

			public Rectangle(Point p) { // Solo punto de origen

				this(p, 1, 1); // Llamamos al constructor "predilecto"
			}

			public Rectangle(int valorX, int valorY, int ancho, int alto) { // coordenadas origen, alto y ancho

				this(new Point(valorX, valorY), ancho, alto); // Llamamos al constructor "predilecto"
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
				// Es un ejemplo ya que bien codificado bastaría con :
				// return (this.alto * this.ancho);
			}

			// Desplaza el rectángulo
			public void moveRectangle(int deltaX, int deltaY) {

				this.puntoOrigen.movePoint(deltaX, deltaY); // Invocamos el método movePoint del Obj 'origen'
				return; // Aún siendo un método "void" es posible añadir la cláusula return para indicar
						// la finalización del método
				// this.origen.movePoint(dX*2, dY*2); // Este código sería inaccesible, el
				// return fuerza la salida del método
			}

			// Muestra el rectángulo
			public void showRectangle() {

				System.out.println(Rectangle.ELEMENTO);
				System.out.println(this); // Se muestra la referencia de este Obj
				this.puntoOrigen.showPoint(); // Mostramos los valores del Obj punto Origen
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
									// se almacena en la variable "punto1"
									// en la creación "new" se invoca automáticamente al método constructor para
									// inicializar el Obj recién creado. Este Obj es accesible desde el cuerpo
									// principal del programa

		// Obviamente se puede hacer todo junto; Declaración, instanciación e
		// inicialización
		// La variable punto2 es de type Class Point; Referenciará a un Obj de tipo
		// Point
		Point punto2 = new Point(1, 1); // Accesible desde el cuerpo principal del programa

		// Llamadas a métodos de los Objetos recién creados
		punto1.showPoint();
		System.out.println();
		punto2.showPoint();
		System.out.println();

		// Llamamos al método que "mueve" el Obj Point
		punto1.movePoint(-1, 2); // Movemos a nueva posición (2,6)
		punto2.movePoint(2, 3); // Movemos a nueva posición (3,4)

		// Comprobamos nuevos valores
		punto1.showPoint();
		System.out.println();
		punto2.showPoint();
		System.out.println();

		// Creamos un Obj de Class Rectangle que tiene como origen el Obj de Class Point
		// recién creado "punto1"
		Rectangle rectangulo1; // Obj de tipo Class Rectangle
		rectangulo1 = new Rectangle(punto1, 5, 8); // Instanciación con llama al constructor

		// El Obj rectangulo1 tiene como origen a Obj punto1
		// El Obj punto1 existe fuera del Obj rectangulo1
		// punto1 NO está encapsulado en rectangulo1

		// Veamos los valores del Obj rectangulo1
		rectangulo1.showRectangle();

		// Podemos "manipular" el Obj punto1 desde fuera del Obj rectangulo1
		// e indirectamente estamos manipulando el Obj rectangulo1
		// Si movemos punto1 también movemos el punto origen del rectangulo1
		punto1.movePoint(1, 1);
		System.out.println();
		punto1.showPoint();
		System.out.println();
		rectangulo1.showRectangle(); // También he movido el Obj rectangulo1
		System.out.println();

		// Ahora mismo tenemos un Obj punto1 de Class Point al que podemos
		// referenciarlo desde dentro/fuera del rectángulo
		// Es el mismo Obj

		// Si muevo el Obj rectangulo1 también muevo el Obj punto1
		rectangulo1.moveRectangle(-1, -1); // Lo devuelvo a su posición original
		punto1.showPoint();
		System.out.println();
		rectangulo1.showRectangle(); // También se ha movido
		System.out.println();

		// Si destruyo el Obj rectangulo1 el Obj punto1 sigue existiendo
		rectangulo1 = null; // Matamos el Obj rectangulo1
		// rectangulo1.showRectangle(); // Es inalcanzable, error de runtime
		punto1.showPoint(); // Sin problema, sigue existiendo
		System.out.println();

		// Creamos un Rectángulo sin proporcionar el Obj puntoOrigen
		Rectangle rectangulo2 = new Rectangle(1, 2, 3, 4);
		rectangulo2.showRectangle();
		System.out.println();

		// En este caso, el Obj puntoOrigen del Obj rectangulo2 es inaccesible desde el
		// exterior. No tenemos su referencia ni tenemos un método tipo getPuntoOrigen()
		// que nos lo devuelva.
		// No podemos invocar movePoint() desde fuera del Obj rectangulo2
		// porque no tenemos la referencia del Obj puntoOrigen desde fuera del ObJ
		// rectangulo2
		// Diremos que el Obj puntoOrigen está encapusulado en el Obj rectangulo2

		// Vamos a manipularlo
		rectangulo2.moveRectangle(+1, +1);
		rectangulo2.showRectangle();
		System.out.println();

		// Cosas que Java permite y no son muy aconsejables,
		// más adelante veremos las Anonymous Class y las Lambda Expression que
		// formalizan este tipo de expresiones.

		new Rectangle(1, 1).showRectangle(); // Instanciamos un Objeto, llamamos a un método, pero no guardamos su
												// referencia. Un Obj sin referencia la JVM libera los recursos.

		int area = new Rectangle(2, 3).getArea(); // Calculamos el área de un rectángulo sin instanciarlo
		System.out.println();
		System.out.println("Area = " + area);
		System.out.println();

		// Cuando un Objeto es inalcanzable, no tenemos ninguna referencia al mismo,
		// la JVM automáticamente se encarga de destruirlo (eliminar los recursos que
		// utiliza) "The Java runtime environment deletes objects when it determines
		// that they are no longer being used."
		// This process is called "Garbage Collection".
		// Una manera de "destruir" un Objeto de manera explícita es mediante la
		// asignación del valor "null" a todas las variables que lo refrencian.
		// Veamos un ejemplo:

		punto1 = null; // Todavía había una referencia a punto1 dentro de rectangulo1
		rectangulo2 = null; // Indiréctamente, elimina la referencia a puntoOrigen
		System.out.println("Objetos destruidos");
		System.out.println();

		// Un método puede recibir un Obj como parámetro y también puede devolver un Obj
		// Ejemplo; Definimos una Class Utiles para que nos proporcione métodos que
		// gestionan Obj de la Class Point.
		// De la Class Utiles que definimos no nos interesará tanto los Obj instanciados
		// como sus métodos.
		// El Obj que instanciamos se puede ver como un 'contenedor' de métodos
		// genéricos

		class Utiles {// Esta Class no tiene constructor (es implícito),
			// la definimos como una manera de tener un "contenedor" de métodos
			// En próxima lecciones veremos las Static Class, de las que podemos invocar sus
			// métodos sin necesidad de instanciar la Class

			public int areaPunto(Point puntoA) { // Recibe la referencia a un Obj de Class Point
				// Método que calcula el área del rectángulo definido por el Obj Point donde el
				// vértice opuesto es (0.0)

				return Math.abs(puntoA.posicionX * puntoA.posicionY); // Valor absoluto de base * altura
																		// Class Point no tiene getPosicionX(),
																		// getPosicionY()
			}

			public Point restaPuntos(Point puntoA, Point puntoB) {
				// Método que genera un nuevo Punto a partir de la resta de dos Obj Point
				// devuelve un Obj Point

				return new Point((puntoA.posicionX - puntoB.posicionX), (puntoA.posicionY - puntoB.posicionY));
			}

		} // class Utiles

		// Ejemplos de uso de los métodos de la Clase Utiles

		Utiles utilities = new Utiles(); // Objeto Utiles, del que usaremos sus métodos,
		Point puntito1 = new Point(2, 2); // Obj Point
		Point puntito2 = new Point(4, 4); // Obj Point

		puntito1.showPoint();
		System.out.println("Area = " + utilities.areaPunto(puntito1)); // Area que define puntito1
		System.out.println();
		puntito2.showPoint();
		System.out.println("Area = " + utilities.areaPunto(puntito2)); // Area que define puntito2

		Point puntito3 = utilities.restaPuntos(puntito1, puntito2); // Punto resultante de la resta de puntito1 y
																	// puntito2
		puntito3.showPoint();
		System.out.println("Area = " + utilities.areaPunto(puntito3)); // Area que define el nuevo Punto pt3

	} // public static void main

} // public class Leccion_7
// Pasar a leccion_8