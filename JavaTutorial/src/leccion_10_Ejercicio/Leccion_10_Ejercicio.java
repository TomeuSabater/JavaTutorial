package leccion_10_Ejercicio;

public class Leccion_10_Ejercicio {

	public static void main(String[] args) {
		
		//// Hacemos algunas pruebas con la super Class Reserva
		
		// Creamos una reserva
		Reserva r1;
		r1 = new Reserva("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", 1000);
		r1.muestraReserva(); 
		
		//// Hacemos algunas pruebas con ReservaHTL
		
		// Creamos una primera Reserva de Hotel
		ReservaHTL r2;
		r2 = new ReservaHTL("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "Padre Ventura", 'D', 1000); 
		r2.muestraReserva(); 
				
		//Comprobamos cuántas reservas de Hotel hay
		System.out.println("Actualmente hay " + ReservaHTL.numReservasHotel() + " Reservas de tipo " + ReservaHTL.ELEMENTO); 
				
		//Creamos una segunda Reserva de Hotel
		ReservaHTL r3;
		r3 = new ReservaHTL("Juan Pérez","Benito Boniato", null, null, "2024-08-15", "2024-09-17", "Juan Maragall", 'S', 3000); 
		r3.muestraReserva(); 
				
		//Comprobamos cuántas reservas de Hotel hay
		System.out.println("Actualmente hay " + ReservaHTL.numReservasHotel() + " Reservas de tipo " + ReservaHTL.ELEMENTO); 
		
		//Intentamos alterar el numReservasHotel
		//ReservaHTL.numReservaHtl++; --> Genera un error, es del tipo private	
		
		//// Hacemos algunas pruebas con ReservaVUE
		
		// Creamos una primera Reserva de Vuelo
		ReservaVUE r4;
		r4 = new ReservaVUE("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "PMI", "MAD", 1000); 
		r4.muestraReserva(); 
		
		//Comprobamos cuántas reservas de Vuelo hay
		System.out.println("Actualmente hay " + ReservaVUE.numReservasVuelo() + " Reservas de tipo " + ReservaVUE.ELEMENTO); 
		
		//// Hacemos algunas pruebas con ReservaTRL
		
		// Creamos una primera Reserva de Traslado
		ReservaTRL r5;
		r5 = new ReservaTRL("Tomeu Sabater", null, null, null, "2024-07-01", "2024-07-03", "Palma Centro", "A/P PMI", 1000); 
		r5.muestraReserva(); 
		
		//Comprobamos cuántas reservas de Vuelo hay
		System.out.println("Actualmente hay " + ReservaTRL.numReservasTraslado() + " Reservas de tipo " + ReservaTRL.ELEMENTO); 
		
	} // public static void main

} // class Leccion_10_Ejercicio
