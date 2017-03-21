package co.edu.udea.iw.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author dcamilo.bedoya
 * @version 1.0
 */

public class DataSource {

		//Para singleton necesito : constructor privado, variable estática, método público que me devuelva la instancia
	
	private static DataSource instancia; 
	private SessionFactory factory = null; //Crear las sesiones
	private Configuration conf = new Configuration(); //Archivo de configuracion de hibernate 
	
	private DataSource()
	{
		
	}
	
	
	public static  DataSource getInstance()
	{
		
		if(instancia==null)
		{
				instancia = new DataSource();
		}
		
		return instancia;
	}
	
	/**
	 * 
	 * @return Método que entrega sesiones activas en la base de datos
	 * @throws MyException
	 */
	public Session getSession() throws MyException
	{
		try
		{
			if(factory == null)
			{
				conf.configure("co/edu/udea/iw/configuracion/hibernate.cfg.xml");
				factory = conf.buildSessionFactory();
			}
			//Retorna una sesion abierta a la base de datos
			return factory.openSession() ;
		}
		catch(HibernateException e)
		{
			throw new MyException("Error configurando la sesión", e);
			
		}
		
	}
	
}
