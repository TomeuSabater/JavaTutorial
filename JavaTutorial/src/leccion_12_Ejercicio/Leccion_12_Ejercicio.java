package leccion_12_Ejercicio;

class Leccion_12_Ejercicio {

	public static void main(String[] args) {
		
		// Ejercicio de Clases Anidadas (Nested Class)
		
		// Retomamos la Leccion_11 y anidamos class LocalizadorReserva dentro de class Reserva
		// class LocalizadorReserva solamente se usa en class Reserva
		// class LocalizadorReserva será una Static Nested Class por lo que no tendrá acceso a los elementos de la class Reserva

		
		//Inicialmente, vamos a probar el generador de locatas
		
		//Comprobamos datos inicales
		// System.out.println("Número de reservas es:" + LocalizadorReserva.muestraNumeroReservas()); //No es accesible, está oculto en Class Reserva
		//System.out.println("Localizador actual es :" + LocalizadorReserva.muestraLocalizadorActual()); //No es accesibl, etá oculto en Class Reserva

		//Generamos dos Localizadores
		//System.out.println("Nuevo Localizador es :" + LocalizadorReserva.generaLocalizador()); //No es accesible, está oculto en la Class Reserva
		
		//Creamos una reserva
		Reserva r1 = new Reserva("Tomeu Sabater", "2024-07-01"); 
		r1.muestraReserva(); 
		
		//Creamos una segunda reserva
		Reserva r2 = new Reserva("Pepito Pérez", "2024-08-15"); 
		r2.muestraReserva(); //Obervamos que el número de reserva no ha sido consecutivo
		
		//Creamos una tercera reserva
		Reserva r3 = new Reserva("Pepito Pérez", "2024-08-15"); 
		r3.muestraReserva(); //Obervamos que el número de reserva, no ha sido consecutivo
		
		//Intentamos alterar el número consecutivo de reserva
		//No es posible manipular el número consecutivo de reserva
		//Este elemento NO existe fuera de la Class Reserva
	
		
		// Aun funcionando el número consecutivo de reserva, no podemos utilizar los métodos de la Static Class LocalizadorReserva
		// LocalizadorReserva.muestraNumeroReservas(), LocalizadorReserva.muestraLocalizadorActual(), LocalizadorReserva.generaLocalizador()
		// Por tanto, no podemos alterar el localizador desde el exterior, está oculto dentro de la Clase Reserva
		// Podríamos hacerlo mediante métodos estáticos de la Class Reserva
		
		//Intentamos dar una solución más sencilla en leccion_13_Ejercicio
		

	} // public static void main

}