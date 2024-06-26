package ejemplos;

public class Leccion_6 {

	public static void main(String[] args) {

		// Introducción_III a CLASES Y OBJETOS. 
		// Paso por valor y por referencia en métodos
		// Primitive arguments, such as an int or a double, are passed into methods by value.
		// Reference data type parameters, such as objects, are also passed into methods by value. However, the values of the object's fields can be changed in the method
		
		class Circulo { //Por convención, el nombre de la Clase comienza en mayúsculas
			
			//Constantes de la Clase
			static final String FIGURA = "Circulo"; // Tipo de figura
			static final float PI = 3.14f; // Valor de PI
		
			//Atributos de la Clase
			private int x; // Posición x en el plano. 
			private int y; // Posición y en el plano. 
			private int radio; // Radio del círculo. 
			private float area; // Area del cículo. 
			
			//Constructor
			public Circulo(int x, int y, int r) {
				setX(x); 
				setY(y); 
				setRadio(r); 
			}
			
			//Métodos privados
			private float calculaArea(int r) {
				return (PI * (radio * radio)); 
			}
			
			//Métodos públicos
			public int getX() {
				return this.x; 
			}
			public int getY() {
				return this.y; 
			}
			public int getRadio() {
				return this.radio;
			}
			public float getArea() {
				return this.area; 
			}
			public void setX(int x) {
				this.x = x; 
			}
			public void setY(int y) {
				this.y = y; 
			}
			public void setRadio(int r) {
				this.radio = r; 
				this.area = calculaArea(this.radio); 
			}
					
			
			//Método al que pasamos por referencia el identificador el Objeto
			public void muestraCirculo(Circulo c) {
				
				System.out.println("Figura :" + FIGURA); 
				System.out.println("Referencia :" + c); 
				System.out.println("X = " + getX());
				System.out.println("Y = " + getY());
				System.out.println("Radio = " + getRadio());
				System.out.println("Área = " + getArea()); 
			} // public void muestraCirculo
			
		} // class Circulo
		
		
		//Definimos una nueva clase cuyo único objetivo será la de ofrecer 
		//utilidades mediante métodos públicos para el manejo del círculo
		//Los métodos tendrán como parámetros referencias a Objetos Círculo
		class UtilidadesCirculo {
			//Esta clase nos servirá para agrupar métodos con utilidades para el manejo de círculos
			
			public void desplazaCirculo(Circulo ci, int deltaX, int deltaY) {
			//Método público que desplaza un deltaX, deltaY la posición del círculo
						
				ci.setX(ci.getX() + deltaX); 
				ci.setY(ci.getY() + deltaY);
			}
			
		} // class UtilidadesCirculo
		
		
		//Defimimos un círculo
		Circulo c1 = new Circulo(3,2,5);
		c1.muestraCirculo(c1);
		
		//Desplazamos el círculo
		UtilidadesCirculo Utils = new UtilidadesCirculo();
		Utils.desplazaCirculo(c1, +1, -3);
		c1.muestraCirculo(c1);

	} //public static void main

} // class Leccion_6 
