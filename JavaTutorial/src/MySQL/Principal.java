package MySQL;

public class Principal {

	public static void main(String[] args) {
	
		MySQLManager.loadDriver(); 
		MySQLManager.connect(); 
		MySQLManager.isConnected(); 
		
		StaffManager staff = new StaffManager(); 
				
		// Create New Staff
		staff.new_Staff((short)123, "Tomeu", "Profesor", 2000, (short)5, "2024-04-19", (short)368); // from CRUD
		
		// Get Staff
		staff.get_StaffId((short)123); // from CRUD
		
		// Udpate Staff
		staff.update_Staff((short)123, "Tomeu", "Profesor", 2000, (short)5, "2024-04-19", (short)414); // from CRUD
		
		// Delete Staff
		staff.del_StaffId((short)123);
		staff.get_StaffId((short)123);

	
		/* Código antiguo de ejemplo
		staff.imprimeStaff(222);
		MySQLManager.imprimeStaff(222);
		MySQLManager.getClienteProc(222);
		*/
		
		MySQLManager.disconnect(); 

	}

}
