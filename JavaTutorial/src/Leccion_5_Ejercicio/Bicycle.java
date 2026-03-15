package Leccion_5_Ejercicio;

public class Bicycle {

	static final String ELEMENTO = "Bicycle";

	// Variables de instancia
	private String brand; // Marca
	private String model; // Modelo
	private boolean ebike; // Indica si es una e-bike

	// Constructores

	public Bicycle(String brand, String model, boolean ebike) {

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
			return ("Es una muscular");
		}
	}

	// Métodos genéricos & públicos

	public void showBicycle() {

		// Muestra el Obj Bicycle
		System.out.println(Bicycle.ELEMENTO + " Details *******");
		System.out.println("Brand : " + getBrand());
		System.out.println("Model : " + getModel());
		System.out.println("Bike Type: " + getEbike());
	} // public void show_bicycle

} // public class Bicycle {
