package leccion_6;

public class leccion_6 {

	public static void main(String[] args) {
		
		
		// Introduccion III a Clases y Objetos
		
		// Paso por valor y por referencia en métodos
		
		// Paso por valor: Se pasa el "valor de"
		//	copia el dato a una variable nueva
		// Paso por referencia: se para "la referencia de"
		//	No es una copia, es la misma variable 		
		

		class Circulo {
			
			static final String FIGURA = "Circulo"; 
			static final float VALOR_PI = 3.14f; // Valor de PI
			
			// Variables de instancia
			private int posicionX; // Ubicación en el eje X del círculo
			private int posicionY; // Ubicación en el eje Y del cículo
			private int radioCirculo; // Radio 
			private float areaCirculo; // Que se calcula automáticamente
			
			// Constructor
			public Circulo(int x, int y, int r) {
				
				// Llamar a los seterr
				setPuntoX(x);
				setPuntoY(y);
				setRadio(r);
			}
			
			
			private void setPuntoX(int valorX) {
				this.posicionX = valorX; 
			}
			
			private void setPuntoY(int valorY) {
				this.posicionY = valorY; 
			}
			
			private void setRadio(int valorR) {
				this.radioCirculo = valorR; 
			}
			
		}
		
	}

}
