package classesAndObjects;

public class NestedClasses {

	// Introducción_VI a CLASES Y OBJETOS.
	
	// Nested Class; Inner Class / Static Nested Class
	// Damos ejemplos para entender la diferencia entre 
	// - Inner Class 
	// - Static Nested Class

	// Class variables
	private static String staticOuterField = "Statica definida en la Class externa o contenedora";
	
	// Instance variables 
	private String outerField = "Definida en la Class externa o contenedora";
	
	private InnerClass objInner; 
	private StaticNestedClass objStaticNested; 

	//// Inner Class
	// Está totalmente ligada a la Class contenedora
	// Tiene acceso total a los elementos de la Class contenedora
	// Para crear un Obj debe instanciarse primero la Class contenedora
	private class InnerClass {

		InnerClass() {
			//empty constructor
		}
		
		public void showAccessMembers() {
			System.out.println(outerField); // No access problems
			System.out.println(NestedClasses.staticOuterField); // No access problems
		}
	} // class InnerClass

	//// Static Nested Class
	// Está "empaquetada" en la contenedora pero no tiene por qué tener una relación directa
	// No tiene acceso a los elementos de la contenedora (excepto los Static)
	// Puede crearse un Obj de una Static Nested sin instanciar la contenedora
	//	Esta última particularidad nos permite usar la una Class contenedora como elemento que 
	//	empaqueta otras Class para las que no encontramos una ubicación clara como Inner.   
	private static class StaticNestedClass {

		StaticNestedClass() {
			//Empty constructor
		}
		
		public void showAccessMembers() {	
			// System.out.println(outerField); // Access problems
			System.out.println(NestedClasses.staticOuterField); // No access problems
		}
	} // static class StaticNestedClass

	// Constructor 
	
	NestedClasses() {
		
		objInner = new InnerClass(); 
		objStaticNested = new StaticNestedClass(); 
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
		// NestedClasses.InnerClass abc = new NestedClasses.InnerClass(); 
		
		// Podemos instanciar una Static Nested Class sin instanciar la contenedora
		NestedClasses.StaticNestedClass abc = new NestedClasses.StaticNestedClass(); 
		abc.showAccessMembers(); 

	} // public static void main

} // public class OuterClass