package classesAndObjects;

import java.time.LocalDate;

public class Leccion_14_bis {

	public static void main(String[] args) {
		
		// Introducción_VII a CLASES Y OBJETOS. 
		
		// Local Class (Caso especial de una Inner Class) 
		
		// Intentamos dar un ejemplo de Local Class:
		// Tendremos una Class Entrada que simula la entrada a un espectáculo
		// por ejemplo, un cine, teatro, espectáculo musical, parque temático, etc. 
		// La Entrada está diseñada para una única persona
		// el problema que se plantea es que "Persona" tiene complejidad
		//	- fecha de nacimiento (edad, hay mínimo según espectáculo) 
		// 	- es / no es mayor de edad (según país) 
		//	- peso (en varias unidades, hay máximo según espctáculo)
		//	- altura (en varias unidades, hay mínimo según parque)
		// 	- talla (de ropa, requerido según actividad que proporciona equipamiento)
		//  - talla (de zapatos, requerido según actividad que proporciona equipamiento) 
		
		// Con el objetivo de reducir la complejidad y concentrar el código,
		// consideramos que debería existir un Local Class Persona que gestionará toda la 
		// información de Persona, así como volcar su información en diferentes unidades 
		
		class Entrada { // Es la Class principal que contendrá la Local Class
			
			static final String ELEMENTO = "Entrada";
			
			private LocalDate fechaReserva; // Fecha de compra entrada
			private LocalDate fechaEvento; // Fecha del evento
			
			private String nombrePax;
			private String apellido1Pax;
			private String apellido2Pax = null; // No obligatorio
			private LocalDate fechaNacimiento; 
			private Boolean esMayorEdad; 
			
			private float pesoPaxMDC; // Sistema Métrico Decimal (Kilos y Gramos) 
			private float pesoPaxIMP; // Sistema Imperial (Onza y Libra) 
			
			private int alturaPaxMDC; // Sistema Métrico Decimal (Centímetros)
			private float alturaPaxIMP; // Sistema Imperial (Pulgadas)
			
			private String tallaPaxCode;  // XS, S, M, L, XL, XXL : Se considera universal
			private String tallaPaxName; // Extra Small, Small, Medium, Large, Extra Large, Super Large
			
			private byte numeroPiePaxEU; // Ej; 34, 36, 42, 
			private float numeroPiePaxUSA; // Eje:5.5, 7, 8.5, 10.5
			
			//Constructor
			
			public Entrada(String fechaEvento, String nombrePax, String apellido1Pax, String apellido2Pax, 
						String fechaNacimiento, float pesoPax, int alturaPax, String tallaPax, byte numeroPie) {
								
				// Decidimos crear una Local Class para gestionar toda la 
				// complejidad del Pasajero
				// Definimo y usamos esta Local Class en el constructor de Entrada 
				
				
				class Pax { // Local Class
					
					static final int ESMAYOR = 18; // Edad mínima 
					static final float KILOALIBRA = 2.2f; // Factor conversión aprox. 
					static final float CMAPULGADA = 2.54f; // Factor conversión aprox.
					
					private String nombrePax;
					private String apellido1Pax;
					private String apellido2Pax = null; 
					private LocalDate fechaNacimiento; 
					
					private float pesoPaxMDC; // Sistema Métrico Decimal (Kilos y Gramos) 
					private float alturaPaxMDC; // Sistema Métrico Decimal (Metros y Centímetros)
					
					private String tallaPaxCode;  // XS, S, M, L, XL, XXL
					private byte numeroPiePaxEU; // Ej; 34, 36, 42, 
											
					// Constructor de la Local Class
					public Pax(String nombrePax, String apellido1Pax, String apellido2Pax, 
								LocalDate fechaNacimiento, float pesoPaxMDC, float alturaPaxMDC,
								String tallaPaxCode, byte numeroPiePax) {
						
						this.nombrePax = nombrePax;
						this.apellido1Pax = apellido1Pax; 
						this.pesoPaxMDC = pesoPaxMDC; 
						this.alturaPaxMDC = alturaPaxMDC; 
						this.tallaPaxCode = tallaPaxCode; 
						this.numeroPiePaxEU = numeroPiePax; 
						
					} // Constructor
					
					// Métodos de la Local Class
					
					private String getNomPax() {
						// Limpiamos y formateamos el Nombre
						
						String NomLimpio; // Variable temporal 
						
						NomLimpio = nombrePax.replaceAll("[^a-zA-Z]", "");
						if (NomLimpio == "") {
							return null; 
						} else {
							return NomLimpio.toUpperCase(); 
						}
					}			
					
					private String getAp1Pax() {
						// Limpiamos y formateamos el Apellido1
						
						String Ap1Limpio; // Variable temporal 
						
						Ap1Limpio = apellido1Pax.replaceAll("[^a-zA-Z]", "");
						if (Ap1Limpio == "") {
							return null; 
						} else {
							return Ap1Limpio.toUpperCase(); 
						}
					}
					
					private String getAp2Pax() {
						// Limpiamos y formateamos el Apellido2
						
						String Ap2Limpio; // Variable temporal 
						
						Ap2Limpio = apellido2Pax.replaceAll("[^a-zA-Z]", "");
						if (Ap2Limpio == "") {
							return null; 
						} else {
							return Ap2Limpio.toUpperCase(); 
						}
					}
					
					private float getPesoPaxIMP () {
						// Pasamos del metrico 'kilogramo' al imperial 'libra'
						
						return (this.pesoPaxMDC * KILOALIBRA); 
					}
					
					private float getAlturaPaxIMP() {
						// Pasamos del decimal 'cm' a imperial 'pulgada'
						
						return (this.alturaPaxMDC * CMAPULGADA); 
					}
					
					private String getTallaPaxTexto() {
						// Convertimos código en descripción
						
						String tallaText = null; // Variable temporal 
						
						switch (this.tallaPaxCode) {
			
						case "XS":
							tallaText = "Extra Small";
							break;
						case "S":
							tallaText = "Small";
							break;
						case "M":
							tallaText = "Medium";
							break;
						case "L":
							tallaText = "Large";
							break;
						case "XL":
							tallaText = "Extra Large";
							break;
						case "XXL":
							tallaText = "Super Large";
						}
						
						return tallaText; 
					}
					
					private float getNumeroPieUSA() {
						// Convertimos medida pie EU en USA
						// conversión es aprox.
						
						return (float) ((this.numeroPiePaxEU * 0.75) - 23);					
					}
					
					
				} // Local Class Pax
				
				
				// Instanciación de la Local Class
				// Usaremos el Obj pasajero para obtener y formatear información del pasajero
				Pax pasajero = new Pax(nombrePax, apellido1Pax, apellido2Pax, 
						 fechaNacimiento, pesoPax, alturaPax, tallaPax, numeroPie); 
				
				// Fechas 
				this.fechaReserva = LocalDate.now(); 
				this.fechaEvento = LocalDate.parse(fechaEvento); 
			
				
				// Nombre y Apellidos		
				this.nombrePax = pasajero.getNomPax(); 
				this.apellido1Pax = pasajero.getAp1Pax(); 
				this.apellido2Pax = pasajero.getAp2Pax(); 
				
				// Pesos 
				this.pesoPaxMDC = pesoPax;
				this.pesoPaxIMP = pasajero.getPesoPaxIMP();
				
				// Alturas
				this.alturaPaxIMP = alturaPax;
				this.alturaPaxMDC = (int) pasajero.getAlturaPaxIMP(); 
				
				// Tallas
				this.tallaPaxCode = tallaPax; 
				this.tallaPaxName = pasajero.getTallaPaxTexto(); 
				this.numeroPiePaxEU = numeroPie; 
				this.numeroPiePaxUSA = pasajero.getNumeroPieUSA();  	
				
			} // Constructor de la Class Entrada
			
			public void printVoucher() {
			// Método que imprimer un Voucher
			
				System.out.println("************** VOUCHER **********");
				
				
				
			} // public void printVoucher
			
			
			
			
		} // Class Entrada
		
		
		// Generamos una Entrada
		Entrada entrada1; 
		entrada1 = new Entrada("2026-05-25", "Tomeu", "Sabater", "", "1966-03-18", 85.5f, 178, "XL", (byte)45);
			
		
		
		// public Entrada(LocalDate fechaEvento, String nombrePax, String apellido1Pax, String apellido2Pax, 
			//	 LocalDate fechaNacimiento, float pesoPax, float alturaPax,
				//  String tallaPax, byte numeroPie)
		
		
		
		// Imprimimos su Voucher
		entrada1.printVoucher(); 
		

	} // public static void main

} // public class Leccion_14_bis 
