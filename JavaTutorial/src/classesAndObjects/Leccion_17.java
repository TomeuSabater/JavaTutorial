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
				this.birthday = LocalDate.parse(birthday);
				this.gender = sex; 
			}
			
			//Métodos públicos			
			public int getAge() {
				
				//Devuelve la edad estimada
				LocalDate hoy = LocalDate.now(); // Fecha actual
				return (hoy.getYear() - this.birthday.getYear()); 
			}
			
			public void printPerson() {
				
				//Imprime los datos de la persona
				System.out.println("Nombre : " + this.name);
				System.out.println("Birthday : " + this.birthday);
				System.out.println("Age aprox : "+ this.getAge()); 
				System.out.println("Gender : " + this.gender);
				System.out.println("*************************"); 
			}
					
		} //class Person
	
		class RosterTest {
			
			interface CheckPerson {
				boolean testAge(Person p); 
			}
			
			//Aproach 1 :  Create static Methods That Search for Members That Match One Characteristic
			public static void printPersonsOlderThan(List<Person> roster, int age) {
				
				for (Person p: roster) {
					if (p.getAge() >= age) {
						p.printPerson();
					}
				}
			} // public static void printPersonsOlderThan
			
			//Approach 2: Create More Generalized Search Methods
			public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
			
				for (Person p: roster) {
					if (low <= p.getAge() && p.getAge() < high) {
						p.printPerson();
					}
				}
			} // public static void printPersonsWithinAgeRange
			
			
			
		} // class RosterTest
		
		
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

		//Aproach 1
		System.out.println("***************Aproach 1"); 
		RosterTest.printPersonsOlderThan(listaPersona, 60);

		//Aproach 2
		System.out.println("***************Aproach 2"); 
		RosterTest.printPersonsWithinAgeRange(listaPersona, 50, 80);
		
		
	} // public static void main
} // class Leccion_17
