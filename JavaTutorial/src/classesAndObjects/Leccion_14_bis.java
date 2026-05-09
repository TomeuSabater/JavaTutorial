package classesAndObjects;

import java.time.LocalDate;

public class Leccion_14_bis {

	public static void main(String[] args) {
		
		// Introducción_VII a CLASES Y OBJETOS. 
		
		// Local Class (Caso especial de una Inner Class) 
		
		// Intentamos dar un ejemplo de Local Class
		// Tendremos una Class Entrada que simula la entrada a un espectáculo
		// por ejemplo, un cine, teatro, espectáculo musical, parque temático, etc. 
		// La Entrada está diseñada para una única persona
		// el problema es que Persona tiene mucha complejidad
		//	- fecha de nacimiento (edad, hay mínimo según espectáculo) 
		// 	- es / no es mayor de edad (según país) 
		//	- peso (en varias unidades, hay máximo según espctáculo)
		//	- altura (en varias unidades, hay mínimo según parque)
		// 	- Talla (de ropa, requerido según actividad que proporciona equipamiento)
		//  - Talla (de zapatos, requerido según actividad que proporciona equipamiento) 
		
		// Con el objetivo de reducir la complejidad y concentrar el código
		// consideramos que debería existir un Local Class Persona que gestinara toda la 
		// información de Persona, así como volcar su información 
		
		class Entrada {
			
			static final String ELEMENTO = "Entrada";
			private LocalDate fechaReserva; // Fecha de compra 
			private LocalDate fechaEvento; // Fecha del evento
			
			private String nombrePax;
			private String apellido1Pax;
			private String apellido2Pax = null; 
			private LocalDate fechaNacimiento; 
			private Boolean esMayorEdad; 
			
			private float pesoPaxMDC; // Sistema Métrico Decimal (Kilos y Gramos) 
			private float pesoPaxIMP; // Sistema Imperial (Onza y Libra) 
			
			private float alturaPaxMDC; // Sistema Métrico Decimal (Centímetros)
			private float alturaPaxIMP; // Sistema Imperial (Pulgadas)
			
			private String tallaPaxCode;  // XS, S, M, L, XL, XXL
			private String tallaPaxName; // Extra Small, Small, Medium, Large, Extra Large, Super Large
			
			private byte numeroPiePaxEU; // Ej; 34, 36, 42, 
			private float numeroPiePaXUSA; // Eje:5.5, 7, 8.5, 10.5
			
			//Constructor
			
			public Entrada(LocalDate fechaEvento, String nombrePax, String apellido1Pax, String apellido2Pax, 
			 LocalDate fechaNacimiento, float pesoPax, float alturaPax,
			 String tallaPax, String numeroPiePax) {
								
				// Decidimos crear una Local Class para gestionar toda la 
				// complejidad del Pasajero
				// Definimo y usamos esta Local Class en el constructor 
				
				class Pax {
					
					static final int ESMAYOR = 18; 
					static final float KILOALIBRA = 2.2f; 
					static final float CMAPULGADA = 2.54f;
					
					private String nombrePax;
					private String apellido1Pax;
					private String apellido2Pax = null; 
					private LocalDate fechaNacimiento; 
					
					private float pesoPaxMDC; // Sistema Métrico Decimal (Kilos y Gramos) 
					private float alturaPaxMDC; // Sistema Métrico Decimal (Metros y Centímetros)
					private String tallaPax;  // XS, S, M, L, XL, XXL
					private byte numeroPiePaxEU; // Ej; 34, 36, 42, 
											
					
					// Constructor
					public Pax(String nombrePax, String apellido1Pax, String apellido2Pax, 
								LocalDate fechaNacimiento, float pesoPaxMDC, float alturaPaxMDC,
								String tallaPaxEU, String numeroPiePax) {
						
						this.nombrePax = nombrePax;
						this.apellido1Pax = apellido1Pax; 
						this.pesoPaxMDC = pesoPaxMDC; 
						
					} // Constructor
					
					// Métodos
					
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
						
						// Pasamos del metrico decimal 'kilogramo' al imperial 'libra'
						return (this.pesoPaxMDC * KILOALIBRA); 
					}
					
					private float getAlturaPaxIMP() {
						
						// Pasamos del métrico decimal 'cm' a imperial 'pulgada'
						
					}
					
					
							
				} // Local Class Pax
				
				
				// Instanciación de la Local Class
				// Usaremos el Obj pasajero para obtener y formatear información del pasajero
				Pax pasajero = new Pax(nombrePax, apellido1Pax, apellido2Pax, 
						 fechaNacimiento, pesoPax, alturaPax, tallaPax, numeroPiePax); 
				
				// Fechas 
				this.fechaReserva = LocalDate.now(); 
				this.fechaEvento = fechaEvento; 
				
				// Nombre y Apellidos		
				this.nombrePax = pasajero.getNomPax(); 
				this.apellido1Pax = pasajero.getAp1Pax(); 
				this.apellido2Pax = pasajero.getAp2Pax(); 
				
				// Pesos 
				this.pesoPaxMDC = pesoPax;
				this.pesoPaxIMP = pasajero.getPesoPaxIMP();
				
				// Alturas
				this.alturaPaxIMP = alturaPax;
				this.alturaPaxMDC = pasajero.getAlturaPaxIMP(); 
					
						
				
			} // Constructor de la Class Entrada
			
		} // Local Class Entrada
		

	} // public static void main

} // public class Leccion_14_bis 
