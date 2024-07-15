package Leccion_12_Ejercicio_bis_bis_bis;

public class Ejercicio_12_bis_bis_bis {

	
	// Tenemos como objetivo indagar más sobre las Nested Class
	// Aplicamos una Inner Class para analizar su comportamiento y posibilidades
	
	// Tenemos una Class Cuadriátero (un polígono con cuatro aristas y cuatro vértices)
	// 	que contiene una Inner Class denominada Class Punto que define cada uno de los vértices 
	
	
	public static void main(String[] args) {
		
		// Definimos un primer cuadrilátero
		Cuadrilatero c1 = new Cuadrilatero(1,2,3,4,5,6,7,8); 
		c1.pintaCuadrilatero();
		
		// Definimos un segundo cuadrilátero
		Cuadrilatero c2 = new Cuadrilatero(3,5,7,8,9,-1,7,8); 
		c2.pintaCuadrilatero();
	}

}
