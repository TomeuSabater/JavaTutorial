package leccion_12_Ejercicio;

class Leccion_12_Ejercicio {

	public static void main(String[] args) {
		
		
		// Introducción_VI a CLASES Y OBJETOS. 
		// Nested Class; Inner Class / Static Nested Class
		
		// Ejercicio de Clases Anidadas (Nested Class)
		
		// Retomamos la Leccion_11 y anidamos La Class LocalizadorReserva dentro de la Class Reserva
		// Suponemos que Class LocalizadorReserva solamente se usa en Class Reserva

		// Al ser un elemento de una Class, como un atributo o método, podemos acompañar a la Class de static, private, public, etc. 
		// Las Nested Class pueden ser de dos tipos: Inner Class / Static Nested Class
		// 		- Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private. 
		//		- Static nested classes do not have access to other members of the enclosing class.
		
		// Inner Class: It is associated with an instance of its enclosing Class and has direct access to that object's methods and fields. 
		//		also, because an Inner Class is associated with an instance, it cannot define any static members itself.
		//		Objects that are instances of an Inner Class exist within an instance of the outer class.
		// 		To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:
		// 			OuterClass outerObject = new OuterClass();
		//			OuterClass.InnerClass innerObject = outerObject.new InnerClass();
		// 		Hay 2 Inner Class especiales, la Local Class y la Anonymous Class, que veremos más adelante. 
		
		// Static Nested Class: is associated with its outer class. 
		//		And like static class methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing class
		
		
		// Class LocalizadorReserva será una Static Nested Class por lo que no tendrá acceso a los elementos de la class Reserva
		
		
		//Comprobamos datos inicales
		System.out.println("*********************************");
		System.out.println("Número de reservas es:" + Reserva.muestraNumerodeReservas()); 
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual()); 

		//Intentamos generar Localizadores
		//System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador()); //No es accesible, está oculto en la Class Reserva
		
		//Creamos una reserva
		Reserva r1 = new Reserva("Tomeu Sabater", "2024-07-01"); 
		r1.muestraReserva(); 
		
		//Creamos una segunda reserva
		Reserva r2 = new Reserva("Pepito Pérez", "2024-08-15"); 
		r2.muestraReserva(); //Obervamos que el número de reserva ha sido consecutivo
		
		//Creamos una tercera reserva
		Reserva r3 = new Reserva("Pepito Pérez", "2024-08-15"); 
		r3.muestraReserva(); //Obervamos que el número de reserva, no ha sido consecutivo
		
		//Comprobamos datos
		System.out.println("*********************************");
		System.out.println("Número de reservas es:" + Reserva.muestraNumerodeReservas()); 
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual()); 
		
		
		// No podemos utilizar los métodos static de la Static Class LocalizadorReserva.generaLocalizador()
		//		ni acceder a los atributos static localizador o numeroReserva, 
		//		por tanto, no podemos alterar el localizador desde el exterior, está todo oculto dentro de la Clase Reserva
		// 
		// Por otra parte, al ser LocalizadorReserva una Class static, respeta la necesidad de único número de reserva para todas las Class que la contiene
		//		es decir, no se genera una Class LocalizadorReserva para cada Class Reserva (lo que no permitiría la gestión de un número único de reserva)
		//		Un elemento static pertenece a la Class no al Obj, por tanto, una Sub Class static también pertenece a la Class que la contiene 
		//
		// Finalmente, se ha podido etiquetar la Class LocalizadorReserva como static y private porque es una Class Nested, en caso contrario no es posible.
		
		//Obviamente, recurrir a una Class Nested es una opción, se propone dar otra solucion sin Class Nested mediante atributos y métodos private static
		//		de la propia Class Reserva. El ejemplo mostrado aquí es teórico, en una situación real posiblemente se optaría por esta solución más sencilla 
		
		// Intentamos dar una solución más sencilla evitando la Static Nested Class en leccion_13_Ejercicio
		// Intentamos dar una ejemplo de la diferencia entre una Inner Class y una Static Nested Class en NestedClass.java y Leccion_12_Ejercicio_bis
		
	} // public static void main
	
} // class Leccion_12_Ejercicio

