package Leccion_5_Ejercicio;

public class BicyclePlus extends Bicycle {

	// Además de los atributos que hereda de la Super Class Bicycle
	// añadiremos los siguiente nuevos atributos

	// Variables de la Class BicyclePlus
	static final int NUM_GEARS = 6; // Número de marchas, es static y final (cte compartida)

	// Variables de Instancia, se inicializan
	private int cadence = 0; // Nuevo atributo cadencia, con valor inicial.
	private float speed = 0; // Nuevo atributo velocidad, con valor inicial.
	private int gear = 1; // Nuevo atributo marcha, con valor inicial.

	// Metodo constructor, usaremos el constructor de la Super Class
	// El constructor puede/debe usar el de la Super Class
	BicyclePlus(String brand, String model, boolean ebike) {

		// Invoca constructor de la Super Class
		super(brand, model, ebike);
	}

	// Getters, uno para cada nuevo atributo, públicos para poder llamarlos sin
	// problemas
	// Para esta Class, al ser heredada, también oferta los de la Super Class
	public int getCadence() {
		return this.cadence;
	}

	public float getSpeed() {
		return this.speed;
	}

	public int getGear() {
		return this.gear;
	}

	// Setters, no existen puesto que no permitiremos asignar de manera "directa"
	// valores a los nuevos atributos
	// En su lugar, ofreceremos algún método para asignarlos

	// Método privado: No es posible invocarlo desde el exterior del Objeto
	// No es posible aumenter la velocidad de manera "directa"
	// El método es llamado con parámetros
	private void changeSpeed(int value) {

		// incremento / decremento velocidad
		speed += (value * 0.3);
	}

	// Método público para aumentar/disminuir la cadencia
	// Si es posible llamarlo desde el exterior de la Class
	// Se llama con parámetros
	public void changeCadence(int value) {

		// incremento / decremento cadencia
		cadence += value;
		// invocamos el método privado, accesible desde dentro de la Class
		changeSpeed(value);
	} // changeCadence

	// Método público para aumentar/disminuir de marcha
	// Si es posible llamarlo desde el exterior de la Class
	// Se llama con parámetros
	public void changeGear(int value) {

		// Controlamos el máximo y mínimo de marchas
		if ((this.gear + value) > BicyclePlus.NUM_GEARS) {
			// Ya era la marcha más alta
			this.gear = BicyclePlus.NUM_GEARS;
		} else if ((this.gear + value) < 1) {
			// Ya era la marcha más baja
			this.gear = 1;
		} else {
			// Cambiamos de marcha
			this.gear += value;
		}
		changeSpeed(value); // invocamos el método privado
	} // changeGear

	// Método públic que oferta la operación de frenado
	public void applyBrake(int intensity) {

		// Debe ser siempre un valor negativo
		if (intensity > 0) {
			intensity *= -1;
		}
		changeSpeed(intensity); // invocamos al método privado
	} // applyBrake

	// Método público para mostrar valores, utilizaremos el de la Super Clase
	public void showBicyle() {

		super.showBicycle(); // Utilizamos el método de la Super Class
		// Además, mostramos los atributos de la Class
		System.out.println("Cadence : " + getCadence());
		System.out.println("Gear : " + getGear());
		System.out.println("Speed : " + getSpeed());
	}

} // public class BicyclePlus
