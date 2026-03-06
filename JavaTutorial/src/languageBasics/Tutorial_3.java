package languageBasics;

import java.util.Scanner;

public class Tutorial_3 {

	public static void main(String[] args) {
		// Estructuras de datos complejas: Arrays Multidimensionales
		// Estructuras de control: Switch, Break, Continue
		
		final byte C_NUM = 4; // Cte de tamaño de arrays
		
		int[] a_enteros = new int[C_NUM]; // Array enteros para ejemplos. Vector
		int[][] a2d_enteros = new int[C_NUM][C_NUM]; // Array 2d de enteros. Matriz 
		
		int variable_entera = 5; 
		
		a_enteros[0] = 1;  // rellenarlo 
		a_enteros[1] = 2;  // rellenarlo 
		a_enteros[2] = 3;  // rellenarlo 
		a_enteros[3] = 4;  // rellenarlo 
		
		int[][] a2d_enteros2 = {{1,2,3,4}, {0,0,0,0}, {9,10,11,12},{13,14,15,0}}; 
		
		// recorremos el array para comprobar su contenido
		
		/*
		for (int i = 0; i < a2d_enteros2.length; i++) {
			for (int j = 0; j < a2d_enteros2[i].length; j++) {
				System.out.println("ad2_enteros2[" + i + "][" + j + "]" + a2d_enteros2[i][j]); 
			}
		}
		
		for (int i = 0; i < C_NUM; i++) {
			for (int j = 0; j < C_NUM; j++) {
				System.out.println("ad2_enteros2[" + i + "][" + j + "]" + a2d_enteros2[i][j]); 
			}
		}
		
		*/ 
		
		int[][] a2d_enteros3 = {{1}, {2,3}, {4,5,6}};
		//  a2d_enteros3[0] = {1}
		//  a2d_enteros3[1] = {2,3}
		//  a2d_enteros3[2] = {4,5,6}

		for (int i = 0; i < a2d_enteros3.length; i++) {
			for (int j = 0; j < a2d_enteros3[i].length; j++) {
				System.out.println("ad2_enteros2[" + i + "][" + j + "]" + a2d_enteros3[i][j]); 
			}
		}
		
		// Ahora estilo javaloya
		byte i, j; // definimos índices para visualización en pantalla
		i = j = 0; // inicializamos índices
		System.out.println("Estilo Javaloya"); 
		for (int fila[] : a2d_enteros3) {
			for (int v_entero: fila) {
				System.out.println("ad2_enteros2[" + i + "][" + j + "] = " + v_entero);
				j++; 
			}
			i++; j=0; // incremento para i, inicialización para j. 
		}
		
		// Para acabar de entender el for estilo "Javaloya", nos atrevemos con una 3x3
		int a3d_enteros[][][] = {{{1},{2,3}},{{4,5,6}},{{7,8},{10,11}}}; 
		
		for ( int d1[][]:a3d_enteros) { // extracción de una matriz
			for (int d2[] : d1) { // extracción de un vector
				for (int v_entero : d2) { //extracción de un elemento 
					System.out.println("a3d_enteros[][][] = " + v_entero);
				}
			}
		}
		
		// Ejercicio: mostrarlo con índices
		
		// ESTRUCTURA DE CONTROL SWITCH
		
		// A diferencia del if, if-else, if-else-if, es que el Switch permite
		// Varios flujos de ejecución
		
		// Sintaxis
		//
		// switch(expresion) {
		// 	case x : code_block;
		//  case y : code_block; break;
		//  default : code_block; break;
		// }
		
		Scanner entrada = new Scanner(System.in); 
		String dia_semana; 
		int v_entrada; 
		
		/*
		do {
			System.out.println("Teclea dia de la semana ");
			v_entrada = entrada.nextInt(); 
			
			switch(v_entrada) {
				case 1 : dia_semana = "Lunes"; break;
				case 2 : dia_semana = "Martes"; break;
				case 3 : dia_semana = "Miercoles"; break;
				case 4 : dia_semana = "Jueves"; break;
				case 5 : dia_semana = "Viernes"; break;
				case 6 : dia_semana = "Sábado"; break;
				case 7 : dia_semana = "Domingo"; break;
				default : dia_semana = "No existe"; break; 
				}
				System.out.println(dia_semana);
		} while (v_entrada > 0 && v_entrada < 8);
		System.out.println("Fin"); 
		
		*/
		// Ahora una mejora para que me muestre lo que me queda hasta el fin de semana
		
		/*
		do {
			System.out.println("Teclea dia de la semana ");
			v_entrada = entrada.nextInt(); 
			dia_semana = ""; 
			
			switch(v_entrada) {
				case 1 : dia_semana = "Lunes y Muy lejos "; 
				case 2 : dia_semana += "Martes y Animo "; 
				case 3 : dia_semana += "Miércoles está Medio hecho "; 
				case 4 : dia_semana += "Jueves Acercándose "; 
				case 5 : dia_semana += "Viernes y No queda nada "; 
				case 6 : dia_semana += "Sábado Fiesta" ; 
				case 7 : dia_semana += "Domingo y Mañana al curro"; break; 
				default : dia_semana = "No existe"; break; 
				}
				System.out.println(dia_semana);
		} while (v_entrada > 0 && v_entrada < 8);
		System.out.println("Fin"); 
		
		*/ 
		
		// Otra ventaja que tiene el switch con el if-else 
		// es la posibilidad de agrupar casos
		
		do {
			System.out.println("Teclea dia de la semana ");
			v_entrada = entrada.nextInt(); 
			dia_semana = ""; 
			
			switch(v_entrada) {
			case 1: case 2 : case 3: case 4: case 5 : dia_semana = "Toca trabjar"; break;
			default : dia_semana ="Fin de semana o no existe"; break;  
			} System.out.println(dia_semana);
		} while (v_entrada > 0 && v_entrada < 8); 
		System.out.println("Fin"); 
		
		// BREAK CONTINUE
		// Aquí para miércoles 11
		
		
		
		
		
	}
}
