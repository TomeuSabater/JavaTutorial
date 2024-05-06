package MySQL;

public class Principal {

	public static void main(String[] args) {
	
		MySQLManager.loadDriver(); 
		MySQLManager.connect(); 
		MySQLManager.isConnected(); 
		
		// MySQLManager.imprimeStaff(222);
		
		MySQLManager.getClienteProc(333);
		
		MySQLManager.disconnect(); 

	}

}
