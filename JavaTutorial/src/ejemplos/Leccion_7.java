package ejemplos;

public class Leccion_7 {

	public static void main(String[] args) {

		// Introducción_IV a CLASES Y OBJETOS. 
		
		// Sobrecarga de Constructores
		// Objetos anidados 
		// Ciclo de Vida de un Objeto: 
		// 		Declaración, Instanciación e Inicialización de Objetos.  
		// 		Uso del Objeto
		// 		Destrucción del Objeto 
		
		class Point {
			//Define un punto (x,y) en el espacio
			
			//Ctes
			static final String FIGURA = "Punto"; 
			
			//Atributos
			private int x = 0; 
			private int y = 0;
			
			//Constructor
			public Point(int a, int b) {
				this.x = a; 
				this.y = b; 
			}
			
			//Métodos públicos
			public void movePoint(int dX, int dY) {
				this.x += dX; 
				this.y += dY; 
			}
			
			public void showPoint() {
				System.out.println(FIGURA);
				System.out.println("X = " + this.x);
				System.out.println("Y = " + this.y);
			}
			
		} //public class Point
		
		class Rectangle {
			//Define un Rectángulo
			
			//Ctes
			static final String FIGURA = "Rectángulo"; 
			
			//Atributos
			private int alto; //Define la altura
			private int ancho; //Define la anchura
			private Point origen; //Posición en el plano del vértice origen del rectángulo
			private int area; //Area del rectángulo 
		
			//Métodos constructores x 5, Sobrecarga
			public Rectangle() { //Sin valores
				this.ancho = 0; 
				this.alto = 0; 
				this.origen = new Point(0,0); 
				this.area = 0; 
			}
			
			public Rectangle(Point p) { //Solo punto de origen
				this.ancho = 0; 
				this.alto = 0; 
				this.origen = p; 
				this.area = 0; 
			}
			
			public Rectangle(int w, int h) { //Solo altura y anchura
				this.ancho = w; 
				this.alto = h; 
				this.origen = new Point(0,0);
				this.area = getArea(); 
			}
			
			public Rectangle(Point p, int w, int h) { //Origen, altura y anchura
				this.ancho = w; 
				this.alto = h; 
				this.origen = p; 
				this.area = getArea(); 
			}
			
			public Rectangle(int x, int y, int w, int h) { //coordenadas origen, alto y ancho
				
				this.origen = new Point(x, y);
				this.ancho = w; 
				this.alto = h; 
				this.area = getArea(); 
			}
			
			
			//Métodos públicos
			public int getArea() { //Calcula área del rectángulo
				return (this.alto * this.ancho); 
			}
						
			public void moveRectangle(int dX, int dY) { //Desplaza el rectángulo 
				this.origen.movePoint(dX, dY);
			}
			
			public void showRectangle() {
				System.out.println(FIGURA); 
				this.origen.showPoint();
				System.out.println("Ancho = " + this.ancho);
				System.out.println("Alto = " + this.alto);
				System.out.println("Área = " + this.area); 
			}
			
		} //class Rectangulo
		
		
		//Creamos un Objeto p1 a partir de la Clase Point 
		//p1 no es el Objeto, es la variable que identifica el Objeto
		
		Point p1; //Declaración, la variable p1 es de type Point; Referenciará a un Objeto de tipo Point
		p1 = new Point(3,4); //Instanciación e Inicialización, 
							//"new" instancia Clase (crea el Objeto) y devuelve una referencia al Objeto que se almacena en la variable "p1" 
							//en la creación "new" se invoca automáticamente al método constructor para inicializar el Objeto recién creado 
		
		//Obviamente se puede hacer todo junto; Declaración, instanciación e inicialización
		Point p2 = new Point(1,1); 
				
		//Llamadas a métodos de los Objetos
		p1.showPoint();
		p2.showPoint(); 
				
		//Creamos un rectángulo que tiene como origen el punto creado
		Rectangle r1; //Declaración de variable r1; es una variable de tipo Objeto Rectangle  
		r1 = new Rectangle(p1, 5, 8); //Instanciación ("new") de la Clase Rectangle que crea el Objeto e inicialización del mismo mediante llamada a su constructor
		
		//Obviamente, se puede hacer todo junto
		Rectangle r3 = new Rectangle(p2, 3, 5); //Declaración, instanciación, inicialización. 
		
		//Llamadas a métodos del Objeto
		r1.showRectangle();
		r3.showRectangle();
		
		
		//Ahora mismo tenemos un Objeto p1 al que podemos referenciar desde fuera/dentro del rectángulo 
		//Es el mismo objeto
		
		//Movemos el punto "p1" y también moveremos el punto "origen" del Rectángulo, son el mismo Objeto
		p1.movePoint(1, 1);
		p1.showPoint();
		r1.showRectangle();
		
		//Movemos el punto "origen" del rectángulo y también movemos el punto "p1", son el mismo Objeto 
		r1.moveRectangle(-1, -1);
		r1.showRectangle();
		p1.showPoint();
		
		//Creamos un Rectángulo sin tener el punto "origen" ya creado
		Rectangle r2 = new Rectangle(1,2,3,4); 
		r2.showRectangle();
		
		//El punto "origen" del rectángulo r2 es inaccesible desde el exterior
		//No tenemos su referencia ni tenemos un getOrigen() que nos la devuelva
		//No podemos invocar movePoint() desde fuera del Objeto r2 porque no tenemos la referencia de "origen" desde fuera de r2
		r2.moveRectangle(+1, +1);
		r2.showRectangle();
		
		//Cosas que Java permite y no son muy aconsejables
		new Rectangle(1,1).showRectangle(); //Instanciamos un Objeto de tipo Rectángulo, lo mostramos pero no guardamos su referencia
											//Al tener un Objeto sin referencia, la JVM liberará los recursos que utiliza 
		int area = new Rectangle(2,3).getArea(); //Instanciamos un Objeto de tipo Rectángulo, podría servir para tener una herramienta para calcular el área de un Rectángulo
		System.out.println("Area = " + area); 
		
		//Cuando un Objeto es inalcanzable, no tenemos ninguna referencia al mismo, la JVM automáticamente se encarga de destruirlo (eliminar los recursos que utiliza)
		//The Java runtime environment deletes objects when it determines that they are no longer being used. This process is called "Garbage Collection".
		//Una manera de "destruir" un Objeto de manera explícita es mediante la asignación del valor "null" a las variables que lo refrencian. 
		
		p1 = null; //Todavía hay una referencia a p1 dentro de r1
		p2 = null; 
		r1 = null; //Indiréctamente, elimina la referencia a p1, p1 queda ahora sin referencias. 
		r2 = null; 
		r3 = null; 
		System.out.println("Objetos destruidos"); 

	} //public static void main
	
} // public class Leccion_7 