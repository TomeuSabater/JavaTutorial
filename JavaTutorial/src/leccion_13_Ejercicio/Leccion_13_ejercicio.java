package leccion_13_Ejercicio;


public class Leccion_13_ejercicio {

	public static void main(String[] args) {
	
		// Ejercicio de Control de Acceso
		// Simplificación de Leccion_12_Ejercicio
		
		
		// Intentamos hacerlo todo más sencillo
		// Combinación de elementos (variables y métodos) privados estáticos
		// El objetivo es ocultar el número consecutivo y el localizador
		
		// Reserva tendrá un localizador único con un contador
		// No podemos manipular este contador, solo saber su valor actual (Número reservas totales) y/o localizador actual
		// En la creación de una Reserva, se genera el localizador único que contiene el contador actual y se incrementa el contador para siguiente
		// No debe ser posible manipular el contador (incrementar/decrementar/resetar) a excepción de lo anterior 

	
		// Comprobamos datos inicales
		System.out.println("Número de reservas es:" + Reserva.muestraNumeroReservas()); 
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual()); 

		//Generamos un Localizador
		// System.out.println("Nuevo Localizador es :" + Reserva.generaLocalizador()); //El método es private, no es accesible desde fuera de su Class
		// Reserva.numeroReserva++; //No tiene visibilidad es una private static, no tiene visibilidad fuera de cu Class
		
		//Creamos primera reserva
		Reserva r1 = new Reserva("Tomeu Sabater", "2024-07-01"); 
		r1.muestraReserva(); 
		
		//Creamos segunda reserva
		Reserva r2 = new Reserva("Pepito Pérez", "2024-08-15"); 
		r2.muestraReserva(); 
		
		// Comprobamos datos 
		System.out.println("*****************"); 
		System.out.println("Número de reservas es:" + Reserva.muestraNumeroReservas()); 
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual()); 
		
		//Comprobamos que los localizadores de las reservas no han variado
		r1.muestraReserva(); 
		r2.muestraReserva(); 
	} //public static void main

} // class Leccion_13_ejercicio
