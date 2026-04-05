package classesAndObjects;

public class NestedClass {

	// Introducción_VI a CLASES Y OBJETOS.
	// Nested Class; Inner Class / Static Class
	// Damos ejemplos de la diferencia entre una Inner Class y una Static Nested
	// Class

	String outerField = "Outer Field";
	static String staticOuterField = "Static outer field";

	//// Inner Class
	class InnerClass {

		void accessMembers() {
			System.out.println(outerField); // No access problems
			System.out.println(NestedClass.staticOuterField); // No access problems
		}
	} // class InnerClass

	//// Static Nested Class
	static class StaticNestedClass {

		void accessMembers(NestedClass outer) {
			// System.out.println(outerField); // Access problems
			System.out.println(outer.outerField); // No access problems
			System.out.println(NestedClass.staticOuterField); // No access problems

		}
	} // static class StaticNestedClass

	public static void main(String[] args) {

		System.out.println("Inner class:");
		System.out.println("------------");
		NestedClass outerObject = new NestedClass();
		NestedClass.InnerClass innerObject = outerObject.new InnerClass();
		innerObject.accessMembers();

		System.out.println("\nStatic nested class:");
		System.out.println("------------");
		StaticNestedClass staticNestedObject = new StaticNestedClass();
		staticNestedObject.accessMembers(outerObject);

	} // public static void main

	// Esto no me queda nada claro, a ver si haciendo un ejemplo en OuterClass

} // public class OuterClass