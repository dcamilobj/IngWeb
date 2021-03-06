/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.DAO.DataSource;
import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author dcamilo.bedoya
 *
 */
public class UsuarioDAOImp implements UsuarioDAO {
	
	public Usuario obtener(String login) throws MyException
	{
		Usuario usuario= new Usuario();
		Session session = null;
		try{
			session = DataSource.getInstance().getSession();
	
			usuario = (Usuario) session.get(Usuario.class,login);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando ciudades", e);
		}
		return usuario;
	}
}
