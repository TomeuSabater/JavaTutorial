package leccion_12;


class Leccion_12_Ejercicio {

	public static void main(String[] args) {

		// Introducción_VI a CLASES Y OBJETOS.
		// Nested Class; Inner Class / Static Nested Class

		// Ejercicio de Clases Anidadas (Inner Class / Static Nested Class)

		// Retomamos la Leccion_11.java y anidamos las Class LocalizadorReserva y 
		// la Class Pax dentro de la Class Reserva ya que suponemos que ambas Class 
		// solamente se usarán (tienen sentido) en la Class Reserva

		// Al ser un elemento de una Class, al igual que un atributo o método, 
		// podremos acompañar a la Nested Class de los calificadores static, private, public, etc.
		// Además, las Nested Class pueden ser de dos tipos: Inner Class / Static Nested Class
		// - Las Non-static Nested Classes (Inner Class) have access to other members of
		// the enclosing Class, even if they are declared private.
		// - Las Static Nested Class do not have access to other members of the enclosing
		// class.

		// Inner Class: It is associated with an instance of its enclosing Class and has
		// direct access to that object's methods and fields. also, because an Inner Class 
		// is associated with an instance, it cannot define any static members itself.
		// Objects that are instances of an Inner Class exist within an instance of the
		// outer class.
		// To instantiate an Inner Class, you must first instantiate the outer class,
		// then, create the Inner Object within the Outer Object with this syntax:
		// OuterClass outerObject = new OuterClass();
		// OuterClass.InnerClass innerObject = outerObject.new InnerClass();
		// Además, hay 2 Inner Class especiales, la Local Class y la Anonymous Class, que
		// veremos más adelante, ahora nos centramos en las Inner Class y las Static Nested Class

		// Static Nested Class: It is associated with its outer class.
		// And like static class methods, a static nested class cannot refer directly to
		// instance variables or methods defined in its enclosing class
		// Funciona como una Static Class pero la definimos como subclase para una
		// mejor arquitectura.
		// Aunque es Nested, no se necesita crear el Outer Object para instanciar la Static Nested.
		// Tiene acceso limitado, solo puede acceder a los miembros static (variables y métodos) de la clase externa. 
		// No puede ver los miembros de instancia (no estáticos) directamente porque, y como static que es, no tiene 
		// una referencia al objeto creador.
		// Se usan para agrupar clases que solo tienen sentido dentro de otra, manteniendo el código más limpio y organizado y
		// aplicando el concepto de encapsulamiento 
		
		
		///// Veamos un ejemplo de todo esto 
		
		// Comprobamos datos inicales
		// Llamamos a los métodos static de la Class Reserva, 
		// como son static, no hace falta crear ninguna
		// recordar que a la vez, estos métodos static de la Class Reserva 
		// llaman a los métodos static de la Static Nested Class LoalizadorReserva
		// reserva
		System.out.println("*********************************");
		System.out.println("Número de reservas actual es: " + Reserva.muestraNumerodeReservas());
		System.out.println("Localizador actual es : " + Reserva.muestraLocalizadorActual());

		// Intentamos generar Localizadores
		// System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador()); // No es accesible, error 

		
		// Creamos una Reserva
		Reserva reserva1 = new Reserva("42.023.096-C", "Tomeu", "Sabater", null, "1966-03-18", "2026-05-05");
		reserva1.muestraReserva();

		// Creamos una segunda Reserva
		Reserva reserva2 = new Reserva("44.965.695-V", "Pepito", "Pérez", null, "1965-05-27", "2026-05-06");
		reserva2.muestraReserva(); // Obervamos que el Localizador de reserva ha sido consecutivo
	
		// Comprobamos datos de la contabilidad de número de reserva y localizadores
		// Es imposible alterarlos, no son visibles y no se ofertan métodos para ello
		// solamente los podemos consultar
		System.out.println("*********************************");
		System.out.println("Número de reservas es:" + Reserva.muestraNumerodeReservas());
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual());

		
		// Intentamos ahora crear un Pax
		// Pax pasajero = new Pax("42.023.096-C", "Tomeu", "Sabater", null, "1966-03-18", false); // No visible, error
		
		
		// En definitiva, no podemos utilizar los métodos static de la Static Nested Class
		// LocalizadorReserva.generaLocalizador() ni acceder a los atributos
		// static localizador o numeroReserva por tanto, no podemos alterar el 
		// localizador desde el exterior, está todo oculto dentro de la Class Reserva
		
		// Por otra parte, al ser LocalizadorReserva una Static Nested Class, respeta la
		// necesidad de único número de reserva para todas las Class que la contienen
		// es decir, no se genera una Class LocalizadorReserva para cada Class Reserva
		// (lo que no permitiría la gestión de un número único de reserva)
		// Un elemento static pertenece a la Class no al Obj, por tanto, una Sub Class static 
		// también pertenecería a la Class que la contiene. 
		
		// Finalmente, se ha podido etiquetar la Class LocalizadorReserva como static y
		// private porque es una Nested Class, en caso contrario no es posible.

		// Obviamente, recurrir a una nested Class es una opción, se podría dar otra
		// solucion sin Nested Class mediante atributos y métodos 'private static'
		// de la propia Class Reserva. El ejemplo mostrado aquí es teórico, 
		// en una situación real posiblemente se optaría por una solución más sencilla 
		// donde la Class Reserva posee directamente variables y métodos calificados como static 
		// de generación de su localizador. 
		// No obstante, si la gestión del localizador fuera compleja, entonces estaría
		// plenamente justificada la Static Nested Class

		
		// Se intenta dar una solución más sencilla evitando la Static Nested Class en
		// leccion_13 para acabar de comprenderlo.
		// Intentamos dar una ejemplo de la diferencia entre una Inner Class y una
		// Static Nested Class en NestedClass.java y Leccion_12_Ejercicio_bis

	} // public static void main

} // class Leccion_12_Ejercicio.java 

// Siguientes lecciones son variaciones y posibles soluciones utilizando
// Inner Class, Static Nested Class, métodos y variables static. 
// Se pueden obviar y saltar directamente a leccion_14.java donde veremos las "Local Class"

