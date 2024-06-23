package ejemplos;


import java.util.Scanner;

public class Leccion_3 {

	public static void main(String[] args) {
		
		// ESTRUCTURAS DE CONTROL; SWITCH, BREAK, BREAK CONTINUE
		// ESTRUCTURAS DE DATOS COMPLEJAS: ARRAYS MULTIDIMENSIONALES

		final byte C_NUM = 4; //Constante de uso general durante la lección 
		
		//Veamos como definimos un array multidimensional
		//Recordamos como definiamos un array unidimensional, o vector
		int[] a_enteros = new int[C_NUM]; //Definimos un array unidimensional de CNUM posiciones de enteros
		
		//Para definir un array n-dimensional usamos la misma notación
		int[][] a2d_enteros = new int[C_NUM][C_NUM]; //Array de dos dimensiones de CNUM X CNUM posiciones de enteros.
		
		//Para entender mejor su estructura 
		//Definimos un array de 2 dimensiones con valores iniciales
		int[][] a2d_enteros2 = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		//Hemos definido un array de 2 dimensiones de 3 X 3 números enteros
		//Primera dimensión contiene 3 elementos, cada elemento es a su vez un array unidimensional
		//Segunda dimensión contiene 3 elementos, cada elemento es un entero
		//Es mucho más fácil verlo en forma de árbol
		
		//Como siempre vamos a recorrerlo para rellenarlo con su valor, 
		//La estrategia pasa por la construcción de dos FOR anidados
		//Como 'a priori' sabemos cuántas iteraciones, usamos FOR
		for (int i = 0, k= 0; i < C_NUM; i++) {
			for (int j = 0; j < C_NUM; j++) {
				a2d_enteros[i][j] = k++;
			}
		} 
		
		//Y mostramos su contenido
		for (int i = 0; i < C_NUM; i++) {
			for (int j = 0; j < C_NUM; j++) {
				System.out.println("a2d_enteros[" + i + "][" + j + "]" + a2d_enteros[i][j]);
			}
		}
		
		//Refactorizamos el código anterior
		//Lo rellenamos mediante "length"
		System.out.println();
		for (int i = 0; i < a2d_enteros.length; i++) {
			for (int j = 0; j < a2d_enteros[i].length; j++) {
				System.out.println("a2_enteros[" + i + "][" + j + "]" + a2d_enteros[i][j]);
			}
		}
		
		//Lo recorremos de la manera correcta y específica de Java
		System.out.println();
		for (int fila[] : a2d_enteros) {
			for (int v_entero : fila) {
				System.out.println("a2_enteros[][]=" + v_entero);
			}
		}
		
		System.out.println();
		byte i,j;
		i = j = 0;  
		for (int fila[] : a2d_enteros) {
			for (int v_entero : fila) {
				System.out.println("a2_enteros["+ i + "][" + j + "]=" + v_entero);
				j++; 
			}
			i++; j = 0; 
		}
		
		
		//Quzás definiendo un array n-dimensional que no sea N x N entendamos mejor estas estructuras en Java
		//Fijarse como Java permite definir un array que no es "cuadrado"
		int[][] a2d_enteros3 = {{1},{2,3},{4,5,6}};
		
		//Hemos definido un array de 2 dimensiones
		//La primera dimensión contiene 3 arrays unidimensioneles
		//La segunda dimensión depende de la primera dimensión
		//a2d_enteros[0] = {1}
		//a2d_enteros[1] = {2,3}
		//a2d_enteros[2] = {4,5,6}
		
		//Y aquí cobra sentido el recorrido de un array mediante lengh. 
		System.out.println();
		for (byte ind1 = 0; ind1 < a2d_enteros3.length; ind1++) {
			for (int ind2 = 0; ind2 < a2d_enteros3[ind1].length; ind2++) {
				System.out.println("a2d_enteros3[" + ind1 + "][" + ind2 + "]" + a2d_enteros3[ind1][ind2]);
			}
		}
			
		//Evidentemente, ahora también cobra sentido la manera "correcta" de recorrer un array en Java
		//No tenemos que pensar en el length de cada dimensión
		System.out.println();
		i = j = 0; 
		for (int fila[] : a2d_enteros3) {
			for (int v_entero : fila) {
				System.out.println("a2_enteros3["+ i + "][" + j + "]=" + v_entero);
				j++; 
			}
			i++; j = 0; 
		}
		
		//Nos atrevemos con una array de 3 dimensiones
		int a3d_enteros[][][] = {{{1},{2,3}},{{4,5,6}},{{7,8},{10,11}}};
		
		//Lo recorremos
		System.out.println();
		for (int d1[][] : a3d_enteros) {
			for (int d2[] : d1 ) {
				for (int v_entero : d2) {
					System.out.println("a3d_enteros[][][]=" + v_entero);
				}
			}
		}
		
		
	} // public static void main

} // public class Leccion_3 


