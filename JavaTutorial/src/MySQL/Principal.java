package MySQL;

public class Principal {

	public static void main(String[] args) {
	
		MySQLManager.loadDriver(); 
		MySQLManager.connect(); 
		MySQLManager.disconnect(); 

	}

}
