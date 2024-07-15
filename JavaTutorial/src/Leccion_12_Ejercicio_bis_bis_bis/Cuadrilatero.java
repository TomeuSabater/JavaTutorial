package Leccion_12_Ejercicio_bis_bis_bis;

public class Cuadrilatero {
	
	// Define la figura geométrica de un cuadrilatero
	// un cuadrilátero es un polígono con cuatro aristas y cuatro vértices. Ejemplos:
	//	Cuadrado, Rectángulo, Rombo, Romboide, Trapecios, Trapezoides, etc. 

	// Ctes
	static final String FIGURA = "Cuadrilátero"; // Define el elemento
	static final byte NUM_VERTICES = 4; // Define número máximo de vertices (puntos)
	
	// Atributos de Instancia
	private Point[] Puntos = new Point[Cuadrilatero.NUM_VERTICES]; //Array de Objetos Point
		
		//// Inner Class
		
		private class Point {
			
			// Ctes
			static final String FIGURA = "Punto";
			
			//Atributos de Instancia
			int pX = 0; // Posición X en el plano
			int pY = 0; // Posición Y en el plano
			
			// Constructor
			Point(int i, int j) {
				
				this.pX = i;
				this.pY= j; 
			}
			
			// Método públicos
			public void pintaPunto() {
				
				System.out.println("\n" + Point.FIGURA);
				System.out.println("X : " + this.pX);
				System.out.println("Y : " + this.pY); 
			}
			
		} // private class Point 
	
		// Constructor 
		Cuadrilatero(int i, int j, 
					int k, int l, 
					int m, int n, 
					int o, int p) {
			
			this.Puntos[0] = new Point(i, j); 
			this.Puntos[1] = new Point(k, l);
			this.Puntos[2] = new Point(m, n);
			this.Puntos[3] = new Point(o, p);
		}
		
		// Métodos públicos
		
		public void pintaCuadrilatero() {
			
		    System.out.println(Cuadrilatero.FIGURA);
			// Recorremos el array de puntos Puntos
			for (Point p: Puntos) {
				p.pintaPunto();
			}
		} // public void pintaCuadrilatero()
	
} // public class Cuadrilatero 
