
public class Leccion_13_Ejercicio_bis {

	public static void main(String[] args) {
	
		
		/*
		
		Antes de pasar al tema de las Local y Anonymous Class, hacemos un ejercicio para acabar
		de entender las Local Class (Inner / Static). Para ello, miraremos de definir un expediente
		 
		 Expediente: Es un objeto que aglutina un conjunto de reservas que pueden ser de varios tipos (Vuelo, Traslado, Hotel, Seguro, etc.)
		 La información mínima que contiene un Expediente es la siguiente:
		 Código Único de Expediente: Es un código único por cada expediente y está compuesto por: 	
		 		- Cte: Constante de 3 carácteres, en nuestro caso "EXP"
		 		- Año: de la Fecha de creación
		 		- Mes: de la Fecha de creación
		 		- Número: Número único incremental
		 		Ejemplos: EXP/2024/08/001, EXP/2024/08/002, EXP/2024/09/003, ... 
		 Fecha: Fecha de creación del expediente
		 Titular: Aún habiendo varios pasajeros, solamente existe un titular del expediente, que también es pasajero. 
		 Pasajeros: 
		 		- Número : Número de Pasajero (1, 2, 3, 4, ...)
		 		- Sr/Sra : Title
		 	 	- Nombre : Nombre de Pila 
		 	 	- Apellidos : Puede haber varios o uno solo
		 	 	- DNI/Passport : Identificador del Pasajero
		 	 	- Edad : Edad del Pasajero
		 Reservas: Un Expediente puede tener N Reservas, Cada Reserva contiene la siguiente información mínima
		 		- Localizador de la Reserva: Número Único para cada Reserva y está compuesto por
		 				- Cte: Constante de 3 carácteres que define el tipo: HTL (Hotel), VUE (Vuelo), TRL (Traslado), ACT (Actividad)
		 				- Año: de la Fecha de creación
		 				- Mes: de la Fecha de creación
		 				- Número: Número único incremental para cada tipo de reserva
		 				Ejemplos: HTL/2024/07/001, HTL/2024/07/002, VUE/2024/07/001, TRL/2024/07/001, ACT/2024/07/001, ACT/2024/07/002,...

		  		- Fecha de Inicio Servicio: Fecha de Inicio/Entrada
		  		- Fecha de Fin Servicio: Fecha de Fin/Salida
		  		- Precio Neto: Precio de la Reserva sin Impuestos
		  		- Precio Bruto: Precio Total de la Reserva (Neto + 21% IVA)
		  		Si Reserva es HTL:
		  		 	- Dirección; Dirección postal del hotel
					- Tipo de Alojamiento: SA (Sólo Alojamiento), AD (Alojamiento y Desayuno), PC (Pensión Completa), UX (Todo Incluído)
		  		Si Reserva es VUE:
		  			- A/P de Salida: Código 3 letras IATA del aeropuerto de salida, Eje: PMI
					- A/P de llegada: Código 3 letras IATA del aeropuerto de llegada, Eje: MAD
				Si Reserva es TRL:
					- Recogida: Lugar de Recogida, es una dirección postal
					- Destino: Lugar de Destino, es una dirección postal 
		  		Si Reserva es ACT:
		  			- Ubicación de la Actividad: Es una dirección postal


		 Observaciones: 
		 	- Tanto el Expediente como la Reserva han de contener la información mínima indicada, pero se pueden añadir campos si se necesitan. 
		 	- El Titular también es un Pasajero, y no puede ser menor de edad. 
		 	- La Edad de los Pasajeros se almacena para control de acceso a actividades 
		 	- Fecha de Creación del Expediente: Fecha generación del Expediente que no tiene por qué coincidir con las fechas de los servicios
		 	- Número de Expediente: La Fecha de creación del Expediente tiene que coincidir con el Número de Expediente
		 	- Todas las Reservas del Expediente tiene los mismos pasajeros, puede haber N pasajeros para cada Reserva.
		 	- El Titular del Expediente también es un Pasajero, y es el Pasajero 1. 
		  	- No ha de ser posible, desde "public static void main" alterar los números únicos de expediente y reserva (Si se consigue la entrega no es válida) 
		  	- Normalmente, un Expediente contiene un mínimo de 6 reservas. 
		  			Vuelo de ida y de vuelta, estancia en Hotel, traslado de ida y de vuelta entre A/P y Hotel, y una actividad. 
		 		 
		 
		*/

	}

}
