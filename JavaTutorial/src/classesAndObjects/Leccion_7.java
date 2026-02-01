package classesAndObjects;

class Leccion_7 {

	public static void main(String[] args) {

		// Introducción_IV a CLASES Y OBJETOS. 
		
		// Sobrecarga de Constructores
		// Nombre de los métodos
		// Nested Class (Clases Anidadas) 
		// Ciclo de Vida de un Objeto: 
		// 		Declaración, Instanciación e Inicialización de Objetos.  
		// 		Uso del Objeto
		// 		Destrucción del Objeto 
		// Operador Ternario condición ? valor_si_verdadero : valor_si_falso
		// Métodos void, return, void con return
		// Métodos con Obj como parámetros de entrada
		// Métodos que retornan Obj
		// Class sin Constructor (como repositorios de métodos) 
		// "This" en Constructores
		
		
		class Point {
			//Define un punto (x,y) en el espacio
			
			//Variables de Class, y Ctes. 
			static final String FIGURA = "Punto"; 
			
			//Atributos de Instancia, privados
			private int x = 0; 
			private int y = 0;
			
			//Constructor
			public Point(int a, int b) {
				
				this.x = a; 
				this.y = b; 
			}
			
			//Métodos públicos
			
			//Movemos la posición de punto un dX, dY
			//Nombre método es un verbo descriptivo, palabra compuesta en mayúsculas
			public void movePoint(int dX, int dY) {
				
				this.x += dX; //Incremento delta X
				this.y += dY; //Incremente delta Y 
			}
			
			//Mostramos el Punto
			//Nombre método es un verbo descriptivo, palabra compuesta en mayúsculas
			public void showPoint() {
				
				System.out.println(this.FIGURA);
				System.out.println("X = " + this.x);
				System.out.println("Y = " + this.y);
			}
			
		} //class Point
		
		class Rectangle {
			//Define un Rectángulo a partir de un punto en el espacio, altura y anchura
			
			//Variables de Class, y Ctes. 
			static final String FIGURA = "Rectángulo"; 
			
			//Variables de Instancia, privados
			private int alto; //Define la altura
			private int ancho; //Define la anchura
			private Point origen; //Posición en el plano del vértice origen del rectángulo, es un Obj
									//Realmente no es el Obj Point, es la referencia (puntero) al Obj Point
			private int area; //Área del rectángulo 
		
			
			//Métodos constructores x 5, Sobrecargamos el Constructor
			
			// Constructor "predilecto", punto origen, ancho y alto
			// El resto de constructores se basan en este
			public Rectangle(Point p, int w, int h) { //Origen, altura y anchura
				this.ancho = w; 
				this.alto = h; 
				this.origen = p; 
				this.area = getArea(); 
			}
			
			public Rectangle() { //Sin valores
				this(0,0);		// Llamamos a otro constructor 
				 				// El "this" para llamar a otro constructor debe ser la primera instrucción
								// No se pueden "encadenar" constructores
			}
			
			public Rectangle(int w, int h) { //Solo altura y anchura
				this.ancho = w; 
				this.alto = h; 
				this.origen = new Point(0,0);
				this.area = getArea();
			}
			
			public Rectangle(Point p) { //Solo punto de origen
				this(p,0,0); // Llamamos al constructor "predilecto"
			}
						
			public Rectangle(int x, int y, int w, int h) { //coordenadas origen, alto y ancho
				
				this(new Point(x,y), w, h); // Llamamos al constructor "predilecto" 
			}


			// Métodos públicos
			
			// Calcula área del rectángulo
			public int getArea() {
				//Ejemplo de utilización del operador ternario de Java
				// Sintaxis:
				//		condición ? valor_si_verdadero : valor_si_falso;
				//  	String mensaje = (edad >= 18) ? “Eres mayor de edad” : “Eres menor de edad”;
				
				return (this.alto == 0 || this.ancho == 0) ? 0 : (this.alto * this.ancho);
				
				/* El código anterior substituye al siguiente bloque de código
				if (this.alto == 0 || this.ancho == 0) {
					return 0; 
				} else {	
					return (this.alto * this.ancho); 
				} 
				*/ 
				//Es evidente que aplicando refactorización obtendríamos:
				//	el operador ternario es un ejemplo
				// 	bien codificado bastaría con : return (this.alto * this.ancho);
			}
			
			// Desplaza el rectángulo
			public void moveRectangle(int dX, int dY) {  
				
				this.origen.movePoint(dX, dY); //Invocamos el método movePoint del Obj 'origen'
				return; //Aún siendo un método "void" es posible añadir la cláusula return para indicar la finalización del método  
				//this.origen.movePoint(dX*2, dY*2); // Este código sería inaccesible, el return fuerza la salida del método
			}
			
			// Muestra el rectángulo
			public void showRectangle() {
				
				System.out.println(Rectangle.FIGURA); 
				this.origen.showPoint();
				System.out.println("Ancho = " + this.ancho);
				System.out.println("Alto = " + this.alto);
				System.out.println("Área = " + this.area); 
				return; //Aún siendo "void", es posible añadir la cláusula return para indicar la finalización del método 
			}
			
		} //class Rectangulo
		
		
		//Creamos un Objeto p1 a partir de la Clase Point 
		//Recordamos que "p1" no es el Obj, es la variable que identifica el Obj; su referencia
		
		Point p1; //Declaración, la variable p1 es de type Class Point; Referenciará a un Obj de tipo Point
		p1 = new Point(3,4); //Instanciación e Inicialización, 
							//"new" instancia la Class (crea el Obj) y devuelve una referencia al Obj que se almacena en la variable "p1" 
							//en la creación "new" se invoca automáticamente al método constructor para inicializar el Obj recién creado 
		
		//Obviamente se puede hacer todo junto; Declaración, instanciación e inicialización
		//La variable p2 es de type Class Point; Referenciará a un Obj de tipo Point
		Point p2 = new Point(1,1); 
				
		//Llamadas a métodos de los Objetos
		p1.showPoint();
		p2.showPoint(); 
				
		//Creamos un Obj de Class Rectangle que tiene como origen el Obj de Class Point recién creado
		Rectangle r1; //Declaración de variable r1; es una variable de tipo Class Rectangle  
		r1 = new Rectangle(p1, 5, 8); 	//Instanciación ("new") de la Class Rectangle que crea el Obj con referencia r1
										// e inicialización del mismo mediante llamada a su constructor
		
		//Obviamente, se puede hacer todo junto
		Rectangle r3 = new Rectangle(p2, 3, 5); //Declaración, instanciación, inicialización. Obj de Class Rectangle, referenciado por r3.  
		
		//Llamadas a métodos de los Obj recién creados
		r1.showRectangle();
		r3.showRectangle();
		
		
		//Ahora mismo tenemos un Obj de Class Point al que, y mediante p1, podemos referenciarlo desde dentro/fuera del rectángulo 
		//Es el mismo Obj
		
		//Movemos el punto "p1" y también moveremos el punto "origen" del Rectángulo, porque son el mismo Objeto
		p1.movePoint(1, 1);
		p1.showPoint();
		r1.showRectangle();
		
		//Movemos el punto "origen" del rectángulo y también movemos el punto "p1", son el mismo Objeto 
		r1.moveRectangle(-1, -1);
		r1.showRectangle();
		p1.showPoint();
		
		//Creamos un Rectángulo sin tener su punto de "origen"
		Rectangle r2 = new Rectangle(1,2,3,4); 
		r2.showRectangle();
		
		//En este caso, el punto "origen" del rectángulo r2 es inaccesible desde el exterior
		//No tenemos su referencia ni tenemos un getOrigen() que nos la devuelva
		//No podemos invocar movePoint() desde fuera del Objeto r2 porque no tenemos la referencia de "origen" desde fuera de r2
		r2.moveRectangle(+1, +1);
		r2.showRectangle();
		
		
		//Cosas que Java permite y no son muy aconsejables, 
		//	más adelante veremos las Anonymous Class y las Lambda Expression que formalizan este tipo de expresiones. 
		new Rectangle(1,1).showRectangle(); //Instanciamos un Objeto de tipo Rectángulo, lo mostramos pero no guardamos su referencia
											//Al tener un Objeto sin referencia, la JVM liberará los recursos que utiliza de manera inmediata
		int area = new Rectangle(2,3).getArea(); //Instanciamos un Objeto de tipo Rectángulo, 
												// podría servir para tener una herramienta para calcular el área de un rectángulo
												// sin necesidad de almacenar el Obj rectángulo 
		System.out.println("Area = " + area); 
		
		//Cuando un Objeto es inalcanzable, no tenemos ninguna referencia al mismo, 
		//	la JVM automáticamente se encarga de destruirlo (eliminar los recursos que utiliza)
		//The Java runtime environment deletes objects when it determines that they are no longer being used. 
		//This process is called "Garbage Collection".
		//Una manera de "destruir" un Objeto de manera explícita es mediante la asignación del valor "null" 
		//	a todas las variables que lo refrencian. Veamos un ejemplo
		
		p1 = null; //Todavía hay una referencia a p1 dentro de r1
		p2 = null; 
		r1 = null; //Indiréctamente, elimina la referencia a p1, que queda ahora sin ninguna referencia
		r2 = null; 
		r3 = null; 
		System.out.println("Objetos destruidos"); 
		
		
		//Un método puede recibir un Obj como parámetro y también puede devolver un Obj
		//Ejemplo; Creamos una Class Utiles para que nos proporcione métodos que gestionan Obj
		//De la Class Utiles que definimos no nos interesará tanto los Obj como sus métodos
		//El Obj que instanciamos se puede ver como un 'contenedor' de métodos genéricos
		
		class Utiles { 	// Esta Class no tiene constructor (es implícito), 
						// 	la definimos como una manera de tener un "contenedor" de métodos
						// En próxima lecciones veremos las Static Class, 
						//	de las que podemos invocar sus métodos sin necesidad de instanciar la Class
						
			//Método que calcula el área de un rectángulo definido por el Obj de la Class Point
			//Coordenadas origen siempre son (0,0), vertice opuesto es el definido por el Obj Point
			public int areaPunto(Point a) { // Recibe la referencia a un Obj de Class Point
				
				return Math.abs(a.x * a.y); //Valor absoluto de base * altura
			}
			
			
			//Método que genera un nuevo Punto a partir de la resta de dos Puntos
			public Point restaPuntos(Point a, Point b) {
				
				return new Point((a.x - b.x), (a.y - b.y)); // Retorna un Obj (la referencia al Obj)
			}
			
		} //class Utiles
		
		//Ejemplos de uso de los métodos de la Clase Utiles
		
		Utiles ut = new Utiles(); //Objeto Utiles, del que usaremos sus métodos,
		Point pt1 = new Point(2,2); // Obj Punto
		Point pt2 = new Point(4,4); // Obj Punto
	
		pt1.showPoint();
		System.out.println("Area = " + ut.areaPunto(pt1)); //Area que define el Punto pt1
		pt2.showPoint();
		System.out.println("Area = " + ut.areaPunto(pt2)); //Area que define el Punto pt2	
		
		Point pt3 = ut.restaPuntos(pt1, pt2); //Punto resultante de la resta del Punto pt1 y Punto pt2
		pt3.showPoint();
		System.out.println("Area = " + ut.areaPunto(pt3)); //Area que define el nuevo Punto pt3

	} //public static void main
	
} // public class Leccion_7 