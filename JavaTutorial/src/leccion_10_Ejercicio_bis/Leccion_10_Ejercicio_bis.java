package leccion_10_Ejercicio_bis;

public class Leccion_10_Ejercicio_bis {
	
	// EJERCICIO CLASES Y OBJETOS. 
	
			// Mejoras sobre leccion_10_Ejercicio.java:
	
			// 		Se añade Número TOTAL de reservas
			// 		Se añaden bloques de código de inicialización de variables
			// 		Los pax se implementan mediante una Class Cliente, hay un cliente principal o titular

			// Se trata de diseñar una Class Reserva aplicando la mayoría de los conceptos vistos hasta el momento
			// La Class Reserva tiene como atributos comunes:
			//		Número de reserva; compuesto por "NúmeroTotal/Tipo/Año/NúmeroParcial"; 
			//			NúmeroTotal: Es un número consecutivo único para cada Reserva
			//			Tipo; HTL si es de Hotel, VUE si es un vuelo, TRL si es un traslado
			//			Año; Año en curso (del momento de la reserva, no de la fecha de consumo) 
			//			Número Parcial; Es un número consecutivo del tipo de reserva
			//			Ejemplos: "001/HTL/2024/0001", "002/HTL/2024/0002", "003/VUE/2024/001", "004/TRL/2024/0001",...
			//		Pax; máximo 4 Ejemplo; [Bartolomé Sabater, Juan Pérez, Pep Gonella, Pepito Perez]
			//		Fecha de Inicio/Llegada y Fecha de Fin/Salida; Ejemplo: 01-Agosto-2024, 05-Agosto-2024
			// 		Precio sin Impuestos y Precios con Impuestos (IVA 21%); Ejemplo: 1.000, 1.210
			// Atributos particulares:
			//		Si es HTL: 
			//			Dirección; Dirección postal del hotel
			//			Tipo de Habitación: [S]imple, [D]oble, [T]riple
			// 		Si es VUE:
			//			A/P de salida: Código 3 letras aeropuerto de salida, Eje: PMI
			//			A/P de llegada: Código 3 letras aeropuerto de llegada, Eje: MAD
			//		Si es TRL:
			//			Recogida: Lugar de Recogida, es una dirección postal
			//			Destino: Lugar de Destino, es una dirección postal 
			// Tiene que haber un método constructor
			// Tiene que haber Getters y Setters para los Atributos principales
			// Tiene que haber un método que muestra el contenido de la reserva
			// Lo más importante; NúmeroTotal y NúmeroParcial deben quedar "ocultos" tal que no sea posible su manipulación a excepción de la Instanciación donde se usarán
			// 		para crear el Número de Reserva de cada reserva. 
			// Típicamente, habría 5 reservas: 2 x vuelo, 2 x traslado, 1 x  hotel 
			// Los pasajeros toman un Vuelo desde el A/P origen al A/P destino (reserva 1), a la llegada toman un Traslado cuyo destino es el Hotel (reserva 2), 
			// una vez finalizada la estancia en el Hotel (reserva 3) toman un Traslado hasta el A/P destino (reserva 4) donde un Vuelo los devuelve al A/P origen (reserva 5) 
			// Nota: En la realidad, existen más elementos, por ejemplo el seguro de viaje y entradas a museos, parques temáticos y otras atracciones, 
			//		todo ello se almacena en un único expediente, no trataremos esta estructura expediente por el momento, nos limitamos a Reservas independientes. 
						
			// Se muestra una posible Solución:  

	public static void main(String[] args) {
		
		// Inicialmente, y sin instanciar ninguna Sub Class, podemos saber cuántas reserva hay de cada tipo y cuantas totales
		// mediante la invocación del método static de la Class
		System.out.println("Reservas totales = " + Reserva.numReservas()); 
		System.out.println("Reservas de tipo HTL = " + ReservaHTL.numReservasHotel()); 
		System.out.println("Reservas de tipo VUE = " + ReservaVUE.numReservasVuelo()); 
		System.out.println("Reservas de tipo TRL = " + ReservaTRL.numReservasTraslado()); 
		
		
		//// Hacemos algunas pruebas con ReservaHTL
		
		// Creamos una primera Reserva de Hotel
		ReservaHTL r2;
		r2 = new ReservaHTL("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "Padre Ventura", 'D', 1000); 
		r2.muestraReserva(); 
				
		//Comprobamos cuántas reservas totales hay y de Hotel
		System.out.println("Actualmente hay " + Reserva.numReservas() + " Reservas totales"); 
		System.out.println("Actualmente hay " + ReservaHTL.numReservasHotel() + " Reservas de tipo HTL"); 
				
		//Creamos una segunda Reserva de Hotel
		ReservaHTL r3;
		r3 = new ReservaHTL("Juan Pérez","Benito Boniato", null, null, "2024-08-15", "2024-09-17", "Juan Maragall", 'S', 3000); 
		r3.muestraReserva(); 
				
		//Comprobamos cuántas reservas de Hotel hay
		System.out.println("Actualmente hay " + Reserva.numReservas() + " Reservas totales"); 
		System.out.println("Actualmente hay " + ReservaHTL.numReservasHotel() + " Reservas de tipo HTL"); 
		
		//Intentamos alterar el numReserva y/o el numReservaHtl
		//System.out.println(Reserva.generaNumTotalReservas()); // No funciona, es un método privado. 
		//Reserva.numReserva++ // No funciona, es una private static, no tiene visibilidad 
		//ReservaHTL.numReservaHtl++; // Genera un error, es una static de tipo private, no tiene visibilidad
		//String numero = ReservaHTL.generaNuevoNumeroReserva(); // Genera un error, este método static de tipo private no tiene visibilidad
	
		
		//// Hacemos algunas pruebas con ReservaVUE
		
		// Creamos una primera Reserva de Vuelo
		ReservaVUE r4;
		r4 = new ReservaVUE("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "PMI", "MAD", 1000); 
		r4.muestraReserva(); 
		
		//Comprobamos cuántas reservas de Vuelo hay
		System.out.println("Actualmente hay " + Reserva.numReservas() + " Reservas totales"); 
		System.out.println("Actualmente hay " + ReservaVUE.numReservasVuelo() + " Reservas de tipo VUE"); 
		
		//// Hacemos algunas pruebas con ReservaTRL
		
		// Creamos una primera Reserva de Traslado
		ReservaTRL r5;
		r5 = new ReservaTRL("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "Palma Centro", "A/P PMI", 1000); 
		r5.muestraReserva(); 
		
		//Comprobamos cuántas reservas de Traslado hay
		System.out.println("Actualmente hay " + Reserva.numReservas() + " Reservas totales"); 
		System.out.println("Actualmente hay " + ReservaTRL.numReservasTraslado() + " Reservas de tipo TRL"); 


	} // public static void main
	
	// Tenemos que encontrar alguna manera de aislar el numero total de reservas y el número particular de reservas
	// La manera que hemos aplicado ha sido con variables y métodos privados que se invocan únicamente mediante los constructores
	// Al invocarse únicamente con el constructor, es necesario la generación de una reserva para alterar su valor
	// También podemos probar con Nested Class, es decir, Una Class dentro de otra Class
	

} // class Leccion_10_Ejercicio_bis
