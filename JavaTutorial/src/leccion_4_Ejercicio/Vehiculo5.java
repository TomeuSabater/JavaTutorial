package leccion_4_Ejercicio;

public class Vehiculo5 {
			
	//Cte de la Clase
	static final String ELEMENTO = "Vehículo"; 
	
	//Atributos de un objeto
	private String matricula;
	private String marca;
	private String modelo;
	private int precio;
	private boolean electrico;
	private boolean hibrido;
	
	//Método Constructor
	public Vehiculo5 (String matricula,
		String marca,
		String modelo,
		int precio,
		boolean electrico,
		boolean hibrido) {
			//Utilizamos los Setter
			set_matricula(matricula); 
			set_marca(marca);
			set_modelo(modelo); 
			set_precio(precio); 
			set_electrico(electrico);
			set_hibrido(hibrido); 
	}
	
	//En Java podemos duplicar los métodos (incluído el constructor), se denomina Sobrecarca
	//Es necesario que tengan una "firma" diferente
	//La "firma" está compuesta por nombre_método y lista_parámetros
	//Cambiando lista_parámetros tenemos una firma diferente
	
	//Método Constructor 2
	//Cambiamos la lista_de_parámetros para conseguir una firma diferente
	public Vehiculo5 (String matricula,
			String marca,
			String modelo,
			int precio) {
				//Utilizamos los Setter
				set_matricula(matricula); 
				set_marca(marca);
				set_modelo(modelo); 
				set_precio(precio); 
				set_electrico(false);
				set_hibrido(false); 
		}
	
	
	//Métodos Get y Set para la gestión de atributos
	
	//Getters
	public String get_matricula() {
		return this.matricula;
	}
	public String get_marca() {
		return this.marca;
	}
	public String get_modelo() {
		return this.modelo;
	}
	public int get_precio() {
		return this.precio;
	}
	public boolean get_electrico() {
		return this.electrico;
	}
	public boolean get_hibrido() {
		return this.hibrido;
	}
	
	//Setters: matricula, marca, modelo, precio, electrico, hibrido
	//Al no devolver ningún valor, los métodos son de tipo void
	public void set_matricula(String matricula) {
		this.matricula = matricula.toUpperCase(); 
	}
	public void set_marca(String marca) {
		this.marca = marca; 
	}
	public void set_modelo(String modelo) {
		this.modelo = modelo; 
	}
	public void set_precio(int precio) {
		this.precio = precio;
	}
	public void set_electrico(boolean electrico) {
		this.electrico = electrico; 
	}
	public void set_hibrido(boolean hibrido) {
		this.hibrido = hibrido; 
	}
				
	//Método público que muestra los atributos del Objeto
	//El nombre de un método debería comenzar con un verbo, o ser un verbo. 
	public void muestraCoche() {
		System.out.println(Vehiculo5.ELEMENTO + " de Clase Vehiculo5"); 
		System.out.println("Vehiculo de matricula "+ get_matricula());
		System.out.println("Vehiculo de marca "+ get_marca());
		System.out.println("Vehiculo de modelo "+ get_modelo());
		System.out.println("Vehiculo de precio "+ get_precio());
		System.out.println("Vehiculo electrico "+ get_electrico());
		System.out.println("Vehiculo hibrido "+ get_hibrido());
	} // public void muestraCoche

}//class Vehiculo5
