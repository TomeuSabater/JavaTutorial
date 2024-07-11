package Leccion_12_Ejercicio_bis;

// import Leccion_12_Ejercicio_bis.Reserva.LocalizadorReservaInner; // No es posible importar esta Inner Class, genera un error de visibilidad
// import Leccion_12_Ejercicio_bis.Reserva.LocalizadorReservaStatic; // No es posible importar esta Static Class, genera un error de visibilidad

public class Leccion_12_Ejercicio_bis {

	
	// Introducción_VI a CLASES Y OBJETOS. 
	// Nested Class; Inner Class / Static Nested Class
	
	// En este ejercicio aplicaremos dos Nested Class; Una Inner Class y una Static Nested Class
	// 		ambas Nested Class llevan a cabo el mismo objetivo; Generar un Localizador compuesto por: 
	// 		- YYYY/MM/Contador. Ejemplo: 2024/07/1
	// 		- YYYY: Año en curso
	// 		- MM: Mes en curso
	// 		- Contador: Número consecutivo incremental
	
	// Existirá una Class Contenedora (Outer Class) Class Reserva que contendrá las dos Nested Class: 
	//		- 	private static class LocalizadorReserva como la que hemos aplicado en la Leccion_12_Ejercicio
	//		-   private class LocalizadorReserva
	// Ambas Class tienen como objetivo generar un Localizador de la Reserva
	// Cada Reserva tiene 2 x Localizador, uno generado por cada Nested Class
	
	// El objetivo es evaluar el comportamiento y diferencias de cada una de las Nested Class
	
	public static void main(String[] args) {
		
		System.out.println("Ejercicio para analizar comportamiento de Nested Class: Inner Class & Static Nested Class"); 
		
		//Comprobamos datos inicales
		System.out.println("*********************************");
		System.out.println("Número de reservas Inner es:" + Reserva.muestraNumerodeReservaInner()); 
		System.out.println("Número de reservas Static es:" + Reserva.muestraNumerodeReservaStatic()); 
		System.out.println("Localizador actual Inner es :" + Reserva.muestraLocalizadorActualInner()); 
		System.out.println("Localizador actual Static es :" + Reserva.muestraLocalizadorActualStatic()); 
		

		//Intentamos generar Localizadores
		//System.out.println("Nuevo Localizador Static es :" + LocalizadorReservaStatic.generaLocalizador()); //No es accesible, está oculto en la Class Reserva
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
		System.out.println("Número de reservas Inner es:" + Reserva.muestraNumerodeReservaInner()); 
		System.out.println("Número de reservas Static es:" + Reserva.muestraNumerodeReservaStatic()); 
		System.out.println("Localizador actual Inner es :" + Reserva.muestraLocalizadorActualInner()); 
		System.out.println("Localizador actual Static es :" + Reserva.muestraLocalizadorActualStatic()); 

		// Realmente no hemos encontrado ninguna diferencia en el uso de una Inner o de una Static
		// No obstante, sabiendo que la Inner Class sí tiene acceso a datos de la Class contenedora, podemos reescribirlo de otra manera
		// 	Vamos a instanciar las Nested Class, y eliminamos los elementos static en la Inner Class, a ver qué tal. 
		//  Lo haremos en Leccion_12_Ejercicio_bis_bis
		
	}

} // class Leccion_12_Ejercicio_bis 
