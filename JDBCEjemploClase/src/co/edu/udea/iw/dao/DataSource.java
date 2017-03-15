package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author dcamilo.bedoya
 * @version 1.0
 *@description Entrega conexiones activas de la BD 
 */
public class DataSource {

	private static Connection connection; // //Creamos la conexión con la BD (singleton)
	
	//El throws es indicarle al método que maneje dicha excepción
	//El throw es para lanzar hacia arriba la excepción
	public static Connection getConnection() throws MyException
	{
		try
		{ 
			if(connection == null || connection.isClosed())
			{
				//Se valida que el driver esté cargado y se establece la conexión
				Class.forName("com.mysql.jdbc.Driver"); 
			    connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/camiloClase","root","root");
			}
		}
		catch(ClassNotFoundException e)
		{
			throw new MyException("Driver no encontrado",e);
		}
		catch(SQLException e)
		{
			throw new MyException("No se puede establecer conexión",e);
		}
		
		return connection;
	}
}
