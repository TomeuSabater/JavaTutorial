package languageBasics;

import java.util.Scanner;

public class Leccion_2 {

	public static void main(String[] args) {
		
		// ESTRUCTURAS DE CONTROL; If, If Else, If Else If
		// ESTRUCTURA DE REPETICION: Do While
		// OPERACIONES DE CAPTURA DE NÚMEROS POR ENTRADA DE USUARIO

		
		//Estructuras de Repeticion DO WHILE
		// bucle que se repite mientras se cumpla una condición
		
		/* Sintaxis::
		 * do {
		 * 	statement(s)
		 * } while (expression)  
		 */
		
		/*
		do {
			System.out.println("Esto se ejecuta siempre, no para");
		} while(true);
		*/ 
		
		//El DO WHILE, se repite como mínimo una vez, itera como mínimo una vez
		//Recordar que el FOR, por el contratrio, puede no comenzar nunca
		//DO WHILE no puedes evitar que entre como mínimo una vez. 

		do  {
			System.out.println("Como mínimo me ejecuto una vez");
			break;
		} while (true);
		
		 
		//Veamos ejemplo de cómo romper la iteración  
		//Mostramos los primeros 10 números enteros (0,1,2...9)
		
		int v_entero = 0;
		do {
			System.out.println(v_entero++);
			if (v_entero > 9) {
				break;
			}
		} while(true);
		
		//Mismo ejemplo, ahora codificaremos el do while de manera más formal
		System.out.println();
		v_entero = 0;
		do {
			System.out.println(v_entero++);
		} while (v_entero < 10);
		
				
		//La diferencia entre un For y un Do While
		//Do While no hay inicializaciones
		//Do While nosotros controlamos el incremento
		//Do While se ejecuta al menos una vez. 
		//For es más adecuado cuando sabemos el número de iteraciones (p.ej. recorrer un array)
		//Do While es más adecuado cuando no sabemos "a priori" el número de iteraciones 
		
		//Ejemplo de Do While, en el que no sabemos el número de iteraciones
		//Pedimos un número a usuario, 
		//Mostramos si es para, si es impar, y cuando introduzca "0" es que quiere parar 
		
		Scanner entrada = new Scanner(System.in);
		int v_entrada; //Variable con valor aportado por usuario 
		
		/*
		do {
			System.out.println("Teclea un número :");
			v_entrada = entrada.nextInt();
			if (v_entrada %2 == 0) {
				System.out.println(v_entrada + " Es par");
			} else {
				System.out.println(v_entrada + " Es impar");
			}
		} while (v_entrada != 0);
		System.out.println("Fin"); 
		entrada.close();
		*/ 
				
		
		//Mejoramos el do while, ahora hacemos lo mismo pero
		//Si es par, decimos que es par
		//Si es impar, decimos que es impar
		//Si es cero, decimos que es cero
		//El usuario acaba cuando teclea un número negativo
		
		/*
		System.out.println();
		do {
			System.out.println("Teclea un número :");
			v_entrada = entrada.nextInt();
			if (v_entrada == 0) {
				System.out.println(v_entrada + " Es cero");
			} else {
				if (v_entrada %2 == 0) {
					System.out.println(v_entrada + " Es par");
				} else {
					System.out.println(v_entrada + " Es impar");
				}
			}
		} while (v_entrada >= 0);
		System.out.println("Fin"); 
		entrada.close(); 
		
		*/  
		
		/* 
		
		//La estrucutra "else { if " se puede mejorar en Java con un "else if"
		System.out.println();
		do {
			System.out.println("Teclea un número :");
			v_entero = entrada.nextInt();
			if (v_entero == 0) {
				System.out.println(v_entero + " Es cero");
			} else if (v_entero %2 == 0) {
					System.out.println(v_entero + " Es par");
				} else {
					System.out.println(v_entero + " Es impar");
			}
			
		} while (v_entero >= 0);
		System.out.println("Fin"); 
		entrada.close(); 
		*/ 
		
		
		//else if llevado al extremo
		//Pedimos número al usaurio y 
		//Si es uno mostramos "es un uno"
		//Si es dos mostramos "es un dos"
		//Si es tres mostramos "es un tres"
		//Si es cuatro mostramos "es un cuatro"
		//Acaba cuando introduce un número mayor que cuatro o menor que uno. 

		/* 
		System.out.println();
		do {
			System.out.println("Teclea un número :");
			v_entero = entrada.nextInt();
			if (v_entero == 1) {
				System.out.println(v_entero + " Es uno");
			} else {
				if (v_entero == 2) {
					System.out.println(v_entero + " Es dos");
				} else {
					if (v_entero == 3) {
						System.out.println(v_entero + " Es tres");
					} else {
						if (v_entero == 4) {
							System.out.println(v_entero + "Es cuatro");
						}
					}
				}
			} 
		} while (v_entero >= 1 && v_entero <= 4);
		System.out.println("Fin"); 

		
		//Ahora bien hecho con el "else if"
		System.out.println();
		do {
			System.out.println("Teclea un número :");
			v_entero = entrada.nextInt();
			if (v_entero == 1) {
				System.out.println(v_entero + " Es uno");
			} else if (v_entero == 2) {
				System.out.println(v_entero + " Es dos");
			} else if (v_entero == 3) {
				System.out.println(v_entero + " Es tres");
			} else if (v_entero == 4) {
				System.out.println(v_entero + "Es cuatro");
			}
		} while (v_entero >= 1 && v_entero <= 4);
		System.out.println("Fin"); 
		entrada.close();  
		
		*/ 
		
	    //Para acabar, 
		//Tenemos un array unidimensional de CNUM posiciones 
		//y lo rellenamos con valores positivos proporcionados por el usuario
		//Acabamos cuando el usuario teclea "0", o cuando ya no hay más espacio en el array
		
		final int CNUM = 5; //tamaño del array, es una cte 
		int[] a_enteros = new int[CNUM]; //array de enteros
		int indice = 0; //indice del array
		do {
			System.out.println("Teclea un número: ");
			v_entero = entrada.nextInt();
			a_enteros[indice++] = v_entero;
		} while (indice < a_enteros.length && v_entero != 0);
		
		//Y evidentemete mostramos el contenido de a_enteros
		for (int variable : a_enteros) {
			  System.out.println(variable);
		  }
		
	    // Próxima lección Switch, Break, Break y Continue,  Arrays Multidimensionales. 
		
	} // public static void main

} //public class Leccion_2

