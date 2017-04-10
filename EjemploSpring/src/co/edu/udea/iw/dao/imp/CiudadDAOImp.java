/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.DAO.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta clase implementa los métodos definidos en la interfaz "CiudadDAO"
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public class CiudadDAOImp implements CiudadDAO{


	private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * @return La lista de ciudades que se encuentran en la base de datos.
	 * @throws MyException
	 */
	@Override
	public List<Ciudad> obtener() throws MyException {
		
		List<Ciudad> ciudades = new ArrayList<>();
		Session session = null;
		
	try {
		session = sessionFactory.getCurrentSession();
		//Usamos criteria cuando hay una condición en la bd 
		Criteria criteria = session.createCriteria(Ciudad.class);
		ciudades = criteria.list();
	} 
	catch (HibernateException e) {
		throw new MyException("Error consultando ciudades", e);
		}
	
	return ciudades;
	}

	/**
	 * @param código de la ciudad que se desea obtener
	 * @return una ciudad en base al código pasado por parametro 
	 * @throws MyException
	 */
	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		
		Ciudad ciudad= new Ciudad();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			ciudad = (Ciudad) session.get(Ciudad.class,codigo);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando ciudades", e);
		}
		return ciudad;
	}
	
	/**
	 * Implementación de método para guardar una ciudad en la base de datos.
	 * @param ciudad que se desea guardar
	 * @throws MyException
	 */
	@Override
	public void guardar(Ciudad ciudad) throws MyException
	{
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.save(ciudad);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando ciudades", e);
		}
		
	}
}
