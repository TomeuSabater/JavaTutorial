package languageBasics;


import java.util.Scanner;

public class Leccion_3 {

	public static void main(String[] args) {
		

		// ESTRUCTURAS DE DATOS COMPLEJAS: ARRAYS MULTIDIMENSIONALES
		// ESTRUCTURAS DE CONTROL; SWITCH, BREAK, CONTINUE

		final byte C_NUM = 4; //Constante de uso general para los ejemplos 
		
		//Veamos como definimos un array multidimensional
		//Recordamos como definiamos un array unidimensional, o vector
		//Recordar que un array en Java es un objeto
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
		
		/*
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
		
		
		*/ 
		
		/*
		
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
		
		*/ 
		
		
		//ESTRUCTURAS DE CONTROL: SWITCH
		
		//A diferencia del if, if-else, if-else-if, es que el switch permite varios flujos de ejecución
		/*Sintaxis:
			switch (expression) {
				case x: code block; break; 
				case y: code bock; break;
				default: code block;
			}
		*/
		//Se evalúa la expression y se compara con cada case
		//Si coincíde con un case entonces se ejecuta el code block de ese case
		//Si coinciden varios cases, entonces se ejecuta el code block de cada uno
		//El break fuerza a la finalización, no se comparan más cases
		
		//Veamos un ejemplo
		
				
		Scanner entrada = new Scanner(System.in);
		int v_entrada; //Variable con valor aportado por usuario 
		
		/*
		
		String dia_semana = null; 
		 	
		do {
			System.out.println("Teclea día de la semana :");
			v_entrada = entrada.nextInt();
			
			switch (v_entrada) {
				case 1 : dia_semana = "Lunes"; break;
				case 2 : dia_semana = "Martes"; break;
				case 3 : dia_semana = "Miércoles"; break; 
				case 4 : dia_semana = "Jueves"; break;
				case 5 : dia_semana = "Viernes"; break;
				case 6 : dia_semana = "Sábado"; break;
				case 7 : dia_semana = "Domingo"; break;
				default : dia_semana = "No existe"; break; 
			}
			System.out.println(dia_semana); 
		} while (v_entrada > 0 && v_entrada < 8);
		System.out.println("Fin"); 

		
		//Obviamente el código anterior se puede recodificar mediante una estructura if-else-if 
		//Veamos un ejemplo respecto la ventaja de un switch respecto a un if-else-if
		//Si coincide un case, entonces se ejecutan todos los code blok siguientes, hasta encontrar un break. 
		
		String dias_hasta_finsemana = null; 
	 	
		do {
			System.out.println("Teclea día de la semana :");
			v_entrada = entrada.nextInt();
			
			switch (v_entrada) {
				case 1 : dias_hasta_finsemana = "Martes";
				case 2 : dias_hasta_finsemana += " Miércoles";
				case 3 : dias_hasta_finsemana += " Jueves";
				case 4 : dias_hasta_finsemana += " Viernes"; break; 
				case 5 : dias_hasta_finsemana = "No queda nada"; break; 
				default: dias_hasta_finsemana = "Ya estás en ello"; break; 

			}
			System.out.println(dias_hasta_finsemana); 
		} while (v_entrada > 0 && v_entrada < 8);
		System.out.println("Fin"); 

		
		//Otra ventaja es la de poder agrupar cases en uno solo
		do {
			System.out.println("Teclea día de la semana :");
			v_entrada = entrada.nextInt();
			
			switch (v_entrada) {
				case 1 : case 2 : case 3: case 4: case 5: dia_semana = "Entre Semana"; break;
				case 6 : case 7: dia_semana = "Fin de semana"; break;
				default : dia_semana = "No existe"; break; 
			}
			System.out.println(dia_semana); 
		} while (v_entrada > 0 && v_entrada < 8);
		System.out.println("Fin"); 
		
		//Switch a partir de Java SE 7 puede usarse con Strings
		String v_nombre = null; 
		do {
			System.out.println("Teclea tu nombre :");
			v_nombre = entrada.next(); 
			
			switch (v_nombre) {
				case "Miguel" : case "Gabriel" : case "Rafael": System.out.println("Eres un Arcángel"); break;
				default: System.out.println("Tu nombre es normalillo"); break; 
			}

		} while (v_nombre != "Fin");
		System.out.println("Fin"); 		
		*/ 
		
		//BREAK CONTINUE
		
		//Puede usarse el break para terminar un bucle for, while, do while
		
		//Ejemplo muy sencillo
		for (byte k = 0;;k++) {
			System.out.println(k); 
			if (k == 10) break; 
		}
		
		//Recodificado mediante un do while
		byte k = 0; 
		do {
			System.out.println(k++);
			if (k > 10) break; 
		} while (true); 
		
		
		//Definimos un array unidimensional de enteros aleatorios entre 0..9
		final int C_POSICIONES = 10; 
		int[] a_valores = new int[C_POSICIONES]; 
		int numero, indice, cuantos, puesto;
		numero = indice = cuantos = puesto = 0; 
		
		//Rellenamos el array
		for (byte posicion = 0; posicion < a_valores.length; posicion++) {
			
			numero = (int)(10*Math.random()); //Genera número aleatorio entre 0..9
			a_valores[posicion] = numero; 
		}
		//Mostramos su contenido 
		
		for (int valor : a_valores) {
			System.out.println("a_valores["+ indice++ + "] = " + valor);
		}
		
		//Buscamos cuántos números hay iguales al tecleado
		System.out.println("Teclea un número :");
		v_entrada = entrada.nextInt();
		
		for (int valor : a_valores) {
			if (valor != v_entrada) continue; 
			cuantos++; 
		}
		System.out.println("Había " + cuantos); 		
				
		//Buscamos la posición del primero igual al tecleado
		//Solamente queremos saber la del primero 
		for (int valor : a_valores) {
			if (valor == v_entrada) {
					System.out.println("Estaba en la posición : " + puesto);
					break; 
			}
			puesto++;
		}
		
		entrada.close(); //Cerramos input. 
		
	} // public static void main

} // public class Leccion_3 


