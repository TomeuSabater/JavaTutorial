package classesAndObjects;

public class Tutorial4 {

	public static void main(String[] args) {
		// Introducción a Class y Objects
		
		// Definicion de Class, Instanciacion de Object
		// Constantes y atributos de la Class/Obj
		// Métodos constructores, getter y setter
		// Constructor implícito
		// Atributos públicos/privados
		// Métodos públicos
		// Sobrecarga de métodos
		// Palabra reservada "this"
		
		
		class Circulo { // Nombre de la Class en Mayúscula
			
			// Variables y constantes de la Class
			
			// CTES y Variables static
			static final String FIGURA = "Círculo"; 
			
			// Variables de instancia
			int x; // Posición en el plano
			int y; // Posición en el planio
			int radio; // Radio del cículo
		} // Circulo
		
		// Instanciar la Class para generar Objects
		
		Circulo circulo1; 
		circulo1 = new Circulo(); 
		
		Circulo circulo2 = new Circulo(); 
		
		circulo1.x = 1;
		circulo1.y = 2; 
		circulo1.radio = 3; 
		
		circulo2.x = 4;
		circulo2.y = 5; 
		circulo2.radio = 6; 
		
		System.out.println("Figura " + circulo1.FIGURA + " circulo1.x= " + 
		circulo1.x + " circulo1.y = " + circulo1.y + " radio = " + circulo1.radio); 
		
		System.out.println("Figura " + circulo2.FIGURA + " circulo2.x= " + 
		circulo2.x + " circulo2.y = " + circulo2.y + " radio = " + circulo2.radio); 
		
		class Vehiculo {
			
			static final String CACHARRO = "Vehículo"; // Nombre del objeto
			static final int TOPE = 50000; // Tope del valor del vehículo
			
			String matricula; // Matrícula de vehículo
			String marca; // Marca del vehículo
			String modelo; // Modelo del vehículo
			int precio; // precio en €
			boolean electrico; // Si es eléctrico
			boolean hibrido; // Si es híbrido 
			
			// Métodos constructores
			
			public Vehiculo (String matricula, String marca, String modelo, int precio,
				boolean electrico, boolean hibrido) {
				
				this.setMatricula(matricula);
				this.setMarca(marca);
				this.setModelo(modelo);
				this.setPrecio(precio);
				this.setElectrico(electrico);
				this.setHibrido(hibrido);
			} // Constructor A
						
			public Vehiculo (String marca, String modelo, int precio,
					boolean electrico, boolean hibrido) {
		
				this.setMatricula(" "); // No tenemos matrícula todavía
				this.setMarca(marca);
				this.setModelo(modelo);
				this.setPrecio(precio);
				this.setElectrico(electrico);
				this.setHibrido(hibrido);
			} // Constructor B

			// Metodos públicos
			
			// Setters
			public void setMatricula(String matricula) {
				this.matricula = matricula.toUpperCase(); 
			}
			public void setMarca(String marca) {
				this.marca = marca.toUpperCase(); 
			}
			public void setModelo(String modelo) {
				this.modelo = modelo.toUpperCase(); 
			}
			public void setPrecio(int precio) {
				this.precio = precio; 
			}
			public void setElectrico(boolean electrico) {
				this.electrico = electrico; 
			}
			public void setHibrido(boolean hibrido) {
				this.hibrido = hibrido; 
			}
			
			// Getters
			
			public String getTipoObjeto() {
				return(Vehiculo.CACHARRO);
			}
			public String getMatricula() {
				return(this.matricula);
			}
			public String getMarca() {
				return(this.marca);
			}
			public String getModelo() {
				return(this.modelo);
			}
			public int getPrecio() {
				return(this.precio);
			}
			public String getTipoVehiculo() {
				if (this.electrico) {
					return("Es eléctrico");
				} else if (this.hibrido) {
					return("Es híbrido");
				} else {
					return("Es combustión"); 
				}
			}
			
			public void imprimeVehiculo() {
				System.out.println(this.getTipoObjeto()); 
				System.out.println(this.getMatricula());
				System.out.println(this.getMarca());
				System.out.println(this.getModelo());
				System.out.println(this.getPrecio());
				System.out.println(this.getTipoVehiculo());
			} // imprimeVehiculo
			
			public void modificaPrecio(int precio) {
				
				// Modifica el precio del vehículo 
				// controla el margen
				
				if (precio < this.precio) {
					System.out.println("El precio no puede ser menor a" + this.precio);
				} else if (precio > Vehiculo.TOPE) {
					System.out.println("El precio no puede ser mayor a " + Vehiculo.TOPE);
				} else {
					this.precio = precio; // Se ajusta el valor
				}
			} // modificaPrecio
			
		} // Vehiculo
		
		Vehiculo vehiculo1 = new Vehiculo("5284HTX", "Ford", "Fiesta", 10000,
				false, false);
		Vehiculo vehiculo2 = new Vehiculo("123HTX", "Renault", "Clio", 15000,
				false, true);
		
		System.out.println("vehiculo1 = " + vehiculo1);
		System.out.println("vehiculo2 = " + vehiculo2);
		
		//vehiculo1 = vehiculo2; 
		//vehiculo2 = null; 
		
		// Mostramos el vehículo por pantalla
		vehiculo1.imprimeVehiculo();
		vehiculo2.imprimeVehiculo();
		
		vehiculo1.modificaPrecio(15000);
		vehiculo1.imprimeVehiculo();
		
		// Cambiar los valores de instancia
		vehiculo1.setMatricula("Aabdada");
		vehiculo1.setMarca("Mercedes");
		vehiculo1.setPrecio(15000); // Cambio el precio
		
		vehiculo1.imprimeVehiculo();
		
		Vehiculo vehiculo3 = new Vehiculo("BMW", "M3", 15000,
				false, true);
		vehiculo3.imprimeVehiculo();
		
	} // main

}
