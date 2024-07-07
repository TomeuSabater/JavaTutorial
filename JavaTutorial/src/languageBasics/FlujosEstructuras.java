package languageBasics;

import java.util.Scanner;

public class FlujosEstructuras {

	public static void main(String[] args) {
		// Código para control de flujo
		// Estructuras de Control y Estructuras de Repetición
		
		//Definición de variables

		Scanner entradaint = new Scanner(System.in); 
		Scanner entradachar = new Scanner(System.in);
		int primervalor;
		int factorial, i, j, vocales, consonantes, espacios;
		char letra;
		String valor, cadena1, cadena2 = "";
		
		//ESTRUCTURAS DE CONTROL 
			
		//tecleamos número entero con signo
		System.out.print("Teclear valor : ");
		primervalor = entradaint.nextInt();
				
		//IF identificamos número par
		if (primervalor % 2 == 0) {
			
			System.out.println(primervalor + " es par");
		} else {
		
			System.out.println(primervalor + " es impar");
		}
		
		//IF - ELSE -IF Identificamos número positivo, cero o negativo
		if (primervalor < 0) {
			System.out.println(primervalor + " es < 0");
		} else if (primervalor == 0) {
				System.out.println(primervalor + " es = 0");
		} else {
				System.out.println(primervalor + " es > 0");
		}
	
		
		//SWITCH Identificamos números positivos, cero o negativos
		
		if (primervalor < 0) {
			valor = "negativo";
		} else if (primervalor == 0) {
				valor = "cero";
		} else {
				valor = "positivo";
		}
		
		switch (valor) {
		
			case "negativo" : System.out.println(primervalor + " es < 0");
							  break;
							  
			case "positivo" : System.out.println(primervalor + " es > 0");
							  break;
		
			default : System.out.println(primervalor + " es = 0");		  
							  
		}
		
		//ESTRUCTURAS DE REPETICIÓN
		
		//WHILE cálculo factorial mediante un while 
		
		if (primervalor < 0) {
			primervalor = Math.abs(primervalor);
		};
		factorial = i = 1;
		
		while (i <= primervalor) {
			
			factorial = factorial * i; 
			i++;
		}
		
		System.out.println("factorial es : " + factorial);
		
		//WHILE Calculamos si un número es par mediante restas sucesivas
		
		i = primervalor;
		while (i <= 2) {
			i = i - 2;
		}
		if (i == 0) {
			System.out.println(primervalor+" es par");
		} else {
			System.out.println(primervalor+" es impar");
		}
		
		
		// DO WHILE cálculo factorial mediante un do while
		
	    factorial = i = 1;
		do {
			factorial = factorial * i;
			i++;
			
		} while (i<= primervalor);
		System.out.println("factorial es : " + factorial);
		
		//DO WHILE sacamos númeo aleatorios hasta que sea el que hemos introducido
		
		do {
			
			i = (int) (10 * Math.random());
			System.out.print("i = " + i + ",");
			
		} while (i != primervalor);
		System.out.println();
		
		
		//DO WHILE BREAK sacamos número aleatorio hasta que salga el que hemos introducido
		
		do {
			i = (int) (10 * Math.random());
			System.out.print("i = " + i + ",");
			if (i == primervalor) break;
		} while (true);
		System.out.println();
		
		
		//FOR cálculo factorial mediante un for

		for (factorial = i = 1; i <= primervalor; i++) {
			factorial = factorial * i;
		}
		System.out.println("factorial es : " + factorial);
		
		//FOR sacamos la tabla de multiplicar		
		for (i = 1; i <= primervalor; i++) {
			for (j = 1; j <= primervalor; j++) {
				System.out.print(i + "*" + j + "=" + i*j +" ");
			}
			System.out.println();
		}
		
		//FOR calculo de potencias de 2
		
		for (i= j= 1; i<=primervalor; i++) {
			j = j*2;
		}
		System.out.println(primervalor + "**2 = " + j);
		
		
		//FOR Invertimos una cadena de carácters 
		System.out.print("Teclea string a invertir: ");
		cadena1 = entradachar.nextLine();
		
		for(i=cadena1.length()-1; i >= 0; i--) {
			cadena2 = cadena2 + cadena1.charAt(i);
		}
		System.out.println(cadena2);
		
		
		// FOR SWITCH BREAK Contamos vocales, consonantes y espacios. 
		vocales = consonantes = espacios = 0;
		cadena1 = cadena1.toLowerCase();
		for (i=0; i < cadena1.length(); i++) {
			letra = cadena1.charAt(i);
			switch (letra) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u': vocales++;
						  break;
				case ' ': espacios++;
				          break;
				default: consonantes++;
			}
		}
		System.out.println("hay "+vocales+" vocales "+consonantes+" consonantes y "+espacios+" espacios");
		
		//FOR CONTINUE Contamos sólo los carácters que no son espacios
		
		for (i=j=0; i < cadena1.length(); i++) {
			if (cadena1.charAt(i) == ' ') continue;
			j++;
		}
		System.out.println("hay "+j+" letras que no son espacios");
		
	}
}

