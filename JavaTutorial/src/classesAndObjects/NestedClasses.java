package classesAndObjects;

public class NestedClasses {

	// Introducción_VI a CLASES Y OBJETOS.

	// Nested Class; INNER CLASS vs STATIC NESTED CLASS
	// Damos ejemplos para entender mejor la diferencia entre
	// - Nested Class (Inner Class)
	// - Static Nested Class

	// Variables de la Class
	private static String staticOuterField = "Static definida en la Class externa o contenedora";

	// Instance variables
	private String outerField = "Variable de instancia definida en la Class externa o contenedora";

	// Nested Classes
	private InnerClass objInner; // Inner Class
	private StaticNestedClass objStaticNested; // Static Nested Class

	//// Definimos la Inner Class
	// Está totalmente ligada a la Class contenedora
	// Tiene acceso total a los elementos de la Class contenedora
	// Para crear un Obj debe instanciarse primero la Class contenedora
	private class InnerClass {

		InnerClass() {
			// empty constructor
			// No haría falta definirlo
		}

		public void showAccessMembers() {
			System.out.println(outerField); // No access problems
			System.out.println(NestedClasses.staticOuterField); // No access problems
		}
	} // class InnerClass

	//// Definimos la Static Nested Class
	// Está "empaquetada" en la contenedora pero no tiene por qué tener una relación directa.
	// No tiene acceso a los elementos de la contenedora (excepto los Static obviamente).
	// Puede crearse un Obj de una Static Nested sin instanciar la Class contenedora.
	// Esta última particularidad nos permite usar la una Class contenedora como
	// elemento que 'empaqueta' otras Class para las que no encontramos una
	// ubicación clara como sería el caso de las Inner Class. 
	private static class StaticNestedClass {

		StaticNestedClass() {
			// Empty constructor
			// No haría falta definirlo
		}

		public void showAccessMembers() {
			// System.out.println(outerField); // Access problems
			System.out.println(NestedClasses.staticOuterField); // No access problems
		}
	} // static class StaticNestedClass

	
	// Constructor único 

	NestedClasses() {

		objInner = new InnerClass(); // Instanciamos la Inner
		objStaticNested = new StaticNestedClass(); // Instanciamos la Static Nested
	}

	// Public metods

	public void showNestedClasses() {

		objInner.showAccessMembers();
		objStaticNested.showAccessMembers();
	}

	public static void main(String[] args) {

		System.out.println("Inner class / Static Nested Class:");
		System.out.println("------------");
		NestedClasses outerObject = new NestedClasses();
		outerObject.showNestedClasses();

		// No se puede instanciar una Inner Class sin instanciar la contenedora
		// NestedClasses.InnerClass abc = new NestedClasses.InnerClass(); // Esto no es correcto

		// La gran diferencia entre una Inner Class y una Static Nested Class es que
		// podemos instanciar una Static Nested Class sin instanciar la Class contenedora
		NestedClasses.StaticNestedClass abc = new NestedClasses.StaticNestedClass();
		abc.showAccessMembers();
		
		// NestedClasses.InnerClass abcd = new NestedClasses.InnerClass(); -- No es posible

	} // public static void main

} // public class OuterClass. Pasar a Leccion_12.java para ejemplo más real y menos teórico 