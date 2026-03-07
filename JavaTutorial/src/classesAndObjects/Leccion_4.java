package classesAndObjects;

public class Leccion_4 {


	public static void main(String[] args) {
		
		// Introducción_I a CLASES Y OBJETOS. 
		
		// Definición de Clases, Instanciación de Clases (Objetos)
		// Constantes y Atributos de la Class/Objeto
		// Métodos Constructores, Getters y Setters
		// Constructor implícito
		// Atributos Publicos/Privados
		// Métodos Públicos
		// Sobrecarga de métodos
		// Palabra reservada "this"
				
		//Podemos ver una CLASS como un tipo de dato complejo. 
		//Y un OBJECT como un elemento que se crea a partir de la CLASS.
		
		//Tengo la CLASS que es como un molde para fabricar elementos, como coches, o figuras de plastelina
		//Con una CLASS o molde creo OBJECTS que serán los coches, o las figura de plastelina, tantos como quiera
		//EL creador de elementos es la CLASS y cada elementos es un OBJECT de esa CLASS
		//El molde de la plastelina es la CLASS y cada figura de plastelina es el OBJECT
		//Hay una CLASS, pero puede haber muchos OBJECTS de esa CLASS (0:n)
		
		//Redefinimos con la terminología correcta de Programación Orientada a Objetos (POO)
		//Un Objeto es una "instancia" de una Clase. 
		//Un Objeto tiene una "identidad", un "estado" y un "comportamiento".
		//	La "identidad" se define mediante su identificador.
		//	Su "estado" se define por el valor de sus atributos.
		//	Su "comportamiento" queda determinado por el comportamiento de la clase a la que pertenece
		//Actuamos con los objetos medinate lo "metodos" que publica
		
		
		// Veamos las CLASS
		// Recordar, son como moldes para definir objetos
		
		class Circulo { //Por convención, el nombre de la Clase comienza en mayúsculas
			
			//Variables y constantes de la Class
			static final String FIGURA = "Circulo"; //Combinamos static con final
													// static; es una variable de la Class, misma para todos los objetos 
													// final: es una cte.  
		
			//Atributos de la Clase; variables de Instancia
			int x; // Atributo. Posición x en el plano. Variable de Instancia. Idependiente en cada Objeto, cada Obj tiene la suya. 
			int y; // Atributo. Posición y en el plano. Variable de Instancia. Idependiente en cada Objeto, cada Obj tiene la suya. 
			int radio; //Atributo. Radio del círculo. Variable de Insancia. Idependiente en cada Objeto, cada Obj tiene la suya. 
		}
		
		//Ahora hemos definido la Class Circulo (o el molde)
		//	pero todavía no hemos generado (instanciado) ningún Objeto de esa Clase
		//Para generar un Objeto, "instanciamos" la Clase
		
		// Se puede instanciar de dos maneras:
		Circulo circulo1;
			circulo1 = new Circulo(); //circulo1 es el identificador del Objeto, no es el Objeto.
		
		Circulo circulo2 = new Circulo(); //circulo2 es el identificador del Objeto, no es el Objeto. 
		
		//Hemos creado dos objetos generados con el molde Circulo. 
		//	formalmente Hemos "instanciado" la Class Circulo para generar dos Objetos circulo1 y circulo2
		
		//Asignamos valores a los atributos de los Objetos
		//Recordamos que al ser variables de instancia, son independientes para cada objeto 
		circulo1.x = 1; 
		circulo1.y = 2;
		circulo1.radio = 3; 
		
		circulo2.x = 4; 
		circulo2.y = 5;
		circulo2.radio = 6; 
		
		//circulo2.FIGURA = "Cuadrado"; // Genera un eror, porque FIGURA es una cte. 
		
		//Podemos mostrar los atributos de cada objeto
		System.out.println("Figura: " + Circulo.FIGURA + " circulo1.x = " + circulo1.x + " circulo1.y = " + circulo1.y + " circulo1.radio = " + circulo1.radio); 
		System.out.println("Figura: " + Circulo.FIGURA +" circulo2.x = " + circulo2.x + " circulo2.y = " + circulo2.y + " circulo2.radio = " + circulo2.radio); 
		System.out.println("Figura:" + circulo1.FIGURA); //No es un error pero se desaconseja porque FIGURA es variable de la Class 
		
		//ELEMENTOS DE UNA CLASE
		//Definimos la información que almacena un Objeto mediante sus atributos. 
	
		class Vehiculo {
			
			//Atributos del Objeto, variables de instancia (cada Obj tendrá los suyos)
			String matricula; // Matrícula del vehículo
			String marca; // Marca del vehículo
			String modelo; // Modelo del vehículo
			int precio; // precio, en €
			boolean electrico; // Indica si es un eléctrico
			boolean hibrido; // Indica si es un híbrido 
		}
		
		//Instanciamos la clase Vehiculo para crear Objetos
		Vehiculo v1 = new Vehiculo(); // v1 es el identificador del Objeto 
		Vehiculo v2 = new Vehiculo(); // v2 es el identificador del Objeto 
		
		//Veamos qué es realmente v1 y v2
		System.out.println("Identificador de v1 = " + v1); // Muestra la direcció de memoria donde se aloja el objeto v1
		System.out.println("Identificador de v2 = " + v2); // Muestra la direcció de memoria donde se aloja el objeto v2
				
		//Hemos visto que el Objeto puede tener "atributos"
		//	o variables de instancia
		//Veamos cómo los empleamos para definir su "estado"
		
		class Vehiculo2 {
			
			//Atributos del Objeto, variables de Instancia (particulares de cada Objeto) 
			String matricula; // Matrícula del vehículo
			String marca; // Marca del vehículo
			String modelo; // Modelo del vehículo
			int precio; // precio, en €
			boolean electrico; // Indica si es un eléctrico
			boolean hibrido; // Indica si es un híbrido 
			
			//Metodo constructor; mismo nombre que la Class y se invoca para crear (instanciar) el Obj
			//Se puede utilizar para asignar valores iniciales a los atributos del Obj mediante parámetros, pero no es obligatorio
			//El constructor no retorna ningún valor, puede haber más de un constructor mediante sobrecarga
			//Si no se define un constructor Java define uno implícitamente; Circulo() y Vehículo() no los hemos definido explícitamente
			public Vehiculo2 (String matricula,
				String marca,
				String modelo,
				int precio,
				boolean electrico,
				boolean hibrido) {
				
					//Se usa la palabra "this" para diferenciar los atributos del Obj de los parámetros
					//Los parámetros pueden llamarse como los atributos del Obj
					//La palabra reservada "this" diferencia el atributo del Obj del parámetro
					this.matricula = matricula; 
					this.marca = marca;
					this.modelo = modelo;
					this.precio = precio;
					this.electrico = electrico;
					this.hibrido = hibrido;
			} //public Vehiculo2 
		} //class Vehiculo2
		
		//Instanciamos la Class Vehiculo2 y llamamos al método constructor
		//Podemos llamarlo de dos maneras, en la instanciación o posteriormente
		Vehiculo2 v3 = new Vehiculo2("1234JXC", "Ford", "Fiesta", 14000, false, true);
		
		Vehiculo2 v4; 
		v4 = new Vehiculo2("4321PRX", "Renault", "Megane", 20000, true, false);
		
		//Ahora tenemos dos Objetos Vehiculo2; v3 y v4, cuyos atributos son diferentes
		//Es como crear dos Objetos con un molde de plastelina
		//pero con plastelina diferente (color, tipo plastelina)
		//Son Instancias de la misma Class, pero en absoluto son el mismo Obj
		
		//Es abitual ofrecer un método constructor para asignar valores iniciales a los atributos del Obj. 
		//Para consultar/obtener los valores de sus atributos y para asignar nuevos valores se usan los métodos "get" y "set"
		//get (getter) --> Consultar valores
		//set (setter) --> Modificar su estado (inicializado con el constructor)
		
		// Mejoramos la Class Vehiculo
		class Vehiculo3 {
			
			//Cte de la Clase. static: variable de la Class (cada Obj la comparte), final : es una cte. 
			static final String ELEMENTO = "Vehículo"; 
			
			//Atributos del Obj, particulares a cada Obj de la Class
			//Esta vez los definimos como privados (private), solo serán accesibles desde la propia Class
			// o indirectamente mediante métodos públicos que oferte la Class 
			private String matricula; 
			private String marca;
			private String modelo;
			private int precio;
			private boolean electrico;
			private boolean hibrido;
			
			//Metodo Constructor
			public Vehiculo3 (String matricula,
				String marca,
				String modelo,
				int precio,
				boolean electrico,
				boolean hibrido) {
				
					this.matricula = matricula;
					this.marca = marca;
					this.modelo = modelo;
					this.precio = precio;
					this.electrico = electrico;
					this.hibrido = hibrido;
			}
			
			//Los atributos son de tipo private, no accesibles desde el exterior de la Class, 
			//por tanto, deberemos dar algún método público para obtener/modificar sus valores:
			//	Métodos Get (Getter) para asignar/modificar los valores de los atributos
			//	Métodos Set (Setter) para obtener/leer los valores de los atributos
			//Si un método no devuelve ningún valor, entonces es de tipo "void"
			
			// Getters() : Extracción de valores
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
			
			// Setters(): Asignación (modificación) valores
			// Solo damos la posibilidad de modificar el precio
			// Al ser los atributos private, no es posible el acceso desde fuera de la Class 
			// 	solamente mediante los métodos que oferte la Class
			public void set_precio(int precio) { // Modifica el precio
				this.precio = precio;
			}
			
			// Ofrecemos un segundo método para modificar el precio
			//	este segundo método devuelve el precio realmente asignado
			//	sería necesario cuando el precio se manipula por el Obj. 
			public int set_precio_check(int precio) {
				this.set_precio(precio);
				return this.get_precio(); 
			}
		} //class Vehiculo3 
		
		//Instanciamos la Class para crear el Obj y mostramos sus valores
		Vehiculo3 v5 = new Vehiculo3("9999XXX", "Seat", "Leon", 34000, false, true);
		Vehiculo3 v6 = new Vehiculo3("777ABC", "Mercedes", "A220D", 44000, false, false);
		
		//Mostramos los valores para v5
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v5.get_matricula());
		System.out.println("es marca "+ v5.get_marca());		
		System.out.println("es modelo "+ v5.get_modelo());
		System.out.println("y vale "+ v5.get_precio());
		if (v5.get_electrico()) {
			System.out.println("es electrico");
		} else if (v5.get_hibrido()) {
			System.out.println("es hibrido");
		} else {
			System.out.println("es combustión");
		}
		//Cambiamos el precio de v5, es el único atributo modificable
		System.out.println("y ahora vale "+ v5.set_precio_check(24000));
	
		//Observar lo siguiente que es debido a la visibilidad de los atributos
		//	recordar que estamos definiendo la Class Vehiculo3 'dentro' de la Class Leccion_4
		//	y podemos acceder a los atributos de forma jerárquica
		//Para ver un ejemplo más real de la visibilidad 'private' ver Leccion_4_Ejercicio.java
		v5.precio = 25000; // No genera un error porque estamos dentro del fichero Class Leccion_4
		System.out.println("y ahora vale "+ v5.get_precio());
		
		//Mostramos los valores para v6
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v6.get_matricula());
		System.out.println("es marca "+ v6.get_marca());		
		System.out.println("es modelo "+ v6.get_modelo());
		System.out.println("y vale "+ v6.get_precio());
		if (v6.get_electrico()) {
			System.out.println("es electrico");
		} else if (v6.get_hibrido()) {
			System.out.println("es hibrido");
		} else {
			System.out.println("es combustión");
		}

		//Seguimos mejorando nuestra Class con más métodos
		//	y utilizaremos los getter y setter existentes
		
		class Vehiculo5 {
			
			//Cte de la Clase
			static final String ELEMENTO = "Vehículo"; 
			
			//Atributos de un objeto
			private String matricula;
			private String marca;
			private String modelo;
			private int precio;
			private boolean electrico;
			private boolean hibrido;
			
			//Método Constructor 1
			public Vehiculo5 (String matricula,
				String marca,
				String modelo,
				int precio,
				boolean electrico,
				boolean hibrido) {
					//Utilizamos los Setter
					this.set_matricula(matricula); 
					this.set_marca(marca);
					this.set_modelo(modelo); 
					this.set_precio(precio); 
					this.set_electrico(electrico);
					this.set_hibrido(hibrido); 
			}
			
			//Sobrecarda (mismo nombre para métodos diferentes) 
			//En Java podemos duplicar los métodos (incluído el constructor); Sobrecarca
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
						this.set_matricula(matricula); 
						this.set_marca(marca);
						this.set_modelo(modelo); 
						this.set_precio(precio); 
						this.set_electrico(false); // El constructor 1 no require este parámetro
						this.set_hibrido(false); // El constructor 1 no requiere este parámetro
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
			public void muestraVehiculo() {
				System.out.println(Vehiculo5.ELEMENTO + " de Clase Vehiculo5"); 
				System.out.println("Vehiculo de matricula "+ get_matricula());
				System.out.println("Vehiculo de marca "+ get_marca());
				System.out.println("Vehiculo de modelo "+ get_modelo());
				System.out.println("Vehiculo de precio "+ get_precio());
				System.out.println("Vehiculo electrico "+ get_electrico());
				System.out.println("Vehiculo hibrido "+ get_hibrido());
			}
			
		} //class Vehiculo5
				
		//Instanciamos Class Vehiculo5 y llamamos al método que nos muestra sus atributos 
		Vehiculo5 v7 = new Vehiculo5("777ABC", "Mercedes", "A220D", 44000, false, false);
		v7.muestraVehiculo();
		
		Vehiculo5 v9 = new Vehiculo5("1234ABC", "BMW", "330i", 66000);
		v9.muestraVehiculo();
		
		
		//Demostració de que la instanciación de Class genera la referencia al Obj más que el Obj en sí
		Vehiculo5 v8; //Instanciamos la Class para generar la referencia al Obj
		v8 = v7; //Igualamos la referencia del nuevo Obj a uno ya existente (perdemos el original) 
		System.out.println(v7);
		System.out.println(v8);
		v8.muestraVehiculo();
		
		//Hemos dicho que la instanciación de una Class genera un Obj y retorna una referencia a ese Obj
		//Si machacamos la referencia a un Obj, perdemos la posibilidad de acceder a ese Obj
		//La JVM (JRE) tiene un proceso que libera la memoria de los Obj inalcanzable. 
		//Recordamos Objetos v5 y v6
		
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v5.get_matricula());
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v6.get_matricula());
		v5 = v6; //Acabamos de perder el Objeto v5 puesto que hemos machacado su referencia
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v5.get_matricula());
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v6.get_matricula());

		
	} // public static void main
	
} // public class Leccion_4 
