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

import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta clase implementa los métodos definidos en la interfaz "UsuarioDAO"
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public class UsuarioDAOImp implements UsuarioDAO {
	
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
	 * @return La lista de usuarios que se encuentran en la base de datos.
	 * @throws MyException
	 */
	@Override
	public List<Usuario> obtener() throws MyException {

			
			List<Usuario> usuarios= new ArrayList<>();
			Session session = null;
			
		try {
			session = sessionFactory.getCurrentSession();
			//Usamos criteria cuando hay una condición en la bd 
			Criteria criteria = session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		} 
		catch (HibernateException e) {
			throw new MyException("Error consultando usuarios", e);
			}
		
		return usuarios;
		}

	/**
	 * 
	 * @param Nombre de usuario 
	 * @return El usuario actual en el sistema dado su nombre de usuario. 
	 * @throws MyException
	 */
	public Usuario obtener(String login) throws MyException
	{
		Usuario usuario= new Usuario();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();	
			usuario = (Usuario) session.get(Usuario.class,login);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando usuario", e);
		}
		return usuario;
	}



}
