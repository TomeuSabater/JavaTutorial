package classesAndObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Leccion_17 {

	public static void main(String[] args) {
		// Introducción_IX a CLASES Y OBJETOS. 
		
		// Lambda Expressions
		// For Classes with only one method, even an Anonymous Class seems a bit excessive and cumbersome
		// Lambda Expressions let you express instances of single-method classes more compactly.
		
		// Variables de Instancia
		enum Sex {MALE, FEMALE} //Sex Type
		
		
		//Nested Class Local Class
		class Person {
						
			private String name; 			//Person name
			private LocalDate birthday; 	//Person date of birthday
			private Sex gender; 			//Person sex; 
			
			//Constructor
			Person(String name, String birthday, Sex sex) {
				
				this.name = name; 
				this.birthday = LocalDate.parse(birthday); // Se espera un formato "yyy-mm-dd"
				this.gender = sex; 
			}
			
			//Métodos 			
			private int getAge() {
				//Devuelve la edad estimada
				LocalDate hoy = LocalDate.now(); // Fecha actual
				return (hoy.getYear() - this.birthday.getYear()); 
			}
			
			private Sex getGender() {
				// Devuelve Sex
				return this.gender; 
			}
			
			private void printPerson() {
				
				//Imprime los datos de la persona
				System.out.println("Nombre : " + this.name);
				System.out.println("Birthday : " + this.birthday);
				System.out.println("Age aprox : "+ this.getAge()); 
				System.out.println("Gender : " + this.gender);
				System.out.println("*************************"); 
			}
					
		} //class Person
	
		
		// Interfaces
		interface CheckPerson {
			boolean testAge(Person p); 
		}
		
		// Class que implemente el Interface
		class CheckPersonEligibleForSelectiveService implements CheckPerson {
			
			//Métodos 
			public boolean testAge(Person p) {
				
				int age = p.getAge();
				
				return p.getGender() == Sex.MALE
				&& age >= 50
				&& age <= 60; 
			}
		} // class CheckPersonEligibleForSelectiveService
		
		// Implementa los métodos static que llamaremos desde main()
		class RosterTest {
		
			//Aproach 1 :  Create static methods that search for members that match one characteristic
			private static void printPersonsOlderThan(List<Person> roster, int age) {
				
				for (Person p: roster) {
					if (p.getAge() >= age) {
						p.printPerson();
					}
				}
			} // private static void printPersonsOlderThan
			
			//Approach 2: Create static methods that search using a more generalized search methods
			private static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
			
				int age = 0; //Contendrá la edad de la Person
				for (Person p: roster) {
					age = p.getAge(); //Obtenemos la edad de la Person
					if (low <= age && age < high) {
						p.printPerson();
					}
				}
			} // private static void printPersonsWithinAgeRange
			
			// Approach 3: Specify Search Criteria Code in a Local Class
			// Approach 4: Specify Search Criteria Code in an Anonymous Class
			// Approach 5: Specify Search Criteria Code with a Lambda Expression
			
			private static void printPersons(List<Person> roster, CheckPerson tester) {
				
				for (Person p: roster) {
					if (tester.testAge(p)) {
						p.printPerson();
					}
				}
			} // private static void printPersons
			
			
						
		} // class RosterTest

		
		// main() ********************************************************
		
		
		//Creamos algunos Objetos Person
		Person p1 = new Person("Tomeu", "1966-03-18",  Sex.MALE); 
		p1.printPerson();
		
		Person p2 = new Person("Juan", "1943-07-21",  Sex.MALE); 
		p2.printPerson();
		
		Person p3 = new Person("Marga", "1986-05-03",  Sex.FEMALE); 
		p3.printPerson();
		
		Person p4 = new Person("Montse", "1956-07-27",  Sex.MALE); 
		p4.printPerson();
		
		Person p5 = new Person("Vicente", "1965-06-06",  Sex.MALE); 
		p5.printPerson();
		
		
		//Creamos una Lista de Objetos Person, será una lista de punteros a Objetos de Class Person
		List<Person> listaPersona = new ArrayList<Person>();
		
		//Insertamos los Objetos Person dentro de la Lista 
		listaPersona.add(p1); 
		listaPersona.add(p2); 
		listaPersona.add(p3); 
		listaPersona.add(p4); 
		listaPersona.add(p5); 
		listaPersona.add(new Person("Maria", "1964-12-12",  Sex.FEMALE)); // Insertamos en la Lista de Personas un nuevo Objeto Persona

		//Mostramos el contenido de cada Objeto Person
		for (Person p: listaPersona) {
			p.printPerson();
		}
				
		//Aproach 1 Create Methods that Search for Persons that Match One
		System.out.println("***************Aproach 1"); 
		RosterTest.printPersonsOlderThan(listaPersona, 60);

		//Aproach 2 Create More Generalized Search Methods
		System.out.println("***************Aproach 2"); 
		RosterTest.printPersonsWithinAgeRange(listaPersona, 50, 80);
		
		//Aproach 3 Specify Search Criteria Code in a Local Class
		System.out.println("***************Aproach 3"); 
		RosterTest.printPersons(listaPersona, new CheckPersonEligibleForSelectiveService());
		
	    //Approach 4: Specify Search Criteria Code in an Anonymous Class
		//One of the arguments of the invocation of the method printPersons is an anonymous class 
		System.out.println("***************Aproach 4"); 
		RosterTest.printPersons(listaPersona, 
								new CheckPerson() {
									public boolean testAge(Person p) {
										int edad = p.getAge(); 
										return (p.getGender() == Sex.MALE
												&& edad >= 50
												&& edad <= 60); 
									} //public boolean testAge
								}
		);
				
		// Approach 5: Specify Search Criteria Code with a Lambda Expression
		// In the previous approach, The syntax of anonymous classes is bulky considering that the CheckPerson interface contains only one method.
		// We can use a lambda expression instead of an anonymous class, as described in the next section.
		// Because a functional interface contains only one abstract method, you can omit the name of that method when you implement it. 
		// To do this, instead of using an anonymous class expression, you use a lambda expression
		RosterTest.printPersons(listaPersona,
								(Person p) -> p.getGender() == Sex.MALE
								&& p.getAge() >= 50
								&& p.getAge() <= 60
		);
		
		// Y me paro aquí porque me estoy perdiendo. 
		
	} // public static void main
} // class Leccion_17
