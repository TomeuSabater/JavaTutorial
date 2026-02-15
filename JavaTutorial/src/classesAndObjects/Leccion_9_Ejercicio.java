package classesAndObjects;

import java.time.LocalDate;

public class Leccion_9_Ejercicio {

	public static void main(String[] args) {
				
		// EJERCICIO CLASES Y OBJETOS. 
		
		// En leccion_10_Ejercicio está resuelto con estructura correcta de Package

		// Se trata de diseñar una Class "Reserva" aplicando la mayoría de los conceptos vistos hasta el momento
		//
		// La Class Reserva tiene como atributos comunes:
		//		Número de reserva; compuesto por "Tipo/Año/Número"; 
		//			Tipo; HTL si es de Hotel, VUE si es un vuelo, TRL si es un traslado
		//			Año; Año en curso (del momento de la reserva, no de la fecha de consumo) 
		//			Número; Es un número consecutivo del tipo de reserva
		//			Ejemplos: "HTL/2024/0001", "HTL/2024/0002", "VUE/2024/001", "TRL/2024/0001",...
		//		Pax; máximo 4 Ejemplo; [Bartolomé Sabater, Juan Pérez, Pep Gonella, Pepito Perez]
		//		Fecha de Inicio/Llegada y Fecha de Fin/Salida; Ejemplo: 01-Agosto-2024, 05-Agosto-2024
		// 		Precio sin Impuestos y Precios con Impuestos (IVA 21%); Ejemplo: 1.000, 1.210
		// 
		// Atributos particulares:
		//		Si es HTL: 
		//			Dirección; Dirección postal del hotel
		//			Tipo de Habitación: [S]imple, [D]oble, [T]riple
		// 		Si es VUE:
		//			A/P de salida: Código 3 letras aeropuerto de salida, Ej: PMI, BCN, CUN, HAV, etc. 
		//			A/P de llegada: Código 3 letras aeropuerto de llegada, Ej: MAD, SVQ, JFK, ATL, etc. 
		//		Si es TRL:
		//			Recogida: Lugar de Recogida, es una dirección postal
		//			Destino: Lugar de Destino, es una dirección postal 
		// 
		// Tiene que haber un método constructor
		// Tiene que haber Getters y Setters para cada atributo de instancia
		// Tiene que haber un método que muestra el contenido de la reserva
		// Típicamente, habría 5 reservas: 2 x vuelo (ida/vuelta), 2 x traslado (a/p -> hotel, hotel -> a/p), 1 x  hotel 
		// Los pasajeros toman un Vuelo desde el A/P origen al A/P destino (reserva 1), a la llegada toman un Traslado cuyo destino es el Hotel (reserva 2), 
		// una vez finalizada la estancia en el Hotel (reserva 3) toman un Traslado hasta el A/P destino (reserva 4) donde un Vuelo los devuelve al A/P origen (reserva 5) 
		// 
		// Nota: En la realidad, existen más elementos, por ejemplo el seguro de viaje y entradas a museos, parques temáticos y otras atracciones, 
		//		todo ello se almacena en un único expediente, no trataremos esta estructura por el momento, nos limitamos a Reservas independientes. 

		
		// Se muestra una aproximación (no tiene todas las Sub Class) a una posible Solución:  
		
		// Diseñaremos una Super Class Reserva que contendrá los elementos comunes 
		//	y 3 Sub Class, para HTL, VUE y TRL cada una con los elemento que les sea particular
		// Nota: Sería adecuado tener el diagrama de Clases antes de empezar
	
		
		// Super Class Reserva 
		class Reserva {
			
			// Ctes de la Class
			private static final String ELEMENTO = "Reserva"; // Identifica el elemento 
			private static final byte MAX_NUM_PAX = 4; // Numero máximo de pasajeros
			private static final byte IVA = 21; // Impuestos aplicados
			
			// Atributos o Variables de Instancia
			
			// Número de la Reserva (De cada una de las reservas)
			protected String numeroReserva = null; //Se rellenará en cada sub clase, no puede ser private 
			
			// Pax, máximo de 4
			private String[] pax = new String[Reserva.MAX_NUM_PAX];
			
			// Fechas Inicio/Llegada, Fin/Salida
			private LocalDate fechaInicio;  // Inicio o Llegada, se podría inicializar con LocalDate.now();
			private LocalDate fechaFin; // Fin o Salida, se podría inicializar con LocalDate.now();
			
			//Precio
			private int precioNeto = 0; //Precio sin impuestos
			private int precioBruto = 0; //Precio con impuestos
						
			// Método constructor
			public Reserva(String pax1, String pax2, String pax3, String pax4, String fInicio, String fFin, int neto) {
				
				//Asigna pax
				this.asignaPax(pax1, pax2, pax3, pax4); // Asigna los pax 
				
				//Fechas Inicio y Fin
				this.fechaInicio = LocalDate.parse(fInicio); // Se espera un formato de fecha yyyy-mm-dd
				this.fechaFin = LocalDate.parse(fFin); 	// Se espera un formato de fecha yyyy-mm-dd
				
				//Precios
				this.precioNeto = neto; 
				this.precioBruto = calculaBruto(this.precioNeto); 
			}
			
			// Metodos Privados
			
			// Asigna Pax
			private void asignaPax(String p1, String p2, String p3, String p4) {
				
				this.pax[0] = p1; 
				this.pax[1] = p2;
				this.pax[2] = p3;
				this.pax[3] = p4; 	
			}
			
			// Calcula Precio Bruto
			private int calculaBruto(int neto) {
				
				return (neto + ((neto * Reserva.IVA) / 100)); 
			}
			
			// Métodos Públicos
			
			// Muestra las Fechas Inicio/Entrada Fin/Salida 
			public void muestraFechas()  {
				
				System.out.println("Fecha Inicio : " + this.fechaInicio);
				System.out.println("Fecha Fin :" + this.fechaFin); 
			}
						
			// Muestra Pax
			public void muestraPax() {
				
				byte contador = 0; /// Orden del pasajero 
				for (String pasajero : this.pax) {
				  System.out.println("Pasajero " + ++contador + " : " + pasajero);
				}
			}
			
			// Mostrar Reserva 
			public void muestraReserva() {
				
				System.out.println(Reserva.ELEMENTO); 
				muestraPax(); 
				muestraFechas(); 
				System.out.println("Precio Neto : " + this.precioNeto);
				System.out.println("Precio Bruto: " + this.precioBruto); 
			} // Mostrar Reserva
			
		} // Class Reserva 
		
		//Creamos una Super Reserva para probar lo definido hasta el momento
		//Realmente, no deberíamos tener ninguna Super Reservas, la instanciamos por motivos de test
		Reserva r1 = new Reserva("Tomeu Sabater", null, null, null, "2026-02-01", "2026-02-03", 1000);
		r1.muestraReserva(); 

		// Creamos ahora las 3 x Class para cada una de las Reservas Particulares
		
		// Class Reserva de Hotel especializa Class Reserva
		class ReservaHTL extends Reserva {
			
			// Ctes particulares de la Class ReservaHTL
			private static final String ELEMENTO = "Reserva de Hotel"; // Identifica el elemento
			private static final String TIPO_RESERVA = "HTL"; //Tipo de Reserva
			
			// Atributos de la Class ReservaHTL
			// mismo atributo y valor para todos los Obj
			// Se inicializa con un bloque de código, no es posible volver a inicializarlo 
			private static int numReservaHtl; 
			static {
				ReservaHTL.numReservaHtl = 0; 
			}
						
			// Atributos o Variables de Instancia del Obj ReservaHTL
			// cada Obj tendrá un atributo con su valor particular 
			private String direccionHtl = null; // Dirección Postal del Hotel
			private char tipoHab = '\0';  	//Tipo de Habitación: Simple, Doble, Triple
											//Posteriormente veremos los tipo enum
			
			
			// Métodos static que gestionan variables static
			
			// Devuelve el número actual de Reservas de Hotel
			public static int numReservasHotel() {
				
				return ReservaHTL.numReservaHtl; 
			}		
			
			
			// Método constructor
			public ReservaHTL(String pax1, String pax2, String pax3, String pax4, 
								String fInicio, String fFin, 
								String direccion, 
								char habitacion, 
								int neto) {
				
				// Llamamos al constructor de la Super Class Reserva 
				super(pax1, pax2, pax3, pax4, fInicio, fFin, neto);
				
				//Asignamos valores a los atributos particuales de ReservaHTL
				this.direccionHtl = direccion; // Dirección Hotel 
				this.tipoHab = habitacion; // Tipo de habitación 
				
				//Asignamos número de reserva
				this.numeroReserva = generaNuevoNumeroReserva(); 
			}
			
			
			// Métodos privados
			
			//Genera el número de reserva para la reserva de hotel 
			//Sería más adecuado que fuera un método static
			private static String generaNuevoNumeroReserva() {
				
				LocalDate hoy = LocalDate.now(); // Fecha actual
				int anyo = hoy.getYear(); //Obtenemos el año
				String sanyo = String.valueOf(anyo); //Transformamos año en String
				String numeroHlt = String.valueOf(++ReservaHTL.numReservaHtl); 
				
				String numero = ReservaHTL.TIPO_RESERVA + "/" + sanyo + "/" + numeroHlt; 
				return numero; 
			} // generaNuevoNumeroReserva()
			
			
			// Métodos públicos
			
			//Mostrar Reserva 
			public void muestraReserva() {
				
				super.muestraReserva(); //Llamamos al método de la Super Class
				System.out.println(ReservaHTL.ELEMENTO); 
				System.out.println("Número de Reserva :" + this.numeroReserva); 
				System.out.println("Dirección : " + this.direccionHtl);
				System.out.println("Tipo Habitación : " + this.tipoHab); 
				
			} // Mostrar Reserva
			
		} // class ReservaHTL
		
		//Hacemos algunas pruebas con ReservaHTL
		
		//Creamos una primera Reserva de Hotel
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
		ReservaHTL.numReservaHtl++; // Es posible, se explica motivo más abajo
		System.out.println("Actualmente hay " + ReservaHTL.numReservasHotel() + " Reservas de tipo " + ReservaHTL.ELEMENTO); 
		
		//No podemos reinicializar el valor de numReservaHtl una vez inicializado
		//Si hemos podido alterar el valor porque estamos dentro de la misma class Leccion_9_Ejercicio
		//Para aplicar correctamente el nivel de protección debemos separar cada Class en ficheros separados
		//Realmente, estamos anidando la Super Class y las Sub Class dentro de la Clas Leccion_9 y los niveles de protección no actúan como deseamos
		//Lo haremos correctamente en la Lección_10_Ejercicio, junto con las Sub Class para ReservaVUE y ReservaTRL

	} // public static void main

} // Leccion_9_Ejercicio. Pasar a Leccion_10_Ejercicio.java donde está estructurado en un Package
