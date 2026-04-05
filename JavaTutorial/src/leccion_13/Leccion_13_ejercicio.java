package leccion_13;

public class Leccion_13_ejercicio {

	public static void main(String[] args) {

		// Introducción_VI a CLASES Y OBJETOS.
		// Nested Class; Inner Class / Static Class
		// Control de Acceso

		// Simplificación de Leccion_12_Ejercicio (Se aplica misma solución que el
		// Leccion_10_Ejercicio y Leccion_10_Ejercicio_bis)

		// Intentamos genera una solución más sencilla mediante una combinación de
		// elementos (variables y métodos) private static.
		// El objetivo es el mismo; evitar la posibilidad de manipular el localizador
		// (la generación de un número consecutivo que forma parte del localizador)

		// La Reserva se identifica con un localizador que tiene que ser único, para
		// ello hacemos uso de un contador.
		// No podemos manipular este contador desde el exterior, solo saber su valor
		// actual (Número reservas totales) y/o localizador actual.
		// En la creación de una Reserva, se genera el localizador único que contiene el
		// contador actual y se incrementa el contador para siguiente

		// Comprobamos datos inicales
		System.out.println("Número de reservas es:" + Reserva.muestraNumeroReservas());
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual());

		// Generamos un Localizador
		// System.out.println("Nuevo Localizador es :" + Reserva.generaLocalizador());
		// //El método es private, no es accesible desde fuera de su Class
		// Reserva.numeroReserva++; //No tiene visibilidad es una private static, no
		// tiene visibilidad fuera de cu Class

		// Creamos primera reserva
		Reserva reserva1 = new Reserva("Tomeu Sabater", "2024-07-01");
		reserva1.muestraReserva();

		// Creamos segunda reserva
		Reserva reserva2 = new Reserva("Pepito Pérez", "2024-08-15");
		reserva2.muestraReserva();

		// Comprobamos datos
		System.out.println("*****************");
		System.out.println("Número de reservas es:" + Reserva.muestraNumeroReservas());
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual());

		// Comprobamos que los localizadores de las reservas no han variado
		reserva1.muestraReserva();
		reserva2.muestraReserva();

	} // public static void main

} // class Leccion_13_ejercicio

// No obstante, necesitamos poder tener una nested Class que no sea static.
// Imaginar que en nuestra empresa el elemento Pasajero no existe fuera de una Reserva,
// y que Pasajero es suficientemente complejo para tener información y operaciones propias. 
// Entonces, sería correcto definir una nested Class Pasajero de la Class Reserva.
// La gran diferencia es que no se desea compartir un Obj Pasajero de la manera que hemos 
// compartido el Obj LocalizadorReserva. Cada Obj Reserva tendrá sus propios Obj Pasajero
// por tanto la nested Class Pasajero en ningún caso será static.
// Al no ser static, la nested Class Pasajero podrá, si se necesita, acceder a los elementos 
// de su Obj Reserva, ya que cada Obj Pasajero pertencerá a un único Obj Reserva.

// Hagamos un ejemplo de todo ello en Leccion_13_bis 
// Tendremos dos nested Class: 
// una static nested Class
// una non-static nested Class o inner Class 
// Observación: Así como una static Class no podía tener acceso a ningún elemento 
// de la outer Class porque no sería capaz de identificar cuál de ellos, la inner Class tiene la restricción
// de que no puede definir ningún elemento static porque rompería el concepto de static, 
// cada Obj Reserva tendría un elemento stati particular (que tampoco sería descabellado, pero Java no lo permite) 
