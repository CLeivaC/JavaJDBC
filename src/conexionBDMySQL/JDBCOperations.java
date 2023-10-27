package conexionBDMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCOperations {

	private JDBCOperations() {
		
	}
	
	private static Statement crearSentencia(Connection connection) {
		
		try {
			return connection.createStatement();
		}catch (SQLException ex) {
			// TODO: handle exception
			System.err.println("No se ha podido crear la sentencia");
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
		
		return null;
	}
	
	public static void crearTabla(Connection con,String query) {
		Statement sentencia = crearSentencia(con);
		
		try {
			sentencia.execute(query);
		}catch (SQLException ex) {
			// TODO: handle exception
			System.err.println("No se ha podido ejecutar la consulta: "+query);
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
	}
	
	
	public static ResultSet buscarDatos(Connection con, String query) {
		
		Statement sentencia = crearSentencia(con);
		try {
		
			sentencia.executeQuery(query);
		}catch (SQLException ex) {
			// TODO: handle exception
			System.err.println("No se han podido recuperar los datos.");
			System.err.println(ex.getMessage());
			return null;
		}
		
		try {
			ResultSet resultSet = sentencia.getResultSet();
			return resultSet;
		
		}catch (SQLException ex) {
			// TODO: handle exception
			System.err.println("No se han podido recuperar los datos.");
			System.err.println(ex.getMessage());
			return null;
		}
		
	}
}
