package ejemplos;

public class Leccion_4 {


	public static void main(String[] args) {
		
		// Introducción_I a CLASES Y OBJETOS. 
		
		// Definición de Clases, Instanciación de Objetos
		// Constantes y Atributos de la Clase/Objeto
		// Métodos Constructores, Getters y Setters
		// Constructor implícito
		// Atributos Privados
		// Métodos Públicos
		// Sobrecarga de métodos
		// Palabra reservada "this"
				
		//Podemos ver una CLASE es un tipo de dato complejo. 
		//Y un OBJETO como un elemento que se crea a partir de la CLASE
		
		//Tengo la CLASE que es como un molde para fabricar elementos, como coches, o figuras de plastelina
		//Con una CLASE o molde creo OBJETOS que serán los coches, o las figura de plastelina, tantos como quiera
		//EL creador de elementos es la CLASE y cada elementos es un OBJETO de esa CLASE
		//El molde de la plastelina es la CLASE y cada figura de plastelina es el OBJETO
		//Hay una CLASE, pero puede haber muchos OBJETOS de esa CLASE 1:n
		
		//Redefinimos ahora aplicando terminología correcta de Programación Orientada a Objetos (POO)
		//Un Objeto es una "instancia" de una Clase. 
		//Un Objeto tiene una "identidad", un "estado" y un "comportamiento".
		//La "identidad" se define mediante su identificador.
		//Su "estado" se define por el valor de sus atributos.
		//Su "comportamiento" queda determinado por el comportamiento de la clase a la que pertenece
		//Actuamos con los objetos medinate lo "metodos" que publica

		
		// CLASES; Recordar, son como moldes para definir objetos
		
		class Circulo { //Por convención, el nombre de la Clase comienza en mayúsculas
			
			//Constantes de la Clase
			static final String FIGURA = "Circulo"; //Static: Es la misma para todos los objetos. Final: Es una cte.  
		
			//Atributos de la Clase
			int x; // Atributo. Posición x en el plano. Variable de Instancia. Idepediente en cada Objeto 
			int y; // Atributo. Posición y en el plano. Variable de Instancia. Idepediente en cada Objeto 
			int radio; //Atributo. Radio del círculo. Variable der Insancia. Idepediente en cada Objeto
		}
		
		//Ahora hemos definido la Clase Circulo (o el molde)
		//pero todavía no hemos generado (instanciado) ningún Objeto de esa Clase
		//Para generar un Objeto, "instanciamos" la Clase
		
		Circulo circulo1 = new Circulo(); //circulo1 es el identificador del Objeto, no es el Objeto. 
		Circulo circulo2 = new Circulo(); //circulo2 es el identificador del Objeto, no es el Objeto. 
		
		//Ahora tenemos dos objetos generados con el molde Circulo. 
		//Ahora hemos instanciado la Clase Circulo para generar dos Objetos
		
		//Asignamos valores a los atributos de los Objetos
		//Recordamos que al ser variables de instancia, son independientes para cada objeto 
		circulo1.x = 1; 
		circulo1.y = 2;
		circulo1.radio = 3; 
		
		circulo2.x = 4; 
		circulo2.y = 5;
		circulo2.radio = 6; 
		
		//circulo2.FIGURA = "Cuadrado"; Genera un eror, es una cte. 
		
		//Podemos mostrar los atributos de cada objeto
		System.out.println("Figura: " + Circulo.FIGURA + " circulo1.x = " + circulo1.x + " circulo1.y = " + circulo1.y + " circulo1.radio = " + circulo1.radio); 
		System.out.println("Figura: " + Circulo.FIGURA +" circulo2.x = " + circulo2.x + " circulo2.y = " + circulo2.y + " circulo2.radio = " + circulo2.radio); 

		//System.out.println("Figura:" + circulo1.FIGURA); //No es un error pero se desaconseja
		
		//ELEMENTOS DE UNA CLASE
		//Definimos la información que almacena un Objeto mediante sus atributos. 
	
		class Vehiculo {
			
			//Atributos del Objeto
			String matricula; 
			String marca;
			String modelo;
			int precio;
			boolean electrico;
			boolean hibrido;
		}
		
		//Instanciamos la clase Vehiculo para crear Objetos
		Vehiculo v1 = new Vehiculo(); // v1 es el identificador del Objeto 
		Vehiculo v2 = new Vehiculo(); // v2 es el identificador del Objeto 
		
		System.out.println("Identificador de v1 = " + v1); 
		System.out.println("Identificador de v2 = " + v2); 
		
		//Hemos visto que el Objeto puede tener "atributos" 
		//Veamos cómo los empleamos para definir su "estado"
		
		class Vehiculo2 {
			
			//Atributos de un objeto
			String matricula;
			String marca;
			String modelo;
			int precio;
			boolean electrico;
			boolean hibrido;
			
			//Metodo constructor, tiene mismo nombre que la Clase y llama para crear el objeto
			//Se puede utilizar para asignar valores inicial a los atributos del Objeto mediante parámetros, pero no es obligatorio
			//El constructor no retorna ningún valor, puede haber más de un constructor mediante sobrecarga
			//Si no se define un constructor Java define uno implícitamente, caso de Circulo() y Vehículo()
			public Vehiculo2 (String matricula,
				String marca,
				String modelo,
				int precio,
				boolean electrico,
				boolean hibrido) {
				
					//Se usa la palabra "this" para diferenciar los atributos del objeto de los parámetros
					//Los parámetros pueden llamarse como los atributos del objeto
					//La palabra reservada "this" diferencia el atributo del objeto del parámetro
					this.matricula = matricula; 
					this.marca = marca;
					this.modelo = modelo;
					this.precio = precio;
					this.electrico = electrico;
					this.hibrido = hibrido;
			} //public Vehiculo2 
		} //class Vehiculo2
		
		//Instanciamos la Clase Vehiculo2 y llamamos al método constructor
		Vehiculo2 v3 = new Vehiculo2("1234JXC", "Ford", "Fiesta", 14000, false, true);
		Vehiculo2 v4 = new Vehiculo2("4321PRX", "Renault", "Megane", 20000, true, false);
		
		//Ahora tenemos dos Objetos Vehiculo2; v3 y v4, cuyos atributos son diferentes
		//Es como crear dos Objetos con un molde de plastelina
		//pero con plastelina diferente (color, tipo plastelina)
		//Son Instancias de la misma Clase, pero en absoluto son el mismo Objeto
		
		//Es abituar ofrecer un método constructor para asignar valores iniciales a los atributos del Objeto. 
		//Para consultar/obtener los valores de sus atributos y para asignar nuevos valores se usan los "get" y "set"
		//get (getter) --> Consultar valores
		//set (setter) --> Modificar su estado (inicializado con el constructor)
		
		class Vehiculo3 {
			
			//Cte de la Clase
			static final String ELEMENTO = "Vehículo"; 
			
			//Atributos del Objeto
			//Esta vez los definimos como privados, solo serán accesibles desde la propia clase
			//o indirectamente mediante métodos públicos que oferte la Clase 
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
			
			//Los atributos son de tipo private, por tanto deberemos dar algún
			//método público para obtener/modificar su valor
			//Métodos Get (Getter) y Set (Setter) para obtener/modificar los valores de los atributos
			//Si un método no devuelve ningún valor, entonces es de tipo void
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
			public void set_precio(int precio) { //Solamente es posible modificar el precio
				this.precio = precio;
			}
		} //class Vehiculo3 
		
		//Instanciamos la Clase para crear el Objeto y mostramos sus valores
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
		v5.set_precio(24000);
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

		//Vamos a mejorar nuestra clase con más métodos
		//y utilizaremos los getter y setter
		
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
			
			//Método Constructor
			public Vehiculo5 (String matricula,
				String marca,
				String modelo,
				int precio,
				boolean electrico,
				boolean hibrido) {
				
					set_matricula(matricula); 
					set_marca(marca);
					set_modelo(modelo); 
					set_precio(precio); 
					set_electrico(electrico);
					set_hibrido(hibrido); 
			}
			
			//En Java podemos duplicar los métodos (incluído el constructor), se denomina Sobrecarca
			//Es necesario que tengan una "firma" diferente
			//Firma está compuesta por nombre_método y lista_parámetros
			//Cambiando lista_parámetros, entonces tenemos una firma diferente
			
			//Método Constructor 2
			public Vehiculo5 (String matricula,
					String marca,
					String modelo,
					int precio) {
					
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
				this.matricula = matricula; 
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
			//El nombre de un método debería comenzar on un verbo, o ser un verbo. 
			public void muestra_coche() {
				System.out.println(Vehiculo5.ELEMENTO + " de Clase Vehiculo5"); 
				System.out.println("Vehiculo de matricula "+ get_matricula());
				System.out.println("Vehiculo de marca "+ get_marca());
				System.out.println("Vehiculo de modelo "+ get_modelo());
				System.out.println("Vehiculo de precio "+ get_precio());
				System.out.println("Vehiculo electrico "+ get_electrico());
				System.out.println("Vehiculo hibrido "+ get_hibrido());
			}
			
		} //class Vehiculo5
				
		//Instanciamos Clase Vehiculo5 y llamamos al método que nos muestra sus atributos 
		Vehiculo5 v7 = new Vehiculo5("777ABC", "Mercedes", "A220D", 44000, false, false);
		v7.muestra_coche();
		
		Vehiculo5 v9 = new Vehiculo5("1234ABC", "BMW", "330i", 66000);
		v9.muestra_coche();
		
		//Demostració de que la instanciación de Clase genera la referencia al Objeto más que el Objeto en sí
		Vehiculo5 v8; //Instanciamos la Clase para generar la referencia al Objeto
		v8 = v7; //Igualamos la referencia del nuevo Objeto a uno ya existente (perdemos el original) 
		System.out.println(v7);
		System.out.println(v8);
		v8.muestra_coche();
		
		//Si machacamos la referencia a un Objeto, perdemos la posibilidad de acceder a ese Objeto
		//La JVM tiene un proceso que libera memoria de Objetos inalcanzable. 
		//Recordamos Objetos v5 y v6
		
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v5.get_matricula());
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v6.get_matricula());
		v5 = v6; //Acabamos de perder el Objeto v5 puesto que hemos machacado su referencia
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v5.get_matricula());
		System.out.println(Vehiculo3.ELEMENTO + " de matricula "+ v6.get_matricula());
		
	} // public static void main
	
} // public class Leccion_4 
