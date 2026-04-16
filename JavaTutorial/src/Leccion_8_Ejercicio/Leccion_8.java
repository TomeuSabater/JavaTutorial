package Leccion_8_Ejercicio;

public class Leccion_8 {

	public static void main(String[] args) {
		
		class Bicycle {
			
			private static final String ELEMENTO ="Bicycle"; 
			private static int numTotalBikes = 0; // Próximo numero de serie
			
			private int numSerialBike = 0; // Número de serie
			private String nombreBike; 
			private int precio = 0; 
			
			public Bicycle(String nombre, int precio) {
				
				this.nombreBike = nombre; 
				this.precio = precio; 
				this.numSerialBike = ++Bicycle.numTotalBikes; 
			}
			
			public void showBicyle() {
				System.out.println(Bicycle.ELEMENTO); 
				System.out.println("Serial number =" + this.numSerialBike); 
				System.out.println("Name =" + this.nombreBike); 
				System.out.println("Precio = " + this.precio); 
			}
		} // Class Bicycle
			
		
		System.out.println("Siguiente numero de serie = " + Bicycle.numTotalBikes); 
		
		Bicycle.numTotalBikes++; 
		
		Bicycle bicicleta1 = new Bicycle("Orbea", 1500);
		bicicleta1.showBicyle();
		
		Bicycle bicicleta2 = new Bicycle("BH", 2500);
		bicicleta2.showBicyle();
		
		System.out.println("Siguiente numero de serie = " + Bicycle.numTotalBikes); 
		
		
		class Booking {
			
			// Variables staticas
			static final String ELEMENTO = "Booking"; //cte
			private static int numActualReservas = 0; 
			
			// Variables de instancia 
			private int numReserva = 0; 
			private String nombre; 
			private int precio = 0; 
			
			// Constructor
			public Booking(String nombrePasajero, int precioReserva) {
				
				this.nombre = nombrePasajero; 
				this.precio = precioReserva; 
				this.numReserva = Booking.numActualReservas++; 
			}
			
			// Métodos públicos
			public void showBooking() {
				System.out.println("Elemento " + Booking.ELEMENTO + " Numero " + Booking.numActualReservas);
				System.out.println("Nombre " + this.nombre);
				System.out.println("Precio " + this.precio);
			}
			
			// Métodos estáticos
			public static int  getNumActualReserva() {
				
				return Booking.numActualReservas; 
			}
		}
		
		Booking.getNumActualReserva(); 
		
		Booking reserva1 = new Booking("Tomeu Sabater", 1500);
		reserva1.showBooking();
		
		
		

	} // Main 

}
