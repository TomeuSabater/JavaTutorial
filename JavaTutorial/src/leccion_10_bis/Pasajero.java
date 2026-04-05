package leccion_10_bis;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pasajero {

	//// Class para los Pax o Clientes de una reserva

	//// Ctes de la Class

	private static final String ELEMENTO = "Cliente"; // Identifica el elemento
	private static final byte MIN_ADULT_YEARS = 18; // Fija edad mínima para Adultos, podría ser una Cte para cada país

	//// Atributos o variables de instancia, variables de Obj Pasajero

	private String passport = null; // Pasaporte o DNI

	private String nombre = null; // Nombre de pila
	private String apellido1 = null; // Apellido1
	private String apellido2 = null; // Apellido2

	private LocalDate fechaNacimiento; // Fecha nacimiento pax

	//// Constructor único

	public Pasajero(String passport, String nombre, String apellido1, String apellido2, String fechaNacimiento) {

		this.passport = passport;
		this.nombre = nombre.toUpperCase();
		this.apellido1 = apellido1.toUpperCase();
		this.apellido2 = (apellido2 != null) ? apellido2.toUpperCase() : null;

		this.fechaNacimiento = LocalDate.parse(fechaNacimiento); // Se espera un formato yyyy-mm-dd

	} // Constructor

	//// Métodos públicos

	public void muestraPax() {
		// Vuelca los datos del pax
		System.out.println(Pasajero.ELEMENTO);
		System.out.println("Passport cliente :" + this.passport);
		System.out.println("Cliente adulto :" + this.esAdulto());
		System.out.println("Nombre :" + this.nombre);
		System.out.println("Apellido1 : " + this.apellido1);
		System.out.println("Apellido2 : " + this.apellido2);
	}

	//// Métodos privados

	// Determina si el pax es mayor de edad
	// Se opta por no almacenar edad al ser un dato dinámico
	// en su lugar se ofrece método que proporciona esta info
	private boolean esAdulto() {
		// Si el pax es mayor de edad en el momento consulta devuelve 'true'
		// Si no es mayor de edad en el momento de la consulta devuelve 'false'

		long anyos = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
		return (anyos >= Pasajero.MIN_ADULT_YEARS) ? true : false;

		// En una sola instrucción no quedaría claro:
		// return (ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now()) >=
		// Cliente.ADULT) ? true : false;
	} // esAdulto()

} // public class Pasajero
