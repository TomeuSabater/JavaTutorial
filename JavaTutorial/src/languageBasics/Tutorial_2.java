package languageBasics;

import java.util.Scanner;

public class Tutorial_2 {

	public static void main(String[] args) {
		// Estructuras de control: if, if else, if else if
		// Estructuras de repetición: for, Do While
		// Operaciones de captura de número por pantalla
		
		// Estructuras de repetición DO WHILE
		// bucle QUE ENTRA  se repite mientras se cumpla una condición
		
		// Sintaxis;
		// do {
		//		statements(); 
		// while (condición); 
		
		/*
		do {
			System.out.println("no paro");
		} while (true); 
		
		*/ 
		
		int v_entero = 0; 
		do {
			System.out.println(v_entero++);
			if (v_entero > 9) break; 
		} while (true); 		
		
		// Ahora bien hecho
		
		v_entero = 0; 
		do {
			System.out.println(v_entero++);
		} while (v_entero < 10 );
		
		// Cuando uso FOR? cuándo uso WHILE? 
		
		// Pedimos un número al usuario y 
		// Mostramos si es par o es impar
		// Acaba cuando usuario teclea un 0 
			
		Scanner entrada = new Scanner(System.in); 
		
		/*
		int v_entrada; 
		
		do {
			System.out.println("Teclea un número :");
			v_entrada = entrada.nextInt(); 
			if (v_entrada % 2 == 0) {
				System.out.println(v_entrada + " Es par");
			} else {
				System.out.println(v_entrada + " Es impar");
			}
		} while (v_entrada != 0);
		System.out.println("Fin");

		
		
		// Mejora
		// Si es par
		// Si es impar
		// Si es cero
		// Y acaba con negativo 
		
		/*
		do {
			System.out.println("Teclea un número :");
			v_entrada = entrada.nextInt(); 
			if (v_entrada == 0) {
				System.out.println(v_entrada + " Es cero");
			} else {
				if (v_entrada % 2 == 0) {
					System.out.println(v_entrada + " Es par");
				} else {
					System.out.println(v_entrada + " Es impar");
				}
			}
		} while (v_entrada >= 0); // hasta que sea negativo 
		System.out.println("Fin");
		entrada.close();
		
		*/ 
		// Mejor estructurado 
		
		/*
		do {
			System.out.println("Teclea un número :");
			v_entrada = entrada.nextInt(); 
			if (v_entrada == 0) {
				System.out.println(v_entrada + " Es cero");
			} else if (v_entrada % 2 == 0) {
				System.out.println(v_entrada + " Es par");
			} else {
				System.out.println(v_entrada + " Es impar");
			}
		} while (v_entrada >= 0); // hasta que sea negativo 
		System.out.println("Fin");
		entrada.close();
		
		//else if llevado al extremo
				//Pedimos número al usuario y 
				//Si es uno mostramos "es un uno"
				//Si es dos mostramos "es un dos"
				//Si es tres mostramos "es un tres"
				//Si es cuatro mostramos "es un cuatro"
				//Acaba cuando introduce un número mayor que cuatro o menor que uno. 

				
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
		
		// Para acabar 
		// Tenemos un array unidimensional de C_NUM posiciones
		// Rellenarlo con valores aportados por el usuario 
		// Acabamos cuando usuario teclea 0 o cuando ya no hay más espacio en array
		
		final int C_NUM = 5; // Tamaño del array 
		int[] a_enteros = new int[C_NUM]; //Array de enteros, contiene entradas usuario
		int indice = 0; // índice para control posición array, indexar el array
		
		do {
			System.out.println("Teclea número para vector:"); 
			v_entero = entrada.nextInt(); 
			a_enteros[indice++] = v_entero; 
		} while (v_entero != 0 && indice < a_enteros.length); // (Teclea no 0) Y (array NO lleno)
		
		// y evidentemente, mostramos el contenido
		for (int a : a_enteros) {
			System.out.println(a); 
		}
		
		
		
		
		

		
		
		

		
		
		
		

	}

}
