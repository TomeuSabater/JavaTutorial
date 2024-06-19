package ejemplos;

public class Private {
	
	public static void main(String[] args) {
		
		class Prueba {

			private int atributo;
			
			public Prueba(int atributo) {
				this.atributo = atributo;
			}
			
			public int get_atributo() {
				return atributo;
			}
			
			public void set_atributo(int atributo) {
				this.atributo = atributo;
			}
			
		}
		
		Prueba v1 = new Prueba(10);
		System.out.println(v1.get_atributo());
		v1.atributo = 30; 
		System.out.println(v1.get_atributo());
		v1.set_atributo(50);
		System.out.println(v1.get_atributo());
		
	}

}
