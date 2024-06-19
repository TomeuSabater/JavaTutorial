package ejemplos;

public class Leccion_5 {

	public static void main(String[] args) {

		// Introducción a CLASES Y OBJETOS. 
		// Concepto de HERENCIA (Inheritance)
		
		class Bicycle {
			
			private String brand; 
			private String model; 
			private boolean ebike = false; //Asignamos un valor por defecto
					
			//Método constructor, mismo nombre que la clase, usamos los setters
			public Bicycle (String brand, String model, boolean ebike) {
				
				set_brand(brand); 
				set_model(model);
				set_ebike(ebike); 
			}
			
			//Setters, uno para cada atributo 
			public void set_brand(String brand) {
				this.brand = brand; 
			}
			public void set_model(String model) {
				this.model = model; 
			}
			public void set_ebike(boolean ebike) {
				this.ebike = ebike; 
			}
			
			//Getters, uno para cada atributo 
			public String get_brand() {
				return this.brand;
			}
			public String get_model() {
				return this.model; 
			}
			
			public boolean get_ebike() {
				return this.ebike; 
			}
			
			//Método públicos 
			public void show_bicycle() {
				
				System.out.println("Bicycle Details *******");
				System.out.println("Brand : " + get_brand());
				System.out.println("Model : " + get_model());
				System.out.println("e_Bike: " + get_ebike()); 
			}
			
		} //class Bicycle 
		
		//Creamos una bicicleta
		Bicycle bici1 = new Bicycle("Orbea", "Rallón", false);
		Bicycle bici2 = new Bicycle("Lapierre", "Overvolt", true); 
		bici1.show_bicycle();
		bici2.show_bicycle(); 
		
		
		//Vamos a mejorar la Clase Bicycle
		//Pero para ellos aplicaremos el concepto de herencia (inheritance) 
		//Definiremos una nueva Clase Bicycle_plus que extenderá (mejorará) la Clase Bicycle 
		//Bicycel será la Super Clase de una nueva Clase Bicycle_plus que la extenderá  
		//Esta nueva Clase Bicycle_plus contendrá (heredará) todo lo de Super Clase Bicycle y elementos extras
		
		
		class Bicycle_plus extends Bicycle {
			
			//Además de los atributos de la Super Clase Bicycle
			//también tendremos los siguiente nuevos atributos
			
			static final int GEARS = 6; //Número de marchas, es una constante
			
			private int cadence = 0; //Nuevo atributo cadencia
			private float speed = 0; //Nuevo atributo velocidad
			private int gear = 1; //Nuevo atributo marcha 
			
			//Metodo constructor, usaremos el constructor de la Super Clase
			Bicycle_plus (String brand, String model, boolean ebike) {
				super(brand, model, ebike);
			}
			
			//Getters, uno para cada nuevo atributo 
			public int get_cadence() {
				return this.cadence;
			}
			public float get_speed() {
				return this.speed;
			}
			public int get_gear() {
				return this.gear; 
			}
			
			//Setters
			//No existen como tales puesto que no permitiremos asignar
			//de manera "directa" estos valores
						
			//Aumento de velocidad no es posible invocarlo 
			//desde el exterior, es de tipo privado
			private void change_speed(int value) {
				speed += (value * 0.3); 
			}
			
			//Método para aumentar/disminuir la cadencia
			public void change_cadence(int value) {
				cadence += value; 
				change_speed(value);
			}
			
			//Método para aumentar/disminuir de marcha
			public void change_gear(int value) {
				//Controlamos el máximo y mímio de marchas
				if ((this.gear + value) > GEARS) {
					this.gear = GEARS;
				} else if ((this.gear + value ) < 1) {
					this.gear = 1; 
				} else {
					this.gear += value; 
				}
				change_speed(value);
			}
			
			//Método mostrar valores, utilizaremos el de la Super Clase
			public void show_bicyle() {
				
				super.show_bicycle(); //Utilizamos el método de la Super Clase
				System.out.println("Cadence : " + get_cadence());
				System.out.println("Gear : " + get_gear());
				System.out.println("Speed : " + get_speed());
			}
			
		} // class Bicycle_plus 
		
		//Instanciamos una Bicycle_plus
		Bicycle_plus bici_plus_1 = new Bicycle_plus("Specialized", "Levo", true);
		bici_plus_1.show_bicyle();
		
		//Aumentamos las marchas
		bici_plus_1.change_gear(+2);
		bici_plus_1.show_bicyle();
		
		//Aumentamos cadencia
		bici_plus_1.change_cadence(+3);
		bici_plus_1.show_bicyle();
		
		//Disminuimos marchas
		bici_plus_1.change_gear(-1);
		bici_plus_1.show_bicyle();
		
		//Disminuimos marchas, sobrepasa límite
		bici_plus_1.change_gear(-3);
		bici_plus_1.show_bicyle();

	} //main
}//class Leccion_5
