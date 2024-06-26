package ejemplos;

public class Leccion_7 {

	public static void main(String[] args) {

		// Introducción_IV a CLASES Y OBJETOS. 
		
		// Sobrecarga en Constructores
		// Objetos anidados 
		
		class Point {
			//Define un punto x,y en el espacio
			
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
			
		} //public class Point
		
		class Rectangulo {
			//Define un Rectángulo
			
			//Ctes
			static final String FIGURA = "Rectángulo"; 
			
			//Atributos
			private int alto; //Define la anchura
			private int ancho; //Define la altura
			private Point origen; //Posición en el plano del vértice origen del rectángulo
			private int area; //Area del rectángulo 
		
			//Métodos constructores x 4
			public Rectangulo() {
				this.ancho = 0; 
				this.alto = 0; 
				this.origen = new Point(0,0); 
				this.area = 0; 
			}
			
			public Rectangulo(Point p) {
				this.ancho = 0; 
				this.alto = 0; 
				this.origen = p; 
				this.area = 0; 
			}
			
			public Rectangulo(int w, int h) {
				this.ancho = w; 
				this.alto = h; 
				this.origen = new Point(0,0);
				this.area = getArea(); 
			}
			
			public Rectangulo(Point p, int w, int h) {
				this.ancho = w; 
				this.alto = h; 
				this.origen = p; 
				this.area = getArea(); 
			}
			
			//Métodos privados
			private int getArea() { //Calcula área del rectángulo
				return (this.alto * this.ancho); 
			}
						
			//Métodos públicos
			public void moveFigura(int dX, int dY) { //Desplaza el rectángulo 
				this.origen.x += dX; 
				this.origen.y += dY; 
			}
			
			
		} //class Rectangulo

	} //public static void main
	
} // public class Leccion_7 