package classesAndObjects;

public class Leccion_5 {

	public static void main(String[] args) {

		// Introducción_II a CLASES Y OBJETOS. 
		
		// Shadowing en Constructores y Setters
		// Concepto de Herencia (Inheritance)
		// Métodos Publicos/Privados 

		
		// Creamos una Class para una Bicicleta
		class Bicycle {
			
			//Variable y Cte de la Clase 
			//al ser de tipo 'static' pertenece a la Class no al Obj
			//es la misma variable para todos los Obj -> un elemento en memoria, el mismo
			static final String ELEMENTO = "Bicycle"; 
			// final String ELEMENTO = "Bicycle"; // Es posible, pero es elegante, puesto que es la misma CTE para cada Obj
			
			//Atributos privados, o variables de Instancia, uno para cada Obj que definamos 
			private String brand; // Marca
			private String model; // Modelo
			private boolean ebike = false; // Asignamos un valor por defecto
					
			//Método constructor, mismo nombre que la Class, y usaremos los setters
			//Dar el nombre del atributo al parámetro se denomina 'Shadowing'
			//Al poder dificultar el código, solamente se suele usar en constructores o setters
			public Bicycle (String brand, String model, boolean ebike) {
				
				// El constructor llama a los setters, tenemos centralizada la asignación
				set_brand(brand); 
				set_model(model);
				set_ebike(ebike); 
			}
			
			//Setters públicos, uno para cada atributo 
			public void set_brand(String brand) {
				this.brand = brand.toUpperCase(); 
			}
			public void set_model(String model) {
				this.model = model.toUpperCase(); 
			}
			public void set_ebike(boolean ebike) {
				this.ebike = ebike; 
			}
			
			//Getters públicos, uno para cada atributo 
			public String get_brand() {
				return this.brand;
			}
			public String get_model() {
				return this.model; 
			}
			public String get_ebike() {
				if (this.ebike) {
					return "e-bike";
				} else {
					return "muscular";
				}

			}
			
			//Método genéricos públicos 
			public void show_bicycle() {
				
				System.out.println(Bicycle.ELEMENTO + " Details *******");
				System.out.println("Brand : " + get_brand());
				System.out.println("Model : " + get_model());
				System.out.println("Bike Type: " + get_ebike()); 
			} // public void show_bicycle
			
		} //class Bicycle 
		
		//Creamos algunas bicicletas instanciando la Class Bicycle
		Bicycle bici1 = new Bicycle("Orbea", "Rallón", false);
		Bicycle bici2 = new Bicycle("Lapierre", "Overvolt", true); 
		
		//Mostramos sus atributos
		bici1.show_bicycle();
		bici2.show_bicycle(); 
		
		//Queremos mejorar la Clase Bicyce
		//Pero para ello, no tocaremos su código, sino que aplicaremos el concepto de herencia (Inheritance) 
		//Definiremos una nueva Class BicyclePlus que extenderá (mejorará/refinará) la Class Bicycle 
		//Bicycle será la Super Class de una nueva Class BicyclePlus que la extenderá esta Super Class 
		//Esta nueva Class BicyclePlus contendrá (heredará) todo lo de su Super Class Bicycle, y además, algunos elementos extra
		
		class BicyclePlus extends Bicycle {
			
			//Además de los atributos que hereda de la Super Class Bicycle
			//añadiremos los siguiente nuevos atributos
			
			//Variables de la Class
			static final int NUM_GEARS = 6; //Número de marchas, es static y cte
			
			//Variables de Instancia, se inicializan
			private int cadence = 0; //Nuevo atributo cadencia, valor inicial. 
			private float speed = 0; //Nuevo atributo velocidad, valor inicial. 
			private int gear = 1; //Nuevo atributo marcha, valor inicial. 
			
			//Metodo constructor, usaremos el constructor de la Super Class
			//El constructor puede/debe usar el de la Super Class 
			BicyclePlus (String brand, String model, boolean ebike) {
				super(brand, model, ebike); //Invoca constructor de la Super Class
			}
			
			//Getters, uno para cada nuevo atributo, públicos para poder llamarlos si problemas
			//Para esta Class, al ser heredada, también oferta los de la Super Class
			public int get_cadence() {
				return this.cadence;
			}
			public float get_speed() {
				return this.speed;
			}
			public int get_gear() {
				return this.gear; 
			}
			
			//Setters, no existen puesto que no permitiremos asignar de manera "directa" valores a los nuevos atributos
			//En su lugar, ofreceremos algún método para asignarlos
						
			//Método privado: No es posible invocarlo desde el exterior del Objeto
			//No es posible aumenter la velocidad de manera "directa"
			//El método es llamado con parámetros
			private void change_speed(int value) {
				speed += (value * 0.3); //incremento / decremento velocidad
			}
			
			//Método público para aumentar/disminuir la cadencia
			//Si es posible llamarlo desde el exterior de la Class
			//Se llama con parámetros
			public void change_cadence(int value) {
				cadence += value; // incremento / decremento cadencia
				change_speed(value); //invocamos el método privado, es accesible desde dentro de la Class
			}
			
			//Método público para aumentar/disminuir de marcha
			//Si es posible llamarlo desde el exterior de la Class
			//Se llama con parámetros
			public void change_gear(int value) {
				//Controlamos el máximo y mínimo de marchas
				if ((this.gear + value) > BicyclePlus.NUM_GEARS) {
					this.gear = BicyclePlus.NUM_GEARS;
				} else if ((this.gear + value ) < 1) {
					this.gear = 1; 
				} else {
					this.gear += value; 
				}
				change_speed(value); //invocamos el método privado
			}
			
			//Método público para mostrar valores, utilizaremos el de la Super Clase
			public void show_bicyle() {
				
				super.show_bicycle(); //Utilizamos el método de la Super Class
				//Además, mostramos los atributos de la Class
				System.out.println("Cadence : " + get_cadence());
				System.out.println("Gear : " + get_gear());
				System.out.println("Speed : " + get_speed());
			}
			
		} // class Bicycle_plus 
		
		//Instanciamos una BicyclePlus
		BicyclePlus bici_plus_1 = new BicyclePlus("Specialized", "Levo", true);
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
		
		// bici_plus_1.change_speed(4); // Esta llamada es posible porque estamos en misma public class Leccion_5

	} //main
}//class Leccion_5
