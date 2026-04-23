package leccion_10;

public class Leccion_10_Ejercicio {

	// EJERCICIO CLASES Y OBJETOS.

	// Se trata de diseñar una Class Reserva aplicando la mayoría de los conceptos
	// vistos hasta el momento
	// La Class Reserva tiene como atributos comunes:
	// Número de reserva; compuesto por "Tipo/Año/NúmeroParcial";
	// Tipo; HTL si es de Hotel, VUE si es un vuelo, TRL si es un traslado
	// Año; Año en curso (del momento de la reserva, no de la fecha de consumo)
	// Número Parcial; Es un número consecutivo del tipo de reserva (no hay contador
	// total en este ejemplo)
	// Ejemplos: "HTL/2024/0001", "HTL/2024/0002", "VUE/2024/001",
	// "TRL/2024/0001",...
	// Pax; máximo 4 Ejemplo; [Bartolomé Sabater, Juan Pérez, Pep Gonella, Pepito
	// Perez]
	// Fecha de Inicio/Llegada y Fecha de Fin/Salida; Ejemplo: 01-Agosto-2024,
	// 05-Agosto-2024
	// Precio sin Impuestos y Precios con Impuestos (IVA 21%); Ejemplo: 1.000, 1.210
	// Atributos particulares:
	// Si es HTL:
	// Dirección; Dirección postal del hotel
	// Tipo de Habitación: [S]imple, [D]oble, [T]riple
	// Si es VUE:
	// A/P de salida: Código 3 letras aeropuerto de salida, Eje: PMI
	// A/P de llegada: Código 3 letras aeropuerto de llegada, Eje: MAD
	// Si es TRL:
	// Recogida: Lugar de Recogida, es una dirección postal
	// Destino: Lugar de Destino, es una dirección postal
	// Tiene que haber un método constructor
	// Tiene que haber Getters y Setters para cada Atributo
	// Tiene que haber un método que muestra el contenido de la reserva
	// Típicamente, habría 5 reservas: 2 x vuelo, 2 x traslado, 1 x hotel
	// Los pasajeros toman un Vuelo desde el A/P origen al A/P destino (reserva 1),
	// a la llegada toman un Traslado cuyo destino es el Hotel (reserva 2),
	// una vez finalizada la estancia en el Hotel (reserva 3) toman un Traslado
	// hasta el A/P destino (reserva 4) donde un Vuelo los devuelve al A/P origen
	// (reserva 5)
	// Nota: En la realidad, existen más elementos, por ejemplo el seguro de viaje y
	// entradas a museos, parques temáticos y otras atracciones,
	// todo ello se almacena en un único expediente, no trataremos esta estructura
	// por el momento, nos limitamos a Reservas independientes.

	// Se muestra una posible Solución:

	public static void main(String[] args) {

		//// Comprobamos las variables de la Class; las static

		// Inicialmente, y sin instanciar ninguna Sub Class, podemos saber cuántas
		// reserva hay de cada tipo mediante la invocación del método static de la Class
		// Observar que NO es posible acceder directamente a las static porque las
		// definimos como private, en su lugar, el método estático es public
		System.out.println("Reservas de tipo HTL = " + ReservaHTL.numReservasHotel());
		System.out.println("Reservas de tipo VUE = " + ReservaVUE.numReservasVuelo());
		System.out.println("Reservas de tipo TRL = " + ReservaTRL.numReservasTraslado());
		// System.out.println("Reservas de tipo TRL = " + ReservaHTL.numReservaHtl);
		// System.out.println("Reservas de tipo TRL = " + ReservaVUE.numReservaVue);
		// System.out.println("Reservas de tipo TRL = " + ReservaTRL.numReservaTrl);

		//// Hacemos algunas pruebas con la super Class Reserva
		//// No deberíamos instancia esta super Class, lo hacemos por motivos de test

		// Creamos una reserva instanciando la Super Class Reserva
		Reserva reserva1;
		reserva1 = new Reserva("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", 1000);
		reserva1.muestraReserva();

		//// Hacemos algunas pruebas con ReservaHTL

		// Creamos una primera Reserva de Hotel
		ReservaHTL reserva2;
		reserva2 = new ReservaHTL("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "Padre Ventura", 'D',
				1000);
		reserva2.muestraReserva();

		// Comprobamos cuántas reservas de Hotel hay
		System.out.println("Actualmente hay " + ReservaHTL.numReservasHotel() + " Reservas de tipo HTL");

		// Creamos una segunda Reserva de Hotel
		ReservaHTL reserva3;
		reserva3 = new ReservaHTL("Juan Pérez", "Benito Boniato", null, null, "2024-08-15", "2024-09-17",
				"Juan Maragall", 'S', 3000);
		reserva3.muestraReserva();

		// Comprobamos cuántas reservas de Hotel hay
		System.out.println("Actualmente hay " + ReservaHTL.numReservasHotel() + " Reservas de tipo HTL");

		//// Comprobamos el nivel de protección de las static

		// Intentamos alterar el numReservasHotel
		// ReservaHTL.numReservaHtl++; --> Genera un error, es una static de tipo
		// private, es inaccesible exteriormente
		// String numero = ReservaHTL.generaNuevoNumeroReserva(); --> Genera un error,
		// este método static de tipo private; es inaccesible exteriormente

		//// Hacemos algunas pruebas con ReservaVUE

		// Creamos una primera Reserva de Vuelo
		ReservaVUE reserva4;
		reserva4 = new ReservaVUE("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "PMI", "MAD", 1000);
		reserva4.muestraReserva();

		// Comprobamos cuántas reservas de Vuelo hay
		System.out.println("Actualmente hay " + ReservaVUE.numReservasVuelo() + " Reservas de tipo VUE");

		//// Hacemos algunas pruebas con ReservaTRL

		// Creamos una primera Reserva de Traslado
		ReservaTRL reserva5;
		reserva5 = new ReservaTRL("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "Palma Centro",
				"A/P PMI", 1000);
		reserva5.muestraReserva();

		// Comprobamos cuántas reservas de Traslado hay
		System.out.println("Actualmente hay " + ReservaTRL.numReservasTraslado() + " Reservas de tipo TRL");

	} // public static void main

	// En el lección_10_Ejercicio_bis se construye una solución donde cohexisten el
	// Número Particular de la Reserva (único para cada tipo de reserva)
	// y el Número Total de la Reserva (único para todas las reservas, con
	// independencia de su tipo)

} // class Leccion_10_Ejercicio. Pasar a Leccion_10_Ejercicio_bis.java
