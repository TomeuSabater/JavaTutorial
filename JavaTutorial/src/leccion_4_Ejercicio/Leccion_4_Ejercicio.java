package leccion_4_Ejercicio;

public class Leccion_4_Ejercicio {

	public static void main(String[] args) {

		// Ejemplo atributos de la Class / Obj
		// Ejemplo de atributos private
		
		//Instanciamos Clase Vehiculo5 y llamamos al método que nos muestra sus atributos 
		Vehiculo5 v7 = new Vehiculo5("777ABC", "Mercedes", "A220D", 44000, false, false);
		v7.muestraCoche();
		
		// Intentamos acceder a los atributos del Obj directamente
		
		// v7.matricula = "ABC"; //No es posible, no tiene visibilidad y genera un error
		//System.out.println("Matricula es " + v7.matricula); //No es posible, no tiene visibilidad y genera un error
		
		//Solamente es posible acceder a los atributos "private" mediante los métodos públicos que oferta la Class Vehiculo5
		v7.set_matricula("777XYZ"); 
		System.out.println("Matricula es " + v7.get_matricula()); 
		v7.muestraCoche();
		
		//Sí es posible acceder a las variables de tipo static (porque en la Class no se han declarado como "private")
		System.out.println("Tipo elemento = " + Vehiculo5.ELEMENTO); 
		System.out.println("Tipo elemento = " + v7.ELEMENTO); // Es ok, pero se desaconseja esta manera de acceder a un atributo de la Class 
		
	} // public static void main

} // public class Leccion_4_Ejercicio 
