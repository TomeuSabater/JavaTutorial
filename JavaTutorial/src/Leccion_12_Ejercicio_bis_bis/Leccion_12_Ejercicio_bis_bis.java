package Leccion_12_Ejercicio_bis_bis;


public class Leccion_12_Ejercicio_bis_bis {

	public static void main(String[] args) {

	// Ejercicio para analizar el comportamiento y diferencia
	// 	entre una Inner Class y una Static Nested Class
		
	
	System.out.println("Ejercicio para analizar comportamiento de Nested Class: Inner Class & Static Nested Class"); 
		
	
		//Comprobamos datos inicales
		System.out.println("*********************************");
		System.out.println("Número de reserva  es:" + Reserva.muestraNumerodeReserva()); 
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizador()); 
		
	
		//Intentamos generar Localizadores
		// System.out.println("Nuevo Localizador es :" + LocalizadorReservaStatic.generaLocalizador()); //No es accesible, está oculto en la Class Reserva
		//System.out.println("Nuevo Localizador Inner es :" + LocalizadorReservaInner.generaLocalizador()); //No es accesible, está oculto en la Class Reserva
		
		
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
		System.out.println("Número de reserva  es:" + Reserva.muestraNumerodeReserva()); 
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizador()); 
		
	
		// Intentamos romper el sistema. 
		// Reserva.numeroReserva++; // No tiene visibilidad
		// Reserva.LocalizadorReserva localizador = r3.new LocalizadorReserva(); // La Inner Class LocalizadorReserva es private, no hay visibilidad
		
		
		// Creo que tiene un poco más de sentido porque las static pertenecen a la Class Reserva y no a las Nested Class
		// Luego, la Inner Class al ser private se oculta
		// Finalmente, la Inner Class estructura mucho mejor la generación del Localizador y sigue la lógica de POO
	}

}
