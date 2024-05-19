package MySQL;

import java.sql.CallableStatement;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffManager {
	
   
    // Configuración de la tabla t5_employees.Staff
    private final String TB_STAFF = "Staff";
    private final String TB_STAFF_SELECT = "SELECT * FROM " + TB_STAFF;
    private final String TB_STAFF_CODE = "Employee_Code";
    private final String TB_STAFF_NAME = "Employee_Name";
    private final String TB_STAFF_JOB = "Employee_Job";
    private final String TB_STAFF_SALARY = "Employee_Salary";
    private final String TB_STAFF_DEPTO = "Department_Code";
    private final String TB_STAFF_START = "Start_Date";
    private final String TB_STAF_SUPOFF = "Superior_Officer";
    
    
	////////////////////////////////////////////////////////////////////////////////////////
	// Métodos particulares de tablas 
	/////////////////////////////////////////////////////////////////////////////////////////


	/* Solicita a la BD el Staff con id indicado
	* @param id id del Staff
	* @return ResultSet con el resultado de la consulta, null en caso de error
	*/


	private ResultSet getStaff(int id) {
	
		try {
			// creamos la consulta sql
			Statement stmt = MySQLManager.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = TB_STAFF_SELECT + " WHERE " + TB_STAFF_CODE + "='" + id + "';";
			System.out.println(sql); //Mostramos query a ejecutar
			ResultSet rs = stmt.executeQuery(sql);
	
			//Si no hay primer resultado, entonces no hay empleado
			if (!rs.first()) {
				return null;
			} else {
				return rs; 
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null; 
		}
	}

	/**
	* Imprime los datos del Staff con id indicado
	*
	* @param id id del Staff
	*/

	public void imprimeStaff(int id) {
	
		try {
	
			// Obtenemos el Staff
			ResultSet rs = this.getStaff(id);
	
			if (rs == null || !rs.first()) {
				System.out.println("Staff " + id + " NO EXISTE");
				return;
			}
	
			//Imprimimos su información por pantalla
			int sid = rs.getInt(TB_STAFF_CODE);
			String nombre = rs.getString(TB_STAFF_NAME);
			String job = rs.getString(TB_STAFF_JOB); 
			int salary = rs.getInt(TB_STAFF_SALARY); 
			int depto = rs.getInt(TB_STAFF_DEPTO); 
			String start = rs.getString(TB_STAFF_START); 
			int jefe = rs.getInt(TB_STAF_SUPOFF); 
	
			System.out.println("Staff :" + sid + "\t" + nombre + "\t" + job + "\t" + salary + "\t" + depto + "\t" + start + "\t" + jefe);
	
			} catch(SQLException ex) {
	
				System.out.println("Error al solicitar Staff " + id);
				ex.printStackTrace();
			}
	}

	/**
	* Obtiene los datos del Staff con el id indicado
	*
	* @param id id del Staff
	* @return ResultSet con el resultado de la consulta, null en caso de error
	*/

	// Lo que quiero es llamar a un proc almacenado que me devuelve los datos
	// de una tupla de un Staff específico que pasamos por parámetro

	public void getStaffProc(int id) {
	
	//Llama a un proc almacenado

	try {
		// Creamos la sentencia SQL de llamada al proc almacenado
		//String sql = "call get_staff(" + id + ",employee_name, @employee_job, @salary, @deparment_code, @start_date, @superior_officer)";
	
		//1.- Preparamos el callable statement
		//CallableStatement cStmt = conn.prepareCall("{call demoSp(?, ?)}");
		String sql_string = "call get_staff(?,?,?,?,?,?,?)";
		CallableStatement cStmt = MySQLManager.conn.prepareCall(sql_string ); 

		//2.- Registramos los parámetros de salida (si existen)
		//parameters specified as OUT or INOUT when you created the stored procedure
		// cStmt.registerOutParameter("inOutParam", Types.INTEGER); // name-based
		// cStmt.registerOutParameter(2, Types.INTEGER); // index-based
		cStmt.registerOutParameter(2, JDBCType.VARCHAR);
		cStmt.registerOutParameter(3, JDBCType.VARCHAR);
		cStmt.registerOutParameter(4, JDBCType.DECIMAL);
		cStmt.registerOutParameter(5, JDBCType.SMALLINT);
		cStmt.registerOutParameter(6, JDBCType.DATE);
		cStmt.registerOutParameter(7, JDBCType.SMALLINT);

		//3.-Especificamos los parámetros de entrada (si existen)
		//Input and in/out parameters are set as for PreparedStatement objects.
		//  cStmt.setString(1, "abcdefg"); // index based
		// 	cStmt.setString("inputParam", "abcdefg"); // name based
		cStmt.setInt(1, id); 


		//4.- Ejecutamos CallableStatement, recibimos cualquier conjunto de resultados o parámetros de salida
		cStmt.execute();    
		// ResultSet rs = cStmt.getResultSet();  

		//5.- Extramos el resultado de los in/out y out
		// int outputValue = cStmt.getInt(2); // index-based
		// int outputValue = cStmt.getInt("inOutParam"); // name-based
		String nombre = cStmt.getString("employee_name");
		String job = cStmt.getString("employee_job"); 
		int salary = cStmt.getInt("salary"); 
		int depto = cStmt.getInt("department_code"); 
		String start = cStmt.getString("start_date"); 
		int jefe = cStmt.getInt("superior_officer"); 

		System.out.println("Staff :" + id + "\t" + nombre + "\t" + job + "\t" + salary + "\t" + depto + "\t" + start + "\t" + jefe);
	
		} catch(SQLException ex) {
	
			System.out.println("Error al solicitar Staff " + id);
			ex.printStackTrace();
		}
	}

	// Llamadas al CRUD.sql 
	
	public void get_StaffId(short Employee_Code) {
	
	//Llama al almacenado de MySQL
	/*	read_staff_java(
			1 inout employee_code smallint unsigned, 
			2 out employee_name varchar(25),
			3 out employee_job varchar(25),
			4 out employee_salary decimal(7,2),
			5 out department_code smallint unsigned,
			6 out start_date date,
			7 out superior_officer smallint unsigned,
			8 out status smallint unsigned,
			9 out error_message varchar(255)
		)		
		
		comment 'Obtiene un Staff específico de t5_employees.staff
    	Status = 0 --> error_message = "Info: Staff econtrado, se devuelve su info"
		Status = 1 --> error_message = "Error: Staff no econtrado"
    	Status = 2 --> error_message = "Error: Falta algún dato obligatorio, no se aporta employee_code"'
	*/ 

	try {

		//1.- Preparamos el callable statement
		String sql_string = "call read_staff_java(?,?,?,?,?,?,?,?,?)";
		CallableStatement cStmt = MySQLManager.conn.prepareCall(sql_string ); 

		//2.- Registramos los parámetros de salida OUT / INOUT 
		cStmt.registerOutParameter(1, JDBCType.SMALLINT); // 1 inout employee_code smallint unsigned
		cStmt.registerOutParameter(2, JDBCType.VARCHAR); // 2 out employee_name varchar(25)
		cStmt.registerOutParameter(3, JDBCType.VARCHAR); // 3 out employee_job varchar(25)
		cStmt.registerOutParameter(4, JDBCType.DECIMAL); // 4 out employee_salary decimal(7,2),
		cStmt.registerOutParameter(5, JDBCType.SMALLINT); // 5 out department_code smallint unsigned
		cStmt.registerOutParameter(6, JDBCType.DATE); // 6 out start_date date
		cStmt.registerOutParameter(7, JDBCType.SMALLINT); // 7 out superior_officer smallint unsigned
		cStmt.registerOutParameter(8, JDBCType.SMALLINT); // 8 out status smallint unsigned
		cStmt.registerOutParameter(9, JDBCType.VARCHAR); // 9 out error_message varchar(255)

		//3.-Especificamos los parámetros de entrada (si existen)
		if (Employee_Code != 0) {
			cStmt.setInt(1, Employee_Code);
		} else {
			cStmt.setNull(1, Employee_Code);
		}

		//4.- Ejecutamos CallableStatement, recibimos cualquier conjunto de resultados o parámetros de salida
		cStmt.execute();   

		//5.- Extramos el resultado de los in/out y out
		short id = cStmt.getShort(1); // 1 inout employee_code smallint unsigned
		String nombre = cStmt.getString(2); // 2 out employee_name varchar(25)
		String job = cStmt.getString(3); // 3 out employee_job varchar(25)
		int salary = cStmt.getInt(4); // 4 out employee_salary decimal(7,2)
		int depto = cStmt.getInt(5); // 5 out department_code smallint unsigned
		String start = cStmt.getString(6); // 6 out start_date date
		int jefe = cStmt.getInt(7); // 7 out superior_officer smallint unsigned
		int status = cStmt.getInt(8); // 8 out status smallint unsigned
		String message = cStmt.getString(9); // 9 out error_message varchar(255)

		//6.- Mostramos el resultado 
		System.out.println("Status: " + status + " Message :" + message); 
		System.out.println("Staff :" + id + "\t" + nombre + "\t" + job + "\t" + salary + "\t" + depto + "\t" + start + "\t" + jefe);

		} catch (SQLException ex) {
			System.out.println("Error al solicitar Staff " + Employee_Code);
			ex.printStackTrace();	
		}
	}


	public void new_Staff(short Employee_Code, String Name, String Job, int Salary, 
	short Department_Code, String Start_Date, short Superior_Officer) {
	
		/* create_staff_java(inout employee_code smallint unsigned, 
				inout employee_name varchar(25),
				inout employee_job varchar(25),
				inout employee_salary decimal(7,2),
				inout department_code smallint unsigned,
				inout start_date date,
				inout superior_officer smallint unsigned,
				out status smallint unsigned,
				out error_message varchar(255)
			)
			
		comment 'Inserta tupla en t5_employees.staff
		Hay handler sobre datos obligatorios, integridad referencial e inserción duplicada
		If Salary is null : Salary = Avg(Salary) (trigger)
		If Salary > Max(Salary) : Salary = Max(Salary) (trigger)
		If Salary < Min(Salary) : Salary = Min(Salary) (trigger) 
		If Start_Date is null : Start_Date = current_date()
		If Supperior_Officer is null : Supperior_Officer = Employee_Code (trigger)
    	Status = 0 --> error_message = "Info: Se ha insertado la tupla"
    	Status = 1 --> error_message = "Error: Inserción duplicada, el empleado ya existe"
    	Status = 2 --> error_message = "Error: Falta algún dato obligatorio"
    	Status = 3 --> error_message = "Error: Superior_Officer / Department_Code no es válido"' 
			
		*/ 

		try {
			
			//1.- Preparamos el callable statement
			String sql_string = "call create_staff_java(?,?,?,?,?,?,?,?,?)";
			CallableStatement cStmt = MySQLManager.conn.prepareCall(sql_string ); 
			
			//2.- Registramos los parámetros de salida OUT / INOUT 
			cStmt.registerOutParameter(1, JDBCType.SMALLINT); // 1 inout employee_code smallint unsigned
			cStmt.registerOutParameter(2, JDBCType.VARCHAR); // 2 inout employee_name varchar(25)
			cStmt.registerOutParameter(3, JDBCType.VARCHAR); // 3 inout employee_job varchar(25)
			cStmt.registerOutParameter(4, JDBCType.DECIMAL); // 4 inout employee_salary decimal(7,2),
			cStmt.registerOutParameter(5, JDBCType.SMALLINT); // 5 inout department_code smallint unsigned
			cStmt.registerOutParameter(6, JDBCType.DATE); // 6 inout start_date date
			cStmt.registerOutParameter(7, JDBCType.SMALLINT); // 7 inout superior_officer smallint unsigned
			cStmt.registerOutParameter(8, JDBCType.SMALLINT); // 8 out status smallint unsigned
			cStmt.registerOutParameter(9, JDBCType.VARCHAR); // 9 out error_message varchar(255)
			
			//3.-Especificamos los parámetros de entrada (si existen)
			cStmt.setShort(1, Employee_Code);  
			cStmt.setString(2, Name);  
			cStmt.setString(3, Job);
			if (Salary != 0) {
				cStmt.setInt(4, Salary);
			} else {
				cStmt.setNull(4, Salary);
			}
			cStmt.setShort(5, Department_Code); 
			cStmt.setString(6, Start_Date); 
			cStmt.setShort(7, Superior_Officer);
			
			//4.- Ejecutamos CallableStatement, recibimos cualquier conjunto de resultados o parámetros de salida
			cStmt.execute();   
			
			//5.- Extramos el resultado de los in/out y out
			Employee_Code = cStmt.getShort(1); // 1 inout employee_code smallint unsigned
			Name = cStmt.getString(2); // 2 out employee_name varchar(25)
			Job = cStmt.getString(3); // 3 out employee_job varchar(25)
			Salary = cStmt.getInt(4); // 4 out employee_salary decimal(7,2)
			Department_Code = cStmt.getShort(5); // 5 out department_code smallint unsigned
			Start_Date = cStmt.getString(6); // 6 out start_date date
			Superior_Officer = cStmt.getShort(7); // 7 out superior_officer smallint unsigned
			int status = cStmt.getShort(8); // 8 out status smallint unsigned
			String message = cStmt.getString(9); // 9 out error_message varchar(255)
			
			//6.- Mostramos el resultado 
			System.out.println("Status: " + status + " Message :" + message); 
			System.out.println("Staff :" + Employee_Code + "\t" + Name + "\t" + Job + 
								"\t" + Salary + "\t" + Department_Code + "\t" + Start_Date + 
								"\t" + Superior_Officer);
			
		} catch (SQLException ex) {
			System.out.println("Error al crear Staff " + Employee_Code);
			ex.printStackTrace();	
		}
	}
	
	
	public void update_Staff(short Employee_Code, String Name, String Job, int Salary, 
	short Department_Code, String Start_Date, short Superior_Officer) {
		
	/* update_staff_java(inout employee_code smallint unsigned, 
				inout employee_name varchar(25),
				inout employee_job varchar(25),
				inout employee_salary decimal(7,2),
				inout department_code smallint unsigned,
				inout start_date date,
				inout superior_officer smallint unsigned,
				out status smallint unsigned,
				out error_message varchar(255))

		comment 'Actualiza tupla en t5_employees.staff
		Hay handler sobre datos obligatorios e integridad referencial
		If Salary is null : Salary = Avg(Salary) (trigger)
		If Salary > Max(Salary) : Salary = Max(Salary) (trigger)
		If Salary < Min(Salary) : Salary = Min(Salary) (trigger) 
		If Start_Date is null : Start_Date = current_date()
		If Supperior_Officer is null : Supperior_Officer = Employee_Code (trigger)
		Status = 0 --> error_message = "Info: Se ha modificado la tupla"
		Status = 1 --> error_message = "Error: Staff no econtrado"
		Status = 2 --> error_message = "Error: Falta algún dato obligatorio"
		Status = 3 --> error_message = "Error: Superior_Officer / Department_Code no es válido"'
	 */ 
		
		try {
			//1.- Preparamos el callable statement
			String sql_string = "call update_staff_java(?,?,?,?,?,?,?,?,?)";
			CallableStatement cStmt = MySQLManager.conn.prepareCall(sql_string); 
			
			//2.- Registramos los parámetros de salida OUT / INOUT 
			cStmt.registerOutParameter(1, JDBCType.SMALLINT); // 1 inout employee_code smallint unsigned
			cStmt.registerOutParameter(2, JDBCType.VARCHAR); // 2 inout employee_name varchar(25)
			cStmt.registerOutParameter(3, JDBCType.VARCHAR); // 3 inout employee_job varchar(25)
			cStmt.registerOutParameter(4, JDBCType.DECIMAL); // 4 inout employee_salary decimal(7,2),
			cStmt.registerOutParameter(5, JDBCType.SMALLINT); // 5 inout department_code smallint unsigned
			cStmt.registerOutParameter(6, JDBCType.DATE); // 6 inout start_date date
			cStmt.registerOutParameter(7, JDBCType.SMALLINT); // 7 inout superior_officer smallint unsigned
			cStmt.registerOutParameter(8, JDBCType.SMALLINT); // 8 out status smallint unsigned
			cStmt.registerOutParameter(9, JDBCType.VARCHAR); // 9 out error_message varchar(255)
			
			//3.-Especificamos los parámetros de entrada (si existen)
			cStmt.setShort(1, Employee_Code);  
			cStmt.setString(2, Name);  
			cStmt.setString(3, Job);
			cStmt.setInt(4, Salary); 
			cStmt.setShort(5, Department_Code); 
			cStmt.setString(6, Start_Date); 
			cStmt.setShort(7, Superior_Officer);
			
			//4.- Ejecutamos CallableStatement, recibimos cualquier conjunto de resultados o parámetros de salida
			cStmt.execute();   
			
			//5.- Extramos el resultado de los in/out y out
			Employee_Code = cStmt.getShort(1); // 1 inout employee_code smallint unsigned
			Name = cStmt.getString(2); // 2 out employee_name varchar(25)
			Job = cStmt.getString(3); // 3 out employee_job varchar(25)
			Salary = cStmt.getInt(4); // 4 out employee_salary decimal(7,2)
			Department_Code = cStmt.getShort(5); // 5 out department_code smallint unsigned
			Start_Date = cStmt.getString(6); // 6 out start_date date
			Superior_Officer = cStmt.getShort(7); // 7 out superior_officer smallint unsigned
			int status = cStmt.getShort(8); // 8 out status smallint unsigned
			String message = cStmt.getString(9); // 9 out error_message varchar(255)
			
			//6.- Mostramos el resultado 
			System.out.println("Status: " + status + " Message :" + message); 
			System.out.println("Staff :" + Employee_Code + "\t" + Name + "\t" + Job + 
								"\t" + Salary + "\t" + Department_Code + "\t" + Start_Date + 
								"\t" + Superior_Officer);
			
		} catch (SQLException ex) {
			System.out.println("Error al crear Staff " + Employee_Code);
			ex.printStackTrace();	
		}
	} // public void updateStaff
	
	
	public void del_StaffId(short Employee_Code) {
		
	//Llama al almacenado de MySQL
	/*	delete_staff_java(inout employee_code smallint unsigned, 
							out employee_name varchar(25),
							out employee_job varchar(25),
							out employee_salary decimal(7,2),
							out department_code smallint unsigned,
							out start_date date,
							out superior_officer smallint unsigned,
							out status smallint unsigned,
							out error_message varchar(255))	
							
		comment 'Elimina un Staff específico de t5_employees.staff
    	Status = 0 --> error_message = "Info: Staff eliminado, se devuelve su info"
		Status = 1 --> error_message = "Error: Staff no econtrado"
    	Status = 2 --> error_message = "Error: Falta algún dato obligatorio, no se aporta employee_code"'
	*/ 
		
		try {
			
			//1.- Preparamos el callable statement
			String sql_string = "call delete_staff_java(?,?,?,?,?,?,?,?,?)";
			CallableStatement cStmt = MySQLManager.conn.prepareCall(sql_string); 
			
			//2.- Registramos los parámetros de salida OUT / INOUT 
			cStmt.registerOutParameter(1, JDBCType.SMALLINT); // 1 inout employee_code smallint unsigned
			cStmt.registerOutParameter(2, JDBCType.VARCHAR); // 2 out employee_name varchar(25)
			cStmt.registerOutParameter(3, JDBCType.VARCHAR); // 3 out employee_job varchar(25)
			cStmt.registerOutParameter(4, JDBCType.DECIMAL); // 4 out employee_salary decimal(7,2),
			cStmt.registerOutParameter(5, JDBCType.SMALLINT); // 5 out department_code smallint unsigned
			cStmt.registerOutParameter(6, JDBCType.DATE); // 6 out start_date date
			cStmt.registerOutParameter(7, JDBCType.SMALLINT); // 7 out superior_officer smallint unsigned
			cStmt.registerOutParameter(8, JDBCType.SMALLINT); // 8 out status smallint unsigned
			cStmt.registerOutParameter(9, JDBCType.VARCHAR); // 9 out error_message varchar(255)
			
			//3.-Especificamos los parámetros de entrada (si existen)
			cStmt.setShort(1, Employee_Code);  
			
			//4.- Ejecutamos CallableStatement, recibimos cualquier conjunto de resultados o parámetros de salida
			cStmt.execute();   
			
			//5.- Extramos el resultado de los in/out y out
			Employee_Code = cStmt.getShort(1); // 1 inout employee_code smallint unsigned
			String Name = cStmt.getString(2); // 2 out employee_name varchar(25)
			String Job = cStmt.getString(3); // 3 out employee_job varchar(25)
			int Salary = cStmt.getInt(4); // 4 out employee_salary decimal(7,2)
			short Department_Code = cStmt.getShort(5); // 5 out department_code smallint unsigned
			String Start_Date = cStmt.getString(6); // 6 out start_date date
			short Superior_Officer = cStmt.getShort(7); // 7 out superior_officer smallint unsigned
			int status = cStmt.getShort(8); // 8 out status smallint unsigned
			String message = cStmt.getString(9); // 9 out error_message varchar(255)
			
			//6.- Mostramos el resultado 
			System.out.println("Status: " + status + " Message :" + message); 
			System.out.println("Staff :" + Employee_Code + "\t" + Name + "\t" + Job + 
								"\t" + Salary + "\t" + Department_Code + "\t" + Start_Date + 
								"\t" + Superior_Officer);
			
		} catch (SQLException ex) {
			System.out.println("Error al crear Staff " + Employee_Code);
			ex.printStackTrace();	
		}
	} // del_StaffId	


} // StaffManager
