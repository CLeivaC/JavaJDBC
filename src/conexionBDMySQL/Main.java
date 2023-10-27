package conexionBDMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost/m06";
		String username = "root";
		String password = "admin";
		
		System.out.println("Iniciando conexion con el servidor");
		Connection connection = MySQLConnection.newInstance(url,username,password);
		
		
		
		String crearTablaPersona = "create table if not exists Persona(id INTEGER PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(30) NOT NULL, telefono INTEGER(9) NOT NULL)";
		
		String crearTablaDirecciones = "create table if not exists Direcciones(ID INTEGER PRIMARY KEY AUTO_INCREMENT, persona_id INTEGER NOT NULL, direccion VARCHAR(50) NOT NULL, FOREIGN KEY (persona_id) REFERENCES PERSONA(id))";
		
		JDBCOperations.crearTabla(connection,crearTablaPersona);
		JDBCOperations.crearTabla(connection,crearTablaDirecciones);
		
		
		String buscarPersona = "select * from Persona where id=1";
		
		 ResultSet resultSet =  JDBCOperations.buscarDatos(connection, buscarPersona);
		 
		 if(resultSet!=null) {
		 
			 try {
				 while(!resultSet.isLast()) {
					 resultSet.next();
					 System.out.println(resultSet.getString("nombre"));
				 }
			 }catch (SQLException ex) {
				 // TODO: handle exception
				 System.err.println("Error al leer los datos recuperados.");
				 System.err.println(ex.getMessage());
			 }
		 
		 }
		
		try {
			connection.close();
		}catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Error al cerrar la conexion");
			e.getMessage();
		}
		
		System.out.println("Finalizando conexion con el servidor");
		
	}

}
