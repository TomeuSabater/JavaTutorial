package classesAndObjects;

public class Leccion_6 {

	public static void main(String[] args) {

		// Introducción_III a CLASES Y OBJETOS. 
		
		// Paso por valor y por referencia en métodos
		// Estándares para nombre de Class, Atributo y Método
		
		// Primitive arguments, such as an int or a double, are passed into methods by value.
		// Reference data type parameters, such as objects, are also passed into methods by value. 
		// However, the values of the object's fields of the objects passed can be changed in the method
		
		// Paso por valor: Se pasa el 'valor de'
		//		'Copia del dato, el dato original permanece inalterado, se crea nueva variable copia de la original
		// Paso por referencia: Se pasa la 'referencia de'
		//		No es una copia del dato, es el dato, es la variable (la dirección de memoria de la variable) 
		
		// No obstante, en Java (y en Python) se pasa por valor una referencia
		// Hay que entender que lo que manejamos de un Obj es una referencia (puntero) al Obj. 	
		// Es importante entender que en Java, los parámetros se pasan por valor, nunca por referencia
		// Es imporante enteder que cuando pasamos por valor un Obj, pasamos por valor la referencia (puntero) al Obj, nunca el Obj en sí
		// y al pasar por valor una referencia (puntero) a un Obj creamos una nueva referencia (puntero) que apunta al mismo Obj. 
		// Entonces, aún pasando por valor un Obj, en Java estamos pasando el mimso Obj, porque pasamos su referencia por valor, no el Obj en sí. 
		
		// También hay que entender que si pasamos como parámetro un Obj, aún siendo por valor, no pasamos el Obj entero, no hace una copia del Obj
		//		esta estrategia permite que sea muy eficiente porque se pasa por valor un parámetro muy 'ligero' la copia de la referencia al Obj
		//		no es costosa, sería mucho más costos hacer una copia de todo el Obj
		
		
		class Circulo { //Por convención, el nombre de una Class comienza siempre en mayúsculas
						//Si es palabra compuesta, se juntan las palabras y cada palabra en mayúsculas, ej: UtilidadesCirculo
			
			//Variables de la Class y Ctes de la Class 
			static final String FIGURA = "Circulo"; // Tipo de figura. CTEs en mayúscula
			static final float PI = 3.14f; // Valor de PI. CTEs en mayúscula
		
			//Atributos de la Clase. Los definimos private
			private int x; // Posición x en el plano. Nombre de atributo en minúscula, siguientes palabra en mayúscula
			private int y; // Posición y en el plano. Nombre de atributo en minúscula, siguientes palabra en mayúscula
			private int radio; // Radio del círculo. Nombre de atributo en minúscula, siguientes palabra en mayúscula
			private float area; // Area del cículo. Nombre de atributo en minúscula, siguientes palabra en mayúscula
			
			//Constructor
			public Circulo(int x, int y, int r) {
				setX(x); 
				setY(y); 
				setRadio(r); 
			}
			
			//Métodos privados, solo accesible desde el interior de la Class
			private float calculaArea(int r) { //Nombre método es un verbo, comienza minúscula, si compuesta primera palabra mayúscula
				return (PI * (radio * radio)); 
			}
			
			//Métodos públicos, accesibles universalmente
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
				this.area = calculaArea(this.radio); // Totalmente asociado al atributo 'radio'.
			}
			
			//Método al que pasamos por valor la referencia (identificador) del Objeto
			public void muestraCirculo(Circulo c) { //Circulo c es totalmente redundante, es un ejemplo
				
				System.out.println("Figura :" + FIGURA); 
				System.out.println("Referencia :" + c); 
				System.out.println("X = " + c.getX());
				System.out.println("Y = " + c.getY());
				System.out.println("Radio = " + c.getRadio());
				System.out.println("Área = " + c.getArea()); 
			} // public void muestraCirculo
			
		} // class Circulo
		
		
		//Definimos una nueva clase cuyo único objetivo será la de ofrecer 
		//	utilidades mediante métodos públicos para el manejo del Obj Círculo
		//Los métodos tendrán como parámetros referencias a Obj Círculo
		//Circulo 'ci' se pasa por valor, lo que significa que ci es una NUEVA referencia al mismo Obj Circulo c1
		//c1 y ci son dos "variables" distintas pero referencian(apuntan) al mismo Obj Círculo
		class UtilidadesCirculo {
			//Esta Class nos servirá para agrupar métodos con utilidades para el manejo de Obj Circulo
			//No tenemos constructor UtilidadesCirculo() porque el objetivo es tener los métodos de la Class
			//	Java tiene otras herramientas para conseguir este comportamiento, las static Class que no hace falta instanciarlas
			//	lo que nos permitiría invocar sus métodos directamente (se verá posteriormente) 
						
			public void desplazaCirculo(int deltaX, int deltaY, Circulo ci) {
			//Método público que desplaza un deltaX, deltaY la posición del Círculo ci
		
				//Lo hacemos sencillo para entenderlo
				int x = ci.getX(); //Obtengo valor de X
				int y = ci.getY(); //Obtengo valor de Y
				x += deltaX; //Incremento (x = x + deltaX)
				y += deltaY; //Incremento (y = y + deltaY)
				ci.setX(x); //Asigno nuevo valor X 
				ci.setX(x); //Asigno nuevo valor Y
				
				//Lo hacemos ahora más Javero o Javaloya 
				ci.setX(ci.getX() + deltaX); //Llama a los métodos de Circulo
				ci.setY(ci.getY() + deltaY); //Llama a los métodos de Circulo
				ci = null; //Se pasan los parámetros por valor, c1 no es afectado. 
							// Java VM liberará automáticamente los recursos de ci, hacerlo es redundante
			} //Al acabar el método, la JVM liberará recursos locales; deltaX, deltaY, ci (que es una ref al Obj no el Obj en sí), c1 no afectado
			
		} // class UtilidadesCirculo
		
		
		//Defimimos un círculo
		Circulo c1 = new Circulo(3,2,5);
		c1.muestraCirculo(c1);

		//Desplazamos el círculo
		UtilidadesCirculo Utils = new UtilidadesCirculo();
		Utils.desplazaCirculo(+1, -3, c1);
		c1.muestraCirculo(c1);

	} //public static void main

} // class Leccion_6 
