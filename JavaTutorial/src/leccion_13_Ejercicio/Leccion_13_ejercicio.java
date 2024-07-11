package leccion_13_Ejercicio;


public class Leccion_13_ejercicio {

	public static void main(String[] args) {
	
				
		// Introducción_VI a CLASES Y OBJETOS. 
		// Nested Class; Inner Class / Static Class
		// Control de Acceso

		// Simplificación de Leccion_12_Ejercicio (Se aplica misma solución que el Leccion_10_Ejercicio y Leccion_10_Ejercicio_bis)
				
		// Intentamos genera una solución más sencilla mediante una combinación de elementos (variables y métodos) privados estáticos
		// El objetivo es el mismo; evitar la posibilidad de manipular el localizador (la generación de un número consecutivo que forma parte del localizador) 
		
		// La Reserva se identifica con un localizador que tiene que ser único, para ello hacemos uso de un contador 
		// No podemos manipular este contador desde el exterior, solo saber su valor actual (Número reservas totales) y/o localizador actual
		// En la creación de una Reserva, se genera el localizador único que contiene el contador actual y se incrementa el contador para siguiente

	
		// Comprobamos datos inicales
		System.out.println("Número de reservas es:" + Reserva.muestraNumeroReservas()); 
		System.out.println("Localizador actual es :" + Reserva.muestraLocalizadorActual()); 

		
		//Generamos un Localizador
		//System.out.println("Nuevo Localizador es :" + Reserva.generaLocalizador()); //El método es private, no es accesible desde fuera de su Class
		//Reserva.numeroReserva++; //No tiene visibilidad es una private static, no tiene visibilidad fuera de cu Class
		
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
