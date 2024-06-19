package ejemplos;

public class Leccion_5 {

	public static void main(String[] args) {

		// Introducción a CLASES Y OBJETOS. 
		
		class Bicycle {
			
			private String brand; 
			private String model; 
			private boolean ebike = false; 
					
			
			//Método constructor, usamos los setters
			public Bicycle (String brand, String model, boolean ebike) {
				
				set_brand(brand); 
				set_model(model);
				set_ebike(ebike); 
			}
			
			//Setters
			public void set_brand(String brand) {
				this.brand = brand; 
			}
			
			public void set_model(String model) {
				this.model = model; 
			}
			
			public void set_ebike(boolean ebike) {
				this.ebike = ebike; 
			}
			
			//Getters
			
			public String get_brand() {
				return this.brand;
			}
			
			public String get_model() {
				return this.model; 
			}
			
			public boolean get_ebike() {
				return this.ebike; 
			}
			
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
		//Pero para ellos aplicaremos el concepto de herencia
		//Definiremos una nueva Clase Bicycle_plus que extienderá (mejorará) la Clase Bicycle
		//Esta nueva Clase Bicycle_plus contendrá todo lo de Bicycle y elementos extras
		
		
		class Bicycle_plus extends Bicycle {
			
			static final int GEARS = 6; //Número de marchas
			
			private int cadence = 0;
			private int speed = 0;
			private int gear = 1; 
			
			//Metodo constructor
			Bicycle_plus (String brand, String model, boolean ebike) {
				super(brand, model, ebike);
				
			}
			
			//Getters
			public int get_cadence() {
				return this.cadence;
			}
			public int get_speed() {
				return this.speed;
			}
			public int get_gear() {
				return this.gear; 
			}
			
			//Setters
			//No existen como tales puesto que no permitinos asignar
			//de manera "directa" estos valores
						
			private void change_speed(int value) {
				speed += (value * 0.3); 
			}
			
			public void change_cadence(int value) {
				cadence += value; 
				change_speed(value);
			}
						
			public void change_gear(int value) {
				
				if ((this.gear + value) > GEARS) {
					this.gear = GEARS;
				} else if ((this.gear + value ) < 1) {
					this.gear = 1; 
				} else {
					this.gear += value; 
				}
				change_speed(value);
			}
			
			public void show_bicyle() {
				
				super.show_bicycle();
				System.out.println("Cadence : " + get_cadence());
				System.out.println("Gear : " + get_gear());
				System.out.println("Speed : " + get_speed());
			}
			
		} // class Bicycle_plus 
		
		Bicycle_plus bici_plus_1 = new Bicycle_plus("Specialized", "Levo", true);
		bici_plus_1.show_bicyle();
		

	} //main
}//class Leccion_5
