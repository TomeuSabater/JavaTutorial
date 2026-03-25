package classesAndObjects;

public class Tutorial_5 {

	public static void main(String[] args) {

		// Introducción_II a CLASES Y OBJETOS.

		// Shadowing en Constructores y Setters
		// Control en instanciación de clases
		// Concepto de Herencia (Inheritance)
		// Variables de Instancia Publicos/Privados

		class Bicycle {

			// Constantes y estáticas
			static final String ELEMENTO = "Bicycle";

			// Variables de instancia
			private String brand; // Marca
			private String model; // Modelo
			private boolean ebike; // Indica si es una e-bike

			// Constructores
			public Bicycle(String brand, String model, boolean ebike) {

				// java.util.Objects.requireNonNull(brand, "Parametro 'brand' no puede ser
				// null");
				// java.util.Objects.requireNonNull(model, "Parametro 'model' no puede ser
				// null");

				if (brand == null || brand.isBlank()) {
					throw new IllegalArgumentException("El Parámetro 'brand' es obligatorio");
				}

				if (brand == null || model.isBlank()) {
					throw new IllegalArgumentException("El Parámetro 'model' es obligatorio");
				}

				this.setBrand(brand);
				this.setModel(model);
				this.setEbike(ebike);
			}

			public Bicycle(String brand, String model) {

				this(brand, model, false);
			}

			// Setters

			public void setBrand(String brand) {

				this.brand = brand.toUpperCase();
			}

			public void setModel(String model) {

				this.model = model.toUpperCase();
			}

			public void setEbike(boolean ebike) {

				this.ebike = ebike;
			}

			// Getters

			public String getBrand() {

				return (this.brand);
			}

			public String getModel() {

				return (this.model);
			}

			public String getEbike() {

				if (ebike) {
					return ("Es una ebike");
				} else {
					return "Ee una muscular";
				}
			}

			public void showBike() {

				System.out.println(this.getBrand());
				System.out.println(this.getModel());
				System.out.println(this.getEbike());
			}

		} // Bicycle

		class BicyclePlus extends Bicycle {

			static final int NUM_GEARS = 6; // Número de marchas es CTE

			// Variables de instancia
			private int cadence = 0; // Ritmo de pedaleo
			private float speed = 0; // Velocidad
			private int gear = 1; // Marcha que lleva en un momento dado

			// Metodo contructor

			public BicyclePlus(String brand, String model, boolean ebike) {

				// Invocar al super constructor
				super(brand, model, ebike);
			}

			// Getters

			public int getCadence() {
				return this.cadence;
			}

			public float getSpeed() {
				return this.speed;
			}

			public int getGear() {
				return this.gear;
			}

			//

			private void changeSpeed(int value) {

				// Es privado no es posible invocarlo fuera del Obj
				this.speed += (value * 0.3);
			}

			public void changeCadence(int value) {

				this.cadence += value;
				changeSpeed(value);
			}

			// Métodos genéricos públicos
			public void showBike() {

				super.showBike(); // Me llama al de la superclase;
				System.out.println("Cadencia +" + this.cadence);
				System.out.println("Cadencia +" + this.gear);
				System.out.println("Cadencia +" + this.speed);
			}
		} // BicyclePlus

		Bicycle bici1 = new Bicycle("Mondraker", "Crafty", true);
		bici1.showBike();

		Bicycle bici2 = new Bicycle("Orbea", "Rallón");
		bici2.showBike();

		BicyclePlus bici3 = new BicyclePlus("BH", "Siempre hace parche", true);
		bici3.showBike();

	}

} // Tutorial_5
