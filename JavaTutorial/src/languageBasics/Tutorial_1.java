package languageBasics;

public class Tutorial_1 {

	public static void main(String[] args) {
		
		// Tipos de datos en JAVA; Simples, y compuestos (arrays)
		// Casting
		// Operaciones básicas; Asignación, ++x, --x, x++, x--
		// Estructura de repetición: for (for específico de java) 
		
		// ************************* TIPOS DATOS
		
		//Numeros enteros
		byte v_byte = 0; // Entero con signo -128 a +127
		short v_short = 0; // Enterno con signo -32728 a +32767
		int v_int = 0; // Entero con signo -2.147.483.648 a +2.147.483.3648 
		int v_dni = 43_026_097; // Entero con underscore para mejorar visualización
		long v_long = 0; // Entero con signo 64bits. -2^63 +2^63-1
		long creditCardNumer = 1234_5678_9012_3569L; // Underscore para visibilidad
		
		System.out.println("v_byte "+ v_byte);
		System.out.println("v_short "+ v_short);
		System.out.println("v_vint "+ v_int);
		System.out.println("v_dni "+ v_dni);
		System.out.println("v_long "+ v_long);
		System.out.println("CreditCardNumer "+ creditCardNumer);
		
		//Numeros Reales 
		float v_float = 0.00f; // Real con precisión simple (32-bits) 
		float pi = 3.1415f; // Ejemplo de real simple
		double v_double = 3.14d; // Ejemplo de real precisión doble (64-bits)
		v_float = 23.99f; // Podría ser un precio 
		v_double = 123.99; // Podría ser un precio 
		v_double = 1.234e2; // Ejemplo de real doble
		
		System.out.println("v_float "+  v_float); 
		System.out.println("v_double "+  v_double); 
		
		// Valores booleanos
		boolean v_true = true; // Valor booleano
		boolean v_false = false; // Valor booleano
		
		System.out.println("v_true "+  v_true); 
		System.out.println("v_false "+  v_false); 
		
		// Caracteres
		char v_char = 'Á'; 
		String v_cadena = null; // Cadena puede contener null
		v_cadena ="Bartolomé Sabater"; 
		String v_nif = "43.026.097-C"; // dni, nif, passport
		
		System.out.println("v_char "+  v_char); 
		System.out.println("v_cadena "+  v_cadena); 
		System.out.println("v_nif "+  v_nif); 
		
		// Constantes, valores inmutables
		final int C_NUM = 5; 
		final boolean VERDADERO = true; 
		final char LA_X = 'X'; 
		final String MI_NOMBRE = "Tomeu"; 
		final float PI = 3.1421f; 
		
		// C_NUM = 3; 
		// VERDADERO = false; 
		
		System.out.println("C_NUM " + C_NUM ); 
		System.out.println("VERDADERO " + VERDADERO ); 
		System.out.println("LA_X " + LA_X ); 
		System.out.println("MI_NOMBRE " + MI_NOMBRE ); 
		System.out.println("PI " + PI ); 
		
		// ***************** Casting
		
		// Widening Casting
		// Is done automatically when passing a smaller size type to a larger size type
		
		int myInt1 = 9;
		double myDouble = (double)myInt1; // Automatic Casting; int to double 
		System.out.println("myInt1 " + myInt1 ); 
		System.out.println("myDouble " + myDouble ); 
		
		double myDouble2 = 9.78d; 
		int myInt2 = 0;
		myInt2 = (int)myDouble2; 
		
		System.out.println("myDouble2 " + myDouble2 ); 
		System.out.println("myInt2 " + myInt2 ); 
		
		// Casting example in real life
		
		int net = 520;
		byte iva = 21; 
		
		float total_impuesto = (float)(net * iva) / 100f; 
		System.out.println("Impuesto = " + total_impuesto); 
		
		// ****************** Tipos de datos complejos (array)
		// Un arra en Java es un objeto, y se debe entender y manejar como tal 
		// posteriormente veremos objetos en detalle
		
		int[] a_enteros; // Tipo del array 
		a_enteros = new int[C_NUM]; // La dimension del array 
		
		boolean[] a_boolean = new boolean[C_NUM]; // Array de booleanos
		char[] a_chars = new char[C_NUM]; // Array de caracteres
		
		String[] a_cadenas = new String[C_NUM]; // Array de cadenas de caracteres
		
		int[][] m_enteros = new int[C_NUM][C_NUM]; // Matriz de enteros
		
		int[][][] cubo_enteros = new int[C_NUM][C_NUM][C_NUM]; // Cubo de enteros
		
		//*********** Operacione básicas
		
		v_int = 1; 
		// v_int = v_int + v_int; 
		v_int = v_int + v_int + v_int + v_int; 
		System.out.println("v_int "+ v_int); 
		
		v_int = 0;
		v_int = v_int + 1;
		
		v_int = 0;
		int temporal = 0; 
		temporal = v_int + 1;
		v_int = temporal; 
		
		v_int++; // Sumar 1 a v_int DESPUES DE SU USO v_int = v_int + 1; 
		++v_int; // Sumar 1 a v_int ANTES DE SU USO v_int = v_int + 1; 
		
		v_int = 0; 
		System.out.println("Soy v_int y valgo " + v_int); 
		System.out.println("Soy v_int y valgo " + v_int++); 
		System.out.println("Soy v_int y valgo " + v_int); 
		
		v_int = 0; 
		System.out.println("Soy ++v_int y valgo " + (++v_int)); 
		System.out.println("Soy ++v_int y valgo " + (v_int)); 
		
		v_int = temporal = 0; 
		temporal = v_int++; 
		System.out.println("Soy temporal " + temporal + " soy v_int " + v_int); 
		
		v_int = temporal = 0; 
		temporal = ++v_int; 
		System.out.println("Soy temporal " + temporal + " soy v_int " + v_int); 
		
		v_int = 0;
		v_int = (v_int++) + (v_int++) + (v_int++); // (0) + (2) + (3)
		System.out.println("soy v_int " + v_int); 
		
		v_int = 0;
		v_int = (++v_int) + (++v_int) + (++v_int); // (1) + (2) + (3)
		System.out.println("soy v_int " + v_int); 

		// ***************** Estructuras de control FOR 
		
		// for(incializacion; control; accion de cada iteración) {}
		
		// for(;;) {}
		
		// for(;;System.out.println("hola")) {}
		
		/*
		for(;;System.out.println("no me canso de decir")) {
			System.out.println("hola");
		}
		
		for(byte i = 0;;) {
			System.out.println(i++);
		}
				
		for(byte i = 0;;i++) {
			System.out.println(i);
		}
		
		*/ 
		
		for (byte i = 0;  ; i++) {
			System.out.println(i);
			if ( i >= 127) {
				break; 
			}
		}
		
		v_byte = 0; 
		for (; v_byte < 100; ) {
			System.out.println(v_byte++);
		}
		
		// Un for como toca ser
		for(v_byte = 0; v_byte < 100; v_byte++) {
			System.out.println(v_byte);
		}
		
		byte j = 0;
		for ( ; ; ) {
			System.out.println(j);
			j++;
			if (j == 127) {
				break;
			}
		}
		
		for (j = 0; j < 127; j++) {
			System.out.println(j);
		}
		
		int a;
		int b; 
		for (a = 0, b = 0; a < 127; a++, b++) {
			System.out.println(a + "a y b " + b);
		}
		
		for (byte r = 0; r != 0; r++) {
			
			System.out.println("Me ejecuto? -> NO NUNCA"); 
		}
		
		System.out.println("No se ejecutó");
		
		//*********** Manejamos arrays
		
		// int[] a_enteros; // Tipo del array 
		// a_enteros = new int[C_NUM]; // La dimension del array
		// C_NUM = 5; 
		
		a_enteros[0] = 0; 
		a_enteros[1] = 1; 
		a_enteros[2] = 2; 
		a_enteros[3] = 3; 
		a_enteros[4] = 4; 
		
		v_byte = 0;
		a_enteros[v_byte] = v_byte++; 
		a_enteros[v_byte] = v_byte++; 
		a_enteros[v_byte] = v_byte++; 
		a_enteros[v_byte] = v_byte++; 
		a_enteros[v_byte] = v_byte; 
		
		v_byte = 0; 
		System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte++]); 
		System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte++]); 
		System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte++]); 
		System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte++]); 
		System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte]); 
		
		for (v_byte = 0; v_byte < 5; v_byte++) {
			
			System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte]); 
		}
		
		System.out.println("Bien hecho"); 
		System.out.println("Longitud o número elemento " + a_enteros.length); 
		for (v_byte = 0; v_byte < a_enteros.length; v_byte++) {
			
			System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte]); 
		}
		
		for (int indice = a_enteros.length - 1; indice >= 0; indice--) {
			
			System.out.println("a_enteros[" + indice + "] = " + a_enteros[indice]); 
		}
		
		System.out.println("Modo Javaloya"); 
		for (int indice : a_enteros) {
			
			System.out.println(indice); 
		}
		
		// boolean[] a_boolean = new boolean[C_NUM]; 
		for (boolean variable : a_boolean) {
			
			System.out.println(variable);
		}
		
		// Strings customizado
		String[] dias_semana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" }; 

		for (String variable : dias_semana) {
			System.out.println(variable);
			if (variable == "Viernes") break; 
		}
	}

}
