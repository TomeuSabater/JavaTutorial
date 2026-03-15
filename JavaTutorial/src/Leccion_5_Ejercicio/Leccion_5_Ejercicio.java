package Leccion_5_Ejercicio;

public class Leccion_5_Ejercicio {

	public static void main(String[] args) {

		// Instanciamos la Class Bicycle

		Bicycle bici1 = new Bicycle("Orbea", "Rallón", true);
		Bicycle bici2 = new Bicycle("Lapierre", "Overvolt");

		// Mostramos sus atributos
		bici1.showBicycle();
		bici2.showBicycle();

		bici1.showBicycle();
		bici2.showBicycle();

		// Instancia la Class sin valores obligatorios
		Bicycle bici3 = new Bicycle("BH", "Lynx");
		bici3.showBicycle();

		// Instanciamos una BicyclePlus
		BicyclePlus bici_plus_1 = new BicyclePlus("Specialized", "Levo", true);
		bici_plus_1.showBicyle();

		// Aumentamos las marchas
		bici_plus_1.changeGear(+2);
		bici_plus_1.showBicyle();

		// Aumentamos cadencia
		bici_plus_1.changeCadence(+3);
		bici_plus_1.showBicyle();

		// Disminuimos marchas
		bici_plus_1.changeGear(-1);
		bici_plus_1.showBicyle();

		// Disminuimos marchas, sobrepasa límite
		bici_plus_1.changeGear(-3);
		bici_plus_1.showBicyle();

		// Frenamos
		bici_plus_1.applyBrake(5);
		bici_plus_1.showBicyle();

		// Intentamos el acceso a variables de instancia y métodos privados
		// bici_plus_1.cadence = 123;
		// bici_plus_1.gear = 4;
		// bici_plus_1.speed = 10;
		// bici_plus_1.changeSpeed(10);

	} // public static void main

} // class Leccion_5_Ejercicio
