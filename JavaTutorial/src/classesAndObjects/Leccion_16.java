package classesAndObjects;

public class Leccion_16 {
	
	// Introducción_VIII a CLASES Y OBJETOS. 
	
	// Anonymous Classes
	
	
	// Anonymous classes enable you to make your code more concise. 
	// They enable you to declare and instantiate a class at the same time. 
	// They are like Local Classes except that they DO NOT HAVE a name. 
	// Use them if you need to use a local class only once.
	
	// While Local Classes are class declarations, anonymous classes are expressions, 
	// which means that you define the class in another expression. 
	
	
	
	
	// Anonymous Classe implements and Interface or extends a Class. In the body, method declarations are allowed but statements are not.
	// It must be part of a statement, This explains why there is a semicolon after the closing brace.
	// An anonymous class has access to the members of its enclosing class.
	// Anonymous classes also have the same restrictions as local classes with respect to their members

	public static void main(String[] args) {
						
		class HelloWorldAnonymousClasses {
			
			// Interfaces a implementar
			interface HelloWorld {

				//Métodos públicos de la Interface 
				public void greet();
				public void greetSomeone(String someone); 
			}
			
			//Métodos públicos 
			public void sayHello() {
				
				//Local Class
				class EnglishGreeting implements HelloWorld {
					
					//Variables de Instancia
					String name = "world";
					
					//Métodos públicos 
					public void greet() {
						greetSomeone(this.name); 
						
					}
					public void greetSomeone(String someone) {
						this.name = someone; 
						System.out.println("Hello " + this.name);
					}
					
				} // class EnglishGreeting implements HelloWorld
							
				// Anonymous Class
				HelloWorld frenchGreeting = new HelloWorld() { // Implementa el Interface HelloWorld()
					
					String name = "Tout le monde";
					
					public void greet() {
						greetSomeone(this.name);
					}
					
					public void greetSomeone(String someone) {
						this.name = someone; 
						System.out.println("Salut " + this.name);
					}
					
				};  // HelloWorld (Anonymous Class) 
				
				// Anonymous Class
				HelloWorld spanishGreeting = new HelloWorld() { // Implementa el Interface HelloWorld()
					
					String name = "Todo el mundo";
					
					public void greet() {
						greetSomeone(this.name);
					}
					
					public void greetSomeone(String someone) {
						this.name = someone; 
						System.out.println("Hola " + this.name); 	
					}
					
				}; // HelloWorld (Anonymous Class) 
				
				HelloWorld englishGreeting = new EnglishGreeting(); //Instanciamos la Class para crear el Obj
				englishGreeting.greet(); 							//Invocamos el método del Obj
				
				frenchGreeting.greetSomeone("Fred"); //El Obj se ha instancia junto con la creación de la Class ya invocamos Obj
				spanishGreeting.greet(); //El Obj se ha instanciado junto con la creación de la Class, ya invocamos el Obj
				
			} // public void sayHello

		} // class HelloWorldAnonymousClasses
			
	
		HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
		myApp.sayHello();

	} // public static void main

} // public class Leccion_16
