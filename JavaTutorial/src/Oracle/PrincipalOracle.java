package Oracle;


public class PrincipalOracle {

	public static void main(String[] args) {
		
		OracleManager.loadDriver(); 
		OracleManager.connect(); 
		OracleManager.isConnected(); 
		
		OracleManager.imprimeStaff(368);
		OracleManager.imprimeStaffName("Bauza");
		
		OracleManager.disconnect(); 
	
	}

}



