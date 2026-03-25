package classesAndObjects;

public class Leccion_6 {

	public static void main(String[] args) {

		// Introducción_III a CLASES Y OBJETOS.

		// Paso por valor y por referencia en métodos
		// Estándares para nombre de Class, Atributo y Método

		// Primitive arguments, such as an int or a double, are passed into methods by
		// value.
		// Reference data type parameters, such as objects, are also passed into methods
		// by value.
		// However, the values of the object's fields of the objects passed can be
		// changed in the method

		// Paso por valor: Se pasa el 'valor de':
		// 'Copia del dato, el dato original permanece inalterado, se crea nueva
		// variable copia de la original
		// Paso por referencia: Se pasa la 'referencia de':
		// No es una copia del dato, es el dato,
		// es la variable (la dirección de memoria de la variable)

		// No obstante, en Java (y en otros lenguajes como Python) se pasa por valor una
		// referencia
		// Hay que entender que lo que manejamos de un Obj es una referencia (puntero)
		// al Obj.
		// Es importante entender que en Java, los parámetros se pasan por valor, nunca
		// por referencia
		// Es importante enteder que cuando pasamos por valor un Obj, pasamos por valor
		// la referencia (puntero) al Obj, nunca el Obj en sí y al pasar por valor
		// una referencia (puntero) a un Obj creamos una nueva referencia (puntero) que
		// apunta al mismo Obj.
		// Entonces, aún pasando por valor un Obj, en Java estamos pasando el mismo Obj,
		// porque pasamos su referencia por valor, no el Obj en sí.
		// parece un contrasentido, se denomina paso por valor-referencia, y se consigue
		// pasar por referencia un Obj en paso por valor

		// También hay que entender que si pasamos como parámetro un Obj, aún siendo por
		// valor,
		// no pasamos el Obj entero, no hace una copia del Obj.
		// Esta estrategia permite que sea muy eficiente porque se pasa por valor un
		// parámetro muy 'ligero'. La copia de la referencia al Obj no es costosa,
		// sería mucho más costos hacer una copia de todo el Obj

		// Veamos algún ejemplo del paso por valor-referencia de Obj en Java

		class Circulo { // Por convención, el nombre de una Class comienza siempre en mayúsculas
						// Si es palabra compuesta, se juntan las palabras y cada palabra en mayúsculas,
						// ej: UtilidadesCirculo, BicyclePlus, PersonaAlumno, PersonaProfesor, etc.
						// Usar sustantivos: Los nombres de las clases siempre deben ser sustantivos.
						// Evita usar verbos, ya que esos se reservan para los métodos.
						// Capitalización: La primera letra de cada palabra debe ir en mayúscula.

			// Variables de la Class y Ctes de la Class
			// Las constantes se recomienda escribirlos en SCREAMING_SNAKE_CASE
			static final String FIGURA = "Circulo"; // Tipo de figura. CTEs siempre en mayúscula (no su valor)
			static final float VALOR_PI = 3.14f; // Valor de PI. CTEs siempre en mayúscula

			// Atributos de la Clase. Los definimos private
			// Se recomienda escribirlos en lowerCamelCase
			// Se evitará el uso de "_" (totalmente desaconsejado en Java excepto en CTES)
			private int posicionX; // Posición x en el plano. Nombre de atributo en minúscula, siguientes palabra
									// en mayúscula
			private int posicionY; // Posición y en el plano. Nombre de atributo en minúscula, siguientes palabra
									// en mayúscula
			private int radioCirculo; // Radio del círculo. Nombre de atributo en minúscula, siguientes palabra en
										// mayúscula
			private float areaCirculo; // Area del cículo. Nombre de atributo en minúscula, siguientes palabra en
										// mayúscula

			// Constructor
			public Circulo(int x, int y, int r) {

				// Llamamos a setters
				setPuntoX(x);
				setPuntoY(y);
				setRadio(r);
			}

			// Métodos privados, solo accesible desde el interior de la Class
			// Los nombres de los métodos siguen la norma del lowerCamelCase
			// Un método representa una acción, por lo que su nombre debe empezar con un
			// verbo.

			private float calculaArea(int radio) { // Nombre método es un verbo, comienza minúscula, si compuesta
													// primera palabra mayúscula
				return (VALOR_PI * (radio * radio));
			}

			// Métodos públicos; accesibles universalmente

			// Getters

			public int getPuntoX() {
				return this.posicionX;
			}

			public int getPuntoY() {
				return this.posicionY;
			}

			public int getRadio() {
				return this.radioCirculo;
			}

			public float getArea() {
				return this.areaCirculo;
			}

			// Setters

			public void setPuntoX(int valorX) {
				this.posicionX = valorX;
			}

			public void setPuntoY(int valorY) {
				this.posicionY = valorY;
			}

			public void setRadio(int valorR) {
				this.radioCirculo = valorR;
				// Area está asociado al atributo 'radio'.
				this.areaCirculo = calculaArea(this.radioCirculo);
			}

			// Método al que pasamos por valor la referencia (identificador) del Objeto
			public void muestraCirculo(Circulo circulito) { // Circulo circulito es totalmente redundante, es un ejemplo

				System.out.println("Figura :" + FIGURA);
				System.out.println("Referencia :" + circulito);
				System.out.println("X = " + circulito.getPuntoX());
				System.out.println("Y = " + circulito.getPuntoY());
				System.out.println("Radio = " + circulito.getRadio());
				System.out.println("Área = " + circulito.getArea());
			} // public void muestraCirculo

		} // class Circulo

		// Definimos una nueva Class cuyo único objetivo será la de ofrecer
		// utilidades mediante métodos públicos para el manejo del Obj Círculo
		// Los métodos tendrán como parámetros referencias a Obj Círculo
		// Circulo 'ci' se pasa por valor, lo que significa que ci es una NUEVA
		// referencia al mismo Obj Circulo c1
		// c1 y ci son dos "variables" distintas pero referencian(apuntan) al mismo Obj
		// Círculo

		class UtilidadesCirculo {
			// Esta Class nos servirá para agrupar métodos con utilidades para el manejo del
			// Obj Circulo
			// No tenemos constructor en UtilidadesCirculo() porque el objetivo es tener los
			// métodos de la Class, en absoluto instancia esta Class que agrupa métodos
			// OBSERVACIÓN: Java ya tiene herramientas para conseguir este comportamiento,
			// las static Class que no hace falta instanciarlas; lo que nos permitiría
			// invocar sus métodos directamente
			// (el concepto de static Class se verá posteriormente),

			// Centrémonos ahora en una Class que oferta utilidades (mediante métodos)

			public void desplazaCirculo(int deltaX, int deltaY, Circulo ci) {
				// Método público que desplaza un deltaX & deltaY la posición del Círculo ci

				// Lo hacemos sencillo para entenderlo
				int x = ci.getPuntoX(); // Obtengo valor de puntoX
				int y = ci.getPuntoY(); // Obtengo valor de puntoY

				x += deltaX; // Incremento (x = x + deltaX)
				y += deltaY; // Incremento (y = y + deltaY)

				ci.setPuntoX(x); // Asigno nuevo valor X
				ci.setPuntoY(y); // Asigno nuevo valor Y

				// Lo hacemos ahora más Javero o Javaloya (Javaloyero)
				ci.setPuntoX(ci.getPuntoX() + deltaX); // Llama a los métodos de Circulo
				ci.setPuntoY(ci.getPuntoY() + deltaY); // Llama a los métodos de Circulo
				ci = null; // OMG; Tranquilo, se pasan los parámetros por valor, c1 no es afectado.
							// Java VM liberará automáticamente los recursos de ci,
							// hacerlo explícitamente es redundante, no necesario
			} // Al acabar el método, la JVM liberará recursos locales; deltaX, deltaY, ci
				// "ci" es una ref al Obj no el Obj en sí, "c1" no afectado, y el Obj en sí
				// tampoco

		} // class UtilidadesCirculo

		// Defimimos un círculo
		Circulo c1 = new Circulo(3, 2, 5); // Instanciamos
		c1.muestraCirculo(c1); // Lo mostramos

		// Desplazamos el círculo
		UtilidadesCirculo Utils = new UtilidadesCirculo();
		Utils.desplazaCirculo(+1, -3, c1);
		c1.muestraCirculo(c1);

	} // public static void main

} // class Leccion_6
