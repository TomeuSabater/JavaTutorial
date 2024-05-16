package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleManager {
	
    // Conexión a la base de datos
    private static Connection conn = null;
    
    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "1521";
    private static final String DB_NAME = "freepdb1";
    private static final String DB_URL = "jdbc:oracle:thin:@" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    private static final String DB_USER = "TOMEU";
    private static final String DB_PASS = "TOMEU2024";
    
    private static final String DB_MSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MSQ_CONN_NO = "ERROR EN LA CONEXIÓN";
    private static final String DB_STM_EX_NO = "ERROR EN EJECUCIÓN SENTENCIA";
    
    
    // Configuración de la tabla Staff
    private static final String TB_STAFF = "Staff";
    private static final String TB_STAFF_COLUMNS = "EMPLOYEE_CODE, NAME, JOB, SALARY, DEPARTMENT_CODE, START_DATE, SUPERIOR_OFFICER";   
    private static final String TB_STAFF_SELECT = "SELECT " + TB_STAFF_COLUMNS + " FROM " + TB_STAFF;
    private static final String TB_STAFF_CODE = "Employee_Code";
    private static final String TB_STAFF_NAME = "Name";
    private static final String TB_STAFF_JOB = "Job";
    private static final String TB_STAFF_SALARY = "Salary";
    private static final String TB_STAFF_DEPTO = "Department_Code";
    private static final String TB_STAFF_START = "Start_Date";
    private static final String TB_STAF_SUPOFF = "Superior_Officer";
  
    
    
    ////////////////////////////////////////////////////////////////////////////////////////
    // Métodos de conexión a la DDBB
    /////////////////////////////////////////////////////////////////////////////////////////
    
    // Carga del driver
    public static boolean loadDriver() {

    	try {
    		System.out.print("Cargando driver...");
    		Class.forName("oracle.jdbc.OracleDriver"); 
    		 System.out.println("Ok!");
    		return true; 
    	} catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		return false; 
    	}
    }
    
    //Conexión a la DDBB
    public static boolean connect() {
    	
    	try {
    		System.out.print("Conectando a la base de datos...");
    		System.out.println(DB_URL); 
    		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println(DB_MSQ_CONN_OK);
    		return true; 
    	} catch (SQLException ex) {
            System.out.println(DB_MSQ_CONN_NO);
    		ex.printStackTrace();
    		return false; 
    	}
    }
    
    // Comprueba el estado de la conexión
    public static boolean isConnected() {
		System.out.print("Comprobando conexión a la base de datos...");
    	try {
    		if (conn != null && conn.isValid(0)) {
                System.out.println(DB_MSQ_CONN_OK);
                return true;    			
    		} else {
    			return false; 
    		}
    	} catch (SQLException ex) {
            System.out.println(DB_MSQ_CONN_NO);
    		ex.printStackTrace();
    		return false; 
    	}
    }
    
    // Desconecta de la DDBB 
    public static boolean disconnect() {
    	try {
    		System.out.print("Desconectando de la base de datos...");
    		conn.close(); 
    		System.out.println("Ok!"); 
    		return true; 
    	} catch(SQLException ex) {
   		 	ex.printStackTrace();
    		return false; 
    	}
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////
    // Métodos particulares de tablas 
    /////////////////////////////////////////////////////////////////////////////////////////
    
    /* Solicita a la BD el Staff con id indicado
     * @param id id del Staff
     * @return ResultSet con el resultado de la consulta, null en caso de error
     */
    
    public static ResultSet getCliente(int id) {
    	
		// creamos la consulta sql
		String query = TB_STAFF_SELECT + " WHERE " + TB_STAFF_CODE + "=(?)";
		PreparedStatement stmt;
    	try {
    		stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
    		//Pasamos por parámetro el ID de empleado.
	    	stmt.setInt(1, id);
	    	ResultSet rs = stmt.executeQuery();
    		 
    		 //Si no hay primer resultado, entonces no hay cliente
             if (!rs.first()) {
                 return null;
             } else {
            	 return rs; 
             }
    	} catch (SQLException ex) {
    		System.out.println(DB_STM_EX_NO);
    		ex.printStackTrace();
    		return null; 
    	}
    }
    
 
    /**
     * Imprime los datos del Staff con id indicado
     *
     * @param id id del Staff
     */
    public static void imprimeStaff(int id) {
    	
    	try {
    		
    		// Obtenemos el Staff
    		ResultSet rs = getCliente(id);
    		
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
    

}

