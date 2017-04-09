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
 * @author estudiantelis
 *
 */
public class CiudadDAOImp implements CiudadDAO{

	/**
	* @return Lista de ciudades
	* Implementación del método obtener
	*/
	
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

	@Override
	public List<Ciudad> obtener() throws MyException {
		
		List<Ciudad> ciudades = new ArrayList<>();
		Session session = null;
		
	try {
		//session = DataSource.getInstance().getSession();
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

	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		
		Ciudad ciudad= new Ciudad();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			/*Podemos usar  lo siguiente para traer la ciudad, pero no es la mejor manera
			Criteria criteria = session.createCriteria(Ciudad.class);
			criteria.add(Restrictions.eq("codigo", codigo));
			ciudad = (Ciudad)criteria.uniqueResult(); */
			//Unique result porque estoy seguro que la consulta me va entregar un solo valor
			//session.get(Ciudad.class,codigo);
			//Método load -> si no encuentra lso datos retorna excepcion 
			//Método get -> si no encuentra los datos retorna nulo
			ciudad = (Ciudad) session.get(Ciudad.class,codigo);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando ciudades", e);
		}
		return ciudad;
	}
	
	/**
	 * 
	 * @param ciudad
	 * @throws MyException
	 * Guarda una ciudad en la base de datos 
	 */
	@Override
	public void guardar(Ciudad ciudad) throws MyException
	{
		Session session = null;
		try
		{
			//session = DataSource.getInstance().getSession();
			session = sessionFactory.getCurrentSession();
			session.save(ciudad);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando ciudades", e);
		}
		
	}
}
