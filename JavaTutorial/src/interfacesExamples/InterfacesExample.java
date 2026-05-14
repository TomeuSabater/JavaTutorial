package interfacesExamples;

public class InterfacesExample {

	public static void main(String[] args) {
		
		Reserva r1 = new Reserva("Tomeu", "Sabater", "1966-03-18", "ES", 80.5f);
		r1.showReserva();
		
		Reserva r2 = new Reserva("Bartolome", "Sabater", "1966-03-18", "US", 90.5f);
		r2.showReserva();

	}
}
