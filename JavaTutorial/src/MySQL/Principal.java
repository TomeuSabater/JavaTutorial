package MySQL;

public class Principal {

	public static void main(String[] args) {
	
		MySQLManager.loadDriver(); 
		MySQLManager.connect(); 
		MySQLManager.isConnected(); 
		
		StaffManager staff = new StaffManager(); 
		staff.getStaffId(222); // from CRUD
		staff.newStaff((short)123, "Tomeu", "Profesor", 2000, (short)5, "2024-04-19", (short)333); // from CRUD
		
		
		// 	public void newStaff(short Employee_Code, String Name, String Job, int Salary, 
		// short Department_Code, String Start_Date, short Superior_Officer) {
		/*
		staff.imprimeStaff(222);
		MySQLManager.imprimeStaff(222);
		MySQLManager.getClienteProc(222);
		MySQLManager.readClient(221); // from CRUD
	
		*/
		MySQLManager.disconnect(); 


	}

}
