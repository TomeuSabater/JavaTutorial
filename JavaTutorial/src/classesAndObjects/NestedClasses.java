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

	} // public static void main

} // public class OuterClass