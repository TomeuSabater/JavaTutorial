package Leccion_13_bis;

public class Leccion_13_Ejercicio_bis {

	// Se muestran ejemplo de static nested Class e inner Class
	// Tendremos dos nested Class:
	// - una static nested Class
	// - una non-static nested Class o inner Class
	// Observación: Así como una static Class no puede tener acceso a ningún
	// elemento de la outer Class porque no sería capaz de identificar cuál de
	// ellos, la inner Class tiene la restricción de que no puede definir ningún
	// elemento static porque rompería el concepto de static, cada Obj Reserva
	// tendría un elemento stati particular (que tampoco sería descabellado, pero
	// Java no lo permite)

	public static void main(String[] args) {

		// Comprobamos datos inicales
		System.out.println("Número de reservas es:" + Reserva.muestraNumerodeReservas());
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual());

		// Creamos la primera reserva
		Reserva reserva1;
		reserva1 = new Reserva("43.026.095-C", "Tomeu", "Sabater", null, "1966-03-18", "41.234.567-B", "Isabel",
				"Pantoja", null, "1965-05-27", null, null, null, null, null);

		// Volcamos la reserva
		reserva1.muestraReserva();

		// Comprobados si son adultos
		System.out.println("Son adultos = " + reserva1.sonAdultos());

		// Comprobamos valores estáticos
		System.out.println("Número de reservas es:" + Reserva.muestraNumerodeReservas());
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual());
	}

}

// La Class Reserva contiene dos nested Class
// - static nested Class LocalizadorReserva
// - non-static nested Class o inner Class Pasajero
// La Class Reserva tiene métodos static que llaman a los métodos de la static class
// Esto proporciona herramientas de acceso a los valores static sin la necesidad 
// de instanciar la Class Reserva
