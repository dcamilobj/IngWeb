package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author dcamilo.bedoya
 *@description Entrega conexiones activas de la BD 
 */
public class DataSource {

	
	//Función estatica que crea un objeto de tipo "Connection"
	//El throws es indicarle al método que maneje dicha excepción
	//El throw es para lanzar hacia arriba la excepción
	public static Connection getConnection() throws MyException
	{
		Connection con=null;   //Creamos la conexión con la BD
		try
		{
			//Se valida que el driver esté cargado y se establece la conexión
			Class.forName("com.mysql.jdbc.Driver"); 
		    con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/camiloClase","root","root");
		}
		catch(ClassNotFoundException e)
		{
			throw new MyException("Driver no encontrado",e);
		}
		catch(SQLException e)
		{
			throw new MyException("No se puede establecer conexión",e);
		}
		
		return con;
	}
}
