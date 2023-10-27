package conexionBDMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	
	private static void mySQLConnection() {
		
	}
	
	public static Connection newInstance(String url, String username, String password) {
		
		try {
			Class.forName(driver);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.err.println("No se ha podido encontrar el Driver: "+driver);
		}
		
		Connection connection = null;
		
		try {
		 connection = DriverManager.getConnection(url,username,password);
		}catch (SQLException ex) {
			// TODO: handle exception
			System.err.println("No se ha podido establecer conexion con el servidor.");
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
		return connection;
		
	}
	
}
