package classesAndObjects;

public class Leccion_5 {

	public static void main(String[] args) {

		// Introducción_II a CLASES Y OBJETOS. 
		
		// Shadowing en Constructores y Setters
		// Control en instanciación de clases
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
			//al definirlos 'private' no son accesibles desde el exterior del Obj
			private String brand; // Marca
			private String model; // Modelo
			private boolean ebike; // Indica si es una e-bike
					
			//Métodos constructores, mismo nombre que la Class, y usaremos los setters
			//Dar el mismo nombre del atributo al parámetro se denomina 'Shadowing'
			//Al poder dificultar el código, solamente se suele usar en constructores o setters
			//para evitar confusiones se utiliza la palabra reservada 'this'
			public Bicycle (String brand, String model, boolean ebike) {
				
				//java.util.Objects.requireNonNull(brand, "Parámetro 'brand' no puede ser nulo");
				//java.util.Objects.requireNonNull(model, "Parámetro 'model' no puede ser nulo");
												
				if (brand == null || brand.isBlank()) {
					// Control sobre variables de instancia 'brand' obligatoria
					throw new IllegalArgumentException("La marca es obligatoria");
				}
								
				if (model == null || model.isBlank()) {
					// Control sobre variable de instancia 'model' oblitgaoria
					throw new IllegalArgumentException("El modelo es obligatorio");
				}
								
				// El constructor llama a los setters, así tenemos centralizada la asignación
				setBrand(brand); 
				setModel(model);
				setEbike(ebike); 				
			} // Bicycle
			
			public Bicycle (String brand, String model) {
				
				// El constructor llama al constructor general
				this(brand, model, false); // pasamos el parámetro ebike = false
			}
					
			//Setters públicos, uno para cada atributo
			
			public void setBrand(String brand) {
				this.brand = brand.toUpperCase(); 
			}
			public void setModel(String model) {
				this.model = model.toUpperCase(); 
			}
			public void setEbike(boolean ebike) {
				this.ebike = ebike; 
			}
			
			//Getters públicos, uno para cada atributo 
			public String getBrand() {
				return this.brand;
			}
			public String getModel() {
				return this.model; 
			}
			public String getEbike() {
				if (this.ebike) {
					return "e-bike";
				} else {
					return "muscular";
				}
			} 
			
			//Métodos genéricos & públicos 
			
			public void showBicycle() {
				
				// Muestra el Obj Bicycle
				System.out.println(Bicycle.ELEMENTO + " Details *******");
				System.out.println("Brand : " + getBrand());
				System.out.println("Model : " + getModel());
				System.out.println("Bike Type: " + getEbike()); 
			} // public void show_bicycle
			
		} //class Bicycle 
		
		//Creamos algunas bicicletas instanciando la Class Bicycle
		Bicycle bici1 = new Bicycle("Orbea", "Rallón", true);
		Bicycle bici2 = new Bicycle("Lapierre", "Overvolt"); 
		
		//Mostramos sus atributos
		bici1.showBicycle();
		bici2.showBicycle(); 
		
		// Intentamos instancia la Class sin valores obligatorios
		// Bicycle bici3 = new Bicycle(" ", null); 
		
		Bicycle bici3 = new Bicycle("BH","Lynx"); 
				
				
		//Queremos mejorar la Class Bicycle
		//Pero para ello, no tocaremos su código, sino que aplicaremos el concepto de herencia (Inheritance) 
		//Definiremos una nueva Class BicyclePlus que extenderá (mejorará/refinará) la Class Bicycle 
		//Bicycle será la Super Class de una nueva Class BicyclePlus 
		//Esta nueva Class BicyclePlus contendrá (heredará) todo lo de su Super Class Bicycle, y además, algunos elementos extra
		
		class BicyclePlus extends Bicycle {
			
			//Además de los atributos que hereda de la Super Class Bicycle
			//añadiremos los siguiente nuevos atributos
			
			//Variables de la Class BicyclePlus
			static final int NUM_GEARS = 6; //Número de marchas, es static y final (cte compartida)
			
			//Variables de Instancia, se inicializan
			private int cadence = 0; //Nuevo atributo cadencia, con valor inicial. 
			private float speed = 0; //Nuevo atributo velocidad, con valor inicial. 
			private int gear = 1; //Nuevo atributo marcha, con valor inicial. 
			
			//Metodo constructor, usaremos el constructor de la Super Class
			//El constructor puede/debe usar el de la Super Class 
			BicyclePlus (String brand, String model, boolean ebike) {
				
				//Invoca constructor de la Super Class
				super(brand, model, ebike); 
			}
			
			//Getters, uno para cada nuevo atributo, públicos para poder llamarlos sin problemas
			//Para esta Class, al ser heredada, también oferta los de la Super Class
			public int getCadence() {
				return this.cadence;
			}
			public float getSpeed() {
				return this.speed;
			}
			public int getGear() {
				return this.gear; 
			}
			
			//Setters, no existen puesto que no permitiremos asignar de manera "directa" valores a los nuevos atributos
			//En su lugar, ofreceremos algún método para asignarlos
						
			//Método privado: No es posible invocarlo desde el exterior del Objeto
			//No es posible aumenter la velocidad de manera "directa"
			//El método es llamado con parámetros
			private void changeSpeed(int value) {
				
				//incremento / decremento velocidad
				speed += (value * 0.3); 
			}
			
			//Método público para aumentar/disminuir la cadencia
			//Si que es posible llamarlo desde el exterior de la Class
			//Se llama con parámetros
			public void changeCadence(int value) {
				
				// incremento / decremento cadencia
				cadence += value; 
				//invocamos el método privado, es accesible desde dentro de la Class
				changeSpeed(value); 
			} // changeCadence
			
			//Método público para aumentar/disminuir de marcha
			//Si es posible llamarlo desde el exterior de la Class
			//Se llama con parámetros
			public void changeGear(int value) {
				
				//Controlamos el máximo y mínimo de marchas
				if ((this.gear + value) > BicyclePlus.NUM_GEARS) {
					// Ya era la marcha más alta
					this.gear = BicyclePlus.NUM_GEARS;
				} else if ((this.gear + value ) < 1) {
					// Ya era la marcha más baja
					this.gear = 1; 
				} else {
					// Cambiamos de marcha
					this.gear += value; 
				}
				changeSpeed(value); //invocamos el método privado
			} // changeGear
			
			//Método públic que oferta la operación de frenado
			public void applyBrake(int intensity) {
				
				//Debe ser siempre un valor negativo
				if (intensity > 0) {
					intensity *= -1;
				} 
				changeSpeed(intensity); // invocamos al método privado
			} // applyBrake
			
			
			//Método público para mostrar valores, utilizaremos el de la Super Clase
			public void showBicyle() {
				
				super.showBicycle(); //Utilizamos el método de la Super Class
				//Además, mostramos los atributos de la Class
				System.out.println("Cadence : " + getCadence());
				System.out.println("Gear : " + getGear());
				System.out.println("Speed : " + getSpeed());
			}
			
		} // class Bicycle_plus 
		
		//Instanciamos una BicyclePlus
		BicyclePlus bici_plus_1 = new BicyclePlus("Specialized", "Levo", true);
		bici_plus_1.showBicyle();
		
		//Aumentamos las marchas
		bici_plus_1.changeGear(+2);
		bici_plus_1.showBicyle();
		
		//Aumentamos cadencia
		bici_plus_1.changeCadence(+3);
		bici_plus_1.showBicyle();
		
		//Disminuimos marchas
		bici_plus_1.changeGear(-1);
		bici_plus_1.showBicyle();
		
		//Disminuimos marchas, sobrepasa límite
		bici_plus_1.changeGear(-3);
		bici_plus_1.showBicyle();
		
		//Frenamos
		bici_plus_1.applyBrake(5);
		bici_plus_1.showBicyle();
		
		// bici_plus_1.change_speed(4); // Esta llamada es posible porque estamos en misma public class Leccion_5

	} //main

}//class Leccion_5
