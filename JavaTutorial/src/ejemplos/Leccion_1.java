package ejemplos;

public class Leccion_1 {
		
	public static void main(String[] args) {

		// TIPOS DE DATOS EN JAVA; Simples y Complejos (Arrays) 
		// Operaciones básicas: Asignación, ++x, --x, x++, x--
		// ESTRUCTURAS DE REPETICION; for
	
		// *********************************** TIPOS DE DATOS SIMPLES
		
		//Números enteros
		byte v_byte = 0; //Entero con signo -128 a +127
		short v_short = 0; //Entero con signo -32768 a +32767
		int v_int = 0; //Entero con signo -214.7483.648 a +214.748.3648 (32-bit signed) 
		int v_dni = 43_026_097; //Entero con undescore para mejorar su visualización 
		long v_long = 0; //Entero con signo 64-bit. Minimum value of -2^63 and a maximum value of 2^63-1
		long creditCardNumber = 1234_5678_9012_3456L; //Underscore es para mejora visualizarlo  
		
		System.out.println("v_byte = " + v_byte); 
		System.out.println("v_short = " + v_short); 
		System.out.println("v_int = " + v_int); 
		System.out.println("v_dni = " + v_dni); 
		System.out.println("v_long = " + v_long); 
		System.out.println("creditCardNumber = " + creditCardNumber); //Se muestra sin el símbolo "_"
				
		//Números reales
		float v_float = 0.00f; //Real con precisión simple (32-bit float literal)
		float pi = 3.1415f; // Ejemplo de real simple
		double v_double = 3.14d; //Real de precisión doble (64-bit double literal)
		v_double = 123.4; //Ejemplo de real doble
		v_double = 1.234e2; //Ejemplo de real doble
		
		System.out.println("v_float = " + v_float); 
		System.out.println("pi = " + pi); 
		System.out.println("v_double = " + v_double); 
		
		//Valores lógicos
		boolean v_booleant = true; //Booleano
		boolean v_booleanf = false; //Booleano
		
		System.out.println("v_boolean = " + v_booleant); 
		System.out.println("v_boolean = " + v_booleanf); 
		
		//Carácteres
		char v_char = 'X'; //Caracter. 16-bit Unicode character
		String v_cadena = null; //Cadena de carácteres de longitud variable. Puede ser null.  
		v_cadena = "Bartolomé Sabater"; // Ejemplo de cadena 
		String v_nif = "43.026.097-C"; // Ejemplo de uso de cadena
		
		System.out.println("v_char = " + v_char); 
		System.out.println("v_cadena = " + v_cadena); 
		System.out.println("v_nif = " + v_nif);
			
		//Constantes, valor fijo inmutable que se asigna en momento de creación
		final int C_NUM = 5;
		final boolean C_VERDADERO = true;
		final char C_LAX = 'X'; 
		final String MI_NOMBRE = "Bartolomé"; 
		final float PI = 3.1421f;  
		
		// C_NUM = 3; Muestra un error, una CTE no puede alterar su contenido
		// C_VERDADERO = false; Muestra un error. 
		
		System.out.println("C_NUM = " + C_NUM); 
		System.out.println("C_VERDADERO = " + C_VERDADERO); 
		System.out.println("C_LAX = " + C_LAX); 
		System.out.println("MI_NOMBRE = " + MI_NOMBRE); 
		System.out.println("PI = " + PI); 
		
		
		// *********************************** TIPOS DE DATOS COMPLEJOS (Arrays)
		
				
		//Tipos de datos complejos ARRAYS 
		//Al ser un objeto se utiliza la instanciación para definirlos
		
		int[] a_enteros; // Paso 1: Definimos un array de enteros, sin definir cuántos elementos entero contiene
		a_enteros = new int[C_NUM];  //Paso 2: Definimos cuántos elementos contiene, usamos la CTE C_NUM 
		boolean[] a_booleanos = new boolean[C_NUM]; //Definición en un paso. Vector de booleanos de NUM posiciones
		char a_caracteres[] = new char[C_NUM]; //Vector de caracters de NUM posiciones. Ejemplo en 1 paso y corchetes después nombre. 
		String a_cadenas[] = new String[C_NUM]; //Vector de cadenas de caracteres de NUM posiciones. Ejemplo en 1 paso y corchetes después nombre. 
		
		int[][] m_enteros = new int[C_NUM][C_NUM]; //Matriz de dos dimensiones de enteros de NUMxNUM posciones
		boolean m_booleanos[][] = new boolean[C_NUM][C_NUM]; //Matriz de dos dimensione de booleanos de NUMxNUM. Corchetes después nombre
		char[][][] m_caracteres = new char[C_NUM][C_NUM][C_NUM]; // Matriz de tres dimensiones de caracters de NUMxNUMxNUM 

		
		
		// *********************************** OPERACIONES BÁSICAS
		
		//OPERACIONES BASICAS. 
		System.out.println("*********** OPERACIONES BASICAS"); 
		
		//Asignación
		
		v_int = 0; //Derecha a izquierda SIEMPRE
		System.out.println("v_int = " + v_int); 
		
		v_int = v_int + 0; // Derecha a izquierda SIEMPRE.
		System.out.println("v_int = " + v_int); 
		
		v_int = 1;
		v_int = v_int + v_int + v_int + v_int;
		System.out.println("soy v_int y valgo :" + v_int);
		
		//La asignación de derecha a izquiera se resuelve en el compilador / interprete mediante variables temporales. 
		//La siguiente secuencia de instrucciones
		v_int = 0;
		v_int = v_int + 1; // Él es igual a Él + 1. 
		
        //Internamente se resuelve de esta manera
		v_int = 0;
		int temporal = 0; //Variable que define el compilador / interprete
		temporal = v_int + 1; //Calcula la parte de la derecha
		v_int = temporal; //La asigna a la variable final
		
		//Otro ejemplo con asignación compleja
		//Siempre se calcula el valor mediante operaciones temporales y luego se asigna. 		
		//Revisar microcódigo de máquina de Von Neumann
		v_int = 1;
		v_int = v_int + v_int + v_int + v_int; 
		System.out.println("soy v_entero y ahora valgo: " + v_int);
		
		
		//Operaciones específicas de Java
		v_int = 0;
		v_int = v_int + 1; //Operación muy común en cualquier lenguaje de programación, que tiene sintaxis específica
		
		v_int++; //Incremento en 1 unidad DESPUES DE SER UTILIZADA
		v_int--; //Decremento en 1 unidad DESPUES DE SER UTILIZADA
		
		++v_int; //Incremento en 1 unidad para la variable ANTES DE SER UTILIZADA
		--v_int; //Decremento en 1 unidad para la variable ANTES DE SER UTILIZADA
		
		//Veamos un ejemplo 
		v_int = 0;
		System.out.println("soy v_entero y valgo: " + v_int); //mostramos su valor
		System.out.println("soy v_entero++ y valgo: " + v_int++); //mostramos su valor y luego la incrementamos
		System.out.println("soy v_entero y valgo: " + v_int); //mostramos su nuevo valor
		
		v_int = 0;
		System.out.println("soy ++v_entero y valgo: " + (++v_int)); //incrementamos su valor y la mostramos;
		System.out.println("soy v_entero y valgo: " + v_int); //mostramos su nuevo valor
			
		// Veamos otros ejemplos de diferencia entre ++x y x++
		
		v_int = temporal = 0; 
		temporal = v_int++;
		System.out.println("soy temporal = v_entero++ y valgo:" + temporal);
		System.out.println("soy v_entero  = " + v_int); 
		
		v_int = temporal = 0;
		temporal = ++v_int;
		System.out.println("soy temporal = ++v_entero y valgo:" + temporal);
		System.out.println("soy v_entero  = " + v_int); 
		
		
		//Se recomienda no complicar innecesariamente este tipo de operaciones
		v_int = 0;
		v_int = v_int++;
		System.out.println("soy v_int y valgo:" + v_int);
		
		//Para entenderlo mejor, podemos decir que el compilador hace esta secuencia: 
		v_int = 0;
		temporal = v_int;
		v_int++;
		v_int = temporal;
		System.out.println("soy v_entero y valgo:" + v_int + "soy temporal y valgo:" + temporal);
		
		//En este caso no hay mucha complicación
		v_int = 0;
		v_int = ++v_int;
		System.out.println("soy v_int y valgo:" + v_int);
	
		//Ejemplo de cómo complicar innecesariamente el código con este tipo de operacioes
		v_int = 0;
		v_int = (v_int++) + (v_int++) + (v_int++); //0 + (1) + (2)
		System.out.println("Soy v_int complicado y valgo: " + v_int);
			
		v_int = 0;
		v_int = (++v_int) + (++v_int) + (++v_int); //Evitar este tipo de operaciones (1) + (2) + (3)
		System.out.println("Soy v_entero chulo porras y valgo: " + v_int);
		

		//Las operaciones x++, ++x, --x, etc. es altamenterecomendables 
		//que sean sencillas, de todas maneras, si existe un optimizador de código
		//acabará reorganizándolo. No escatiméis en usar más pasos si queda más legible 
	   
		
		// *********************************** ESCTRUCTURAS DE CONTROL: FOR
		
		//ESTRUCTURA DE CONTROL
		
		//FOR --> Repetición, bucle, iteración
		 
		//Un For Repite el bloque de  instrucciones que están bajo su control
		
		/* Sintaxis
		
			for (inicialización; control; acción de cada iteración) {}
			
			for (;;)  {}
			
			for (;;System.out.println("hola")) {}
			
			for (;;System.out.print("no me canso de decir")) {
				System.out.println(" hola");
			}
			
	        for (byte i =0; ; ) {
	        	System.out.println(i++);
	        }
			
			for (byte i =0; ; i++) {
				System.out.println(i);
			}
			
		*/ 
		
		//Vamos a controlar el bucle para que no se salga de rango
		for (byte i = 0; ; i++) {
			System.out.println(i);
			if (i >= 127) {
				break;
			}
		}

		//Aprovechamos la estructura de control del for
		v_byte = 0;
	    for (;v_byte<=100;) {
			System.out.println(v_byte++);
	    }
		
	    //Mejoramos un pelín la anterior estructura
	    for (byte v2_byte = 0; v2_byte <= 100;) {
			System.out.println(v2_byte++);
	    }
	    
		//For hecho a mano
		byte j = 0;
		for (;;) {
			System.out.println(j);
			j++;
			if (j == 127) {
				break;
			}
		}
		
		//For BIEN hecho
		for(byte k = 0; k < 127; k++) {
			System.out.println("Soy k y valgo: " + k);
		}
		

		//Aprovechamos la estructura del FOR
		j = 0;
		for(byte r = 0; r < 127; r++, j--) {
			System.out.print("soy j y valgo :" + j);
			System.out.println(" soy r y valgo :" + r);
		}
		
		//Recordar que el For puede no iterar ninguna vez
		for (byte r = 0; r != 0; r++) {
			System.out.println("Nunca me ejecuto");
		}
		
	
	  //MANEJAMOS ARRAYS
	
	    
	  //Definimos un array que luego lo vamos a utilizar. 
	  // int[] a_enteros = new int[C_NUM]; //Recordamos su definición anterior 
	  
	  //Rellenamos manualmente y mostramos su contenido 
	  a_enteros[0] = 0;
	  a_enteros[1] = 1;
	  a_enteros[2] = 2;
	  a_enteros[3] = 3;
	  a_enteros[4] = 4;  

	  System.out.println("a_enteros[0] = " +  a_enteros[0]);
	  System.out.println("a_enteros[1] = " +  a_enteros[1]);
	  System.out.println("a_enteros[2] = " +  a_enteros[2]);
	  System.out.println("a_enteros[3] = " +  a_enteros[3]);
	  System.out.println("a_enteros[4] = " +  a_enteros[4]); 
  
	  //Rellenamos de una manera más inteligente y mostramos
	  v_byte = 0;
	  a_enteros[v_byte] = v_byte++;
	  a_enteros[v_byte] = v_byte++;
	  a_enteros[v_byte] = v_byte++;
	  a_enteros[v_byte] = v_byte++;
	  a_enteros[v_byte] = v_byte++; 
	  
	  v_byte = 0;
	  System.out.println("a_enteros[" + v_byte + "] = " +  a_enteros[v_byte++]);
	  System.out.println("a_enteros[" + v_byte + "] = " +  a_enteros[v_byte++]);
	  System.out.println("a_enteros[" + v_byte + "] = " +  a_enteros[v_byte++]);
	  System.out.println("a_enteros[" + v_byte + "] = " +  a_enteros[v_byte++]);
	  System.out.println("a_enteros[" + v_byte + "] = " +  a_enteros[v_byte++]);
	  
	  //Mismo ejemplo con (++v_byte)
	  v_byte = -1; System.out.println();
	  //System.out.println("a_enteros2[" + v_byte + "] = " +  a_enteros2[v_byte++]); //No Funciona
	  //System.out.println("a_enteros2[" + v_byte + "] = " +  a_enteros2[++v_byte]); //No funciona
	  //System.out.println("a_enteros2[" + (++v_byte) + "] = " +  a_enteros2[++v_byte]); //No funciona
	  
	  System.out.println("a_enteros[" + (++v_byte) + "] = " +  a_enteros[v_byte]); 
	  System.out.println("a_enteros[" + (++v_byte) + "] = " +  a_enteros[v_byte]); 
	  System.out.println("a_enteros[" + (++v_byte) + "] = " +  a_enteros[v_byte]); 
	  System.out.println("a_enteros[" + (++v_byte) + "] = " +  a_enteros[v_byte]); 
	  System.out.println("a_enteros[" + (++v_byte) + "] = " +  a_enteros[v_byte]); 

	  //Vamos a rellenarlo con un FOR
	  //siendo la manera más "normal" o abitual
	  
	  v_byte = 0;
	  for (;;) {
		  System.out.println(a_enteros[v_byte]);
		  v_byte++;
		  if (v_byte >= 4) {
			  break;
		  }
	  }
	  
	  //Podemos saber la longitud de un array
	  System.out.println("Soy a_enteros y tengo " + a_enteros.length + " posiciones"); 
	  
	  //Rellenamos aprovechando la estructura del for y su longitud
	  for (v_byte = 0; v_byte < a_enteros.length; v_byte++) {
		  a_enteros[v_byte] = v_byte;
		  System.out.println("a_enteros[" + v_byte + "] = " + a_enteros[v_byte]);
	  }
	  
	  //Recorremos el array de manera inversa
	  System.out.println();
	  for (int indice = a_enteros.length - 1; indice >= 0; indice--) {
		  System.out.println("a_enteros[" + indice + "] = " + a_enteros[indice]);
		  
	  }
	  
	  //Recorrer un Array es una operación muy común en programación
	  //JAVA tiene una for "especial" para recorrer un array (extraer sus valores en orden ascendente)
	  
	  for (int variable : a_enteros) {
		  System.out.println(variable);
	  }
	   
	  for (boolean variable : a_booleanos) {
		  System.out.println(variable);
	  }
	  
	  //Un array puede ser de booleanos, enteros, carateres
	  //Ejemplo con array de Strings
	  String[] dias_semana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	  
	  for (String variable : dias_semana) {
		  System.out.println(variable);
	  }
	  
	  //El problema de recorrer un array al estilo java es que no tienes control sobre ello
	  //por ejemplo, muestrame sólo los dias laborales. 
	  
	  v_byte = 0;
	  for (String variable : dias_semana) {
		  System.out.println(variable);
		  if (variable == "Jueves") 
			  break;
	  }
	  
	  // Ver Arrays.java con código ejemplo de manipuación avanzada de arrays. 
	
	
	} // public static void main
	  
} // public class Leccion_1 
	
