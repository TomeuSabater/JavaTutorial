package enums;

public class EnumExamples {

	public static void main(String[] args) {
		// Enums are a Class when all instances are known to the compiler
		// Enums are used for creating types that can only have few possible values

		enum DayOfWeek {
			// enum constants are listed here
			LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SÁBADO, DOMINGO
		}

		enum TypeOfRoom {
			// enums constants are listed here
			SIMPLE, DOBLE_ESTANDAR, DOBLE_SUPERIOR, TRIPLE, SUITE_JUNIOR, SUITE_BUSINESS, SUITE_ROYAL
		}

		// Accessing, evaluating and comparing enunms
		// The values of an enum can be used as constants

		DayOfWeek weekStart = DayOfWeek.LUNES;
		DayOfWeek weekEnd = DayOfWeek.DOMINGO;

		if (weekStart == DayOfWeek.LUNES) {
			System.out.println("The week starts on " + DayOfWeek.LUNES);
		}

		if (weekEnd == DayOfWeek.DOMINGO) {
			System.out.println("The week ends on " + DayOfWeek.DOMINGO);
		}

		TypeOfRoom tipoHabitacion = TypeOfRoom.SIMPLE;

		switch (tipoHabitacion) {
		case SIMPLE -> {
			System.out.println("Está alojado en una habitación " + TypeOfRoom.SIMPLE);
			System.out.println("Está alojado en una habitación " + TypeOfRoom.SIMPLE.name());
		}
		case DOBLE_ESTANDAR, DOBLE_SUPERIOR -> System.out.println("Está alojadon en una habitación doble " + tipoHabitacion);
		case TRIPLE -> System.out.println("Está alojado en una habitación doble de tipo" + TypeOfRoom.TRIPLE);
		default -> System.out.println("Está alojado en una suite de tipo" + tipoHabitacion);
		}
	}

}
